package boardProject.demo.board;

import boardProject.demo.member.Member;
import boardProject.demo.member.MemberRepository;
import boardProject.demo.member.MemoryMemberRepository;
import boardProject.demo.member.Position;

public class BoardServiceImpl implements BoardService{

    private final MemberRepository memberRepository;
    private final BoardPolicy boardPolicy;

    public BoardServiceImpl(MemberRepository memberRepository, BoardPolicy boardPolicy) {
        this.memberRepository = memberRepository;
        this.boardPolicy = boardPolicy;
    }

    @Override
    public Post posting(Long id, Position position, String title, String content) {
        Member member = memberRepository.findById(id);
        boolean authority = boardPolicy.returnAuthority(member);

        if(authority) {
            return new Post(id, position, title, content);
        } else {
            return new Post(id, position, "unavailable", "unavailable");
        }

    }
}
