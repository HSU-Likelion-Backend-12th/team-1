package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemeberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemeberRepository memeberRepository= new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 불가
        validateDuplicateMember(member); //중복 회원 검증
        memeberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memeberRepository.findByName(member.getName())
                .ifPresent(m -> { //result가 깂이 있으면. 멤버 m이 들어올 것. 여기에 멤버의 값이 있으면
                    throw new IllegalStateException("이미 존재하는 회원입니다."); //null이 아니면 어떤 값이 있으면 로직 동작
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memeberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memeberRepository.findById(memberId);
    }


}
