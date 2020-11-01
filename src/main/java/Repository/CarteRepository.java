package Repository;

import DAO.Interfaces.IAutorDAO;
import DAO.Interfaces.ICarteDAO;
import DTO.CreateCarteDTO;
import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class CarteRepository implements ICarteRepository  {

    @Autowired
    private ICarteDAO _carteDAO;
    @Autowired
    private IAutorDAO _autorDAO;

    public Carte getCarteDupaId(int id) {
       return _carteDAO.getCarteById(id);
    }

    public void SaveCarteNowaSiAutory(CreateCarteDTO modelView) {

        modelView.getCarte().setAutori(modelView.getAutoriCarti());
        for(Autor a : modelView.getAutoriCarti()){
            a.getCarteNavigator().add(modelView.getCarte());
        }
        EntityManager entitymanager = EntityManagerUtil.getEntityManager();
        entitymanager.getTransaction().begin();
        _carteDAO.SaveCarte(modelView.getCarte(), entitymanager);
        _autorDAO.SaveAutorii(modelView.getAutoriCarti(), entitymanager);
        entitymanager.getTransaction().commit();
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

    @Override
    public void saveCarte(Carte carte) {
        EntityManager manager = EntityManagerUtil.getEntityManager();
        manager.getTransaction().begin();


        for (Autor a : carte.getAutori()) {
            a.getCarteNavigator().add(carte);
        }
        _autorDAO.SaveAutorii(carte.getAutori(), manager);
        _carteDAO.SaveCarte(carte, manager);
        manager.getTransaction().commit();
    }
}
