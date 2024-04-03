package hello.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
