package comparadores;

import java.util.Comparator;

import dataStructures.Player;

public class PlayersCompare implements Comparator<Player> {

	@Override
	public int compare(Player o1, Player o2) {
		if(o1.getLevel() > o2.getLevel()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
}
