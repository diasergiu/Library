package DAO;

import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;
public class CarteDAO {

    private static int PAGE_SIZE = 10;

    public void SaveCarte(Carte carte, EntityManager entityManager) {
        entityManager.persist(carte);
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

    // if data is big enough this swould be more efficient
//    public List<Carte> getCarteByTitlu(String titlu, int pageNumber) {
//        Session session = EntityManagerUtil.getSessionFactory().openSession();
//        String hql = "SELECT c FROM FT_SEARCH('"+ titlu + "', 0, 0)";
//
//        Query query = session.createQuery(hql, Carte.class)
//                .setFirstResult(PAGE_SIZE * ((pageNumber-1) +1 ))
//                .setMaxResults(PAGE_SIZE);
//        return query.getResultList();
//    }

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
        carte.setAutorNavigator(carteUpdatata.getAutorNavigator());
        carte.setAnPublicatie(carteUpdatata.getAnPublicatie());
        carte.setEdituraNavigator(carteUpdatata.getEdituraNavigator());
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
