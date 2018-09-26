package model;

import exceptions.StackEmptyException;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Practico {

	private InterfaceCampiStack<Character> pilaGranja;
	private InterfaceCampiQueue<Character> colaEjecucion;
	
	public Practico() {
		pilaGranja = new Abstract<Character>();
		colaEjecucion = new Abstract<Character>();
	}
	
	
	public InterfaceCampiStack<Character> getPilaGranja() {
		return pilaGranja;
	}

	public void setPilaGranja(InterfaceCampiStack<Character> pilaGranja) {
		this.pilaGranja = pilaGranja;
	}

	public InterfaceCampiQueue<Character> getColaEjecucion() {
		return colaEjecucion;
	}

	public void setColaEjecucion(InterfaceCampiQueue<Character> colaEjecucion) {
		this.colaEjecucion = colaEjecucion;
	}


	public static void main(String[] args) throws StackEmptyException {
		
		InterfaceCampiStack<Character> pilaGranja = new Abstract<Character>();
		pilaGranja.push(new Character('A'));
		pilaGranja.push(new Character('B'));
		System.out.println(pilaGranja.top().getData());
		System.out.println(pilaGranja.pop());
		
		InterfaceCampiQueue<Character> colaEjecucion = new Abstract<Character>();
		colaEjecucion.enqueue('A');
		colaEjecucion.enqueue('B');
		colaEjecucion.enqueue('C');
		colaEjecucion.dequeue();
		
		

		

		
		
		
		
		
		
	}

}
