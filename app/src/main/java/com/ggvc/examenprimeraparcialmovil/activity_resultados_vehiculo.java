package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_resultados_vehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_vehiculo);

        // Obtener los extras del Intent
        Intent intent = getIntent();
        double importeRenovacion = intent.getDoubleExtra("IMPORTE_RENOVACION", 0.0);
        double valorMatricula = intent.getDoubleExtra("VALOR_MATRICULA", 0.0);
        double multaContaminacion = intent.getDoubleExtra("MULTA_CONTAMINACION", 0.0);
        double multaPorMultas = intent.getDoubleExtra("MULTA_POR_MULTAS", 0.0);
        double totalPagar = intent.getDoubleExtra("TOTAL_PAGAR", 0.0);

        // Mostrar los resultados en los TextView correspondientes
        TextView lblImporte = findViewById(R.id.lblImporte);
        lblImporte.setText(String.valueOf(importeRenovacion));

        TextView lblValorMatricula = findViewById(R.id.lblValorMatricula);
        lblValorMatricula.setText(String.valueOf(valorMatricula));

        TextView lblContaminacion = findViewById(R.id.lblContaminacion);
        lblContaminacion.setText(String.valueOf(multaContaminacion));

        TextView lblMultas2 = findViewById(R.id.lblMultas2);
        lblMultas2.setText(String.valueOf(multaPorMultas));

        TextView lblTotalPagar = findViewById(R.id.lblTotalPagar);
        lblTotalPagar.setText(String.valueOf(totalPagar));

        // Agregar OnClickListener al botón "ATRAS"
        Button btnAtras = findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cerrar la actividad actual y volver a la actividad anterior
                finish();
            }
        });
    }
}
