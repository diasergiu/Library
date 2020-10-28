package Repository;

import DTO.CreateCarteDTO;
import Entityes.Carte;

import java.util.List;

public interface ICarteRepository {
    List<Carte> getToateCartile();

    Carte getCarteDupaId(int id);

    void SaveCarteNowaSiAutory(CreateCarteDTO modelView);

    List<Carte> getCarteByTitlu(String titlu, int pageNumber);

    void updateCarte(Carte carteUpdatata);

    void deleteCarte(int id);
}
