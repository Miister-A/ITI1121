
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
	
	
	private E[] elems;
	private int top;    
	private int capacity;    
	
	@SuppressWarnings("unchecked")
	
	public ArrayStack(int capacity) {
		elems = (E[]) new Object[ capacity ];
		top = 0;
		this.capacity = capacity;
	}
	
	public boolean isEmpty() {	
		return (top == 0);
	}
	
	public E peek() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		return elems[ top-1 ];
	}
	
	public E pop() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		E saved = elems[ --top ];
		elems[ top ] = null;
		return saved;
	}
	
	public void push(E element) {
		if (top == capacity) {
			throw new FullStackException();
		}
		elems[ top++ ] = element;
	}
	
	public int getCapacity() {
		return elems.length;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		elems = (E[]) new Object[capacity];
		top = 0;
	}
	
}
