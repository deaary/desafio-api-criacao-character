package com.example.desafioapicriacaocharacter.controller;

import com.example.desafioapicriacaocharacter.domain.model.Character;
import com.example.desafioapicriacaocharacter.service.CharacterService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> findById(@PathVariable Long id) {
        var character = characterService.findById(id);
        return ResponseEntity.ok(character);
    }

    @GetMapping
    public ResponseEntity<List<Character>> findAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @PostMapping
    public ResponseEntity<Character> create(@RequestBody Character characterToCreate) {
        var characterCreated = characterService.create(characterToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(characterCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(characterCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        character.setId(id);
        characterService.updateCharacter(id, character);
        return ResponseEntity.ok(character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.ok().build();
    }
}
