package com.ggvc.examenprimeraparcialmovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleRegistrationActivity extends AppCompatActivity {

    Button button;
    EditText txt_numeroCedula, txt_nombrepropietario, txt_numeroPlaca, txt_anioFabricacion, txt_marca, txt_color, txt_tipoVehiculo, txt_valorVehiculo, txt_multas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_registration);

        // Obtener referencias de los elementos de la interfaz
        button = findViewById(R.id.button);
        txt_numeroCedula = findViewById(R.id.txt_numeroCedula);
        txt_nombrepropietario = findViewById(R.id.txt_nombrepropietario);
        txt_numeroPlaca = findViewById(R.id.txt_numeroPlaca);
        txt_anioFabricacion = findViewById(R.id.txt_anioFrabri);
        txt_marca = findViewById(R.id.txt_marca);
        txt_color = findViewById(R.id.txt_color);
        txt_tipoVehiculo = findViewById(R.id.txt_tipovehiculo);
        txt_valorVehiculo = findViewById(R.id.txt_valorvehiculo);
        txt_multas = findViewById(R.id.txt_multas);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numeroCedula = txt_numeroCedula.getText().toString();
                String numeroPlaca = txt_numeroPlaca.getText().toString();
                String anioFabricacion = txt_anioFabricacion.getText().toString();
                String marca = txt_marca.getText().toString();
                String tipoVehiculo = txt_tipoVehiculo.getText().toString();
                String valorVehiculo = txt_valorVehiculo.getText().toString();
                String multas = txt_multas.getText().toString();


                if (!numeroCedula.isEmpty() && !numeroPlaca.isEmpty() && !valorVehiculo.isEmpty()) {

                    Intent intent = new Intent(VehicleRegistrationActivity.this, validacion.class);
                    intent.putExtra("numeroCedula", numeroCedula);
                    intent.putExtra("numeroPlaca", numeroPlaca);
                    intent.putExtra("anioFabricacion", anioFabricacion);
                    intent.putExtra("marca", marca);
                    intent.putExtra("tipoVehiculo", tipoVehiculo);
                    intent.putExtra("valorVehiculo", valorVehiculo);
                    intent.putExtra("multas", multas);

                    startActivity(intent);
                } else {

                }
            }
        });
    }
}
