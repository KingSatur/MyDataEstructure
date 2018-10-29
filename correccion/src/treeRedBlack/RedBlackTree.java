package treeRedBlack;

import general.Player;
import general.TreeWithRotation;
import tda.InterfaceRedBlackTree;
import treeBinarySearch.NodeBinaryTree;

public class RedBlackTree<T, K extends Comparable<K>> extends TreeWithRotation<T,K> implements InterfaceRedBlackTree<T,K> {

	private NodeRedBlack<T,K> nodeWithDoubleBlack;
	private NodeRedBlack<T,K> nodeFatherOfDoubleBlack;
	
	public RedBlackTree() {
		super();
		nodeWithDoubleBlack = null;
		nodeFatherOfDoubleBlack = null;
	}
	
	@Override
	public void addNode(T data, K key) {
		
		addElement(new NodeRedBlack<T,K>(data, key));
		NodeRedBlack<T,K> searchRecentlyAdded = (NodeRedBlack<T, K>) searchElement(key);
		searchRecentlyAdded.setColor(NodeRedBlack.RED);
		addFixUp(searchRecentlyAdded);
	}
	
	@Override
	public void deleteNode(K key) {
			
		NodeRedBlack<T,K> elementToDelete = (NodeRedBlack<T, K>) searchElement(key);
		
		//CASO 1, EL NODO QUE VOY A ELIMINAR ES HOJA
		if(elementToDelete.isSheet()) {
			NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(key);
			if(father == null) {
				root = null;
			}
			else {
				if(father.under(key) == -1) {
					if(elementToDelete.getColor().equals(NodeRedBlack.RED)) {
						father.setRightSon(null);
					}
					else {
						NodeRedBlack<T,K> m = new NodeRedBlack<T,K>(null, null);
						m.setDoubleBlack(true);
						father.setRightSon(m);
						nodeWithDoubleBlack = m;
						nodeFatherOfDoubleBlack = father;
					}
					
				}
				else {
					if(elementToDelete.getColor().equals(NodeRedBlack.RED)) {
						father.setLeftSon(null);
					}
					else {
						NodeRedBlack<T,K> m = new NodeRedBlack<T,K>(null, null);
						m.setDoubleBlack(true);
						father.setLeftSon(m);
						nodeWithDoubleBlack = m;
						nodeFatherOfDoubleBlack = father;
					}
				}
			}
		}
		//CASO 2, EL NODO QUE VOY A ELIMINAR, TIENE 2 HIJOS O UN HIJO
		else {
			NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(key);
			//EL NODO QUE VOY A ELIMINAR SOLO TIENE EL HIJO DERECHO
			if(elementToDelete.sonNull() == 1) {
				if(father.under(key) == -1) {
					String color  = elementToDelete.getColor();
					if(((NodeRedBlack<T,K>)elementToDelete.getRightSon()).getColor().equals(NodeRedBlack.BLACK)) {
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setDoubleBlack(true);
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setColor(color);
						father.setRightSon(elementToDelete.getRightSon());
						nodeWithDoubleBlack = (NodeRedBlack<T, K>) father.getRightSon();
						nodeFatherOfDoubleBlack = father;
					}
					else {
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setColor(color);
						father.setRightSon(elementToDelete.getRightSon());
					}
				}
				if(father.under(key) == 1) {
					String color = elementToDelete.getColor();
					if(((NodeRedBlack<T,K>)elementToDelete.getRightSon()).getColor().equals(NodeRedBlack.BLACK)) {
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setDoubleBlack(true);
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setColor(color);
						father.setLeftSon(elementToDelete.getRightSon());
						nodeWithDoubleBlack = (NodeRedBlack<T, K>) father.getLeftSon();
						nodeFatherOfDoubleBlack = father;
					}
					else {
						((NodeRedBlack<T,K>)elementToDelete.getRightSon()).setColor(color);
						father.setLeftSon(elementToDelete.getRightSon());
					}
				}
			}
			//EL NODO QUE VOY A ELIMINAR SOLO TIENE EL HIJO IZQUIERDO
			if(elementToDelete.sonNull() == -1) {
				if(father.under(key) == -1) {
					String color  = elementToDelete.getColor();
					if(((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).getColor().equals(NodeRedBlack.BLACK)) {
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setDoubleBlack(true);
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setColor(color);
						father.setRightSon(elementToDelete.getLeftSon());
						nodeWithDoubleBlack = (NodeRedBlack<T, K>) father.getRightSon();
						nodeFatherOfDoubleBlack = father;
					}
					else {
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setColor(color);
						father.setRightSon(elementToDelete.getLeftSon());
					}
				}
				if(father.under(key) == 1) {
					String color  = elementToDelete.getColor();
					if(((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).getColor().equals(NodeRedBlack.BLACK)) {
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setDoubleBlack(true);
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setColor(color);
						father.setLeftSon(elementToDelete.getLeftSon());
						nodeWithDoubleBlack = (NodeRedBlack<T, K>) father.getLeftSon();
						nodeFatherOfDoubleBlack = father;
					}
					else {
						((NodeRedBlack<T,K>)elementToDelete.getLeftSon()).setColor(color);
						father.setLeftSon(elementToDelete.getLeftSon());
					}
				}
			}
			//EL NODO QUE VOY A ELIMINAR TIENE DOS HIJOS
			else if(elementToDelete.sonNull() == 0){
				NodeRedBlack<T,K> minimumRight = (NodeRedBlack<T, K>) minimum(elementToDelete.getRightSon());
				NodeRedBlack<T,K> beforeMinimum = (NodeRedBlack<T, K>) searchElementBefore(minimumRight.getKey());
				elementToDelete.setData(minimumRight.getData());
				elementToDelete.setKey(minimumRight.getKey());
				if(beforeMinimum.getKey().equals(minimumRight.getKey())) {
					if(minimumRight.getColor().equals(NodeRedBlack.RED)) {
						elementToDelete.setRightSon(minimumRight.getRightSon());
					}
					else {
						NodeRedBlack<T,K> m = new NodeRedBlack<T,K>(null, null);
						m.setDoubleBlack(true);
						elementToDelete.setRightSon(m);
						nodeWithDoubleBlack = m;
						nodeFatherOfDoubleBlack = elementToDelete;
					}
				}
				else {
					if(minimumRight.isSheet()) {
						if(minimumRight.getColor().equals(NodeRedBlack.RED)) {
							beforeMinimum.setLeftSon(null);	
						}
						else {
							NodeRedBlack<T,K> m = new NodeRedBlack<T,K>(null, null);
							m.setDoubleBlack(true);
							beforeMinimum.setLeftSon(m);
							nodeWithDoubleBlack = m;
							nodeFatherOfDoubleBlack = beforeMinimum;
						}
					}
					else {
						if(minimumRight.getColor().equals(NodeRedBlack.RED)) {
							beforeMinimum.setLeftSon(minimumRight.getRightSon());	
						}
						else {
							beforeMinimum.setLeftSon(minimumRight.getRightSon());
							((NodeRedBlack<T,K>)beforeMinimum.getLeftSon()).setDoubleBlack(true);
							nodeWithDoubleBlack = (NodeRedBlack<T,K>)beforeMinimum.getLeftSon();
							nodeFatherOfDoubleBlack = elementToDelete;
							nodeFatherOfDoubleBlack = beforeMinimum;
						}
					}
				}
				
			}
		}
	}

	@Override
	public NodeRedBlack<T, K> searchUncle(K key) {
		
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(key);
		NodeRedBlack<T,K> grandFather = (NodeRedBlack<T, K>) searchElementBefore(father.getKey());
		if(grandFather.under(father.getKey()) == -1) {
			return (NodeRedBlack<T, K>) grandFather.getLeftSon();
		}
		else {
			return (NodeRedBlack<T, K>) grandFather.getRightSon();
		}
	}

	@Override
	public NodeRedBlack<T, K> searchGrandFather(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addFixUp(NodeRedBlack<T, K> nodeAdded) {
		
		NodeRedBlack<T,K> z = nodeAdded;
		
		if(z.equals(root)) {
			if(z.getColor().equals(NodeRedBlack.RED)) {
				((NodeRedBlack<T, K>) root).changeColor();
			}
		}
		else {
			boolean salir = false;
			while(searchElementBefore(z.getKey()) != null && (((NodeRedBlack<T, K>) searchElementBefore(z.getKey())).getColor().equals(NodeRedBlack.RED)) && salir == false) {
					//CASO EN EL PADRE SEA ROJO Y QUE EL TIO SEA NEGRO O NULL, SI ES NULO TAMBIEN SERA NEGRO
					if(searchUncle(z.getKey()) == null || searchUncle(z.getKey()).getColor().equals(NodeRedBlack.BLACK)) {
						NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(z.getKey());
						NodeRedBlack<T,K> grandFather = (NodeRedBlack<T, K>) searchElementBefore(father.getKey());
						NodeRedBlack<T,K> uncle = searchUncle(z.getKey());
						//SI MI TIO NEGRO NULO ES HIJO IZQUIERDO
						if(grandFather.sonNull() == 1) {
							if(father.under(z.getKey()) == -1) {
								//CASO 4, MI TIO ES NULO NEGRO IZQUIERDO, YO SOY HIJO DERECHO, SE FORMA LINEA
								z = caseFourAdd(z);
							}
							else {
								z = caseThreeAdd(z);
							}
						}
						//MI TIO NEGRO NULO ES HIJO DERECHO
						else if(grandFather.sonNull() == -1){
							//SI MI TIO DERECHO NULO Y YO SOY HIJO IZQUIERDO
							if(father.under(z.getKey()) == 1) {
								z = caseFourAdd(z);
							}
							//SI MI TIO DERECHO NEGRO NULO Y YO SOY HIJO DERECHO
							else {
								//CASO 3, TRIANGULO
								z = caseThreeAdd(z);
							}
						}
						else {
							//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO
							if(grandFather.under(uncle.getKey()) == -1) {
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseThreeAdd(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseFourAdd(z);
								}
							}
							//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO
							else {
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseFourAdd(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseThreeAdd(z);
								}
							}
						}
					}
					if(searchElementBefore(searchElementBefore(z.getKey()).getKey()) != null) {
						if(searchUncle(z.getKey()).getColor().equals(NodeRedBlack.RED)) {
							z = caseTwoAdd(z);							
						}
					}
					if(z.equals(root)) {
						if(z.getColor().equals(NodeRedBlack.RED)) {
							z.changeColor();
							salir = true;
						}
					
					}
				}
			}	
	
		
		
	}
	
	public NodeRedBlack<T,K> caseTwoAdd(NodeRedBlack<T,K> pointer) {
		
		NodeRedBlack<T,K> uncle = searchUncle(pointer.getKey());
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(pointer.getKey());
		NodeRedBlack<T,K> grandFather = (NodeRedBlack<T, K>) searchElementBefore(father.getKey());
		uncle.setColor(NodeRedBlack.BLACK);
		father.setColor(NodeRedBlack.BLACK);
		grandFather.setColor(NodeRedBlack.RED);
		
		return grandFather;
		
	}
	
	public NodeRedBlack<T,K> caseThreeAdd(NodeRedBlack<T,K> pointer){
		
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(pointer.getKey());
		if(father.under(pointer.getKey()) == -1) {
			leftRotation(pointer);
		}
		else {
			rightRotation(pointer);
		}
			
		return father;
	}
	
	public NodeRedBlack<T,K> caseFourAdd(NodeRedBlack<T,K> pointer){
		
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(pointer.getKey());
		NodeRedBlack<T,K> grandFather = (NodeRedBlack<T, K>) searchElementBefore(father.getKey());
		if(grandFather.under(father.getKey()) == 1) {
			rightRotation(father);
			father.changeColor();
			grandFather.changeColor();
			
		}
		else {
			leftRotation(father);
			father.changeColor();
			grandFather.changeColor();
		}
		
		return pointer;
		
	}
	
	@Override
	public void deleteFixUp(K key) {
		
		boolean back = false;
		while(!back) {
			
			if((((NodeRedBlack<T,K>)root)).isDoubleBlack()) {
				caseOneDelete();
			}
			else {
				if(nodeFatherOfDoubleBlack.getColor().equals(NodeRedBlack.BLACK)) {
					if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
						if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).getColor().equals(NodeRedBlack.BLACK)){
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()).getColor().equals(NodeRedBlack.RED)) {
								caseFiveDelete();
							}
							
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()).getColor().equals(nodeFatherOfDoubleBlack.getColor()) && ((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getRightSon()).getColor().equals(NodeRedBlack.RED)) {
								caseSixDelete();
							}
							else {
								caseThreeDelete();
							}	
						}
						else {
							caseTwoDelete();
						}
					}
					if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)) {
						if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).getColor().equals(NodeRedBlack.BLACK)){
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getRightSon()).getColor().equals(NodeRedBlack.RED)) {
								caseFiveDelete();
							}
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getRightSon()).getColor().equals(nodeFatherOfDoubleBlack.getColor()) && ((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getLeftSon()).getColor().equals(NodeRedBlack.RED)) {
								caseSixDelete();
							}
							else {
								caseThreeDelete();
							}	
						}
						else {
							caseTwoDelete();
						}
					}
				}
				else {
					if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)) {
						if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).getColor().equals(NodeRedBlack.BLACK)){
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getRightSon()).getColor().equals(nodeFatherOfDoubleBlack.getColor()) && ((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getLeftSon()).getColor().equals(NodeRedBlack.RED)){
								caseSixDelete();
							}
							else {
								caseFourDelete();
							}
						}
					}
					else {
						if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).getColor().equals(NodeRedBlack.BLACK)){
							if(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()).getColor().equals(nodeFatherOfDoubleBlack.getColor()) && ((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getRightSon()).getColor().equals(NodeRedBlack.RED)){
								caseSixDelete();
							}
							else {
								caseFourDelete();
							}
						}
					}
					
				}
				
			}
			
			
			
			
			
		}
		
		
	}
	
	//CASO 1, EL NODO ES LA RAIZ, TIENE DOBLE NEGRO, LO QUITAMOS Y QUEDA NEGRA, CASO TERMINAL
	public void caseOneDelete() {
		((NodeRedBlack<T,K>) root).setDoubleBlack(false);
	}
	
	public void caseTwoDelete() {
		
		if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).setColor(nodeFatherOfDoubleBlack.getColor());
			nodeFatherOfDoubleBlack.changeColor();
			leftRotation(nodeFatherOfDoubleBlack.getRightSon());
		}
		if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)) {
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).setColor(nodeFatherOfDoubleBlack.getColor());
			nodeFatherOfDoubleBlack.changeColor();
			rightRotation(nodeFatherOfDoubleBlack.getLeftSon());
		}
	}
	
	public void caseThreeDelete() {
		
		if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
			nodeFatherOfDoubleBlack.setDoubleBlack(true);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).setDoubleBlack(false);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).changeColor();
		}
		if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)){
			nodeFatherOfDoubleBlack.setDoubleBlack(true);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).setDoubleBlack(false);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).changeColor();
		}
		
	}
	
	public void caseFourDelete() {
		
		if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
			nodeFatherOfDoubleBlack.changeColor();
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).setDoubleBlack(false);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).changeColor();
		}
		if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)){
			nodeFatherOfDoubleBlack.changeColor();
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).setDoubleBlack(false);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).changeColor();
		}
		
		
	}
	
	public void caseFiveDelete() {
		
		if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).changeColor();
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()).changeColor();
			rightRotation(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()));
		}
		if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)){
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).changeColor();
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getRightSon()).changeColor();
			leftRotation(((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getLeftSon()));
		}
	}
	
	public void caseSixDelete() {
		
		if(nodeFatherOfDoubleBlack.getLeftSon().equals(nodeWithDoubleBlack)) {
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon()).setColor(nodeFatherOfDoubleBlack.getColor());
			nodeFatherOfDoubleBlack.setColor(NodeRedBlack.BLACK);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon().getRightSon()).setColor(NodeRedBlack.BLACK);
			leftRotation((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getRightSon());
		}
		if(nodeFatherOfDoubleBlack.getRightSon().equals(nodeWithDoubleBlack)){
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon()).setColor(nodeFatherOfDoubleBlack.getColor());
			nodeFatherOfDoubleBlack.setColor(NodeRedBlack.BLACK);
			((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon().getLeftSon()).setColor(NodeRedBlack.BLACK);
			rightRotation((NodeRedBlack<T,K>)nodeFatherOfDoubleBlack.getLeftSon());
		}
	
	}
	
	public static void main(String[] args) {
		
		RedBlackTree<Player, Integer> jugadores = new RedBlackTree<Player, Integer>();
//		for(int i = 0; i < 1000000; i ++) {
//			jugadores.addNode(new Player("Player" + (i + 1), (i + 1)*2) ,(i + 1)*2);
//		}
		jugadores.addNode(new Player("Juan david", 20), 20);
		jugadores.addNode(new Player("Cristiano", 10), 10);
		jugadores.addNode(new Player("Rodolfo", 50), 50);
		jugadores.addNode(new Player("Adolf", 30), 30);
		jugadores.addNode(new Player("J", 80), 80);
		jugadores.addNode(new Player("Juan", 90), 90);
		jugadores.addNode(new Player("David", 100), 100);
		jugadores.addNode(new Player("Michael", 6), 6);
		jugadores.addNode(new Player("Clone", 300), 300);
		jugadores.addNode(new Player("Adolf5", 21), 21);
		jugadores.addNode(new Player("J4", 4), 4);
		jugadores.addNode(new Player("Juan13", 13), 13);
		jugadores.addNode(new Player("David17", 17), 17);
		jugadores.addNode(new Player("Michael51", 51), 51);
		jugadores.addNode(new Player("Clone87", 87), 87);
		jugadores.addNode(new Player("Juan13", 45), 45);
		jugadores.addNode(new Player("David17", 69), 69);
		jugadores.addNode(new Player("Michael51", 34), 34);
		jugadores.addNode(new Player("Clone87", 29), 29);
		jugadores.deleteNode(80);
//		NodeRedBlackTree<Player,Integer> mhj1 = jugadores.searchUncle(100);
//		jugadores.rightRotation(mhj);
		System.out.println((2*19) / 5);
		int m = 100;
		int x = 40;
		int c = m + x;
		
		
	}



	
	
	
}

































































































