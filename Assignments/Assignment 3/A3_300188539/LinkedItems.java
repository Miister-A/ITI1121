/*******************************/
/*Students numbers: 
/*Students full names: 
/*******************************/

import java.util.*;

public class LinkedItems<E> {
	
	class Elem<T> {
		public T value;
		public Elem<T> next;

		Elem(T value, Elem<T> next) { //Node constructor (each individual element of the linked-list)
			this.value = value;
			this.next = next; //The attribute that links an element (node) with the next one
		}
	}
	
	private Elem<E> top;
	private int size=0;
	
	public LinkedItems() { //Data structure constructor (linked-list)
		top = null;
		this.size = size;
	}
	
    public boolean isEmpty() { //Common method : Checks if the linked-list is empty by returning a bool
		return top == null;
	}

	public void addToTop(E value) { //Common method : Pushes an element to the top of the linked-list (like a stack)

		Elem<E> addedElement = new Elem<E>(value,top);

		if (this.isEmpty()) { //Base case #1 : The list is empty and the added element becomes the top
            top = addedElement;
            size++;
        }

		else { //Base case #2 : The list isn't empty and there is an already-existing head
			addedElement.next = top; //Links the newly-added element with the former top 
			top = addedElement; //Pushes the newly-added element to the top
			size++;
		}
	}

	public Item removeDuplicates() {
		Elem<E> temp = top;
		List<Item> itemsList = new ArrayList<Item>();
		List<String> respectiveDuplicateLabels = new ArrayList<String>();
		for (int i=0 ; i<this.size ; i++) {
			itemsList.add((Item) temp.value);
			respectiveDuplicateLabels.add(((Item) temp.value).getLabel());
			temp = temp.next;
		}

		final Set<String> finalSet = new HashSet<String>();
		final Set<String> set = new HashSet<String>();

		for (String s : respectiveDuplicateLabels) {
			if (!set.add(s)) {
				finalSet.add(s);
			}
		}

		List<String> listOfDuplicates = new ArrayList<String>(finalSet);
		List<Float> respectivePrices = new ArrayList<Float>();
		List<Integer> respectiveQuantities = new ArrayList<Integer>();
		
		for (int i1=0 ; i1<listOfDuplicates.size() ; i1++) {
			for (int i2=0 ; i2<this.size ; i2++) {
				if (itemsList.get(i2).getLabel().equals(listOfDuplicates.get(i1))) {
					respectivePrices.add(itemsList.get(i2).getPrice());
					respectiveQuantities.add(itemsList.get(i2).getQuantity());
				}
			}
		}

		Collections.sort(respectivePrices);
		int sumOfQuantitiesOfDuplicates = respectiveQuantities.stream().mapToInt(Integer::intValue).sum();
		float lowestPriceOfDuplicates = respectivePrices.get(0);

		
		Item output = new Item(listOfDuplicates.get(0),sumOfQuantitiesOfDuplicates,lowestPriceOfDuplicates);

		return output;
	}

	public void removeDuplicatesHelper() {
        Elem<E> ptr1 = null, ptr2 = null, dup = null;
        ptr1 = top;
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;
            while (ptr2.next != null) {
                if (((Item) ptr1.value).getLabel() == ((Item) ptr2.next.value).getLabel()) {
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                }
                else {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }

	public void display() { //Common method : A printer method that displays all elements of the list
        Elem<E> current = top;  
        if (this.isEmpty()) {  
            System.out.println("The LinkedItems list is empty !");  
            return;  
        }  
        System.out.println("All linked items of the list :");  
        while (current != null) {  
            System.out.print(current.value + "\n");  
            current = current.next;  
        }  
    }

	public static void main(String[] string) {

		LinkedItems<Item> linkedItems = new LinkedItems<Item>();

		Item i1 = new Item("9LAWI", 420, 69);
		Item i2 = new Item("ZABI", 89, 420);
		Item i3 = new Item("7WINI",42069,69);
		Item i4 = new Item("ZABI",69,259);

		linkedItems.addToTop(i4);
		linkedItems.addToTop(i3);
		linkedItems.addToTop(i2);
		linkedItems.addToTop(i1);
		linkedItems.display();
		System.out.println("-------------------------------");
		linkedItems.display();
	}



}
