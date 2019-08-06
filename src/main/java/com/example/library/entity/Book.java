package com.example.library.entity;

import com.example.library.entity.enums.Enums;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @JsonIgnoreProperties("books")
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books", cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Enums.genre getGenre() {
        return this.genre;
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

    public Book()
    {}

    public Book(String title, String ISBN, Enums.genre genre, List<Author> authors)
    {
        this.authors=authors;
        this.genre=genre;
        this.ISBN=ISBN;
        this.title=title;
    }

    public Book(Integer id, String title, String ISBN, Enums.genre genre, List<Author> authors)
    {
        this.id=id;
        this.authors=authors;
        this.genre=genre;
        this.ISBN=ISBN;
        this.title=title;
    }
}
