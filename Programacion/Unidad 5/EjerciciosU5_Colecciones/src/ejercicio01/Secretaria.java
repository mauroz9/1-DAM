package ejercicio01;

import java.util.List;
import java.util.stream.Collectors;

public class Secretaria {
	private List <Alumno> listaAlumnos;

	public Secretaria(List<Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	@Override
	public String toString() {
		return "Secretaria [listaAlumnos=" + listaAlumnos + "]";
	}
	
	public List<Alumno> obtenerAlumnos(){
		return listaAlumnos.stream().filter(a -> true).collect(Collectors.toList());
	}
	
	public void imprimirLista() {
		listaAlumnos.forEach(a -> System.out.println(a));
	}
	
	
	public void filtrarLetra(char letra) {
		
		listaAlumnos.stream().filter(a -> a.getNombre().toUpperCase().charAt(0) == Character.toUpperCase(letra)).forEach(a -> System.out.println(a));
	}
	
	public long contarTamaño() {
		
		return listaAlumnos.stream().count();
	}
	
	public List<Alumno> filtrarNota1DAM(double nota){
		return listaAlumnos.stream().filter(a -> a.getCurso().equalsIgnoreCase("1DAM") && a.getNotaMedia() >= nota).collect(Collectors.toList());
	}
	
	
	public void obtenerTresPrimerosAlumnos(){
		listaAlumnos.stream().limit(3).forEach(a -> System.out.println(a));
	}
	
	public List<Alumno> menorEdad(){
		if(listaAlumnos.isEmpty()) {
			return List.of();
		}
		
		int edadMinima = listaAlumnos.stream().mapToInt(a -> a.getEdad()).min().orElseThrow();
		
		return listaAlumnos.stream().filter(a -> a.getEdad() == edadMinima).collect(Collectors.toList());
	}
	
	public Alumno primerAlumno() {
		return listaAlumnos.stream().findFirst().orElse(null);
	}
	
	public List<Alumno> buscarNombre10Letras(){
		
		return listaAlumnos.stream().filter(a -> a.getNombre().length() > 10).collect(Collectors.toList());
	}

	public List<Alumno> buscarNombreA6Letras() {

		return listaAlumnos.stream().filter(a -> a.getNombre().length() <= 6  && a.getNombre().startsWith("A")).collect(Collectors.toList());
	}
}
