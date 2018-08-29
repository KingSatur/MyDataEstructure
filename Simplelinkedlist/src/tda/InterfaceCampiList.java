package tda;

import exceptions.IndexOutOfRangeException;
import model.Node;

public interface InterfaceCampiList<T> {

	public void addElement(T element);
	
	public void deleteElement(int position) throws IndexOutOfRangeException;
	
	public Node<T> searchElement(int position)throws IndexOutOfRangeException;
	
	public int getSize();
	
	public boolean isEmpty();
	
	public Node<T> searchElementBefore(T element);
	
	public Node<T> searchElementAfter(T element);

	
	
	
	
}
