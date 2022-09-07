package com.infina.likitech.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infina.likitech.entity.Fon;
import com.infina.likitech.entity.FonFiyat;
import com.infina.likitech.entity.FonIslem;
import com.infina.likitech.entity.FonStok;
import com.infina.likitech.repository.FonRepository;

@Repository
public class FonRepositoryImpl implements FonRepository {

	private static final String FON_STOK_COLUMNS = "fonStokID, hesapID, fonID, stokMiktari";
	private static final String FON_STOK_COLUMNS_WITH_NO_ID = "hesapID, fonID, stokMiktari";
	private static final String FIND_ALL_FON_STOK = "SELECT " + FON_STOK_COLUMNS + " FROM FonStok f";
	private static final String FIND_FONSTOK_BY_FONSTOK_ID = "SELECT " + FON_STOK_COLUMNS
			+ " FROM FonStok f WHERE f.fonStokID = ?";
	private static final String FIND_FONSTOK_BY_HESAP_ID = "SELECT " + FON_STOK_COLUMNS
			+ " FROM FonStok f WHERE f.fonStokID = ?";
	private static final String FIND_FONSTOK_BY_FON_ID = "SELECT " + FON_STOK_COLUMNS
			+ " FROM FonStok f WHERE f.fonID = ?";
	private static final String ADD_FON_STOK = "INSERT INTO FonStok(" + FON_STOK_COLUMNS_WITH_NO_ID
			+ ") VALUES (?, ?, ?)";
	private static final String DELETE_FON_STOK = "DELETE FROM FonStok WHERE fonStokID = ?";
	private static final String UPDATE_FON_STOK = "UPDATE FonStok SET stokMiktari = ? WHERE fonStokID = ?";

	private static final String FON_COLUMNS = "fonID, fonAdi, fonTuru, fonKodu, isinKodu";
	private static final String FON_COLUMNS_WITH_NO_ID = "fonAdi, fonTuru, fonKodu, isinKodu";
	private static final String FIND_ALL_FON = "SELECT " + FON_COLUMNS + " FROM Fon f";
	private static final String FIND_FON_BY_FON_ID = "SELECT " + FON_COLUMNS + " FROM Fon f WHERE f.fonID = ?";
	private static final String ADD_FON = "INSERT INTO Fon(" + FON_COLUMNS_WITH_NO_ID + ") VALUES (?, ?, ?, ?)";
	private static final String DELETE_FON = "DELETE FROM Fon WHERE fonID = ?";
	private static final String UPDATE_FON = "UPDATE Fon SET fonAdi, = ?, fonTuru = ?, fonKodu = ?, isinKodu = ? WHERE fonID = ?";

	private static final String FON_ISLEM_COLUMNS = "fonIslemID, hesapID, fonID, islemTarihi, fonMiktari, fonBirimFiyati";
	private static final String FON_ISLEM_COLUMNS_WITH_NO_ID = "hesapID, fonID, islemTarihi, fonMiktari, fonBirimFiyati";
	private static final String FIND_ALL_FON_ISLEM = "SELECT " + FON_ISLEM_COLUMNS + " FROM FonIslem f";
	private static final String FIND_FON_ISLEM_BY_FONISLEM_ID = "SELECT " + FON_ISLEM_COLUMNS
			+ " FROM FonIslem f WHERE f.fonIslemID = ?";
	private static final String FIND_FON_ISLEM_BY_HESAP_ID = "SELECT " + FON_ISLEM_COLUMNS
			+ " FROM FonIslem f WHERE f.hesapID = ?";
	private static final String ADD_FON_ISLEM = "INSERT INTO FonIslem(" + FON_ISLEM_COLUMNS_WITH_NO_ID
			+ ") VALUES (?, ?, ?, ?, ?)";
	private static final String DELETE_FON_ISLEM = "DELETE FROM FonIslem WHERE fonIslemID = ?";

	private static final String FON_FIYAT_COLUMNS = "fonFiyatID, fonID, fonFiyat, fonTarih";
	private static final String FON_FIYAT_COLUMNS_WITH_NO_ID = "fonID, fonFiyat, fonTarih";
	private static final String FIND_ALL_FON_FIYAT = "SELECT " + FON_FIYAT_COLUMNS + " FROM FonFiyat f";
	private static final String FIND_FON_FIYAT_BY_FONFIYAT_ID = "SELECT " + FON_FIYAT_COLUMNS
			+ " FROM FonFiyat f WHERE f.fonFiyatID = ? AND f.fonTarih=(CAST(GETDATE()) AS Date)";
	private static final String FIND_FON_FIYAT_BY_FONID = "SELECT " + FON_FIYAT_COLUMNS
			+ " FROM FonFiyat f WHERE f.fonID = ? AND f.fonTarih=(CAST(GETDATE()) AS Date)";
	private static final String ADD_FON_FIYAT = "INSERT INTO FonFiyat(" + FON_FIYAT_COLUMNS_WITH_NO_ID
			+ ") VALUES(?, ?, ?)";
	private static final String UPDATE_FON_FIYAT = "UPDATE FonFiyat SET fonFiyat = ?, fonTarih = ? WHERE fonFiyatID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<FonStok> STOK_MAPPER = (rs, i) -> {
		FonStok fonStok = new FonStok();
		fonStok.setFonStokID(rs.getInt(1));
		fonStok.setHesapID(rs.getInt(2));
		fonStok.setFonID(rs.getInt(3));
		fonStok.setStokMiktari(rs.getInt(4));
		return fonStok;
	};

	private static final RowMapper<Fon> FON_MAPPER = (rs, i) -> {
		Fon fon = new Fon();
		fon.setFonID(rs.getInt(1));
		fon.setFonAdi(rs.getString(2));
		fon.setFonTuru(rs.getString(3));
		fon.setFonKodu(rs.getString(4));
		fon.setIsinKodu(rs.getString(5));
		return fon;
	};

	private static final RowMapper<FonIslem> ISLEM_MAPPER = (rs, i) -> {
		FonIslem fonIslem = new FonIslem();
		fonIslem.setFonIslemID(rs.getInt(1));
		fonIslem.setHesapID(rs.getInt(2));
		fonIslem.setFonID(rs.getInt(3));
		fonIslem.setIslemTarihi(rs.getDate(4));
		fonIslem.setFonMiktari(rs.getInt(5));
		fonIslem.setFonBirimFiyati(rs.getBigDecimal(6));
		return fonIslem;
	};

	private static final RowMapper<FonFiyat> FIYAT_MAPPER = (rs, i) -> {
		FonFiyat fonFiyat = new FonFiyat();
		fonFiyat.setFonFiyatID(rs.getInt(1));
		fonFiyat.setFonID(rs.getInt(2));
		fonFiyat.setFonFiyat(rs.getBigDecimal(3));
		fonFiyat.setFonTarih(rs.getDate(4));
		return fonFiyat;
	};

	// FON STOK

	@Override
	public List<FonStok> findAllFonStok() {
		return jdbcTemplate.query(FIND_ALL_FON_STOK, STOK_MAPPER);
	}

	@Override
	public List<FonStok> findFonStokByFonStokID(Integer fonStokID) {
		return jdbcTemplate.query(FIND_FONSTOK_BY_FONSTOK_ID, STOK_MAPPER, fonStokID);
	}

	@Override
	public List<FonStok> findFonStokByHesapID(Integer hesapID) {
		return jdbcTemplate.query(FIND_FONSTOK_BY_HESAP_ID, STOK_MAPPER, hesapID);
	}

	@Override
	public List<FonStok> findFonStokByFonID(Integer fonID) {
		return jdbcTemplate.query(FIND_FONSTOK_BY_FON_ID, STOK_MAPPER, fonID);
	}

	@Override
	public Integer addFonStok(FonStok fonStok) {
		return jdbcTemplate.update(ADD_FON_STOK, fonStok.getHesapID(), fonStok.getFonID(), fonStok.getStokMiktari());

	}

	@Override
	public Integer deleteFonStok(Integer fonStokID) {
		return jdbcTemplate.update(DELETE_FON_STOK, fonStokID);
	}

	@Override
	public Integer updateFonStok(FonStok fonStok, Integer fonStokID) {
		return jdbcTemplate.update(UPDATE_FON_STOK, fonStok.getStokMiktari(), fonStokID);
	}

	// FON

	@Override
	public List<Fon> findFonByFonID(Integer fonID) {
		return jdbcTemplate.query(FIND_FON_BY_FON_ID, FON_MAPPER, fonID);
	}

	@Override
	public List<Fon> findAllFon() {
		return jdbcTemplate.query(FIND_ALL_FON, FON_MAPPER);
	}

	@Override
	public Integer addFon(Fon fon) {
		return jdbcTemplate.update(ADD_FON, fon.getFonAdi(), fon.getFonTuru(), fon.getFonKodu(), fon.getIsinKodu());
	}

	@Override
	public Integer deleteFon(Integer fonID) {
		return jdbcTemplate.update(DELETE_FON, fonID);
	}

	@Override
	public Integer updateFon(Fon fon, Integer fonID) {
		return jdbcTemplate.update(UPDATE_FON, fon.getFonAdi(), fon.getFonTuru(), fon.getFonKodu(), fon.getIsinKodu(),
				fonID);
	}

	// FON ISLEM

	@Override
	public List<FonIslem> findFonIslemByFonIslemID(Integer fonIslemID) {
		return jdbcTemplate.query(FIND_FON_ISLEM_BY_FONISLEM_ID, ISLEM_MAPPER, fonIslemID);
	}

	@Override
	public List<FonIslem> findFonIslemByHesapID(Integer hesapID) {
		return jdbcTemplate.query(FIND_FON_ISLEM_BY_HESAP_ID, ISLEM_MAPPER, hesapID);
	}

	@Override
	public Integer addFonIslem(FonIslem fonIslem) {
		return jdbcTemplate.update(ADD_FON_ISLEM, fonIslem.getHesapID(), fonIslem.getFonID(), fonIslem.getIslemTarihi(),
				fonIslem.getFonMiktari(), fonIslem.getFonBirimFiyati());
	}

	@Override
	public Integer deleteFonIslem(Integer fonIslemID) {
		return jdbcTemplate.update(DELETE_FON_ISLEM, fonIslemID);
	}

	// FON FIYAT

	@Override
	public List<FonFiyat> findAllFonFiyat() {
		return jdbcTemplate.query(FIND_ALL_FON_FIYAT, FIYAT_MAPPER);
	}

	@Override
	public List<FonFiyat> findFonFiyatByFonFiyatID(Integer fonFiyatID) {
		return jdbcTemplate.query(FIND_FON_FIYAT_BY_FONFIYAT_ID, FIYAT_MAPPER, fonFiyatID);
	}

	@Override
	public List<FonFiyat> findFonFiyatByFonID(Integer fonID) {
		return jdbcTemplate.query(FIND_FON_FIYAT_BY_FONID, FIYAT_MAPPER, fonID);
	}

	@Override
	public Integer addFonFiyat(FonFiyat fonFiyat) {
		return jdbcTemplate.update(ADD_FON_FIYAT, fonFiyat.getFonID(), fonFiyat.getFonFiyat(), fonFiyat.getFonTarih());
	}

	@Override
	public Integer updateFonFiyat(FonFiyat fonFiyat, Integer fonFiyatID) {
		return jdbcTemplate.update(UPDATE_FON_FIYAT, fonFiyat.getFonFiyatID(), fonFiyat.getFonTarih(), fonFiyatID);
	}

}
