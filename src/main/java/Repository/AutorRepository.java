package Repository;
import Entityes.Autor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.LinkedList;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class AutorRepository {

    // Method Used To Create The Hibernate's SessionFactory Object
    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        SessionFactory factoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return factoryObj;
    }

    @SuppressWarnings("unchecked")
    public static List getAllAutors() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guide-to-jpa-with-hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Autor> result = entityManager
                .createQuery("from Autor", Autor.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return result;
    }

    public void saveNewAutor(Autor autor) {

        EntityManager manager = getEntityManager();
        manager.getTransaction().begin();

        manager.persist(autor);
        manager.getTransaction().commit();
    }

    private EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("guide-to-jpa-with-hibernate");
        return entityManagerFactory.createEntityManager();
    }
}
