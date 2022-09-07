package com.infina.likitech.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infina.likitech.entity.EmailDetay;
import com.infina.likitech.entity.Fon;
import com.infina.likitech.entity.FonFiyat;
import com.infina.likitech.entity.FonIslem;
import com.infina.likitech.entity.FonStok;
import com.infina.likitech.entity.Hesap;
import com.infina.likitech.entity.Personel;
import com.infina.likitech.exception.FonNotFoundException;
import com.infina.likitech.exception.HesapNotFoundException;
import com.infina.likitech.exception.MusteriAlreadyExistException;
import com.infina.likitech.exception.MusteriNotFoundException;
import com.infina.likitech.exception.NoParamArgumentsException;
import com.infina.likitech.exception.PersonelNotFoundException;
import com.infina.likitech.model.AlimSatimDto;
import com.infina.likitech.model.HesapDto;
import com.infina.likitech.model.HesapTop10Dto;
import com.infina.likitech.model.MusteriBireyselDto;
import com.infina.likitech.model.MusteriKurumsalDto;
import com.infina.likitech.service.EmailService;
import com.infina.likitech.service.FonService;
import com.infina.likitech.service.HesapService;
import com.infina.likitech.service.MusteriService;
import com.infina.likitech.service.PersonelService;

@RestController
@RequestMapping("/personels")
public class PersonelController {

	@Autowired
	private PersonelService personelService;

	@Autowired
	private MusteriService musteriService;

	@Autowired
	private HesapService hesapService;

	@Autowired
	private FonService fonService;

	@Autowired
	private EmailService emailService;

	@GetMapping(value = "/giris")
	public Boolean giris(@RequestParam(value = "personelKullaniciAdi") String personelKullaniciAdi,
			@RequestParam(value = "personelSifresi") String personelSifresi) {
		return personelService.giris(personelKullaniciAdi, personelSifresi);
	}

	@GetMapping()
	public ResponseEntity<List<Personel>> personelListele() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personelService.personelListele());
		} catch (PersonelNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Personel> personelById(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(personelService.personelById(id));
		} catch (PersonelNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping()
	public ResponseEntity<Personel> personelEkle(@RequestBody Personel personel) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(personelService.personelEkle(personel));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Personel> personelSil(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personelService.personelSil(id));
		} catch (PersonelNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Personel> personelGuncelle(@PathVariable Integer id, @RequestBody Personel personel) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personelService.personelGuncelle(id, personel));
		} catch (PersonelNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/guncelle")
	public ResponseEntity<Void> personelGuncelleWithMailPassword(String mail, String sifre, String yeniSifre) {
		try {
			personelService.personelSifreGuncelleWithMail(mail, sifre, yeniSifre);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (PersonelNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// MUSTERI

	@GetMapping("/musteri/bireysel")
	public ResponseEntity<List<MusteriBireyselDto>> musteriBireyselListele() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriBireyselListele());
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/musteri/kurumsal")
	public ResponseEntity<List<MusteriKurumsalDto>> musteriKurumsalListele() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriKurumsalListele());
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/musteri/bireysel/{id}")
	public ResponseEntity<MusteriBireyselDto> musteriBireyselById(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriBireyselById(id));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/musteri/kurumsal/{id}")
	public ResponseEntity<MusteriKurumsalDto> musteriKurumsalById(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriKurumsalById(id));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/musteri/bireysel")
	public ResponseEntity<MusteriBireyselDto> musteriBireyselEkle(@RequestBody MusteriBireyselDto musteriBireyselDto) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(musteriService.musteriBireyselEkle(musteriBireyselDto));
		} catch (MusteriAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PostMapping("/musteri/kurumsal")
	public ResponseEntity<MusteriKurumsalDto> musteriKurumsalEkle(@RequestBody MusteriKurumsalDto musteriKurumsalDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriKurumsalEkle(musteriKurumsalDto));
		} catch (MusteriAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@PutMapping("/musteri/bireysel/2/{id}")
	public ResponseEntity<MusteriBireyselDto> musteriBireyselSetDurum(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriBireyselSetDurum(id));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/musteri/kurumsal/2/{id}")
	public ResponseEntity<MusteriKurumsalDto> musteriKurumsalSetDurum(@PathVariable Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(musteriService.musteriKurumsalSetDurum(id));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/musteri/bireysel/{id}")
	public ResponseEntity<MusteriBireyselDto> musteriBireyselGuncelle(@PathVariable Integer id,
			@RequestBody MusteriBireyselDto musteriBireyselDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(musteriService.musteriBireyselGuncelle(id, musteriBireyselDto));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/musteri/kurumsal/{id}")
	public ResponseEntity<MusteriKurumsalDto> musteriKurumsalGuncelle(@PathVariable Integer id,
			@RequestBody MusteriKurumsalDto musteriKurumsalDto) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(musteriService.musteriKurumsalGuncelle(id, musteriKurumsalDto));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// HESAP

	@GetMapping("/hesap")
	public ResponseEntity<List<Hesap>> hesaplariGetirTum() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesaplariGetirTum());
		} catch (HesapNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/musteri/bireysel/hesap")
	public ResponseEntity<List<Hesap>> hesapGetirBireysel(Integer musteriID) {
		return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapByMusteriID(musteriID));
	}

	@GetMapping("/musteri/kurumsal/hesap")
	public ResponseEntity<List<Hesap>> hesapGetirKurumsal(Integer musteriID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapByMusteriID(musteriID));
		} catch (HesapNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/musteri/hesap/top10")
	public ResponseEntity<List<HesapTop10Dto>> hesapTop10Getir() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapTop10());
		} catch (HesapNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/musteri/hesap")
	public ResponseEntity<Hesap> hesapEkleBireysel(@RequestBody Hesap hesap) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapEkle(hesap));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/musteri/bireysel/hesap")
	public ResponseEntity<Hesap> hesapSilBireysel(Integer hesapID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapSil(hesapID));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@DeleteMapping("/musteri/kurumsal/hesap")
	public ResponseEntity<Hesap> hesapSilKurumsal(Integer hesapID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(hesapService.hesapSil(hesapID));
		} catch (MusteriNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// HAVALE PROVİZYON

	@PutMapping("/musteri/hesap/{hesapID}")
	public Hesap hesapGuncelle(@PathVariable String hesapID, @RequestParam BigDecimal hesapBakiye) {
		return hesapService.hesapBakiyeGuncelleHP(hesapBakiye, Integer.valueOf(hesapID));
	}

	// FON STOK

	@GetMapping("/fonStok/{fonStokID}")
	public FonStok fonStokByFonStokID(@PathVariable Integer fonStokID) {
		return fonService.fonStokByFonStokID(fonStokID);
	}

	@GetMapping("/fonStok") // ?hesapID=5
	public List<FonStok> fonStokByHesapFonID(@RequestParam(required = false) Integer hesapID,
			@RequestParam(required = false) Integer fonID) {
		if (hesapID == null) {
			if (fonID != null) {
				return fonService.fonStokByFonID(fonID);
			}
			return fonService.fonStokByHesapID(hesapID);
		}
		throw new NoParamArgumentsException();
	}

	@PostMapping("/fonStok")
	public FonStok fonStokEkle(@RequestBody FonStok fonStok) {
		return fonService.fonStokEkle(fonStok);
	}

	@DeleteMapping("/fonStok/{fonStokID}")
	public FonStok fonStokSil(@PathVariable Integer fonStokID) {
		return fonService.fonStokSil(fonStokID);
	}

	@PutMapping("/fonStok/{fonStokID}")
	public FonStok fonStokGuncelle(@RequestBody FonStok fonStok, @PathVariable Integer fonStokID) {
		return fonService.fonStokGuncelle(fonStok, fonStokID);
	}

	// FON

	@GetMapping("/fon/{fonID}")
	public Fon fonByFonID(@PathVariable Integer fonID) {
		return fonService.fonByFonID(fonID);
	}

	@GetMapping("/fon")
	public ResponseEntity<List<Fon>> fonListele() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonListele());
		} catch (FonNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/fon")
	public Fon fonEkle(@RequestBody Fon fon) {
		return fonService.fonEkle(fon);
	}

	@DeleteMapping("/fon/{fonID}")
	public Fon fonSil(@PathVariable Integer fonID) {
		return fonService.fonSil(fonID);
	}

	@PutMapping("/fon/{fonID}")
	public Fon fonGuncelle(@RequestBody Fon fon, @PathVariable Integer fonID) {
		return fonService.fonGuncelle(fon, fonID);
	}

	// FON ISLEM

	@GetMapping("/fonIslem/{fonIslemID}")
	public FonIslem fonIslemByFonIslemID(@PathVariable Integer fonIslemID) {
		return fonService.fonIslemByFonIslemID(fonIslemID);
	}

	@GetMapping("/fonIslem")
	public List<FonIslem> fonIslemByHesapID(@RequestParam(name = "hesapID") Integer hesapID) {
		return fonService.fonIslemByHesapID(hesapID);
	}

	@PostMapping("/fonIslem")
	public FonIslem fonIslemEkle(@RequestBody FonIslem fonIslem) {
		return fonService.fonIslemEkle(fonIslem);
	}

	@DeleteMapping("/fonIslem/{fonIslemID}")
	public FonIslem fonIslemSil(@PathVariable Integer fonIslemID) {
		return fonService.fonIslemSil(fonIslemID);
	}

	// FON FIYAT

	@PostMapping("/fonFiyat")
	public FonFiyat fonFiyatEkle(@RequestBody FonFiyat fonFiyat) {
		return fonService.fonFiyatEkle(fonFiyat);
	}

	// HESAP DTO

	@GetMapping("/fonAlimSatim/hesap")
	public List<HesapDto> hesapDtoGetir() {
		return fonService.hesapDtoGetir();
	}

	// FON ALIM SATIM

	@PostMapping("/fonAlimSatim")
	public Map<String, Boolean> fonAlimSatim(@RequestBody AlimSatimDto alimSatim) {
		return fonService.fonAlimSatim(alimSatim);
	}

	// TOLAM BAKIYELER

	@GetMapping("/musteri/bakiye")
	public BigDecimal toplamBakiyeGetir(@RequestParam String tur) {
		if (tur.equals("TL")) {
			return hesapService.toplamTLBakiyeGetir();
		} else if (tur.equals("USD")) {
			return hesapService.toplamUSDBakiyeGetir();
		} else if (tur.equals("EURO")) {
			return hesapService.toplamEUROBakiyeGetir();
		} else {
			throw new NoParamArgumentsException();
		}
	}

	// MAIL
	@PostMapping("/mail")
	public String mailGonder(@RequestBody EmailDetay emailDetay) {

		return emailService.mailGonder(emailDetay);

	}

	@PutMapping("/mail")
	public void sifreSifirlama(@RequestParam String mail, @RequestParam String sifre, @RequestParam String yeniSifre) {
		personelService.personelSifreGuncelleWithMail(mail, sifre, yeniSifre);
	}

	@ExceptionHandler(PersonelNotFoundException.class)
	public ResponseEntity<String> handlePersonelNotFoundException(PersonelNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}