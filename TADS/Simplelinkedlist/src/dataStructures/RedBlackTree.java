package dataStructures;

import tda.InterfaceRedBlackTree;

public class RedBlackTree<T, K extends Comparable<K>> implements InterfaceRedBlackTree<T, K>{

	private NodeRedBlackTree<T,K> root;
	private int BHeight;

	public RedBlackTree() {
		root = null;
		BHeight = 0;
	}
	
	public NodeRedBlackTree<T, K> getRoot() {
		return root;
	}

	public void setRoot(NodeRedBlackTree<T, K> root) {
		this.root = root;
	}

	public int getBHeight() {
		return BHeight;
	}

	public void setBHeight(int bHeight) {
		BHeight = bHeight;
	}

	@Override
	public void leftRotation(NodeRedBlackTree<T, K> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightRotation(NodeRedBlackTree<T, K> node) {
		
				
	}

	@Override
	public void addNode(T data, K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNode(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchUncle(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchGrandFather(K key) {
		// TODO Auto-generated method stub
		
	}
	
	public NodeRedBlackTree<T, K> searchNode(K key, NodeRedBlackTree<T, K> node){
		
		if(node.getKey().equals(key)) {
			return node;
		}
		else {
			if(node.getKey().compareTo(key) > 0) {
				if(node.getLeftSon() != null) {
					return searchNode(key, node.getLeftSon());
				}
				else {
					return null;
				}
			}
			if(node.getKey().compareTo(key) < 0) {
				if(node.getRightSon() != null) {
					return searchNode(key, node.getRightSon());
				}
				else {
					return null;
				}
			}			
		}
		
		return null;
		
	}
	
	
	

	
}
