package DAO;

import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class AutorDAO {


    public void SaveAutorii(Set<Autor> autoriCarti, EntityManager entityManager) {
        for(Autor a : autoriCarti){
            entityManager.persist(a);
        }
    }

    public List<Autor> getAllAutori(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guide-to-jpa-with-hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Autor> result = entityManager
                .createQuery("from Autor", Autor.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }
}
