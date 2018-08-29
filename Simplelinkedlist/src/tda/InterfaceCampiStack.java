package tda;

import exceptions.StackEmptyException;
import model.Node;

public interface InterfaceCampiStack<T> {

	
	public void push(Node<T> data);
	
	public boolean isEmpty();
	
	public Node<T> top();
	
	public void pop() throws StackEmptyException;
	
	public boolean isArmonic(char a, char b);

	
	
	
}
