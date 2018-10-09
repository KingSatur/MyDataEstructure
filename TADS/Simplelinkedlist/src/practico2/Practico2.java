//package practico2;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Hashtable;
//
//import dataStructures.CampiHash;
//import exceptions.StackEmptyException;
//
//public class Practico2 {
//
//	private Cajero[] cajeros;
//	private int cantidadPruebas;
//	
//	public Practico2() {
//	}
//	
//	public void inicializarCajeros(int size) {
//		cajeros = new Cajero[size];
//	}
//
//	public void setCantidadPruebas(int cantidadPruebas) {
//		this.cantidadPruebas = cantidadPruebas;
//	}
//	
//	public int tiempoDemoraMaximo() {
//		
//		int tiempoMaxi = 0;
//		
//		int c = cajeros.length;
//		if(c == 1) {
//			return cajeros[0].getTiempoDemora();
//		}
//		for(int i = 0; i < cajeros.length - 1 ; i++) {
//			if(cajeros[i].getTiempoDemora() < cajeros[i + 1].getTiempoDemora()) {
//				tiempoMaxi = cajeros[i + 1].getTiempoDemora();
//			}
//			else {
//				tiempoMaxi = cajeros[i].getTiempoDemora();
//			}
//		}
//
//		return tiempoMaxi;
//	}
//
//	public void muestraContenido(String archivo) throws IOException, StackEmptyException {
//		
//		String cadena = "";
//		int linea = 0;
//		
//		FileReader f = new FileReader(archivo);
//		BufferedReader b = new BufferedReader(f);
//		while((cadena = b.readLine()) != null) {
//			if(linea == 0) {
//				setCantidadPruebas(Integer.parseInt(cadena));
//			}
//			else {
//				int cantidadCajas = Integer.parseInt(cadena.split(" ")[0]);
//				crearCajas(cantidadCajas);
//				int cantidadPersonas = Integer.parseInt(cadena.split(" ")[1]);
//				int avance = 0;
//				while(avance < cantidadPersonas) {
//					cadena = b.readLine();
//					agregarComprador(new Comprador(cadena.split(" ")[0], Integer.parseInt(cadena.split(" ")[1])));
//					avance++;
//				}
//				int tiempoDemora = tiempoDemoraMaximo();
//				for(int i = 0; i < cajeros.length ; i ++) {
//					System.out.print(cajeros[i].atender());
//				}
//				System.out.println(tiempoDemora);
//				cantidadPersonas = 0;
//				cantidadCajas = 0;
//			}
//			linea++;
//		}
//		b.close();		
//	}
//	
//	
//	
//	public void crearCajas(int cantidad) {
//		cajeros = new Cajero[cantidad];
//		for(int i = 0; i < cajeros.length ; i ++) {
//			cajeros[i] = new Cajero(i);
//		}
//	}
//	
//	public void agregarComprador(Comprador p) {
//		
//		int posCajaMenor = 0;
//		
//		for(int i = 0; i < cajeros.length - 1 ; i ++) {
//			if(cajeros[i + 1].getColaCompradores().getSize() < cajeros[i].getColaCompradores().getSize()) {
//				posCajaMenor = i + 1;
//			}
//		}
//		if(posCajaMenor != 0) {
//			cajeros[posCajaMenor].agregarComprador(p);
//		}
//		else {
//			cajeros[0].agregarComprador(p);
//		}
//	}	
//	
//	
//	public static void main(String[] args) {
//	
//		Practico2 m = new Practico2();
//		try {
//			m.muestraContenido("FilesTest/pruebaPractico2");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (StackEmptyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//
//		
//	}
//	
//	
//	
//}