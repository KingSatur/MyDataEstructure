package tree;

import tda.InterfaceBinaryTreeSearch;

public class BinaryTree<T, K extends Comparable<K>> implements InterfaceBinaryTreeSearch<T,K>{

	private NodeBinaryTree<T,K> root;
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
	public void addElement(T data, K key, NodeBinaryTree<T, K> node) {

		NodeBinaryTree<T, K> nod = new NodeBinaryTree<T, K>(data, key);
		
		if(node == null) {
			if(root == null) {
				root = nod;				
			}
		}
		else {
			if(node.isSheet()) {
				if(node.compareTo(nod) < 0) {
					node.setRightSon(nod);
				}
				if(node.compareTo(nod) > 0) {
					node.setLeftSon(nod);
				}
			}
			else {
				if(node.compareTo(nod) < 0) {
					if(node.getRightSon() == null) {
						node.setRightSon(nod);
					}
					else {
						addElement(data, key, node.getRightSon());						
					}
				}
				if(node.compareTo(nod) > 0) {
					if(node.getLeftSon() == null) {
						node.setLeftSon(nod);
					}
					else {
						addElement(data, key, node.getLeftSon());
					}
				}
			}
		}
		
		
	}
	
	@Override
	public void delete(K key, NodeBinaryTree<T, K> node) {
		
		NodeBinaryTree<T,K> elementToDelete = searchElement(key, root);
		//CASO 1, EL NODO QUE VOY A ELIMINAR ES HOJA
		if(elementToDelete.isSheet()) {
			NodeBinaryTree<T,K> father = searchElementBefore(key, root);
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
			NodeBinaryTree<T,K> father = searchElementBefore(key, root);
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
				NodeBinaryTree<T,K> beforeMinimum = searchElementBefore(minimumRight.getKey(), root);
				elementToDelete.setData(minimumRight.getData());
				elementToDelete.setKey(minimumRight.getKey());
				if(beforeMinimum.getKey().equals(minimumRight.getKey())) {
					elementToDelete.setRightSon(minimumRight.getRightSon());
				}
				else {
					beforeMinimum.setLeftSon(null);
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
	public NodeBinaryTree<T, K> searchElementBefore(K key, NodeBinaryTree<T, K> node){
	
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
						return searchElementBefore(key, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getKey().compareTo(key) < 0) {
					if(node.getRightSon() != null) {
						return searchElementBefore(key, node.getRightSon());
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
		jugadores.addElement(new Player("Juan david", 20), 20, jugadores.root);
		jugadores.addElement(new Player("Cristiano", 10), 10, jugadores.root);
		jugadores.addElement(new Player("Rodolfo", 50), 50, jugadores.root);
		jugadores.addElement(new Player("Adolf", 30), 30, jugadores.root);
		jugadores.addElement(new Player("J", 80), 80, jugadores.root);
		jugadores.addElement(new Player("Juan", 90), 90, jugadores.root);
		jugadores.addElement(new Player("David", 100), 100, jugadores.root);
		jugadores.addElement(new Player("Michael", 6), 6, jugadores.root);
		jugadores.delete(50, jugadores.root);
		NodeBinaryTree<Player,Integer> jugadorAnterior = jugadores.searchElement(100, jugadores.root);
		int j = 100;
		int x = 100;
		int c = j + x;
		

	}

	@Override
	public NodeBinaryTree<T, K> searchElement(K key, NodeBinaryTree<T, K> node) {
		
		if(node.getKey() == key) {
			return node;
		}
		else {
			//DERECHA
			if(node.getKey().compareTo(key) == -1) {
				if(node.getRightSon() != null) {
					return searchElement(key, node.getRightSon());
				}
				else {
					return null;
				}
			}
			//IZQUIERDA
			else {
				if(node.getLeftSon() != null) {
					return searchElement(key, node.getLeftSon());
				}
				else {
					return null;
				}
			}
		}
		
		
	}
	
	
	
	
	
}
