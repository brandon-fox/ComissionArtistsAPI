package org.vindicta.artists;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ArtistsRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Artist("Bilbo Baggins")));
            log.info("Preloading " + repository.save(new Artist("Frodo Baggins")));
        };
    }
}
