package spring.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springcorebasic.discount.DiscountPolicy;
import spring.springcorebasic.discount.FixDiscountPolicy;
import spring.springcorebasic.discount.RateDiscountPolicy;
import spring.springcorebasic.member.MemberRepository;
import spring.springcorebasic.member.MemberService;
import spring.springcorebasic.member.MemberServiceImpl;
import spring.springcorebasic.member.MemoryMemberRepository;
import spring.springcorebasic.order.OrderService;
import spring.springcorebasic.order.OrderServiceImpl;

@Configuration //설정을 Configuration 한다는 뜻
public class AppConfig {
    //AppConfig는 애플리케이션에 필요한 구현 객체를 생성
    //AppConfig는 생성한 객체 인스턴스의 참조를 생성자를 통해서 주입(연결)
    //이처럼 객체를 생성하고 관리하면서 의존관계를 연결해주는 것 : IoC 컨테이너 or DI 컨테이너

    @Bean //구체를 반환하는 함수에 @Bean 붙이기 -> 구체를 저장해둘 수 있다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy(); //구체만 변경
    }
}
