package icecream;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;

import common.JDBConnection;
import common.OracleJDBConnection;

public class OracleIceDAO implements IceDAO {

	@Override
	public int insert(Icecream ice) {
		
		
		JDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder().append("insert into icecream (iceID, name, price, regDate)")
										.append("values (ice_Seq.nextval, ?, ?, sysdate)")
										.toString();
		
		
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setString(1, ice.getName());
			jdbc.pstmt.setInt(2, ice.getPrice());
			
			result = jdbc.pstmt.executeUpdate();
			
			if (result >= 1) {
				System.out.println("success");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			jdbc.close();
			
		}
		return result;
	}

	@Override
	public Icecream select(int id) {
		
		JDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from icecream where iceID = ?";

		
		Icecream ice = null;
		
		try {
		
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, id);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				ice = new Icecream(
						jdbc.rs.getString("name"),
						jdbc.rs.getInt("price"));
				
			} else {
				System.out.println("비어있습니다.");
			}
		
		} catch (SQLException e) {

			e.printStackTrace();
			
		} finally {
			
			jdbc.close();
			
		}
		
		return ice;
	}

	@Override
	public List<Icecream> selectAll() {
		
		JDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from icecream";
		
		List<Icecream> iceList = new ArrayList<>();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			while (jdbc.rs.next()) {
				Icecream ice= new Icecream(
								jdbc.rs.getString("name"),
								jdbc.rs.getInt("price"));
				
				iceList.add(ice);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			jdbc.close();
			
		}
		
		return iceList;
		
	}

	@Override
	public int update(Icecream icecream) {
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		String sql = new StringBuilder().append("update icecream ")
				.append("set name = ?, price = ? ")
				.append("where iceID = ?")
				.toString();
		int result = 0;

		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);

			jdbc.pstmt.setString(1, icecream.getName());
			jdbc.pstmt.setInt(2, icecream.getPrice());
			jdbc.pstmt.setInt(3, icecream.getIceID());

			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "개의 행이 수정되었습니다.");

		} catch (SQLException e) {

			e.printStackTrace();
		
		} finally {
			jdbc.close();
		}

		return result;
		
	}

	@Override
	public int delete(int id) {
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		int result = 0;
		
		String sql = "delete icecream where iceID = ?";
		
		
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql); // PrepareStatment 객체 생성, sql 명령문 준비
			
			jdbc.pstmt.setInt(1, id); // ? 부분에 매개변수 넣기
			
			result = jdbc.pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			jdbc.close();
		}
		
		return result;
	}
}
