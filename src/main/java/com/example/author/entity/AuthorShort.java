package com.example.author.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
            name="AuthorShortResult",
            classes={
                @ConstructorResult(
                        targetClass=com.example.author.entity.AuthorShort.class,
                        columns={
                                @ColumnResult(name="firstName", type=String.class),
                                @ColumnResult(name="lastName", type=String.class),
                                @ColumnResult(name="age", type=Integer.class)
                        })}),
        @SqlResultSetMapping(name = "AuthorBooksResult",
                columns = { @ColumnResult(name="books", type=List.class) })
        })
@NamedNativeQueries({

        @NamedNativeQuery(name = "AuthorShort",
        query = "SELECT firstName, lastName," +
                "DATEDIFF(CURRENT_DATE, STR_TO_DATE(birth_date, '%d-%m-%Y'))/365 AS age " +
                "FROM author WHERE id=?1",
        resultSetMapping = "AuthorShortResult"),

@NamedNativeQuery(name = "AuthorBooks",
        query = "SELECT b.title FROM book b, author_books a  WHERE  ab.book_id=b.id " +
                "AND a.author_books=?1",
        resultSetMapping = "AuthorBooksResult")})

public class AuthorShort {

    private String firstName;

    private String lastName;

    private Integer age;

    List<String> books = new ArrayList<>();

    public AuthorShort(String firstName, String lastName, Integer age)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public void setBooks(List<String> books)
    {
        this.books=books;
    }
}
