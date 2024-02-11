package boardProject.demo;

import boardProject.demo.board.BoardService;
import boardProject.demo.board.BoardServiceImpl;
import boardProject.demo.board.Post;
import boardProject.demo.member.Member;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import boardProject.demo.member.Position;

public class BoardApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        BoardService boardService = new BoardServiceImpl();

        Member member = new Member(1L, "studentA", Position.STUDENT);
        memberService.join(member);

        Post newPost = boardService.posting(member.getId(), member.getPosition(), "NEW POST", "hi");

        System.out.println("post = " + newPost);
    }
}
