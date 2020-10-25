package Repository;

import DAO.EdituraDAO;
import Entityes.Editura;

import java.util.List;

public class EdituraRepository {

    private EdituraDAO _edituraDAO;

    public EdituraRepository(){this._edituraDAO = new EdituraDAO();}

    public List<Editura> getAlleditura() {
        return _edituraDAO.getAllEditura();
    }

    public Editura getEdituraById(int id) {
        return _edituraDAO.getEdituraById(id);
    }

    public void saveNewEditura(Editura editura) {
        _edituraDAO.saveEditura(editura);
    }

    public void updateEditor(Editura edituraUpdate) {
        _edituraDAO.updateEditura(edituraUpdate);
    }

    public void deleteEditura(int id) {
        _edituraDAO.deleteEditura(id);
    }
}
