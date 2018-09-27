package Practico2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import exceptions.StackEmptyException;
import model.CampiHash;

public class Practico2 {

	private ArrayList<Almacenador> totalDatos;
	private Cajero[] cajeros;
	private int cantidadPruebas;
	
	public Practico2() {
		totalDatos = new ArrayList<Almacenador>();
	}
	
	public void inicializarCajeros(int size) {
		cajeros = new Cajero[size];
	}

	public void setCantidadPruebas(int cantidadPruebas) {
		this.cantidadPruebas = cantidadPruebas;
	}
	

	public void muestraContenido(String archivo) throws IOException, StackEmptyException {
		
		String cadena = "";
		int linea = 0;
		
		FileReader f = new FileReader(archivo);
		BufferedReader b = new BufferedReader(f);
		while((cadena = b.readLine()) != null) {
			if(linea == 0) {
				setCantidadPruebas(Integer.parseInt(cadena));
			}
			else {
				String[] a = cadena.split(" ");
				if()
				totalDatos.add(new Almacenador(a[0], a[1]));
			}
			linea ++;
			System.out.println(cadena);
		}
		b.close();		
	}
	
	
	
	public static void main(String[] args) {
	
		Practico2 m = new Practico2();
		try {
			m.muestraContenido("FilesTest/pruebaPractico2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
	}
	
	
	
}