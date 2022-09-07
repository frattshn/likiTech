package com.infina.likitech.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infina.likitech.entity.Personel;
import com.infina.likitech.repository.PersonelRepository;

@Repository
public class PersonelRepositoryImpl implements PersonelRepository {

	private static final String PERSONEL_COLUMNS = "personelID, personelAdi, personelSoyadi, personelKullaniciAdi, personelSifresi, personelMaili";
	private static final String PERSONEL_COLUMNS_WITH_NO_ID = "personelAdi, personelSoyadi, personelKullaniciAdi, personelSifresi, personelMaili";

	private static final String FIND_ALL_PERSONELS = "SELECT " + PERSONEL_COLUMNS + " FROM Personel p";
	private static final String FIND_PERSONEL_BY_KULLANICIADI = "SELECT " + PERSONEL_COLUMNS
			+ " FROM Personel p WHERE p.personelKullaniciAdi = ? AND p.personelSifresi = ?";
	private static final String FIND_PERSONEL_BY_ID = "SELECT " + PERSONEL_COLUMNS
			+ " FROM Personel p WHERE p.personelID = ?";
	private static final String FIND_PERSONEL_BY_MAIL = "SELECT " + PERSONEL_COLUMNS
			+ " FROM Personel p WHERE p.personelMaili = ?";
	private static final String FIND_PERSONEL_BY_MAIL_PASSWORD = "SELECT " + PERSONEL_COLUMNS
			+ " FROM Personel p WHERE p.personelMaili = ? AND p.personelSifresi = ?";
	private static final String ADD_PERSONEL = "INSERT INTO Personel(" + PERSONEL_COLUMNS_WITH_NO_ID
			+ ") VALUES(?, ?, ?, ?, ?)";
	private static final String DELETE_PERSONEL = "DELETE FROM Personel WHERE personelID = ?";
	private static final String UPDATE_PERSONEL = "UPDATE Personel SET personelAdi = ?, personelSoyadi = ?, personelKullaniciAdi = ?, personelSifresi = ?, personelMaili = ? WHERE personelID = ?";
	private static final String UPDATE_PERSONEL_PASSWORD = "UPDATE Personel SET personelSifresi = ? WHERE personelID = ?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	// INSERT UPDATE ve DELETE için UPDATE(), SELECT için QUERY()

	private static final RowMapper<Personel> PE_MAPPER = (rs, i) -> {
		Personel personel = new Personel();
		personel.setPersonelID(rs.getInt(1));
		personel.setPersonelAdi(rs.getString(2));
		personel.setPersonelSoyadi(rs.getString(3));
		personel.setPersonelKullaniciAdi(rs.getString(4));
		personel.setPersonelSifresi(rs.getString(5));
		personel.setPersonelMaili(rs.getString(6));
		return personel;
	};

	@Override
	public List<Personel> giris(String personelKullaniciAdi, String personelSifresi) {
		return jdbcTemplate.query(FIND_PERSONEL_BY_KULLANICIADI, PE_MAPPER, personelKullaniciAdi, personelSifresi);
	}

	@Override
	public List<Personel> findAll() {
		return jdbcTemplate.query(FIND_ALL_PERSONELS, PE_MAPPER);
	}

	@Override
	public List<Personel> findById(Integer personelID) {
		return jdbcTemplate.query(FIND_PERSONEL_BY_ID, PE_MAPPER, personelID);
	}

	@Override
	public List<Personel> findByMail(String mail) {
		return jdbcTemplate.query(FIND_PERSONEL_BY_MAIL, PE_MAPPER, mail);
	}

	@Override
	public Personel findByMailPassword(String mail, String password) {
		return jdbcTemplate.query(FIND_PERSONEL_BY_MAIL_PASSWORD, PE_MAPPER, mail, password).get(0);
	}

	@Override
	public Integer addPersonel(Personel personel) {
		return jdbcTemplate.update(ADD_PERSONEL, personel.getPersonelAdi(), personel.getPersonelSoyadi(),
				personel.getPersonelKullaniciAdi(), personel.getPersonelSifresi(), personel.getPersonelMaili());
	}

	@Override
	public Integer deletePersonel(Integer personelID) {
		return jdbcTemplate.update(DELETE_PERSONEL, personelID);
	}

	@Override
	public Integer updatePersonel(Personel personel, Integer personelID) {
		return jdbcTemplate.update(UPDATE_PERSONEL, personel.getPersonelAdi(), personel.getPersonelSoyadi(),
				personel.getPersonelKullaniciAdi(), personel.getPersonelSifresi(), personel.getPersonelMaili(),
				personelID);
	}

	@Override
	public Integer updatePersonelPassword(String mail, String yeniSifre) {
		List<Personel> personelList = findByMail(mail);
		Personel personel = personelList.get(0);
		return jdbcTemplate.update(UPDATE_PERSONEL_PASSWORD, yeniSifre, personel.getPersonelID());

	}

}
