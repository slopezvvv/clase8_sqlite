package cl.tuserver.clase8_sqlite.DAO;

import java.util.ArrayList;

import cl.tuserver.clase8_sqlite.DTO.Usuario;

public interface DBUsuarioInterfaz {
    boolean insertar(Usuario usuario);

    Usuario obtener(int rut);
    Usuario obtener(String email);
    ArrayList<Usuario> obtener();

    void actualizar(Usuario usuario);
    void eliminar(int rut);
}
