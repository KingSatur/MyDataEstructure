package Practico2;

public class Comprador {

	private String identificador;
	private int numeroCompras;
	
	public Comprador(String identificador, int numeroCompras) {
		this.identificador = identificador;
		this.numeroCompras = numeroCompras;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getNumeroCompras() {
		return numeroCompras;
	}

	public void setNumeroCompras(int numeroCompras) {
		this.numeroCompras = numeroCompras;
	}
	
	public void restarCompras() {
		numeroCompras --;
	}
	
	public void sumarCompras() {
		numeroCompras ++;
	}
}
