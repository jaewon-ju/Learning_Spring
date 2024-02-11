package boardProject.demo;

import boardProject.demo.board.BoardPolicy;
import boardProject.demo.board.BoardService;
import boardProject.demo.board.BoardServiceImpl;
import boardProject.demo.board.ReadOnly;
import boardProject.demo.member.MemberRepository;
import boardProject.demo.member.MemberService;
import boardProject.demo.member.MemberServiceImpl;
import boardProject.demo.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public BoardPolicy boardPolicy(){
        return new ReadOnly();
    }
    @Bean
    public BoardService boardService(){
        return new BoardServiceImpl(memberRepository(), boardPolicy());
    }
}
