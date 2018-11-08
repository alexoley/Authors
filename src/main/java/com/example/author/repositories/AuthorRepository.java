package com.example.author.repositories;

import com.example.author.entity.AuthorShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.author.entity.Author;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    /*List<String> books (){
        Query query = em.createNamedQuery("AuthorBooks");
        List<String>;
    }*/

    @Query(value = "SELECT first_name, last_Name, DATEDIFF(CURRENT_DATE, STR_TO_DATE(birth_date, '%d-%m-%Y'))/365 AS age" +
            " FROM author", nativeQuery = true)
    List<AuthorShort> shortInfo();

}
