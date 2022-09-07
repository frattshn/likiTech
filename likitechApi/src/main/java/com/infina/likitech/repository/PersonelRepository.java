package com.infina.likitech.repository;

import java.util.List;

import com.infina.likitech.entity.Personel;

public interface PersonelRepository {

	List<Personel> giris(String personelKullaniciAdi, String personelSifresi);

	List<Personel> findAll();

	List<Personel> findById(Integer personelID);

	List<Personel> findByMail(String mail);

	Personel findByMailPassword(String mail, String password);

	Integer addPersonel(Personel personel);

	Integer deletePersonel(Integer personelID);

	Integer updatePersonel(Personel personel, Integer personelID);

	Integer updatePersonelPassword(String mail, String yeniSifre);

}