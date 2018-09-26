package tda;

import exceptions.StackEmptyException;
import model.Node;

public interface InterfaceCampiStack<T> {

	
	public void push(T data);
	
	public boolean isEmpty();
	
	public Node<T> top();
	
	public T pop() throws StackEmptyException;
	
	public boolean isArmonic(char a, char b);

	
	
	
}
