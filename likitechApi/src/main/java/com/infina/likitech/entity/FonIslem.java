package com.infina.likitech.entity;

import java.io.Serializable;
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
@Table(name = "FonIslem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FonIslem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940969785390140107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fonIslemID;
	private Integer hesapID;
	private Integer fonID;
	private Date islemTarihi;
	private Integer fonMiktari;
	private BigDecimal fonBirimFiyati;

}
