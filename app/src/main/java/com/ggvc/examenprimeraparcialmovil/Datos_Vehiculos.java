package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class Datos_Vehiculos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_vehiculos);

        @SuppressLint("WrongViewCast") EditText edCedula = findViewById(R.id.txtCedulaP);
        @SuppressLint("WrongViewCast") EditText edNombre = findViewById(R.id.txtNombreP);
        @SuppressLint("WrongViewCast") EditText edPlaca = findViewById(R.id.txtPlaca);
        @SuppressLint("WrongViewCast") EditText edAnio = findViewById(R.id.txtAnio);
        @SuppressLint("WrongViewCast") EditText edColor = findViewById(R.id.txtColor);
        @SuppressLint("WrongViewCast") EditText edTvVehiculo = findViewById(R.id.txtTvehiculo);
        @SuppressLint("WrongViewCast") EditText edMulta = findViewById(R.id.txtMulta);

        Button btnCalcular = findViewById(R.id.btnSigiente);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Datos_Vehiculos.this, DatosEnviados.class);
                Bundle datos = new Bundle();

                String cedula = Objects.requireNonNull(edCedula.getText()).toString();
                String nombreCompleto = Objects.requireNonNull(edNombre.getText()).toString();
                String placa = Objects.requireNonNull(edPlaca.getText()).toString();
                String anioStr = Objects.requireNonNull(edAnio.getText()).toString();
                String color = Objects.requireNonNull(edColor.getText()).toString();
                String tipoVehiculo = Objects.requireNonNull(edTvVehiculo.getText()).toString();
                String multa = Objects.requireNonNull(edMulta.getText()).toString();

                try {
                    Integer anio = Integer.parseInt(anioStr);

                    if (!TextUtils.isEmpty(cedula) && !TextUtils.isEmpty(nombreCompleto)
                            && !TextUtils.isEmpty(placa) && anio != null
                            && !TextUtils.isEmpty(color) && !TextUtils.isEmpty(tipoVehiculo)
                            && !TextUtils.isEmpty(multa)) {
                        Toast.makeText(Datos_Vehiculos.this, "CALCULANDO DATOS DEL VEHÍCULO", Toast.LENGTH_SHORT).show();

                        datos.putString("cedula", cedula);
                        datos.putString("nombreCompleto", nombreCompleto);
                        datos.putString("placa", placa);
                        datos.putInt("anioFabricacion", anio);
                        datos.putString("color", color);
                        datos.putString("tipoVehiculo", tipoVehiculo);
                        datos.putString("multa", multa);

                        intent.putExtras(datos);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Datos_Vehiculos.this, "INGRESE DATOS VÁLIDOS", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(Datos_Vehiculos.this, "ASEGÚRESE DE LLENAR BIEN LOS CAMPOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
