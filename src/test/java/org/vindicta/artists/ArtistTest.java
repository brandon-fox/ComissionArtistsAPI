package org.vindicta.artists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {
    Artist artist;

    @BeforeEach
    void setUp() {
        artist = new Artist();
    }

    @AfterEach
    void tearDown() {
        artist = null;
    }


    @Test
    void getSkills() {
        assertNotNull(artist.getSkills());
        assertThat(artist.getSkills(), instanceOf(List.class));
    }

    @Test
    void setSkills() {
        List<String> skills = new ArrayList<>();
        skills.add("Painting");
        artist.setSkills(skills);
        assertEquals(skills, artist.getSkills());
    }

    @Test
    void addSkill() {
        String skill = "Building Stuff";
        artist.addSkill(skill);
        assertThat(artist.getSkills(), contains(skill));
    }

    @Test
    void getName() {
        assertThat(artist.getName(), is(""));
    }
}