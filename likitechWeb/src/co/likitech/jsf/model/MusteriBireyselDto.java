package co.likitech.jsf.model;

import java.io.Serializable;

import co.likitech.jsf.entity.Musteri;

public class MusteriBireyselDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7964609201975828669L;

	private Integer musteriID;
	private String musteriAdi;
	private String musteriSoyadi;
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

	public MusteriBireyselDto() {

	}
	
	public MusteriBireyselDto(Integer musteriID, String musteriAdi, String musteriSoyadi, String musteriVergiNumarasi,
			String musteriVergiMukellefiyeti, String musteriMaili, String musteriTelefonNo, String musteriSehri,
			String musteriUyruk, String musteriUlkesi, String musteriAdresi, String musteriTcNoYabanciNo,
			String musteriBabaAdi, String musteriNufusaKayitliYeri, String musteriDogumYeri, String musteriIkametYeri) {
		super();
		this.musteriID = musteriID;
		this.musteriAdi = musteriAdi;
		this.musteriSoyadi = musteriSoyadi;
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

	public static MusteriBireyselDto of(Musteri musteri) {
		return new MusteriBireyselDto(musteri.getMusteriID(), musteri.getMusteriAdi(), musteri.getMusteriSoyadi(),
				musteri.getMusteriVergiNumarasi(), musteri.getMusteriVergiMukellefiyeti(), musteri.getMusteriMaili(),
				musteri.getMusteriTelefonNo(), musteri.getMusteriSehri(), musteri.getMusteriUyruk(),
				musteri.getMusteriUlkesi(), musteri.getMusteriAdresi(), musteri.getMusteriTcNoYabanciNo(),
				musteri.getMusteriBabaAdi(), musteri.getMusteriNufusaKayitliYeri(), musteri.getMusteriDogumYeri(),
				musteri.getMusteriIkametYeri());
	}

	public Integer getMusteriID() {
		return musteriID;
	}

	public void setMusteriID(Integer musteriID) {
		this.musteriID = musteriID;
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

}
