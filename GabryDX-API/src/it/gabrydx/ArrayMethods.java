package it.gabrydx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayMethods {

	public static String[] splitStringEvery(String s, int interval) {
		int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
		String[] result = new String[arrayLength];

		int j = 0;
		int lastIndex = result.length - 1;
		for (int i = 0; i < lastIndex; i++) {
			result[i] = s.substring(j, j + interval);
			j += interval;
		} //Add the last bit
		result[lastIndex] = s.substring(j);

		return result;
	}

	/**
	 * Permette di unire più array in uno singolo
	 * @param arrays
	 * @return
	 */
	public static <T> T[] joinArrayGeneric(T[]... arrays) {
		int length = 0;
		for (T[] array : arrays) {
			length += array.length;
		}

		//T[] result = new T[length];
		final T[] result = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);

		int offset = 0;
		for (T[] array : arrays) {
			System.arraycopy(array, 0, result, offset, array.length);
			offset += array.length;
		}

		return result;
	}

	/**
	 * Prende una lista ordinata come un database matriciale e lo trasforma in un 
	 * database matriciale tenendo conto di valori uguali
	 * @param list
	 * @return String[][]
	 */
	public static String[][] joinDoublesFromList(List<String> list) {
		List<String[]> listArray = new ArrayList<String[]>();
		for (int i=0; i<list.size()-1; i+=2) {
			String element1 = list.get(i);
			String element2 = list.get(i+1);
			String[] a = {element2};
			String[] b = {element1};
			boolean contain = false;
			for(String[] array : listArray) //controlla se c'è più di una risposta ad una frase
				if(array[0].equals(element2))
					contain = true; // se si contain = true
			if(contain) {
				String[] c = {};
				String[] remove1 = {};
				String[] remove2 = {};
				for (int j=0; j<listArray.size()-1; j+=2)
					if (listArray.get(j)[0].equals(element2)) {
						remove1 = listArray.get(j);
						remove2 = listArray.get(j+1);
						c = ArrayUtils.addAll(remove2,b); // unisce le risposte trovate
						break;
					}
				listArray.remove(remove1); // rimuove la frase con risposta parziale
				listArray.remove(remove2); // rimuove la risposta parziale
				listArray.add(a);
				listArray.add(c); // aggiunge la frase con completa parziale
			} else {
				listArray.add(a);
				listArray.add(b);
			}
		}
		String[][] newDatabase = new String[listArray.size()][];
		for (int i=0; i<listArray.size(); i++) {
			newDatabase[i] = listArray.get(i);
		}
		return newDatabase;
	}

	/**
	 * Ordina un database con più occorrenze separate e le unisce
	 * @param matrix String[][]
	 * @return String[][]
	 */
	public static String[][] orderDatabase(String[][] matrix) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();

		for(int i=0; i<matrix.length-1; i+=2) {
			if (map.containsKey(matrix[i][0]))
				map.get(matrix[i][0]).add(matrix[i+1][0]);
			else {
				List<String> l = new ArrayList<String>();
				l.add(matrix[i+1][0]);
				map.put(matrix[i][0], l);
			}
		}
		String[][] newMatrix = new String[map.size()*2][];
		int count = 0;
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			String[] quest = {entry.getKey()};
			newMatrix[count] = quest;
			String[] ans = new String[entry.getValue().size()];
			for(int i=0; i<entry.getValue().size(); i++) {
				ans[i] = entry.getValue().get(i);
			}
			newMatrix[count+1] = ans;
			count+=2;
		}

		return newMatrix;
	}


//	public static void main (String[] args) {
//		String[][] a = {{"ciao"},{"hola"},{"ciao"},{"we"},{"sera"},{"buonasera"}};
//		String[][] b = orderDatabase(a);
//
//		for (String[] aa : b)
//			for (int i=0; i<aa.length; i++){
//				System.out.print(aa + "\t");
//				System.out.println(i + "\t" + aa[i]);
//			}
//
//		System.out.println(splitStringEvery("Ecco bravo, parliamo di altro..", 4096)[0]);
//	}
}
