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
@Table(name = "Fon")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3929689971457659420L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fonID;
	private String fonAdi;
	private String fonTuru;
	private String fonKodu;
	private String isinKodu;

}
