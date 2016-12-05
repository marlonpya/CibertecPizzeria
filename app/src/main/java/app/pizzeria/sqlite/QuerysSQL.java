package app.pizzeria.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import app.pizzeria.modelo.Carta;
import app.pizzeria.modelo.Usuario;
import app.pizzeria.util.Querys;

/**
 * Created by marlonpya on 1/12/16.
 */

public class QuerysSQL {
    public static final String TAG = QuerysSQL.class.getSimpleName();

    private ManagerOpenHelper helper;

    public QuerysSQL(Context context) {
        this.helper = new ManagerOpenHelper(context);
    }

    public void registrarUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Querys.USU_USUARIO, usuario.getUsuario());
        values.put(Querys.USU_CONTRASENIA, usuario.getContrasenia());
        values.put(Querys.USU_DIA, usuario.getDia());
        values.put(Querys.USU_MES, usuario.getMes());
        values.put(Querys.USU_ANIO, usuario.getAnio());
        values.put(Querys.USU_GENERO, usuario.getGenero());
        db.insert(Querys.TB_USUARIO, null, values);
        db.close();
        Log.d(TAG, "usuario registrado "+usuario.getUsuario());
    }

    public boolean validarIniciarSesion(String usuario, String contrasenia) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * " +
                                    " FROM "+Querys.TB_USUARIO+"" +
                                    " WHERE "
                                    +Querys.USU_USUARIO+ "= '"+usuario+"'" +
                                    " AND  " +
                                    Querys.USU_CONTRASENIA+ " = '"+contrasenia+"'", null);
        return cursor.moveToFirst();
    }

    public void registrarCarta(Carta carta) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Querys.CAR_TIPO, carta.getTipo_carta());
        values.put(Querys.CAR_NOMBRE, carta.getNombre_carta());
        values.put(Querys.CAR_IMAGEN, carta.getImagen_carta());
        values.put(Querys.CAR_PRE_GRANDE, carta.getPrecio_grande());
        values.put(Querys.CAR_PRE_FAMILIAR, carta.getPrecio_familiar());
        values.put(Querys.CAR_PRE_S_FAMILIAR, carta.getPrecio_super_familiar());
        db.insert(Querys.TB_CARTA, null, values);
        Log.d(TAG, "carta registrada "+carta.getNombre_carta());
    }

    public boolean validarPrueba() {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_CARTA", null);
        return cursor.moveToFirst();
    }

    public ArrayList<Carta> getCarta(int tipo) {
        ArrayList<Carta> list_carta = new ArrayList<>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+Querys.TB_CARTA+" WHERE CAR_TIPO ="+tipo, null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    do {
                        Carta carta = new Carta(cursor.getInt(cursor.getColumnIndex(Querys.CAR_ID)),
                                                cursor.getInt(cursor.getColumnIndex(Querys.CAR_TIPO)),
                                                cursor.getString(cursor.getColumnIndex(Querys.CAR_NOMBRE)),
                                                cursor.getInt(cursor.getColumnIndex(Querys.CAR_IMAGEN)),
                                                cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_GRANDE)),
                                                cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_FAMILIAR)),
                                                cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_S_FAMILIAR)),
                                                cursor.getString(cursor.getColumnIndex(Querys.CAR_INGREDIENTES)));
                        list_carta.add(carta);
                    } while (cursor.moveToNext());
                }
            }
        }
        return list_carta;
    }

    public Carta getCartaPorId(int id) {
        Carta carta = null;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(" SELECT * " +
                                    " FROM "+Querys.TB_CARTA +
                                    " WHERE "+Querys.CAR_ID +"="+id,null);
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                if (cursor.moveToFirst()) {
                    carta = new Carta(cursor.getInt(cursor.getColumnIndex(Querys.CAR_ID)),
                            cursor.getInt(cursor.getColumnIndex(Querys.CAR_TIPO)),
                            cursor.getString(cursor.getColumnIndex(Querys.CAR_NOMBRE)),
                            cursor.getInt(cursor.getColumnIndex(Querys.CAR_IMAGEN)),
                            cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_GRANDE)),
                            cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_FAMILIAR)),
                            cursor.getDouble(cursor.getColumnIndex(Querys.CAR_PRE_S_FAMILIAR)),
                            cursor.getString(cursor.getColumnIndex(Querys.CAR_INGREDIENTES)));
                }
            }
        }
        return carta;
    }
}
