package model;

public class Main {

	public static void main(String[] args) {
		
//		Batmannacci m = new Batmannacci(7, 9);
//		System.out.println(m.batmanacci(500));
		
		CampiHash<String> m = new CampiHash<String>(String.class, 20);
		m.getHash()[0] = new String("JUanda");
		m.getHash()[1] = new String("JUanda");
	}

}
