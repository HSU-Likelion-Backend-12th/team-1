package spring.springcorebasic.autowired;

import jakarta.annotation.Nullable;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springcorebasic.member.Member;

import java.sql.SQLOutput;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class); // 스프링빈 등록
    }

    static class TestBean {
        //@Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
        //호출 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("setNoBean1 = " + noBean1);
        }
        //org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null 입력
        //null 호출
        @Autowired
        public void setBoBean2(@Nullable Member noBean2){
            System.out.println("setNoBean2 = " + noBean2);
        }
        //Optional<> : 자동 주입할 대싱이 없으면 Optional.empty가 입력
        //Optional.empty 호출
        @Autowired(required = false)
        public void setBoBean3(Optional<Member> noBean3){
            System.out.println("setNoBean3 = " + noBean3);
        }
    }
}
