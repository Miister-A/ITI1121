//Student name: Alae Boufarrachene
//Student number: 300188539

import java.util.Scanner;

public class A1Q5 {

	private static int largestInteger(int[] intArray) { //Private helper method used to retrieve the largest integer in the row sizes array in the main
		int temp, size;
      	size = intArray.length;
      	for (int i = 0; i<size; i++ ) {
         	for (int j = i+1; j<size; j++) {
            	if (intArray[i]>intArray[j]) {
               		temp = intArray[i];
               		intArray[i] = intArray[j];
               		intArray[j] = temp;
				}
			}
		}
		return intArray[size-1];
	}

	private static String intArrayToString(int[] intArray) { //Private helper method used to convert each row into a string to be used in the display
		String outputString="";
		for (int i=0 ; i<intArray.length ; i++) {
			outputString = outputString+Integer.toString(intArray[i])+" ";
		}
		return outputString;
	}

	public static void display(int[][] arrayOfArrays) { //The display method used to print the matrix
		System.out.println("\nThe matrix (array of arrays) is the following :");
		for (int i=0 ; i<arrayOfArrays.length ; i++) {
			System.out.println("Row "+i+" : "+intArrayToString(arrayOfArrays[i]));
		}
	}

	public static void main(String[] args) {

		Scanner inputString = new Scanner(System.in); //Scanner object used to retrieve the integers as strings
        System.out.print("-Please enter the array of arrays one row per line. Enter an empty line when you're done :");
		String row = inputString.nextLine();

		int rowCounter = 0; //Variable used to keep track of the number of rows the final matrix will have
		int[] sizes = new int[999]; //Variable used to keep track of the size of each row which will be used to initialize the final matrix
		int[][] tempMatrix = new int[999][999]; //Temporary matrix with an arbitrary size used to store each array of integers
		while (row!="") {
			String[] inputStringArray = row.split(","); //Creates an array of strings that contains all integers
			int[] inputIntegerArray = new int[inputStringArray.length]; //Initializes an array of integers of equal size as the strings one
			for (int i=0; i<inputStringArray.length; i++) { //Loop used to convert each element of string array into an integer into an other array
				inputIntegerArray[i] = Integer.parseInt(inputStringArray[i]);
			}
			tempMatrix[rowCounter] = inputIntegerArray;
			row = inputString.nextLine();
			sizes[rowCounter] = inputIntegerArray.length;
			rowCounter++;
		}

		int[][] matrix = new int[rowCounter][largestInteger(sizes)];
		for (int i3=0 ; i3<matrix.length ; i3++) { //Loop used to populate the final matrix from the temporary matrix
			matrix[i3] = tempMatrix[i3];
		}

		display(matrix);
	}		
}