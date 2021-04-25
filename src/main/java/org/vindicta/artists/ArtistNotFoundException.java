package org.vindicta.artists;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ArtistNotFoundException extends RuntimeException{
    ArtistNotFoundException(Long id){
        super("Could not find artist " + id);
    }
}
