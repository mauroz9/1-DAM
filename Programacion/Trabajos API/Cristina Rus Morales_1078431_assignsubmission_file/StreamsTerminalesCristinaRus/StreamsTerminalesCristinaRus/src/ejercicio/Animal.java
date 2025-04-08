package ejercicio;

import java.time.LocalDate;

public class Animal {
	
    private String nombre;
    private int edad;
    private int numChip;
    private double precioAdopcion;
    private boolean disponible;
    private LocalDate fechaIngreso;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPrecioAdopcion() {
		return precioAdopcion;
	}
	public void setPrecioAdopcion(double precioAdopcion) {
		this.precioAdopcion = precioAdopcion;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public int getNumChip() {
		return numChip;
	}
	public void setNumChip(int numChip) {
		this.numChip = numChip;
	}
	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", edad=" + edad + ", numChip=" + numChip + ", precioAdopcion="
				+ precioAdopcion + ", disponible=" + disponible + ", fechaIngreso=" + fechaIngreso + "]";
	}
	public Animal(String nombre, int edad, int numChip, double precioAdopcion, boolean disponible,
			LocalDate fechaIngreso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.numChip = numChip;
		this.precioAdopcion = precioAdopcion;
		this.disponible = disponible;
		this.fechaIngreso = fechaIngreso;
	}
	

    
    
}
