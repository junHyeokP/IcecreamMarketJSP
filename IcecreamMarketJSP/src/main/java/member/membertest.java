package member;

import java.util.List;

public class membertest {

	public static void main(String[] args) {
		MemberService service = new PMemberService(new OracleMemberDAO());
		List<Member> memberList = service.listAll();
		
		System.out.println(memberList.size());
		
	}

}
