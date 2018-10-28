package general;


import tda.InterfaceTreeWithRotation;
import treeBinarySearch.BinaryTree;
import treeBinarySearch.NodeBinaryTree;

public class TreeWithRotation<T, K extends Comparable<K>> extends BinaryTree<T,K> implements InterfaceTreeWithRotation<T,K>{

	@Override
	public void leftRotation(NodeBinaryTree<T, K> node) {
		
		NodeBinaryTree<T,K> nodeBefore = searchElementBefore(node.getKey());
		NodeBinaryTree<T,K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey());
		if(nodeBeforeBefore == null) {
			nodeBefore.setRightSon(node.getLeftSon());
			node.setLeftSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == -1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setRightSon(node.getLeftSon());
					node.setLeftSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}	
			}
		}
		
	}

	@Override
	public void rightRotation(NodeBinaryTree<T, K> node) {
		
		NodeBinaryTree<T, K> nodeBefore = searchElementBefore(node.getKey());
		NodeBinaryTree<T, K> nodeBeforeBefore = searchElementBefore(nodeBefore.getKey());
		if(nodeBeforeBefore == null) {
			nodeBefore.setLeftSon(node.getRightSon());
			node.setRightSon(nodeBefore);
			root = node;
		}
		else {
			if(nodeBefore.under(node.getKey()) == 1) {
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == -1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setRightSon(node);
				}
				if(nodeBeforeBefore.under(nodeBefore.getKey()) == 1) {
					nodeBefore.setLeftSon(node.getRightSon());
					node.setRightSon(nodeBefore);
					nodeBeforeBefore.setLeftSon(node);
				}			
			}
		}
		
	}


	
	

	
	
	
	
}
