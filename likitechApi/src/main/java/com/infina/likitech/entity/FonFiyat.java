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
@Table(name = "FonFiyat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FonFiyat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5016691016385456268L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fonFiyatID;
	private Integer fonID;
	private BigDecimal fonFiyat;
	private Date fonTarih;

}
