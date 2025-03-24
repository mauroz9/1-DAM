package ejercicio05;

import java.util.Arrays;

public class Oficina {
	private Empleado [] lista;

	public Oficina(Empleado[] lista) {
		super();
		this.lista = lista;
	}

	public Empleado[] getLista() {
		return lista;
	}

	public void setLista(Empleado[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Oficina [lista=" + Arrays.toString(lista) + "]";
	}
	
	public Empleado buscarEmpleado(int numeroEmpleado) {
		Empleado empleadoBuscado=null;
		
		for(int i=0; i<lista.length && lista[i]!=null;i++) {
			if(lista[i].getNumeroEmpleado()==numeroEmpleado) {
				empleadoBuscado=lista[i];
			}
		}
		return empleadoBuscado;
	}
	
	public double calcularSueldoOficina(Empleado empleadoBuscado, double topeVentas) {
		return empleadoBuscado.calcularSueldo(topeVentas);
	}
	
	public double gastosTotales(double topeVentas) {
		double suma=0;
		
		for(int i=0; i<lista.length && lista[i]!=null;i++) {
			suma=suma+calcularSueldoOficina(lista[i], topeVentas);
		}
		
		return suma;
	}
	
	public void listarEmpleados(double topeVentas) {
		for(int i=0; i<lista.length && lista[i]!=null;i++) {
			System.out.println(lista[i]);
		}
	}
	
	public void felicitarMejores(double topeVentas) {
		for(int i=0; i<lista.length && lista[i]!=null; i++) {
			if(lista[i] instanceof Vendedor) {
				((Vendedor)lista[i]).comprobarVentas(topeVentas);
			}
			
		}
	}
}
	
	
