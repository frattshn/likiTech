package com.infina.likitech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infina.likitech.entity.Musteri;
import com.infina.likitech.exception.MusteriAlreadyExistException;
import com.infina.likitech.exception.MusteriNotFoundException;
import com.infina.likitech.model.MusteriBireyselDto;
import com.infina.likitech.model.MusteriKurumsalDto;
import com.infina.likitech.repository.MusteriRepository;

@Service
public class MusteriService {

	@Autowired
	private MusteriRepository musteriRepository;

	// MUSTERI

	public List<MusteriBireyselDto> musteriBireyselListele() {
		List<MusteriBireyselDto> musteriBireyselList = new ArrayList<MusteriBireyselDto>();
		List<Musteri> musteriList = musteriRepository.findAllBireysel();

		for (Musteri musteri : musteriList) {
			MusteriBireyselDto musteriBireysel = MusteriBireyselDto.of(musteri);
			musteriBireyselList.add(musteriBireysel);
		}
		return musteriBireyselList;

	}

	public List<MusteriKurumsalDto> musteriKurumsalListele() {
		List<MusteriKurumsalDto> musteriKurumsalList = new ArrayList<MusteriKurumsalDto>();
		List<Musteri> musteriList = musteriRepository.findAllKurumsal();

		for (Musteri musteri : musteriList) {
			MusteriKurumsalDto musteriKurumsal = MusteriKurumsalDto.of(musteri);
			musteriKurumsalList.add(musteriKurumsal);
		}
		return musteriKurumsalList;

	}

	public MusteriBireyselDto musteriBireyselById(Integer id) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			MusteriBireyselDto musteriBireysel = MusteriBireyselDto.of(musteriList.get(0));
			return musteriBireysel;
		}
		throw new MusteriNotFoundException();
	}

	public MusteriKurumsalDto musteriKurumsalById(Integer id) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			MusteriKurumsalDto musteriKurumsal = MusteriKurumsalDto.of(musteriList.get(0));
			return musteriKurumsal;
		}
		throw new MusteriNotFoundException();
	}

	public MusteriBireyselDto musteriBireyselEkle(MusteriBireyselDto musteriBireyselDto) {
		Musteri musteri = Musteri.ofBireysel(musteriBireyselDto);
		musteri.setMusteriDurum("A");
		musteri.setMusteriTipi("B");

		List<Musteri> musteriUniques = musteriRepository.findBireyselUnique();

		for (Musteri musteriLoop : musteriUniques) {
			if (musteriLoop.getMusteriTcNoYabanciNo().equals(musteri.getMusteriTcNoYabanciNo())
					|| musteriLoop.getMusteriMaili().equals(musteri.getMusteriMaili())
					|| musteriLoop.getMusteriVergiNumarasi().equals(musteri.getMusteriVergiNumarasi())) {
				throw new MusteriAlreadyExistException();
			}
		}
		musteriRepository.addMusteri(musteri);
		return musteriBireyselDto;
	}

	public MusteriKurumsalDto musteriKurumsalEkle(MusteriKurumsalDto musteriKurumsalDto) {
		Musteri musteri = Musteri.ofKurumsal(musteriKurumsalDto);
		musteri.setMusteriDurum("A");
		musteri.setMusteriTipi("K");

		List<Musteri> musteriUniques = musteriRepository.findKurumsalUnique();

		for (Musteri musteriLoop : musteriUniques) {
			if (musteriLoop.getMusteriKurumAdi().equals(musteri.getMusteriKurumAdi())
					|| musteriLoop.getMusteriVergiNumarasi().equals(musteri.getMusteriVergiNumarasi())
					|| musteriLoop.getMusteriMaili().equals(musteri.getMusteriMaili())) {
				throw new MusteriAlreadyExistException();
			}
		}
		musteriRepository.addMusteri(musteri);
		return musteriKurumsalDto;
	}

	public MusteriBireyselDto musteriBireyselSetDurum(Integer id) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			musteriRepository.setMusteriDurum("P", id);
			return MusteriBireyselDto.of(musteriList.get(0));
		}
		throw new MusteriNotFoundException();
	}

	public MusteriKurumsalDto musteriKurumsalSetDurum(Integer id) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			musteriRepository.setMusteriDurum("P", id);
			return MusteriKurumsalDto.of(musteriList.get(0));
		}
		throw new MusteriNotFoundException();
	}

	public MusteriBireyselDto musteriBireyselGuncelle(Integer id, MusteriBireyselDto musteriBireyselDto) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			Musteri foundMusteri = musteriList.get(0);

			foundMusteri.setMusteriID(musteriBireyselDto.getMusteriID());
			foundMusteri.setMusteriAdi(musteriBireyselDto.getMusteriAdi());
			foundMusteri.setMusteriSoyadi(musteriBireyselDto.getMusteriSoyadi());
			foundMusteri.setMusteriVergiNumarasi(musteriBireyselDto.getMusteriVergiNumarasi());
			foundMusteri.setMusteriVergiMukellefiyeti(musteriBireyselDto.getMusteriVergiMukellefiyeti());
			foundMusteri.setMusteriMaili(musteriBireyselDto.getMusteriMaili());
			foundMusteri.setMusteriTelefonNo(musteriBireyselDto.getMusteriTelefonNo());
			foundMusteri.setMusteriSehri(musteriBireyselDto.getMusteriSehri());
			foundMusteri.setMusteriUyruk(musteriBireyselDto.getMusteriUyruk());
			foundMusteri.setMusteriUlkesi(musteriBireyselDto.getMusteriUlkesi());
			foundMusteri.setMusteriAdresi(musteriBireyselDto.getMusteriAdresi());
			foundMusteri.setMusteriTcNoYabanciNo(musteriBireyselDto.getMusteriTcNoYabanciNo());
			foundMusteri.setMusteriBabaAdi(musteriBireyselDto.getMusteriBabaAdi());
			foundMusteri.setMusteriNufusaKayitliYeri(musteriBireyselDto.getMusteriNufusaKayitliYeri());
			foundMusteri.setMusteriDogumYeri(musteriBireyselDto.getMusteriDogumYeri());
			foundMusteri.setMusteriIkametYeri(musteriBireyselDto.getMusteriIkametYeri());

			musteriRepository.updateMusteri(foundMusteri, id);
			return MusteriBireyselDto.of(foundMusteri);
		}
		throw new MusteriNotFoundException();

	}

	public MusteriKurumsalDto musteriKurumsalGuncelle(Integer id, MusteriKurumsalDto musteriKurumsalDto) {
		List<Musteri> musteriList = musteriRepository.findById(id);
		if (!musteriList.isEmpty()) {
			Musteri foundMusteri = musteriList.get(0);

			foundMusteri.setMusteriID(musteriKurumsalDto.getMusteriID());
			foundMusteri.setMusteriKurumAdi(musteriKurumsalDto.getMusteriKurumAdi());
			foundMusteri.setMusteriVergiNumarasi(musteriKurumsalDto.getMusteriVergiNumarasi());
			foundMusteri.setMusteriVergiMukellefiyeti(musteriKurumsalDto.getMusteriVergiMukellefiyeti());
			foundMusteri.setMusteriMaili(musteriKurumsalDto.getMusteriMaili());
			foundMusteri.setMusteriTelefonNo(musteriKurumsalDto.getMusteriTelefonNo());
			foundMusteri.setMusteriSehri(musteriKurumsalDto.getMusteriSehri());
			foundMusteri.setMusteriUlkesi(musteriKurumsalDto.getMusteriUlkesi());
			foundMusteri.setMusteriAdresi(musteriKurumsalDto.getMusteriAdresi());

			musteriRepository.updateMusteri(foundMusteri, id);
			return MusteriKurumsalDto.of(foundMusteri);
		}
		throw new MusteriNotFoundException();
	}

}
