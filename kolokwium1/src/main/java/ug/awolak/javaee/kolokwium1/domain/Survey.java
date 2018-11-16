package ug.awolak.javaee.kolokwium1.domain;

public class Survey {
    private String user_name;
    private String date_from;
    private String date_to;
    private String frequency;
    private String comments;

    public Survey(String user_name, String date_from, String date_to, String frequency, String comments) {
        this.user_name = user_name;
        this.date_from = date_from;
        this.date_to = date_to;
        this.frequency = frequency;
        this.comments = comments;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
