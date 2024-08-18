package icecream;

import java.util.Date;

public class Icecream {
	
	private int iceID;
	private String name;
	private int price;
	private Date regDate;
	
	public Icecream() {}
	
	public Icecream(String name,int price) {
		this.name = name;
		this.price = price;
	}

	public int getIceID() {
		return iceID +1;
	}

	public void setIceID(int iceID) {
		this.iceID = iceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Icecream [iceID=" + iceID + ", name=" + name + ", price=" + price +
			   ", regDate=" + regDate + "]";
	}

	
	
}
