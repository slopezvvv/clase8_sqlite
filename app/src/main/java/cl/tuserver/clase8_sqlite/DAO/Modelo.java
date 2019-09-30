package cl.tuserver.clase8_sqlite.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Modelo extends SQLiteOpenHelper{
    private static final String DB_NAME = "test.db";
    private static final int VERSION = 1;
    private final String[] nombreTablas = new String[]{"USUARIOS", "PRODUCTOS"};
    private final String[] tablas;

    public Modelo(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        // Tablas
        tablas = new String[]{
            "CREATE TABLE USUARIOS(" +
                "RUT INTEGER NOT NULL," +
                "EMAIL VARCHAR(32) UNIQUE NOT NULL,"+
                "NOMBRE VARCHAR(64) NOT NULL," +
                "PRIMARY KEY(RUT)" +
            ")",
            "CREATE TABLE PRODUCTOS(" +
                "ID INTEGER NOT NULL," +
                "NOMBRE VARCHAR(32) NOT NULL," +
                "PRIMARY KEY(ID)"+
            ")"
        };
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for(String s : tablas)
            db.execSQL(s);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        for(String s : nombreTablas)
            db.execSQL("DROP TABLE IF EXISTS "+s);
        onCreate(db);
    }
}
