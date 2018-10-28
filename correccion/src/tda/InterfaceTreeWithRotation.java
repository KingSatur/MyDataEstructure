package tda;

import treeBinarySearch.NodeBinaryTree;

public interface InterfaceTreeWithRotation<T,K extends Comparable<K>> {

	public void leftRotation(NodeBinaryTree<T,K> node);
	
	public void rightRotation(NodeBinaryTree<T, K> node);
	
}
