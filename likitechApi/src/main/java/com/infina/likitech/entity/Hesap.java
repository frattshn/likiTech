package com.infina.likitech.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Hesap")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hesap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hesapID;
	private Integer musteriID;
	private String hesapTuru;
	private BigDecimal hesapBakiye;
	private String portfoyNo;
	private Date hesapAcilisTarihi;

}
