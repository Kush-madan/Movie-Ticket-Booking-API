package org.example.booking.entities;

import java.sql.Timestamp;

public class Show {
    private int showId;
    private String title;
    private Timestamp startTime;

    public Show() {}

    public Show(int showId, String title, Timestamp startTime) {
        this.showId = showId;
        this.title = title;
        this.startTime = startTime;
    }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Timestamp getStartTime() { return startTime; }
    public void setStartTime(Timestamp startTime) { this.startTime = startTime; }
}
