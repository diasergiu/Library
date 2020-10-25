package com.tutorial.h2.librarie.Controllers;

import Entityes.Autor;
import Entityes.Editura;
import Repository.EdituraRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EditorController {

    private EdituraRepository _edituraRepository;

    public EditorController(){ _edituraRepository = new EdituraRepository();}
    @GetMapping(value = "/Editura")
    public List<Editura> getAllEditura(){
        return _edituraRepository.getAlleditura();
    }

    @GetMapping(value = "/Editura/getById")
    public Editura getEdituraById(int id){
        return _edituraRepository.getEdituraById(id);
    }

    @PostMapping(value = "/Editor/createEditor",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEditor(@RequestBody Editura editura){
        _edituraRepository.saveNewEditura(editura);
    }

    @PostMapping(value = "/Editor/UpdateEditor")
    public void updateEditor(@RequestBody Editura editorUpdatata){
        _edituraRepository.updateEditor(editorUpdatata);
    }

    @DeleteMapping(value = "Editor/DeleteEditor")
    public void deleteEditor(int id){
        _edituraRepository.deleteEditura(id);
    }
}
