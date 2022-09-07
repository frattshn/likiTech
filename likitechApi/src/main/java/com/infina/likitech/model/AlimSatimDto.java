package com.infina.likitech.model;

import java.io.Serializable;

public class AlimSatimDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3586633421769520691L;

	private Integer hesapID;
	private Boolean alSat;
	private Integer fonID;
	private Integer fonAdet;

	public AlimSatimDto() {

	}

	public AlimSatimDto(Integer hesapID, Boolean alSat, Integer fonID, Integer fonAdet) {
		super();
		this.hesapID = hesapID;
		this.alSat = alSat;
		this.fonID = fonID;
		this.fonAdet = fonAdet;
	}

	public Integer getHesapID() {
		return hesapID;
	}

	public void setHesapID(Integer hesapID) {
		this.hesapID = hesapID;
	}

	public Boolean getAlSat() {
		return alSat;
	}

	public void setAlSat(Boolean alSat) {
		this.alSat = alSat;
	}

	public Integer getFonID() {
		return fonID;
	}

	public void setFonID(Integer fonID) {
		this.fonID = fonID;
	}

	public Integer getFonAdet() {
		return fonAdet;
	}

	public void setFonAdet(Integer fonAdet) {
		this.fonAdet = fonAdet;
	}

}
