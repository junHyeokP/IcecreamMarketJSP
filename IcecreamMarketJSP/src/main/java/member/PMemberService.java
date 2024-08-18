package member;

import java.util.List;

public class PMemberService implements MemberService {
	
	private MemberDAO memberDao;
	
	public PMemberService(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	@Override
	public boolean regist(Member member) {

		if (member == null) return false;
		
		int result = memberDao.insert(member);
		
		return (result == 1) ? true : false;
	}
	
	@Override
	public Member login(String id, String password) {
	
		return memberDao.select(id, password);
	}
	
	@Override
	public Member read(int no) {
		Member member = memberDao.select(no);
		return member;
	}
	
	@Override
	public List<Member> listAll() {
		
		List<Member> memberList = memberDao.selectAll();
		return memberList;
	}
	
	@Override
	public boolean edit(Member member, String oldPassword) {
		
		if (member == null) return false;
		if (oldPassword == null) return false;
		
		int result = 0;
		
		Member memInfo = memberDao.select(member.getNo());
		if (oldPassword.equals(memInfo.getPassword())) {
				result = memberDao.update(member);
		}
		
		return (result == 1) ? true : false;
	}
	
	@Override
	public boolean editAdditionalInfo(int no, String mobile, String email, String address) {
		
		Member member = new Member();
		
		member.setNo(no);
		member.setMobile(mobile);
		member.setEmail(email);
		member.setAddress(address);
		
		memberDao.updateAddtionalInfo(member);
		
		return false;
	}
	
	@Override
	public boolean remove(int no) {
		if (memberDao.select(no) == null) {
			return false;
		}
		
		int result = memberDao.delete(no);
		
		return (result == 1) ? true : false;
	}
}
