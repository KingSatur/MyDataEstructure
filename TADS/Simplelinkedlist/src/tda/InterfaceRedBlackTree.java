package tda;

import dataStructures.NodeRedBlackTree;

public interface InterfaceRedBlackTree<T, K extends Comparable<K>> {

	public void leftRotation(NodeRedBlackTree<T, K> node);
	
	public void rightRotation(NodeRedBlackTree<T, K> node);
	
	public void addNode(T data, K key);
	
	public void deleteNode(K key);
	
	public void searchUncle(K key);
	
	public void searchGrandFather(K key);
	
	
	
}
