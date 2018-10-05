package dataStructures;

public class NodeTree<T> {

	private T data;
	private NodeAbstract<T> leftSon;
	private NodeAbstract<T> rightSon;
	
	public NodeTree(T data) {
		this.data = data;
		leftSon = null;
		rightSon = null;
	}
	
	public boolean isSheet() {
		return false;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public NodeAbstract<T> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(NodeAbstract<T> leftSon) {
		this.leftSon = leftSon;
	}

	public NodeAbstract<T> getRightSon() {
		return rightSon;
	}

	public void setRightSon(NodeAbstract<T> rightSon) {
		this.rightSon = rightSon;
	}
	
	
	
}
