package model;

import java.lang.reflect.Array;

public class CampiHash<T> {
	
	T[] array;

	@SuppressWarnings("unchecked")
	public CampiHash(Class c , int length) {
		array = (T[]) Array.newInstance(c, length);
	}
	
	public T[] getArray() {
		return (T[]) array;
	}
	
	public T[] getHash() {
		return (T[]) array;
	}

	public int hashFunction(int n) {
		return n - 1;
	}
	
	public void put(int n, T t) {
		array[n] = t;
	}
	
	public T get(int n) {
		return array[n];
	}
}
