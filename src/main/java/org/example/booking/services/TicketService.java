package org.example.booking.services;

import java.util.List;
import org.example.booking.entities.Ticket;

public interface TicketService {
    String reserveSeat(int showId, int seatNo, int customerId);
    List<Ticket> fetchAllTickets();
    Ticket fetchTicketById(int id);
    void revokeTicket(int id);
}
