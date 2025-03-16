package org.example.booking.services;

import java.util.List;


import org.example.booking.entities.Show;

public interface ShowService {
    void createShow(Show show);
    List<Show> fetchAllShows();
    Show fetchShowById(int id);
    void removeShow(int id);
}
