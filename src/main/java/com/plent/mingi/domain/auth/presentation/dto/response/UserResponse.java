package com.plent.mingi.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter @AllArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String userId;
    private String password;
    private String name;

}
