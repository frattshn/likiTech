package com.infina.likitech.repository.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infina.likitech.model.HesapDto;
import com.infina.likitech.repository.AlimSatimRepository;

@Repository
public class AlimSatimRepositoryImpl implements AlimSatimRepository {

	private static final String FIND_HESAP_DTO = "SELECT hes.hesapID, portfoyNo, "
			+ "(CASE must.musteriTipi WHEN 'B' THEN must.musteriAdi + ' ' + must.musteriSoyadi WHEN 'K' THEN must.musteriKurumAdi END) AS musteriAdi, "
			+ "hesapBakiye, hesapTuru FROM Musteri must JOIN Hesap hes ON hes.musteriID = must.musteriID WHERE must.musteriDurum = 'A'";

	private static final String FIND_FON_STOK = "SELECT stokMiktari FROM FonStok f WHERE f.hesapID = ? AND f.fonID = ?";
	private static final String UPDATE_FON_STOK = "UPDATE FonStok SET stokMiktari = ? WHERE hesapID = ? AND fonID = ?";

	private static final String FIND_HESAP_BAKIYE = "SELECT hesapBakiye FROM Hesap WHERE hesapID = ?";
	private static final String FIND_FON_FIYAT = "SELECT fonFiyat FROM FonFiyat f WHERE fonID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<HesapDto> HESAPDTO_MAPPER = (rs, i) -> {
		HesapDto hesapDto = new HesapDto();
		hesapDto.setHesapID(rs.getInt(1));
		hesapDto.setPortfoyNo(rs.getString(2));
		hesapDto.setMusteriAdi(rs.getString(3));
		hesapDto.setHesapBakiye(rs.getBigDecimal(4));
		hesapDto.setHesapTuru(rs.getString(5));
		return hesapDto;
	};

	private static final RowMapper<Integer> FON_STOK_MAPPER = (rs, i) -> {
		return rs.getInt(1);
	};

	private static final RowMapper<BigDecimal> HESAP_BAKIYE_MAPPER = (rs, i) -> {
		return rs.getBigDecimal(1);
	};

	private static final RowMapper<BigDecimal> FON_FIYAT_MAPPER = (rs, i) -> {
		return rs.getBigDecimal(1);
	};

	@Override
	public List<HesapDto> findAllHesapDto() {
		return jdbcTemplate.query(FIND_HESAP_DTO, HESAPDTO_MAPPER);
	}

	@Override
	public Integer findFonStok(Integer hesapID, Integer fonID) {
		return jdbcTemplate.query(FIND_FON_STOK, FON_STOK_MAPPER, hesapID, fonID).get(0);
	}

	@Override
	public BigDecimal findHesapBakiye(Integer hesapID) {
		return jdbcTemplate.query(FIND_HESAP_BAKIYE, HESAP_BAKIYE_MAPPER, hesapID).get(0);
	}

	@Override
	public BigDecimal findFonFiyat(Integer fonID) {
		return jdbcTemplate.query(FIND_FON_FIYAT, FON_FIYAT_MAPPER, fonID).get(0);
	}

	@Override
	public Integer updateFonStok(Integer stokMiktari, Integer hesapID, Integer fonID) {
		return jdbcTemplate.update(UPDATE_FON_STOK, stokMiktari, hesapID, fonID);
	}

}
