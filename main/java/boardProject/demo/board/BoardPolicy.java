package boardProject.demo.board;

import boardProject.demo.member.Member;

public interface BoardPolicy {
    boolean returnAuthority(Member member);
}
