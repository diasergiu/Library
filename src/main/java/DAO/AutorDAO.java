package DAO;

import DAO.Interfaces.IAutorDAO;
import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class AutorDAO implements IAutorDAO {

    @Transactional
    public void SaveAutorii(Set<Autor> autoriCarti, EntityManager entityManager) {
        for(Autor a : autoriCarti){
            Session session = (Session) entityManager.getDelegate();
            session.saveOrUpdate(a);
        }
    }

    public List<Autor> getAllAutori(){
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        entityManager.getTransaction().begin();
        List<Autor> result = entityManager
                .createQuery("from Autor", Autor.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public void SaveAutor(Autor autor) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();

        manager.persist(autor);
        manager.getTransaction().commit();
    }

    public void updateAutor(Autor autorUpdatata) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Autor autor = entityManager.find(Autor.class, autorUpdatata.getIdAutor());
        autor.setCarteNavigator(autorUpdatata.getCarteNavigator());
        autor.setNume(autorUpdatata.getNume());
        autor.setPrenume(autorUpdatata.getPrenume());
        entityManager.persist(autor);
        entityManager.getTransaction().commit();
    }

    public void deleteAutor(int id) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Autor.class, id));
        entityManager.getTransaction().commit();
    }
}
