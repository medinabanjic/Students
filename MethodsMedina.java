package ba.bitcamp.arrays;

public class MethodsMedina {
	
	
	/**
	 * This method makes files.
	 * @param names = string array with file names
	 */
	public static void studentFile(String[] names) {

		for (int i = 0; i < names.length; i++) {
			String name = names[i] + ".grd";
			TextIO.writeFile(name);
		}
	}

	/**
	 * This method reads names of students from file, discard commas, blank
	 * spaces, and then turns it to lower case letters.
	 * 
	 * @return
	 * 
	 *         Array of strings, file names.
	 */
	public static String[] makeFileName() {

		TextIO.readFile("src/ba/bitcamp/arrays/names.in");

		int counter = 0;

		while (!TextIO.eof()) {
			TextIO.getln();
			counter++;
		}

		TextIO.readStandardInput();

		TextIO.readFile("src/ba/bitcamp/arrays/names.in");

		String[] studentFile = new String[counter];

		for (int i = 0; i < counter; i++) {
			String line = TextIO.getln();
			int length = line.length();

			String rest = "";
			String name = "";
			if (line.charAt(length - 3) != ' ') {
				name = line.substring(0, length - 4);
				rest = line.substring(length - 3, length - 1);
			} else {
				name = line.substring(0, length - 3);
				rest = line.substring(length - 2, length - 1);
			}
			String filename = name + rest;

			studentFile[i] = filename.toLowerCase();
		}

		return studentFile;
	}
}
