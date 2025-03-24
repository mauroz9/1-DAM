package ejercicio03;

import java.util.Random;
import java.util.Arrays;

public class ArrayReales implements IEstadisticas{
	private double[]num;

	public ArrayReales(double[] num) {
		super();
		this.num = num;
	}

	public double[] getNum() {
		return num;
	}

	public void setNum(double[] num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return "ArrayReales [num=" + Arrays.toString(num) + "]";
	}
	
	public void rellenarArray(double desde, double hasta) {
		Random rnd=new Random();
		
		for(int i=0; i<num.length; i++) {
			num[i]=rnd.nextDouble(hasta-desde+1)+desde;
		}
	}

	@Override
	public double calcularMinimo() {
		double minimo=num[0];
		
		for(int i=0; i<num.length; i++) {
			if(num[i]<minimo) {
				minimo=num[i];
			}
			
		}
		
		return minimo;
	}

	@Override
	public double calcularMaximo() {
		double maximo=num[0];
		
		for(int i=0; i<num.length; i++) {
			if(num[i]>maximo) {
				maximo=num[i];
			}
		}
		
		return maximo;
	}

	@Override
	public double calcularSumatorio() {
		double sum=0;
		
		for(int i=0; i<num.length; i++) {
			sum+=num[i];
		}
		
		return sum;
	}
	
	public void mostrarArray() {
		for(int i=0; i<num.length; i++) {
			System.out.printf("%.2f, ",num[i]);
		}
	}
	
	
	
}