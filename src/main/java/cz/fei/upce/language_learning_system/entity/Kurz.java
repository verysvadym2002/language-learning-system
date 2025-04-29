package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity
public class Kurz {
    @Id
    private Long id;

    private String language;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Uzivatel> users;


    @OneToMany(mappedBy = "course")
    private List<Karticka> cards;


    @OneToMany(mappedBy = "course")
    private List<Test> tests;

}
