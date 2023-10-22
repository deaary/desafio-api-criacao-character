package com.example.desafioapicriacaocharacter.domain.repository;

import com.example.desafioapicriacaocharacter.domain.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
}
