package Repository;

import DAO.EdituraDAO;
import DAO.Interfaces.IEdituraDAO;
import Entityes.Editura;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EdituraRepository implements IEdituraRepository {

    @Autowired
    private IEdituraDAO _edituraDAO;

    public List<Editura> getAlleditura() {
        return _edituraDAO.getAllEditura();
    }

    public Editura getEdituraById(int id) {
        return _edituraDAO.getEdituraById(id);
    }

    public void saveNewEditura(Editura editura) {
        _edituraDAO.saveEditura(editura);
    }

    public void updateEditura(Editura edituraUpdate) {
        _edituraDAO.updateEditura(edituraUpdate);
    }

    public void deleteEditura(int id) {
        _edituraDAO.deleteEditura(id);
    }
}
