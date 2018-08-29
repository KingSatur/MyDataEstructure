package tda;

import model.Node;

public interface InterfaceCampiQueue<T> {

	public Node<T> front();
	
	public void enqueue(Node<T> node);
	
	public Node<T> dequeue();
	
	public boolean isEmpty();
	
	
	
}
