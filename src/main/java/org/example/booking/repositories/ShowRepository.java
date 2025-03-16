package org.example.booking.repositories;

import org.example.booking.entities.Show;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShowRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShowRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Show show) {
        String sql = "INSERT INTO movies (movie_id, movie_time) VALUES (?, ?)";
        jdbcTemplate.update(sql, show.getTitle(), show.getStartTime());
    }

    public List<Show> fetchAll() {
        String sql = "SELECT * FROM movies ORDER BY movie_time ASC";
        return jdbcTemplate.query(sql, new ShowRowMapper());
    }

    public Show fetchById(int id) {
        String sql = "SELECT * FROM movies WHERE movie_id = ?";
        return jdbcTemplate.queryForObject(sql, new ShowRowMapper(), id);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM movies WHERE movie_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class ShowRowMapper implements RowMapper<Show> {
        @Override
        public Show mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Show(
                rs.getInt("movie_id"),
                rs.getString("movie_name"),
                rs.getTimestamp("movie_time")
            );
        }
    }
}
