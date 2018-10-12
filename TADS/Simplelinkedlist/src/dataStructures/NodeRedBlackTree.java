package dataStructures;

public class NodeRedBlackTree<T, K extends Comparable<K>>{

	public static final String RED = "Red";
	public static final String BLACK = "Black";
	private String color;
	private T data;
	private K key;
	private NodeRedBlackTree<T,K> leftNode;
	private NodeRedBlackTree<T,K> rightNode;
	
	public NodeRedBlackTree(T data, K key) {
		this.data = data;
		this.key = key;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public NodeRedBlackTree<T, K> getLeftSon() {
		return leftNode;
	}

	public void setLeftSon(NodeRedBlackTree<T, K> leftNode) {
		this.leftNode = leftNode;
	}

	public NodeRedBlackTree<T, K> getRightSon() {
		return rightNode;
	}

	public void setRightSon(NodeRedBlackTree<T, K> rightNode) {
		this.rightNode = rightNode;
	}
	
}
