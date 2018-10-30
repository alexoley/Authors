package com.example.author.entity;

//import com.mysql.fabric.xmlrpc.base.Data;

import javax.persistence.*;
import java.util.*;

@Entity // This tells Hibernate to make a table out of this class
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Enums.sex sex;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList();

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Reward> rewards = new ArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Enums.sex getSex() {
        return sex;
    }

    public void setSex(Enums.sex sex) {
        this.sex = sex;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void setBooks(Collection<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public java.util.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public void setRewards(Collection<Reward> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

}