package com.example.springboot.web;


import com.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//json을 반환하는 컨트롤러 설정
public class HelloController {

    @GetMapping("/hello") // HTTP method Get 요청을 받을 수 있는 API를 만들어줌 -> /hello로 요청이오면 hello 를 반환
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto") // get 요청을 받을 수 있는 API를 생성
    public HelloResponseDto helloDto(@RequestParam("name") String name, // 외부에서 API로 넘긴 파라미터(매개변수)를 가져오는 어노테이션
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }

}
