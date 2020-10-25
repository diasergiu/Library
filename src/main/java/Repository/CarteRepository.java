package Repository;

import DAO.AutorDAO;
import DAO.CarteDAO;
import DTO.CreateCarteDTO;
import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class CarteRepository {

    EntityManagerUtil _entityManagerUtil;
    CarteDAO _carteDAO;
    AutorDAO _autorDAO;


    public CarteRepository(){
        this._entityManagerUtil = new EntityManagerUtil();
        _carteDAO = new CarteDAO();
        _autorDAO = new AutorDAO();
    }

    public Carte getCarteDupaId(int id) {
        EntityManager manager = _entityManagerUtil.getEntityManager();
        manager.getTransaction().begin();
        Carte carte = manager.find(Carte.class, id);
        manager.getTransaction().commit();
        return carte;
    }

    public int SaveCarteNowaSiAutory(CreateCarteDTO modelView) {
        modelView.getCarte().setAutorNavigator(modelView.getAutoriCarti());
        for(Autor a : modelView.getAutoriCarti()){
            a.getCarteNavigator().add(modelView.getCarte());
        }
        EntityManager entitymanager = _entityManagerUtil.getEntityManager();
        entitymanager.getTransaction().begin();
        _carteDAO.SaveCarte(modelView.getCarte(), entitymanager);
        _autorDAO.SaveAutorii(modelView.getAutoriCarti(), entitymanager);
        int id = modelView.getCarte().getIdCarte();
        entitymanager.getTransaction().commit();
        return id;

    }


    public void updateCarte(Carte carteUpdatata) {
        _carteDAO.updateCarte(carteUpdatata);
    }

    public List<Carte> getToateCartile() {
        return _carteDAO.GetToateCartile();
    }

    public List<Carte> getCarteByTitlu(String titlu, int pageNumber) {
        return _carteDAO.getCarteByTitlu(titlu, pageNumber);
    }
}
