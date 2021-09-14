/*******************************/
/*Student number : 300188539  
/*Student full name : Alae Boufarrachene  
/*******************************/

public class LinkedList<E extends Comparable<E>> {

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size=0;

    public boolean isEmpty() {
        return head == null;
    }
	
    public void addFirst(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        head = new Node<E>(elem, head);
        size++;
    }

    public void addLast(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            head = new Node<E>(elem, null);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<E>(elem, null);
        }
        size++;
    }
	
	//adding at a specific index
    public void add(E elem, int index) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            head = new Node<E>(elem, head);
        } else {
            Node<E> p = head;
            for (int i=0; i<(index-1); i++) {
                p = p.next;
            }
            p.next = new Node<E>(elem, p.next);
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new NullPointerException();
        }
        E saved = head.value;
        head = head.next;
        size--;
        return saved;
    }

    public E removeLast() {
        if (head == null) {
            throw new NullPointerException();
        }
        E saved;
        if (head.next == null) {
            saved = head.value;
            head = null;
        } else {
            Node<E> p = head;
            while (p.next.next != null) {
                p = p.next;
            }
            saved = p.next.value;
            p.next = null;
        }
        size--;
        return saved;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String str = "[";
        Node<E> p = head;
        while (p!=null) {
            if (p != head) {
                str += ", ";
            }
            str += p.value;
            p = p.next;
        }
        str += "]";
        return str;
    }

//*****************************************************	
//Do Not change anything above this line
//Add your code below this line
//*****************************************************

	//orderList() returns a list ordered in ascending order(smallest to greatest)
	//called by isComprisedBetween(E v1, E v2)

    private E getElementAtSpecificIndex(int index) { //Helper method : Returns a specific element from a linked-list without changing the list itself
        Node<E> currentElement = head;
        int intNavigator = 0;
        while (currentElement != null) {
            if (intNavigator==index) {
                return currentElement.value;
            }
            intNavigator++;
            currentElement = currentElement.next;
        }
        return null;
    }
	
    public LinkedList<E> orderList() { //Method that sorts a linked list in ascending order

		LinkedList<E> orderedList = new LinkedList<E>();
        Node<E> tempElement=null, tempIndex=null;
        E tempValue;

        for (int i=0 ; i<this.size() ; i++) { //Loop used to populate orderedList without changing the original list
            orderedList.add((E)this.getElementAtSpecificIndex(i),i); //Makes a call to the private helper method to retrieve an element at a specific index
        }

        if (orderedList.isEmpty()) { //Edge case : The list is empty
            System.out.println("Cannot be sorted because the list is empty !");
        }

        else { //Base case : List isn't empty and can be sorted

            for (tempElement=orderedList.head ; tempElement!=null ; tempElement=tempElement.next) {

                for (tempIndex=tempElement.next ; tempIndex!=null ; tempIndex=tempIndex.next) { 

                    if (tempElement.value.compareTo(tempIndex.value)>0) { 
                        tempValue = tempElement.value;  
                        tempElement.value = tempIndex.value;  
                        tempIndex.value = tempValue;  
                    }  

                }

            }

        }

		return orderedList;
	}
	
    public LinkedList<E> isComprisedBetween(E v1, E v2) {

		LinkedList<E> originalList = this;
        LinkedList<E> sortedList = this.orderList();
		LinkedList<E> newList = new LinkedList<E>();
        
        if (originalList.isEmpty()) { //Edge case : The list is empty
            System.out.println("The list is empty !");
        }

        else { //Base case : We navigate the sorted list and check if the current value is in the interval between v1 and v2

            for (int i2=0 ; i2<sortedList.size() ; i2++) {

                E temp = sortedList.getElementAtSpecificIndex(i2);
    
                if ((temp.compareTo(v1)>=0)&&(temp.compareTo(v2)<=0)) {
                    //If the current element has a value between v1 and v2 (inclusively), it's added to the new list
                    E temp2 = (E) temp;
                    newList.addLast(temp2);
                }
            }
    
            return newList;
        }
        return null;
    }
	
    public void myMeth() {
        Node<E> current = head;
        Node<E> before = null;
        Node<E> after = null;

        while (current.next!=null) {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
        head = current;
        head.next = before;
       
    }

    public static void main(String[] arg) {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
		l.addLast(4);
		l.addLast(5);
        l.myMeth();
        System.out.println(l);
    }
}
