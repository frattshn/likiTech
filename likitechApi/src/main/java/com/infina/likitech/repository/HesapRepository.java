package com.infina.likitech.repository;

import java.math.BigDecimal;
import java.util.List;

import com.infina.likitech.entity.Hesap;
import com.infina.likitech.model.HesapTop10Dto;

public interface HesapRepository {

	List<Hesap> findAllHesap();

	List<Hesap> findHesapByMusteriID(Integer musteriID);

	List<Hesap> findHesapByHesapID(Integer hesapID);

	List<HesapTop10Dto> findHesapTop10();

	BigDecimal findSumTLBakiye();

	BigDecimal findSumUSDBakiye();

	BigDecimal findSumEUROBakiye();

	Integer addHesap(Hesap hesap);

	Integer deleteHesap(Integer hesapID);

	Integer updateHesapBakiye(BigDecimal hesapBakiye, Integer hesapID);

}
