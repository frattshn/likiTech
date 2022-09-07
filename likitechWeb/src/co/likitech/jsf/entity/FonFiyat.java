package co.likitech.jsf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import co.likitech.jsf.model.MusteriKurumsalDto;
import co.likitech.jsf.service.PersonelService;

public class FonFiyat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7269294120428308456L;

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
