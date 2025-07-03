package com.hansung.likelion.global.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@RequiredArgsConstructor
public class BaseResponse {
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    private final String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));


    // 정팩메. 생성자를 쓰는 것보다 명확한 이름을 갖고 있고, 다양한 경우에 대해 일관된 응답 객체 생성 가능.
    public static BaseResponse of(Boolean isSuccess, BaseResponse baseResponse) {
        return new BaseResponse(isSuccess, baseResponse.getCode(), baseResponse.getMessage());
    }

    public static BaseResponse of(Boolean isSuccess, BaseResponse baseResponse, String message) {
        return new BaseResponse(isSuccess, baseResponse.getCode(), message);
    }

    public static BaseResponse of(Boolean isSuccess, String code, String message) {
        return new BaseResponse(isSuccess, code, message);
    }
}
