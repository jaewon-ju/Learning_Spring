package boardProject.demo.handleBean;

import boardProject.demo.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    // AppConfig를 설정정보로 하는 스프링 컨테이너 생성

    @Test
    @DisplayName("Print All Bean")
    void printAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // getBeanDefinitionNames() --> 스프링에 등록된 모든 빈 이름을 배열로 리턴

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            // getBean(이름) --> 해당 이름을 가진 빈을 Object 타입으로 반환
            // getBean(타입) --> 해당 타입 + 해당 타입의 하위 타입의 빈을 모두 조회, 중복 시 오류 발생
            // getBean(이름, 타입) --> 해당 이름, 타입을 가진 빈을 반환

            System.out.println("name = " +  beanDefinitionName + "bean = " + bean);
        }
    }
    // 위의 코드는 모든 빈을 출력함
    // 개발자가 만들어낸 어플리케이션 빈만 출력하고 싶다면, BeanDefinition.ROLE_APPLICATION을 사용하면 됨

    @Test
    @DisplayName("Print Application Bean")
    void printApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // getBeanDefinitionNames() --> 스프링에 등록된 모든 빈 이름을 배열로 리턴

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            // BeanDefinition 클래스에는 getRole() 메소드가 정의되어 있음

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " +  beanDefinitionName + "bean = " + bean);
            }
        }
    }
}
