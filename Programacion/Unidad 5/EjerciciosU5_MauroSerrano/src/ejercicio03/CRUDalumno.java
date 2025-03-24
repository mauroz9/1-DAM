package ejercicio03;

import java.util.Iterator;
import java.util.Set;

public class CRUDalumno{
	private Set <Alumno> listaAlumnos;

	public CRUDalumno(Set<Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

	public Set<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(Set<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	@Override
	public String toString() {
		return "CRUDalumno [listaAlumnos=" + listaAlumnos + "]";
	}
	
	public Alumno findById(int id) {
		Alumno alumnoBuscado=null;
		
		for(Alumno a : listaAlumnos) {
			if(a.getId() == id) {
				alumnoBuscado = a;
				return alumnoBuscado;
			}
		}
		return alumnoBuscado;
	}
	
	public void showList() {
		Iterator <Alumno> it = listaAlumnos.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void showStudent(Alumno a) {
		System.out.println(a);
	}
	
	public void addStudent(Alumno a) {
		listaAlumnos.add(a);
	}
	
	public boolean deleteStudent(Alumno a) {
		boolean correct=false;
		
		if(a != null) {
			listaAlumnos.remove(a);
			correct=true;
		}
		return correct;
	}
	
	public boolean modifyName(Alumno a, String newName) {
		boolean correct = false;
		
		if(a != null) {
			a.setNombre(newName);
			correct = true;
		}
		return correct;
	}
	
	public boolean modifySurname(Alumno a, String newSurname) {
		boolean correct = false;
		
		if(a != null) {
			a.setApellido(newSurname);
			correct = true;
		}
		return correct;
	}
	
	public boolean modifyGrade(Alumno a, double newGrade) {
		boolean correct = false;
		
		if(a != null) {
			a.setNota(newGrade);
			correct = true;
		}
		return correct;
	}

}
