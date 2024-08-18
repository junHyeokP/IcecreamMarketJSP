package cart;

import java.util.List;

public interface CartService {
	
	public boolean add(CartItem item);
	
	//CartItem read(int loggedMemberNo);
	List<CartItem> readByIceID(int IceID);
	//CartItem readIceId(int loggedMemberNo, int iceID);
	
	public List<CartItem> listAll(int loggedMemberNo);
	
	public boolean update(int id,int loggedMemberNo, int quantity);
	
	public boolean remove(int id, int loggedMemberNo);
	
	public boolean removeByIceID(int IceID);
	
	public boolean clear(int loggedMemberNo);
	
	
}
