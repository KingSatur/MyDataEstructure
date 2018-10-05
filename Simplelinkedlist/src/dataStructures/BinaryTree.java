package dataStructures;

import tda.InterfaceBinaryTreeSearch;

public class BinaryTree<T> implements InterfaceBinaryTreeSearch<T>{

	private NodeAbstract<T> root;
	private int height;
	
	public BinaryTree() {
		root = null;
		height = 1;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public NodeAbstract<T> getRoot() {
		return root;
	}

	public void setRoot(NodeAbstract<T> root) {
		this.root = root;
	}

	@Override
	public void addElement(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodeAbstract<T> searchElement(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
}
