package DAO;

import Entityes.Editura;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class EdituraDAO {
    public List<Editura> getAllEditura() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Editura> result = entityManager
                .createQuery("from Editura", Editura.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public Editura getEdituraById(int id) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();
        Editura editura = manager.find(Editura.class, id);
        manager.getTransaction().commit();
        return editura;
    }

    public void saveEditura(Editura editura) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();
        manager.persist(editura);
        manager.getTransaction().commit();
    }

    public void updateEditura(Editura edituraUpdate) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Editura autor = entityManager.find(Editura.class, edituraUpdate.getIdEditura());
        autor.setDenumireEditura(edituraUpdate.getDenumireEditura());
        entityManager.persist(autor);
        entityManager.getTransaction().commit();
    }

    public void deleteEditura(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Editura.class, id));
        entityManager.getTransaction().commit();
    }
}
