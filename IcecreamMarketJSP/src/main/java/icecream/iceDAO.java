package icecream;

import java.util.List;

public interface iceDAO {
	
	int insert(Icecream ice);
	
	Icecream select(int id);
	
	List<Icecream> selecAll();
	
	int update(Icecream icecream);
	
	int delete(int id);
}
