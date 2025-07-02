package com.hansung.likelion.global.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.hansung.likelion.global.constant.StaticValue.*;

/***
 * 공통 에러 응답 코드
 */
@Getter
@AllArgsConstructor
public enum ErrorResponseCode implements BaseResponseCode {
    BAD_REQUEST_ERROR("GLOBAL_400_1", BAD_REQUEST, "잘못된 요청입니다."),
    INVALID_HTTP_MESSAGE_BODY("GLOBAL_400_2",  BAD_REQUEST,"HTTP 요청 바디의 형식이 잘못되었습니다."),
    INVALID_HTTP_MESSAGE_PARAMETER("GLOBAL_400_2", BAD_REQUEST,"HTTP 요청 파라미터의 형식이 잘못되었습니다."),
    ACCESS_DENIED_REQUEST("GLOBAL_403",  FORBIDDEN,"해당 요청에 접근 권한이 없습니다."),
    NOT_FOUND_ENDPOINT("GLOBAL_404",  NOT_FOUND,"존재하지 않는 엔드포인트입니다. URL을 확인해주세요"),
    UNSUPRPORTED_HTTP_METHOD("GLOBAL_405",  METHOD_NOT_ALLOWED,"지원하지 않는 HTTP 메소드입니다."),
    SERVER_ERROR("GLOBAL_500", INTERNAL_SERVER_ERROR, "서버 내부에서 알 수 없는 에러가 발생했습니다.");

    private final String code;
    private final int httpStatus;
    private final String message;
}
