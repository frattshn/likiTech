package co.likitech.jsf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Hesap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6203688895178328932L;

	private Integer hesapID;
	private Integer musteriID;
	private String hesapTuru;
	private String portfoyNo;
	private Date hesapAcilisTarihi;
	private BigDecimal hesapBakiye;

	public Hesap() {
	}

	public Hesap(Integer hesapID, Integer musteriID, String hesapTuru, String portfoyNo, Date hesapAcilisTarihi,
			BigDecimal hesapBakiye) {
		super();
		this.hesapID = hesapID;
		this.musteriID = musteriID;
		this.hesapTuru = hesapTuru;
		this.portfoyNo = portfoyNo;
		this.hesapAcilisTarihi = hesapAcilisTarihi;
		this.hesapBakiye = hesapBakiye;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Hesap) {
			Hesap oObj = (Hesap) obj;
			if (this.getHesapID().equals(oObj.getHesapID())) {
				equal = true;
			}
		}
		return equal;
	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

	public Integer getMusteriID() {
		return musteriID;
	}

	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
	}

	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}

	public String getPortfoyNo() {
		return portfoyNo;
	}

	public void setPortfoyNo(String portfoyNo) {
		this.portfoyNo = portfoyNo;
	}

	
	public BigDecimal getHesapBakiye() {
		return hesapBakiye;
	}

	public void setHesapBakiye(BigDecimal hesapBakiye) {
		this.hesapBakiye = hesapBakiye;
	}

	public Date getHesapAcilisTarihi() {
		return hesapAcilisTarihi;
	}

	public void setHesapAcilisTarihi(Date hesapAcilisTarihi) {
		this.hesapAcilisTarihi = hesapAcilisTarihi;
	}

}
