package Practico2;

import model.Abstract;
import tda.InterfaceCampiQueue;

public class Cajero {

	private InterfaceCampiQueue<Comprador> colaCompradores;
	private int numeroIdentificador;
	
	public Cajero(int numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
		colaCompradores = new Abstract<Comprador>();
	}

	public InterfaceCampiQueue<Comprador> getColaCompradores() {
		return colaCompradores;
	}

	public void setColaCompradores(InterfaceCampiQueue<Comprador> colaCompradores) {
		this.colaCompradores = colaCompradores;
	}

	public int getNumeroIdentificador() {
		return numeroIdentificador;
	}

	public void setNumeroIdentificador(int numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}
		
	
}
