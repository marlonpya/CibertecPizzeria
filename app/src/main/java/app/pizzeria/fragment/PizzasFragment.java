package app.pizzeria.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import app.pizzeria.DetalleCompraActivity;
import app.pizzeria.PrincipalActivity;
import app.pizzeria.R;
import app.pizzeria.adapter.AdapterCarta;
import app.pizzeria.modelo.Carta;
import app.pizzeria.sqlite.QuerysSQL;
import app.pizzeria.util.Constantes;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzasFragment extends Fragment {
    public static final String TAG = PizzasFragment.class.getSimpleName();
    private AdapterCarta adapter;
    private ArrayList<Carta> lista_cartas;
    private GridView listView;

    private QuerysSQL sql;

    public PizzasFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pizzas, container, false);
        listView = (GridView) view.findViewById(R.id.lvPizzas);

        sql = new QuerysSQL(getActivity());

        if (!sql.validarPrueba()) cargarDatos();

        lista_cartas = sql.getCarta(PrincipalActivity.ID);

        adapter = new AdapterCarta(lista_cartas, getActivity());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity().getApplicationContext(), DetalleCompraActivity.class)
                .putExtra(Constantes.KEY_ID_CARTA, lista_cartas.get(i).getId_carta()));
            }
        });

        Log.d(TAG, String.valueOf(PrincipalActivity.ID));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        lista_cartas = sql.getCarta(PrincipalActivity.ID);

        adapter = new AdapterCarta(lista_cartas, getActivity());
        listView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        lista_cartas = sql.getCarta(PrincipalActivity.ID);

        adapter = new AdapterCarta(lista_cartas, getActivity());
        listView.setAdapter(adapter);
    }

    private void cargarDatos() {
        sql.registrarCarta(new Carta(Carta.PIZZA, "Pizza Americana", R.drawable.pizza_americana, 44.00, 51.00, 66.00, "Ingredientes: Queso Mozarela, Jamón, Salsa, Pomarola"));
        sql.registrarCarta(new Carta(Carta.PIZZA, "Pizza Barbacoa", R.drawable.pizza_barbacoa, 44.00, 54.00, 63.00, "Ingredientes: Queso Mozarela, Cabanossi, Chorizo"));
        sql.registrarCarta(new Carta(Carta.PIZZA, "Pizza Carne", R.drawable.pizza_carne, 42.00, 51.00, 67.00, "Ingredientes: Queso Mozarela, Tocino, Champignones"));
        sql.registrarCarta(new Carta(Carta.PIZZA, "Pizza Margarita", R.drawable.pizza_margarita, 42.00, 53.00, 70.00, "Ingredientes: Queso Mozarela, Jamón, Chancho, Salsa"));
        sql.registrarCarta(new Carta(Carta.PIZZA, "Pizza Pecado Carnal", R.drawable.pizza_pecado_carnal, 47.00, 60.00, 68.00, "Cebolla, Oregano, Pimiento"));

        sql.registrarCarta(new Carta(Carta.PASTAS, "Pasta Derwent Park", R.drawable.pasta_derwent_park, 60.00, 70.00, 90.00, "Ingredientes: Salsa Bolognesa\n" + "Exquisita Salsa de Carne"));
        sql.registrarCarta(new Carta(Carta.PASTAS, "Pasta Etuvisu", R.drawable.pasta_etusivu, 100.00, 120.00, 144.00, "Ingredientes: Salsa Alfredo \n" + "Exquisita Salsa Blanca, Crema de Leche"));
        sql.registrarCarta(new Carta(Carta.PASTAS, "Pasta Melina Catering", R.drawable.pasta_melina_catering, 80.00, 90.00, 110.00, "Ingredientes: Salsa Rossini\n" + "Exquisita Combinación, Salsa Bolognesa con la Salsa Alfredo"));
        sql.registrarCarta(new Carta(Carta.PASTAS, "Pasta Mozz Basil", R.drawable.pasta_mozz_basil, 60.00, 77.00, 90.00, "Ingredientes: Salsa Pesto\n" + "Exquisita Salsa Verde de Albahaca"));
        sql.registrarCarta(new Carta(Carta.PASTAS, "Pasta Pastavilla", R.drawable.pasta_pastavilla, 42.00, 56.00, 77.00, "Ingredientes: FETUCCINI\n" + "Salsa Bolognesa\n" + "Exquisita Salsa de Carne"));

        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Agua Cielo", R.drawable.bebida_cielo, 5.00, 50.00, 60.00, "Cielo Personal"));
        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Coca Cola Zero", R.drawable.bebida_coca_cola_zero, 7.00, 50.00, 60.00, "Coca Cola Zero Personal"));
        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Fanta Personal", R.drawable.bebida_fanta, 7.00, 50.00, 60.00, "Fanta Pequeña Personal"));
        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Fanta Kola Inglesa", R.drawable.bebida_fanta_kola_inglesa, 8.00, 50.00, 60.00, "Kola Inglesa Personal"));
        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Inca Kola Personal", R.drawable.bebida_inca_kola_zero, 8.00, 50.00, 60.00, "Inca Kola Normal Personal"));
        sql.registrarCarta(new Carta(Carta.BEBIDAS, "Oro Personal", R.drawable.bebida_oro, 6.00, 50.00, 60.00, "Bebida Oro Normal Personal"));

        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo de Pizza y Compañía", R.drawable.oferta_combo, 6.00, 50.00, 60.00, "Contiene pizza grande y companía"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo Pizza de Amor", R.drawable.oferta_corazon, 6.00, 50.00, 60.00, "Contiene pizza grande de amor"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo Grande Dos x Uno", R.drawable.oferta_dos_x_uno, 6.00, 50.00, 60.00, "Contiene 2 pizzas grandes"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Oferta especial Metro", R.drawable.oferta_metro, 6.00, 50.00, 60.00, "Contiene pizza grande más "));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Oferta Pizza Dolce", R.drawable.oferta_pizza_dolce, 6.00, 50.00, 60.00, "Contiene pizza grande dolce"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo Gran Tavolo 1", R.drawable.oferta_tavolo_1, 6.00, 50.00, 60.00, "Contiene pizza grande de tavolo 1"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo Gran Tavolo 2", R.drawable.oferta_tavolo_2, 6.00, 50.00, 60.00, "Contiene pizza grande de tavolo 2"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Combo Gran Tavolo 3", R.drawable.oferta_tavolo_3, 6.00, 50.00, 60.00, "Contiene pizza grande de tavolo 3"));
        sql.registrarCarta(new Carta(Carta.OFERTAS, "Oferta Grande Tres x Uno", R.drawable.oferta_tres_x_uno, 6.00, 50.00, 60.00, "Contiene 3 pizzas grandes"));
    }

}
