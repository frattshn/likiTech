package com.infina.likitech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FonStok")
public class FonStok implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140019690610605949L;

	private Integer fonStokID;
	private Integer hesapID;
	private Integer fonID;
	private Integer stokMiktari;

	public FonStok() {

	}

	public FonStok(Integer fonStokID, Integer hesapID, Integer fonID, Integer stokMiktari) {
		super();
		this.fonStokID = fonStokID;
		this.hesapID = hesapID;
		this.fonID = fonID;
		this.stokMiktari = stokMiktari;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getFonStokID() {
		return fonStokID;
	}

	public void setFonStokID(Integer fonStokID) {
		this.fonStokID = fonStokID;
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

	public Integer getStokMiktari() {
		return stokMiktari;
	}

	public void setStokMiktari(Integer stokMiktari) {
		this.stokMiktari = stokMiktari;
	}

	

}
