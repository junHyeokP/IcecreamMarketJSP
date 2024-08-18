package cart;

import java.sql.Date;

public class CartItem {
	private int id;
	private int memberNo;
	private int iceID;
	private int quantity;
	private Date addDate;
	
	public CartItem(int memberNo, int id, int quantity) {
		this.memberNo = memberNo;
		this.id = id;
		this.quantity = quantity;
	}
	
	public CartItem(int cartid, int memberNo,  int iceID, int quantity) {
		this.id = cartid;
		this.memberNo = memberNo;
		this.iceID = iceID;
		this.quantity = quantity;
	}
	
	public CartItem(int cartid, int memberNo,  int iceID, int quantity,Date addDate) {
		this.id = cartid;
		this.memberNo = memberNo;
		this.iceID = iceID;
		this.quantity = quantity;
		this.addDate = addDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getIceID() {
		return iceID;
	}

	public void setIceID(int iceID) {
		this.iceID = iceID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", memberNo=" + memberNo + ", iceID=" + iceID + ", quantity=" + quantity
				+ ", addDate=" + addDate + "]";
	}
	
}
