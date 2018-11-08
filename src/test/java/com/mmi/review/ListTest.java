package com.mmi.review;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;



public class ListTest {

	@Test
	public void test() {
		List<Object> listMock = mock(List.class);
		when(listMock.size()).thenReturn(10);
		assertEquals(10,listMock.size());
	}

	@Test
	public void testSizeMultipalReturn() {
		List<Object> listMock = mock(List.class);
		when(listMock.size()).thenReturn(10).thenReturn(20).thenReturn(30);
		assertEquals(10,listMock.size());
		assertEquals(20,listMock.size());
		assertEquals(30,listMock.size());
	}
	
	@Test
	public void testGet() {
		List<Object> listMock = mock(List.class);
		when(listMock.get(0)).thenReturn(10).thenReturn("Some info").thenReturn(30);
		assertEquals(10,listMock.get(0));
		assertEquals("Some info",listMock.get(0));
		assertEquals(30,listMock.get(0));
	}
	
	@Test
	public void testGetAntyIndex() {
		List<Object> listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("Some info");
		assertEquals("Some info",listMock.get(0));
		assertEquals("Some info",listMock.get(999999999));
	}
	
}
