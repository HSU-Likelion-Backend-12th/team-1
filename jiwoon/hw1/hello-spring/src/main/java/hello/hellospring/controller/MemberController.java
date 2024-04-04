package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }
}