package tda;

import dataStructures.NodeEnari;
import dataStructures.NodeTree;
import exceptions.IndexOutOfRangeException;

public interface InterfaceCampiTreeEnari<T> {

	public NodeTree<T> search(T data);
	
	public void delete(T data);

	public void add(T data, T dataPadre, NodeEnari<T> node) throws IndexOutOfRangeException;
	
}
