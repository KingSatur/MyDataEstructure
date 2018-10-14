package dataStructures;

import tda.InterfaceRedBlackTree;

public class RedBlackTree<T, K extends Comparable<K>> implements InterfaceRedBlackTree<T, K>{

	private NodeRedBlackTree<T,K> root;
	private int BHeight;

	public RedBlackTree() {
		root = null;
		BHeight = 0;
	}
	
	public NodeRedBlackTree<T, K> getRoot() {
		return root;
	}

	public void setRoot(NodeRedBlackTree<T, K> root) {
		this.root = root;
	}

	public int getBHeight() {
		return BHeight;
	}

	public void setBHeight(int bHeight) {
		BHeight = bHeight;
	}

	@Override
	public void leftRotation(NodeRedBlackTree<T,K> node) {
		
		NodeRedBlackTree<T,K> nodeBefore = searchElementBefore(node.getKey(), root);
		NodeRedBlackTree<T,K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey(), root);
		if(nodeBeforeBefore == null) {
			nodeBefore.setRightSon(node.getLeftSon());
			node.setLeftSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == -1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}	
			}
		}
		
	}

	@Override
	public void rightRotation(NodeRedBlackTree<T, K> node) {
		
		NodeRedBlackTree<T,K> nodeBefore = searchElementBefore(node.getKey(), root);
		NodeRedBlackTree<T,K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey(), root);
		if(nodeBeforeBefore == null) {
			nodeBefore.setLeftSon(node.getRightSon());
			node.setRightSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == 1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setLeftSon(node);
				}			
			}
		}
	}

	@Override
	public void addNode(T data, K key, NodeRedBlackTree<T,K> node) {
		
		NodeRedBlackTree<T, K> nod = new NodeRedBlackTree<T, K>(data, key);
		
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
						addNode(data, key, node.getRightSon());						
					}
				}
				if(node.compareTo(nod) > 0) {
					if(node.getLeftSon() == null) {
						node.setLeftSon(nod);
					}
					else {
						addNode(data, key, node.getLeftSon());
					}
				}
			}
		}
		
	}

	@Override
	public void deleteNode(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchUncle(K key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchGrandFather(K key) {
		// TODO Auto-generated method stub
		
	}
	
	public NodeRedBlackTree<T, K> searchNode(K key, NodeRedBlackTree<T, K> node){
		
		if(node.getKey().equals(key)) {
			return node;
		}
		else {
			if(node.getKey().compareTo(key) > 0) {
				if(node.getLeftSon() != null) {
					return searchNode(key, node.getLeftSon());
				}
				else {
					return null;
				}
			}
			if(node.getKey().compareTo(key) < 0) {
				if(node.getRightSon() != null) {
					return searchNode(key, node.getRightSon());
				}
				else {
					return null;
				}
			}			
		}
		
		return null;
		
	}
	
	public NodeRedBlackTree<T,K> searchElementBefore(K key, NodeRedBlackTree<T,K> node){
		
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
 	
	public NodeRedBlackTree<T, K> searchElement(K key, NodeRedBlackTree<T, K> node) {
		
		if(node.getKey().equals(key)) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getKey().compareTo(key) > 0) {
					if(node.getLeftSon() != null) {
						return searchElement(key, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getKey().compareTo(key) < 0) {
					if(node.getRightSon() != null) {
						return searchElement(key, node.getRightSon());
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
		
		RedBlackTree<Player, Integer> jugadores = new RedBlackTree<Player, Integer>();
		jugadores.addNode(new Player("Juan david", 20), 20, jugadores.root);
		jugadores.addNode(new Player("Cristiano", 10), 10, jugadores.root);
		jugadores.addNode(new Player("Rodolfo", 50), 50, jugadores.root);
		jugadores.addNode(new Player("Adolf", 30), 30, jugadores.root);
		jugadores.addNode(new Player("J", 80), 80, jugadores.root);
		jugadores.addNode(new Player("Juan", 90), 90, jugadores.root);
		jugadores.addNode(new Player("David", 100), 100, jugadores.root);
		jugadores.addNode(new Player("Michael", 6), 6, jugadores.root);
		NodeRedBlackTree<Player,Integer> mhj = jugadores.searchElement(10, jugadores.root);
		jugadores.rightRotation(mhj);
		int m = 100;
		
		
		
	}

	
}
