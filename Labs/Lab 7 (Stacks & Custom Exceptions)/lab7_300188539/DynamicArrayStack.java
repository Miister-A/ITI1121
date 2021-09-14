import java.util.EmptyStackException;

public class DynamicArrayStack<E> implements Stack<E>  {
	
	private E[] elems;  
	private int top; 
	private static final int DEFAULT_INC = 25;  
	
	@SuppressWarnings("unchecked")
	
	public DynamicArrayStack(int capacity) {
		elems = (E[]) new Object[capacity];
		tryEnlarge();
		top = 0;
	}
	
	public int getCapacity() {
		return elems.length;
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
	
	@SuppressWarnings("unchecked")
	
	public E pop() {
		if (top == 0) {
			throw new EmptyStackException();
		}
		E saved = elems[ --top ];
		
		elems[ top ] = null; // scrub the memory!
		tryReduce();
		return saved;
	}
	
	@SuppressWarnings("unchecked")
	
	public void push(E element) {
		tryEnlarge();
		elems[ top++ ] = element;
	}
	
	@SuppressWarnings("unchecked")
	
	public void clear() {
		elems = (E[]) new Object[DEFAULT_INC];
		top = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void tryEnlarge() {
		if (elems.length >= DEFAULT_INC && elems[elems.length - 1] == null) return;
		E[] newElems = (E[])new Object[elems.length + DEFAULT_INC];
		System.arraycopy(elems, 0, newElems, 0, elems.length);
		elems = newElems;
	}
	
	@SuppressWarnings("unchecked")
	private void tryReduce() {
		int nullCount = 0;
		for (; elems[elems.length - nullCount - 1] == null && nullCount < elems.length - 1; nullCount++);
		nullCount /= DEFAULT_INC;
		if (nullCount == 0) return;
		E[] newElems = (E[])new Object[elems.length - nullCount * DEFAULT_INC];
		System.arraycopy(elems, 0, newElems, 0, newElems.length);
		elems = newElems;
	}
}
