package com.example.author.entity;

import com.example.author.entity.enums.Enums;

import javax.persistence.*;
import java.util.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String ISBN;

    @Enumerated(EnumType.STRING)
    private Enums.genre genre;

    @JoinTable
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Author> authors = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public Enums.genre getGenre() {
        return genre;
    }

    public void setGenre(Enums.genre genre) {
        this.genre = genre;
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = new ArrayList<>(authors);
    }

}
