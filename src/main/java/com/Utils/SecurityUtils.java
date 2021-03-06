package com.Utils;

import com.service.CustomUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static String ROLE_ADMIN = "ROLE_ADMIN";
    public static String ROLE_USER = "ROLE_USER";

    // Lấy id người dùng hiện tại // Get current user id
    public static Long getCurrentUserId() {
        return getCurrentUser().getUser().getId();
    }

    public static CustomUserDetail getCurrentUser() {
        return (CustomUserDetail) getCurrentAuthentication().getPrincipal();
    }

    private static Authentication getCurrentAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static boolean isAuthenticated() {
        return getCurrentAuthentication().isAuthenticated();
    }

    // kiểm tra chức vụ người dùng hiện tại có không // Get current user role
    public static boolean hasRole(String role) {
        return getCurrentAuthentication().getAuthorities().stream().anyMatch(r -> r.getAuthority().equals(role));
    }

}