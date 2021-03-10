package datastruct;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	protected UnsortedList list;
	protected UnsortedList expected;
	
	@Test
	public void testequals() {
		assertTrue(MyUnsortedList.of().equals(MyUnsortedList.of()));
		assertTrue(MyUnsortedList.of(2,1,3,4,5,6).equals(MyUnsortedList.of(2,1,3,4,5,6)));
		assertFalse(MyUnsortedList.of(2,1,3,4,5,6).equals(MyUnsortedList.of(2,1,4,5,6,5)));
		assertFalse(MyUnsortedList.of(2,1,3,4,5,6).equals(3));
		assertFalse(MyUnsortedList.of(2,1,3,4,5,6).equals(MyUnsortedList.of(2,1,4)));
		assertFalse(MyUnsortedList.of(2,1,3,4,5,6).equals(MyUnsortedList.of(2,4,5,6,5)));
		assertFalse(MyUnsortedList.of(2,1).equals(MyUnsortedList.of(2,1,4,5,6,5)));
		
	}
	
	@Test
	public void testtoString() {
		list = MyUnsortedList.of();
		expected = MyUnsortedList.of();
		assertEquals("",expected.toString(),list.toString());
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,4,5,6);
		assertEquals("",expected.toString(),list.toString());
		
	}

	@Test
	public void testisEmpty() {
		list = MyUnsortedList.of();
		assertEquals("empty list",true,list.isEmpty());
		
		list = MyUnsortedList.of(1);
		assertEquals("one element list",false,list.isEmpty());
		
		list = MyUnsortedList.of(null,1);
		assertEquals("first element is null",false,list.isEmpty());
	}
	
	@Test
	public void testsize() {
		list = MyUnsortedList.of();
		assertEquals("empty list",0,list.size());
		
		list = MyUnsortedList.of(1);
		assertEquals("one element list",1,list.size());
		
		list = MyUnsortedList.of(null,1);
		assertEquals("first element is null",2,list.size());
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		assertEquals("first element is null",6,list.size());
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopVide() throws Exception{
		list = MyUnsortedList.of();
		list.pop();
	}
	
	@Test
	public void testpop() {
		list = MyUnsortedList.of(1);
		expected = MyUnsortedList.of();
		assertEquals("vérification récuperation pop on element list",1,list.pop());
		assertEquals("pop one element list",expected,list);
		
		list = MyUnsortedList.of(null,1);
		expected = MyUnsortedList.of(1);
		assertEquals("vérification récuperation pop null first element list",null,list.pop());
		assertEquals("pop one element list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(1,3,4,5,6);
		assertEquals("vérification récuperation pop on long list",2,list.pop());
		assertEquals("pop one element list",expected,list);
	}
	
	@Test
	public void testPrepend() {
		list = MyUnsortedList.of();
		list.prepend(1);
		assertEquals("vérification prepend on element list",1,list.pop());
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.prepend(1);
		assertEquals("vérification prepend on long list",1,list.pop());
	}
	
	@Test(expected = EmptyListException.class)
	public void testPopLastVide() throws Exception{
		list = MyUnsortedList.of();
		list.popLast();
	}
	
	@Test
	public void testpopLast() {
		list = MyUnsortedList.of(1);
		expected = MyUnsortedList.of();
		assertEquals("vérification récuperation popLast on one element list",1,list.popLast());
		assertEquals("pop one element list",expected,list);
		
		list = MyUnsortedList.of(2,1);
		expected = MyUnsortedList.of(2);
		assertEquals("vérification récuperation popLast two element list",1,list.popLast());
		assertEquals("pop one element list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,4,5);
		assertEquals("vérification récuperation popLast on long list",6,list.popLast());
		assertEquals("pop one element list",expected,list);
	}
	
	@Test
	public void testappend() {
		list = MyUnsortedList.of();
		list.append(1);
		assertEquals("vérification append on empty list",1,list.popLast());
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.append(1);
		assertEquals("vérification append on long list",1,list.popLast());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testinsertnegativeIndex() throws Exception{
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.insert(10, -1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testinsertgreaterIndex() throws Exception{
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.insert(10,list.size()+1);
	}
	
	@Test
	public void testinsert() {
		list = MyUnsortedList.of();
		expected = MyUnsortedList.of(1);
		list.insert(1, 0);
		assertEquals("vérification insert 0 on empty list",expected,list);
		
		list = MyUnsortedList.of();
		expected = MyUnsortedList.of(1);
		list.insert(1, list.size());
		assertEquals("vérification insert size on empty list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(10,2,1,3,4,5,6);
		list.insert(10, 0);
		assertEquals("vérification insert 0 on long list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,4,5,6,10);
		list.insert(10, list.size());
		assertEquals("vérification insert size on long list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,10,4,5,6);
		list.insert(10, 3);
		assertEquals("vérification insert middle on long list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,4,5,10,6);
		list.insert(10, list.size()-1);
		assertEquals("vérification insert prelast on long list",expected,list);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testremovenegativeIndex() throws Exception{
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.remove(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testremovegreaterIndex() throws Exception{
		list = MyUnsortedList.of(2,1,3,4,5,6);
		list.remove(list.size());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testremoveemptylist() throws Exception{
		list = MyUnsortedList.of();
		list.remove(0);
	}
	
	@Test
	public void testremove() {
		list = MyUnsortedList.of(1);
		expected = MyUnsortedList.of();
		list.remove(0);
		assertEquals("vérification remove on one element list",expected,list);
		
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(1,3,4,5,6);
		list.remove(0);
		assertEquals("vérification insert 0 on long list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,4,5);
		list.remove(list.size()-1);
		assertEquals("vérification insert size on long list",expected,list);
		
		list = MyUnsortedList.of(2,1,3,4,5,6);
		expected = MyUnsortedList.of(2,1,3,5,6);
		list.remove(3);
		assertEquals("vérification insert middle on long list",expected,list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
