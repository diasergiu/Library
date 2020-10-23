package DAO;

import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CarteDTO {

    private EntityManagerUtil managerUtil;

    public CarteDTO(){
        this.managerUtil = new EntityManagerUtil();
    }

    public void SaveCarte(Carte carte, EntityManager entityManager) {
        entityManager.persist(carte);
    }


    public void updateCarte(Carte carteUpdatata) {
        EntityManager entitymanager = managerUtil.getEntityManager();
        entitymanager.getTransaction().begin();
        ;
    }

    public List<Carte> GetToateCartile() {
        EntityManager entityManager = managerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Carte> result = entityManager
                .createQuery("from Carte", Carte.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }
}
