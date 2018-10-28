package tda;
import treeBinarySearch.NodeBinaryTree;

public interface InterfaceBinaryTreeSearch<T, K extends Comparable<K>> {

	public void addElement(NodeBinaryTree<T,K> nodeToAdd);
	
	public void delete(K key);
	
	public NodeBinaryTree<T, K> searchElement(K key);
	
	public NodeBinaryTree<T, K> minimum(NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> maximum(NodeBinaryTree<T, K> node);
	
	public NodeBinaryTree<T, K> searchElementBefore(K key);

}
