package com.infina.likitech.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infina.likitech.entity.Hesap;
import com.infina.likitech.exception.HesapNotFoundException;
import com.infina.likitech.model.HesapTop10Dto;
import com.infina.likitech.repository.HesapRepository;

@Service
public class HesapService {

	@Autowired
	private HesapRepository hesapRepository;

	public Hesap hesapByHesapID(Integer hesapID) {
		List<Hesap> hesapList = hesapRepository.findHesapByHesapID(hesapID);
		if (!hesapList.isEmpty()) {
			return hesapList.get(0);
		}
		throw new HesapNotFoundException();
	}

	public List<Hesap> hesaplariGetirTum() {
		List<Hesap> hesapList = hesapRepository.findAllHesap();
		if (!hesapList.isEmpty()) {
			return hesapList;
		}
		throw new HesapNotFoundException();
	}

	public List<Hesap> hesapByMusteriID(Integer musteriID) {
		return hesapRepository.findHesapByMusteriID(musteriID);
	}

	public Hesap hesapEkle(Hesap hesap) {
		hesapRepository.addHesap(hesap);
		return hesap;
	}

	public List<HesapTop10Dto> hesapTop10() {
		List<HesapTop10Dto> hesapTop10List = hesapRepository.findHesapTop10();
		if (!hesapTop10List.isEmpty()) {
			return hesapTop10List;
		}
		throw new HesapNotFoundException();
	}

	public Hesap hesapSil(Integer hesapID) {
		List<Hesap> hesapList = hesapRepository.findHesapByHesapID(hesapID);
		if (!hesapList.isEmpty()) {
			hesapRepository.deleteHesap(hesapList.get(0).getHesapID());
			return hesapList.get(0);
		}
		throw new HesapNotFoundException();
	}

	// FON ALIM SATIM İÇİN

	public Hesap hesapBakiyeGuncelle(BigDecimal hesapBakiye, Integer hesapID) {
		List<Hesap> hesapList = hesapRepository.findHesapByHesapID(hesapID);
		if (!hesapList.isEmpty()) {

			hesapRepository.updateHesapBakiye(hesapBakiye, hesapID);

			return hesapList.get(0);
		}
		throw new HesapNotFoundException();
	}

	// HAVALE PROVİZYON İÇİN

	public Hesap hesapBakiyeGuncelleHP(BigDecimal hesapBakiye, Integer hesapID) {
		List<Hesap> hesapList = hesapRepository.findHesapByHesapID(hesapID);
		if (!hesapList.isEmpty()) {
			BigDecimal currentBakiye = hesapList.get(0).getHesapBakiye();
			currentBakiye = currentBakiye.add(hesapBakiye);
			hesapRepository.updateHesapBakiye(currentBakiye, hesapID);

			return hesapList.get(0);
		}
		throw new HesapNotFoundException();
	}

	// TOPLAM BAKIYELER

	public BigDecimal toplamTLBakiyeGetir() {
		return hesapRepository.findSumTLBakiye();
	}

	public BigDecimal toplamUSDBakiyeGetir() {
		return hesapRepository.findSumUSDBakiye();
	}

	public BigDecimal toplamEUROBakiyeGetir() {
		return hesapRepository.findSumEUROBakiye();
	}
}
