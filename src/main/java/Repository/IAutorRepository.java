package Repository;


import Entityes.Autor;

import java.util.List;

public interface IAutorRepository {
    List<Autor> getAllAutors();

    void saveNewAutor(Autor autor);

    void updateAutor(Autor autorUpdatata);

    void deleteAutor(int id);
}
