package org.example.booking.entities;

public class Ticket {
    private int ticketId;
    private int showId;
    private int seatNo;
    private int customerId;

    public Ticket() {}

    public Ticket(int ticketId, int showId, int seatNo, int customerId) {
        this.ticketId = ticketId;
        this.showId = showId;
        this.seatNo = seatNo;
        this.customerId = customerId;
    }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getShowId() { return showId; }
    public void setShowId(int showId) { this.showId = showId; }

    public int getSeatNo() { return seatNo; }
    public void setSeatNo(int seatNo) { this.seatNo = seatNo; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
}
