package model;

public class CampiHash<T> {
	
	private T[] array;
	private final int length = 1000;

	public CampiHash() {
		array = (T[])new Object[length];
	}
	
	public T[] getHash() {
		return array;
	}
	
	public T getHashPosition(int index) {
		return array[index];
	}
	
}
