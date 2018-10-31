package com.example.author.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.author.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
