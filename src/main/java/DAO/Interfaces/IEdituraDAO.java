package DAO.Interfaces;

import Entityes.Editura;

import java.util.List;

public interface IEdituraDAO {
    List<Editura> getAllEditura();

    Editura getEdituraById(int id);

    void saveEditura(Editura editura);

    void updateEditura(Editura edituraUpdate);

    void deleteEditura(int id);
}
