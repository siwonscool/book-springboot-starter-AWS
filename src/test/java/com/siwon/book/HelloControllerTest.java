package com.siwon.book;

import com.siwon.book.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
* @RunWith 어노테이션은 스프링부트 테스트와 JUnit 사이에 연결자 역할을 한다
* */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    /*
    * Spring 이 관리하는 Bean 을 주입
    * */
    @Autowired
    /*
    * MockMvc 클래스를 통해서 HTTP GET, POST 등에대한 API 테스트를 할 수 있다.
    * */
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";
        /*
        * mvc.perform(get("/hello))는 MockMvc 객체를 통해 /hello 주소로 HTTP GET 요청을 보낸다.
        * andExpect(status().isOk())의 status() 는 HTTP header 의 상태를 검증하며 isOK() 는 200인지 아닌지 검증
        * andExpect(content().string(hello))는 mvc.perform 의 결과를 검증하며 Controller 에서 "hello"를 리턴하기 떄문에 이값이 맞는지 검증
        * */
        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        /*
        * .param()은 String 값만 허용하며 API 테스트를 진행할 때 사용될 요청 파라미터를 설정
        * jsonPath() 는 JSON 응닶값을 필드별로 검증할수 있는 메소드, $ 를 기준으로 필드명을 명시
        * */
        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
