package com.infina.likitech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Fon")
public class Fon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3929689971457659420L;

	private Integer fonID;
	private String fonAdi;
	private String fonTuru;
	private String fonKodu;
	private String isinKodu;

	public Fon() {

	}

	public Fon(Integer fonID, String fonAdi, String fonTuru, String fonKodu, String isinKodu) {
		super();
		this.fonID = fonID;
		this.fonAdi = fonAdi;
		this.fonTuru = fonTuru;
		this.fonKodu = fonKodu;
		this.isinKodu = isinKodu;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFonID() {
		return fonID;
	}

	public void setFonID(Integer fonID) {
		this.fonID = fonID;
	}

	public String getFonAdi() {
		return fonAdi;
	}

	public void setFonAdi(String fonAdi) {
		this.fonAdi = fonAdi;
	}

	public String getFonTuru() {
		return fonTuru;
	}

	public void setFonTuru(String fonTuru) {
		this.fonTuru = fonTuru;
	}

	public String getFonKodu() {
		return fonKodu;
	}

	public void setFonKodu(String fonKodu) {
		this.fonKodu = fonKodu;
	}

	public String getIsinKodu() {
		return isinKodu;
	}

	public void setIsinKodu(String isinKodu) {
		this.isinKodu = isinKodu;
	}

}
