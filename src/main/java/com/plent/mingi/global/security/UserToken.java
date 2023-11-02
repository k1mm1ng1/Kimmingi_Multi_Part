package com.plent.mingi.global.security;

import com.plent.mingi.domain.auth.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserToken extends UsernamePasswordAuthenticationToken {
    public UserToken(User user) {
        super(user, null, null);
    }
}
