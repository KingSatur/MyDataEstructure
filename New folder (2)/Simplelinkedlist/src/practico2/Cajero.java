package practico2;

import dataStructures.Abstract;
import dataStructures.NodeAbstract;
import exceptions.StackEmptyException;
import tda.InterfaceCampiQueue;

public class Cajero {

	private InterfaceCampiQueue<Comprador> colaCompradores;
	private int numeroIdentificador;
	private int tiempoDemora;
	
	public Cajero(int numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
		colaCompradores = new Abstract<Comprador>();
	}

	
	public int getTiempoDemora() {
		calcularTiempoDemora();
		return tiempoDemora;
	}


	public void setTiempoDemora(int tiempoDemora) {
		this.tiempoDemora = tiempoDemora;
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
		
	public void agregarComprador(Comprador m) {
		colaCompradores.enqueue(m);
	}
	
	public void calcularTiempoDemora() {
		
		tiempoDemora = 0;
		NodeAbstract<Comprador> actually = colaCompradores.front();
		
		if(actually.getNextElement() == null) {
			tiempoDemora = actually.getData().getNumeroCompras();
		}
		else {
			boolean salir = false;
			while(!salir) {
				tiempoDemora += actually.getData().getNumeroCompras();
				if(actually.getNextElement() == null) {
					salir = true;
				}
				else {
					actually = actually.getNextElement();
				}
			}
		}
		
		
	}
	
	
	public String atender() throws StackEmptyException {
		
		String toReturn = "";
		
		while(colaCompradores.front() != null) {
			
			int cantidadComprasPrimerComprador = colaCompradores.front().getData().getNumeroCompras();
			int tiempoParaSalir = 0;
			
			for(int i = 0; i <= cantidadComprasPrimerComprador; i ++) {
			
				if(colaCompradores.front().getData().getNumeroCompras() == 0) {
					toReturn += colaCompradores.front().getData().getIdentificador() + " " + tiempoParaSalir + "\n";
					colaCompradores.dequeue();
					tiempoDemora++;
					if(colaCompradores.front() != null) {
						colaCompradores.front().getData().sumarCompras();						
					}
				}
				else {
					tiempoDemora++;
					colaCompradores.front().getData().restarCompras();
					tiempoParaSalir ++;
				}
			}
		}
		
		return toReturn;
	}
	
}
