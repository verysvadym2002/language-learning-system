package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.Set;

@Entity
public class Test {
    @Id
    private Long id;

    private String topic;

    @ManyToMany(mappedBy = "tests")
    private Set<Uzivatel> users;

    public Set<Uzivatel> getUsers() {
        return users;
    }

    public void setUsers(Set<Uzivatel> users) {
        this.users = users;
    }

    @ManyToOne
    private Kurz course;

    public Kurz getCourse() {
        return course;
    }

    public void setCourse(Kurz course) {
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
