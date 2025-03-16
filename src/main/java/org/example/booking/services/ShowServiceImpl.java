package org.example.booking.services;

import org.example.booking.entities.Show;
import org.example.booking.repositories.ShowRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @Override
    public void createShow(Show show) {
        showRepository.save(show);
    }

    @Override
    public List<Show> fetchAllShows() {
        return showRepository.fetchAll();
    }

    @Override
    public Show fetchShowById(int id) {
        return showRepository.fetchById(id);
    }

    @Override
    public void removeShow(int id) {
        showRepository.deleteById(id);
    }
}
