package treeRedBlack;

import general.Player;
import general.TreeWithRotation;
import tda.InterfaceRedBlackTree;

public class RedBlackTree<T, K extends Comparable<K>> extends TreeWithRotation<T,K> implements InterfaceRedBlackTree<T,K> {

	@Override
	public void addNode(T data, K key) {
		
		addElement(new NodeRedBlack<T,K>(data, key));
		NodeRedBlack<T,K> searchRecentlyAdded = (NodeRedBlack<T, K>) searchElement(key);
		searchRecentlyAdded.setColor(NodeRedBlack.RED);
		addFixUp(searchRecentlyAdded);
	}
	
	@Override
	public void deleteNode(K key) {
		// TODO Auto-generated method stub
		
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
		for(int i = 0; i < 1000000; i ++) {
			jugadores.addNode(new Player("Player" + (i + 1), (i + 1)*2) ,(i + 1)*2);
		}
//		jugadores.addNode(new Player("Juan david", 20), 20);
//		jugadores.addNode(new Player("Cristiano", 10), 10);
//		jugadores.addNode(new Player("Rodolfo", 50), 50);
//		jugadores.addNode(new Player("Adolf", 30), 30);
//		jugadores.addNode(new Player("J", 80), 80);
//		jugadores.addNode(new Player("Juan", 90), 90);
//		jugadores.addNode(new Player("David", 100), 100);
//		jugadores.addNode(new Player("Michael", 6), 6);
//		jugadores.addNode(new Player("Clone", 300), 300);
//		jugadores.addNode(new Player("Adolf5", 21), 21);
//		jugadores.addNode(new Player("J4", 4), 4);
//		jugadores.addNode(new Player("Juan13", 13), 13);
//		jugadores.addNode(new Player("David17", 17), 17);
//		jugadores.addNode(new Player("Michael51", 51), 51);
//		jugadores.addNode(new Player("Clone87", 87), 87);
		
//		NodeRedBlackTree<Player,Integer> mhj = jugadores.searchElement(10, jugadores.root);
//		NodeRedBlackTree<Player,Integer> mhj1 = jugadores.searchUncle(100);
//		jugadores.rightRotation(mhj);
		System.out.println((2*19) / 5);
		int m = 100;
		int x = 40;
		int c = m + x;
		
		
	}

	
	
	
}
