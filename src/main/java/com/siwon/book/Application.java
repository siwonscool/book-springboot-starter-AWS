package com.siwon.book;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*
* @SpringBootApplication 어노테이션으로
* 스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
* 이 이노테이션이 있는 위치부터 설정을 읽으므로 반드시 프로젝트 최상단에 위치
*
* @EnableJpaAuditing 어노테이션으로
* JPA Auditing 어노테이션들을 모두 활성화 할 수 있도록 추가
 * */
//@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //SpringApplication.run 으로 내장 WAS를 실행
        SpringApplication.run(Application.class,args);


    }
}
