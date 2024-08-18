package icecream;

import java.util.List;

public interface IceDAO {
	
	int insert(Icecream ice);
	
	Icecream select(int id);
	
	List<Icecream> selectAll();
	
	int update(Icecream icecream);
	
	int delete(int id);
}
