package com.example.desafioapicriacaocharacter.service;

import com.example.desafioapicriacaocharacter.domain.model.Character;

import java.util.List;

public interface CharacterService {

    Character findById(Long id);

    List<Character> findAll();

    Character create(Character characterToCreate);

    void updateCharacter(Long id, Character character);

    void deleteCharacter(Long id);
}
