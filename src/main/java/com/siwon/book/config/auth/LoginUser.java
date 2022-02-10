package com.siwon.book.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이 어노테이션이 생성될수 있는 위치를 지정하며 PARAMETER 로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용가능
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)

//@interface 는 이파일을 어노테이션 클래스로 지정해주며 LoginUser 라는 어노테이션이 생성되었음을 알 수 있다.
public @interface LoginUser {
}
