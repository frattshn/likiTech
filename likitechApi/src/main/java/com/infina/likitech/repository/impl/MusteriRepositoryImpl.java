package com.infina.likitech.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infina.likitech.entity.Musteri;
import com.infina.likitech.repository.MusteriRepository;

@Repository
public class MusteriRepositoryImpl implements MusteriRepository {

	private static final String MUSTERI_COLUMNS = "musteriID, musteriDurum, musteriTipi, musteriAdi, musteriSoyadi, musteriKurumAdi, musteriVergiNumarasi, "
			+ "musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri, musteriUyruk, musteriUlkesi, musteriAdresi, musteriTcNoYabanciNo, musteriBabaAdi, "
			+ "musteriNufusaKayitliYeri, musteriDogumYeri, musteriIkametYeri";
	private static final String MUSTERI_COLUMNS_WITH_NO_ID = "musteriDurum, musteriTipi, musteriAdi, musteriSoyadi, musteriKurumAdi, musteriVergiNumarasi, "
			+ "musteriVergiMukellefiyeti, musteriMaili, musteriTelefonNo, musteriSehri, musteriUyruk, musteriUlkesi, musteriAdresi, musteriTcNoYabanciNo, musteriBabaAdi, "
			+ "musteriNufusaKayitliYeri, musteriDogumYeri, musteriIkametYeri";

	private static final String FIND_ALL_MUSTERI = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriDurum = 'A'";
	private static final String FIND_ALL_BIREYSEL = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriTipi = 'B' AND m.musteriDurum = 'A'";
	private static final String FIND_ALL_KURUMSAL = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriTipi = 'K' AND m.musteriDurum = 'A'";
	private static final String FIND_MUSTERI_BY_ID = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriID = ?";

	private static final String FIND_KURUMSAL_UNIQUES = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriTipi = 'K'";
	private static final String FIND_BIREYSEL_UNIQUES = "SELECT " + MUSTERI_COLUMNS
			+ " FROM Musteri m WHERE m.musteriTipi = 'B'";

	private static final String ADD_MUSTERI = "INSERT INTO Musteri(" + MUSTERI_COLUMNS_WITH_NO_ID
			+ ") VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//	private static final String DELETE_MUSTERI = "DELETE FROM Musteri WHERE musteriID = ?";
	private static final String SET_MUSTERI_DURUM = "UPDATE Musteri SET musteriDurum = ? WHERE musteriID = ?";
	private static final String UPDATE_MUSTERI = "UPDATE Musteri SET musteriDurum = ?, musteriAdi = ?, musteriSoyadi = ?, musteriKurumAdi = ?, musteriVergiNumarasi = ?, "
			+ "musteriVergiMukellefiyeti = ?, musteriMaili = ?, musteriTelefonNo = ?, musteriSehri = ?, musteriUyruk = ?, musteriUlkesi = ?, musteriAdresi = ?, musteriTcNoYabanciNo = ?, "
			+ "musteriBabaAdi = ?, musteriNufusaKayitliYeri = ?, musteriDogumYeri = ?, musteriIkametYeri = ? WHERE musteriID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final RowMapper<Musteri> MUS_MAPPER = (rs, i) -> {
		Musteri musteri = new Musteri();
		musteri.setMusteriID(rs.getInt(1));
		musteri.setMusteriDurum(rs.getString(2));
		musteri.setMusteriTipi(rs.getString(3));
		musteri.setMusteriAdi(rs.getString(4));
		musteri.setMusteriSoyadi(rs.getString(5));
		musteri.setMusteriKurumAdi(rs.getString(6));
		musteri.setMusteriVergiNumarasi(rs.getString(7));
		musteri.setMusteriVergiMukellefiyeti(rs.getString(8));
		musteri.setMusteriMaili(rs.getString(9));
		musteri.setMusteriTelefonNo(rs.getString(10));
		musteri.setMusteriSehri(rs.getString(11));
		musteri.setMusteriUyruk(rs.getString(12));
		musteri.setMusteriUlkesi(rs.getString(13));
		musteri.setMusteriAdresi(rs.getString(14));
		musteri.setMusteriTcNoYabanciNo(rs.getString(15));
		musteri.setMusteriBabaAdi(rs.getString(16));
		musteri.setMusteriNufusaKayitliYeri(rs.getString(17));
		musteri.setMusteriDogumYeri(rs.getString(18));
		musteri.setMusteriIkametYeri(rs.getString(19));
		return musteri;
	};

	@Override
	public List<Musteri> findAll() {
		return jdbcTemplate.query(FIND_ALL_MUSTERI, MUS_MAPPER);
	}

	@Override
	public List<Musteri> findAllBireysel() {
		return jdbcTemplate.query(FIND_ALL_BIREYSEL, MUS_MAPPER);
	}

	@Override
	public List<Musteri> findAllKurumsal() {
		return jdbcTemplate.query(FIND_ALL_KURUMSAL, MUS_MAPPER);
	}

	@Override
	public List<Musteri> findById(Integer musteriID) {
		return jdbcTemplate.query(FIND_MUSTERI_BY_ID, MUS_MAPPER, musteriID);
	}

	@Override
	public List<Musteri> findBireyselUnique() {
		return jdbcTemplate.query(FIND_BIREYSEL_UNIQUES, MUS_MAPPER);
	}

	@Override
	public List<Musteri> findKurumsalUnique() {
		return jdbcTemplate.query(FIND_KURUMSAL_UNIQUES, MUS_MAPPER);
	}

	@Override
	public Integer addMusteri(Musteri musteri) {
		return jdbcTemplate.update(ADD_MUSTERI, musteri.getMusteriDurum(), musteri.getMusteriTipi(),
				musteri.getMusteriAdi(), musteri.getMusteriSoyadi(), musteri.getMusteriKurumAdi(),
				musteri.getMusteriVergiNumarasi(), musteri.getMusteriVergiMukellefiyeti(), musteri.getMusteriMaili(),
				musteri.getMusteriTelefonNo(), musteri.getMusteriSehri(), musteri.getMusteriUyruk(),
				musteri.getMusteriUlkesi(), musteri.getMusteriAdresi(), musteri.getMusteriTcNoYabanciNo(),
				musteri.getMusteriBabaAdi(), musteri.getMusteriNufusaKayitliYeri(), musteri.getMusteriDogumYeri(),
				musteri.getMusteriIkametYeri());
	}

//	@Override
//	public Integer deleteMusteri(Integer musteriID) {
//		return jdbcTemplate.update(DELETE_MUSTERI, musteriID);
//	}

	@Override
	public Integer setMusteriDurum(String musteriDurum, Integer musteriID) {
		return jdbcTemplate.update(SET_MUSTERI_DURUM, musteriDurum, musteriID);
	}

	@Override
	public Integer updateMusteri(Musteri musteri, Integer musteriID) {
		return jdbcTemplate.update(UPDATE_MUSTERI, musteri.getMusteriDurum(), musteri.getMusteriAdi(),
				musteri.getMusteriSoyadi(), musteri.getMusteriKurumAdi(), musteri.getMusteriVergiNumarasi(),
				musteri.getMusteriVergiMukellefiyeti(), musteri.getMusteriMaili(), musteri.getMusteriTelefonNo(),
				musteri.getMusteriSehri(), musteri.getMusteriUyruk(), musteri.getMusteriUlkesi(),
				musteri.getMusteriAdresi(), musteri.getMusteriTcNoYabanciNo(), musteri.getMusteriBabaAdi(),
				musteri.getMusteriNufusaKayitliYeri(), musteri.getMusteriDogumYeri(), musteri.getMusteriIkametYeri(),
				musteriID);
	}

}
