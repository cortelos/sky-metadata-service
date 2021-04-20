package com.sky.metadata.service.web;

import com.sky.metadata.service.entity.Movie;
import com.sky.metadata.service.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MetadataController {

    private static final Logger log = LoggerFactory.getLogger(MetadataController.class);

    private final MovieRepository repository;

    @Autowired
    public MetadataController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movie> list() {

        return repository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Movie movie) {

        Movie savedMovie = repository.save(movie)

        log.info("Added movie {}", savedMovie);
    }
}
