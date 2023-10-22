package com.example.desafioapicriacaocharacter.service.impl;

import com.example.desafioapicriacaocharacter.domain.model.Character;
import com.example.desafioapicriacaocharacter.domain.repository.CharacterRepository;
import com.example.desafioapicriacaocharacter.service.CharacterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Long id) {
        return characterRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public  Character create(Character characterToCreate) {
        return characterRepository.save(characterToCreate);
    }

    @Override
    public void updateCharacter(Long id, Character character) {
        Optional<Character> characterBd = characterRepository.findById(id);
        if (characterBd.isPresent()) {
            characterRepository.save(character);
        }
    }

    @Override
    public void deleteCharacter(Long id) {
        characterRepository.deleteById(id);
    }
}