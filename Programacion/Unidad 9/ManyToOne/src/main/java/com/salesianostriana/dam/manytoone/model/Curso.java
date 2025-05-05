
package com.salesianostriana.dam.manytoone.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/* La anotación @Builder es de Lombok
 * 
 * La de Lombok, permite general un objeto Builder para una clase 
 * facilitando la creación de instancias de forma más flexible
 * que con un constructor tradicional, ya que el objeto Builder
 * puede llamara a métodos para configurar los atributos de una clase,
 * permitiendo construir objetos paso a paso, configurando solo los 
 * atributos necesarios de forma secuencial y evita los constructores con muchos
 * parámetros "opcionales".
 * */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, tutor;
	
	//Parte para la asociación, antes debemos crear el repositorio de curso
	//CursoRepository
	
	/*La exlusión de los métodos toString, equals y hashCode se explica en la parte 5, 
	 * se hace para evitar las referencias circulares en la asociación, por ejemplo: 
	 * 
	 * Si pensamos en el método toString de Curso. Cuando al campo alumno, llama a su 
	 * toString y al ser una lista, el tratamiento será invocar al toString de 
	 * cada una de las instancias alumno que contiene. A su vez, cada instancia
	 * de Alumno tiene un atributo/propiedad llamada Curso (de hecho, es el mismo curso
	 * sobre el que ya hemos invocado a toString). Esto provocaría un desbordamiento
	 * de la pila de llamadas.
	 * 
	 *  Para evitar eso se excluyen los métodos toString, equals y hashCode con 
	 *  las anotaciones de Lombok.
	 * */
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	private List<Alumno> alumnos = new ArrayList<>();
	

}
