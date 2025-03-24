package ejercicio06;

public class CJoven extends Cuenta{
	private double supIngreso;

	public CJoven(int numeroCuenta, int cvv, double saldo, double supIngreso) {
		super(numeroCuenta, cvv, saldo);
		this.supIngreso = supIngreso;
	}

	public double getSupIngreso() {
		return supIngreso;
	}

	public void setSupIngreso(double supIngreso) {
		this.supIngreso = supIngreso;
	}

	@Override
	public double ingresarDinero(double ingreso) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()+ingreso+supIngreso);
		return saldoRes;
	}

	@Override
	public double retirarDinero(double retirar) {
		double saldoRes=0;
		super.setSaldo(super.getSaldo()-retirar);
		return saldoRes;
	}
	
}
