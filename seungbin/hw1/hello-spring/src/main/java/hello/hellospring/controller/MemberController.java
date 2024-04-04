package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//생성해두면 스프링 컨테이너에서 스피링 빈이 관리됨
//스프링 빈을 등록할 때는 싱글톤으로만 등록됨
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //스프링 컨테이너에 있는 멤버서비스를 가져다가 연결해줌
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
