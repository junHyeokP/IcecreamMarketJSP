package icecream;

import java.util.List;

public interface IceService {
	
	boolean add(Icecream ice);
	
	Icecream load(int iceID);
	
	List<Icecream> listAll();
	
	boolean edit(Icecream ice);
	
	boolean remove(int iceID);
}
