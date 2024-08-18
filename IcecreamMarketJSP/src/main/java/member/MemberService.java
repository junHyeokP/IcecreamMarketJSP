package member;

import java.util.List;

public interface MemberService {
	boolean regist(Member member);
	Member login(String id, String password);
	Member read(int no);
	List<Member> listAll();
	boolean edit(Member member, String oldPassword);
	boolean editAdditionalInfo(int memberNo, String mobile, String email, String address);
	boolean remove(int no);
}