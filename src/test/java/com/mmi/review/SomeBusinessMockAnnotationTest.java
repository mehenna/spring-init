package com.mmi.review;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mmi.review.mokito.DataService;
import com.mmi.review.mokito.SomeBusinessImpl;

public class SomeBusinessMockAnnotationTest {

	@Test 
	public void testFindTheGretestFromAllData() {
		DataService dataService = mock(DataService.class);
		when(dataService.retrieveAllData()).thenReturn(new int [] {24,5,15,88});
		SomeBusinessImpl business = new SomeBusinessImpl(dataService);
		Optional<Integer> result=  business.findTheGretestFromAllData();
		assertEquals(result.get(), new Integer(88));
	}
}