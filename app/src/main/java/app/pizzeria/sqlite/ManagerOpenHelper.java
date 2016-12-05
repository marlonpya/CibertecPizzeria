package app.pizzeria.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.pizzeria.util.Querys;

/**
 * Created by marlonpya on 1/12/16.
 */

public class ManagerOpenHelper extends SQLiteOpenHelper{

    public ManagerOpenHelper(Context context) {
        super(context, Querys.DB_NOMBRE, null, Querys.DB_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Querys.CREATE_TB_USUARIO);
        db.execSQL(Querys.CREATE_TB_CARTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
