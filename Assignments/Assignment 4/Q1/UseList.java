/*******************************/
/*Student number : 300188539  
/*Student full name : Alae Boufarrachene  
/*******************************/

public class UseList {

    private static LinkedList<Integer> getList() {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.addLast(8);
        l.addLast(2);
        l.addLast(1);
		l.addLast(6);
		l.addLast(9);
		l.addLast(3);
		l.addLast(7);
		l.addLast(4);
		l.addLast(5);
        return l;
    }
	
    private static void testCase1() {
        System.out.println("-----testCase1: list with multiple elements-----");
        LinkedList<Integer> l = getList();
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(5,7));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase2() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase2: list that doesn't contain v1-----");
		l.addLast(9);
        l.addLast(11);
        l.addLast(7);
        l.addLast(10);
        l.addLast(8);
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(5,11));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase3() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase3: list that doesn't contain v2-----");
		l.addLast(69);
        l.addLast(89);
        l.addLast(43);
        l.addLast(22);
        l.addLast(96);
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(22,100));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase4() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase4: list that doesn't contain v1 and v2-----");
		l.addLast(46);
        l.addLast(234);
        l.addLast(23);
        l.addLast(69);
        l.addLast(420);
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(0,666));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase5() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase5: An empty list-----");
        System.out.println("-Initial list: " + l);
        l.isComprisedBetween(69,420);
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase6() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase6: A list with a single element-----");
        l.addLast(178);
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(0,1000));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    private static void testCase7() {
        LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("-----testCase7: Already ordered list-----");
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        System.out.println("-Initial list: " + l);
        System.out.println("-New list: "+l.isComprisedBetween(1,5));
        System.out.println("-Initial list unchanged: " + l);
        System.out.println();
    }

    public static void main(String[] args) {
		
		System.out.println("-------------------------------------");
		System.out.println("* Student name: Alae Boufarrachene  *");
		System.out.println("* Student number: 300188539         *");
		System.out.println();

        testCase1();
			
		testCase2();
		
		testCase3();
		
		testCase4();

        testCase5();

        testCase6();

        testCase7();

        System.out.println("* Thank you for using my program !  *");
        System.out.println("-------------------------------------");
    }
}