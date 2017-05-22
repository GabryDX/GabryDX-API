package it.gabrydx.textfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class WriteTextFile {

	public static void write(String fileName, String text) {

		try {
			File f = new File(fileName);

			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(f, true), "UTF8"));
			
			out.append(text);
			
			out.flush();
			out.close();
			
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e){
			System.out.println(e.getMessage());
		} 

	}

	public static void overwrite(String fileName, String text) {
		try {
			// if false then not append
			FileWriter fileWriter = new FileWriter(fileName, false);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(text);
			bufferedWriter.close();
		} catch(IOException ex) {
			System.out.println("Error writing to file '" + fileName + "'");
			ex.printStackTrace();
		}
	}

	public static void writeln(String fileName, String text) {
		write(fileName, text+"\n");
	}

	public static void overwriteln(String fileName, String text) {
		overwrite(fileName, text+"\n");
	}

	public static void create(String fileName) {
		overwrite(fileName, "");
	}
	
	public static String escapeChars(String str) {
	    char[][] escapes = {
	            { '\n', 'n' },
	            { '\r', 'r' },
	            { '\f', 'f' },
	            { '\b', 'b' },
	            { '\t', 't' }
	    };
	    for (char[] escape : escapes) {
	        str = str.replaceAll(Character.toString(escape[0]), "\\\\" + escape[1]);
	    }
	    return str;
	}
	
	public static void updateLine(String toUpdate, String updated, String fileName) throws IOException {
	    BufferedReader file = new BufferedReader(new FileReader(fileName));
	    String line;
	    String input = "";

	    while ((line = file.readLine()) != null)
	        input += line + System.lineSeparator();

	    input = input.replace(toUpdate, updated);

	    FileOutputStream os = new FileOutputStream(fileName);
	    os.write(input.getBytes());

	    file.close();
	    os.close();
	}

	/**
	 * Checks if file is empty or not.
	 * If it does not exist it will be created.
	 * 
	 * @param fileName
	 * @return 	true if file is empty
	 * 			false if file is not empty
	 */
	public static boolean isEmptyAndCreate(String fileName) {
		boolean result = true;
		File f = new File(fileName);
		if (f.exists() && !f.isDirectory()) {
			if (!ReadTextFile.isEmpty(fileName))
				result = false;
		} else
			WriteTextFile.create(fileName);
		return result;
	}
}
