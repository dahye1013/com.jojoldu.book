package com.shin.book.springboot.web;

import com.shin.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //responseBody처럼 RestController을 붙이면 문자열로 return해준다.
public class HelloController {


    @GetMapping("/hello") //@RequestMapping(method=RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDTO(@RequestParam("name") String name, @RequestParam("amount") int amount){

        return new HelloResponseDto(name,amount);
    }
}
