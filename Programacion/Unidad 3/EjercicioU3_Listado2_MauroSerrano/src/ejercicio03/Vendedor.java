package ejercicio03;

import java.util.Arrays;

public class Vendedor {
	
	private int movilesVendido;
	private Movil lista[];
	
	public Vendedor(int movilesVendido, Movil[] lista) {
		super();
		this.movilesVendido = movilesVendido;
		this.lista = lista;
	}

	public int getMovilesVendido() {
		return movilesVendido;
	}

	public void setMovilesVendido(int movilesVendido) {
		this.movilesVendido = movilesVendido;
	}

	public Movil[] getLista() {
		return lista;
	}

	public void setLista(Movil[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Vendedor [movilesVendido=" + movilesVendido + ", lista=" + Arrays.toString(lista) + "]";
	}
	
	public Movil []	comprobarStock(int telefonos) {
		int contador=0;
		Movil []listaSinVender=new Movil[telefonos];
		
		for(int i=0; i<telefonos; i++) {
			if(!lista[i].isVendido()) {
				listaSinVender[contador]=lista[i];
				contador++;
			}
		}
		return listaSinVender;
	}
	
	public void imprimirStock(Movil []listaSinVender) {
		for(int i=0; i<listaSinVender.length; i++) {
			if(listaSinVender[i]==null) {
				
			}else {
				System.out.println(listaSinVender[i]);
			}
		}
	}
	
	public Movil buscarPorModelo(String modelo, Movil []listaSinVender) {		
		Movil movilBuscado=null;
		
		for(int i=0; i<listaSinVender.length; i++) {
			if(listaSinVender[i] != null&&listaSinVender[i].getModelo().equalsIgnoreCase(modelo)) {
				movilBuscado=listaSinVender[i];
			}
		}
		return movilBuscado;
	}
	
	public double calcularDescuento(double descuento, Movil movilBuscado) {
		double cien=100.0, dineroDescontar=0;
		
		dineroDescontar=movilBuscado.getPrecio()*descuento/cien;
		
		return movilBuscado.getPrecio()-dineroDescontar;
	}
	
	public void cambiarTelefono(Movil nuevoMovil, Movil antiguoMovil) {
		for(int i=0;i< lista.length; i++) {
			if(lista[i]==antiguoMovil) {
				lista[i]=nuevoMovil;
			}
		}
	}
	
	public double calcularGanancias(){
		double ganancia=0;
		for(int i=0; i<lista.length; i++) {
			if(lista[i]!=null) {
				ganancia+=lista[i].getPrecio();
			}
		}
		return ganancia;
	}
	
}
