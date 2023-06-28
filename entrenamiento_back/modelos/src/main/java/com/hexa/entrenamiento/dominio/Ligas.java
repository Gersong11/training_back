package com.hexa.entrenamiento.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "ligas", catalog = "hexa.dbo")
@Data
public class Ligas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdLiga", nullable = false)
	private Integer id;
	
	@Column(name = "Codigo", nullable = false)
	private String codigo;
	
	@Column(name= "Nombre", nullable = false)
	private String nombre;
	
	@Column(name= "Sponsor")
	private String sponsor;
	
	@ManyToOne
	@JoinColumn(name = "IdPais")
	private Paises pais;
	
}
