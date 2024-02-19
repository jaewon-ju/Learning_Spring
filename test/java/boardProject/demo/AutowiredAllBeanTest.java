package boardProject.demo;

import boardProject.demo.board.*;
import boardProject.demo.member.Member;
import boardProject.demo.member.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.List;

public class AutowiredAllBeanTest {
    static class BoardService {

        private final Map<String, BoardPolicy> policyMap;

        public BoardService(Map<String, BoardPolicy> policyMap) {
            this.policyMap = policyMap;
        }

        public boolean getAuthority(Member member, String policyCode){
            BoardPolicy boardPolicy = policyMap.get(policyCode);

            return boardPolicy.returnAuthority(member);
        }
    }

    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, BoardService.class);
        // AutoAppConfig와 BoardService를 설정정보로 전달 + 빈으로 등록

        BoardService boardService = ac.getBean(BoardService.class);
        Member member = new Member(1L, "studentA", Position.STUDENT);

        boolean authority = boardService.getAuthority(member, "readOnlyPolicy");

        Assertions.assertThat(authority).isEqualTo(false);
    }
}
