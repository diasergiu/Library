package DAO;

import Entityes.Autor;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class AutorDTO {

    private EntityManagerUtil managerUtil;

    public AutorDTO(){
        this.managerUtil = new EntityManagerUtil();
    }

    public void SaveAutorii(Set<Autor> autoriCarti, EntityManager entityManager) {
        for(Autor a : autoriCarti){
            entityManager.persist(a);
        }
    }
}
