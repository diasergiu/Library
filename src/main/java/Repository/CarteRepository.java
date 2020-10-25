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

    CarteDAO _carteDAO;
    AutorDAO _autorDAO;


    public CarteRepository(){
        _carteDAO = new CarteDAO();
        _autorDAO = new AutorDAO();
    }

    public Carte getCarteDupaId(int id) {
       return _carteDAO.getCarteById(id);
    }

    public int SaveCarteNowaSiAutory(CreateCarteDTO modelView) {
        modelView.getCarte().setAutorNavigator(modelView.getAutoriCarti());
        for(Autor a : modelView.getAutoriCarti()){
            a.getCarteNavigator().add(modelView.getCarte());
        }
        EntityManager entitymanager = EntityManagerUtil.getEntityManager();
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

    public void deleteCarte(int id) {
        _carteDAO.DeleteCarte(id);
    }
}
