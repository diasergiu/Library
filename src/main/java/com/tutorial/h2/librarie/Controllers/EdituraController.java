package com.tutorial.h2.librarie.Controllers;

import Entityes.Autor;
import Entityes.Editura;
import Repository.EdituraRepository;
import Repository.IEdituraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EdituraController {

    @Autowired
    private IEdituraRepository _edituraRepository;

    @GetMapping(value = "/Editura")
    public List<Editura> getAllEditura(){
        return _edituraRepository.getAlleditura();
    }

    @GetMapping(value = "/Editura/GetById")
    public Editura getEdituraById(int id){
        return _edituraRepository.getEdituraById(id);
    }

    @PostMapping(value = "/Editura/CreateEditura",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createEditura(@RequestBody Editura editura){
        _edituraRepository.saveNewEditura(editura);
    }

    @PostMapping(value = "/Editura/UpdateEditura")
    public void updateEditura(@RequestBody Editura edituraUpdatata){
        _edituraRepository.updateEditura(edituraUpdatata);
    }

    @DeleteMapping(value = "/Editura/DeleteEditura")
    public void deleteEditura(int id){
        _edituraRepository.deleteEditura(id);
    }
}
