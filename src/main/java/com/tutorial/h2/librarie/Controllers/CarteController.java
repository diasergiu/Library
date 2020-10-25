package com.tutorial.h2.librarie.Controllers;

import DTO.CreateCarteDTO;
import Entityes.Carte;
import Repository.CarteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class CarteController {

    private CarteRepository _carteRepository;

    public CarteController(){
        this._carteRepository = new CarteRepository();
    }


    @GetMapping(value = "/Carte")
    public List<Carte> getAllCarti(){
        return _carteRepository.getToateCartile();
    }

    @GetMapping(value = "/CarteById")
    public Carte getCarteDupaId(int id){
        return _carteRepository.getCarteDupaId(id);
    }

    @PostMapping(value = "/SaveCarte")
    public void saveCarti(@RequestBody CreateCarteDTO modelView){
        _carteRepository.SaveCarteNowaSiAutory(modelView);
    }

    @PostMapping(value = "/UpdateCarte")
    public void updateCarte(@RequestBody Carte carteUpdatata){
        _carteRepository.updateCarte(carteUpdatata);
    }

    @GetMapping(value = "/CartiByTitlu")
    public List<Carte> getCarteByTitlu(String titlu, int pageNumber){
        return _carteRepository.getCarteByTitlu(titlu, pageNumber);

    }

}
