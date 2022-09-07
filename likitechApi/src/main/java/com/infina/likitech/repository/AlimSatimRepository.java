package com.infina.likitech.repository;

import java.math.BigDecimal;
import java.util.List;

import com.infina.likitech.model.HesapDto;

public interface AlimSatimRepository {

	List<HesapDto> findAllHesapDto();

	Integer findFonStok(Integer hesapID, Integer fonID);

	BigDecimal findHesapBakiye(Integer hesapID);

	BigDecimal findFonFiyat(Integer fonID);

	Integer updateFonStok(Integer stokMiktari, Integer hesapID, Integer fonID);

}
