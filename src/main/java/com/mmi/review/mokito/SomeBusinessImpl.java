package com.mmi.review.mokito;

import java.util.Arrays;
import java.util.Optional;

public class SomeBusinessImpl {
	private DataService dataService;
	/**
	 * 
	 * @param dataService
	 */
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	 /**
	  * 
	  * @return
	  */
	public Optional<Integer> findTheGretestFromAllData() {
		
		return  Arrays.stream(dataService.retrieveAllData())
				.boxed().max((x, y) -> x - y);
	}
}
