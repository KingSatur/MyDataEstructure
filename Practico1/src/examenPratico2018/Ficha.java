package examenPratico2018;

public class Ficha {

	private int numero;
	private int legibilidad;
	
	public Ficha( int numero) {
		this.numero = numero;
		legibilidad = 4;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void restarLegibilidad(int a) {
		legibilidad = legibilidad - a;
	}

	public int getLegibilidad() {
		return legibilidad;
	}

	public void setLegibilidad(int legibilidad) {
		this.legibilidad = legibilidad;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
