/*******************************/
/*Students numbers: 
/*Students full names: 
/*******************************/

import java.util.*;

public class A3Q2 {
	
	public static void main(String[] args) throws NumberFormatException {
		System.out.println("Welcome to my LinkedItems program ! :)");
		System.out.println("DISCLAIMER : THIS PROGRAM DOESN'T WORK WITH INPUTS HAVING DIFFERENT DUPLICATES");
		LinkedItems<Item> linkedItems = new LinkedItems<Item>();
		List<Item> itemsList = new ArrayList<Item>();
		
		System.out.print("Would you like to enter an Item? (Y/N)");
		Scanner input1 = new Scanner(System.in);
		String stringInput = input1.nextLine();

		while (stringInput.toLowerCase().equals("y")) { 
			System.out.print("-Please enter an item :");
			try { 	
			Scanner input2 = new Scanner(System.in);
			String stringInput2 = input2.nextLine();
			String[] tempArray = stringInput2.split(" ");
			String tempLabel = tempArray[0];
			int tempQuantity = Integer.parseInt(tempArray[1]);
			float tempPrice = Float.parseFloat(tempArray[2]);
			Item addedItem = new Item(tempLabel,tempQuantity,tempPrice);
			itemsList.add(addedItem);
			System.out.print("Would you like to enter another Item? (Y/N)");
			stringInput = input1.next();
			}
			catch (NumberFormatException e) {
				System.out.println(e);
				System.out.println("You've entered an input in the wrong format, please try again !");
			}
		}
		input1.close();
		for (int i=0 ; i<itemsList.size() ; i++) {
			linkedItems.addToTop(itemsList.get(i));
		}

		Item replacer = linkedItems.removeDuplicates();
		int index=0;
		for (int i1=0 ; i1<itemsList.size() ; i1++) {
			if (itemsList.get(i1).getLabel().equals(replacer.getLabel())) {
				index=i1;
				break;
			}
		}

		List<Item> finalItemsList = new ArrayList<Item>();
		for (int i2=0 ; i2<itemsList.size() ; i2++) {
			if (replacer.getLabel().equals(itemsList.get(i2).getLabel())) {
				continue;
			}
			else {
				finalItemsList.add(itemsList.get(i2));
			}
		}

		finalItemsList.add(index, replacer);
		LinkedItems<Item> finalLinkedItems = new LinkedItems<Item>();
		for (int i3=0 ; i3<finalItemsList.size() ; i3++) { 
			finalLinkedItems.addToTop(finalItemsList.get(i3));
		}

		float totalValue=0;
		for (int i4=0 ; i4<finalItemsList.size() ; i4++) {
			float temp = (float) finalItemsList.get(i4).getQuantity();
			totalValue = totalValue + (finalItemsList.get(i4).getPrice()*temp);
		}

		List<Float> prices = new ArrayList<Float>();
		List<Item> output = new ArrayList<Item>();
		for (int i5=0 ; i5<finalItemsList.size() ; i5++) {
			prices.add(finalItemsList.get(i5).getPrice());
		}
		Collections.sort(prices);
		for (int i6=0 ; i6<finalItemsList.size() ; i6++) {
			if (finalItemsList.get(i6).getPrice()==prices.get(0)) {
				output.add(finalItemsList.get(i6));
			}
			if (finalItemsList.get(i6).getPrice()==prices.get(finalItemsList.size()-1)) {
				output.add(finalItemsList.get(i6));
			}
		}


		System.out.println("------------------------------------------------------");
		System.out.println("-----The linked list as entered by the user-----");
		linkedItems.display();
		System.out.println("-----The linked list after eliminating duplicates-----");
		finalLinkedItems.display();
		System.out.println("------------------------------------------------------");
		System.out.println("-The total value of stored items : "+totalValue);
		System.out.println("-The most expensive item : "+output.get(0));
		System.out.println("-The least expensive item : "+output.get(1)+"\n");
		
		System.out.println("Thank you for using my LinkedItems program, goodbye !");
	}
}

