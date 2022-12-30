package com.example.springboot.web.dto;

import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // test 검증 라이브러리의 검증 메소드 검증하고 싶은 대상을 인자로 받음
        assertThat(dto.getAmount()).isEqualTo(amount);// 메소드 체이닝이 지원되어 isEqualTo(대상의 내용자체를 비교)와 같이 메소드를 이어서 사용가능
    }
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name , amount);
    }
}
