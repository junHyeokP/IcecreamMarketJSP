package icecream;

public class IceTest {

	public static void main(String[] args) {
		
		IceService service = new OracleIceService(new OracleIceDAO());
     	Icecream ice = service.load(1);
		
		if (ice == null) {
		System.out.println("null");
		
		} else {
		System.out.println(ice.getIceID());	
		}
		
		if (service.remove(ice.getIceID())) {
			System.out.println("삭제성공");
		} else {
			System.out.println(0);
		}
		
	}

}
