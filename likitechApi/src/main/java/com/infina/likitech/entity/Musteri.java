package com.infina.likitech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infina.likitech.model.MusteriBireyselDto;
import com.infina.likitech.model.MusteriKurumsalDto;

@Entity
@Table(name = "Musteri")
public class Musteri implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2646911938866327794L;

	private Integer musteriID;
	private String musteriDurum;
	private String musteriTipi;
	private String musteriAdi;
	private String musteriSoyadi;
	private String musteriKurumAdi;
	private String musteriVergiNumarasi;
	private String musteriVergiMukellefiyeti;
	private String musteriMaili;
	private String musteriTelefonNo;
	private String musteriSehri;
	private String musteriUyruk;
	private String musteriUlkesi;
	private String musteriAdresi;
	private String musteriTcNoYabanciNo;
	private String musteriBabaAdi;
	private String musteriNufusaKayitliYeri;
	private String musteriDogumYeri;
	private String musteriIkametYeri;

	public Musteri() {
	}

	public Musteri(Integer musteriID, String musteriDurum, String musteriTipi, String musteriAdi, String musteriSoyadi,
			String musteriKurumAdi, String musteriVergiNumarasi, String musteriVergiMukellefiyeti, String musteriMaili,
			String musteriTelefonNo, String musteriSehri, String musteriUyruk, String musteriUlkesi,
			String musteriAdresi, String musteriTcNoYabanciNo, String musteriBabaAdi, String musteriNufusaKayitliYeri,
			String musteriDogumYeri, String musteriIkametYeri) {
		super();
		this.musteriID = musteriID;
		this.musteriDurum = musteriDurum;
		this.musteriTipi = musteriTipi;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
		this.musteriKurumAdi = musteriKurumAdi;
		this.musteriVergiNumarasi = musteriVergiNumarasi;
		this.musteriVergiMukellefiyeti = musteriVergiMukellefiyeti;
		this.musteriMaili = musteriMaili;
		this.musteriTelefonNo = musteriTelefonNo;
		this.musteriSehri = musteriSehri;
		this.musteriUyruk = musteriUyruk;
		this.musteriUlkesi = musteriUlkesi;
		this.musteriAdresi = musteriAdresi;
		this.musteriTcNoYabanciNo = musteriTcNoYabanciNo;
		this.musteriBabaAdi = musteriBabaAdi;
		this.musteriNufusaKayitliYeri = musteriNufusaKayitliYeri;
		this.musteriDogumYeri = musteriDogumYeri;
		this.musteriIkametYeri = musteriIkametYeri;
	}

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Musteri) {
			Musteri oObj = (Musteri) obj;
			if (this.getMusteriID().equals(oObj.getMusteriID())) {
				equal = true;
			}
		}
		return equal;
	}

	public static Musteri ofBireysel(MusteriBireyselDto musteriBireyselDto) {
		Musteri musteri = new Musteri();
		musteri.setMusteriID(musteriBireyselDto.getMusteriID());
		musteri.setMusteriDurum(musteriBireyselDto.getMusteriDurum());
		musteri.setMusteriAdi(musteriBireyselDto.getMusteriAdi());
		musteri.setMusteriSoyadi(musteriBireyselDto.getMusteriSoyadi());
		musteri.setMusteriVergiNumarasi(musteriBireyselDto.getMusteriVergiNumarasi());
		musteri.setMusteriVergiMukellefiyeti(musteriBireyselDto.getMusteriVergiMukellefiyeti());
		musteri.setMusteriMaili(musteriBireyselDto.getMusteriMaili());
		musteri.setMusteriTelefonNo(musteriBireyselDto.getMusteriTelefonNo());
		musteri.setMusteriSehri(musteriBireyselDto.getMusteriSehri());
		musteri.setMusteriUyruk(musteriBireyselDto.getMusteriUyruk());
		musteri.setMusteriUlkesi(musteriBireyselDto.getMusteriUlkesi());
		musteri.setMusteriAdresi(musteriBireyselDto.getMusteriAdresi());
		musteri.setMusteriTcNoYabanciNo(musteriBireyselDto.getMusteriTcNoYabanciNo());
		musteri.setMusteriBabaAdi(musteriBireyselDto.getMusteriBabaAdi());
		musteri.setMusteriNufusaKayitliYeri(musteriBireyselDto.getMusteriNufusaKayitliYeri());
		musteri.setMusteriDogumYeri(musteriBireyselDto.getMusteriDogumYeri());
		musteri.setMusteriIkametYeri(musteriBireyselDto.getMusteriIkametYeri());
		return musteri;
	}

	public static Musteri ofKurumsal(MusteriKurumsalDto musteriKurumsalDto) {
		Musteri musteri = new Musteri();
		musteri.setMusteriID(musteriKurumsalDto.getMusteriID());
		musteri.setMusteriDurum(musteriKurumsalDto.getMusteriDurum());
		musteri.setMusteriKurumAdi(musteriKurumsalDto.getMusteriKurumAdi());
		musteri.setMusteriVergiNumarasi(musteriKurumsalDto.getMusteriVergiNumarasi());
		musteri.setMusteriVergiMukellefiyeti(musteriKurumsalDto.getMusteriVergiMukellefiyeti());
		musteri.setMusteriMaili(musteriKurumsalDto.getMusteriMaili());
		musteri.setMusteriTelefonNo(musteriKurumsalDto.getMusteriTelefonNo());
		musteri.setMusteriSehri(musteriKurumsalDto.getMusteriSehri());
		musteri.setMusteriUlkesi(musteriKurumsalDto.getMusteriUlkesi());
		musteri.setMusteriAdresi(musteriKurumsalDto.getMusteriAdresi());
		return musteri;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public String getMusteriTipi() {
		return musteriTipi;
	}

	public void setMusteriTipi(String musteriTipi) {
		this.musteriTipi = musteriTipi;
	}

	public String getMusteriAdi() {
		return musteriAdi;
	}

	public void setMusteriAdi(String musteriAdi) {
		this.musteriAdi = musteriAdi;
	}

	public String getMusteriSoyadi() {
		return musteriSoyadi;
	}

	public void setMusteriSoyadi(String musteriSoyadi) {
		this.musteriSoyadi = musteriSoyadi;
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

	public String getMusteriUyruk() {
		return musteriUyruk;
	}

	public void setMusteriUyruk(String musteriUyruk) {
		this.musteriUyruk = musteriUyruk;
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

	public String getMusteriTcNoYabanciNo() {
		return musteriTcNoYabanciNo;
	}

	public void setMusteriTcNoYabanciNo(String musteriTcNoYabanciNo) {
		this.musteriTcNoYabanciNo = musteriTcNoYabanciNo;
	}

	public String getMusteriBabaAdi() {
		return musteriBabaAdi;
	}

	public void setMusteriBabaAdi(String musteriBabaAdi) {
		this.musteriBabaAdi = musteriBabaAdi;
	}

	public String getMusteriNufusaKayitliYeri() {
		return musteriNufusaKayitliYeri;
	}

	public void setMusteriNufusaKayitliYeri(String musteriNufusaKayitliYeri) {
		this.musteriNufusaKayitliYeri = musteriNufusaKayitliYeri;
	}

	public String getMusteriDogumYeri() {
		return musteriDogumYeri;
	}

	public void setMusteriDogumYeri(String musteriDogumYeri) {
		this.musteriDogumYeri = musteriDogumYeri;
	}

	public String getMusteriIkametYeri() {
		return musteriIkametYeri;
	}

	public void setMusteriIkametYeri(String musteriIkametYeri) {
		this.musteriIkametYeri = musteriIkametYeri;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
