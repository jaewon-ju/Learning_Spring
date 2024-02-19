package boardProject.demo.board;

import boardProject.demo.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static boardProject.demo.member.Position.STUDENT;

@Component
@Primary
public class ReadOnlyPolicy implements BoardPolicy {
    @Override
    public boolean returnAuthority(Member member) {
        if(member.getPosition() == STUDENT){
            return false;
        } else {
            return true;
        }
    }
}
