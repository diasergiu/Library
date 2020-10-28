package com.tutorial.h2.librarie.Configurations;

import DAO.*;
import DAO.Interfaces.*;
import Repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigurations {

    @Bean
    public ICarteRepository carteRepository(){
        return new CarteRepository();
    }

    @Bean
    public IAutorRepository autorRepository(){
        return new AutorRepository();
    }

    @Bean
    public IEdituraRepository edituraRepository(){
        return new EdituraRepository();
    }

    @Bean
    public ICarteDAO carteDAO(){
        return new CarteDAO();
    }

    @Bean
    public IAutorDAO autorDAO(){
        return new AutorDAO();
    }

    @Bean
    public IEdituraDAO edituraDAO(){
        return new EdituraDAO();
    }
}
