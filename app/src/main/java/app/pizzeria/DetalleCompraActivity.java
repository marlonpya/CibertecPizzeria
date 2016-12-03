package app.pizzeria;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import app.pizzeria.util.Utils;

public class DetalleCompraActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private Button btnComprarDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_compra);

        toolbar = (Toolbar) findViewById(R.id.toolbar_detalle_compra);
        btnComprarDetalle = (Button) findViewById(R.id.btnComprarDetalle);

        Utils.setToolbar(toolbar, DetalleCompraActivity.this, "Detalle Compra");
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnComprarDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DetalleCompraActivity.this)
                        .setTitle("Mensaje")
                        .setMessage("Gracias por su compra")
                        .setPositiveButton("ACEPTAR", null)
                        .show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
