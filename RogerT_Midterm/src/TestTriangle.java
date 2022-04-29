
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestTriangle {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Triangle> triangleList = new ArrayList<Triangle>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boolean again = true;
		displayOptions();
		String answer = input.nextLine();

		while (!answer.equals("1") && !answer.equals("2") && !answer.equals("3") && !answer.equals("e")) {
			System.out.print("Please insert a valid option. >> ");
			answer = input.nextLine();
		}

		while (again) {
			if (answer.equals("1")) {
				readFile();
				displayOptions();
				answer = input.nextLine();

			} else if (answer.equals("2")) {
				displayHistogram();
				displayOptions();
				answer = input.nextLine();

			} else if (answer.equals("3")) {
				outputTriangles();
				displayOptions();
				answer = input.nextLine();

			} else if (answer.equals("e")) {
				System.out.print("GoodBye!");
				again = false;

			} else {
				System.out.print("Please insert a valid option. >> ");
				answer = input.nextLine();
			}
		}

	}

	public static void displayOptions() {
		System.out.println("1) Load the database " + "\n" + "2) Display the histogram" + "\n"
				+ "3) Write the top 3 triangles" + "\n" + "e) Exit");
		System.out.println("Please select >>>");
	}

	public static void readFile() {

		System.out.print("Please enter the filename >> ");
		String answer2 = input.nextLine();

		// Clean
		Triangle triangleObject = new Triangle();
		triangleList.clear();
		
		String fileName = "./" + answer2;

		try {

			FileReader input = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(input);
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] array;
				array = line.split(",");

				double base, height;
				base = Double.parseDouble(array[0]);
				height = Double.parseDouble(array[1]);

				triangleObject = new Triangle(base, height);
				triangleList.add(triangleObject);
			}

			reader.close();
		} catch (Exception e) {
			System.out.print(e);
		}
		System.out.println(triangleList.size() + " triangles succesfully loaded.");

	}

	public static void displayHistogram() {

		String counter1 = "", counter2 = "", counter3 = "", counter4 = "", counter5 = "", counter6 = "";
		String counter7 = "", counter8 = "", counter9 = "", counter10 = "";
		for (int i = 0; i < triangleList.size(); i++) {
			if (triangleList.get(i).getArea() >= 0 && triangleList.get(i).getArea() < 10) {
				counter1 += "*";
			} else if (triangleList.get(i).getArea() >= 10 && triangleList.get(i).getArea() < 20) {
				counter2 += "*";
			} else if (triangleList.get(i).getArea() >= 20 && triangleList.get(i).getArea() < 30) {
				counter3 += "*";
			} else if (triangleList.get(i).getArea() >= 30 && triangleList.get(i).getArea() < 40) {
				counter4 += "*";
			} else if (triangleList.get(i).getArea() >= 40 && triangleList.get(i).getArea() < 50) {
				counter5 += "*";
			} else if (triangleList.get(i).getArea() >= 50 && triangleList.get(i).getArea() < 60) {
				counter6 += "*";
			} else if (triangleList.get(i).getArea() >= 60 && triangleList.get(i).getArea() < 70) {
				counter7 += "*";
			} else if (triangleList.get(i).getArea() >= 70 && triangleList.get(i).getArea() < 80) {
				counter8 += "*";
			} else if (triangleList.get(i).getArea() >= 80 && triangleList.get(i).getArea() < 90) {
				counter9 += "*";
			} else {
				counter10 += "*";
			}
		}

		System.out.println("Here is the histogram " + "\n" + "[000,010] " + counter1 + "\n" + "[010,020] " + counter2
				+ "\n" + "[020,030] " + counter3 + "\n" + "[030,040] " + counter4 + "\n" + "[040,050] " + counter5
				+ "\n" + "[050,060] " + counter6 + "\n" + "[060,070] " + counter7 + "\n" + "[070,080] " + counter8
				+ "\n" + "[080,090] " + counter9 + "\n" + "[090,100] " + counter10);

	}

	public static void outputTriangles() {

		Triangle[] triangleArray = new Triangle[triangleList.size()];
		for (int i = 0; i < triangleList.size(); i++) {
			triangleArray[i] = triangleList.get(i);
		}

		Triangle temp;
		for (int i = 0; i < triangleArray.length - 1; i++) {
			for (int j = 0; j < triangleArray.length - 1; j++) {
				if (triangleArray[j].getArea() > triangleArray[j + 1].getArea()) {
					temp = triangleArray[j];
					triangleArray[j] = triangleArray[j + 1];
					triangleArray[j + 1] = temp;
				}
			}
		}

		System.out.println("Please enter the output filename>> ");
		String answer3 = input.nextLine();
		try {
			File output = new File("./" + answer3);
			PrintWriter writer = new PrintWriter(output);

			for (int i = triangleArray.length - 1; i > triangleArray.length - 4; i--) {
				writer.println(triangleArray[i].getBase() + "," + triangleArray[i].getHeight());
			}

			writer.close();
		} catch (Exception e) {
			System.out.print(e);
		}

	}

}
