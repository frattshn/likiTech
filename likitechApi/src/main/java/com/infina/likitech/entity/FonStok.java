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
@Table(name = "FonStok")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FonStok implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 140019690610605949L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fonStokID;
	private Integer hesapID;
	private Integer fonID;
	private Integer stokMiktari;

}
