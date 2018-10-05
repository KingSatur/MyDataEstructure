package dataStructures;
import exceptions.IndexOutOfRangeException;
import tda.InterfaceCampiTreeEnari;

public class CampiTreeEnari<T extends Comparable<T>> implements InterfaceCampiTreeEnari<T>{
	
	private NodeEnari<T> root;
	private int levels;
	
	public CampiTreeEnari(T data) {
		root = new NodeEnari<T>(data);
		levels = 0;
	}	
	
	public NodeEnari<T> getRoot() {
		return root;
	}

	public void setRoot(NodeEnari<T> root) {
		this.root = root;
	}

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels = levels;
	}

	@Override
	public NodeEnari<T> search(T data, NodeEnari<T> node) {

		return null;
	}

	@Override
	public void delete(T data) {
		
	}

	@Override
	public void add(T data, T dataPadre, NodeEnari<T> node) throws IndexOutOfRangeException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws IndexOutOfRangeException {
		
		
			
	}
	








	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
