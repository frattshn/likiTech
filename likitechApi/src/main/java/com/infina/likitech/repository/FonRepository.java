package com.infina.likitech.repository;

import java.util.List;

import com.infina.likitech.entity.Fon;
import com.infina.likitech.entity.FonFiyat;
import com.infina.likitech.entity.FonIslem;
import com.infina.likitech.entity.FonStok;

public interface FonRepository {

	// FON STOK

	List<FonStok> findAllFonStok();

	List<FonStok> findFonStokByFonStokID(Integer fonStokID);

	List<FonStok> findFonStokByHesapID(Integer hesapID);

	List<FonStok> findFonStokByFonID(Integer fonID);

	Integer addFonStok(FonStok fonStok);

	Integer deleteFonStok(Integer fonStokID);

	Integer updateFonStok(FonStok fonStok, Integer fonStokID);

	// FON

	List<Fon> findFonByFonID(Integer fonID);

	List<Fon> findAllFon();

	Integer addFon(Fon fon);

	Integer deleteFon(Integer fonID);

	Integer updateFon(Fon fon, Integer fonID);

	// FON ISLEM

	List<FonIslem> findFonIslemByFonIslemID(Integer fonIslemID);

	List<FonIslem> findFonIslemByHesapID(Integer hesapID);

	Integer addFonIslem(FonIslem fonIslem);

	Integer deleteFonIslem(Integer fonIslemID);

	// FON FIYAT

	List<FonFiyat> findAllFonFiyat();

	List<FonFiyat> findFonFiyatByFonFiyatID(Integer fonFiyatID);

	List<FonFiyat> findFonFiyatByFonID(Integer fonID);

	Integer addFonFiyat(FonFiyat fonFiyat);

	Integer updateFonFiyat(FonFiyat fonFiyat, Integer fonFiyatID);

}
