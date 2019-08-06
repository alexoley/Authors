package com.example.library.repositories;

import com.example.library.entity.AuthorShort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.entity.Author;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<AuthorShort> findShortById(Integer id);



}
