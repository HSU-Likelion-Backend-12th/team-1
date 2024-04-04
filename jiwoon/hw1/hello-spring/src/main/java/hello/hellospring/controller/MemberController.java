package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) { // 1. 생성자 주입(DI 세 가지 방법) 권장 <- 실행 중 동적으로 변하는 경우 거의 없으므로
        this.memberService = memberService;
    }

    // @Autowired private final MemberService memberService; // 2. 필드 주입

    /*@Autowired // 3. setter 주입(단점, public으로 열려있어야 함 -> setter가 아무 개발자나 접근 가능), memberService 선언 시 final 제거
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/
}