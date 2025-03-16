package org.example.booking.entities;

public class Seat {
    private int seatId;
    private int showId;
    private int seatNo;

    public Seat() {}

    public Seat(int seatId, int showId, int seatNo) {
        this.seatId = seatId;
        this.showId = showId;
        this.seatNo = seatNo;
    }

    public int getSeatId() { return seatId; }
    public void setSeatId(int seatId) { this.seatId = seatId; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public int getSeatNo() { return seatNo; }
    public void setSeatNo(int seatNo) { this.seatNo = seatNo; }
}
