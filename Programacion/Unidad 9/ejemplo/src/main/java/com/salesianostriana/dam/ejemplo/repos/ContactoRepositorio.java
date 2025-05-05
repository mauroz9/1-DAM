package com.salesianostriana.dam.ejemplo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplo.entidad.Contacto;

public interface ContactoRepositorio extends JpaRepository<Contacto, Long> {
	
}
