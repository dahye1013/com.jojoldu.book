package com.shin.book.springboot.web.dto;


import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {
    @Test
    public void lombok_test(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto  dto = new HelloResponseDto(name, amount);
        assertThat(dto.getName()).isEqualTo(name); //테스트 검증 라이브러리 검증 메소드 , 검증 대상을 메소드 인자로 받는다
        assertThat(dto.getAmount()).isEqualTo(amount); //


        //then

    }




}


