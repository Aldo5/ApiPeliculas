package com.mx.ApiPeliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiPeliculas.entity.Peliculas;
import com.mx.ApiPeliculas.service.PeliculasServImp;



@RestController
@RequestMapping("PeliculasWs")
@CrossOrigin

public class PeliculasWs {

	@Autowired
	PeliculasServImp imp;
	
	@GetMapping("listar")
	public List<Peliculas> listar(){
	return imp.listar();
	}
	
	@PostMapping("guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula){
		boolean response = imp.guardar(pelicula);
		
		if(response == true)
			return new ResponseEntity <>("Ese nombre de producto ya existe", HttpStatus.OK);
		else
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
					
	}
}
