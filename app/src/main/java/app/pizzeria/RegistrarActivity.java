package app.pizzeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import app.pizzeria.modelo.Usuario;
import app.pizzeria.sqlite.ManagerOpenHelper;
import app.pizzeria.sqlite.QuerysSQL;
import app.pizzeria.util.Constantes;
import app.pizzeria.util.Utils;

public class RegistrarActivity extends AppCompatActivity {
    public static final String TAG = RegistrarActivity.class.getSimpleName();
    private Spinner spDia, spMes, spAnio;
    private Button btnRegistrar;
    private Toolbar toolbar;
    private EditText etUsuario, etContrasenia;
    private RadioButton rbHombre, rbMujer;
    private QuerysSQL sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        sql = new QuerysSQL(RegistrarActivity.this);

        spDia = (Spinner) findViewById(R.id.spDia);
        spMes = (Spinner) findViewById(R.id.spMes);
        spAnio = (Spinner) findViewById(R.id.spAnio);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_registrar);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasenia = (EditText) findViewById(R.id.etContrasenia);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);

        Utils.setSpinner(this, spDia, Constantes.array_dias);
        Utils.setSpinner(this, spMes, Constantes.array_mes);
        Utils.setSpinner(this, spAnio, Constantes.array_anios);
        Utils.setToolbar(toolbar, RegistrarActivity.this, "Registrar Usuario");
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "hombre_chh" + String.valueOf(rbHombre.isChecked()));
                Log.d(TAG, "mujer_chh" + String.valueOf(rbMujer.isChecked()));
                String strusuario = etUsuario.getText().toString().trim();
                String strcontrasenia = etContrasenia.getText().toString().trim();

                if (!strusuario.isEmpty() || !strcontrasenia.isEmpty()) {
                    if (rbHombre.isChecked() || rbMujer.isChecked()) {
                        String genero = rbHombre.isChecked() ? rbHombre.getText().toString() : rbMujer.getText().toString();
                        Usuario usuario = new Usuario(strusuario, strcontrasenia, spDia.getSelectedItem().toString(), spMes.getSelectedItem().toString(), spAnio.getSelectedItem().toString(), genero);
                        sql.registrarUsuario(usuario);

                        Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(RegistrarActivity.this, IniciarSesionActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegistrarActivity.this, "Debe escoger un género", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistrarActivity.this, "Se requiere de usuario ó contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
