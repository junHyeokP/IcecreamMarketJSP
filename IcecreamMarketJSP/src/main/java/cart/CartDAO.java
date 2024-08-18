package cart;

import java.util.List;

public interface CartDAO {
	
	// C
	int insert(CartItem item);
	
	//R 
	CartItem select(int cartid, int loggedMemberNo);
	CartItem selectByIceID(int loggedMemberNo, int iceID);
	List<CartItem> selectByIceID(int iceID);
	List<CartItem> selectAll(int loggedMemberNo);
	
	//U
	int update(int cartid, int loggedMemberNo, int quantity);
	
	//D
	int delete(int cartid, int loggedMemberNo);
	int delete(int cartid); 
	
	int deleteByIceID(int iceID);
	int deleteAll(int loggedMemberNo);
}
