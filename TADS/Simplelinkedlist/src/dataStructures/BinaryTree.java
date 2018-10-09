package dataStructures;

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
		
		NodeBinaryTree<T, K> node1 = searchElementBefore(key, node);
		
		if(node1 != null) {
			if(node1.under(key) == -1) {
				NodeBinaryTree<T, K> temporal = node1.getRightSon();
				if(temporal.isSheet()) {
					node1.setRightSon(null);
				}
				else {
					if(temporal.sonNull() == -1) {
						NodeBinaryTree<T, K> nodeAuxiliar = maximum(temporal.getLeftSon());
						NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == -1) {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setRightSon(null);								
							}
						}
						else {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setLeftSon(null);								
							}
						}
						int c = 100;
					}
					if(node1.sonNull() == 1 || node1.sonNull() == 0 ) {
						NodeBinaryTree<T, K> nodeAuxiliar = minimum(temporal.getRightSon());
						NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == -1) {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setRightSon(null);								
							}
						}
						else {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setLeftSon(null);								
							}
						}
						int c = 100;
					}
				}
			}
			else {
				NodeBinaryTree<T, K> temporal = node1.getLeftSon();
				if(temporal.isSheet()) {
					node1.setLeftSon(null);
				}
				else {
					if(node1.sonNull() == -1) {
						NodeBinaryTree<T, K> nodeAuxiliar = maximum(temporal.getLeftSon());
						NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == 1) {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setLeftSon(null);								
							}
							int x = 0;
						}
						else {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setRightSon(null);								
							}
						}
						int c = 100;
					}
					if(node1.sonNull() == 1 || node1.sonNull() == 0) {
						NodeBinaryTree<T, K> nodeAuxiliar = minimum(temporal.getRightSon());
						NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == 1) {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar1.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setLeftSon(null);								
							}
							int x = 0;
						}
						else {
							temporal.setKey(nodeAuxiliar.getKey());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar1.getKey()) == -1) {
									temporal.setRightSon(null);
								}
								else {
									temporal.setLeftSon(null);
								}
							}
							else {
								nodeAuxiliar1.setRightSon(null);								
							}
							int x = 0;
						}
						int c = 100;
					}
				}
			}
		}
		else {
			if(root.sonNull() == -1) {
				NodeBinaryTree<T, K> nodeAuxiliar = maximum(root.getLeftSon());
				NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
				if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == -1) {
					root.setKey(nodeAuxiliar.getKey());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getKey()) == -1) {
							root.setRightSon(null);
						}
						else {
							root.setLeftSon(null);
						}
					}
					else {
						nodeAuxiliar1.setRightSon(null);								
					}
					int x = 0;
				}
				else {
					root.setKey(nodeAuxiliar.getKey());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getKey()) == -1) {
							root.setRightSon(null);
						}
						else {
							root.setLeftSon(null);
						}
					}
					else {
						nodeAuxiliar1.setLeftSon(null);								
					}
					int x = 0;
				}
				int c = 100; 
			}
			if(root.sonNull() == 1 || root.sonNull() == 0 ) {
				NodeBinaryTree<T, K> nodeAuxiliar = minimum(root.getRightSon());
				NodeBinaryTree<T, K> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getKey(), node);
				if(nodeAuxiliar1.under(nodeAuxiliar.getKey()) == -1) {
					root.setKey(nodeAuxiliar.getKey());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getKey()) == -1) {
							root.setRightSon(null);
						}
						else {
							root.setLeftSon(null);
						}
					}
					else {
						nodeAuxiliar1.setRightSon(null);								
					}
					int x = 0;
				}
				else {
					root.setKey(nodeAuxiliar.getKey());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getKey()) == -1) {
							root.setRightSon(null);
						}
						else {
							root.setLeftSon(null);
						}
					}
					else {
						nodeAuxiliar1.setLeftSon(null);								
					}
					int x = 0;
				}
				int c = 100; 
			}
		}
		
	}

	@Override
	public NodeBinaryTree<T, K> searchElement(K key, NodeBinaryTree<T, K> node) {
		
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
	public NodeBinaryTree<T, K> searchElementBefore(K key, NodeBinaryTree<T, K> node) {
		
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
//		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
//		arbol.addElement(40, arbol.getRoot());
//		arbol.addElement(30, arbol.getRoot());
//		arbol.addElement(50, arbol.getRoot());
//		arbol.addElement(20, arbol.getRoot());
//		arbol.addElement(35, arbol.getRoot());
//		arbol.addElement(45, arbol.getRoot());
//		arbol.addElement(10, arbol.getRoot());
//		arbol.addElement(24, arbol.getRoot());
//		arbol.addElement(60, arbol.getRoot());
//		arbol.addElement(31, arbol.getRoot());
//		arbol.addElement(36, arbol.getRoot());
//		arbol.delete(40, arbol.getRoot());
//		int c = 100;

	}
	
	
	
	
	
}
