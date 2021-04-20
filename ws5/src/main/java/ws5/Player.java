package ws5;


public class Player {

	public enum ROLE {GKP, DEF, MDF, FWD};
	
	private int number;
	private String surname;
	private ROLE role;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Player))
			return false;
		Player other = (Player) obj;
		if (number != other.number)
			return false;
		if (role != other.role)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

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
