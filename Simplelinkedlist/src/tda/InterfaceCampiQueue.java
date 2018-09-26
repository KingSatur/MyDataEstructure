package tda;

import exceptions.StackEmptyException;
import model.Node;

public interface InterfaceCampiQueue<T> {

	public Node<T> front();
	
	public void enqueue(T data);
	
	public T dequeue()throws StackEmptyException;
	
	public boolean isEmpty();
	
	
	
}
