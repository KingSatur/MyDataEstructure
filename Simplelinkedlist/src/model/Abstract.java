package model;

import exceptions.IndexOutOfRangeException;
import exceptions.StackEmptyException;
import tda.InterfaceCampiList;
import tda.InterfaceCampiQueue;
import tda.InterfaceCampiStack;

public class Abstract<T> implements InterfaceCampiList<T>, InterfaceCampiQueue<T>, InterfaceCampiStack<T> {

	private Node<T> firstNode;
	private int size;
	
	public Abstract() {
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
			newNode.setPosition(size - 1);
			firstNode = newNode;
			
		}
		else {
			if(firstNode.getNextElement() == null) {
				Node<T> newNode = new Node<T>(element);
				size++;
				newNode.setPosition(size - 1);
				firstNode.setNextElement(newNode);
			}
			else {
				Node<T> temporallyNode = firstNode;
				while(temporallyNode.getNextElement() != null) {
					temporallyNode = temporallyNode.getNextElement();
				}
				Node<T> newNode = new Node<T>(element);
				size++;
				newNode.setPosition(size - 1);
				temporallyNode.setNextElement(newNode);
			}
		}
	}

	@Override
	public void deleteElement(int position)throws IndexOutOfRangeException {
		
		if(position >= 0 && position < size) {
			Node<T> temporally = firstNode;
			if(temporally.getPosition() == position) {
				if(searchElementAfter(temporally.getData()) != null) {
					substractPosition(temporally);
					firstNode = searchElementAfter(temporally.getData());
				}
				else {
					firstNode = null;
				}
				size--;
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
				size--;
			}
		}
		else {
			throw new IndexOutOfRangeException("Posicion fuera del rango");
		}
		
		
		
	}

	@Override
	public Node<T> searchElement(int position)throws IndexOutOfRangeException {
	
		Node<T> toReturn = null;
 		
		if(position >= 0 && position < size) {
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
	
	
	public Node<T> searchLastElement(){
		
		Node<T> actually = firstNode;
		
		while(actually.getNextElement() != null) {
			actually = actually.getNextElement();
		}
		
		return actually;
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
	public void push(T data) {
		
		if(this.getFirstNode() == null) {
			Node<T> node = new Node<T>(data);
			firstNode = node;
		}
		else {
			Node<T> node = new Node<T>(data);
			node.setNextElement(firstNode);
			firstNode = node;
		}
	}

	@Override
	public Node<T> top() {
		return firstNode;
	}

	@Override
	public T pop()throws StackEmptyException {
		
		T dataDeleted = null;
		
		if(isEmpty()) {
			throw new StackEmptyException("La pila esta vacia");
		}
		else {
			if(top().getNextElement() == null) {
				dataDeleted = top().getData();
				firstNode = null;
			}
			else {
				dataDeleted = firstNode.getData();
				firstNode = firstNode.getNextElement();
			}
		}
		
		return dataDeleted;
	}

	
///////////////////////////////////////////////////////////////////////////
	//Metodos de cola
	@Override
	public Node<T> front() {
		return firstNode;
	}

	@Override
	public void enqueue(T data) {
		
		Node<T> nodeToEnqueue = new Node<T>(data);
		
		if(firstNode == null) {
			firstNode = nodeToEnqueue;
			size ++;
		}
		else {
			if(firstNode.getNextElement() == null) {
				size++;
				nodeToEnqueue.setPosition(size - 1);
				firstNode.setNextElement(nodeToEnqueue);
			}
			else {
				Node<T> temporallyNode = firstNode;
				while(temporallyNode.getNextElement() != null) {
					temporallyNode = temporallyNode.getNextElement();
				}
				size++;
				nodeToEnqueue.setPosition(size - 1);
				temporallyNode.setNextElement(nodeToEnqueue);
			}
		}
	}

	@Override
	public T dequeue()throws StackEmptyException {
		
		T dataDeleted = null;

		if(isEmpty()) {
			throw new StackEmptyException("La cola esta vacia");
		}
		else {
			if(front().getNextElement() == null) {
				dataDeleted = front().getData();
				firstNode = null;
				size --;
			}
			else {
				firstNode = firstNode.getNextElement();
				size--;
			}
		}
						
		return dataDeleted;
		
	}
	
	
}
