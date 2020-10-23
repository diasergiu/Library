package Repository;

import DAO.AutorDTO;
import DAO.CarteDTO;
import DTO.CreateCarteDTO;
import Entityes.Autor;
import Entityes.Carte;
import com.tutorial.h2.librarie.Util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

public class CarteRepository {

    EntityManagerUtil _entityManagerUtil;
    CarteDTO _carteDTO;
    AutorDTO _autorDTO;


    public CarteRepository(){
        this._entityManagerUtil = new EntityManagerUtil();
        _carteDTO = new CarteDTO();
        _autorDTO = new AutorDTO();
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
        _carteDTO.SaveCarte(modelView.getCarte(), entitymanager);
        _autorDTO.SaveAutorii(modelView.getAutoriCarti(), entitymanager);
        int id = modelView.getCarte().getIdCarte();
        entitymanager.getTransaction().commit();
        return id;

    }


    public void updateCarte(Carte carteUpdatata) {
        _carteDTO.updateCarte(carteUpdatata);
    }

    public List<Carte> getToateCartile() {
        return _carteDTO.GetToateCartile();
    }
}
