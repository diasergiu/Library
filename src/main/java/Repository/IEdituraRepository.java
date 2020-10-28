package Repository;

import Entityes.Editura;

import java.util.List;

public interface IEdituraRepository {
    List<Editura> getAlleditura();

    Editura getEdituraById(int id);

    void saveNewEditura(Editura editura);

    void updateEditura(Editura edituraUpdatata);

    void deleteEditura(int id);
}
