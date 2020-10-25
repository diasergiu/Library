package Repository;
import DAO.AutorDAO;
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

    private AutorDAO _autorDAO;

    public AutorRepository(){ this._autorDAO = new AutorDAO();}

    public List<Autor> getAllAutors() {
        return _autorDAO.getAllAutori();
    }

    public void saveNewAutor(Autor autor) {
        _autorDAO.SaveAutor(autor);
    }

    public void updateAutor(Autor autorUpdatata) {
        _autorDAO.updateAutor(autorUpdatata);
    }

    public void deleteAutor(int id) {
        _autorDAO.deleteAutor(id);
    }
}
