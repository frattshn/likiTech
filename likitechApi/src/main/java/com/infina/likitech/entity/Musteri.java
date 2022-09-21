package com.infina.likitech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infina.likitech.model.MusteriBireyselDto;
import com.infina.likitech.model.MusteriKurumsalDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Musteri")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Musteri implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2646911938866327794L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
