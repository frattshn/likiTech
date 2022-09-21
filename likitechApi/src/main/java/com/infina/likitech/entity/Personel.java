package com.infina.likitech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Personel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer personelID;
	private String personelAdi;
	private String personelSoyadi;
	private String personelKullaniciAdi;
	private String personelSifresi;
	private String personelMaili;

}