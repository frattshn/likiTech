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
@Table(name = "FonFiyat")
public class FonFiyat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5016691016385456268L;
	private Integer fonFiyatID;
	private Integer fonID;
	private BigDecimal fonFiyat;
	private Date fonTarih;

	public FonFiyat() {

	}

	public FonFiyat(Integer fonFiyatID, Integer fonID, BigDecimal fonFiyat, Date fonTarih) {
		super();
		this.fonFiyatID = fonFiyatID;
		this.fonID = fonID;
		this.fonFiyat = fonFiyat;
		this.fonTarih = fonTarih;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFonFiyatID() {
		return fonFiyatID;
	}

	public void setFonFiyatID(Integer fonFiyatID) {
		this.fonFiyatID = fonFiyatID;
	}

	public Integer getFonID() {
		return fonID;
	}

	public void setFonID(Integer fonID) {
		this.fonID = fonID;
	}

	public BigDecimal getFonFiyat() {
		return fonFiyat;
	}

	public void setFonFiyat(BigDecimal fonFiyat) {
		this.fonFiyat = fonFiyat;
	}

	public Date getFonTarih() {
		return fonTarih;
	}

	public void setFonTarih(Date fonTarih) {
		this.fonTarih = fonTarih;
	}

}
