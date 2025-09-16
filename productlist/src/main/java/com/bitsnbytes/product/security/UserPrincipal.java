package com.bitsnbytes.product.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public class UserPrincipal implements UserDetails {
    private SecurityProperties.User user;

    public UserPrincipal(User user){
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
