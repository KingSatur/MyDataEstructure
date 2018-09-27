package model;

public class NodeHash<K, T> {

	private T dataContainer;
	private K identifier;

	public NodeHash(T dataContainer, K identifier) {
		this.dataContainer = dataContainer;
		this.identifier = identifier;
	}
		
	public T getDataContainer() {
		return dataContainer;
	}

	public void setDataContainer(T dataContainer) {
		this.dataContainer = dataContainer;
	}

	public K getIdentifier() {
		return identifier;
	}

	public void setIdentifier(K identifier) {
		this.identifier = identifier;
	}
	
	

}
