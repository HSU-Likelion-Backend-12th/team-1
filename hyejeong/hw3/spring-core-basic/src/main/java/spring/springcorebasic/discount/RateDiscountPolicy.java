package spring.springcorebasic.discount;

import org.springframework.stereotype.Component;
import spring.springcorebasic.member.Grade;
import spring.springcorebasic.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent=10; //10프로 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){ //등급을 확인하고 등급이 vip라면
            return price * discountPercent/100;
        }
        else
            return 0;
    }
}
