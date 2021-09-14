/*******************************/
/*Student number: 300188539
/*Student full name: Alae Boufarrachene
/*******************************/

import java.util.Scanner;

public class A3Q1 {

	private static int zeroReturner() {
		return 0;
	}

	private static void postFixCaller(String str) {
		try {
			System.out.println(PostFixHandler.processExpression(str));
		} 
		catch (Exception e) {
			System.out.println(e);
			if (e.toString().equals("java.lang.ArithmeticException: Square roots of negative numbers don't exist !")) { //Returns 0 when sqrt(negative num)
				System.out.println(zeroReturner());
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to my PostFixHandler program ! :)");

		Scanner input1 = new Scanner(System.in);
        System.out.print("-Please enter your postfix expression (your operators have to be separated by spaces) : ");
		String stringInput = input1.nextLine();
		postFixCaller(stringInput);

		System.out.print("-Would you like to enter another expression to be evaluated (Y/N)?");
		String stringInput2 = input1.nextLine();

		while (stringInput2.toLowerCase().equals("y")) {
			Scanner input3 = new Scanner(System.in);
			System.out.print("-Please enter your postfix expression (your operators have to be separated by spaces) : ");
			String stringInput3 = input3.nextLine();
			postFixCaller(stringInput3);
			System.out.print("-Would you like to enter another expression to be evaluated (Y/N)?");
			stringInput2 = input1.next();
		}
		
		input1.close();
		System.out.println("Thank you for using my PostFixHandler program, goodbye !");
	}
}