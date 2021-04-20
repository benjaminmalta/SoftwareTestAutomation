package ws5;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ws5.stor.StubSaveFailure;
import ws5.stor.StubSaveSuccess;

public class SaveTest {

	private Team team;

	@BeforeEach
	public void initialiseTeam() {
		team = new Team();
		Player p1 = new Player(1, "Messi", Player.ROLE.FWD);
		Player p2 = new Player(2, "Neymar", Player.ROLE.FWD);
		team.addPlayer(p1);
		team.addPlayer(p2);
	}

	@Test
	public void saveSuccessTest() {
		StubSaveSuccess stub = new StubSaveSuccess();
		assertTrue(team.save(stub));
	}

	@Test
	public void saveFailureTest() {
		StubSaveFailure stub = new StubSaveFailure();
		assertFalse(team.save(stub));
		
	}
}
