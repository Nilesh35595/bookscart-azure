package com.bookscart.azure.core;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

	
	Config config = new Config();
	
	public List<String> itemsList() {
		List list = new ArrayList<String>();
		list.add(config.getItem1());
		list.add(config.getItem2());
		list.add(config.getItem3());
		list.add(config.getItem4());
		list.add(config.getItem5());
		return list;
	}
	
}
