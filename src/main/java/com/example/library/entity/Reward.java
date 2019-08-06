package com.example.library.entity;


import javax.persistence.*;

@Entity
public class Reward {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer year;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="author_id", nullable=false)
    private Author author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Reward() {}

    public Reward(Integer year, String title, Author author)
    {
        this.year = year;
        this.title = title;
        this.author = author;
    }

    public Reward(Integer id, Integer year, String title, Author author)
    {
        this.id = id;
        this.year = year;
        this.title = title;
        this.author = author;
    }
}
