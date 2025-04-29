package cz.fei.upce.language_learning_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
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

}
