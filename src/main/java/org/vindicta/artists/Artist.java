package org.vindicta.artists;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artist {
    @ElementCollection
    List<String> skills;
    private String name = "";
    private @Id
    @GeneratedValue
    Long id;


    public Artist() {
        this.skills = new ArrayList<>();
    }

    Artist(String name) {
        super();
        this.name = name;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void addSkill(String skill) {
        this.skills.add(skill);
    }

    public String getName() {
        return name;
    }
}
