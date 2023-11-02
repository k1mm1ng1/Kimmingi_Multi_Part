package com.plent.mingi.domain.post.exception;

import com.plent.mingi.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends BusinessException {

    public static final PostNotFoundException EXCEPTION = new PostNotFoundException();

    private PostNotFoundException() {
        super(HttpStatus.NOT_FOUND, "게시글을 찾을 수 없습니다");
    }
}
