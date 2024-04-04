package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller /*컨트롤러 annotation*/
public class HelloController {

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){ //name은 spring!!으로 바뀐다
        model.addAttribute("name", name); //name은 spring!!으로 바뀐다 -> 그 후 모델에 담겨서
        return "hello-template";
    }

    @GetMapping("hello") /*웹 어플리케이션에서 hello라고 들어오면 이 메소드로 호출*/
    public String hello(Model model) { //model : model view controller
        model.addAttribute( "data","hello!!");
        return "hello";
    }

    @GetMapping("hello-string")
    @ResponseBody //html에 나오는 body가 아니라 http 통신 프로토콜의 body를 뜻함
    // ResponseBody -> 응답 body부에 이 내용을 직접 넣어주겠다는 뜻
    public String helloString(@RequestParam("name") String name){
        return "hello "+name; //"hello spring" 문자가 요청한 클라이언트에 그대로 내려간다
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello =new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
