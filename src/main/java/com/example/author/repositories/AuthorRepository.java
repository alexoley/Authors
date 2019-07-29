package com.example.author.repositories;

import com.example.author.entity.AuthorShort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.author.entity.Author;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<AuthorShort> findShortById(Integer id);
}
