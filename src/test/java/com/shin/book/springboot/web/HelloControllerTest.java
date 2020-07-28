package com.shin.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)// 1. 테스트를 진행할 때 jUIT에 내장된 실행자외에 다른 실행자를 실행시킨다. 여기서는 SpringRunner라는 스프링 실행자를 이용한다. 즉, 스프링 부트 테스트와 JUIT사이에 연결자 역할을 한다.
@WebMvcTest     //2. 여러 스프링 테스트 어노테이션 중, web에 집중할 수 있는 어노테이션, 선언할 경우, Controller, ControllerAdvice등 사용가능
public class HelloControllerTest {
    @Autowired //3. 스프링이 관리하는 bean주입
    private MockMvc mvc; //4. Web API 테스트 할때 사용 스프링 MVC테스트의 시작점, HTTP GET, POST등을 테스트한다

    @Test
    public void hello_return() throws Exception{
        String hello ="hello"; ///hello란 주소로 HTTPGET  요청한다.
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())//andExpect(status.isOk()) mvc perform 의 결과를 검증함, HTTPHeader 의 Status를 검증, 200,404, 500등의 상태 검증, 여기선 OK(200)인지 확인
                .andExpect(content().string(hello)); //CONTENT().string(hello) mvc.perform의 결과 검증, 응답 본문의 내용 검증 Controller에서 hello를 리턴하니까 이 값이 맞는지 검증

    }

    @Test
    public void helloDto_return() throws Exception{
        String name="hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name",name)
                        .param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));




    }


}