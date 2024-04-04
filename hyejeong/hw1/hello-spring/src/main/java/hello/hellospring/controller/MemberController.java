package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller //controller라는 애노테이션을 보고 스프링이 뜰 때
public class MemberController {
    // 이 MemberController를 객체 생성 : 스프링 컨테이너에서 스프링 빈이 관리된다

    private final MemberService memberService;

    @Autowired //이 MemeberService를 스프링이 스프링 컨테이너에 있는 MemberService를 가져다가 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
