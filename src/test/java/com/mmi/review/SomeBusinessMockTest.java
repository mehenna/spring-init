package com.mmi.review;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.mmi.review.mokito.DataService;
import com.mmi.review.mokito.SomeBusinessImpl;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	
	@Mock
	DataService dataService;
	
	@InjectMocks
	SomeBusinessImpl business;
	
	@Test 
	public void testFindTheGretestFromAllData() {
		when(dataService.retrieveAllData()).thenReturn(new int [] {24,5,15,88});
		Optional<Integer> result=  business.findTheGretestFromAllData();
		assertEquals(result.get(), new Integer(88));
	}
}