package ug.awolak.javaee.kolokwium1.service;

import ug.awolak.javaee.kolokwium1.domain.Survey;

import java.util.ArrayList;
import java.util.List;

public class SurveyService {
    private List<Survey> db = new ArrayList<Survey>();

    public void addSurvey(Survey survey) {
        Survey newSurvey = new Survey(survey.getUser_name(), survey.getDate_from(), survey.getDate_to(), survey.getFrequency(), survey.getComments());
        db.add(newSurvey);
    }

    public List<Survey> getAllSurveys() {
        return db;
    }

    public void removeSurvey(Survey survey) {
        db.remove(survey);
    }
}