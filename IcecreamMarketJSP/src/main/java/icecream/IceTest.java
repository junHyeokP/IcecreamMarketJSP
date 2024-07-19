package icecream;

public class IceTest {

	public static void main(String[] args) {
		
		iceDAO iceDao = new OracleIcecreamDAO();
		
		Icecream ice = new Icecream("메로나", 1200);
		
		iceDao.insert(ice);
	}

}
