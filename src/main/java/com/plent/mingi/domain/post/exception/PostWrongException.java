package com.plent.mingi.domain.post.exception;

import com.plent.mingi.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class PostWrongException extends BusinessException {

    public static final PostWrongException EXCEPTION = new PostWrongException();

    private PostWrongException() {
        super(HttpStatus.BAD_REQUEST, "접근 권한이 없는 게시글입니다");
    }
}
