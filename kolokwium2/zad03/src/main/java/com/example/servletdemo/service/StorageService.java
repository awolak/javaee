package com.example.servletdemo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.servletdemo.domain.Lace;


public class StorageService {
	
	private Map<Long, Lace> db = new HashMap<Long, Lace>();

	public void add(Lace lace) {
		Lace newLace = new Lace(lace.getName(), lace.isColorful(), lace.isPlain(), lace.isUsed(), lace.getPrice(), lace.getProductionDate());
		db.put(newLace.getId(), newLace);
	}

	public Map<Long, Lace> getAllLaces(){
		return db;
	}

}
