package dataStructures;

public class NodeBinaryTree<T extends Comparable<T>> implements Comparable<NodeBinaryTree<T>> {

	private T data;
	private NodeBinaryTree<T> leftSon;
	private NodeBinaryTree<T> rightSon;
	
	public NodeBinaryTree(T data) {
		this.data = data;
		leftSon = null;
		rightSon = null;
	}
	
	public boolean isSheet() {
		if(leftSon == null && rightSon == null) {
			return true;
		}
		else {
			return false;
		}
	}

	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public NodeBinaryTree<T> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodeBinaryTree<T> leftSon) {
		this.leftSon = leftSon;
	}

	public NodeBinaryTree<T> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodeBinaryTree<T> rightSon) {
		this.rightSon = rightSon;
	}

	@Override
	public int compareTo(NodeBinaryTree<T> o) {
		return data.compareTo(o.getData());
	}

	public int under(T data) {
		
		if(leftSon.getData().equals(data)) {
			return 1;
		}
		if(rightSon.getData().equals(data)) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public int sonNull() {
		
		if(leftSon == null) {
			return 1;
		}
		if(rightSon == null) {
			return -1;
		}
		else {
			return 0;
		}
		
		
	}
	
	
	
}
