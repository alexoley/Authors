package com.example.library.entity;

import com.example.library.entity.enums.Enums;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Enums.sex sex;

    @JsonIgnoreProperties("authors")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
    joinColumns = { @JoinColumn(name = "author_id") },
    inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    List<Book> books = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Reward> rewards;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Enums.sex getSex() {
        return this.sex;
    }

    public void setSex(Enums.sex sex) {
        this.sex = sex;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    public void addBook(Book book) {books.add(book);}

    public void setBooks(Collection<Book> books) {
        this.books = new ArrayList<>(books);
    }

    public java.util.Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(this.rewards);
    }

    public void setRewards(Collection<Reward> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public Author() {}

    public Author(String firstName, String lastName, Enums.sex sex, List<Book> books
        ,Date birthDate, List<Reward> rewards)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.sex=sex;
        this.books=books;
        this.birthDate=birthDate;
        this.rewards=rewards;
    }

    public Author(Integer id, String firstName, String lastName, Enums.sex sex, List<Book> books
            ,Date birthDate, List<Reward> rewards)
    {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.sex=sex;
        this.books=books;
        this.birthDate=birthDate;
        this.rewards=rewards;
    }
}