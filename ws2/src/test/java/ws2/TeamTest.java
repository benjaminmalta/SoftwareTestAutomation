package ws2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

	private Team team;
	
	@BeforeEach
	public void initialiseTeam() {
		this.team = new Team();
	}
	
	@Test
	public void addPlayerIncrementsPlayerCount() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		assertEquals(1, team.countPlayers(), "added one player");
	}
	
	@Test
	public void playerWithInvalidRoleNotAdded() {
		team.addPlayer(new Player(44, "Baggio", "FWDA"));
		assertEquals(0, team.countPlayers(), "player with invalid role is not added");
	}
	
	@Test
	public void removeInexistentPlayer() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.removePlayer(43);
		assertEquals(1, team.countPlayers(), "an inexistent player cannot be removed");
	}	
	@Test
	public void removeExistentPlayer() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.removePlayer(44);
		assertEquals(0, team.countPlayers(), "an existent player should be removed from the team");
	}
	
	@Test
	public void addTwoPlayersWithSameNumber() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		assertEquals(1, team.countPlayers(), "a player with a number that already exists cannot be added");
	}
	
	@Test
	public void addThreeValidPlayers() {
		team.addPlayer(new Player(43, "Baggio 1", "FWD"));
		team.addPlayer(new Player(44, "Baggio 2", "GKP"));
		team.addPlayer(new Player(45, "Baggio 3", "DEF"));
		assertEquals(3, team.countPlayers(), "adding 3 valid players returns a player count of 3");
	}	
	
	
	
}
