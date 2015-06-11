package ba.bitcamp.gordan;

import java.util.Arrays;

public class Task3_StudentGrades {

	public static void main(String[] args) {
		
		
		
		String[] studentGrades = gradesOfOneStudent();
		System.out.println(Arrays.toString(studentGrades));
		
		String[] subjects = nameOfSubjects();
		
		String[] names = namesOfStudents();
		System.out.println(Arrays.toString(names));
		
		String[][] gradesFromSubjects = gradesFromSubjectsForOneStudent(studentGrades, subjects);
		print2DArray(gradesFromSubjects);
		
		double oneStudentAverage = averageOfOneStudent(studentGrades);
		System.out.println(oneStudentAverage);
		
		TextIO.writeFile("src/proba.txt");
		TextIO.putln(names[0]);
		TextIO.putln();
		for (int i = 0; i < gradesFromSubjects.length; i++) {
			for (int j = 0; j < gradesFromSubjects[i].length; j++) {
				TextIO.put(gradesFromSubjects[i][j]);
			}
			TextIO.putln();
		}
		
		TextIO.putln();
		TextIO.putf("Average: %.2f \n",oneStudentAverage);
	}
	/**
	 * NIZ OCJENA JEDNOG UCENIKA
	 * @return
	 */
	public static String[] gradesOfOneStudent(){
		TextIO.readFile("src/ba/bitcamp/gordan/grades.in");
		String gradesOneStudents = TextIO.getln();
		int counter = 0;
		
		for (int i = 0; i < gradesOneStudents.length(); i++) {
			if(gradesOneStudents.charAt(i)!= ' '){
				counter++;
			}
		}
		
		String[] array = new String[counter];
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = ""+gradesOneStudents.charAt(j);
			j+=2;
		}
		TextIO.readStandardInput();
		return array;
	}
	
	public static String[] nameOfSubjects(){
		TextIO.readFile("src/ba/bitcamp/gordan/courses.in");
		int counter = 0;
		//counting number of lines in the file
		while (!TextIO.eof()) {
			TextIO.getln();
			counter++;
		}
		TextIO.readStandardInput();
		TextIO.readFile("src/ba/bitcamp/gordan/courses.in");
		String[] array = new String[counter];
		for (int i = 0; i < array.length; i++) {
			array[i] = TextIO.getln();
		}
		TextIO.readStandardInput();
		return array;
	}
	
	public static String[][]	gradesFromSubjectsForOneStudent(String[] studentGrades, String[] subjects){
		String[][] array = new String[subjects.length][1];
		for (int i = 0; i < array.length; i++) {
				int j =0;
				array[i][j] = "("+studentGrades[i]+")"+" "+subjects[i];
			}
			
		
		return array;
	}
	
	public static String[] namesOfStudents(){
		TextIO.readFile("src/ba/bitcamp/gordan/names.in");
		int counter = 0;
		//counting number of lines in the file
		while (!TextIO.eof()) {
			TextIO.getln();
			counter++;
		}
		TextIO.readStandardInput();
		TextIO.readFile("src/ba/bitcamp/gordan/names.in");
		String[] array = new String[counter];
		for (int i = 0; i < array.length; i++) {
			array[i] = "Student: "+TextIO.getln();
		}
		TextIO.readStandardInput();
		return array;
	}
	
	
	public static double averageOfOneStudent(String[] studentGrades){
		double average = 0;
		int sum = 0;
		for (int i = 0; i < studentGrades.length; i++) {
			sum+=Integer.parseInt(studentGrades[i]);
			
		}
		average = (double)sum/(double)studentGrades.length;
		return average;
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void print2DArray(String[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");

				if (j == array[i].length-1) {
					System.out.print("\n");
				}
			}
		}
	}
}
