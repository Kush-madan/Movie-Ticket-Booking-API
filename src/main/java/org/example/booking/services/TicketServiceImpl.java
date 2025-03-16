package org.example.booking.services;

import org.example.booking.entities.Ticket;
import org.example.booking.repositories.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final SeatService seatService;

    public TicketServiceImpl(TicketRepository ticketRepository, SeatService seatService) {
        this.ticketRepository = ticketRepository;
        this.seatService = seatService;
    }

    @Transactional
    public String reserveSeat(int showId, int seatNo, int customerId) {
        if (seatService.isSeatAvailable(showId, seatNo)) {
            boolean success = ticketRepository.reserve(showId, seatNo, customerId);
            return success ? "Reservation successful!" : "Seat is occupied.";
        }
        return "Seat is unavailable.";
    }

    @Override
    public List<Ticket> fetchAllTickets() {
        return ticketRepository.fetchAll();
    }

    @Override
    public Ticket fetchTicketById(int id) {
        return ticketRepository.fetchById(id);
    }

    @Override
    @Transactional
    public void revokeTicket(int id) {
        ticketRepository.deleteById(id);
    }
}
