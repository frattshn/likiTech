package com.infina.likitech.repository;

import java.util.List;

import com.infina.likitech.entity.Musteri;

public interface MusteriRepository {

	List<Musteri> findAll();

	List<Musteri> findAllBireysel();

	List<Musteri> findAllKurumsal();

	List<Musteri> findById(Integer musteriID);

	List<Musteri> findKurumsalUnique();

	List<Musteri> findBireyselUnique();

	Integer addMusteri(Musteri musteri);

//	Integer deleteMusteri(Integer musteriID);

	Integer setMusteriDurum(String musteriDurum, Integer musteriID);

	Integer updateMusteri(Musteri musteri, Integer musteriID);

}
