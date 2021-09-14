//Student name: Alae Boufarrachene
//Student number: 300188539

import java.util.Scanner;

public class A1Q2{

	public static int myCalc(int[] intArray, int n) {
		int R = 0;
		int numberOfPositives = 0; //Counter that stores the number of positive integers in the entered array
		int numberOfNegatives = 0; //Counter that stores the number of negative integers in the entered array
		for (int i=0 ; i<intArray.length ; i++) { //Loop that goes through each element of the array of integers
			if (intArray[i]>0) { //If positive, the respective counter get incremented
				numberOfPositives++;
			}
			if (intArray[i]<0) { //If negative, the respective counter get incremented
				numberOfNegatives++;
			}
		}
		R = numberOfPositives-numberOfNegatives; //Number of positive elements (>0) minus the number of negative elements (<0) 
		return R;
	}

	public static void main(String args[]) {

		Scanner inputString = new Scanner(System.in); //Scanner object used to retrieve the sentences (strings)
		System.out.print("-Please enter an array of values separated by commas :  ");
		String strings = inputString.nextLine();

		String[] inputStringArray = strings.split(","); //Stores the entered strings into array after splitting them with the commas
		int[] inputIntArray = new int[inputStringArray.length]; //Creates an array of integers equal to the size of the string array
		for (int i=0 ; i<inputStringArray.length ; i++) { //Loop that converts all the Strings into integers
			inputIntArray[i] = Integer.parseInt(inputStringArray[i]);
		}

		System.out.println("The number of positive elements minus the number of negative elements is : "+myCalc(inputIntArray,inputIntArray.length));
		inputString.close();
	}
}