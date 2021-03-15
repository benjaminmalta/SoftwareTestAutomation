package ws2;

public class Demo {

	public static void main(String[] args) {
		Player p1 = new Player(10,"Player 1 Surname" ,"GKP");
		System.out.println(p1);
		
		Player p2 = new Player(2, "Surname Player 2", "DEF");
		System.out.println(p2);
		
		
		Team team = new Team();
		team.addPlayer(p1);
		team.addPlayer(p2);
		
		System.out.println(team);

	}

}
