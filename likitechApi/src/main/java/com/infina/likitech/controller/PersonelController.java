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
import com.infina.likitech.exception.FonCouldntAddException;
import com.infina.likitech.exception.FonCouldntUpdatedException;
import com.infina.likitech.exception.FonFiyatCouldntAddException;
import com.infina.likitech.exception.FonIslemCouldntAddException;
import com.infina.likitech.exception.FonIslemNotFoundException;
import com.infina.likitech.exception.FonNotFoundException;
import com.infina.likitech.exception.FonStokCouldntAddException;
import com.infina.likitech.exception.FonStokCouldntUpdatedException;
import com.infina.likitech.exception.FonStokNotFoundException;
import com.infina.likitech.exception.HesapDtoNotFoundException;
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
	public ResponseEntity<Hesap> hesapGuncelle(@PathVariable String hesapID, @RequestParam BigDecimal hesapBakiye) {
		try {
			return ResponseEntity.status(HttpStatus.OK)
					.body(hesapService.hesapBakiyeGuncelleHP(hesapBakiye, Integer.valueOf(hesapID)));
		} catch (HesapNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// FON STOK

	@GetMapping("/fonStok/{fonStokID}")
	public ResponseEntity<FonStok> fonStokByFonStokID(@PathVariable Integer fonStokID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokByFonStokID(fonStokID));
		} catch (FonStokNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/fonStok") // ?hesapID=5
	public ResponseEntity<List<FonStok>> fonStokByHesapFonID(@RequestParam(required = false) Integer hesapID,
			@RequestParam(required = false) Integer fonID) {
		try {
			if (hesapID == null) {
				if (fonID != null) {
					return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokByFonID(fonID));
				}
				return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokByHesapID(hesapID));
			}
			throw new NoParamArgumentsException();
		} catch (FonStokNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/fonStok")
	public ResponseEntity<FonStok> fonStokEkle(@RequestBody FonStok fonStok) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokEkle(fonStok));
		} catch (FonStokCouldntAddException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/fonStok/{fonStokID}")
	public ResponseEntity<FonStok> fonStokSil(@PathVariable Integer fonStokID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokSil(fonStokID));
		} catch (FonStokNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PutMapping("/fonStok/{fonStokID}")
	public ResponseEntity<FonStok> fonStokGuncelle(@RequestBody FonStok fonStok, @PathVariable Integer fonStokID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonStokGuncelle(fonStok, fonStokID));
		} catch (FonStokCouldntUpdatedException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (FonStokNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// FON

	@GetMapping("/fon/{fonID}")
	public ResponseEntity<Fon> fonByFonID(@PathVariable Integer fonID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonByFonID(fonID));
		} catch (FonNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
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
	public ResponseEntity<Fon> fonEkle(@RequestBody Fon fon) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonEkle(fon));
		} catch (FonCouldntAddException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	@DeleteMapping("/fon/{fonID}")
	public ResponseEntity<Fon> fonSil(@PathVariable Integer fonID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonSil(fonID));
		} catch (FonNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@PutMapping("/fon/{fonID}")
	public ResponseEntity<Fon> fonGuncelle(@RequestBody Fon fon, @PathVariable Integer fonID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonGuncelle(fon, fonID));
		} catch (FonCouldntUpdatedException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} catch (FonNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// FON ISLEM

	@GetMapping("/fonIslem/{fonIslemID}")
	public ResponseEntity<FonIslem> fonIslemByFonIslemID(@PathVariable Integer fonIslemID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonIslemByFonIslemID(fonIslemID));
		} catch (FonIslemNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/fonIslem")
	public ResponseEntity<List<FonIslem>> fonIslemByHesapID(@RequestParam(name = "hesapID") Integer hesapID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonIslemByHesapID(hesapID));
		} catch (FonIslemNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}

	}

	@PostMapping("/fonIslem")
	public ResponseEntity<FonIslem> fonIslemEkle(@RequestBody FonIslem fonIslem) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonIslemEkle(fonIslem));
		} catch (FonIslemCouldntAddException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

	@DeleteMapping("/fonIslem/{fonIslemID}")
	public ResponseEntity<FonIslem> fonIslemSil(@PathVariable Integer fonIslemID) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonIslemSil(fonIslemID));
		} catch (FonIslemNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// FON FIYAT

	@PostMapping("/fonFiyat")
	public ResponseEntity<FonFiyat> fonFiyatEkle(@RequestBody FonFiyat fonFiyat) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.fonFiyatEkle(fonFiyat));
		} catch (FonFiyatCouldntAddException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}

	// HESAP DTO

	@GetMapping("/fonAlimSatim/hesap")
	public ResponseEntity<List<HesapDto>> hesapDtoGetir() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(fonService.hesapDtoGetir());
		} catch (HesapDtoNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	// FON ALIM SATIM

	@PostMapping("/fonAlimSatim")
	public Map<String, Boolean> fonAlimSatim(@RequestBody AlimSatimDto alimSatim) {
		return fonService.fonAlimSatim(alimSatim);
	}

	// TOLAM BAKIYELER

	@GetMapping("/musteri/bakiye")
	public ResponseEntity<BigDecimal> toplamBakiyeGetir(@RequestParam String tur) {
		try {

			if (tur.equals("TL")) {
				return ResponseEntity.status(HttpStatus.OK).body(hesapService.toplamTLBakiyeGetir());
			} else if (tur.equals("USD")) {
				return ResponseEntity.status(HttpStatus.OK).body(hesapService.toplamUSDBakiyeGetir());
			} else if (tur.equals("EURO")) {
				return ResponseEntity.status(HttpStatus.OK).body(hesapService.toplamEUROBakiyeGetir());
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			}

		} catch (NoParamArgumentsException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
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