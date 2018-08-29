package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import exceptions.StackEmptyException;
import tda.InterfaceCampiList;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Test {
	
	
	public boolean isBalanced(String word) {
		
		InterfaceCampiStack<Character> campiStack = new CampiList<Character>();
		char[] brackets = word.toCharArray();
		boolean leave = false;
		
		for(int i = 0; i < brackets.length && !leave ; i ++) {
			if(brackets[i] == '{' || brackets[i] == '['|| brackets[i] == '(') {
				Node<Character> newNode = new Node<Character>(brackets[i]);
				campiStack.push(newNode);
			}
			else { 
				if(brackets[i] == '}' || brackets[i] == ']'|| brackets[i] == ')') {
					if(!campiStack.isEmpty()) {
						if(campiStack.isArmonic(campiStack.top().getData(), brackets[i])) {
							try {
								campiStack.pop();
							}
							catch(Exception e) {
							
							}
						}
						else {
							leave = true;
							return campiStack.isEmpty();
						}
					}
					else {
						leave = true;
						return false;
					}
				}
			}
		}
		
		return campiStack.isEmpty();		
	}
	
	public void read() throws IOException {
		FileReader file = new FileReader("FilesTest/testCases.txt");
		File m = new File("FilesTest/resultados.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(file);
		String cadena = br.readLine();
		long limit = Long.parseLong(cadena);
		for(long i = 0; i < 1000; i ++) {
			cadena = br.readLine();
			System.out.println(isBalanced(cadena));
		}
				
		
	}

	public static void main(String[] args) {
		
		
//		CampiList<Player> megaList = new CampiList<Player>();
//		Player one = new Player("Juan David", 70);
//		Node<Player> firstNode = new Node<Player>(one);
//		megaList.setFirstNode(firstNode);
//		Player two = new Player("Caros Steveb", 90);
//		Node<Player> secondNode = new Node<Player>(two);
//		megaList.getFirstNode().setNextElement(secondNode);
//		Node<String> three = new Node<String>("Books");
//		
//		System.out.println(megaList.getFirstNode().getData().getName());
		
		//Prueba en forma de lista
//		CampiList<String> listica = new CampiList<String>();
//		Node<String> primeraPalabra = new Node<String>("Juanda");
//		listica.addElement("Juanda");
//		listica.addElement("Carlos");
//		listica.addElement("Jhon");
//		listica.addElement("Messi");
//		listica.addElement("Ronaldo");
//		listica.addElement("M");
//		listica.addElement("A");
//		listica.addElement("D");
//		listica.addElement("F");
//		try {
//			listica.deleteElement(1);
//			System.out.println(listica.getFirstNode().getData());
//			System.out.println(listica.getFirstNode().getPosition());
//			System.out.println(listica.getFirstNode().getNextElement().getData());
//			System.out.println(listica.getFirstNode().getNextElement().getPosition());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getData());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getPosition());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getNextElement().getData());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getNextElement().getPosition());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getNextElement().getNextElement().getData());
//			System.out.println(listica.getFirstNode().getNextElement().getNextElement().getNextElement().getNextElement().getPosition());
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		
		//Prueba en forma de pila
//		InterfaceCampiStack<String> listica1 = new CampiList<String>();
//		listica1.push("A");
//		listica1.push("B");
//		listica1.push("C");
//		listica1.push("D");
//		try {
//			listica1.pop();
//			System.out.println(listica1.top().getData());
//			listica1.pop();
//			System.out.println(listica1.top().getData());
//			listica1.pop();
//			System.out.println(listica1.top().getData());
//			listica1.pop();
//			System.out.println(listica1.top());
//			listica1.pop();
//		} catch (StackEmptyException e) {
//			System.out.println(e.getMessage());
		
//		String a = "[((aaaaaaaa))]}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}{}{}{}{}{}{}{}{}{}{}";
		Test test = new Test();
		try {
			test.read();
		} 
		catch (IOException e) {
		}

	}
	
	
}