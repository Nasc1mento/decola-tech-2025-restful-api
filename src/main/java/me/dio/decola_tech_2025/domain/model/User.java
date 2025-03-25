package me.dio.decola_tech_2025.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = true, unique = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Post> articles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Like> likes;


    @Override
    public String toString() {
        return "User{" +
                super.toString() +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", articles=" + articles +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
