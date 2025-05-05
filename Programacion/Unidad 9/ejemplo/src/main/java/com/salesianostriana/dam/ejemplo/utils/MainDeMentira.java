package com.salesianostriana.dam.ejemplo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.salesianostriana.dam.ejemplo.EjemploApplication;
import com.salesianostriana.dam.ejemplo.entidad.Contacto;
import com.salesianostriana.dam.ejemplo.repos.*;

import jakarta.annotation.PostConstruct;

@Component
public class MainDeMentira {

    private final EjemploApplication ejemploApplication;
	
	@Autowired
	private ContactoRepositorio contactoRepositorio;

    MainDeMentira(EjemploApplication ejemploApplication) {
        this.ejemploApplication = ejemploApplication;
    }
	
	@PostConstruct
	public void Ejecutar() {
		
		contactoRepositorio.findAll()
			.forEach(c -> System.out.println(c.toString()));
		
	}
	
}
