package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") //문자인 경우
    @ResponseBody //응답 Body부에 이 데이터를 내가 직접 넣어주겠다
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //view (X) => 템플릿 엔진과의 차이
    }

    @GetMapping("hello-api") //객체인 경우
    //default - json 방식으로 넘김
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        //JavaBean 규약 - 메서드를 통해 접근하도록
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
