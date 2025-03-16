package org.example.booking.controller;

import org.example.booking.entities.Ticket;
import org.example.booking.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/reserve")
    public String reserveSeat(@RequestParam int showId,
                              @RequestParam int seatNo,
                              @RequestParam int customerId) {
        return ticketService.reserveSeat(showId, seatNo, customerId);
    }

    @GetMapping
    public List<Ticket> fetchAllTickets() {
        return ticketService.fetchAllTickets();
    }

    @GetMapping("/{ticketId}")
    public Ticket fetchTicketById(@PathVariable int ticketId) {
        return ticketService.fetchTicketById(ticketId);
    }

    @DeleteMapping("/{ticketId}")
    public String revokeTicket(@PathVariable int ticketId) {
        ticketService.revokeTicket(ticketId);
        return "Ticket with ID " + ticketId + " has been revoked.";
    }
}
