package tda;

import dataStructures.NodeAbstract;

public interface InterfaceBinaryTreeSearch<T> {

	public void addElement(T data);
	
	public void delete(T data);
	
	public NodeAbstract<T> searchElement(T data);
	
}
