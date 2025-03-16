package org.example.booking.repositories;

import org.example.booking.entities.Ticket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TicketRepository {

    private final JdbcTemplate jdbcTemplate;

    public TicketRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean reserve(int showId, int seatNo, int customerId) {
        String checkSeatQuery = "SELECT COUNT(*) FROM bookings WHERE show_id = ? AND seat_no = ?";
        int count = jdbcTemplate.queryForObject(checkSeatQuery, Integer.class, showId, seatNo);

        if (count == 0) {
            String insertQuery = "INSERT INTO bookings (show_id, seat_no, customer_id) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, showId, seatNo, customerId);
            return true;
        }
        return false;
    }

    public List<Ticket> fetchAll() {
        String sql = "SELECT * FROM bookings";
        return jdbcTemplate.query(sql, new TicketRowMapper());
    }

    public Ticket fetchById(int id) {
        String sql = "SELECT * FROM bookings WHERE booking_id = ?";
        return jdbcTemplate.queryForObject(sql, new TicketRowMapper(), id);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM bookings WHERE booking_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class TicketRowMapper implements RowMapper<Ticket> {
        @Override
        public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Ticket(
                rs.getInt("booking_id"),
                rs.getInt("movie_id"),
                rs.getInt("seat_number"),
                rs.getInt("user_id")
            );
        }
    }
}
