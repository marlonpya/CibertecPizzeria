package app.pizzeria.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import app.pizzeria.modelo.Usuario;

/**
 * Created by marlonpya on 4/12/16.
 */

public class UsuarioAdapter extends BaseAdapter {
    private ArrayList<Usuario> lista_usuario;
    private LayoutInflater inflater;

    public UsuarioAdapter(ArrayList<Usuario> lista_usuario, Context context) {
        this.lista_usuario = lista_usuario;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista_usuario.size();
    }

    @Override
    public Object getItem(int posicion) {
        return lista_usuario.get(posicion);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
