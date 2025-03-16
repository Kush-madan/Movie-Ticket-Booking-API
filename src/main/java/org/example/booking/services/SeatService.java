package org.example.booking.services;
import java.util.List;

import org.example.booking.entities.Seat;

public interface SeatService {
    boolean isSeatAvailable(int movieId, int seatNumber);
    List<Seat> getAllSeats();
    Seat getSeatById(int id);
    void deleteSeat(int id);
}
