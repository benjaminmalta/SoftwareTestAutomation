package ws5.stor;
import ws5.Player;

public interface Storage {
	/**
	 * 
	 * @param player
	 * @return returns 0 when player is successfully saved, -1 on failure
	 */

	public int save(Player player);
}
