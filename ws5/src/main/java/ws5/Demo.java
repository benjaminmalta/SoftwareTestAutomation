package ws5;


import java.util.List;

import ws5.Player.ROLE;

public class Demo {

	public static void main(String[] args) {
//		System.out.println(p1);
//		
//		Player p2 = new Player(2, "Surname Player 2", ROLE.FWD);
//		System.out.println(p2);
//		
//		
//		Team team = new Team();
//		team.addPlayer(p1);
//		team.addPlayer(p2);
//		
//		System.out.println(team);
//
		
//		Team team = new Team();
//		for (int i =1; i <= 22; i ++) {			
//			Player player = new Player(i, "Player Surname", ROLE.DEF);
//			team.addPlayer(player);
//			System.out.println(player);
//		}
		
//		System.out.println(team.canPlayGame());
//		team.addPlayer(new Player(1, "Player Surname", ROLE.GKP));
//		System.out.println(team.canPlayGame());
//		for(int i = 2;i <13;i++) {
//			team.addPlayer(new Player(i, "Player Surname", ROLE.FWD));
//		}
//		System.out.println(team.canPlayGame());
		
//		Team team = new Team();
//		Player p1 = new Player(10,"Player 1 Surname" , ROLE.DEF);
//		team.addPlayer(p1);
//		
//		Player p2 = new Player(10,"Player 1 Surname" , ROLE.DEF);
//		System.out.println(team.containsPlayer(p2));S
		
		Team team = new Team();	
		team.addPlayer(new Player(21, "Player Surname", ROLE.GKP));
		
		for (int i =1; i <= 12; i ++) {			
			team.addPlayer(new Player(i, "Player Surname", ROLE.FWD));
		}
		
		List<Player> randomLineUp = team.pickRandomLineUp();
		System.out.println(randomLineUp.size());
		System.out.println(randomLineUp);
	}

}
 