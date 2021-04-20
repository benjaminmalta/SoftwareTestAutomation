package ws5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ws5.IncompleteTeamException;
import ws5.Player;
import ws5.Player.ROLE;
import ws5.Team;
import ws5.TeamFullUpException;

public class TeamTest {

	private Team team;

	@BeforeEach
	public void initialiseTeam() {
		this.team = new Team();
	}

	@Test
	public void addPlayerIncrementsPlayerCount() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		assertEquals(1, team.countPlayers(), "added one player");
	}

	@Test
	public void playerWithInvalidRoleNotAdded() {
		team.addPlayer(new Player(44, "Baggio", null));
		assertEquals(0, team.countPlayers(), "player with invalid role is not added");
	}

	@Test
	public void removeInexistentPlayer() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.removePlayer(43);
		assertEquals(1, team.countPlayers(), "an inexistent player cannot be removed");
	}

	@Test
	public void removeExistentPlayer() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.removePlayer(44);
		assertEquals(0, team.countPlayers(), "an existent player should be removed from the team");
	}

	@Test
	public void addTwoPlayersWithSameNumber() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		assertEquals(1, team.countPlayers(), "a player with a number that already exists cannot be added");
	}

	@Test
	public void addThreeValidPlayers() {
		team.addPlayer(new Player(43, "Baggio 1", ROLE.FWD));
		team.addPlayer(new Player(44, "Baggio 2", ROLE.GKP));
		team.addPlayer(new Player(45, "Baggio 3", ROLE.DEF));
		assertEquals(3, team.countPlayers(), "adding 3 valid players returns a player count of 3");
	}

	@Test
	public void cannotAddPlayerWhenTeamIsFull() {

		for (int i = 1; i <= 21; i++) {
			Player player = new Player(i, "Player Surname", ROLE.DEF);
			team.addPlayer(player);
		}
		assertTrue(team.isTeamFull(), "Added 21 players so team should be full");

		assertThrows(TeamFullUpException.class, () -> {
			team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		}, "Adding 22nd players should throw exception");
	}

	@Test
	public void canPlayOneKeeperNinePlayers() {
		team.addPlayer(new Player(1, "Keeper surname", ROLE.GKP));

		for (int i = 2; i <= 10; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertFalse(team.canPlayGame(), "cannot play a game with one keeper and nine players");
	}

	@Test
	public void canPlayTwoKeepersNinePlayers() {
		team.addPlayer(new Player(1, "Keeper surname", ROLE.GKP));
		team.addPlayer(new Player(21, "Keeper surname", ROLE.GKP));

		for (int i = 2; i <= 10; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertFalse(team.canPlayGame(), "cannot play a game with two keepers and nine players");
	}

	@Test
	public void canPlayNoKeepersElevenPlayers() {

		for (int i = 1; i <= 11; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertFalse(team.canPlayGame(), "cannot play a game with two keepers and nine players");
	}

	@Test
	public void canPlayNoPlayers() {
		assertFalse(team.canPlayGame(), "Cannon play a game with no players");
	}

	@Test
	public void canPlayOneKeeperTenPlayers() {
		team.addPlayer(new Player(21, "Keeper surname", ROLE.GKP));

		for (int i = 1; i <= 10; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertTrue(team.canPlayGame(), "Can play game with one keeper and 10 players");
	}

	@Test
	public void canPlayOneKeeperTwentyPlayers() {
		team.addPlayer(new Player(21, "Keeper surname", ROLE.GKP));

		for (int i = 1; i <= 20; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertTrue(team.canPlayGame(), "Can play game with one keeper and twenty players");

	}

	@Test
	public void cannotGenerateLineUpWhenNotEnoughPlayers() {
		team.addPlayer(new Player(21, "Keeper surname", ROLE.GKP));

		for (int i = 1; i <= 5; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		assertThrows(IncompleteTeamException.class, () -> {
			team.pickRandomLineUp();
		}, "Cannot play game with one keeper and 5 players");
	}
	
	@Test
	public void generateRandomLineUpWhenTeamCanPlay() {
		team.addPlayer(new Player(21, "Keeper surname", ROLE.GKP));
		team.addPlayer(new Player(22, "Keeper surname", ROLE.GKP));
		
		for (int i = 1; i <= 15; i++) {
			team.addPlayer(new Player(i, "player" + i + " surname", ROLE.MDF));
		}
		List<Player> randomLineUp = team.pickRandomLineUp();
		assertEquals(11,randomLineUp.size(), "A Random line up should have 11 players");
		
		int gkpCount = 0;
		for (Player player : randomLineUp) {
			if(player.getRole() == ROLE.GKP)
				gkpCount++;
		}
		assertEquals(1, gkpCount, "A random line up should have only one keeper");
		
	}

}
