package com.infina.likitech.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class HesapTop10Dto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4199349150796904915L;

	private Integer hesapID;
	private String musteriAdi;
	private BigDecimal hesapBakiyesi;
	private String hesapTuru;

	public HesapTop10Dto() {
		super();
	}

	public HesapTop10Dto(Integer hesapID, String musteriAdi, BigDecimal hesapBakiyesi, String hesapTuru) {
		super();
		this.hesapID = hesapID;
		this.musteriAdi = musteriAdi;
		this.hesapBakiyesi = hesapBakiyesi;
		this.hesapTuru = hesapTuru;
	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public BigDecimal getHesapBakiyesi() {
		return hesapBakiyesi;
	}

	public void setHesapBakiyesi(BigDecimal hesapBakiyesi) {
		this.hesapBakiyesi = hesapBakiyesi;
	}

	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
