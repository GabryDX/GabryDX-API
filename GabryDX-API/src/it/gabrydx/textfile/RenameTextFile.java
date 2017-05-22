package it.gabrydx.textfile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RenameTextFile {

	public static boolean rename(String oldName, String newName) {

		// File (or directory) with old name
		File file = new File(oldName);

		// File (or directory) with new name
		File file2 = new File(newName);

		if (file2.exists())
			try {
				throw new java.io.IOException("file " + newName + " exists");
			} catch (IOException e) {
				e.printStackTrace();
			}

		// Rename file (or directory)
		boolean success = file.renameTo(file2);

		if (!success) {
			// File was not successfully renamed

		}
		return success;
	}
	
	public static boolean renameDateTime(String fileName) {
		if (fileName.contains(".txt"))
			fileName = fileName.replace(".txt", "");
		return rename(fileName, fileName+getCurrentDateTime()+".txt");
	}

	public static String getCurrentDateTime() {
		String date1;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//get current date time with Date()
		Date date = new Date();
		date1 = dateFormat.format(date);

//		String date2;
//		//get current date time with Calendar()
//		Calendar cal = Calendar.getInstance();
//		date2 = dateFormat.format(cal.getTime());

		return date1;
	}
}
