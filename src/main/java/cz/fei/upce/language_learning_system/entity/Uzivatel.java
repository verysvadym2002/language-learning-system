package cz.fei.upce.language_learning_system.entity;

import cz.fei.upce.language_learning_system.dto.UzivatelResponseDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity
public class Uzivatel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // Added role field

    @ManyToMany
    @JoinTable(
            name = "courses_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Kurz> courses;


    @ManyToMany
    @JoinTable(
            name = "tests_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private Set<Test> tests;

    @OneToMany(mappedBy = "uzivatel")
    private List<Karticka> cards;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public UzivatelResponseDto toResponseDto() {
        return new UzivatelResponseDto(
                this.id,
                this.userName,
                this.email
        );
    }
}
