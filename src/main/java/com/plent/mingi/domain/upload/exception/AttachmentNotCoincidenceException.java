package com.plent.mingi.domain.upload.exception;

import com.plent.mingi.global.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class AttachmentNotCoincidenceException extends BusinessException {

    public static final AttachmentNotCoincidenceException EXCEPTION = new AttachmentNotCoincidenceException();

    private AttachmentNotCoincidenceException() {
        super(HttpStatus.BAD_REQUEST, "일치하는 첨부파일이 없습니다");
    }
}
