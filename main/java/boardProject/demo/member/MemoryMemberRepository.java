package boardProject.demo.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> storage = new HashMap<>();
    @Override
    public void add(Member member) {
        storage.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId){
        return storage.get(memberId);
    }
}
