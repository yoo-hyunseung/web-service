package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication //스프링 부트의 자동설정, 스프링 Bean읽기 생성 모두 자동 설정
public class Application { //메인 프로젝트 Application이 있는 위치부터 읽어나가기 때문에 항상 프로젝트 최상단에 위치
    public static void main(String[]args){ //spring boot는 메인 메소드가 선언된 클래스를 기준으로 실행
        SpringApplication.run(Application.class,args); //내장 WAS를 실행
    }
}
