/*******************************/
/*Students numbers: 300188539
/*Students full names: Alae Boufarrachene
/*******************************/

public class DoublyLinkedList<E extends Comparable<E>> {

    private static class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;
        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;
	

    public void addLast(E elem) {
        if (elem == null) {
            throw new NullPointerException();
        }
        if (head == null) {
            head = new Node<E>(elem, null, null);
        } else {
			Node<E> p = head;
			while(p.next != null){
				p = p.next;
			}
            p.next = new Node<E>(elem, p, null);
        }
        size++;
    }
	
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
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

//Do Not change anything above this line
//**************************************************************************
// your code after this line

    private Node<E> removeElement(Node<E> del) { //Helper method : Removing an element of the DLL

        if (this.head==null || del==null)
            return null;

        if (this.head==del)
            this.head = del.next;
 
        if (del.next!=null)
            del.next.previous = del.previous;
 
        if (del.previous != null)
            del.previous.next = del.next;

        del = null;
 
        return head;
    }
 
    private void removeElementAtSpecificIndex(int index) { //Helper method : Removing an element of the DLL at a specific index

        if (this.head==null || index<=0) {
            return;
        }
 
        Node<E> current = this.head;
        int i;
 
        for (i=1 ; current!=null && i<index ; i++) {
            current = current.next;
        }
         
        if (current==null) {
            return;
        }
 
        this.removeElement(current);
    }

    private void addToStart(E elem) { //Helper method : Adding an element to the start of the DLL

        Node<E> addedNode = new Node<E>(elem,null,null);

        if (this.isEmpty()) { //Edge case when the list is empty
            head = addedNode;
            size++;
        }

        else { 
            head.previous = addedNode; //Links the head with the newly-added node
            addedNode.next = head; //Links the newly-added node with the head
            head = addedNode; //Sets the newly-added node as the new head
            size++;
        }
    }

    private void addAtSpecificIndex(E value, int index) { //Helper method : Adding an element at a specific position

        Node<E> addedNode = new Node<E>(value, null, null);

        if (index>this.size-1 || index<0) { //Edge case : Index out of range
            System.out.println("The following index is out of range:"+index);
        }

        else if (index==0) { //Base case : The node is added at the beginning of the DLL
            this.addToStart(value);
            size++;
        }

        else if (index==this.size-1) { //Base case : The node is added at the end of the DLL
            this.addLast(value);
        }

        else { //Base case : The node is added in the middle of the DLL

            Node<E> tempNode = head;
            int loopIndex=0;

            while (loopIndex<index-1) {
                if(tempNode != null) {
                    tempNode = tempNode.next;
                }
                loopIndex++;
                size++;
            }

            if (tempNode != null) {
                addedNode.next = tempNode.next;
                addedNode.previous = tempNode;
                tempNode.next = addedNode;
                size++;

                if (addedNode.next != null) {
                    addedNode.next.previous = addedNode;
                    size++;
                }
            }

        }  
    }

    //Main method : Adds the last element of someList before the last occurrence of beforeMe in myList
    //and that element that was added to myList is removed from someList. 
    public void addSpecific(E beforeMe, DoublyLinkedList<E> someList) { 

        if (this.isEmpty()) { //Edge case : Empty myList
            System.out.println("myList is empty !");
        }

        else if (someList.isEmpty()) { //Edge case : Empty someList
            System.out.println("someList is empty !");
        }

        else { //General case : The lists aren't empty

            Node<E> tempElem=someList.head, lastElemToBeAdded=null;
            for (int i=0 ; i<someList.size() ; i++) { //Loop used to retrieve the last element of someList to be added
                if (i==someList.size()-1) {
                    lastElemToBeAdded = tempElem;
                    break;
                }
                tempElem = tempElem.next;
            }

            DoublyLinkedList<Integer> indiceList = new DoublyLinkedList<Integer>(); //DLL that stores the indices of all occurences of beforeMe

            tempElem = this.head;
            for (int i2=0 ; i2<this.size() ; i2++) { //Loop used to retrieve the indices of all instances of beforeMe and adds them to the indiceList
                if (beforeMe.compareTo(tempElem.value)==0) {
                    indiceList.addToStart(i2);
                }
                tempElem = tempElem.next;
            }

            if (indiceList.isEmpty()) { //Edge case : beforeMe doesn’t exist in myList
                System.out.println("The beforeMe element {"+beforeMe+"} was not found in myList !");
            }

            else {//General case : All conditions are satisfied

                if (indiceList.head.value==this.size()-1) { //Base case : BeforeMe is the last element of the DLL

                    this.addAtSpecificIndex(lastElemToBeAdded.value, this.size()-1);

                    Node<E> tempElem2 = null;
                    tempElem = this.head;
                    for (int i3=0 ; i3<this.size() ; i3++) {
                        if (i3==this.size()-2) {
                            tempElem2 = tempElem;
                            break;
                        }
                        tempElem = tempElem.next;
                    }
                    
                    this.removeElementAtSpecificIndex(this.size()-1);
                    this.addLast(tempElem2.value);
                    someList.removeElementAtSpecificIndex(someList.size()); 
                }

                else { //Base case : The last occurence of beforeMe isn't the last element
                    this.addAtSpecificIndex(lastElemToBeAdded.value, indiceList.head.value);
                    someList.removeElementAtSpecificIndex(someList.size()); 
                }
            }   
        }
    }
}