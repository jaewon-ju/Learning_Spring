package boardProject.demo.board;

import boardProject.demo.member.Member;
import org.springframework.stereotype.Component;

@Component
public class ReadWritePolicy implements BoardPolicy{

    @Override
    public boolean returnAuthority(Member member) {
        return true;
    }
}
