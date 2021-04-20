package ws4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class RouletteWheelTest {

	private RouletteWheel wheel;

	@BeforeEach
	public void initialiseWheel() {
		wheel = new RouletteWheel();
	}

	@Test
	@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
	public void testSpinTimeVersion1() {
		wheel.spin();
	}

	@Test
	public void testSpinTimeVersion2() {
		assertTimeout(Duration.ofMillis(10), () -> {
			wheel.spin();
		}, "Spin should take less than 10ms");
	}

	public void testSeenAll37NumbersVersion1() {
		Set<Integer> seen = new HashSet<>();

		for (int i = 0; i < 100; i++) {
			int num = wheel.spin().getNumber();
			seen.add(num);
		}
		assertEquals(37, seen.size(), "Seen 37 different numbers");
	}
	
	@Test
	@Timeout(value = 100, unit=TimeUnit.MILLISECONDS)
	public void testSeenAll37NumbersVersion2() {
		Set<Integer> seen = new HashSet<>();

		while (seen.size() < 37) {
			int num = wheel.spin().getNumber();
			seen.add(num);
		}
	}
}
