package DAO;

import DAO.Interfaces.ICarteDAO;
import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
public class CarteDAO implements ICarteDAO {

    private static int PAGE_SIZE = 10;

    @Transactional
    public void SaveCarte(Carte carte, EntityManager entityManager) {
        Session session = (Session) entityManager.getDelegate();
        session.saveOrUpdate(carte);
    }

    public List<Carte> GetToateCartile() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Carte> result = entityManager
                .createQuery("from Carte", Carte.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public List<Carte> getCarteByTitlu(String titlu, int pageNumber) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        String hql = "select c FROM Entityes.Carte c where c.titlu like '%" + titlu + "%'";
        List<Carte> result = entityManager
                .createQuery(hql)
                .setFirstResult(PAGE_SIZE * ((pageNumber-1) +1 ))
                .setMaxResults(PAGE_SIZE)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public void updateCarte(Carte carteUpdatata) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Carte carte = entityManager.find(Carte.class, carteUpdatata.getIdCarte());
        carte.setAutori(carteUpdatata.getAutori());
        carte.setAnPublicatie(carteUpdatata.getAnPublicatie());
        carte.setEditura(carteUpdatata.getEditura());
        carte.setISBN(carteUpdatata.getISBN());
        carte.setTitlu(carteUpdatata.getTitlu());
        entityManager.persist(carte);
        entityManager.getTransaction().commit();
    }


    public void DeleteCarte(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Carte.class, id));
        entityManager.getTransaction().commit();
    }

    public Carte getCarteById(int id) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();
        Carte carte = manager.find(Carte.class, id);
        manager.getTransaction().commit();
        return carte;
    }


}
