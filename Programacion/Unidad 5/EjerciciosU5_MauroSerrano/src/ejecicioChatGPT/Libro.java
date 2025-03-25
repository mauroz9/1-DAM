package ejecicioChatGPT;

import java.util.Objects;

public class Libro implements Comparable<Libro>{
	private String ISBN;
	private String titulo;
	private String autor;
	private int anoPubli;

	public Libro(String iSBN, String titulo, String autor, int anoPubli) {
		super();
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.anoPubli = anoPubli;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnoPubli() {
		return anoPubli;
	}

	public void setAnoPubli(int anoPubli) {
		this.anoPubli = anoPubli;
	}

	@Override
	public String toString() {
		return "Libro [ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", anoPubli=" + anoPubli + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ISBN, autor, anoPubli, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(ISBN, other.ISBN) && Objects.equals(autor, other.autor) && anoPubli == other.anoPubli
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Libro o) {
		return this.titulo.compareToIgnoreCase(o.titulo);
	}
	
	
}
