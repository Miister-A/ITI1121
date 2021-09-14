/*******************************/
/*Student number: 300188539
/*Student full name: Alae Boufarrachene
/*******************************/

public class LinkedStack<E> implements Stack<E> {
	
	class Elem<T> {
		private T value;
		private Elem<T> next;

		Elem(T value, Elem<T> next) {
			this.value = value;
			this.next = next;
		}
	}	
	
	private Elem<E> top;
	
	public LinkedStack(){
		top = null;
	}
	
    public boolean isEmpty(){
		return top == null;
	}
	
    public E peek(){
		return top.value;
	}
	
    public E pop(){
		E temp = top.value;
		top = top.next;
		return temp;
	}
	
    public void push( E value){
		top = new Elem<E>(value,top);

	}
}

