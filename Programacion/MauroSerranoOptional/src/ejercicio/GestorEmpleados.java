package ejercicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class GestorEmpleados {
	private List<Empleado> listaEmpleados;

	public GestorEmpleados(List<Empleado> listaEmpleados) {
		super();
		this.listaEmpleados = listaEmpleados;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "GestorEmpleados [listaEmpleados=" + listaEmpleados + "]";
	}

	// Devolvemos un optional para que, en caso de que ya exista un empleado con el
	// ID
	// Introducido, no se agregue un empleado con un ID duplicado.
	public Optional<Empleado> agregarEmpleado(Empleado e) {
		Optional<Empleado> existe = buscarId(e.getId());

		if (existe.isPresent()) {
			return Optional.empty();
		}

		listaEmpleados.add(e);
		return Optional.of(e);
	}

	// Eliminamos un empleado, para el que devolvemos un Optional en caso de que no
	// se
	// encuentre al empleado buscado.
	public Optional<Empleado> eliminarEmpleado(int id) {
		Optional<Empleado> emp = buscarId(id);
		if (emp.isPresent()) {
			listaEmpleados.remove(emp.get());
		}
		return emp;
	}

	// Modificar sueldo para el que devolvemos un Optional en caso de que no se
	// encuentre al empleado buscado.
	public Optional<Empleado> modificarSueldo(int id, double nuevoSalario) {
		Optional<Empleado> emp = buscarId(id);
		if (emp.isPresent()) {
			emp.get().setSalario(nuevoSalario);
		}
		return emp;
	}

	// Devolvemos una lista de empleados filtrada por departamento.
	//Aplicamos el metodo map, a una instancia optional de departamento
	//para transformar el String a mayusculas.
	public List<Empleado> buscarPorDepartamento(String departamento) {
		List<Empleado> resultado = new ArrayList<Empleado>();
		Optional<String> opt = Optional.of(departamento);
		Optional<String> mayusculas = opt.map(String::toUpperCase);

		for (Empleado e : listaEmpleados) {
			if (e.getDepartamento() != null && e.getDepartamento().equalsIgnoreCase(mayusculas.get())) {
				resultado.add(e);
			}
		}
		return resultado;
	}

	// Buscar por ID, y aplicamos la clase optional, para que en caso de que no se encuentre
	// al empleado o se encuentre con valor nulo, devuelva un Optional.empty.
	public Optional<Empleado> buscarId(int id) {
		for (Empleado e : listaEmpleados) {
			if (e.getId() == id) {
				return Optional.of(e);
			}
		}
		return Optional.empty();
	}

	// Lista a todos los empleados
	public void imprimirLista() {
		Iterator<Empleado> it = listaEmpleados.iterator();

		System.out.println("Lista de empleados:");
		while (it.hasNext()) {
			Empleado e = it.next();
			System.out.println(e);
		}
	}

	// Buscar el salario mas alto
	public double mejorSalario() {
		double salario = listaEmpleados.getFirst().getSalario();
		Iterator<Empleado> it = listaEmpleados.iterator();

		while (it.hasNext()) {
			Empleado e = it.next();
			if (e.getSalario() > salario);
			salario = e.getSalario();
		}

		return salario;
	}

	// Devolvemos la lista de los empleados mejor pagados, primero comprobamos
	// que la lista contenga null con .isEmpty() para evitar recibir un
	// NullPointerException
	//
	public List<Empleado> empleadosMejorSalario() {
		List<Empleado> masPagados = new ArrayList<>();
		double salario = mejorSalario();

		if (listaEmpleados.isEmpty()) {
			return Collections.emptyList();
		}

		for (Empleado e : listaEmpleados) {
			if (e.getSalario() == salario) {
				masPagados.add(e);
			}
		}
		return masPagados;
	}

	// Ordenar por ID (orden natural)
	public List<Empleado> ordenarPorId() {
		List<Empleado> listaOrdenada = new ArrayList<Empleado>(listaEmpleados);
		Collections.sort(listaOrdenada);
		return listaOrdenada;
	}

	// Ordenar por Antigüedad (orden no natural)
	public List<Empleado> ordenarPorAntigüedad() {
		List<Empleado> listaOrdenada = new ArrayList<Empleado>(listaEmpleados);
		Collections.sort(listaOrdenada, new CompararPorAntigüedad());
		return listaOrdenada;
	}

}
