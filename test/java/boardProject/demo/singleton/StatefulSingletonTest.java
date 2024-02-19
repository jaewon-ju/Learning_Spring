package boardProject.demo.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.*;

class StatefulSingletonTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(TestConfig.class);

        StatefulSingleton user1 = ac.getBean("statefulSingleton",
                StatefulSingleton.class);
        StatefulSingleton user2 = ac.getBean("statefulSingleton",
                StatefulSingleton.class);


        user1.setTime("user1",100);
        user2.setTime("user2",50);

        System.out.println(user1.getTime());
        Assertions.assertThat(user1.getTime()).isEqualTo(50);
    }
    @Configuration
    static class TestConfig {
        @Bean
        public StatefulSingleton statefulSingleton() {
            return new StatefulSingleton();
        }
    }
}