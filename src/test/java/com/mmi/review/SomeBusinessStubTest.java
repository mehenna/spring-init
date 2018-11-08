package com.mmi.review;


import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.junit.Test;
import com.mmi.review.mokito.DataService;
import com.mmi.review.mokito.SomeBusinessImpl;

public class SomeBusinessStubTest {

	@Test 
	public void testFindTheGretestFromAllData() {
		SomeBusinessImpl business = new SomeBusinessImpl(new DataServiceStub());
		Optional<Integer> result=  business.findTheGretestFromAllData();
		assertEquals(result.get(), new Integer(417));
	}

}

class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		return new int [] {24,5,15,417} ;
	}
	
}