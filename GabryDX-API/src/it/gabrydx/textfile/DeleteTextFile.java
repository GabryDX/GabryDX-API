package it.gabrydx.textfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;

public class DeleteTextFile {

	public static void delete (String fileName) {
		File f = new File(fileName);
		try {
		    Files.delete(f.toPath());
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", f.toPath());
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", f.toPath());
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}
	}
}
