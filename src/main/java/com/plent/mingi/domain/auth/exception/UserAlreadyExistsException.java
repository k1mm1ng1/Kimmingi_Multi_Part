package com.plent.mingi.domain.auth.exception;

import com.plent.mingi.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends BusinessException {

    public static final UserAlreadyExistsException EXCEPTION = new UserAlreadyExistsException();

    private UserAlreadyExistsException() {
        super(HttpStatus.CONFLICT, "이미 존재하는 회원입니다");
    }
}
