package com.hansung.likelion.global.exception;

import com.hansung.likelion.global.response.code.BaseResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
// 런타임 예외를 커스텀하는 클래스이기 때문에 RuntimeException을 상속받는다.
public class BaseException extends RuntimeException {
    private final BaseResponseCode baseResponseCode;

}
