
public class OrderedList implements OrderedStructure {

    private static class Node { //Implementation of the doubly-linked nodes

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    private Node head;

    public OrderedList() { //Representation of the empty list.
        head = new Node(null, null, null); 
        head.next = head;
        head.previous = head;
    }

    public int size() { //Calculates the size of the list
    	Node p = head;
    	int count = 0;
    	while ( p.next!=head ) {
    	    p = p.next;
    	    count++;
    	}
    	return count;
    }


    public Object get( int pos ) {

        if (pos < 0) { 
            throw new IndexOutOfBoundsException(Integer.toString(pos)); 
        }

        Node p = head.next; 

        for (int i = 0; i < pos; i++) { 
            if (p.next == head) { 
                throw new IndexOutOfBoundsException(Integer.toString(pos)); 
            } else { 
                p = p.next; 
            }
        }

        return p.value; 
    
    }

    public boolean add( Comparable o ) { //Adding an element while preserving the order

        if (o == null) { 
            throw new IllegalArgumentException("null"); 
        }
        
        if (head.next == head) { 
            head.next = new Node(o, head, head.next); 
        } else { 
            Node p = head; 

            while(p.next != head && p.next.value.compareTo(o) < 0) { 
                p = p.next; 
            }

            Node q = p.next; 
            p.next = new Node(o, p, q); 
            q.previous = p.next; 
        }

        return true; 

    }

    public void remove( int pos ) { //Removes one item from the position pos.

    	if ( pos < 0 ) 
    	    throw new IndexOutOfBoundsException( Integer.toString( pos ) );

    	Node p = head.next;
    	for ( int i=0; i<pos; i++ ) // traversing pos nodes
    		if ( p.next == head )
    		    throw new IndexOutOfBoundsException(Integer.toString(pos));
    		else
    		    p = p.next;
    	    
    	    Node del = p;  // the node to delete

    	    p = p.previous; // p designates de previous node

    	    Node q = del.next; // q designates the node that follows

    	    p.next = q;
    	    
    		q.previous = p;

    	    del.value = null;
    	    del.next = null;
    	    del.previous = null;
    }

    public void merge(OrderedList other) { //Knowing that both lists store their elements in increasing

        Node p = head.next; 
        Node q = other.head.next; 

        while(q != other.head) { 
            if (p == head) { 
                p.next = new Node(q.value, p, p.next); 
                p = p.next; 
                q = q.next; 
            } else if (q.value.compareTo(p.value) < 0) { 
                p.previous = new Node(q.value, p.previous, p); 
                p.previous.previous.next = p.previous; 
                q = q.next; 
            } else if (p.next==head) {
            	p.next = new Node( q.value, p,head );
            	p = p.next;
            	q = q.next;
            } else {
            	p = p.next;
            }
        }

    }

}