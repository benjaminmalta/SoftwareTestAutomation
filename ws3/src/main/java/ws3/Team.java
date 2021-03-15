package ws3;

import java.util.ArrayList;
import java.util.List;

import ws3.Player.ROLE;

public class Team {
	
	public static final int MAX_PLAYERS = 21;
	
	private List<Player> players;

	public Team() {
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player p) {
		//when you throw an exception you exit the method so the rest of the code wont be executed in the method
		if(isTeamFull())
			throw new TeamFullUpException("team is full... cannot add new player");
		
		if (p.getRole() != null && findPlayer(p.getNumber()) == null) {
			players.add(p);
		}
	}
	
	public boolean isTeamFull() {
		return this.players.size() == MAX_PLAYERS;
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
		if(toRemove != null) {
			players.remove(toRemove);
		}
	}
	
	public int countPlayers() {
		return players.size();
	}
	
	public boolean canPlayGame() {
		int goalKeepers = 0;
		int otherPlayers = 0;
		
		for(Player player : players) {
			if(player.getRole() == ROLE.GKP)
				goalKeepers++;
			else
				otherPlayers++;
		}
		
		return goalKeepers >= 1 && otherPlayers >= 10;
		
	}

	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}
}
