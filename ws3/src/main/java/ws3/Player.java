package ws3;

public class Player {

	public enum ROLE {GKP, DEF, MDF, FWD};
	
	private int number;
	private String surname;
	private ROLE role;

	public Player(int number, String surname, ROLE role) {
		super();
		this.number = number;
		this.surname = surname;
		this.role = role;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public ROLE getRole() {
		return role;
	}
	
	public void setRole(ROLE role) {
		this.role = role;
	}	



	@Override
	public String toString() {
		return "Player [number=" + number + ", surname=" + surname + ", role=" + role + "]";
	}

}
