package app.pizzeria.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.pizzeria.R;
import app.pizzeria.modelo.Carta;

/**
 * Created by marlonpya on 25/11/16.
 */

public class AdapterCarta extends BaseAdapter {
    private ArrayList<Carta> lista_cartas;
    private Context context;
    private LayoutInflater inflater;

    public AdapterCarta(ArrayList<Carta> lista_cartas, Context context) {
        this.lista_cartas = lista_cartas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista_cartas == null ? 0 : lista_cartas.size();
    }

    @Override
    public Object getItem(int i) {
        return lista_cartas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista_cartas.get(i).getId_carta();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.item_carta, viewGroup, false);

        TextView tvNombre = (TextView) view.findViewById(R.id.item_tvNombreCarta);
        ImageView ivCarta = (ImageView) view.findViewById(R.id.item_ivImagenCarta);

        tvNombre.setText(lista_cartas.get(i).getNombre_carta());
        ivCarta.setImageResource(lista_cartas.get(i).getImagen_carta());

        return view;
    }

}
