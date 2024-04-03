package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service
public class MemberService { // ctrl + shift + T => 테스트 생성 단축키
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 직접 new하지 않고 외부에서 넣어줌 -> Dependency Injection(DI)
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원X
        // Optional<Member> result = memberRepository.findByName(member.getName()); // 다음 코드와 같음
        //result.ifPresent(m -> {
        //    throw new IllegalStateException("이미 존재하는 회원입니다.");
        //});
        validateDuplicatedMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
} // 서비스는 비즈니스 용어 사용 지향할 것\

// 2. 직접 스프링빈 등록하기 -> @Service, @Autowired 지우기
