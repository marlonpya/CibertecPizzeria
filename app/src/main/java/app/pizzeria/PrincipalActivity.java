package app.pizzeria;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.pizzeria.fragment.PizzasFragment;
import app.pizzeria.modelo.Carta;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    public static int ID = Carta.PIZZA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        toolbar = (Toolbar) findViewById(R.id.toolbar_principal);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, new PizzasFragment()).commit();
        getSupportActionBar().setTitle("Pizzas");
        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = new PizzasFragment();
        boolean cambiar = false;

        int id = item.getItemId();

        if (id == R.id.item_pizzas) {
            ID = Carta.PIZZA;
            cambiar = true;
        } else if (id == R.id.item_pastas) {
            ID = Carta.PASTAS;
            cambiar = true;
        } else if (id == R.id.item_bebidas) {
            ID = Carta.BEBIDAS;
            cambiar = true;
        } else if (id == R.id.item_ofertas) {
            ID = Carta.OFERTAS;
            cambiar = true;
        } else if (id == R.id.item_contacto) {
            contacto();
        } else if (id == R.id.item_cerrar_sesion) {
            cerrarSesion();
        }
        if (cambiar) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void contacto() {
        new AlertDialog.Builder(PrincipalActivity.this)
                .setTitle(R.string.app_name)
                .setMessage("993-222-019 Atención\n" +
                        "Señorita Karina")
                .show();
    }

    private void cerrarSesion() {
        new AlertDialog.Builder(PrincipalActivity.this)
                .setTitle(R.string.app_name)
                .setMessage("Está seguro de cerrar sesión ?")
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PrincipalActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("CANCELAR", null)
                .show();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            cerrarSesion();
        }
    }

}
