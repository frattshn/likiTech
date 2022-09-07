package com.infina.likitech.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Hesap")
public class Hesap {

	private Integer hesapID;
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Integer musteriID;
	private String hesapTuru;
	private BigDecimal hesapBakiye;
	private String portfoyNo;
	private Date hesapAcilisTarihi;

	public Hesap() {
		super();
	}

	public Hesap(Integer hesapID, Integer musteriID, String hesapTuru, BigDecimal hesapBakiye, String portfoyNo,
			Date hesapAcilisTarihi) {
		super();
		this.hesapID = hesapID;
		this.musteriID = musteriID;
		this.hesapTuru = hesapTuru;
		this.hesapBakiye = hesapBakiye;
		this.portfoyNo = portfoyNo;
		this.hesapAcilisTarihi = hesapAcilisTarihi;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public BigDecimal getHesapBakiye() {
		return hesapBakiye;
	}

	public void setHesapBakiye(BigDecimal hesapBakiye) {
		this.hesapBakiye = hesapBakiye;
	}

	public String getPortfoyNo() {
		return portfoyNo;
	}

	public void setPortfoyNo(String portfoyNo) {
		this.portfoyNo = portfoyNo;
	}

	public Date getHesapAcilisTarihi() {
		return hesapAcilisTarihi;
	}

	public void setHesapAcilisTarihi(Date hesapAcilisTarihi) {
		this.hesapAcilisTarihi = hesapAcilisTarihi;
	}

}
