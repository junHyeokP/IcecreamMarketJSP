package cart;

import java.sql.SQLException; 
import java.util.ArrayList;
import java.util.List;

import common.OracleJDBConnection;

public class OracleCartDAO implements CartDAO {

	@Override
	public int insert(CartItem item) {
		
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder().append("insert into cart (id, member_no, ice_ID, quantity, regdate)")
										.append("values (cart_seq.nextval, ?, ?, ?, sysdate)").toString();
		
		try {
		
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setInt(1, item.getMemberNo());
			jdbc.pstmt.setInt(2, item.getIceID());
			jdbc.pstmt.setInt(3, item.getQuantity());
			
			result = jdbc.pstmt.executeUpdate();
			
			System.out.println(result + "개 행 수정됨");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public CartItem select(int cartid, int loggedMemberNo) {
		
		CartItem item = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where id = ?";		
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartid);
			jdbc.pstmt.setInt(2, loggedMemberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			if (jdbc.rs.next()) {
				item = new CartItem(
				jdbc.rs.getInt("id")
				,jdbc.rs.getInt("member_id")
				,jdbc.rs.getInt("ice_ID")
				,jdbc.rs.getInt("quantity")
				,jdbc.rs.getDate("regdate")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			
			jdbc.close();
		}
		return item;
	}

	@Override
	public CartItem selectByIceID(int loggedMemberNo, int iceID) {
		
		CartItem item = null;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where ice_ID = ? and member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, iceID);
			jdbc.pstmt.setInt(2, loggedMemberNo);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				item = new CartItem(
						jdbc.rs.getInt(1)
						,jdbc.rs.getInt(2)
						,jdbc.rs.getInt(3)
						,jdbc.rs.getInt(4)
						,jdbc.rs.getDate(5)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return item;
	}
	
	@Override
	public List<CartItem> selectByIceID(int iceID) { // for admin
		
		List<CartItem> itemList = new ArrayList<>();
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart where ice_ID = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, iceID);
			
			jdbc.rs = jdbc.pstmt.executeQuery();
			
			if (jdbc.rs.next()) {
				CartItem item = new CartItem(
						jdbc.rs.getInt(1)
						,jdbc.rs.getInt(2)
						,jdbc.rs.getInt(3)
						,jdbc.rs.getInt(4)
						,jdbc.rs.getDate(5)
						);
				itemList.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int loggedMemberNo) {
	
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "select * from cart";		
		
		List<CartItem> itemList = new ArrayList<>();
		
	
			try {
				jdbc.pstmt = jdbc.conn.prepareStatement(sql);
				
				jdbc.rs = jdbc.pstmt.executeQuery();
				
				while(jdbc.rs.next()) {
					
					CartItem item = new CartItem(
						jdbc.rs.getInt("id")
						,jdbc.rs.getInt("member_no")
						,jdbc.rs.getInt("ice_ID")
						,jdbc.rs.getInt("quantity")
						,jdbc.rs.getDate("regdate")
							);
						itemList.add(item);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				
				jdbc.close();
			}
			
		return itemList;
	}

	@Override
	public int update(int cartid, int loggedMemberNo, int quantity) {
		
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = new StringBuilder().append("update cart ")
										.append("set quantity = ?")
										.append("where id = ? and member_no = ?").toString();
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			
			jdbc.pstmt.setInt(1, quantity);
			jdbc.pstmt.setInt(2, cartid);
			jdbc.pstmt.setInt(3, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int delete(int cartid, int loggedMemberNo) {
		
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where id = ? and member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartid);
			jdbc.pstmt.setInt(2, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int deleteAll(int loggedMemberNo) {
		
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, loggedMemberNo);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int delete(int cartid) {
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete cart where id = ? and member_no = ?";
		
		try {
			jdbc.pstmt = jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, cartid);
			
			result = jdbc.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			jdbc.close();
		}
		
		return result;
	}

	@Override
	public int deleteByIceID(int iceID) {
		
		int result = 0;
		
		OracleJDBConnection jdbc = new OracleJDBConnection();
		
		String sql = "delete icecream where ice_ID = ?";
			
		try {
			jdbc.conn.prepareStatement(sql);
			jdbc.pstmt.setInt(1, iceID);
			
		result = jdbc.pstmt.executeUpdate();
		} catch (SQLException e) {	
			e.printStackTrace();
		} finally {
			jdbc.close();
		}
		
		return result;
	}
}
