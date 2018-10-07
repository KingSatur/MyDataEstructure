package dataStructures;

import tda.InterfaceBinaryTreeSearch;

public class BinaryTree<T extends Comparable<T>> implements InterfaceBinaryTreeSearch<T>{

	private NodeBinaryTree<T> root;
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


	public NodeBinaryTree<T> getRoot() {
		return root;
	}

	public void setRoot(NodeBinaryTree<T> root) {
		this.root = root;
	}

	@Override
	public void addElement(T data, NodeBinaryTree<T> node) {
	
		NodeBinaryTree<T> nod = new NodeBinaryTree<T>(data);
		
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
						addElement(data, node.getRightSon());						
					}
				}
				if(node.compareTo(nod) > 0) {
					if(node.getLeftSon() == null) {
						node.setLeftSon(nod);
					}
					else {
						addElement(data, node.getLeftSon());
					}
				}
			}
		}
		
		
	}

	@Override
	public void delete(T data, NodeBinaryTree<T> node) {
		
		NodeBinaryTree<T> node1 = searchElementBefore(data, node);
		
		if(node1 != null) {
			if(node1.under(data) == -1) {
				NodeBinaryTree<T> temporal = node1.getRightSon();
				if(temporal.isSheet()) {
					node1.setRightSon(null);
				}
				else {
					if(temporal.sonNull() == -1) {
						NodeBinaryTree<T> nodeAuxiliar = maximum(temporal.getLeftSon());
						NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == -1) {
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
						NodeBinaryTree<T> nodeAuxiliar = minimum(temporal.getRightSon());
						NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == -1) {
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
				NodeBinaryTree<T> temporal = node1.getLeftSon();
				if(temporal.isSheet()) {
					node1.setLeftSon(null);
				}
				else {
					if(node1.sonNull() == -1) {
						NodeBinaryTree<T> nodeAuxiliar = maximum(temporal.getLeftSon());
						NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == 1) {
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar.getData()) == -1) {
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
						NodeBinaryTree<T> nodeAuxiliar = minimum(temporal.getRightSon());
						NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
						if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == 1) {
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar1.getData()) == -1) {
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
							temporal.setData(nodeAuxiliar.getData());
							if(nodeAuxiliar1.equals(temporal)) {
								if(temporal.under(nodeAuxiliar1.getData()) == -1) {
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
				NodeBinaryTree<T> nodeAuxiliar = maximum(root.getLeftSon());
				NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
				if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == -1) {
					root.setData(nodeAuxiliar.getData());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getData()) == -1) {
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
					root.setData(nodeAuxiliar.getData());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getData()) == -1) {
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
				NodeBinaryTree<T> nodeAuxiliar = minimum(root.getRightSon());
				NodeBinaryTree<T> nodeAuxiliar1 = searchElementBefore(nodeAuxiliar.getData(), node);
				if(nodeAuxiliar1.under(nodeAuxiliar.getData()) == -1) {
					root.setData(nodeAuxiliar.getData());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getData()) == -1) {
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
					root.setData(nodeAuxiliar.getData());
					if(nodeAuxiliar1.equals(root)) {
						if(root.under(nodeAuxiliar1.getData()) == -1) {
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
	public NodeBinaryTree<T> searchElement(T data, NodeBinaryTree<T> node) {
		
		if(node.getData().equals(data)) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getData().compareTo(data) > 0) {
					if(node.getLeftSon() != null) {
						return searchElement(data, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getData().compareTo(data) < 0) {
					if(node.getRightSon() != null) {
						return searchElement(data, node.getRightSon());
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
	public NodeBinaryTree<T> minimum(NodeBinaryTree<T> node) {
		
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
	public NodeBinaryTree<T> maximum(NodeBinaryTree<T> node) {
		
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
	public NodeBinaryTree<T> searchElementBefore(T data, NodeBinaryTree<T> node) {
		
		if(node.under(data) != 0) {
			return node;
		}
		else {
			if(node.isSheet()) {
				return null;
			}
			else {
				if(node.getData().compareTo(data) > 0) {
					if(node.getLeftSon() != null) {
						return searchElementBefore(data, node.getLeftSon());
					}
					else {
						return null;
					}
				}
				if(node.getData().compareTo(data) < 0) {
					if(node.getRightSon() != null) {
						return searchElementBefore(data, node.getRightSon());
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
		BinaryTree<Integer> arbol = new BinaryTree<Integer>();
		arbol.addElement(40, arbol.getRoot());
		arbol.addElement(30, arbol.getRoot());
		arbol.addElement(50, arbol.getRoot());
		arbol.addElement(20, arbol.getRoot());
		arbol.addElement(35, arbol.getRoot());
		arbol.addElement(45, arbol.getRoot());
		arbol.addElement(10, arbol.getRoot());
		arbol.addElement(24, arbol.getRoot());
		arbol.addElement(60, arbol.getRoot());
		arbol.addElement(31, arbol.getRoot());
		arbol.addElement(36, arbol.getRoot());
		arbol.delete(40, arbol.getRoot());
		int c = 100;

	}
	
	
	
	
	
}
