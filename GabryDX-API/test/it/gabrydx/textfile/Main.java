package it.gabrydx.textfile;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main (String[] args) {
		System.out.println("Check if 'testo' file is empty or doesn't exist");
		System.out.println(ReadTextFile.isEmpty("testo"));
		System.out.println("Create 'testo'");
		WriteTextFile.create("testo");
		System.out.println("Rename 'testo' to 'testo.txt'");
		RenameTextFile.rename("testo", "testo.txt");
		System.out.println("Write 'text' in 'testo.txt'");
		WriteTextFile.writeln("testo.txt", "text");
		System.out.println("First read (should be 'text'):");
		ReadTextFile.readPrint("testo.txt");
		System.out.println("Create file 'testo.txt'");
		WriteTextFile.create("testo.txt");
		System.out.println("Second read (should be empty):");
		ReadTextFile.readPrint("testo.txt");
		System.out.println("Delete file 'testo.txt'");
		DeleteTextFile.delete("testo.txt");
		System.out.println("Check if 'testo' file doesn't exist and if not it creates it");
		System.out.println(WriteTextFile.isEmptyAndCreate("testo.txt"));
		System.out.println("Write 'text1\ntext2\ntext3\n\n' in 'testo.txt'");
		WriteTextFile.writeln("testo.txt", "text1\ntext2\ntext3\n\n");
		System.out.println("Reads last 3 lines of 'testo.txt'");
		System.out.println("-->START<--\n"+ReadTextFile.readLastNLines(new File("testo.txt"), 3)+"-->END<--");
		System.out.println("Reads last 3 lines of 'testo.txt' trimmed");
		System.out.println("-->START<--\n"+ReadTextFile.readLastNLines(new File("testo.txt"), 3).trim()+"\n-->END<--");
		
		System.out.println("Checking last non empty line");
		try {
			System.out.println(ReadTextFile.readLastNonEmptyLine("testo.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Delete file 'testo.txt'");
		DeleteTextFile.delete("testo.txt");
		
		System.out.println("Write '\n\n\n\n\n' in 'testo.txt'");
		WriteTextFile.writeln("testo.txt", "\n\n\n\n\n");
		
		System.out.println("Checking last non empty line");
		try {
			System.out.println(ReadTextFile.readLastNonEmptyLine("testo.txt"));
			
			if (ReadTextFile.readLastNonEmptyLine("testo.txt").isEmpty())
				System.out.println("file vuoto");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Delete file 'testo.txt'");
		DeleteTextFile.delete("testo.txt");
	}
}
