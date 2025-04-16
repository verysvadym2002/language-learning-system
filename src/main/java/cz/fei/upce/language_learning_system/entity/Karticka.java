package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Karticka {
    @Id
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private Kurz course;

    @ManyToOne
    private Uzivatel uzivatel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kurz getCourse() {
        return course;
    }

    public void setCourse(Kurz course) {
        this.course = course;
    }

    public Uzivatel getUzivatel() {
        return uzivatel;
    }

    public void setUzivatel(Uzivatel uzivatel) {
        this.uzivatel = uzivatel;
    }
}
