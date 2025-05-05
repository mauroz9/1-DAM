package com.salesianostriana.dam.ejemplo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contacto {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private String telefono;
	
}
