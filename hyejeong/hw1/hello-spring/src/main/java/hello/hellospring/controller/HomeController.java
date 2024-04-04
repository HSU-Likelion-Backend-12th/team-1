package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")

    public String home(){
        //맵핑된 URL 존재-> index.html 기존에 만들었던 정적 리소스 무시
        return "home";
    }
}
