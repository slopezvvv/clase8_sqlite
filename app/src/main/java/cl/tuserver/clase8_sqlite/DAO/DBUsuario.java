package cl.tuserver.clase8_sqlite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import cl.tuserver.clase8_sqlite.DTO.Usuario;

public class DBUsuario extends Modelo implements DBUsuarioInterfaz {
    public DBUsuario(@Nullable Context context) {
        super(context);
    }

    @Override
    public boolean insertar(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            if(obtener(usuario.getRut()) == null ||
               obtener(usuario.getEmail()) == null) {
                    ContentValues valores = new ContentValues();
                    valores.put("RUT", usuario.getRut());
                    valores.put("EMAIL", usuario.getEmail());
                    valores.put("NOMBRE", usuario.getNombre());
                    db.insert("USUARIOS", null, valores);
                    return true;
            }
        } finally {
            db.close();
        }
        return false;
    }

    @Override
    public Usuario obtener(int rut) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE RUT = ?", new String[]{String.valueOf(rut)});
        try {
            if (cursor.moveToFirst()) {
                String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE")),
                        email = cursor.getString(cursor.getColumnIndex("EMAIL"));
                Usuario usuario = new Usuario(rut, nombre);
                usuario.setEmail(email);
                return usuario;
            }
        }
        finally {
            db.close();
            cursor.close();
        }
        return null;
    }

    @Override
    public Usuario obtener(String email) {
        return null;
    }

    @Override
    public ArrayList<Usuario> obtener() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS", null);
        try {
            while (cursor.moveToNext()) {
                int rut = cursor.getInt(cursor.getColumnIndex("RUT"));
                String nombre = cursor.getString(cursor.getColumnIndex("NOMBRE"));
                String email = cursor.getString(cursor.getColumnIndex("EMAIL"));
                Usuario usuario = new Usuario(rut, nombre);
                usuario.setEmail(email);
                usuarios.add(usuario);
            }
        }
        finally {
            db.close();
            cursor.close();
        }
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        //TAREA 2
    }

    @Override
    public void eliminar(int rut) {
        // TAREA 3
    }
}
