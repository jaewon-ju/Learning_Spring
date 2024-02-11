package boardProject.demo.board;

import boardProject.demo.member.MemberRepository;
import boardProject.demo.member.MemoryMemberRepository;
import boardProject.demo.member.Position;

public interface BoardService {
   public Post posting(Long id, Position position, String title, String content);
}
