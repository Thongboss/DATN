package com.service.impl;

import com.Utils.SecurityUtils;
import com.config.jwt.*;
import com.entities.Authority;
import com.entities.User;
import com.entities.models.UserModel;
import com.entities.models.UserRegisterModel;
import com.repository.AuthorityRepository;
import com.service.CustomUserDetail;
import com.service.IMailService;
import com.service.IUserService;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;
    private final String resetPasswordHost;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;
    private final IMailService mailService;

    public UserServiceImpl(UserRepository userRepository,
                           AuthorityRepository authorityRepository,
                           PasswordEncoder passwordEncoder, @Value("${host.frontend.account.resetPassword}") String resetPasswordHost,
                           JwtProvider jwtProvider, AuthenticationManager authenticationManager,
                           IMailService mailService) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.resetPasswordHost = resetPasswordHost;
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
        this.mailService = mailService;
    }

    public User modelToEntity(UserModel userModel) {
        if (userModel == null) throw new RuntimeException("UserModel is null");
        return User.builder()
                .id(userModel.getId())
                .username(userModel.getUsername())
                .fullname(userModel.getFullname())
                .email(userModel.getEmail())
                .createdDate(Calendar.getInstance().getTime())
                .status(userModel.getStatus())
                .avatar(userModel.getAvatar())
                .description(userModel.getDescription())
                .loginFailed(userModel.getLoginFailed())
                .build();

    }

    @Transactional
    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    @Override
    public Page<User> findAll(Pageable page) {
        return this.userRepository.findAll(page);
    }

    @Override
    public Page<User> findAll(Pageable page, Specification<User> specifications) {
        return this.userRepository.findAll(specifications, page);
    }

    @Transactional
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Page<User> findAll(Specification specs, Pageable page) {
        return this.userRepository.findAll(specs, page);
    }

    @Override
    public List<User> findAll(Specification specs) {
        return null;
    }

    @Override
    public Page<User> search(String q, Pageable page) {
        return this.userRepository.findAllByUsernameOrEmailLike("%".concat(q).concat("%"), "%".concat(q).concat("%"), page);
    }

    @Transactional
    @Override
    public User add(UserModel model) {
        User user = modelToEntity(model); // convert lai tu model sang entity
        user.setPassword(passwordEncoder.encode(model.getPassword()));
        user.setCreatedDate(Calendar.getInstance().getTime());
        setAuthority(user, model.getAuthority());

        return this.userRepository.save(user);
    }

    void setAuthority(User user, List<Integer> authorities) {
        user.setAuthorityFilter(this.authorityRepository.findAllByIdIn(authorities));
        if (user.getAuthorityFilter().isEmpty())
            user.setAuthorityFilter(Collections
                    .singleton(this.authorityRepository.findByAuthorityName(SecurityUtils.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("User role not found"))));
        System.out.println("user auths: " + user.getAuthorityFilter().size());
    }

    @Transactional
    @Override
    public User update(UserModel model) {
        User original = this.findById(model.getId());
        User user = modelToEntity(model); // convert lai tu model sang entity
        if (model.getPassword() != null)
            user.setPassword(passwordEncoder.encode(model.getPassword()));
        else user.setPassword(original.getPassword());
        setAuthority(user, model.getAuthority());
        return this.userRepository.save(original);
    }

    @Transactional
    @Override
    public boolean deleteById(Long id) {
        this.userRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteByIds(List<Long> id) {
        return false;
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findFirstByUsernameOrEmail(username, username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    @Override
    public User registerAccount(UserRegisterModel userRegisterModel) {
        User user = User.builder()
                .username(userRegisterModel.getUsername())
                .email(userRegisterModel.getEmail())
                .password(passwordEncoder.encode(userRegisterModel.getPassword()))
                .fullname(userRegisterModel.getFullname())
                .status(false)
                .authorityFilter(Collections.emptySet())
                .build();
        return this.userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean forgotPassword(String username) {
//        User original = this.findByUsername(username);
//        original.setUserActivationKey(Math.round(100000 + Math.random() * 999999));
//        this.userRepository.save(original);
//        String resetToken = jwtProvider.generateToken(username.concat("-").concat(original.getUserActivationKey().toString()), JwtProvider.JWT_TOKEN_VALIDITY / 2);
//        new Thread(() -> {
//            try {
//                Map<String, Object> model = new HashMap<>();
//                model.put("username", original.getUserLogin());
//                model.put("resetUrl", this.resetPasswordHost.concat(resetToken));
//                this.mailService.sendMail("reset_password.html", original.getUserEmail(), "Reset Password", model);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//        }).start();
        return true;
    }

    @Transactional
    @Override
    public boolean resetPassword(String resetToken, String newPassword) {
//        jwtProvider.isTokenExpired(resetToken);
//        String[] subject = jwtProvider.getUsernameFromToken(resetToken).split("-");
//        if (subject.length < 2) throw new RuntimeException("Invalid reset token");
//        User original = this.findByUsername(subject[0]);
//        original.setPassword(passwordEncoder.encode(newPassword));
//        this.userRepository.save(original);
        return true;
    }

    @Override
    public boolean tokenFilter(String token, HttpServletRequest req) {
        String username = this.jwtProvider.getUsernameFromToken(token);
        System.out.println("username: " + username);
        CustomUserDetail userDetail = new CustomUserDetail(this.findByUsername(username));
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return true;
    }

    @Override
    public JwtLoginResponse login(JwtUserLoginModel userLogin) {
        System.out.println("login service");
        UserDetails userDetail = new CustomUserDetail(this.findByUsername(userLogin.getUsername()));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDetail, userLogin.getPassword(), userDetail.getAuthorities()));
        return JwtLoginResponse.builder()
                .token(jwtProvider.generateToken(userLogin.getUsername(), userLogin.isRemember() ? 86400 * 7 : 0l))
                .authorities(userDetail.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .type("Bearer")
                .build();
    }

    @Override
    public User getMyProfile() {
        return this.findById(SecurityUtils.getCurrentUserId());
    }

}
