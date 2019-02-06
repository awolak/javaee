package com.example.servletdemo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.servletdemo.domain.Survey;

public class SurveyService {
	    private Map<String, Survey> db = new HashMap<String, Survey>();

	    public Map<String, Survey> getAllSurveys() {
	        return db;
	    }

	    public void add(String id, Survey survey) {
	        db.put(id, survey);
	    }
}
