package DTO;

import Entityes.Autor;
import Entityes.Carte;

import java.util.Set;

public class CreateCarteDTO {

    private Carte carte;
    private Set<Autor> autoriCarti;

    public Carte getCarte() {
        return carte;
    }

    public void setCarte(Carte carte) {
        this.carte = carte;
    }

    public Set<Autor> getAutoriCarti() {
        return autoriCarti;
    }

    public void setAutoriCarti(Set<Autor> autoriCarti) {
        this.autoriCarti = autoriCarti;
    }
}
