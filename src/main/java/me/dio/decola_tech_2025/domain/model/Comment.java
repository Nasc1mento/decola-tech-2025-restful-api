package me.dio.decola_tech_2025.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {

    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private Set<Like> likes;


    @Override
    public String toString() {
        return "Comment{" +
                super.toString() +
                "content='" + content + '\'' +
                ", user=" + user +
                ", post=" + post +
                ", likes=" + likes +
                '}';
    }
}
