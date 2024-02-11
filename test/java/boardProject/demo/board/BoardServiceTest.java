package boardProject.demo.board;

import boardProject.demo.member.Member;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import boardProject.demo.member.Position;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class BoardServiceTest {
    MemberService memberService = new MemberServiceImpl();
    BoardService boardService = new BoardServiceImpl();


    @Test
    void posting(){
        Member member1 = new Member(1L, "studentA", Position.STUDENT);
        Member member2 = new Member(2L, "teacherB", Position.TEACHER);

        memberService.join(member1);
        memberService.join(member2);

        Post post1 = boardService.posting(member1.getId(), member1.getPosition(), "titleA", "contentA");
        Post post2 = boardService.posting(member2.getId(), member2.getPosition(), "titleB", "contentB");

        Assertions.assertThat(post1.getTitle()).isEqualTo("unavailable");
        Assertions.assertThat(post2.getTitle()).isEqualTo("titleB");
    }

}