package ws2;

public class Demo {

	public static void main(String[] args) {
		
		Player player1 = new Player(1, "Surname Player 1", "GKP");
		System.out.println(player1);
		
		Player player2 = new Player(2, "Surname Player 2", "DEF");
		System.out.println(player2);
		
		Team team = new Team();
		team.addPlayer(player1);
		team.addPlayer(player2);
		
		System.out.println(team);

	}

}
