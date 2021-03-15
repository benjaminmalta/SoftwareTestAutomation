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
}
