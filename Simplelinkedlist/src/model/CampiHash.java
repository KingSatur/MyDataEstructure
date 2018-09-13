package model;

public class CampiHash<T> {
	
//	private Object[] array;
	private T[] array;
	private final int length = 100;

	@SuppressWarnings("unchecked")
	public CampiHash() {
		array = (T[]) new Object[length];	
	}
	
	public <T>  T[] getHash() {
		return (T[]) array;
	}
	

}
