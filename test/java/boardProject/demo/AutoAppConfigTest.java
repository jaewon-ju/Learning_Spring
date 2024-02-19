package boardProject.demo;

import boardProject.demo.board.BoardPolicy;
import boardProject.demo.board.BoardService;
import boardProject.demo.board.BoardServiceImpl;
import boardProject.demo.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {
    @Test
    void componentScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        BoardPolicy boardPolicy = ac.getBean(BoardPolicy.class);
        Assertions.assertThat(boardPolicy).isInstanceOf(BoardPolicy.class);
    }
}