package com.example.springboot.web;


//import com.example.springboot.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith(SpringExtension.class) //junit5에서 사용 junit에 내장된 실행자외에 다른 실행자를 실행한다 SpringExtension.class
                                    //SpringBootTest와 junit사이에 연결자 역활을 한다.
@WebMvcTest(controllers = HelloController.class) //web에 집중 할 수 있는 어노테이션 controller레이어만 슬라이스 테스트에 용이
                                                // controller만 사용

public class HelloControllerTest {
    @Autowired //스프링이 관리하는 Bean을 주입 받습니다. Bean은 객채와 비슷한 뜻;
    private MockMvc mvc; // web API를 테스트할 때 사용합니다. 스프링 MVC테스트의 시작점.(HTTP GET,POST)등 테스트가능
    @Test
        public void hello가_리턴된다() throws Exception{
            String hello = "hello";
            mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
            //MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함, 체이닝이 지원되어 아래와 같이 여러 검증을 이어서 선언 가능
            //mvc.perform의 결과를 검증, HTTP Header의 Status를 검증
            //여기서는 OK 를 200을 확인 우리가 알고 있는 200, 404, 500
            //controller에서는 hello를 리턴하기 때문에 값이 맞는지 확인
        }

    @Test
        public void helloDto가_리턴된다() throws Exception{
            String name ="hello";
            int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
