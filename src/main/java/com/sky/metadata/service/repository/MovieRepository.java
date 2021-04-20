package com.sky.metadata.service.repository;

import com.sky.metadata.service.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
