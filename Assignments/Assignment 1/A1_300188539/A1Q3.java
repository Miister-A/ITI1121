//Student name: Alae Boufarrachene
//Student number: 300188539

import java.util.Scanner;

public class A1Q3 { 
	
	public static void main(String[] args) { 
		
        Scanner inputNames = new Scanner(System.in); //Scanner object used to retrieve the item names (strings)
		System.out.print("-Please enter the items names separated by commas :");
		String names = inputNames.nextLine();
        String[] namesArray = names.split(",");

        Scanner inputQuantities = new Scanner(System.in); //Scanner object used to retrieve the sentences (strings)
		System.out.print("-Please enter the items quantities separated by commas :");
		String strings = inputQuantities.nextLine();
        String[] quantitiesArray = strings.split(",");
		int[] quantitiesIntArray = new int[quantitiesArray.length]; //Creates an array of integers equal to the size of the string array
		for (int i=0 ; i<quantitiesArray.length ; i++) { //Loop that converts all the Strings into integers
			quantitiesIntArray[i] = Integer.parseInt(quantitiesArray[i]);
		}

        //Checks which number of attributes is higher to populate the array of items adequately
        if (namesArray.length<=quantitiesIntArray.length) { //Base case #1 : More number attributes than name

            Item[] itemsArray = new Item[quantitiesArray.length]; //We create an array of items equal to the number of items (which is superior rn)

            for (int i=0 ; i<quantitiesArray.length ; i++) { 
                if (i>=namesArray.length) { //Once the index that's equal to the end of name attributes, we create objects with a pre-defined name attribute
                    Item item = new Item("unknown",quantitiesIntArray[i]);
                    itemsArray[i] = item;
                    itemsArray[i].display();
                }
                else { //Up until the index that's equal to the number of names, we populate from both attribute arrays at the same positions
                    Item item = new Item(namesArray[i],quantitiesIntArray[i]);
                    itemsArray[i] = item;
                    itemsArray[i].display();
                }
            }
        }
        if (quantitiesIntArray.length<namesArray.length) {
            
            Item[] itemsArray = new Item[namesArray.length]; //We create an array of items equal to the number of item names (which is superior rn)

            for (int i=0 ; i<namesArray.length ; i++) { 
                if (i>=quantitiesArray.length) { //Once the index that's equal to the end of name attributes, we create objects with a pre-defined name attribute
                    Item item = new Item(namesArray[i],0);
                    itemsArray[i] = item;
                    itemsArray[i].display();
                }
                else { //Up until the index that's equal to the number of names, we populate from both attribute arrays at the same positions
                    Item item = new Item(namesArray[i],quantitiesIntArray[i]);
                    itemsArray[i] = item;
                    itemsArray[i].display();
                }
            }
        }
        inputNames.close();
        inputQuantities.close();
	}
}

class Item {
  
    private String name;
    private int quantity;
  
    //Item class constructor
    Item(String name, int quantity) {
        this.name = name;
		this.quantity = quantity;
	}
    //Display() method to display Item information
    public void display() {
        System.out.print(this.name + " : " + this.quantity+" - ");
    }  
}