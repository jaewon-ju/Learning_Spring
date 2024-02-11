package boardProject.demo;

import boardProject.demo.board.BoardService;
import boardProject.demo.board.BoardServiceImpl;
import boardProject.demo.board.Post;
import boardProject.demo.member.Member;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import boardProject.demo.member.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardApp {
    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();
        // BoardService boardService = new BoardServiceImpl();

        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        // BoardService boardService = appConfig.boardService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        BoardService boardService = applicationContext.getBean("boardService", BoardService.class);
        Member member = new Member(1L, "studentA", Position.STUDENT);
        memberService.join(member);

        Post newPost = boardService.posting(member.getId(), member.getPosition(), "NEW POST", "hi");

        System.out.println("post = " + newPost);
    }
}
