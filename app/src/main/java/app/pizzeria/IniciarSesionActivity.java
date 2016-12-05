package app.pizzeria;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.pizzeria.sqlite.QuerysSQL;

public class IniciarSesionActivity extends AppCompatActivity {
    private Button btnIngresar, btnIrARegistro;
    private EditText etUsuario, etContrasenia;
    private TextView tvOlvidasteContrasenia;
    private Toolbar toolbar;

    private QuerysSQL sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        sql = new QuerysSQL(getApplicationContext());

        tvOlvidasteContrasenia = (TextView) findViewById(R.id.tvOlvidasteContrasenia);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIrARegistro = (Button) findViewById(R.id.btnIrARegistro);
        toolbar = (Toolbar) findViewById(R.id.include);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasenia = (EditText) findViewById(R.id.etContrasenia);

        tvOlvidasteContrasenia.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Menú Principal");
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUsuario = etUsuario.getText().toString().trim();
                String strContrasenia = etContrasenia.getText().toString().trim();
                if (!strUsuario.isEmpty() || !strContrasenia.isEmpty()) {
                    if (sql.validarIniciarSesion(strUsuario, strContrasenia)) {
                        Toast.makeText(IniciarSesionActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(IniciarSesionActivity.this, PrincipalActivity.class));
                    } else {
                        Toast.makeText(IniciarSesionActivity.this, "Datos erróneos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(IniciarSesionActivity.this, "Se requiere de usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IniciarSesionActivity.this, RegistrarActivity.class));
            }
        });
    }
}
