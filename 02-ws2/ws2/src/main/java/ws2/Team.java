package ws2;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private List<Player> players;
	
	public Team() {
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player p) {
		
		if (p.getRole() != null && findPlayer(p.getNumber()) == null) {
			players.add(p);
		}
		
	}

	private Player findPlayer(int num) {
		for (Player player : players) {
			if (player.getNumber() == num) 
				return player;
		}
		return null;
	}

	public void removePlayer(int num) {
		Player toRemove = findPlayer(num);
		if (toRemove != null)
			players.remove(toRemove);		
	}
	
	public int countPlayers() {
		return players.size();
	}

	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}		
	
	
}
