package com.example.author.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.author.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
