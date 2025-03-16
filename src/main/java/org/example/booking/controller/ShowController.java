package org.example.booking.controller;

import org.example.booking.entities.Show;
import org.example.booking.services.ShowService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping("/create")
    public String createShow(@RequestBody Show show) {
        showService.createShow(show);
        return "Show successfully created!";
    }

    @GetMapping
    public List<Show> fetchAllShows() {
        return showService.fetchAllShows();
    }

    @GetMapping("/{showId}")
    public Show fetchShowById(@PathVariable int showId) {
        return showService.fetchShowById(showId);
    }

    @DeleteMapping("/{showId}")
    public String removeShow(@PathVariable int showId) {
        showService.removeShow(showId);
        return "Show with ID " + showId + " has been removed.";
    }
}
