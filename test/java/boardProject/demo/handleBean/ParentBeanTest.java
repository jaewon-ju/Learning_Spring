package boardProject.demo.handleBean;

import boardProject.demo.board.BoardPolicy;
import boardProject.demo.board.ReadOnly;
import boardProject.demo.board.ReadWrite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ParentBeanTest {
    // 부모 타입의 빈을 조회하면, 자식 타입의 빈도 함께 조회된다.
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(InheritBeanTest.class);

    @Configuration
    static class InheritBeanTest{
        @Bean
        public BoardPolicy boardPolicy1(){
            return new ReadOnly();
        }

        @Bean
        public BoardPolicy boardPolicy2(){
            return new ReadWrite();
        }
    }

    @Test
    @DisplayName("부모 타입 조회 시, 자식 타입도 모두 조회된다.")
    void findBeanByParentTypeError(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(BoardPolicy.class));
    }

    @Test
    @DisplayName("부모 타입으로 조회할 때, 자식이 둘 이상 있으면 자식의 이름을 사용하면 된다.")
    void findBeanByParentTypeAndChildName(){
        BoardPolicy boardPolicy = ac.getBean("boardPolicy1",BoardPolicy.class);
        assertThat(boardPolicy).isInstanceOf(ReadOnly.class);
    }
    // 빈의 타입은 리턴 타입이 아니라, 실제 객체의 타입이다?

    @Test
    @DisplayName("특정 하위 타입으로 조회하면, 중복 오류를 막을 수 있다. 하지만, 권장되지 않음")
    void findChildBeanByType(){
        BoardPolicy boardPolicy = ac.getBean(ReadOnly.class);
        assertThat(boardPolicy).isInstanceOf(ReadOnly.class);
    }

    @Test
    @DisplayName("getBeansOfType 메소드로 해당 타입 + 자식 타입의 모든 빈을 조회할 수 있다.")
    void findAllBeanByParentType(){
        Map<String, BoardPolicy> beans = ac.getBeansOfType(BoardPolicy.class);
        assertThat(beans.size()).isEqualTo(2);
    }
}
