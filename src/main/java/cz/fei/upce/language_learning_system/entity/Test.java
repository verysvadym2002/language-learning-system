package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Test {
    @Id
    private Long id;

    private String topic;

    @ManyToMany(mappedBy = "tests")
    private Set<Uzivatel> users;



    @ManyToOne
    private Kurz course;



}
