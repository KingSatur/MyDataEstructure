package practico2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirLeer {

	
	public void escribir(String archivo) throws IOException {
		
		BufferedWriter m = new BufferedWriter(new FileWriter(archivo));
		m.write("Hola Guevon");
		m.newLine();
		m.write("Hola PAPI");
		m.close();
	}
	
	public void leer(String archivo) throws IOException {
		
		BufferedReader m = new BufferedReader(new FileReader(archivo));
		String linea = "";
		while((linea = m.readLine()) != null) {
			System.out.println(linea);
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		EscribirLeer m = new EscribirLeer();
		try {
			m.escribir("FilesTest/pruebaPractico3.txt");
			m.leer("FilesTest/pruebaPractico3.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
