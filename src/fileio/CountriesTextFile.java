package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {

	public static void readFromFile(String file) {
		Path filePath = Paths.get(file);
		File f = filePath.toFile();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);

				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not foud");
		} catch (IOException e) {
			System.out.println("Something crazy happeneed-call some one who can help");
		}
	}

	public static void createOurFile(String fileName) {
		Path path = Paths.get(fileName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				// System.out.println("The file was created successfully");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("OOPs something went terribly wrong");
			}
		} else {
			// System.out.println("The file already exists");
		}
	}

	public static void writeToFile(ArrayList<Country> cou, String fileName) {

		Path path = Paths.get(fileName);
		File file = path.toFile();
		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(file, true));
			for (Country c : cou) {
				output.println(c);
			}
			System.out.println("This country has been saved");
			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("Yooo..I dontknow whats going on--contact some one!");
		}
	}

	

}


