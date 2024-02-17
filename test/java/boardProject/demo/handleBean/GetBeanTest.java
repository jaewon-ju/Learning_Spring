package boardProject.demo.handleBean;

import boardProject.demo.AppConfig;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GetBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("Find Bean By Name")
    void findBeanByName(){
        // getBean(이름): 해당 빈을 Object 타입으로 반환
        Object memberService = ac.getBean("memberService");
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Find Bean By Type")
    void findBeanByType(){
        // getBean(타입): 해당 타입의 빈을 Object 타입으로 반환
        Object memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("Find Bean By Name & Type")
    void findBeanByNameType(){
        // getBean(이름, 타입): 해당 빈을 Object 타입으로 반환
        Object memberService = ac.getBean("memberService",MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
}
