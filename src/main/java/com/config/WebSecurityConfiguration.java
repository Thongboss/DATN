package com.config;

import com.config.jwt.JwtAuthenticationProvider;
import com.config.jwt.JwtFilter;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Các URL có thể tự do truy cập //Public URLs that don't need to be authorized
    private final RequestMatcher PUBLIC_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/productsDetails/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/categories/**", HttpMethod.GET.name()),
            new AntPathRequestMatcher("/users/login"),
            new AntPathRequestMatcher("/swagger-resources/**"),
            new AntPathRequestMatcher("/swagger-ui/**"),
            new AntPathRequestMatcher("/v2/api-docs"),
            new AntPathRequestMatcher("/webjars/**")
    );
    //Các địa chỉ ip cần cấp phép là các URL còn lại//Private URLs are the others
    private RequestMatcher PRIVATE_URLS = new NegatedRequestMatcher(PUBLIC_URLS);

    @Autowired
    @Lazy
    private IUserService userService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().requestMatchers(PUBLIC_URLS);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new JwtAuthenticationProvider().userService(this.userService));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().disable();

        http.authorizeRequests()
                .requestMatchers(PRIVATE_URLS).authenticated()
                .and().exceptionHandling().accessDeniedHandler((req, res, auth) -> {
                    res.sendError(401, "You must have to login");
                });
        http.addFilterBefore(new JwtFilter(userService), org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);
    }
}
