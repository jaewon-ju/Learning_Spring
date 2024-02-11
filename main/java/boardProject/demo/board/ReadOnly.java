package boardProject.demo.board;

import boardProject.demo.member.Member;

import static boardProject.demo.member.Position.STUDENT;

public class ReadOnly implements BoardPolicy {
    @Override
    public boolean returnAuthority(Member member) {
        if(member.getPosition() == STUDENT){
            return false;
        } else {
            return true;
        }
    }
}
