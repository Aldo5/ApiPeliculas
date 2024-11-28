package com.mx.ApiPeliculas.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="PELICULAS")
@NoArgsConstructor //Constructor vacio
@AllArgsConstructor //Constructor con parametros
@Data  //Encapsulamiento y toString
public class Peliculas implements Serializable {

	//Es para que sea compatible con varias cosas versiones de java
		private static final long serialVersionUID = 1L;
		
		//@GeneratedValue -- Esta linea de codigo se agreg cuando tu llave primaria
		//Es autoincrementable
		//Se parse para que acepte valores nulos
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name =  "ID")
		private Long id;
		
		@Column(name="NOMBRE")
		private String nombre;
		
		@Column(name="PRECIO")
		private Long precio;
		
		@Column(name="FECHA_LANZ")
		private Date fechaLanzamiento;
		
		@Column(name="GENERO")
		private String genero;
}
