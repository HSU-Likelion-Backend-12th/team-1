package hello.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller /*컨트롤러 annotation*/
public class HelloController {

    @GetMapping("hello") /*웹 어플리케이션에서 hello라고 들어오면 이 메소드로 호출*/
    public String hello(Model model) { //model : model view controller
        model.addAttribute( "data","hello!!");
        return "hello";
    }
}
