package spring.springcorebasic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //Conponentscan -> @Configuration이 붙은 설정 정보 자동으로 등록
        //앞에서 만들어두었던 설정 정보도 등록되고 실행되어 버리기 때문에
        //설정 정보는 컴포넌트 스캔 대상에서 제외
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
