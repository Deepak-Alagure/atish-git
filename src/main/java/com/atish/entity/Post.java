package com.atish.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="posts")
public final class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String title;
    private String description;

    private String content;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)//11-12 -2023
    private List<Comment> comments=new ArrayList<>();
 // @ one to many
    // etard eda speret work agtiti
    //post variable affect ayitr yella comment name clear agtav
}
