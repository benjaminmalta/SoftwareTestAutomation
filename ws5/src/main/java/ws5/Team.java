package ws5;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ws5.Player.ROLE;
import ws5.stor.Storage;

public class Team {

	public static final int MAX_PLAYERS = 21;

	private List<Player> players;

	public Team() {
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player p) {
		// when you throw an exception you exit the method so the rest of the code wont
		// be executed in the method
		if (isTeamFull())
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
		if (toRemove != null) {
			players.remove(toRemove);
		}
	}

	public int countPlayers() {
		return players.size();
	}

	public boolean canPlayGame() {
		int goalKeepers = 0;
		int otherPlayers = 0;

		for (Player player : players) {
			if (player.getRole() == ROLE.GKP)
				goalKeepers++;
			else
				otherPlayers++;
		}

		return goalKeepers >= 1 && otherPlayers >= 10;

	}

	public List<Player> pickRandomLineUp() {
		if (!canPlayGame())
			throw new IncompleteTeamException("Not enough players to start the game");
		
		List<Player> lineUp = new ArrayList<>();
		Random r = new Random();
		boolean keeperIn = false;

		while (lineUp.size() < 11) {
			
			// choose a random player
			Player p = players.get(r.nextInt(countPlayers()));
			
			if (lineUp.contains(p))
				continue;
			
			if (p.getRole() == ROLE.GKP) {
				if (!keeperIn) {
					keeperIn = lineUp.add(p);
					// add method returns true, which is why we made it = to keeperIn
				}
			} else {
				// leave room for a keeper to be chosen if one is not already in the line up
				if (keeperIn || lineUp.size() < 10)
					lineUp.add(p);
				}
			
		}
		return lineUp;

	}

	public boolean containsPlayer(Player p) {
		return players.contains(p);
	}
	
	public boolean save(Storage store) {
		for (Player p : players) {
			int saveResult = store.save(p);
			if(saveResult != 0)
				return false;
		}
		return true;
	}
	

	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}
}
