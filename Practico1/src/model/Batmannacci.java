//package model;
//
//import java.util.Hashtable;
//
//public class Batmannacci {
//	
//	private int n;
//	private CampiHash<Long> campiHash;
//	
//	public Batmannacci(int n) {
//		this.n = n;
//		campiHash = new CampiHash<Long>(Long.class, n);
//		batmanacci(n);
//	}
//
//	public long batmanacci(long n) {
//
//		long a = 0;
//		
//		if(campiHash.get(n) != null) {
//			a = campiHash.get(n);
//			return a;
//		}
//		else {
//			if(n == 1) {
//				a = 1;
//				campiHash.put(n - 1, a);
//				return a;
//			}
//			if(n == 2) {
//				a = 1;
//				campiHash.put(n - 1, a);
//				return a;
//			}
//			else {
//				a = batmanacci(n - 2) + batmanacci(n - 1);
//				campiHash.put(n - 1, a);
//				return a;
//			}
//		}
//	}
//		
//	public int getN() {
//		return n;
//	}
//
//	public void setN(int n) {
//		this.n = n;
//	}
//	
//	public long getFib(long n) {
//		return campiHash.get(n);
//	}
//
//	public String printString(int n) {
//		
//		String a = "";
//		
//		if(n == 1) {
//			a += "N";
//			return a;
//		}
//		if(n == 2) {
//			a += "A";
//			return a;
//		}
//		else {
//			a += printString(n - 2) + printString(n - 1);
//			return a;
//		}		
//	}
//
//	public long pos(long n, int fib) {
//				
//		if(n == 1) {
//			return n;
//		}
//		if(n == 2) {
//			return n;
//		}
//		else {
//			if(n > campiHash.get(fib - 2)) {
//				n = n - (campiHash.get(fib) - campiHash.get(fib - 1));
//				return pos(n, fib - 1);
//			}
//			else {
//				return pos(n, fib - 2);
//			}
//		}		
//	}
//	
//	public String batman(int a, int b) {
//			
//		batmanacci(a);
//		if(pos(b, a) == 1) {
//			return "N";
//		}
//		else {
//			return "A";
//		}
//	}
//}
