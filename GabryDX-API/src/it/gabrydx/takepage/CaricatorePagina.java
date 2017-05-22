package it.gabrydx.takepage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CaricatorePagina {

	public static String Caricatore() {
		String contenuto = "";
		String percorso = System.getProperty("user.dir");
		String indirizzo = (percorso + "/src/takePage/pagina.txt");

		BufferedReader br = null;

		try {
			String sCurrentLine;
			br = new BufferedReader(new InputStreamReader(
				    new FileInputStream(indirizzo), "UTF-8"));
			while ((sCurrentLine = br.readLine()) != null) {
				contenuto = contenuto + (sCurrentLine) + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
			contenuto = "errore";
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	//	return contenuto.substring(0, contenuto.length() -1);
		return contenuto;
	}
}
