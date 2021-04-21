package org.vindicta.artists;

public class ArtistNotFoundException extends RuntimeException{
    ArtistNotFoundException(Long id){
        super("Could not find artist " + id);
    }
}
