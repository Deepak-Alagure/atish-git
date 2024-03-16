package com.atish.entity;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name="posts")
public final class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private String content;


    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)//11-12 -2023
    private List<Comment> comments=new ArrayList<>();

 // @ one to many
    // etard eda speret work agtiti
    //post variable affect ayitr yella comment name clear agtav
    //mappedby=post  { post at edk hakevi andr child class dag perents object eti post namele}
}
