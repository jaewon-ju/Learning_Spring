package boardProject.demo.handleBean;

import boardProject.demo.AppConfig;
import boardProject.demo.board.BoardPolicy;
import boardProject.demo.board.ReadOnly;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class DuplicateBeanTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameTypeBeanConfig.class);

    @Configuration
    static class SameTypeBeanConfig{
        @Bean
        public BoardPolicy boardPolicy1(){
            return new ReadOnly();
        }

        @Bean
        public BoardPolicy boardPolicy2(){
            return new ReadOnly();
        }
    }

    @Test
    @DisplayName("Find Bean By Type")
    void findBeanByType(){
        // getBean(타입): 해당 타입의 빈을 Object 타입으로 반환
        // 해당 타입의 빈이 여러개 존재한다면, 중복 오류 발생
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(BoardPolicy.class));
    }

    // 위의 문제를 해결하려면, 이름, 타입을 같이 지정해주면 된다.

    @Test
    @DisplayName("Find Bean By Name & Type")
    void findBeanByTypeSpecific(){
        Object boardPolicy = ac.getBean("boardPolicy1", BoardPolicy.class);
        org.assertj.core.api.Assertions.assertThat(boardPolicy).isInstanceOf(ReadOnly.class);
    }

    // 특정 타입의 빈을 모두 출력하고 싶다면, getBeansOfType()을 사용하면 된다.
    @Test
    @DisplayName("Find ALL Bean By Type")
    void findAllBeanByType(){
        Map<String, BoardPolicy> beansOfType = ac.getBeansOfType(BoardPolicy.class);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }
}
