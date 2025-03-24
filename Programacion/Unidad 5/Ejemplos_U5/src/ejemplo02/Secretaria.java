package ejemplo02;

import java.util.List;

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
	
	public void agregarAlumno(Alumno a) {
		listaAlumnos.add(a);
	}
	
	
	public Alumno buscarAlumno(String dni) {
		Alumno alumnoBuscado=null;
		boolean encontrado=false;
		for(int i=0; i<listaAlumnos.size() && listaAlumnos.get(i)!=null && !encontrado; i++) {
			if(listaAlumnos.get(i).getDni().equalsIgnoreCase(dni)) {
				alumnoBuscado=listaAlumnos.get(i);
				encontrado=true;
			}
		}
		return alumnoBuscado;
	}
	
	public int buscarAlmuno2(String dni) {
		int indice=-1;
		boolean encontrado=false;
		for(int i=0; i<listaAlumnos.size() && listaAlumnos.get(i)!=null && !encontrado; i++) {
			if(listaAlumnos.get(i).getDni().equalsIgnoreCase(dni)) {
				indice=listaAlumnos.indexOf(buscarAlumno(dni));
				encontrado=true;
			}
		}
		return indice;
	}
	
	public void borrarAlumno(Alumno a) {
		listaAlumnos.remove(a);
	}
	
	public void imprimirLista() {
		for (Alumno alumno : listaAlumnos) {
			System.out.println(alumno);
		}
	}
	
	public void cambiarNotaMedia(Alumno a, double nota) {
		listaAlumnos.get(listaAlumnos.indexOf(a)).setNotaMedia(nota);
		
	}
	
	public double calcularMediaAlumnos(){
		double suma=0;
		int contador=0;
		
		for(Alumno alumno : listaAlumnos) {
			suma+=alumno.getNotaMedia();
			contador++;
			
		}
		
		return suma/contador;
	}
}	
