package model;

import java.util.Hashtable;

public class Batmannacci {
	
	private int n;
	private int k;
	private CampiHash<Integer> campiHash;
	
	public Batmannacci(int n, int k) {
		this.n = n;
		this.k = k;
		campiHash = new CampiHash<Integer>(Integer.class, n);
	}

	public int batmanacciCampiHash(int n) {

		int a = 0;
		
		if(campiHash.get(n - 1) != null) {
			a = campiHash.get(n - 1);
			return a;
		}
		else {
			if(n == 1) {
				a = 1;
				campiHash.put(n - 1, a);
				return a;
			}
			if(n == 2) {
				a = 1;
				campiHash.put(n - 1, a);
				return a;
			}
			else {
				a = batmanacciCampiHash(n - 2) + batmanacciCampiHash(n - 1);
				campiHash.put(n - 1, a);
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

	public String printString(int n) {
		
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
			a += printString(n - 2) + printString(n - 1);
			return a;
		}		
	}

	public int pos(int n) {
		
		if(n == 1) {
			return n;
		}
		if(n == 2) {
			return n;
		}
		else {
			if(n > campiHash.get(n - 2)) {
				n = n - (campiHash.get(n) - campiHash.get(n - 1)); 
				return n;
			}
			if(n < campiHash.get(n - 2)) {
				n = n - (campiHash.get(n - 1) - campiHash.get(n - 2));
				return n;
			}
			else {
				return pos(n - 1);
			}
		}		
	}
	
}
