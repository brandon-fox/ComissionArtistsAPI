package org.vindicta.artists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistNotFoundAdviceTest {
    public static final long ID = 1L;
    ArtistNotFoundException artistNotFoundException = new ArtistNotFoundException(ID);

    @Test
    void artistNotFoundHandler() {

    }
}