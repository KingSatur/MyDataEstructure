package treeBinarySearch;

import general.Player;
import tda.InterfaceBinaryTreeSearch;

public class BinaryTree<T, K extends Comparable<K>> implements InterfaceBinaryTreeSearch<T,K>{

	protected NodeBinaryTree<T,K> root;
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

	public NodeBinaryTree<T, K> getRoot() {
		return root;
	}

	public void setRoot(NodeBinaryTree<T, K> root) {
		this.root = root;
	}
	
	@Override
	public void addElement(NodeBinaryTree<T,K> nodeToAdd) {
		addElementSecundary(nodeToAdd, root);
	}
	
	public void addElementSecundary(NodeBinaryTree<T,K> nodeToAdd, NodeBinaryTree<T, K> node) {
		
		if(node == null) {
			if(root == null) {
				root = nodeToAdd;				
			}
		}
		else {
			if(node.isSheet()) {
				if(node.compareTo(nodeToAdd) < 0) {
					node.setRightSon(nodeToAdd);
				}
				if(node.compareTo(nodeToAdd) > 0) {
					node.setLeftSon(nodeToAdd);
				}
			}
			else {
				if(node.compareTo(nodeToAdd) < 0) {
					if(node.getRightSon() == null) {
						node.setRightSon(nodeToAdd);
					}
					else {
						addElementSecundary(nodeToAdd, node.getRightSon());						
					}
				}
				if(node.compareTo(nodeToAdd) > 0) {
					if(node.getLeftSon() == null) {
						node.setLeftSon(nodeToAdd);
					}
					else {
						addElementSecundary(nodeToAdd, node.getLeftSon());
					}
				}
			}
		}
		
		
	}
	
	@Override
	public void delete(K key) {
		deleteSecundary(key, root);
	}
	
	public void deleteSecundary(K key, NodeBinaryTree<T, K> node) {
		
		NodeBinaryTree<T,K> elementToDelete = searchElement(key);
		
		//CASO 1, EL NODO QUE VOY A ELIMINAR ES HOJA
		if(elementToDelete.isSheet()) {
			NodeBinaryTree<T,K> father = searchElementBefore(key);
			if(father == null) {
				root = null;
			}
			else {
				if(father.under(key) == -1) {
					father.setRightSon(null);
				}
				else {
					father.setLeftSon(null);
				}
			}
		}
		//CASO 2, EL NODO QUE VOY A ELIMINAR, TIENE 2 HIJOS O UN HIJO
		else {
			NodeBinaryTree<T,K> father = searchElementBefore(key);
			//EL NODO QUE VOY A ELIMINAR SOLO TIENE EL HIJO DERECHO
			if(elementToDelete.sonNull() == 1) {
				if(father.under(key) == -1) {
					father.setRightSon(elementToDelete.getRightSon());
				}
				if(father.under(key) == 1) {
					father.setLeftSon(elementToDelete.getRightSon());
				}
			}
			//EL NODO QUE VOY A ELIMINAR SOLO TIENE EL HIJO IZQUIERDO
			if(elementToDelete.sonNull() == -1) {
				if(father.under(key) == -1) {
					father.setRightSon(elementToDelete.getLeftSon());
				}
				if(father.under(key) == 1) {
					father.setLeftSon(elementToDelete.getLeftSon());
				}
			}
			//EL NODO QUE VOY A ELIMINAR TIENE DOS HIJOS
			else {
				NodeBinaryTree<T,K> minimumRight = minimum(elementToDelete.getRightSon());
				NodeBinaryTree<T,K> beforeMinimum = searchElementBefore(minimumRight.getKey());
				elementToDelete.setData(minimumRight.getData());
				elementToDelete.setKey(minimumRight.getKey());
				if(beforeMinimum.getKey().equals(minimumRight.getKey())) {
					elementToDelete.setRightSon(minimumRight.getRightSon());
				}
				else {
					if(minimumRight.isSheet()) {
						beforeMinimum.setLeftSon(null);
					}
					else {
						beforeMinimum.setLeftSon(minimumRight.getRightSon());
					}
				}
				
			}
		}
	}
	
	@Override
	public NodeBinaryTree<T, K> minimum(NodeBinaryTree<T, K> node) {
		
		if(node.isSheet()) {
			return node;
		}
		else {
			if(node.getLeftSon() != null) {
				return minimum(node.getLeftSon());
			}
			else {
				return node;
			}
		}
	}

	@Override
	public NodeBinaryTree<T, K> maximum(NodeBinaryTree<T, K> node) {
		
		if(node.isSheet()) {
			return node;
		}
		else {
			if(node.getRightSon() != null) {
				return maximum(node.getRightSon());
			}
			else {
				return node;
			}
		}
	}

	@Override
	public NodeBinaryTree<T, K> searchElementBefore(K key){		
		return searchElementBeforeSecundary(key, root);
	}
	
	public NodeBinaryTree<T, K> searchElementBeforeSecundary(K key, NodeBinaryTree<T, K> node){
	
		if(node.under(key) != 0) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getKey().compareTo(key) > 0) {
					if(node.getLeftSon() != null) {
						return searchElementBeforeSecundary(key, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getKey().compareTo(key) < 0) {
					if(node.getRightSon() != null) {
						return searchElementBeforeSecundary(key, node.getRightSon());
					}
					else {
						return null;
					}
				}
			}
		}
		
		
		return null;
	}
	
	public static void main(String[] args) {
		
		BinaryTree<Player, Integer> jugadores = new BinaryTree<Player, Integer>();
//		jugadores.addElement(new Player("Juan david", 20), 20);
//		jugadores.addElement(new Player("Cristiano", 10), 10);
//		jugadores.addElement(new Player("Rodolfo", 50), 50);
//		jugadores.addElement(new Player("Adolf", 30), 30);
//		jugadores.addElement(new Player("J", 80), 80);
//		jugadores.addElement(new Player("Juan", 90), 90);
//		jugadores.addElement(new Player("David", 100), 100);
//		jugadores.addElement(new Player("Michael", 6), 6);
//		jugadores.addElement(new Player("Michael", 37), 37);
//		jugadores.addElement(new Player("Michael", 56), 56);
//		jugadores.addElement(new Player("Michael", 79), 79);
//		jugadores.addElement(new Player("Michael", 9), 9);
//		jugadores.addElement(new Player("Michael", 3), 3);
		jugadores.delete(20);
		NodeBinaryTree<Player,Integer> jugadorAnterior = jugadores.searchElement(80);
		int j = 100;
		int x = 100;
		int c = j + x;
		

	}

	@Override
	public NodeBinaryTree<T,K> searchElement(K key){
		return searchElementSecundary(key, root);
	}
	
	public NodeBinaryTree<T, K> searchElementSecundary(K key, NodeBinaryTree<T, K> node) {
		
		if(node.getKey() == key) {
			return node;
		}
		else {
			//DERECHA
			if(node.getKey().compareTo(key) == -1) {
				if(node.getRightSon() != null) {
					return searchElementSecundary(key, node.getRightSon());
				}
				else {
					return null;
				}
			}
			//IZQUIERDA
			else {
				if(node.getLeftSon() != null) {
					return searchElementSecundary(key, node.getLeftSon());
				}
				else {
					return null;
				}
			}
		}
		
		
	}
	
	
	
	
	
}
