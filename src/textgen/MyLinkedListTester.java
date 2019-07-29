/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		// @author: LCC
		boolean isAdd = list1.add(99);
		// check if the value has been added
		assertEquals("Add: check return is true", true, isAdd);
		// check if the size has been updated
		assertEquals("Add: check the size is correct:", 4, list1.size);
		// check the added value is surely 99
		assertEquals("Add: check the last element is correct: ", (Integer)99, list1.get(list1.size - 1));
		
		boolean isAdd2 = emptyList.add(99);
		assertEquals("Add: check return is true", true, isAdd2);
		assertEquals("Add: check the size is correct:", 1, emptyList.size);
		assertEquals("Add: check the last element is correct: ", (Integer)99, emptyList.get(emptyList.size - 1));
		
		boolean isAdd3 = shortList.add("C");
		assertEquals("Add: check return is true", true, isAdd3);
		assertEquals("Add: check the size is correct:", 3, shortList.size);
		assertEquals("Add: check the last element is correct: ", "C", shortList.get(shortList.size - 1));
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("size: check emptyList has size 0", 0, emptyList.size());
		assertEquals("size: check shortList has size 2", 2, shortList.size());
		// size() works good for adding
		emptyList.add(1);
		assertEquals("size: check emptyList has size 1 after adding one element", 1, emptyList.size());
		// size() works good for removing
		shortList.remove(0);
		assertEquals("size: check shortList has size 1 after removing one element", 1, shortList.size());
		
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		// check if the value has been added
		int preSize = list1.size;
		// cannot add element at index -1 
		try {
			list1.add(-1, 404);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		// cannot add element at index size+1
		try {
			list1.add(preSize+1, 404);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		list1.add(0, 404);
		// verify that 404 has been added at index 0
		assertEquals((Integer)404, list1.get(0));
		//verify that the second element is 65
		assertEquals((Integer)65, list1.get(1));
		// verify the size
		assertEquals(preSize+1, list1.size);
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    // list1
		int oldValue = list1.set(1, 99);
		assertEquals("set: check list1 idx 1 has old value of 21", 21, oldValue);
		assertEquals("set: check list1 idx 1 has new value of 99", (Integer)99, list1.get(1));
		try {
			list1.set(-1, 404);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			list1.set(3, 404);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		try {
			list1.set(2, null);
			fail("Check null");
		}
		catch (NullPointerException e) {
		}	
	}
	
	
	// TODO: Optionally add more test methods.
	@Test
	public void testToString() {
		System.out.println(list1.toString());
		System.out.println(shortList.toString());
	}
}
