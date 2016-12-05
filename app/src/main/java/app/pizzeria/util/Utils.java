package app.pizzeria.util;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by marlonpya on 24/11/16.
 */

public class Utils {

    public static void setToolbar(Toolbar toolbar, AppCompatActivity activity, String titulo){
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
        activity.getSupportActionBar().setTitle(titulo);
    }

    public static void setSpinner(Context context, Spinner spinner, ArrayList<String> array) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, array);
        spinner.setAdapter(adapter);
    }

}
