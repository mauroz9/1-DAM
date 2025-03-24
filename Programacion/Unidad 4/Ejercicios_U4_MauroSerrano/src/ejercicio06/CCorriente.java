package ejercicio06;

public class CCorriente extends Cuenta{
	private double mantenimiento;
	private int puntos;
	
	public CCorriente(int numeroCuenta, int cvv, double saldo, double mantenimiento, int puntos) {
		super(numeroCuenta, cvv, saldo);
		this.mantenimiento = mantenimiento;
		this.puntos = puntos;
	}

	public double getMantenimiento() {
		return mantenimiento;
	}

	public void setMantenimiento(double mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return "CCorriente [mantenimiento=" + mantenimiento + ", puntos=" + puntos + "]";
	}

	@Override
	public double ingresarDinero(double ingreso) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()+ingreso);
		puntos++;
		return saldoRes;
	}

	@Override
	public double retirarDinero(double retirar) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()-retirar);
		puntos++;
		return saldoRes;
	}
	
	
}
