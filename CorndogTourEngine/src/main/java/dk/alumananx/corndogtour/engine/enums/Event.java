package dk.alumananx.corndogtour.engine.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Event {
	NOTHING(50.0), CRASH(1), ATTACK(5.0);

	private static final List<Event> VALUES = Collections
			.unmodifiableList(Arrays.asList(values()));
	private double probability;

	private Event(double probability) {
		this.probability = probability;
	}

	public double getProbability() {
		return this.probability;
	}

	private static int summWeigts() {
		int summ = 0;
		for (Event value : VALUES) {

			summ += value.getProbability();
		}
		return summ;
	}

	private static final int SIZE = summWeigts();
	private static final Random RANDOM = new Random();

	public static Event randomType() {
		int randomNum = RANDOM.nextInt(SIZE);
		int currentWeightSumm = 0;
		for (Event currentValue : VALUES) {
			if (randomNum > currentWeightSumm
					&& randomNum <= (currentWeightSumm + currentValue
							.getProbability())) {
				return currentValue;
			}
			currentWeightSumm += currentValue.getProbability();
		}
		return Event.NOTHING;
	}
}
