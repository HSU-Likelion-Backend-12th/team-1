package spring.springcorebasic.member;

// 관례상 구현체는 인터페이스 이름 + Impl
// 새로운 회원을 가입(join)하고, 조회(findMember)하는 기능 구현 필요
// 위 기능을 위해 저장소(MemberRepository)에 대한 참조가 필요
public class MemberServiceImpl implements MemberService{

    // new 키워드를 사용하여 인터페이스에 대한 구현체 설정
    // => 구현체가 변경될 경우 코드 수정이 필요하므로 SOLID 원칙중 DIP(의존관계 역전 원칙)을 위배함
    // DIP : 구현에 의존하지 않고, 역할에 의존해야한다. => New 키워드를 사용한 구현체에 직접 의존하면 안된다.
    private final MemberRepository memberRepository;
    //기존에 DIP 위반이 발생하였던 것은 클래스의 멤버 변수가 구체와 직접적인 연관 관계를 가졌기 때문
    //new 키워드를 사용했던 부분을 지우고 생성자를 통해 구체를 전달받도록
    //이렇게 하면 구체와 직접적인 연관 관계를 갖지 않으면서도 생성자를 통해 구체를 주입받을 수 있음

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
