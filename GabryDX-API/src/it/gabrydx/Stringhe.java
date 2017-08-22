package it.gabrydx;

public class Stringhe {


	/**
	 * Verifica se due stringhe sono uguali e se non lo sono mostra
	 * le differenze
	 * 
	 * @param s1
	 * @param s2
	 * @return diff = contiene le due sottostringhe a partire dal 
	 * momento in cui si e' presentata la differenza
	 */
	public static String differenze (String s1, String s2) {
		String diff = "";

		int max = 0;
		if (s1.length() >= s2.length())
			max = s2.length();
		else max = s1.length();

		int i=0;
		while (i<max) {
			if(!s1.substring(0,i+1).equals(s2.substring(0,i+1))) {
				diff = s1.substring(i) +"\n\n\n\n\n"+ s2.substring(i);
				i = max;
			} else
				diff = s1.substring(max) +"\n\n\n\n\n"+ s2.substring(max);
			i++;
		}

		if (s1.substring(max).equals("") && s2.substring(max).equals(""))
			diff = "Le stringhe sono uguali.";

		return diff;
	}

	/**
	 * Controlla se una stringa è tutta maiuscola
	 * @param s
	 * @return
	 */
	public static boolean isAllUpperCase (String s) {
		for (int i=0; i<s.length(); i++)
			if (Character.isLowerCase(s.charAt(i)))
				return false;
		return true;
	}

}
