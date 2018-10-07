package tda;
import dataStructures.NodeBinaryTree;

public interface InterfaceBinaryTreeSearch<T extends Comparable<T>> {

	public void addElement(T data, NodeBinaryTree<T> node);
	
	public void delete(T data, NodeBinaryTree<T> node);
	
	public NodeBinaryTree<T> searchElement(T data,  NodeBinaryTree<T> node);
	
	public NodeBinaryTree<T> minimum(NodeBinaryTree<T> node);
	
	public NodeBinaryTree<T> maximum(NodeBinaryTree<T> node);
	
	public NodeBinaryTree<T> searchElementBefore(T data,  NodeBinaryTree<T> node);

}
