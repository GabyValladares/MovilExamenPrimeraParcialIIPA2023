package com.ggvc.examenprimeraparcialmovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ValidacionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);

        Intent intent = getIntent();
        String cedula = intent.getStringExtra("cedula");
        String nombres = intent.getStringExtra("nombres");
        String placa = intent.getStringExtra("placa");
        String anioFabricacion = intent.getStringExtra("anioFabricacion");
        String marca = intent.getStringExtra("marca");
        String color = intent.getStringExtra("color");
        String tipoVehiculo = intent.getStringExtra("tipoVehiculo");
        String valorVehiculo = intent.getStringExtra("valorVehiculo");
        boolean tieneMultas = intent.getBooleanExtra("tieneMultas", false);

        double importeRenovacion = 0.0;
        double importeMultaContaminacion = 0.0;
        double importeMatriculacion = 0.0;

        if (cedula.startsWith("1") && placa.startsWith("I")) {
            importeRenovacion = 0.05 * 435;
        }

        int anioActual = 2023;
        int anioFabricacionInt = Integer.parseInt(anioFabricacion);
        if (anioFabricacionInt < 2010) {
            int anosContaminacion = anioActual - anioFabricacionInt;
            importeMultaContaminacion = 0.02 * anosContaminacion * Double.parseDouble(valorVehiculo);
        }

        if ("Toyota".equalsIgnoreCase(marca) && "Jeep".equalsIgnoreCase(tipoVehiculo)) {
            importeMatriculacion = 0.08 * Double.parseDouble(valorVehiculo);
        } else if ("Toyota".equalsIgnoreCase(marca) && "Camioneta".equalsIgnoreCase(tipoVehiculo)) {
            importeMatriculacion = 0.12 * Double.parseDouble(valorVehiculo);
        } else if ("Suzuki".equalsIgnoreCase(marca) && "Vitara".equalsIgnoreCase(tipoVehiculo)) {
            importeMatriculacion = 0.10 * Double.parseDouble(valorVehiculo);
        } else if ("Suzuki".equalsIgnoreCase(marca) && "Automóvil".equalsIgnoreCase(tipoVehiculo)) {
            importeMatriculacion = 0.09 * Double.parseDouble(valorVehiculo);
        }

        if (tieneMultas) {
            importeMatriculacion += 0.25 * 435;
        }

        Toast.makeText(this, "Importe de renovación: $" + importeRenovacion +
                "\nMulta por contaminación: $" + importeMultaContaminacion +
                "\nImporte de matriculación: $" + importeMatriculacion, Toast.LENGTH_LONG).show();

        // Mostrar resultado en el layout
        TextView tvResultado = findViewById(R.id.tvResultado);
        String resultadoText = "Importe de renovación: $" + importeRenovacion +
                "\nMulta por contaminación: $" + importeMultaContaminacion +
                "\nImporte de matriculación: $" + importeMatriculacion;
        tvResultado.setText(resultadoText);

        // Configurar el botón de regreso
        Button btnRegresar = findViewById(R.id.btnRegresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a la vista principal (MainActivity)
                finish();
            }
        });
    }
    }

