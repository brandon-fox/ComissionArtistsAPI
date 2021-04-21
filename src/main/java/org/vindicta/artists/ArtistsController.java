package org.vindicta.artists;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    private final ArtistsRepository repository;

    public ArtistsController(ArtistsRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    Artist newArtist(@RequestBody Artist newArtist) {
        return repository.save(newArtist);
    }


    @GetMapping()
    List<Artist> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Artist artistByID(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ArtistNotFoundException(id));
    }

}
