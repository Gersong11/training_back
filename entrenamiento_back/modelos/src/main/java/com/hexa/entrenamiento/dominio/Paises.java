package com.hexa.entrenamiento.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "paises", catalog = "hexa.dbo")
@Data
public class Paises {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdPais", nullable = false)
	private Integer id;
	
	@Column(name = "Codigo", nullable = false, unique = true)
	private String codigo;
	
	@Column(name= "Nombre", nullable = false)
	private String nombre;
	
	
}
