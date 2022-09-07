package com.infina.likitech.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FonIslem")
public class FonIslem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940969785390140107L;

	private Integer fonIslemID;
	private Integer hesapID;
	private Integer fonID;
	private Date islemTarihi;
	private Integer fonMiktari;
	private BigDecimal fonBirimFiyati;

	public FonIslem() {

	}

	public FonIslem(Integer fonIslemID, Integer hesapID, Integer fonID, Date islemTarihi, Integer fonMiktari,
			BigDecimal fonBirimFiyati) {
		super();
		this.fonIslemID = fonIslemID;
		this.hesapID = hesapID;
		this.fonID = fonID;
		this.islemTarihi = islemTarihi;
		this.fonMiktari = fonMiktari;
		this.fonBirimFiyati = fonBirimFiyati;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFonIslemID() {
		return fonIslemID;
	}

	public void setFonIslemID(Integer fonIslemID) {
		this.fonIslemID = fonIslemID;
	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

	public Integer getFonID() {
		return fonID;
	}

	public void setFonID(Integer fonID) {
		this.fonID = fonID;
	}

	public Date getIslemTarihi() {
		return islemTarihi;
	}

	public void setIslemTarihi(Date islemTarihi) {
		this.islemTarihi = islemTarihi;
	}

	public Integer getFonMiktari() {
		return fonMiktari;
	}

	public void setFonMiktari(Integer fonMiktari) {
		this.fonMiktari = fonMiktari;
	}

	public BigDecimal getFonBirimFiyati() {
		return fonBirimFiyati;
	}

	public void setFonBirimFiyati(BigDecimal fonBirimFiyati) {
		this.fonBirimFiyati = fonBirimFiyati;
	}

}
