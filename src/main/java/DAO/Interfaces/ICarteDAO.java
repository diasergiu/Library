package DAO.Interfaces;

import Entityes.Carte;

import javax.persistence.EntityManager;
import java.util.List;

public interface ICarteDAO {
    Carte getCarteById(int id);

    void SaveCarte(Carte carte, EntityManager entitymanager);

    void updateCarte(Carte carteUpdatata);

    List<Carte> GetToateCartile();

    List<Carte> getCarteByTitlu(String titlu, int pageNumber);

    void DeleteCarte(int id);
}
