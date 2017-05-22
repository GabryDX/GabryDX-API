package it.gabrydx.textfile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ReadTextFile {

	public static String read(String fileName) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.getProperty("line.separator"));
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}

	public static String read2(String fileName) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					sb.append(System.getProperty("line.separator"));
					line = br.readLine();
				}
				return sb.toString();
			} finally {
				br.close();
			}
		} catch(IOException ex) {
			return ex.getMessage();
		}
	}

	public static void readPrint(String fileName) {

		// This will reference one line at a time
		String line = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}   

			// Always close files.
			bufferedReader.close();         
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");                
		} catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");                  
			// Or we could just do this: 
			// ex.printStackTrace();
		}
	}

	public static int countLines(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}

	public static List<String> file2List(String fileName) {
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File(fileName), StandardCharsets.UTF_8);
			lines = newLineCharacter(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static List<String> file2List(String fileName, Charset charset) {
		List<String> lines = null;
		try {
			lines = FileUtils.readLines(new File(fileName), charset);
			lines = newLineCharacter(lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * Checks if file is empty or not.
	 * 
	 * @param fileName
	 * @return 	true if file is empty
	 * 			false if file is not empty
	 */
	public static boolean isEmpty(String fileName) {
		File file = new File(fileName);
		if(file.length()==0)
			return true;
		else
			return false;
	}

	public static List<String> newLineCharacter(List<String> list) {
		if (list != null && !list.isEmpty())
			for (int i=0; i<list.size(); i++)
				list.set(i, list.get(i).replaceAll("\\\\n", System.lineSeparator()));
		return list;
	}

	/**
	 * Reads the last n lines of a (test) file also counting \n and \r as lines
	 * @param file
	 * @param lines
	 * @return String - last n lines
	 */
	public static String readLastNLines(File file, int lines) {
		java.io.RandomAccessFile fileHandler = null;
		try {
			fileHandler = new java.io.RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();
			int line = 0;

			for(long filePointer = fileLength; filePointer != -1; filePointer--) {
				fileHandler.seek(filePointer);
				int readByte = fileHandler.readByte();

				if(readByte == 0xA) {
					if (filePointer < fileLength) {
						line = line + 1;
					}
				} else if(readByte == 0xD) {
					if (filePointer < fileLength-1) {
						line = line + 1;
					}
				}
				if (line >= lines) {
					break;
				}
				sb.append((char) readByte);
			}

			String lastLine = sb.reverse().toString();
			return lastLine;
		} catch(java.io.FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch(java.io.IOException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			if (fileHandler != null )
				try {
					fileHandler.close();
				} catch (IOException e) {
				}
		}
	}

	public static String readLastNonEmptyLine(String fileName) throws IOException {

		int i = 1;
		String s = "";
		boolean found = false;
		int max = countLines(fileName);
		while (!found && i<=max) {
			s = readLastNLines(new File(fileName), i).trim();

			if (s.equals("\n") || s.equals("\r") || s.isEmpty())
				i++;
			else
				found = true;
		}

		return s;
	}

}