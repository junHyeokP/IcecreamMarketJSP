package icecreamMix;

import java.util.Date;

public class IcecreamMix {
	private int mixID;
	private int mixNo;
	private String mixName;
	private int mixCupStock;
	private Date regdate;
	
	public IcecreamMix() {}
	
	public IcecreamMix(int mixID, String mixName, int mixCupStock) {
		this.mixID = mixID;
		this.mixName = mixName;
		this.mixCupStock = mixCupStock;
	}

	public int getMixID() {
		return mixID;
	}

	public void setMixID(int mixID) {
		this.mixID = mixID;
	}

	public int getMixNo() {
		return mixNo;
	}

	public void setMixNo(int mixNo) {
		this.mixNo = mixNo;
	}

	public String getMixName() {
		return mixName;
	}

	public void setMixName(String mixName) {
		this.mixName = mixName;
	}

	public int getMixCupStock() {
		return mixCupStock;
	}

	public void setMixCupStock(int mixCupStock) {
		this.mixCupStock = mixCupStock;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "IcecreamMix [mixID=" + mixID + ", mixNo=" + mixNo + ", mixName=" + mixName + ", mixCupStock="
				+ mixCupStock + ", regdate=" + regdate + "]";
	}
	
}
