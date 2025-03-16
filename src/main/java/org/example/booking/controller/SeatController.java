package org.example.booking.controller;

import org.example.booking.entities.Seat;
import org.example.booking.services.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/availability")
    public String checkSeatAvailability(@RequestParam int showId, @RequestParam int seatNo) {
        boolean available = seatService.isSeatAvailable(showId, seatNo);
        return available ? "Seat is available." : "Seat is occupied.";
    }

    @GetMapping
    public List<Seat> fetchAllSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/{seatId}")
    public Seat fetchSeatById(@PathVariable int seatId) {
        return seatService.getSeatById(seatId);
    }

    @DeleteMapping("/{seatId}")
    public String removeSeat(@PathVariable int seatId) {
        seatService.deleteSeat(seatId);
        return "Seat with ID " + seatId + " has been removed.";
    }
}
