package com.infina.likitech.model;

import com.infina.likitech.entity.Musteri;

public class MusteriKurumsalDto {

	private Integer musteriID;
	private String musteriDurum;
	private String musteriKurumAdi;
	private String musteriVergiNumarasi;
	private String musteriVergiMukellefiyeti;
	private String musteriMaili;
	private String musteriTelefonNo;
	private String musteriSehri;
	private String musteriUlkesi;
	private String musteriAdresi;

	public MusteriKurumsalDto() {

	}

	public MusteriKurumsalDto(Integer musteriID, String musteriDurum, String musteriKurumAdi,
			String musteriVergiNumarasi, String musteriVergiMukellefiyeti, String musteriMaili, String musteriTelefonNo,
			String musteriSehri, String musteriUlkesi, String musteriAdresi) {
		super();
		this.musteriID = musteriID;
		this.musteriDurum = musteriDurum;
		this.musteriKurumAdi = musteriKurumAdi;
		this.musteriVergiNumarasi = musteriVergiNumarasi;
		this.musteriVergiMukellefiyeti = musteriVergiMukellefiyeti;
		this.musteriMaili = musteriMaili;
		this.musteriTelefonNo = musteriTelefonNo;
		this.musteriSehri = musteriSehri;
		this.musteriUlkesi = musteriUlkesi;
		this.musteriAdresi = musteriAdresi;

	}

	public static MusteriKurumsalDto of(Musteri musteri) {
		return new MusteriKurumsalDto(musteri.getMusteriID(), musteri.getMusteriDurum(), musteri.getMusteriKurumAdi(),
				musteri.getMusteriVergiNumarasi(), musteri.getMusteriVergiMukellefiyeti(), musteri.getMusteriMaili(),
				musteri.getMusteriTelefonNo(), musteri.getMusteriSehri(), musteri.getMusteriUlkesi(),
				musteri.getMusteriAdresi());
	}

	public Integer getMusteriID() {
		return musteriID;
	}

	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
	}

	public String getMusteriDurum() {
		return musteriDurum;
	}

	public void setMusteriDurum(String musteriDurum) {
		this.musteriDurum = musteriDurum;
	}

	public String getMusteriKurumAdi() {
		return musteriKurumAdi;
	}

	public void setMusteriKurumAdi(String musteriKurumAdi) {
		this.musteriKurumAdi = musteriKurumAdi;
	}

	public String getMusteriVergiNumarasi() {
		return musteriVergiNumarasi;
	}

	public void setMusteriVergiNumarasi(String musteriVergiNumarasi) {
		this.musteriVergiNumarasi = musteriVergiNumarasi;
	}

	public String getMusteriVergiMukellefiyeti() {
		return musteriVergiMukellefiyeti;
	}

	public void setMusteriVergiMukellefiyeti(String musteriVergiMukellefiyeti) {
		this.musteriVergiMukellefiyeti = musteriVergiMukellefiyeti;
	}

	public String getMusteriMaili() {
		return musteriMaili;
	}

	public void setMusteriMaili(String musteriMaili) {
		this.musteriMaili = musteriMaili;
	}

	public String getMusteriTelefonNo() {
		return musteriTelefonNo;
	}

	public void setMusteriTelefonNo(String musteriTelefonNo) {
		this.musteriTelefonNo = musteriTelefonNo;
	}

	public String getMusteriSehri() {
		return musteriSehri;
	}

	public void setMusteriSehri(String musteriSehri) {
		this.musteriSehri = musteriSehri;
	}

	public String getMusteriUlkesi() {
		return musteriUlkesi;
	}

	public void setMusteriUlkesi(String musteriUlkesi) {
		this.musteriUlkesi = musteriUlkesi;
	}

	public String getMusteriAdresi() {
		return musteriAdresi;
	}

	public void setMusteriAdresi(String musteriAdresi) {
		this.musteriAdresi = musteriAdresi;
	}

}
