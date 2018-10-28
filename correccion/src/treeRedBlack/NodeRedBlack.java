package treeRedBlack;

import treeBinarySearch.NodeBinaryTree;

public class NodeRedBlack<T,K extends Comparable<K>> extends NodeBinaryTree<T,K> {
	
	private boolean doubleBlack;
	public static final String RED = "RED";
	public static final String BLACK = "BLACK";
	private String color;
	
	public NodeRedBlack(T data, K key) {
		super(data, key);
	}
	
	public boolean isDoubleBlack() {
		return doubleBlack;
	}

	public void setDoubleBlack(boolean doubleBlack) {
		this.doubleBlack = doubleBlack;
	}



	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public void changeColor() {
		
		if(color.equals(NodeRedBlack.BLACK)) {
			color = NodeRedBlack.RED;
		}
		else {
			color = NodeRedBlack.BLACK;			
		}		
	}
	
	
	
}
