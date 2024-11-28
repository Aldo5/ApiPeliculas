package com.mx.ApiPeliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiPeliculas.entity.Peliculas;
import com.mx.ApiPeliculas.repository.PeliculaRepository;



@Service
public class PeliculasServImp {

	@Autowired
	PeliculaRepository  repository;
	
	@Transactional(readOnly = true)
	public List<Peliculas> listar(){
		//Casteo -- polimorfismo puro
		//Casteo es el cambio de un tipo de valor por otro
		return (List<Peliculas>) repository.findAll();
	}
	
	@Transactional
	public boolean guardar(Peliculas pelicula) {
		//obtener los registros de la bd
		boolean bandera = false;
		for(Peliculas p: repository.findAll()) {
			if(p.getNombre().equals(pelicula.getNombre())) {
				bandera =  true;
				break;
			}
			
		}
		if (bandera == false)
			repository.save(pelicula);
		return bandera;
	}
}
