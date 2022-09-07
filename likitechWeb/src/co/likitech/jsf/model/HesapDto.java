package co.likitech.jsf.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class HesapDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8054789121010312128L;

	private Integer hesapID;
	private String portfoyNo;
	private String musteriAdi;
	private BigDecimal hesapBakiye;
	private String hesapTuru;

	public HesapDto() {

	}

	public HesapDto(Integer hesapID, String portfoyNo, String musteriAdi, BigDecimal hesapBakiye, String hesapTuru) {
		super();
		this.hesapID = hesapID;
		this.portfoyNo = portfoyNo;
		this.musteriAdi = musteriAdi;
		this.hesapBakiye = hesapBakiye;
		this.hesapTuru = hesapTuru;
	}

	public String getPortfoyNo() {
		return portfoyNo;
	}

	public void setPortfoyNo(String portfoyNo) {
		this.portfoyNo = portfoyNo;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public BigDecimal getHesapBakiye() {
		return hesapBakiye;
	}

	public void setHesapBakiye(BigDecimal hesapBakiye) {
		this.hesapBakiye = hesapBakiye;
	}

	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

}
