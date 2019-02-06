package com.example.servletdemo.domain;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Survey {

    private List<String> comments = new ArrayList<String>();
    private String frequency = "Daily";
    private Date From = new Date();
    private Date To = new Date();

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
        String comments = "";
        for(String comment: this.comments) {
            comments += comment + "<br>";
        }
        return "From: " + df.format(From) + "<br>" +
                "To: " + df.format(To) + "<br>" +
                "Frequency: " + frequency + "<br>" +
                "Others:<br>" + comments;
    }

    public boolean ifCommentSelected(String comment) {
        for(String element: this.comments) {
            if(element.equals(comment)) {
                return true;
            }
        }
        return false;
    }
    
	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Date getFrom() {
		return From;
	}

	public void setFrom(Date from) {
		From = from;
	}

	public Date getTo() {
		return To;
	}

	public void setTo(Date to) {
		To = to;
	}

	public Survey(List<String> comments, String frequency, Date from, Date to) {
		super();
		this.comments = comments;
		this.frequency = frequency;
		From = from;
		To = to;
	}
	
    public Survey() {

    }
    
    
}
