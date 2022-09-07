package co.likitech.jsf.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import co.likitech.jsf.entity.EmailDetay;
import co.likitech.jsf.entity.Fon;
import co.likitech.jsf.entity.FonFiyat;
import co.likitech.jsf.entity.Hesap;
import co.likitech.jsf.entity.Personel;
import co.likitech.jsf.model.AlimSatimDto;
import co.likitech.jsf.model.HesapDto;
import co.likitech.jsf.model.HesapTop10Dto;
import co.likitech.jsf.model.MusteriBireyselDto;
import co.likitech.jsf.model.MusteriKurumsalDto;

@ManagedBean(name = PersonelService.BEAN_NAME)
@ApplicationScoped
public class PersonelService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6020197178362537761L;
	public static final String BEAN_NAME = "PersonelService";
	private static final String PORT = "http://localhost:9090";

	public Boolean giris(String personelKullaniciAdi, String personelSifresi) {

		String path = "http://localhost:9090/personels/giris/?personelKullaniciAdi=" + personelKullaniciAdi
				+ "&personelSifresi=" + personelSifresi;
		RestTemplate rt = new RestTemplate();
		Boolean girebilirMi = rt.getForObject(path, Boolean.class);

		return girebilirMi;

	}

	public void personelEkle(Personel p) {

		String path = PersonelService.PORT + "/personels";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, p, Personel.class);

	}

	public void personelGuncelle(Personel p) {

		String path = PersonelService.PORT + "/personels/" + p.getPersonelID();
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, p, Personel.class);

	}

	public void personelSil(Personel p) {

		String path = "http://localhost:9090/personels/" + p.getPersonelID();
		RestTemplate rt = new RestTemplate();
		rt.delete(path, p, Personel.class);

	}

	public List<Personel> personelleriGetir() {
		String path = "http://localhost:9090/personels";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Personel[]> responseEntity = rt.getForEntity(path, Personel[].class);
		List<Personel> personeller = Arrays.asList(responseEntity.getBody());
		return personeller;

	}

	public void personelGuncelle(Integer personelID, String personelAdi, String personelSoyadi,
			String personelKullaniciAdi, String personelSifresi, String personelMaili) {
		String path = "http://localhost:9090/personels/" + personelID;
		Personel p = new Personel(personelID, personelAdi, personelSoyadi, personelKullaniciAdi, personelSifresi,
				personelMaili);
		RestTemplate rt = new RestTemplate();
		rt.put(path, p, Personel.class);

	}

	public void musteriBireyselEkle(MusteriBireyselDto m) {

		String path = "http://localhost:9090/personels/musteri/bireysel";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, m, MusteriBireyselDto.class);

	}

	public void musteriBireyselGuncelle(Integer musteriID, String musteriAdi, String musteriSoyadi,
			String musteriVergiNumarasi, String musteriVergiMukellefiyeti, String musteriMaili, String musteriTelefonNo,
			String musteriSehri, String musteriUyruk, String musteriUlkesi, String musteriAdresi,
			String musteriTcNoYabanciNo, String musteriBabaAdi, String musteriNufusaKayitliYeri,
			String musteriDogumYeri, String musteriIkametYeri) {

		String path = "http://localhost:9090/personels/musteri/bireysel/" + musteriID;
		RestTemplate rt = new RestTemplate();
		MusteriBireyselDto m = new MusteriBireyselDto(musteriID, musteriAdi, musteriSoyadi, musteriVergiNumarasi,
				musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri, musteriUyruk, musteriUlkesi,
				musteriAdresi, musteriTcNoYabanciNo, musteriBabaAdi, musteriNufusaKayitliYeri, musteriDogumYeri,
				musteriIkametYeri);
		rt.put(path, m, MusteriBireyselDto.class);

	}

	public List<MusteriBireyselDto> MusteriBireyselGetir() {
		String path = "http://localhost:9090/personels/musteri/bireysel";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<MusteriBireyselDto[]> responseEntity = rt.getForEntity(path, MusteriBireyselDto[].class);
		List<MusteriBireyselDto> musteriBireyseller = Arrays.asList(responseEntity.getBody());
		return musteriBireyseller;

	}

	public void musteriBireyselSil(MusteriBireyselDto m) {

		String path = "http://localhost:9090/personels/musteri/bireysel/2/" + m.getMusteriID();
		RestTemplate rt = new RestTemplate();
		rt.put(path, m, MusteriBireyselDto.class);

	}

	public void musteriKurumsalEkle(MusteriKurumsalDto m) {
		String path = "http://localhost:9090/personels/musteri/kurumsal";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, m, MusteriKurumsalDto.class);

	}

	public void musteriKurumsalGuncelle(Integer musteriID, String musteriKurumAdi, String musteriVergiNumarasi,
			String musteriVergiMukellefiyeti, String musteriMaili, String musteriTelefonNo, String musteriSehri,
			String musteriUlkesi, String musteriAdresi) {
		String path = "http://localhost:9090/personels/musteri/kurumsal/" + musteriID;
		MusteriKurumsalDto m = new MusteriKurumsalDto(musteriID, musteriKurumAdi, musteriVergiNumarasi,
				musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri, musteriUlkesi, musteriAdresi);
		RestTemplate rt = new RestTemplate();
		rt.put(path, m, MusteriKurumsalDto.class);

	}

	public List<MusteriKurumsalDto> MusteriKurumsalGetir() {
		String path = "http://localhost:9090/personels/musteri/kurumsal";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<MusteriKurumsalDto[]> responseEntity = rt.getForEntity(path, MusteriKurumsalDto[].class);
		List<MusteriKurumsalDto> musteriKurumsallar = Arrays.asList(responseEntity.getBody());
		return musteriKurumsallar;

	}

	public void musteriKurumsalSil(MusteriKurumsalDto m) {

		String path = "http://localhost:9090/personels/musteri/kurumsal/2/" + m.getMusteriID();
		RestTemplate rt = new RestTemplate();
		rt.put(path, m, MusteriKurumsalDto.class);

	}

	public void hesapEkle(Hesap h) {

		String path = "http://localhost:9090/personels/musteri/hesap";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, h, Hesap.class);

	}

	public void hesapGuncelle(Integer hesapID, BigDecimal hesapBakiye) {

		String path = "http://localhost:9090/personels/musteri/hesap/" + hesapID + "?hesapBakiye=" + hesapBakiye;
		RestTemplate rt = new RestTemplate();
		rt.put(path, hesapBakiye, Hesap.class);

	}

	public void fonTanim(Fon fon) {
		String path = "http://localhost:9090/personels/fon";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, fon, Fon.class);

	}

	public void fonGuncelle(Integer fonID, String fonAdi, String fonTuru, String fonKodu, String isinKodu) {
		String path = "http://localhost:9090/personels/fon/" + fonID;
		Fon f = new Fon(fonID, fonAdi, fonTuru, fonKodu, isinKodu);
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, f, Fon.class);
	}

	public void fonSil(Fon f) {
		String path = "http://localhost:9090/personels/fon/" + f.getFonID();
		RestTemplate rt = new RestTemplate();
		rt.delete(path, f, Fon.class);

	}

	public List<Fon> fonlariGetir() {
		String path = "http://localhost:9090/personels/fon";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Fon[]> responseEntity = rt.getForEntity(path, Fon[].class);
		List<Fon> fonlar = Arrays.asList(responseEntity.getBody());
		return fonlar;
	}

	public List<Hesap> hesaplariGetir() {
		String path = "http://localhost:9090/personels/hesap";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<Hesap[]> responseEntity = rt.getForEntity(path, Hesap[].class);
		List<Hesap> hesaplar = Arrays.asList(responseEntity.getBody());
		return hesaplar;
	}

	public List<HesapDto> hesapDtolariGetir() {
		String path = "http://localhost:9090/personels/fonAlimSatim/hesap";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<HesapDto[]> responseEntity = rt.getForEntity(path, HesapDto[].class);
		List<HesapDto> hesapDtolar = Arrays.asList(responseEntity.getBody());
		return hesapDtolar;
	}

	public void emailGonder(EmailDetay e) {
		String path = "http://localhost:9090/personels/mail";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, e, EmailDetay.class);
	}

	public void fonFiyatEkle(FonFiyat fiyat) {
		String path = "http://localhost:9090/personels/fonFiyat";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, fiyat, FonFiyat.class);

	}

	public void fonAlimSatim(AlimSatimDto alsat) {
		String path = "http://localhost:9090/personels/fonAlimSatim";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(path, alsat, FonFiyat.class);

	}

	// donut chart için
	public BigDecimal toplamBakiye(String tur) {
		String path = "http://localhost:9090/personels/musteri/bakiye?tur=" + tur;
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(path, BigDecimal.class);
	}

	public List<HesapTop10Dto> top10() {
		String path = "http://localhost:9090/personels/musteri/hesap/top10";
		RestTemplate rt = new RestTemplate();

		ResponseEntity<HesapTop10Dto[]> responseEntity = rt.getForEntity(path, HesapTop10Dto[].class);
		List<HesapTop10Dto> top10 = Arrays.asList(responseEntity.getBody());
		return top10;
	}

}
