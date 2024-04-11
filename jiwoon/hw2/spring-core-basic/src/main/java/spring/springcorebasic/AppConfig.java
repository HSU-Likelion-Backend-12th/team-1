package spring.springcorebasic;

public class AppConfig {
    public MemberService memberService() {
        rerturn new MemberService(memberRepository());
    }

    public OrderService orderService() {
        return new OrderSerciveImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository()
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}