package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;



@Entity
public class Uzivatel {
    @Id
    private Long id;

    private String userName;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(
            name = "courses_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Kurz> courses;

    public Set<Kurz> getCourses() {
        return courses;
    }

    public void setCourses(Set<Kurz> likedUsers) {
        this.courses = likedUsers;
    }

    @ManyToMany
    @JoinTable(
            name = "tests_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private Set<Test> tests;

    public Set<Test> getTests() {
        return tests;
    }

    public void setTests(Set<Test> tests) {
        this.tests = tests;
    }

    @OneToMany(mappedBy = "uzivatel")
    private List<Karticka> cards;

    public List<Karticka> getCards() {
        return cards;
    }

    public void setCards(List<Karticka> cards) {
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
