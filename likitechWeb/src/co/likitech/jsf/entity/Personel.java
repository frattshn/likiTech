package co.likitech.jsf.entity;

import java.io.Serializable;

public class Personel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer personelID;

	private String personelAdi;
	private String personelSoyadi;
	private String personelKullaniciAdi;
	private String personelSifresi;
	private String personelMaili;

	public Personel() {
	}

	public Personel(Integer personelID, String personelAdi, String personelSoyadi, String personelKullaniciAdi,
			String personelSifresi, String personelMaili) {
		super();
		this.personelID = personelID;
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
		this.personelKullaniciAdi = personelKullaniciAdi;
		this.personelSifresi = personelSifresi;
		this.personelMaili = personelMaili;
	}

	public Integer getPersonelID() {
		return personelID;
	}

	public void setPersonelID(Integer personelID) {
		this.personelID = personelID;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

	public String getPersonelKullaniciAdi() {
		return personelKullaniciAdi;
	}

	public void setPersonelKullaniciAdi(String personelKullaniciAdi) {
		this.personelKullaniciAdi = personelKullaniciAdi;
	}

	public String getPersonelSifresi() {
		return personelSifresi;
	}

	public void setPersonelSifresi(String personelSifresi) {
		this.personelSifresi = personelSifresi;
	}

	public String getPersonelMaili() {
		return personelMaili;
	}

	public void setPersonelMaili(String personelMaili) {
		this.personelMaili = personelMaili;
	}

}
