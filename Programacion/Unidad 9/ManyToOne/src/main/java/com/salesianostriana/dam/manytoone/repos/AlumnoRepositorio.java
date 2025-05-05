package com.salesianostriana.dam.manytoone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.manytoone.model.Alumno;

//No es necesario escribir el @Repository porque lo comprende como tal
public interface AlumnoRepositorio
	extends JpaRepository<Alumno, Long>{

}
