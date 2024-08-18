package cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapCartDAO implements CartDAO {
	
	static private HashMap<Integer, CartItem> cartTable = new HashMap<>();
	static private int cart_seq = 0;

	@Override
	public int insert(CartItem item) {
		
		int result = 0;
		
		item.setId(++cart_seq);
		cartTable.put(cart_seq, item);
		result++;
		
		return result;
	}

	@Override
	public CartItem select(int cartid, int loggedMemberNo) {
		
		CartItem item = cartTable.get(cartid);
		
		if(item.getMemberNo() == loggedMemberNo) return item;

		return null;
	}

	@Override
	public CartItem selectByIceID(int loggedMemberNo, int iceID) {
		List<CartItem> itemList = selectAll(loggedMemberNo);
		
		if(itemList.size() == 0) return null;
		
		for (CartItem item : itemList) {
			if (item.getIceID() == iceID) return item;
		}
		
		return null;
	}

	@Override
	public List<CartItem> selectByIceID(int iceID) {
		List<CartItem> itemList = new ArrayList<>();
		
		for (CartItem item : cartTable.values()) {
			if (item.getIceID() == iceID) {
				itemList.add(item);
			}
		}
		
		return itemList;
	}

	@Override
	public List<CartItem> selectAll(int loggedMemberNo) {
		
		List<CartItem> itemList = new ArrayList<>();
		
		for (CartItem item : cartTable.values()) {
			if (item.getMemberNo() == loggedMemberNo)
				itemList.add(item);
		}
		
		return itemList;
	}

	@Override
	public int update(int cartid, int loggedMemberNo, int quantity) {
		// 장바구니 아이템의 수량을 update
		
		CartItem item = cartTable.get(cartid);
		if (item == null) return 0;
		
		if (item.getMemberNo() != loggedMemberNo) return 0;
		
		item.setQuantity(quantity);
		
		return 1;
	}

	@Override
	public int delete(int cartid, int loggedMemberNo) {
		
		CartItem item = cartTable.get(cartid);
		if(item != null && item.getMemberNo() == loggedMemberNo) {
		cartTable.remove(cartid);
		return 1;
		}
		
		return 0;
	}

	@Override
	public int delete(int cartid) {
		List<CartItem> itemList = selectByIceID(cartid);
		for (CartItem item : itemList) {
			cartTable.remove(item.getId());
		}
		return 0;
	}
	
	@Override
	public int deleteByIceID(int IceID) {
		int result = 0;
		// 어째선지 작동이 안됨
//		List<CartItem> itemList = selectByBookId(iceID);
//		for (CartItem item : itemList) {
//			cartTable.remove(item.getId());
//			result++;
//		}
		
		return result;
	}

	@Override
	public int deleteAll(int loggedMemberNo) {
		int result = 0;
		
		List<CartItem> itemList = selectByIceID(loggedMemberNo);
		for (CartItem item : itemList) {
			cartTable.remove(item.getId());
			result++;
		}
		return result;
	}

}
