package icecream;

import java.sql.SQLException;
import java.util.List;

import common.JDBConnection;
import common.OracleJDBConnection;

public class OracleIcecreamDAO implements iceDAO {

	@Override
	public int insert(Icecream ice) {
		
		
		JDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder().append("insert into icecream (iceNo, name, price, instock, regDate)")
										.append("values (ice_Seq.nextval, ?, ?, ?, sysdate)")
										.toString();
		
		
		int result = 0;
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setString(1, ice.getName());
			jdbc.pstmt.setInt(2, ice.getPrice());
			jdbc.pstmt.setInt(3, ice.getInstock());
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Icecream> selecAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Icecream book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
