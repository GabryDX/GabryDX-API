package it.gabrydx.takepage;

import java.io.IOException;
import java.io.PrintWriter;

public class ModificatorePagina {

	public static void Modificatore(String text) throws IOException {
		String percorso = System.getProperty("user.dir");
		String indirizzo = (percorso + "/src/takePage/pagina.txt");
//		String indhtml = (percorso + "/src/takePage/pagina.html");

		//		PrintWriter writer = new PrintWriter(indirizzo, "UTF-8");
		//		writer.print(text);
		//		writer.close();

		//		File file = new File(indirizzo);
		//		FileWriter fileWriter = new FileWriter(file,true);
		//		fileWriter.write(text+"\r\n");

		//		FileWriter w;
		//	    w=new FileWriter(indirizzo);
		//	    BufferedWriter b;
		//	    b=new BufferedWriter (w);
		//	    b.write(text);

		String lines[] = text.split("\\r?\\n");

		PrintWriter writer = new PrintWriter(indirizzo, "UTF-8");
	//	PrintWriter writer = new PrintWriter(indirizzo, "ISO-8859-1");
		writer.print("");
		for (int i=0; i<lines.length; i++) {
			writer.append(lines[i]+"\r\n");
		}
		writer.close();
	}
}
