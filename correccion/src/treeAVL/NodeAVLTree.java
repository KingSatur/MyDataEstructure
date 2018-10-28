package treeAVL;

import treeBinarySearch.NodeBinaryTree;

public class NodeAVLTree<T,K extends Comparable<K>> extends NodeBinaryTree<T,K> {

	private int avlFactor;
	
	public NodeAVLTree(T data, K key) {
		super(data, key);
	}

	public int getAvlFactor() {
		return avlFactor;
	}

	public void setAvlFactor(int avlFactor) {
		this.avlFactor = avlFactor;
	}
	

	
}
