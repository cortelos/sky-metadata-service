package com.sky.metadata.service.configuration;

import com.sky.metadata.service.entity.Movie;
import com.sky.metadata.service.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {

    private static final Logger log = LoggerFactory.getLogger(DbConfig.class);

    @Bean
    CommandLineRunner initDatabase(MovieRepository repository) {

        return args -> {
            log.info("Loading movie " + repository.save(new Movie("Game of Thrones")));
            log.info("Loading movie " + repository.save(new Movie("Titanic")));
        };
    }
}
