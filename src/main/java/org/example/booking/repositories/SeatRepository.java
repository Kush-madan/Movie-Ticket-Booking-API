package org.example.booking.repositories;

import org.example.booking.entities.Seat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SeatRepository {

    private final JdbcTemplate jdbcTemplate;

    public SeatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean isSeatFree(int showId, int seatNo) {
        String sql = "SELECT COUNT(*) FROM tickets WHERE show_id = ? AND seat_no = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, showId, seatNo);
        return count == 0;
    }

    public List<Seat> fetchAll() {
        String sql = "SELECT * FROM seats";
        return jdbcTemplate.query(sql, new SeatRowMapper());
    }

    public Seat fetchById(int id) {
        String sql = "SELECT * FROM seats WHERE seat_id = ?";
        return jdbcTemplate.queryForObject(sql, new SeatRowMapper(), id);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM seats WHERE seat_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class SeatRowMapper implements RowMapper<Seat> {
        @Override
        public Seat mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Seat(
                rs.getInt("seat_id"),
                rs.getInt("movie_id"),
                rs.getInt("seat_number")
            );
        }
    }
}
