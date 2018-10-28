package tda;

import treeAVL.NodeAVLTree;

public interface InterfaceAVLTree<T, K extends Comparable<K>> {

	public void addNodeAVL(NodeAVLTree<T,K> nodeToAdd);
	
	public void swing();
	
	public int calculateAvlFactor();
	
	public void deleteNodeAvl(K key);
}
