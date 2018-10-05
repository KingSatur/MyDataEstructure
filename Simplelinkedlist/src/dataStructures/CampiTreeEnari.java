package dataStructures;

import exceptions.IndexOutOfRangeException;
import tda.InterfaceCampiTreeEnari;

public class CampiTreeEnari<T> implements InterfaceCampiTreeEnari<T>{
	
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
	public NodeTree<T> search(T data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(T data, T dataPadre, NodeEnari<T> node) throws IndexOutOfRangeException{
		
		T dataCompare = node.getData();
		boolean si = dataCompare.equals(dataPadre);
		if(dataCompare.equals(dataPadre)) {
			node.addSon(new NodeEnari<T>(data));
		}
		else {
			for(int i = 0; i < root.getSons().getSize(); i ++) {
				NodeEnari<T> m = root.getSons().searchElement(i).getData();
				if(m.getData().equals(dataPadre)){
					m.addSon(new NodeEnari<T>(data));
				}
				else {
					add(data, dataPadre, m);
				}
			}
		}
		
		wrfwefwefewf
		
	}

	
	public static void main(String[] args) throws IndexOutOfRangeException {
		
		CampiTreeEnari<Player> arbolJugadores = new CampiTreeEnari<Player>(new Player("Juanda", 10));
		Player p1 = new Player("Player 1", 12);
		Player p2 = new Player("Player 2", 1333);
		Player p3 = new Player("Player 3", 144);
		arbolJugadores.add(p1, arbolJugadores.getRoot().getData(), arbolJugadores.getRoot());
		
		
		
	
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
