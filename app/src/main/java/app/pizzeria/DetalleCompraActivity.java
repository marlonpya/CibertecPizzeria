package app.pizzeria;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import app.pizzeria.modelo.Carta;
import app.pizzeria.sqlite.QuerysSQL;
import app.pizzeria.util.Constantes;
import app.pizzeria.util.Utils;

public class DetalleCompraActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btnComprarDetalle;
    private RadioGroup rbGrupoDetalle;
    private RadioButton rbDetalleCompra1, rbDetalleCompra2, rbDetalleCompra3, rbExtra1, rbExtra2;
    private ImageView ivDetalleImagen;
    private TextView tvDetalleDescripcion, tvExtras;
    private LinearLayout rbExtras;
    private int id_intent;
    private QuerysSQL querysSQL;
    private Carta carta;
    private boolean prohibido_extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);

        querysSQL = new QuerysSQL(DetalleCompraActivity.this);

        toolbar = (Toolbar) findViewById(R.id.toolbar_detalle_compra);
        btnComprarDetalle = (Button) findViewById(R.id.btnComprarDetalle);
        tvDetalleDescripcion = (TextView) findViewById(R.id.tvDetalleDescripcion);
        rbGrupoDetalle = (RadioGroup) findViewById(R.id.rbGrupoDetalle);
        rbDetalleCompra1 = (RadioButton) findViewById(R.id.rbDetalleCompra1);
        rbDetalleCompra2 = (RadioButton) findViewById(R.id.rbDetalleCompra2);
        rbDetalleCompra3 = (RadioButton) findViewById(R.id.rbDetalleCompra3);
        rbExtra1 = (RadioButton) findViewById(R.id.rbExtra1);
        rbExtra2 = (RadioButton) findViewById(R.id.rbExtra2);
        ivDetalleImagen = (ImageView) findViewById(R.id.ivDetalleImagen);
        tvExtras = (TextView) findViewById(R.id.tvExtras);
        rbExtras = (LinearLayout) findViewById(R.id.rbExtras);

        Utils.setToolbar(toolbar, DetalleCompraActivity.this, "Detalle Compra");

        id_intent = getIntent().getIntExtra(Constantes.KEY_ID_CARTA, -1);
        carta = querysSQL.getCartaPorId(id_intent);

        prohibido_extras = (carta.getTipo_carta() == Carta.OFERTAS || carta.getTipo_carta() == Carta.BEBIDAS);

        tvDetalleDescripcion.setText(carta.getDetalle());
        rbDetalleCompra1.setText("Precio Pequeño : " +String.valueOf(carta.getPrecio_grande()));
        rbDetalleCompra2.setText("Precio Mediano : " +String.valueOf(carta.getPrecio_familiar()));
        rbDetalleCompra3.setText("Precio Grande : " +String.valueOf(carta.getPrecio_super_familiar()));
        ivDetalleImagen.setImageResource(carta.getImagen_carta());

        if (prohibido_extras) {
            //setear visibilidad con invisibilidad
            tvExtras.setVisibility(View.INVISIBLE);
            rbExtras.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnComprarDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rbDetalleCompra1.isChecked() || rbDetalleCompra2.isChecked() || rbDetalleCompra3.isChecked()) {
                    int radio_id_encontrado = rbGrupoDetalle.getCheckedRadioButtonId();
                    RadioButton radion_button_comodin = (RadioButton) rbGrupoDetalle.findViewById(radio_id_encontrado);
                    final String radio_elegido = radion_button_comodin.getText().toString();
                    String mas = !prohibido_extras ? (rbExtra1.isChecked() ? "Con extra "+rbExtra1.getText().toString() : "Con extra "+rbExtra2.getText().toString()) : "";
                    new AlertDialog.Builder(DetalleCompraActivity.this)
                            .setTitle("Mensaje")
                            .setMessage("Comprar " + carta.getNombre_carta() +".\n" +
                                    "Su costo es de " + radio_elegido +".\n" +
                                    mas)
                            .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    onBackPressed();
                                }
                            })
                            .setNegativeButton("CANCELAR", null)
                            .show();
                } else {
                    Toast.makeText(DetalleCompraActivity.this, "Debe escoger un precio", Toast.LENGTH_SHORT).show();
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
