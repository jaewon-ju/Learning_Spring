package boardProject.demo.member;

public interface MemberRepository {
    void add(Member member);
    Member findById(Long memberId);
}
