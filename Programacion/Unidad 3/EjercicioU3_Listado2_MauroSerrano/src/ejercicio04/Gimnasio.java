package ejercicio04;

import java.util.Arrays;

public class Gimnasio {
	
	Cliente lista[];

	public Gimnasio(Cliente[] lista) {
		super();
		this.lista = lista;
	}

	public Cliente[] getLista() {
		return lista;
	}

	public void setLista(Cliente[] lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "Gimnasio [lista=" + Arrays.toString(lista) + "]";
	}
	
	public void listarTodos(){
		for(int i=0; i<lista.length; i++) {
			if(lista[i]!=null) {
				System.out.println(lista[i]);
			}
		}
	}
	
	public Cliente buscarCliente(String dni, int clientes) {
		Cliente clienteBuscado=null;
		
		for(int i=0; i<clientes; i++) {
			if(lista[i].getDni().equalsIgnoreCase(dni)) {
				clienteBuscado=lista[i];
			}
		}
		return clienteBuscado;
	}
	
	public void agregarCliente(Cliente nuevoCliente, int clientes) {
		lista[clientes]=nuevoCliente;
	}
	
	public void darBaja(Cliente clienteSeleccionado) {
		clienteSeleccionado.setActivo(false);
	}
	
	public double calcularMediaIMC(int clientes){
		double suma=0;
		for(int i=0; i<clientes; i++) {
			suma+=lista[i].calcularIMC();
		}
		return (double) suma/clientes;
	}
	
	
} 