package model;

public class Main {

	public static void main(String[] args) {
		
		Batmannacci m = new Batmannacci(40, 9);
		System.out.println(m.batmanacciCampiHash(10));
		System.out.println(m.printString(10));
		System.out.println(m.pos(6));
		
	}

}
