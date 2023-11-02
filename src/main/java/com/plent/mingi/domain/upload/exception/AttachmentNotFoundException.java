package com.plent.mingi.domain.upload.exception;

import com.plent.mingi.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class AttachmentNotFoundException extends BusinessException {

    public static final AttachmentNotFoundException EXCEPTION = new AttachmentNotFoundException();

    private AttachmentNotFoundException() {
        super(HttpStatus.NOT_FOUND, "첨부파일을 찾지 못하였습니다");
    }
}
