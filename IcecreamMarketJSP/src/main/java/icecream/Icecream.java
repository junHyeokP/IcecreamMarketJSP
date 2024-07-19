package icecream;

import java.util.Date;

public class Icecream {
	
	private int iceNo;
	private String name;
	private int price;
	private int instock = 10;
	private Date regDate;
	
	public Icecream() {}
	
	public Icecream(String name,int price) {
		this.name = name;
		this.price = price;
	}

	public int getIceNo() {
		return iceNo;
	}

	public void setIceNo(int iceNo) {
		this.iceNo = iceNo;
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

	public int getInstock() {
		return instock;
	}

	public void setInstock(int instock) {
		this.instock = instock;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Icecream [iceNo=" + iceNo + ", name=" + name + ", price=" + price + ", instock=" + instock
				+ ", regDate=" + regDate + "]";
	}

	
	
}
