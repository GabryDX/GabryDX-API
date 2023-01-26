package it.gabrydx;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Ritorna i numeri in una stringa
	 * @param str
	 * @return
	 */
	public static String getNumebers(String str) {
		str = str.replaceAll("[^\\.0123456789]","");
		return str;
	}
	
	
	/**
	 * Separa una stringa str ogni partitionSize caratteri e restituisce una lista di stringhe
	 * @param str
	 * @param partitionSize
	 * @return Ritorna una lista di stringhe
	 */
	public static List<String> splitEachNth(String str, int partitionSize) {
		List<String> parts = new ArrayList<String>();
        int len = str.length();
        for (int i=0; i<len; i+=partitionSize)
        {
            parts.add(str.substring(i, Math.min(len, i + partitionSize)));
        }
        return parts;
	}


}
