package spring.springcorebasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.springcorebasic.discount.DiscountPolicy;
import spring.springcorebasic.member.Member;
import spring.springcorebasic.member.MemberRepository;

@Component
@RequiredArgsConstructor //생성자 코드를 그대로 똑같이 만들어줌
//final이 붙은 필수 값을 파라미터로 받는 생성자를 만들어줌
public class OrderServiceImpl implements OrderService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    /* 위의 경우는 DIP를 위반한 사례이다 : why? = new 객체를 사용하여 직접적으로 구체에 의존하였기 때문
    요구사항을 변경하려면 직접 new 이외의 부분을 수정하여야 한다.
    초기에 기대했던 연관 관계 = DiscountPolicy 인터페이스에 의존
    실제 작성된 코드의 연관 관계 = FixDisountPolicy라는 구체에 직접적으로 의존 -> DIP 위반 (+ OCP 위반)
    */

    // 회원의 등급을 확인하기 위함 => 할인정책 적용을 위해 (DIP 충족 위한 코드로 변경 완료)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); // 사용자의 등급을 통해 할인정책을 달리 하기 위함
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice); // 주문을 생성하여 반환

    }
}
