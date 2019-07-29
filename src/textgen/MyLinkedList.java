package textgen;

import java.util.AbstractList;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.beans.value.ObservableDoubleValue;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 * @author LCC
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		// TODO: Implement this method
		if (element.equals(null)) {
			throw new NullPointerException("element is null");
		}
		LLNode<E> lastNode = tail.prev;
		LLNode<E> newNode = new LLNode<E>(element);
		lastNode.next = newNode;
		newNode.prev = lastNode;
		newNode.next = tail;
		tail.prev = newNode;
		size++;
		
//		add(size, element);
		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("The index is out of bounds.");
		}
		LLNode<E> currNode = head.next;
		int i = 0;
		while (i<index) {
			i++;
			currNode = currNode.next;
		}
		return currNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		// valid element
		if (element == null) {
			throw new NullPointerException("Input element is Null");
		}
		// valid index
//		E currElement = get(index);
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException("The index is out of bounds.");
		}
		
		// add element at index
		LLNode<E> currNode = head;
		LLNode<E> preNode = null;
		LLNode<E> oriNode = null;
		LLNode<E> newNode = new LLNode<E>(element);
		for(int i = -1; i < index + 1; i++) {
			if(i == index - 1) {
				preNode = currNode;
			}
			if(i == index) {
				oriNode = currNode;
			}
			currNode = currNode.next;
			// actual adding
			if(preNode != null && oriNode != null) {
				preNode.next = newNode;
				newNode.next = oriNode;
				newNode.prev = preNode;
				oriNode.prev = newNode;
				size++;
			}
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		// valid index
		if(size == 0) {
			throw new IndexOutOfBoundsException("The LinkedList is already emtpy");
		}
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("The index is out of bound");
		}
		LLNode<E> currNode = head.next; 
		E removedData = null;
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				removedData = currNode.data;
				currNode.prev.next = currNode.next;
				currNode.next.prev = currNode.prev;
				size--;
			}
			currNode = currNode.next;
		}
		
		
		
		return removedData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Null element");
		}
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException("Index out");
		}
		LLNode<E> currNode = head.next;
		E oldValue = null;
		for(int i = 0; i <= index; i++) {
			if(i == index) {
				oldValue = currNode.data;
				currNode.data = element;
			}
			currNode = currNode.next;
		}
		return oldValue;
	}
	
	public String toString() {
		String string = new String();
		for(E element: this) {
			string = string + element;
			string = string + ", ";
		}
		return string;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
