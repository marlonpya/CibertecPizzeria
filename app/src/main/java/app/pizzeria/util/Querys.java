package app.pizzeria.util;

/**
 * Created by marlonpya on 1/12/16.
 */

public class Querys {

    public static final String DB_NOMBRE  = "db.pizzeria";
    public static final int DB_VERSION = 1;

    public static final String TB_USUARIO       = "TB_USUARIO";
    public static final String USU_ID           = "USU_ID";
    public static final String USU_USUARIO      = "USU_USUARIO";
    public static final String USU_CONTRASENIA  = "USU_CONTRASENIA";
    public static final String USU_DIA          = "USU_DIA";
    public static final String USU_MES          = "USU_MES";
    public static final String USU_ANIO         = "USU_ANIO";
    public static final String USU_GENERO       = "USU_GENERO";

    public static final String CREATE_TB_USUARIO= "CREATE TABLE IF NOT EXISTS " +TB_USUARIO+ "(" +
            USU_ID + " INTEGER," +
            USU_USUARIO + " TEXT NOT NULL," +
            USU_CONTRASENIA + " TEXT NOT NULL," +
            USU_DIA + " TEXT," +
            USU_MES + " TEXT," +
            USU_ANIO + " TEXT," +
            USU_GENERO + " TEXT," +
            "PRIMARY KEY (" + USU_ID + "));";

    public static final String TB_CARTA         = "TB_CARTA";
    public static final String CAR_ID           = "CAR_ID";
    public static final String CAR_TIPO         = "CAR_TIPO";
    public static final String CAR_NOMBRE       = "CAR_NOMBRE";
    public static final String CAR_IMAGEN       = "CAR_IMAGEN";
    public static final String CAR_PRE_GRANDE   = "CAR_PRE_GRANDE";
    public static final String CAR_PRE_FAMILIAR = "CAR_PRE_FAMILIAR";
    public static final String CAR_PRE_S_FAMILIAR = "CAR_PRE_S_FAMILIAR";
    public static final String CAR_INGREDIENTES = "CAR_INGREDIENTES";
    public static final String CREATE_TB_CARTA  = "CREATE TABLE IF NOT EXISTS " + TB_CARTA + "(" +
            CAR_ID + " INTEGER," +
            CAR_TIPO + " INTEGER NOT NULL," +
            CAR_NOMBRE + " TEXT," +
            CAR_IMAGEN + " INTEGER," +
            CAR_PRE_GRANDE + " DECIMAL," +
            CAR_PRE_FAMILIAR + " DECIMAL," +
            CAR_PRE_S_FAMILIAR + " DECIMAL," +
            CAR_INGREDIENTES + " TEXT," +
            "PRIMARY KEY (" + CAR_ID + "));";

}
