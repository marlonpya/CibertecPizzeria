package app.pizzeria.util;

import java.util.ArrayList;

/**
 * Created by marlonpya on 26/11/16.
 */

public class Constantes {

    static public ArrayList<String> getArrayDias() {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            array.add(String.valueOf(i));
        }
        return array;
    }

    static public ArrayList<String> getArrayMeses() {
        ArrayList<String> array = new ArrayList<>();
        array.add("Enero");
        array.add("Febrero");
        array.add("Marzo");
        array.add("Abril");
        array.add("Mayo");
        array.add("Junio");
        array.add("Julio");
        array.add("Agosto");
        array.add("Septiembre");
        array.add("Octubre");
        array.add("Noviembre");
        array.add("Dicimenbre");
        return array;
    }

    static public ArrayList<String> getArrayAnios() {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 1990; i < 2017; i++) {
            array.add(String.valueOf(i));
        }
        return array;
    }

    public static final String KEY_ID_CARTA = "KEY_ID_CARTA";
}
