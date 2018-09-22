package model;

import java.util.Hashtable;

public class Batmannacci {
	
	private int n;
	private int k;
	private Hashtable<Integer, Integer> hash;
	private CampiHash<Integer> campiHash;
	
	public Batmannacci(int n, int k) {
		this.n = n;
		this.k = k;
		hash = new Hashtable<Integer, Integer>();
		campiHash = new CampiHash<Integer>(Integer.class, n);
	}
	
	public String batmanacciString(int n) {
		
		String a = "";
		
		if(n == 1) {
			a += "N";
			return a;
		}
		if(n == 2) {
			a += "A";
			return a;
		}
		else {
			a += batmanacciString(n-2) + batmanacciString(n - 1);
			return a;
		}
		
		
	}
	
	public int batmanacci(int n) {

		int a = 0;
		
		if(hash.get(n - 1) != null) {
			a = hash.get(n - 1);
			return a;
		}
		else {
			if(n == 1) {
				a = 1;
				hash.put(n - 1, a);
				return a;
			}
			if(n == 2) {
				a = 1;
				hash.put(n - 1, a);
				return a;
			}
			else {
				a = batmanacci(n - 2) + batmanacci(n - 1);
				hash.put(n - 1, a);
				return a;
			}
		}
	}
		

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}


	public Hashtable<Integer, Integer> getHash() {
		return hash;
	}





	public void setHash(Hashtable<Integer, Integer> hash) {
		this.hash = hash;
	}





	public void batman(int n) {
		
		
	}
	
}
