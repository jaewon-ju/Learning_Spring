package boardProject.demo.singleton;

import boardProject.demo.AppConfig;
import boardProject.demo.board.BoardService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {
    @Test
    @DisplayName("Testing Singleton Container")
    void singletonTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        BoardService boardService1 = ac.getBean(BoardService.class);
        BoardService boardService2 = ac.getBean(BoardService.class);

        System.out.println("boardService1 = " + boardService1);
        System.out.println("boardService2 = " + boardService2);

        Assertions.assertThat(boardService1).isSameAs(boardService2);
    }
}
