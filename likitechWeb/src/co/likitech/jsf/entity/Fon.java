package co.likitech.jsf.entity;

import java.io.Serializable;

public class Fon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9196377893035108782L;

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
