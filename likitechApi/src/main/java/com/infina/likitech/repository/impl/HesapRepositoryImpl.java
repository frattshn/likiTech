package com.infina.likitech.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infina.likitech.entity.Hesap;
import com.infina.likitech.model.HesapTop10Dto;
import com.infina.likitech.repository.HesapRepository;

@Repository
public class HesapRepositoryImpl implements HesapRepository {

	private static final String HESAP_COLUMNS = "hesapID, musteriID, hesapTuru, hesapBakiye, portfoyNo, hesapAcilisTarihi";
	private static final String HESAP_COLUMNS_WITH_NO_ID = "musteriID, hesapTuru, hesapBakiye, portfoyNo, hesapAcilisTarihi";

	private static final String FIND_HESAP_BY_MUSTERIID = "SELECT"
			+ " hesapID, must.musteriID, hesapTuru, hesapBakiye, portfoyNo, hesapAcilisTarihi"
			+ " FROM Hesap hes JOIN Musteri must ON hes.musteriID = must.musteriID WHERE (hes.musteriID = ? AND must.musteriDurum = 'A')";
	private static final String FIND_HESAP_BY_HESAPID = "SELECT"
			+ " hesapID, must.musteriID, hesapTuru, hesapBakiye, portfoyNo, hesapAcilisTarihi"
			+ " FROM Hesap h JOIN Musteri must ON must.musteriID = h.musteriID WHERE h.hesapID = ? AND must.musteriDurum = 'A'";
	private static final String FIND_TOP_10_HESAP = "SELECT TOP 10 must.musteriID, (CASE must.musteriTipi WHEN 'B' THEN must.musteriAdi + ' ' + must.musteriSoyadi WHEN 'K' THEN must.musteriKurumAdi END) AS musteriAdi,"
			+ " hes.hesapBakiye, hes.hesapTuru FROM Musteri must JOIN Hesap hes ON must.musteriID = hes.hesapID"
			+ " WHERE hes.hesapBakiye NOT IN (0) AND must.musteriDurum = 'A' ORDER BY hes.hesapBakiye DESC";
	private static final String FIND_ALL_HESAP = "SELECT hesapID, must.musteriID, hesapTuru, hesapBakiye, portfoyNo, hesapAcilisTarihi FROM Hesap h JOIN Musteri must ON must.musteriID = h.musteriID WHERE must.musteriDurum = 'A'";
	private static final String FIND_SUM_TL_BAKIYE = "SELECT SUM(hesapBakiye) FROM Hesap h JOIN Musteri must ON must.musteriID = h.musteriID WHERE (h.hesapTuru = 'TL' AND must.musteriDurum = 'A')";
	private static final String FIND_SUM_USD_BAKIYE = "SELECT SUM(hesapBakiye) FROM Hesap h JOIN Musteri must ON must.musteriID = h.musteriID WHERE (h.hesapTuru = 'USD' AND must.musteriDurum = 'A')";
	private static final String FIND_SUM_EURO_BAKIYE = "SELECT SUM(hesapBakiye) FROM Hesap h JOIN Musteri must ON must.musteriID = h.musteriID WHERE (h.hesapTuru = 'EURO' AND must.musteriDurum = 'A')";

	private static final String ADD_HESAP = "INSERT INTO Hesap(" + HESAP_COLUMNS_WITH_NO_ID
			+ ") VALUES (?, ?, ?, ?, ?)";

	private static final String DELETE_HESAP = "DELETE FROM Hesap Where hesapID = ?";
	private static final String UPDATE_HESAP = "UPDATE Hesap SET hesapBakiye = ? WHERE hesapID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<Hesap> HE_MAPPER = (rs, i) -> {
		Hesap hesap = new Hesap();
		hesap.setHesapID(rs.getInt(1));
		hesap.setMusteriID(rs.getInt(2));
		hesap.setHesapTuru(rs.getString(3));
		hesap.setHesapBakiye(rs.getBigDecimal(4));
		hesap.setPortfoyNo(rs.getString(5));
		hesap.setHesapAcilisTarihi(rs.getDate(6));
		return hesap;
	};

	private static final RowMapper<HesapTop10Dto> HE_10_MAPPER = (rs, i) -> {
		HesapTop10Dto hesapTop10 = new HesapTop10Dto();
		hesapTop10.setHesapID(rs.getInt(1));
		hesapTop10.setMusteriAdi(rs.getString(2));
		hesapTop10.setHesapBakiyesi(rs.getBigDecimal(3));
		hesapTop10.setHesapTuru(rs.getString(4));
		return hesapTop10;
	};

	private static final RowMapper<BigDecimal> SUM_BAKIYE_MAPPER = (rs, i) -> {
		return rs.getBigDecimal(1);
	};

	@Override
	public List<Hesap> findAllHesap() {
		return jdbcTemplate.query(FIND_ALL_HESAP, HE_MAPPER);
	}

	@Override
	public List<Hesap> findHesapByMusteriID(Integer musteriID) {
		return jdbcTemplate.query(FIND_HESAP_BY_MUSTERIID, HE_MAPPER, musteriID);
	}

	@Override
	public List<Hesap> findHesapByHesapID(Integer hesapID) {
		return jdbcTemplate.query(FIND_HESAP_BY_HESAPID, HE_MAPPER, hesapID);
	}

	@Override
	public BigDecimal findSumTLBakiye() {
		return jdbcTemplate.query(FIND_SUM_TL_BAKIYE, SUM_BAKIYE_MAPPER).get(0);
	}

	@Override
	public BigDecimal findSumUSDBakiye() {
		return jdbcTemplate.query(FIND_SUM_USD_BAKIYE, SUM_BAKIYE_MAPPER).get(0);
	}

	@Override
	public List<HesapTop10Dto> findHesapTop10() {
		return jdbcTemplate.query(FIND_TOP_10_HESAP, HE_10_MAPPER);
	}

	@Override
	public BigDecimal findSumEUROBakiye() {
		return jdbcTemplate.query(FIND_SUM_EURO_BAKIYE, SUM_BAKIYE_MAPPER).get(0);
	}

	@Override
	public Integer addHesap(Hesap hesap) {
		return jdbcTemplate.update(ADD_HESAP, hesap.getMusteriID(), hesap.getHesapTuru(), hesap.getHesapBakiye(),
				hesap.getPortfoyNo(), hesap.getHesapAcilisTarihi());
	}

	@Override
	public Integer deleteHesap(Integer hesapID) {
		return jdbcTemplate.update(DELETE_HESAP, hesapID);
	}

	@Override
	public Integer updateHesapBakiye(BigDecimal hesapBakiye, Integer hesapID) {
		return jdbcTemplate.update(UPDATE_HESAP, hesapBakiye, hesapID);
	}

}
