package it.gabrydx;

/**La classe fornisce uno strumento per misurare il tempo di esecuzione
	 di un programma*/

public class Cronometro {
	private long tempoIniziale;
	private long tempoFinale;
	
	public void start() {
		tempoIniziale = System.currentTimeMillis();
	}
	
	public void stop() {
		tempoFinale = System.currentTimeMillis();
	}

	public long tempoTrascorso() {
		return tempoFinale - tempoIniziale;
	}
	
	public long tempoTrascorsoSecondi() {
		return tempoTrascorso()/1000;
	}
	
	public long inizio() {
		return tempoIniziale;
	}
	
	public long fine() {
		return tempoFinale;
	}
	
	public boolean hasStarted() {
		return tempoTrascorso()!=tempoFinale;
	}
}//fine classe
