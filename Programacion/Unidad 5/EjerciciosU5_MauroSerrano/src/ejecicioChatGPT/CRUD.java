package ejecicioChatGPT;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class CRUD {
	private Set <Libro> listaLibros = new HashSet <Libro>();

	public CRUD(Set<Libro> listaLibros) {
		super();
		this.listaLibros = listaLibros;
	}

	public Set<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(Set<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	@Override
	public String toString() {
		return "CRUD [listaLibros=" + listaLibros + "]";
	}
	
	public void agregarLibro(Libro l) {
		listaLibros.add(l);
	}
	
	public Libro buscarLibro(String ISBN) {
		Libro libroBuscado = null;
		
		for(Libro l : listaLibros) {
			if(l.getISBN().equals(ISBN)) {
				libroBuscado = l;
			}
		}
		
		return libroBuscado;
	}
	
	public boolean modificarTitulo(Libro l, String titulo) {
		boolean conseguido = false;
		
		if(l != null) {
			l.setTitulo(titulo);
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public boolean eliminarLibro(Libro l) {
		boolean conseguido = false;
		
		if(l != null) {
			listaLibros.remove(l);
			conseguido = true;
		}
		
		return conseguido;
	}
	
	public void mostrarLibrosAutor(String autor) {
		Iterator <Libro> it = listaLibros.iterator();
		while(it.hasNext()){
			Libro libro = it.next();
			if(libro.getAutor().equals(autor)) {
				System.out.println(libro);
			}
		}
	}
	
	public void mostrarLibrosAno(int ano) {
		Iterator <Libro> it = listaLibros.iterator();
		while(it.hasNext()) {
			Libro libro = it.next();
			if(libro.getAnoPubli() == ano){
				System.out.println(libro);
			}
		}
	}
	
	public void ordenarListaNombre() {
		Set <Libro> listaOrdenada = new TreeSet <Libro>(listaLibros);
	}

	@Override
	public int hashCode() {
		return Objects.hash(listaLibros);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CRUD other = (CRUD) obj;
		return Objects.equals(listaLibros, other.listaLibros);
	}
	
	
}
