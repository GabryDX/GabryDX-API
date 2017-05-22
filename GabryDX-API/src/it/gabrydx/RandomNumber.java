package it.gabrydx;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {

	/**
	 * Random int inclusivo
	 * @param min
	 * @param max
	 * @return numero random tra min e max (incluso)
	 */
	public static int randInt(int min, int max) {

		// NOTE: This will (intentionally) not run as written so that folks
		// copy-pasting have to think about how to initialize their
		// Random instance.  Initialization of the Random instance is outside
		// the main scope of the question, but some decent options are to have
		// a field that is initialized once and then re-used as needed or to
		// use ThreadLocalRandom (if using at least Java 1.7).
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
	
	/**
	 * Random double esclusivo
	 * @param min
	 * @param max
	 * @return numero random tra min e max (escluso)
	 */
	public static double randDouble(double min, double max) {
		return ThreadLocalRandom.current().nextDouble(min, max);
	}
}
