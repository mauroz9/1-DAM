package ejercicio06;

import java.util.Arrays;

public class Oficina {
	private Cuenta [] lista;

	public Oficina(Cuenta[] lista) {
		super();
		this.lista = lista;
	}

	public Cuenta[] getLista() {
		return lista;
	}

	public void setLista(Cuenta[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Oficina [lista=" + Arrays.toString(lista) + "]";
	}
	
	public Cuenta buscarCuenta(int numCuenta) {
		Cuenta cuentaBuscada=null;
		for(int i=0; i<lista.length; i++) {
			if(lista[i]!=null && lista[i].getNumeroCuenta()==numCuenta) {
				cuentaBuscada=lista[i];
			}
		}
		return cuentaBuscada;
	}
	
	public double calcularTotal() {
		double suma=0;
		
		for(int i=0; i<lista.length && lista[i]!=null ; i++) {
			suma=suma+lista[i].getSaldo();
		}
		
		return suma;
	}
	
	public double calcularImportes(Cuenta cuentaBuscada, int cantidad) {
		double importe=0;
		
		if(cuentaBuscada instanceof CEmpresa) {
			importe=((CEmpresa)cuentaBuscada).getSupRetiro()*cantidad;
		}else if(cuentaBuscada instanceof CJoven){
			importe=((CJoven)cuentaBuscada).getSupIngreso()*cantidad;
		}
		
		return importe;
	}
	
	
}
