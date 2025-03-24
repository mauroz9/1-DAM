package ejercicio01;

import java.util.List;

public class GestionarNota {
	private List <Nota> notas;

	public GestionarNota(List <Nota> notas) {
		super();
		this.notas = notas;
	}

	public List <Nota> getNotas() {
		return notas;
	}

	public void setNotas(List <Nota> notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "GestionarNota [notas=" + notas + "]";
	}
	
	public void crearNota(Nota n) {
		notas.add(n);
	}
	
	public void mostrarNotas() {
		for(int i=0; i<notas.size() && notas.get(i)!=null;i++) {
			System.out.println((1+i)+". "+notas.get(i));
		}
	}
	
	public Nota buscarNota(int num) {
		return notas.get(num);
	}
	
	public void mostrarNumeroDeNotas() {
		System.out.println("Número total de notas guardadas: " + notas.size());
	}

	public boolean eliminarNota(int num) {
		boolean eliminado=false;
		
		if(num > 0 && num <= notas.size()) {
			notas.remove(num);
			eliminado=true;
		}
		
		return eliminado;
	}
}
