package com.tutorial.h2.librarie.Controllers;

import DTO.CreateCarteDTO;
import Entityes.Carte;
import Repository.CarteRepository;
import Repository.ICarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class CarteController {

    @Autowired
    private ICarteRepository _carteRepository;

    @GetMapping(value = "/Carte")
    public List<Carte> getAllCarti(){
        return _carteRepository.getToateCartile();
    }

    @GetMapping(value = "/Carte/CarteById")
    public Carte getCarteDupaId(int id) {
        return _carteRepository.getCarteDupaId(id);
    }

    @PostMapping(value = "/Carte/SaveCarte")
    public void saveCarti(@RequestBody CreateCarteDTO modelView){
        _carteRepository.SaveCarteNowaSiAutory(modelView);
    }

    @GetMapping(value = "/Carte/CartiByTitlu")
    public List<Carte> getCarteByTitlu(String titlu, int pageNumber){
        return _carteRepository.getCarteByTitlu(titlu, pageNumber);
    }

    @PostMapping(value = "/Carte/UpdateCarte")
    public void updateCarte(@RequestBody Carte carteUpdatata){
        _carteRepository.updateCarte(carteUpdatata);
    }

    @DeleteMapping(value = "Carte/DeleteCarte")
    public void deleteCarte(int id){
        _carteRepository.deleteCarte(id);
    }

}
