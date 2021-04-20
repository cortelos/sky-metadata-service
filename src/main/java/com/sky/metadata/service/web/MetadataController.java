package com.sky.metadata.service.web;

import com.sky.metadata.service.entity.Movie;
import com.sky.metadata.service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MetadataController {

    private final MovieRepository repository;

    @Autowired
    public MetadataController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/movies")
    public List<Movie> all() {
        return repository.findAll();
    }
}
