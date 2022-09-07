package com.infina.likitech.service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infina.likitech.entity.Fon;
import com.infina.likitech.entity.FonFiyat;
import com.infina.likitech.entity.FonIslem;
import com.infina.likitech.entity.FonStok;
import com.infina.likitech.entity.Hesap;
import com.infina.likitech.exception.FonCouldntAddException;
import com.infina.likitech.exception.FonCouldntUpdatedException;
import com.infina.likitech.exception.FonFiyatCouldntAddException;
import com.infina.likitech.exception.FonFiyatCouldntUpdated;
import com.infina.likitech.exception.FonFiyatNotFoundException;
import com.infina.likitech.exception.FonIslemCouldntAddException;
import com.infina.likitech.exception.FonIslemNotFoundException;
import com.infina.likitech.exception.FonNotFoundException;
import com.infina.likitech.exception.FonStokCouldntAddException;
import com.infina.likitech.exception.FonStokCouldntUpdatedException;
import com.infina.likitech.exception.FonStokNotFoundException;
import com.infina.likitech.exception.HesapDtoNotFoundException;
import com.infina.likitech.model.AlimSatimDto;
import com.infina.likitech.model.HesapDto;
import com.infina.likitech.repository.AlimSatimRepository;
import com.infina.likitech.repository.FonRepository;

@Service
public class FonService {

	@Autowired
	private HesapService hesapService;

	@Autowired
	private FonRepository fonRepository;

	@Autowired
	private AlimSatimRepository alimSatimRepository;

	// FON STOK

	public List<FonStok> fonlariListele() {
		List<FonStok> fonStokList = fonRepository.findAllFonStok();
		if (!fonStokList.isEmpty()) {
			return fonStokList;
		}
		throw new FonStokNotFoundException();
	}

	public FonStok fonStokByFonStokID(Integer fonStokID) {
		List<FonStok> fonStokList = fonRepository.findFonStokByFonStokID(fonStokID);
		if (!fonStokList.isEmpty()) {
			return fonStokList.get(0);
		}
		throw new FonStokNotFoundException();
	}

	public List<FonStok> fonStokByHesapID(Integer hesapID) {
		List<FonStok> fonStokList = fonRepository.findFonStokByHesapID(hesapID);
		if (!fonStokList.isEmpty()) {
			return fonStokList;
		}
		throw new FonStokNotFoundException();
	}

	public List<FonStok> fonStokByFonID(Integer fonID) {
		List<FonStok> fonStokList = fonRepository.findFonStokByFonID(fonID);
		if (!fonStokList.isEmpty()) {
			return fonStokList;
		}
		throw new FonStokNotFoundException();
	}

	public FonStok fonStokEkle(FonStok fonStok) {
		Integer result = fonRepository.addFonStok(fonStok);
		if (result.equals(Integer.valueOf(0))) {
			throw new FonStokCouldntAddException();
		}
		return fonStok;
	}

	public FonStok fonStokSil(Integer fonStokID) {
		List<FonStok> fonStokList = fonRepository.findFonStokByFonStokID(fonStokID);
		if (!fonStokList.isEmpty()) {
			fonRepository.deleteFonStok(fonStokList.get(0).getFonStokID());
			return fonStokList.get(0);
		}
		throw new FonStokNotFoundException();
	}

	public FonStok fonStokGuncelle(FonStok fonStok, Integer fonStokID) {
		List<FonStok> fonStokList = fonRepository.findFonStokByFonStokID(fonStokID);
		if (!fonStokList.isEmpty()) {
			FonStok founFonStok = fonStokList.get(0);

			founFonStok.setStokMiktari(fonStok.getStokMiktari());
			Integer result = fonRepository.updateFonStok(founFonStok, fonStokID);
			if (result.equals(Integer.valueOf(0))) {
				throw new FonStokCouldntUpdatedException();
			}
			return founFonStok;

		}
		throw new FonStokNotFoundException();
	}

	// FON

	public Fon fonByFonID(Integer fonID) {
		List<Fon> fonList = fonRepository.findFonByFonID(fonID);
		if (!fonList.isEmpty()) {
			return fonList.get(0);
		}
		throw new FonNotFoundException();
	}

	public List<Fon> fonListele() {
		List<Fon> fonList = fonRepository.findAllFon();
		if (!fonList.isEmpty()) {
			return fonList;
		}
		throw new FonNotFoundException();
	}

	public Fon fonEkle(Fon fon) {
		Integer result = fonRepository.addFon(fon);
		if (result.equals(Integer.valueOf(0))) {
			throw new FonCouldntAddException();
		}
		return fon;
	}

	public Fon fonSil(Integer fonID) {
		List<Fon> fonList = fonRepository.findFonByFonID(fonID);
		if (!fonList.isEmpty()) {
			fonRepository.deleteFon(fonID);
			return fonList.get(0);
		}
		throw new FonNotFoundException();
	}

	public Fon fonGuncelle(Fon fon, Integer fonID) {
		List<Fon> fonList = fonRepository.findFonByFonID(fonID);
		if (!fonList.isEmpty()) {
			Fon foundFon = fonList.get(0);

			foundFon.setFonAdi(fon.getFonAdi());
			foundFon.setFonTuru(fon.getFonTuru());
			foundFon.setFonKodu(fon.getFonKodu());
			foundFon.setIsinKodu(fon.getIsinKodu());
			Integer result = fonRepository.updateFon(foundFon, fonID);
			if (result.equals(Integer.valueOf(0))) {
				throw new FonCouldntUpdatedException();
			}
			return foundFon;
		}
		throw new FonNotFoundException();
	}

	// FON ISLEM

	public FonIslem fonIslemByFonIslemID(Integer fonIslemID) {
		List<FonIslem> fonIslemList = fonRepository.findFonIslemByFonIslemID(fonIslemID);
		if (!fonIslemList.isEmpty()) {
			return fonIslemList.get(0);
		}
		throw new FonIslemNotFoundException();
	}

	public List<FonIslem> fonIslemByHesapID(Integer hesapID) {
		List<FonIslem> fonIslemList = fonRepository.findFonIslemByHesapID(hesapID);
		if (!fonIslemList.isEmpty()) {
			return fonIslemList;
		}
		throw new FonIslemNotFoundException();
	}

	public FonIslem fonIslemEkle(FonIslem fonIslem) {
		Integer result = fonRepository.addFonIslem(fonIslem);
		if (result.equals(Integer.valueOf(0))) {
			throw new FonIslemCouldntAddException();
		}
		return fonIslem;
	}

	public FonIslem fonIslemSil(Integer fonIslemID) {
		List<FonIslem> fonIslemList = fonRepository.findFonIslemByFonIslemID(fonIslemID);
		if (!fonIslemList.isEmpty()) {
			fonRepository.deleteFonIslem(fonIslemID);
			return fonIslemList.get(0);
		}
		throw new FonIslemNotFoundException();
	}

	// FON FIYAT

	public List<FonFiyat> fonFiyatListele() {
		List<FonFiyat> fonFiyatList = fonRepository.findAllFonFiyat();
		if (!fonFiyatList.isEmpty()) {
			return fonFiyatList;
		}
		throw new FonFiyatNotFoundException();
	}

	public FonFiyat fonFiyatByFonFiyatID(Integer fonFiyatID) {
		List<FonFiyat> fonFiyatList = fonRepository.findFonFiyatByFonFiyatID(fonFiyatID);
		if (!fonFiyatList.isEmpty()) {
			return fonFiyatList.get(0);
		}
		throw new FonFiyatNotFoundException();
	}

	public List<FonFiyat> fonFiyatByFonID(Integer fonID) {
		List<FonFiyat> fonFiyatList = fonRepository.findFonFiyatByFonID(fonID);
		if (!fonFiyatList.isEmpty()) {
			return fonFiyatList;
		}
		throw new FonFiyatNotFoundException();
	}

	public FonFiyat fonFiyatEkle(FonFiyat fonFiyat) {
		Integer result = fonRepository.addFonFiyat(fonFiyat);
		if (!result.equals(Integer.valueOf(0))) {
			return fonFiyat;
		}
		throw new FonFiyatCouldntAddException();
	}

	public FonFiyat fonFiyatGuncelle(FonFiyat fonFiyat, Integer fonFiyatID) {
		List<FonFiyat> fonFiyatList = fonRepository.findFonFiyatByFonFiyatID(fonFiyatID);
		if (!fonFiyatList.isEmpty()) {
			FonFiyat foundFonFiyat = fonFiyatList.get(0);

			foundFonFiyat.setFonFiyatID(fonFiyat.getFonFiyatID());
			foundFonFiyat.setFonTarih(fonFiyat.getFonTarih());
			Integer result = fonRepository.updateFonFiyat(foundFonFiyat, fonFiyatID);
			if (!result.equals(Integer.valueOf(0))) {
				return foundFonFiyat;
			}
			throw new FonFiyatCouldntUpdated();
		}
		throw new FonFiyatNotFoundException();
	}

	// HESAP DTO

	public List<HesapDto> hesapDtoGetir() {
		List<HesapDto> hesapDtoList = alimSatimRepository.findAllHesapDto();
		if (!hesapDtoList.isEmpty()) {
			return hesapDtoList;
		}
		throw new HesapDtoNotFoundException();
	}

	// FON ALIM SATIM

	private Boolean hesapTuruKontrol(Hesap hesap, Fon fon) {
		if (hesap.getHesapTuru().equals(fon.getFonTuru())) {
			return true;
		}
		return false;
	}

	private Boolean fonStokKontrol(Integer hesapID, Integer fonID, Integer fonAdet) {
		Integer currentStok = alimSatimRepository.findFonStok(hesapID, fonID);
		if (currentStok >= fonAdet) {
			return true;
		} else {
			return false;
		}
	}

	private void fonStokGuncelle(Integer stokMiktari, AlimSatimDto alimSatim) {
		alimSatimRepository.updateFonStok(stokMiktari, alimSatim.getHesapID(), alimSatim.getFonID());
	}

	private Boolean hesapBakiyeKontrol(Integer hesapID, Integer fonID, Integer fonAdet) {
		BigDecimal currentBakiye = alimSatimRepository.findHesapBakiye(hesapID);
		BigDecimal currentFonFiyat = alimSatimRepository.findFonFiyat(fonID);
		BigDecimal islemTutari = currentFonFiyat.multiply(BigDecimal.valueOf(fonAdet));

		if (currentBakiye.compareTo(islemTutari) == 1 || currentBakiye.compareTo(islemTutari) == 0) {
			return true;
		}
		return false;
	}

	private void fonStokSifirKaydet(AlimSatimDto alimSatim) {
		FonStok fonStok = new FonStok();
		fonStok.setFonID(alimSatim.getFonID());
		fonStok.setHesapID(alimSatim.getHesapID());
		fonStok.setStokMiktari(0);
		fonRepository.addFonStok(fonStok);
	}

	public Map<String, Boolean> fonAlimSatim(AlimSatimDto alimSatim) {
		Map<String, Boolean> status = new LinkedHashMap<String, Boolean>();

		Hesap hesap = hesapService.hesapByHesapID(alimSatim.getHesapID());
		Fon fon = fonByFonID(alimSatim.getFonID());

		// hesapTürü kontrolü
		if (hesapTuruKontrol(hesap, fon)) {
			status.put("hesap türü", Boolean.TRUE);

			// fonStok kontrolü
			if (alimSatim.getAlSat()) {

				status.put("alış - satış", true);

				// alış
				if (hesapBakiyeKontrol(alimSatim.getHesapID(), alimSatim.getFonID(), alimSatim.getFonAdet())) {
					status.put("bakiye yeterliliği", true);

					try {
						alimSatimRepository.findFonStok(alimSatim.getHesapID(), alimSatim.getFonID());
					} catch (Exception e) {
						fonStokSifirKaydet(alimSatim);
					}

					Integer currentStok = alimSatimRepository.findFonStok(alimSatim.getHesapID(), alimSatim.getFonID());
					currentStok += alimSatim.getFonAdet();
					fonStokGuncelle(currentStok, alimSatim);

					BigDecimal currentBakiye = alimSatimRepository.findHesapBakiye(alimSatim.getHesapID());
					BigDecimal currentFonFiyat = alimSatimRepository.findFonFiyat(alimSatim.getFonID());

					currentBakiye = currentBakiye
							.subtract(currentFonFiyat.multiply(BigDecimal.valueOf(alimSatim.getFonAdet())));

					hesapService.hesapBakiyeGuncelle(currentBakiye, alimSatim.getHesapID());

				} else {
					status.put("bakiye yeterliliği", false);
				}

			} else {
				// satış

				status.put("alış - satış", false);

				if (fonStokKontrol(alimSatim.getHesapID(), alimSatim.getFonID(), alimSatim.getFonAdet())) {
					status.put("stok yeterliliği", Boolean.TRUE);
					BigDecimal currentBakiye = alimSatimRepository.findHesapBakiye(alimSatim.getHesapID());
					BigDecimal currentFonFiyat = alimSatimRepository.findFonFiyat(alimSatim.getFonID());

					currentBakiye = currentBakiye
							.add(currentFonFiyat.multiply(BigDecimal.valueOf(alimSatim.getFonAdet())));
					hesapService.hesapBakiyeGuncelle(currentBakiye, alimSatim.getHesapID());

					Integer currentStok = alimSatimRepository.findFonStok(alimSatim.getHesapID(), alimSatim.getFonID());
					currentStok -= alimSatim.getFonAdet();
					fonStokGuncelle(currentStok, alimSatim);

				} else {
					status.put("stok yeterliliği", Boolean.FALSE);
				}
			}

		} else {
			status.put("hesap türü", Boolean.FALSE);
		}
		return status;
	}

}
