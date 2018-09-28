package examenPratico2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.StackEmptyException;
import model.Abstract;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Practico {

	
	private int casosPruebas;
	private int cantidadFichas;
	private ArrayList<Estudiante> estudiantes;
	private InterfaceCampiStack<Ficha> pilaFichasDerecha;
	private InterfaceCampiStack<Ficha> pilaFichasIzquierda;
	private ArrayList<Ficha> fichasEliminadas;
	
	public Practico() {
		estudiantes = new ArrayList<Estudiante>();
		pilaFichasIzquierda = new Abstract<Ficha>();
		pilaFichasDerecha = new Abstract<Ficha>();
		fichasEliminadas = new ArrayList<Ficha>();
	}
	
	public void setCasosPruebas(int a) {
	
		int c = 0;
	}
	
	public void lectura(String archivo) throws IOException, StackEmptyException {
		
		BufferedReader m = new BufferedReader(new FileReader(archivo));
		String linea = m.readLine();
		casosPruebas = Integer.parseInt(linea);
	
		while((linea = m.readLine()) != null) {
			if(casosPruebas > 0) {
				cantidadFichas = Integer.parseInt(linea.split(" ")[0]);
				llenarFichasPilaIzquierda(cantidadFichas);
				int numeroSemestres = Integer.parseInt(linea.split(" ")[1]);
				for(int i = 0; i < numeroSemestres; i ++) {
					linea = m.readLine();
					String[] b = linea.split(" ");
					for(int x = 0; x < b.length ; x ++) {
						double promedio = Double.parseDouble(b[x].substring(0, 3));
						String sexo = b[x].charAt(4) + "";
						estudiantes.add(new Estudiante(promedio, sexo, i + 1));
					}
					CompareStudents comparator = new CompareStudents();
					estudiantes.sort(comparator);
					matricular();
					estudiantes.clear();
				}
				
				fichasEliminadas.clear();
				estudiantes.clear();
				
			}
		}
		
		
	}

	
	public void llenarFichasPilaIzquierda(int numberFichas) throws StackEmptyException {
		
		InterfaceCampiQueue<Ficha> m = new Abstract<Ficha>();
		
		for(int i = 0; i < numberFichas ; i ++) {
			pilaFichasIzquierda.push(new Ficha(i + 1));
		}	

		for(int i = 0; i < numberFichas; i ++) {
			m.enqueue(pilaFichasIzquierda.pop());
		}	
		
		for(int i = 0; i < numberFichas; i ++) {
			pilaFichasIzquierda.push(m.dequeue());
		}
	}
	
	
	public void apilarDerecha(boolean m) throws StackEmptyException {
		
		Ficha apilarDerecha = pilaFichasIzquierda.top().getData();
		int h = apilarDerecha.getLegibilidad();
		if(apilarDerecha.getLegibilidad() == 0) {
			fichasEliminadas.add(pilaFichasDerecha.pop());
		}
		else {
			if(m) {
				apilarDerecha.restarLegibilidad(2);
				pilaFichasIzquierda.pop();
				pilaFichasDerecha.push(apilarDerecha);
			}
			else {
				apilarDerecha.restarLegibilidad(1);
				pilaFichasIzquierda.pop();
				pilaFichasDerecha.push(apilarDerecha);
			}
		}
	}
	
	
	public void apilarIzquierda(boolean m) throws StackEmptyException {
		
		Ficha apilarIzquierda = pilaFichasDerecha.top().getData();
		int h = apilarIzquierda.getLegibilidad();
		if(apilarIzquierda.getLegibilidad() == 0) {
			fichasEliminadas.add(pilaFichasDerecha.pop());
		}
		else {
			if(m) {
				apilarIzquierda.restarLegibilidad(2);
				
			}
			else {
				apilarIzquierda.restarLegibilidad(1);
			}
		}

		
	}
	
	
	public void matricular() throws StackEmptyException {
		
		for(int i = 1; i < estudiantes.size() + 1 ; i ++) {
			if(estudiantes.get(i - 1).getNumeroSemestre() % 2 == 0) {
				if(estudiantes.get(i - 1).getSexo().equals("H")) {
					if(pilaFichasDerecha.top() != null) {
						apilarIzquierda(true);											
					}
				}
				else {
					if(pilaFichasDerecha.top() != null) {
						apilarIzquierda(false);
					}
				}
			}
			else {
				if(estudiantes.get(i - 1).getSexo().equals("H")) {
					if(pilaFichasIzquierda.top() != null) {
						apilarDerecha(true);
					}
				}
				else {
					if(pilaFichasIzquierda.top() != null) {
						apilarDerecha(false);
					}
				}
			}
		}
	}
	
	
	public int cuantosPorSemestre(int a) {
		
		int cantidad = 0;
		
		for(int i  = 0; i < estudiantes.size(); i ++) {
			if(estudiantes.get(i).getNumeroSemestre() == a) {
				cantidad++;
			}
		}
		
		return cantidad;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Practico c = new Practico();
		try {
			try {
				c.lectura("FilesTest/pruebaPractico");
			} catch (StackEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
