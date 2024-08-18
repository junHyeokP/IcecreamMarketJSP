package member;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.OracleJDBConnection;

public class OracleMemberDAO implements MemberDAO {

	@Override
	public int insert(Member member) {
		// DB 연결
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		// sql문 만들기
		String sql = new StringBuilder()
				.append("insert into member (no, id, password, nickname, regdate)")
				.append("values (member_seq.nextval, ?, ?, ?, sysdate)")
				.toString();
		
		int result = 0;
		
		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			// SQL문 매개변수에 값 추가
			jdbc.pstmt.setString(1, member.getId());
			jdbc.pstmt.setString(2, member.getPassword());
			jdbc.pstmt.setString(3, member.getNickname());

			// SQL문 실행
			result = jdbc.pstmt.executeUpdate();
			if (result == 1)
				System.out.println(result + "행이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원 객체 닫기
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public Member select(int no) {

		Member member = null;

		// DB 연결
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문 만들기
		String sql = "select * from member where no=?";

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, no);

			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				member = new Member(
						jdbc.rs.getInt("no"),
						jdbc.rs.getString("id"),
						jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate")
				);
				member.setMobile(jdbc.rs.getString("mobile"));
				member.setAddress(jdbc.rs.getString("address"));
				member.setEmail(jdbc.rs.getString("email"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}

		return member;
	}

	@Override
	public Member select(String id, String password) {
		
		Member member = null;

		OracleJDBConnection jdbc = new OracleJDBConnection();

		String sql = "select * from member where id=? and password=?";

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, id);
			jdbc.pstmt.setString(2, password);
			
			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			if (jdbc.rs.next()) {
				member = new Member(
					jdbc.rs.getInt("no"),
					jdbc.rs.getString("id"),
					jdbc.rs.getString("password"),
					jdbc.rs.getString("nickname"),
					jdbc.rs.getDate("regdate"));
				member.setMobile(jdbc.rs.getString("mobile"));
				member.setAddress(jdbc.rs.getString("address"));
				member.setEmail(jdbc.rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}

		// 자원 객체 닫기
		jdbc.close();

		return member;
		
	}

	@Override
	public List<Member> selectAll() {
		// DB 연결
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문 만들기
		String sql = "select * from member";

		// 결과를 저장할 List 객체를 생성
		List<Member> memberList = new ArrayList<>();

		try {
			// PreparedStatement 객체 생성
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			// SQL문 실행
			jdbc.rs = jdbc.pstmt.executeQuery();

			// ResultSet 객체에서 결과값 가져와서 출력하기
			while (jdbc.rs.next()) {
				Member member = new Member(jdbc.rs.getInt("no"),
						jdbc.rs.getString("id"),
						jdbc.rs.getString("password"),
						jdbc.rs.getString("nickname"),
						jdbc.rs.getDate("regdate"));
				member.setMobile(jdbc.rs.getString("mobile"));
				member.setAddress(jdbc.rs.getString("address"));
				member.setEmail(jdbc.rs.getString("email"));
				memberList.add(member);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}

		return memberList;
	}
	
	@Override
	public int update(Member member) {
		
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문
		String sql = new StringBuilder()
				.append("update member ")
				.append("set password=?, nickname=?")
				.append("where no=?")
				.toString();

		int result = 0;
		
		try {
			// PS 객체, 매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getPassword());
			jdbc.pstmt.setString(2, member.getNickname());
			jdbc.pstmt.setInt(3, member.getNo());

			// sql 실행~~~~
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
	
	@Override
	public int updateAddtionalInfo(Member member) {
		
		OracleJDBConnection jdbc = new OracleJDBConnection();

		// sql문
		String sql = new StringBuilder()
				.append("update member ")
				//.append("set password=?, nickname=?")
				.append("set mobile=?, email=?, address=?")
				.append("where no=?")
				.toString();

		int result = 0;
		
		try {
			// PS 객체, 매개변수 set
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setString(1, member.getMobile());
			jdbc.pstmt.setString(2, member.getEmail());
			jdbc.pstmt.setString(3, member.getAddress());
			jdbc.pstmt.setInt(4, member.getNo());

			// sql 실행~~~~
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
	
	
	@Override
	public int delete(int no) {
		int result = 0;
		
		// DB 연결
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		// sql문 만들기
		String sql = "delete member where no=?";
		
		try {
			// PreparedStatement 객체 생성 <- sql문
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			// 파라미터 set
			jdbc.pstmt.setInt(1, no);
			
			// 실행
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 삭제되었습니다.");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			jdbc.close();
		}
				
		return result;
	}

}