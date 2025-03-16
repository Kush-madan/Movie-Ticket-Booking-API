package org.example.booking.services;
import org.example.booking.entities.Seat;
import org.example.booking.repositories.SeatRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public boolean isSeatAvailable(int movieId, int seatNumber) {
        return seatRepository.isSeatFree(movieId, seatNumber);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.fetchAll();
    }

    @Override
    public Seat getSeatById(int id) {
        return seatRepository.fetchById(id);
}

	@Override
	public void deleteSeat(int id) {
		seatRepository.deleteById(id);
		
	}}