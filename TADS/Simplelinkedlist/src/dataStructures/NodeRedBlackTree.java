package dataStructures;

public class NodeRedBlackTree<T, K extends Comparable<K>> extends NodeBinaryTree<T,K>{

	public static final String RED = "Red";
	public static final String BLACK = "Black";
	private String color;
	
	public NodeRedBlackTree(T data, K key) {
		super(data, key);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public NodeRedBlackTree<T, K> getLeftNode(){
		return this.getLeftNode();
	}
	
	
	
	
}
