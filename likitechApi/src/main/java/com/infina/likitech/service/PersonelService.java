package com.infina.likitech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infina.likitech.entity.Personel;
import com.infina.likitech.exception.PersonelNotFoundException;
import com.infina.likitech.repository.PersonelRepository;

@Service
public class PersonelService {

	@Autowired
	private PersonelRepository personelRepository;

	public Boolean giris(String personelKullaniciAdi, String personelSifresi) {
		List<Personel> personelList = null;
		personelList = personelRepository.giris(personelKullaniciAdi, personelSifresi);
		return (!personelList.isEmpty());
	}

	public List<Personel> personelListele() {

		Optional<List<Personel>> personelList = Optional.of(personelRepository.findAll());
		if (personelList.isPresent()) {
			return personelList.get();
		}
		throw new PersonelNotFoundException();

	}

	public Personel personelById(Integer id) {
		Optional<List<Personel>> personelList = Optional.of(personelRepository.findById(id));
		if (!personelList.isEmpty()) {
			return personelList.get().get(0);
		} else {
			throw new PersonelNotFoundException();
		}
	}

	public Personel personelEkle(Personel personel) {
		personelRepository.addPersonel(personel);
		return personel;
	}

	public Personel personelSil(Integer id) {
		List<Personel> personelList = personelRepository.findById(id);
		if (!personelList.isEmpty()) {
			Personel p = personelList.get(0);
			personelRepository.deletePersonel(id);
			return p;
		} else {
			throw new PersonelNotFoundException();
		}
	}

	public Personel personelGuncelle(Integer id, Personel personel) {
		List<Personel> personelListe = personelRepository.findById(id);
		if (!personelListe.isEmpty()) {
			Personel p = personelListe.get(0);
			p.setPersonelAdi(personel.getPersonelAdi());
			p.setPersonelSoyadi(personel.getPersonelSoyadi());
			p.setPersonelKullaniciAdi(personel.getPersonelKullaniciAdi());
			// p.setPersonelSifresi(personel.getPersonelSifresi());
			p.setPersonelMaili(personel.getPersonelMaili());
			personelRepository.updatePersonel(p, id);
			return p;
		} else {
			throw new PersonelNotFoundException();
		}
	}

	public void personelSifreGuncelle(String mail, String yeniSifre) {
		personelRepository.updatePersonelPassword(mail, yeniSifre);
	}

	public void personelSifreGuncelleWithMail(String mail, String sifre, String yeniSifre) {
		Personel personel = personelRepository.findByMailPassword(mail, sifre);
		if (personel.equals(null)) {
			System.out.println("şifre yanlış");
			throw new PersonelNotFoundException();
		} else {
			personelRepository.updatePersonelPassword(personel.getPersonelMaili(), yeniSifre);
		}
	}

}