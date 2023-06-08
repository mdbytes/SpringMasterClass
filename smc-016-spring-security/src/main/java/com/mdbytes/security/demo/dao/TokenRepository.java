package com.mdbytes.security.demo.dao;

import com.mdbytes.security.demo.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value = """
            select t from Token t where t.user.id = :id
            """)
    List<Token> findAllValidTokenByUser(Integer id);


    Optional<Token> findByToken(String token);

}
