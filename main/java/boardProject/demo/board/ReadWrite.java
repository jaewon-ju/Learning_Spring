package boardProject.demo.board;

import boardProject.demo.member.Member;

public class ReadWrite implements BoardPolicy{

    @Override
    public boolean returnAuthority(Member member) {
        return true;
    }
}
