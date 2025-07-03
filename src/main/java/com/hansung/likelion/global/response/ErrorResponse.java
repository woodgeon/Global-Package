package com.hansung.likelion.global.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.hansung.likelion.global.response.code.BaseResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonPropertyOrder({"isSuccess", "timeStamp", "code", "httpStatus", "message", "data"})
public class ErrorResponse<T> extends BaseResponse {
    private final int httpStatus;
    private final T data;

    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode) {
        super(false, baseResponseCode.getCode(), baseResponseCode.getMessage());
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    // message custom
    @Builder
    public ErrorResponse(T data, BaseResponseCode baseResponseCode, String message) {
        super(false, baseResponseCode.getCode(), message);
        this.httpStatus = baseResponseCode.getHttpStatus();
        this.data = data;
    }

    // no data, BaseResponseCode
    public static ErrorResponse<?> from(BaseResponseCode baseResponseCode) {
        return new ErrorResponse<>(null, baseResponseCode);
    }

    // no data, BaseResponseCode, custom message
    public static ErrorResponse<?> from(BaseResponseCode baseResponseCode, String message) {
        return new ErrorResponse<>(null, baseResponseCode, message);
    }

    // has data, BaseResponseCode
    public static <T> ErrorResponse<T> of(BaseResponseCode baseResponseCode, T data) {
        return new ErrorResponse<>(data, baseResponseCode);
    }

    // has data, BaseResponseCode, custom message
    public static <T> ErrorResponse<T> of(BaseResponseCode baseResponseCode, T data, String message) {
        return new ErrorResponse<>(data, baseResponseCode, message);
    }

}
