//Student name: Alae Boufarrachene
//Student number: 300188539

import java.util.Scanner;

public class A1Q1 {

	private static String retrieveLongestElementLength(String[] array) { //Private helper method #1
		int position = 0; 
		int index = 1;
		int elementLength = array[0].length();
		while (index<array.length) { 
			if (array[index].length() > elementLength) { //If bigger, then the element's value is re-assigned and the index is updated
				position = index; elementLength = array[index].length();
			}
			index++;
		}
		return array[position];
	}
	
	public static int[] talk(String[] array, int n) {
		int[] result = new int[2];

		result[0] = retrieveLongestElementLength(array).length();
		int counter = 0; //Counter used to count the number of occurences of the longest string in the array
		for (int i=0 ; i<array.length ; i++) { //Loop that goes over every single element of the array of strings
			if (array[i].length()==retrieveLongestElementLength(array).length()) { //If the current element has the same content as the longest one, it increments
				counter++;
			}
		}
		result[1] = counter;

		return result;
	}

	public static void main(String[] args) {

		Scanner integerInput = new Scanner(System.in); //Scanner object used to retrieve the number of sentences
        System.out.print("-Please enter the number of sentences : ");
		int numStrings = integerInput.nextInt();

		Scanner inputString = new Scanner(System.in); //Scanner object used to retrieve the sentences (strings)
		System.out.print("-Please enter an array of sentence(s) separated by commas : ");
		String sentences = inputString.nextLine();

		String[] inputArray = sentences.split(","); //Stores the entered strings into array after splitting them with the commas
		System.out.println("-The length of the longest sentence is : "+talk(inputArray,numStrings)[0]);
		System.out.println("-Sentences of this length are repeated : "+talk(inputArray,numStrings)[1]+" time(s)");
		
		integerInput.close();
		inputString.close();
	}
}