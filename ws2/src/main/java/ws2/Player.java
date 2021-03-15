package ws2;

public class Player {

	private int number;
	private String surname;
	private String role;

	public Player(int number, String surname, String role) {
		super();
		this.number = number;
		this.surname = surname;
		this.role = validateRole(role);
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

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = validateRole(role);
	}
	
	private String validateRole(String role) {
		switch(role) {
		case "GKP":
		case "DEF":
		case "MDF":
		case "FWD":
			return role;
		}
		return null;
	}


	@Override
	public String toString() {
		return "Player [number=" + number + ", surname=" + surname + ", role=" + role + "]";
	}

}
