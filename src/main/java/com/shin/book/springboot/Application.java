package com.shin.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스트링부트 자동설정, bean 읽기와 생성을 자동으로 해준다. //
                        // 어노테이션 위치로부터 읽어가기때문에 항상 프로젝트 최상단 패키지 안에 위치해있어야함
public class Application {

    public static void main(String[] args) {
        //스프링 부트 내장서버를 실행시킨다.(톰캣 설치 필요없음)
        SpringApplication.run(Application.class , args);

    }



}
