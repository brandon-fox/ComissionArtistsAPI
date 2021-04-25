package org.vindicta.artists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ArtistsWebApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ArtistsWebApplication.class, args);
    }
}
