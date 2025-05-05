package com.salesianostriana.dam.ejemplo01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.ejemplo01.modelo.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{

}
