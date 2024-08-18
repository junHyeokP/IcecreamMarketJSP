package icecream;

import java.util.List;

import cart.CartItem;
import cart.CartService;
import cart.HashMapCartDAO;
import cart.OracleCartService;

public class OracleIceService implements IceService {
	
	IceDAO iceDao;
	
	public OracleIceService(IceDAO iceDao) {
			this.iceDao = iceDao;
	}

	@Override
	public boolean add(Icecream ice) {
		if (ice == null) return false;
		int result = iceDao.insert(ice);
		return (result == 1)? true : false;
	}

	@Override
	public Icecream load(int iceID) {
		Icecream ice = iceDao.select(iceID);
		return ice;
	}

	@Override
	public List<Icecream> listAll() {
		List<Icecream> iceList = iceDao.selectAll();
		return iceList;
	}

	@Override
	public boolean edit(Icecream ice) {
		if (ice == null) return false;
		int result = iceDao.update(ice);
		return (result == 1) ? true : false;
	}

	@Override
	public boolean remove(int iceID) {
		
		if (iceDao.select(iceID) == null) return false;

		int result = 0;
		//** CartService cartService = new HJCartService(new OracleCartDAO());
		CartService cartService = new OracleCartService(new HashMapCartDAO());
		List<CartItem> itemList = cartService.readByIceID(iceID);
		if (itemList.size() > 0) {
			cartService.removeByIceID(iceID);
		}
		
		result = iceDao.delete(iceID);
		return (result == 1) ? true : false;
	}	

}
