package treeRedBlack;

import general.Player;
import general.TreeWithRotation;
import tda.InterfaceRedBlackTree;
import treeBinarySearch.NodeBinaryTree;

public class RedBlackTree<T, K extends Comparable<K>> extends TreeWithRotation<T,K> implements InterfaceRedBlackTree<T,K> {

	private NodeRedBlack<T,K> nodeWithDoubleBlack;
	
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
								z = caseFour(z);
							}
							else {
								z = caseThree(z);
							}
						}
						//MI TIO NEGRO NULO ES HIJO DERECHO
						else if(grandFather.sonNull() == -1){
							//SI MI TIO DERECHO NULO Y YO SOY HIJO IZQUIERDO
							if(father.under(z.getKey()) == 1) {
								z = caseFour(z);
							}
							//SI MI TIO DERECHO NEGRO NULO Y YO SOY HIJO DERECHO
							else {
								//CASO 3, TRIANGULO
								z = caseThree(z);
							}
						}
						else {
							//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO
							if(grandFather.under(uncle.getKey()) == -1) {
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseThree(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO DERECHO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseFour(z);
								}
							}
							//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO
							else {
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO DERECHO DE MI PAPA.
								if(father.under(z.getKey()) == -1) {
									z = caseFour(z);
								}
								//SI MI TIO ES NO NULO Y ES HIJO IZQUIERDO DE MI ABUELO, SOY HIJO IZQUIERDO DE MI PAPA.
								else {
									z = caseThree(z);
								}
							}
						}
					}
					if(searchElementBefore(searchElementBefore(z.getKey()).getKey()) != null) {
						if(searchUncle(z.getKey()).getColor().equals(NodeRedBlack.RED)) {
							z = caseTwo(z);							
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
	

	
	
	
	public NodeRedBlack<T,K> caseTwo(NodeRedBlack<T,K> pointer) {
		
		NodeRedBlack<T,K> uncle = searchUncle(pointer.getKey());
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(pointer.getKey());
		NodeRedBlack<T,K> grandFather = (NodeRedBlack<T, K>) searchElementBefore(father.getKey());
		uncle.setColor(NodeRedBlack.BLACK);
		father.setColor(NodeRedBlack.BLACK);
		grandFather.setColor(NodeRedBlack.RED);
		
		return grandFather;
		
	}
	
	public NodeRedBlack<T,K> caseThree(NodeRedBlack<T,K> pointer){
		
		NodeRedBlack<T,K> father = (NodeRedBlack<T, K>) searchElementBefore(pointer.getKey());
		if(father.under(pointer.getKey()) == -1) {
			leftRotation(pointer);
		}
		else {
			rightRotation(pointer);
		}
			
		return father;
	}
	
	public NodeRedBlack<T,K> caseFour(NodeRedBlack<T,K> pointer){
		
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
		jugadores.deleteNode(100);
//		NodeRedBlackTree<Player,Integer> mhj1 = jugadores.searchUncle(100);
//		jugadores.rightRotation(mhj);
		System.out.println((2*19) / 5);
		int m = 100;
		int x = 40;
		int c = m + x;
		
		
	}

	@Override
	public void deleteFixUp(K key) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}