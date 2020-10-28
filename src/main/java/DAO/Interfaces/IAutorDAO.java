package DAO.Interfaces;

import Entityes.Autor;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public interface IAutorDAO {
    void SaveAutorii(Set<Autor> autoriCarti, EntityManager entitymanager);

    List<Autor> getAllAutori();

    void SaveAutor(Autor autor);

    void updateAutor(Autor autorUpdatata);

    void deleteAutor(int id);
}
