package com.ggvc.examenprimeraparcialmovil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class validacion extends AppCompatActivity {

    EditText txtRenovacion, txtContaminacion, txtMatriculacion, txtMultas, txtTotalMatricula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);


        txtRenovacion = findViewById(R.id.txt_renovacion);
        txtContaminacion = findViewById(R.id.txt_contaminacion);
        txtMatriculacion = findViewById(R.id.txt_matri);
        txtMultas = findViewById(R.id.txt_pagomultas);
        txtTotalMatricula = findViewById(R.id.txt_toalmatricula);

        // Obtener datos del intent
        Intent intent = getIntent();
        String numeroCedula = intent.getStringExtra("numeroCedula");
        String numeroPlaca = intent.getStringExtra("numeroPlaca");
        String anioFabricacion = intent.getStringExtra("anioFabricacion");
        String marca = intent.getStringExtra("marca");
        String tipoVehiculo = intent.getStringExtra("tipoVehiculo");
        String valorVehiculo = intent.getStringExtra("valorVehiculo");
        String multas = intent.getStringExtra("multas");


        double renovacion = 0;
        if (numeroCedula != null && numeroCedula.startsWith("1") && numeroPlaca != null && numeroPlaca.contains("I")) {
            double sueldoBasico = 435;
            renovacion = 0.05 * sueldoBasico;
        }
        txtRenovacion.setText(String.valueOf(renovacion));


        double contaminacion = 0;
        if (anioFabricacion != null && !anioFabricacion.isEmpty() && Integer.parseInt(anioFabricacion) < 2010) {
            contaminacion = 0.02 * (2023 - Integer.parseInt(anioFabricacion));
        }
        txtContaminacion.setText(String.valueOf(contaminacion));


        double porcentajeMatriculacion = 0;

        if ("Toyota".equals(marca) && "Jeep".equals(tipoVehiculo)) {
            porcentajeMatriculacion = 0.08;
        } else if ("Toyota".equals(marca) && "Camioneta".equals(tipoVehiculo)) {
            porcentajeMatriculacion = 0.12;
        } else if ("Suzuki".equals(marca) && "Vitara".equals(tipoVehiculo)) {
            porcentajeMatriculacion = 0.10;
        } else if ("Suzuki".equals(marca) && "Automóvil".equals(tipoVehiculo)) {
            porcentajeMatriculacion = 0.09;
        }

        double matriculacion = porcentajeMatriculacion * Double.parseDouble(valorVehiculo);
        txtMatriculacion.setText(String.valueOf(matriculacion));

        // Lógica de multas
        double multasAmount = 0;
        boolean tieneMultas = Boolean.parseBoolean(multas);
        if (tieneMultas) {
            double sueldoBasico = 435;
            multasAmount = 0.25 * sueldoBasico;
        }
        txtMultas.setText(String.valueOf(multasAmount));

        double total = renovacion + contaminacion + matriculacion + multasAmount;
        txtTotalMatricula.setText(String.valueOf(total));
    }
}
