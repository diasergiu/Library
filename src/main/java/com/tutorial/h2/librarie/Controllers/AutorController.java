package com.tutorial.h2.librarie.Controllers;

import Entityes.Autor;
import Repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import Repository.AutorRepository;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AutorController {

    public AutorRepository _autorRepository;

    public AutorController(){
        _autorRepository = new AutorRepository();
    }

    @GetMapping(value = "/Autor")
    public ModelAndView HomeAutor(){
        return new ModelAndView("AutorView", "Autor", new Autor());
    }

    @GetMapping(value =  "/GetAllAutors")
    public List<Autor> getAllAutors() {
       return _autorRepository.getAllAutors();
    }

//    @RequestMapping(value = "/addAutor",  method = RequestMethod.POST)
//    public void createAutor(Autor autor){
//        System.out.println(autor);
//    }

    @PostMapping(value = "/Autor/CreateAutor",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAutor(@RequestBody Autor autor){
        _autorRepository.saveNewAutor(autor);
    }

    @PostMapping(value = "/Autor/UpdateAutor")
    public void updateAutor(@RequestBody Autor autorUpdatata){
        _autorRepository.updateAutor(autorUpdatata);
    }

    @DeleteMapping(value = "Autor/DeleteAutor")
    public void deleteAutor(int id){
        _autorRepository.deleteAutor(id);
    }

}
