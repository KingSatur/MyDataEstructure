package model;

public class Node<K> {

	private K data;
	private Node<K> nextElement;
	private int position;
	
	public Node(K data) {
		this.data = data;
	}
	//////////////u
	public K getData() {
		return data;
	}
	public void setData(K data) {
		this.data = data;
	}
	public Node<K> getNextElement() {
		return nextElement;
	}
	public void setNextElement(Node<K> nextElement) {
		this.nextElement = nextElement;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	} 
	
	
	
}
