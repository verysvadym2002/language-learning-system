package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.Set;

@Entity
public class Kurz {
    @Id
    private Long id;

    private String language;

    private String description;

    @ManyToMany(mappedBy = "courses")
    private Set<Uzivatel> users;

    public Set<Uzivatel> getUsers() {
        return users;
    }

    public void setUsers(Set<Uzivatel> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "course")
    private List<Karticka> cards;

    public List<Karticka> getCards() {
        return cards;
    }

    public void setCards(List<Karticka> cards) {
        this.cards = cards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "course")
    private List<Test> tests;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}
