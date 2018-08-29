package model;

import exceptions.IndexOutOfRangeException;
import exceptions.StackEmptyException;
import tda.InterfaceCampiList;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class CampiList<T> implements InterfaceCampiList<T>, InterfaceCampiQueue<T>, InterfaceCampiStack<T> {

	private Node<T> firstNode;
	private int size;
	
	public CampiList() {
		firstNode = null;
		size = 0;
	}
	
	public boolean isArmonic(char a, char b) {
		
		if(a == '{' && b == '}') {
			return true;
		}
		else if(a == '(' && b == ')') {
			return true;
		}
		else if(a == '[' && b == ']') {
			return true;
		}
		else {
			return false;
		}
	}

	
////////////////////////////////////////////////////////////////////////////////////////////////	
	//Metodos de lista
	public Node<T> getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(Node<T> firstNode) {
		this.firstNode = firstNode;
	}

	@Override
	public void addElement(T element) {
		
		if(firstNode == null) {
			Node<T> newNode = new Node<T>(element);
			size++;
			newNode.setPosition(size);
			firstNode = newNode;
			
		}
		else {
			if(firstNode.getNextElement() == null) {
				Node<T> newNode = new Node<T>(element);
				size++;
				newNode.setPosition(size);
				firstNode.setNextElement(newNode);
			}
			else {
				Node<T> temporallyNode = firstNode;
				while(temporallyNode.getNextElement() != null) {
					temporallyNode = temporallyNode.getNextElement();
				}
				Node<T> newNode = new Node<T>(element);
				size++;
				newNode.setPosition(size);
				temporallyNode.setNextElement(newNode);
			}
		}
	}

	@Override
	public void deleteElement(int position)throws IndexOutOfRangeException {
		
		if(position > 0 && position <= size) {
			Node<T> temporally = firstNode;
			if(temporally.getPosition() == position) {
				if(searchElementAfter(temporally.getData()) != null) {
					substractPosition(temporally);
					firstNode = searchElementAfter(temporally.getData());
				}
				else {
					firstNode = null;
				}
			}
			else {
				boolean back = false;
				while(temporally.getNextElement() != null && !back) {
					temporally = temporally.getNextElement();
					if(temporally.getPosition() == position) {
						if(searchElementAfter(temporally.getData()) != null) {
							substractPosition(temporally);
							Node<T> before = searchElementBefore(temporally.getData());
							before.setNextElement(searchElementAfter(temporally.getData()));
							back = true;
						}
						else {
							Node<T> before = searchElementBefore(temporally.getData());
							before.setNextElement(null);
							back = true;
						}
					}
				}
			}
		}
		else {
			throw new IndexOutOfRangeException("Posicion fuera del rango");
		}
		
		
		
	}

	@Override
	public Node<T> searchElement(int position)throws IndexOutOfRangeException {
	
		Node<T> toReturn = null;
 		
		if(position >= 0 && position <= size) {
			Node<T> temporally = firstNode;
			if(temporally.getPosition() == position) {
				toReturn = temporally;
			}
			else {
				boolean back = false;
				while(temporally.getNextElement() != null && !back)  {
					temporally = temporally.getNextElement();
					if(temporally.getPosition() == position) {
						toReturn = temporally;
						back = true;
					}
				}
			}
		}
		else {
			throw new IndexOutOfRangeException("Posicion fuera del rango");
		}
		
		

		return toReturn;
	}
	
	public Node<T> searchElementBefore(T element) {
		
		Node<T> temporally = firstNode;
		Node<T> before = null;

		boolean back = false;
		while(temporally.getNextElement() != null && !back) {
			if(temporally.getNextElement().getData().equals(element)) {
				before = temporally;
				back = true;
			}
			else {
				temporally = temporally.getNextElement();
			}
		}
		
		
		
		return before;
	}
	
	public Node<T> searchElementAfter(T element){
		
		Node<T> temporally = firstNode;
		Node<T> after = null;
		
		boolean back = false;
		while(temporally.getNextElement() != null && !back) {
			if(temporally.getData().equals(element)) {
				after = temporally.getNextElement();
				back = true;
			}
			else {
				temporally = temporally.getNextElement();
			}
			
		}
		return after;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return firstNode == null;
	}
	
	public void substractPosition(Node<T> a) {
		
		Node<T> temporally = a;
		
		if(temporally != null) {
			if(temporally.getNextElement() != null) {
				while(temporally.getNextElement() != null) {
					temporally = temporally.getNextElement();
					temporally.setPosition(temporally.getPosition() - 1);
				}
			}
		}
		
	}

	
///////////////////////////////////////////////////////////////////////////	
	//Metodos de pila
	@Override
	public void push(Node<T> node) {
		
		if(this.getFirstNode() == null) {
//			Node<T> node = new Node<T>(data);
			firstNode = node;
		}
		else {
//			Node<T> node = new Node<T>(data);
			node.setNextElement(firstNode);
			firstNode = node;
		}
	}

	@Override
	public Node<T> top() {
		return firstNode;
	}

	@Override
	public void pop()throws StackEmptyException {
		
		if(isEmpty()) {
			throw new StackEmptyException("La pila esta vacia");
		}
		else {
			if(top().getNextElement() == null) {
				firstNode = null;
			}
			else {
				firstNode = firstNode.getNextElement();
			}
		}	
	}

	
///////////////////////////////////////////////////////////////////////////
	//Metodos de cola
	@Override
	public Node<T> front() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enqueue(Node<T> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node<T> dequeue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
