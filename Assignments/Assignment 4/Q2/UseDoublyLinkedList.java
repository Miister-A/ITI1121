/*******************************/
/*Students numbers: 
/*Students full names: 
/*******************************/
public class UseDoublyLinkedList {
  
	private static void testCase1() {
	    DoublyLinkedList<String> myList = new DoublyLinkedList<String>(), someList = new DoublyLinkedList<String>();
		someList.addLast("Hi");
		someList.addLast("AddMe");
		System.out.println("-----Test case #1 : Empty myList-----");
		System.out.println("-Original myList content: "+myList);
		System.out.println("-Original someList content : "+someList);
		System.out.print("-addSpecific() output : ");
		myList.addSpecific("Empty",someList);
		System.out.println("-Modified myList content: "+myList);
		System.out.println("-Modified someList content : "+someList);
		System.out.println();
	}

	private static void testCase2() {
	    DoublyLinkedList<String> myList = new DoublyLinkedList<String>(), someList = new DoublyLinkedList<String>();
		myList.addLast("ITI1120");
		myList.addLast("ITI1121");
		myList.addLast("CSI2110");
		myList.addLast("ITI1100");
		myList.addLast("CEG2136");
		System.out.println("-----Test case #2 : Empty someList-----");
		System.out.println("-Original myList content: "+myList);
		System.out.println("-Original someList content : "+someList);
		System.out.print("-addSpecific() output : ");
		myList.addSpecific("CEG2136",someList);
		System.out.println("-Modified myList content: "+myList);
		System.out.println("-Modified someList content : "+someList);
		System.out.println();
	}

	private static void testCase3() {
	    DoublyLinkedList<String> myList = new DoublyLinkedList<String>(), someList = new DoublyLinkedList<String>();
		someList.addLast("Hi");
		someList.addLast("AddMe");
		myList.addLast("ITI1120");
		myList.addLast("ITI1121");
		myList.addLast("CSI2110");
		myList.addLast("ITI1100");
		myList.addLast("CEG2136");
		System.out.println("-----Test case #3 : beforeMe isn't in the list-----");
		System.out.println("-beforeMe element : MAT2384");
		System.out.println("-Original myList content: "+myList);
		System.out.println("-Original someList content : "+someList);
		System.out.print("-addSpecific() output : ");
		myList.addSpecific("MAT2384",someList);
		System.out.println("-Modified myList content: "+myList);
		System.out.println("-Modified someList content : "+someList);
		System.out.println();
	}

	private static void testCase4() {
	    DoublyLinkedList<String> myList = new DoublyLinkedList<String>(), someList = new DoublyLinkedList<String>();
		someList.addLast("Hi");
		someList.addLast("AddMe");
		myList.addLast("ITI1120");
		myList.addLast("ITI1121");
		myList.addLast("CSI2110");
		myList.addLast("ITI1100");
		myList.addLast("CEG2136");
		System.out.println("-----Test case #4 : One occurence of beforeMe in myList-----");
		System.out.println("-beforeMe element : ITI1121");
		System.out.println("-Original myList content: "+myList);
		System.out.println("-Original someList content : "+someList);
		myList.addSpecific("ITI1121",someList);
		System.out.println("-Modified myList content: "+myList);
		System.out.println("-Modified someList content : "+someList);
		System.out.println();
	}

	private static void testCase5() {
	    DoublyLinkedList<String> myList = new DoublyLinkedList<String>(), someList = new DoublyLinkedList<String>();
		someList.addLast("Hi");
		someList.addLast("AddMe");
		myList.addLast("ITI1120");
		myList.addLast("ITI1121");
		myList.addLast("CSI2110");
		myList.addLast("ITI1121");
		myList.addLast("CEG2136");
		myList.addLast("ITI1121");
		myList.addLast("ELG2138");
		myList.addLast("ELG2136");
		myList.addLast("ITI1121");
		myList.addLast("CEG3156");
		myList.addLast("CEG4136");
		System.out.println("-----Test case #5 : Multiple occurences of beforeMe in myList-----");
		System.out.println("-beforeMe element : ITI1121");
		System.out.println("-Original myList content: "+myList);
		System.out.println("-Original someList content : "+someList);
		myList.addSpecific("ITI1121",someList);
		System.out.println("-Modified myList content: "+myList);
		System.out.println("-Modified someList content : "+someList);
		System.out.println();
	}
  
	public static void main(String[] args) {
		System.out.println("-------------------------------------");
		System.out.println("* Student name: Alae Boufarrachene  *");
		System.out.println("* Student number: 300188539         *");
		System.out.println("-------------------------------------");
		System.out.println();

		testCase1();

		testCase2();

		testCase3();

		testCase4();

		testCase5();
	}
 
}
