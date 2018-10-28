package tda;

import treeRedBlack.NodeRedBlack;

public interface InterfaceRedBlackTree<T, K extends Comparable<K>> {

	public void addNode(T data, K key);
	
	public void deleteNode(K key);
	
	public NodeRedBlack<T,K>  searchUncle(K key);
	
	public NodeRedBlack<T,K>  searchGrandFather(K key);
	
	public void addFixUp(NodeRedBlack<T,K> nodeAdded);
	
	
	
}
