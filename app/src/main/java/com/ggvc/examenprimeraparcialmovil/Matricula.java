package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Matricula extends AppCompatActivity {

    TextView lblRenovacion, lblContaminacion, lblMulta, lblValor, lblTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);
        lblRenovacion = findViewById(R.id.lblRenovacion);
        lblContaminacion = findViewById(R.id.lblContaminacion);
        lblMulta = findViewById(R.id.lblMultasRe);
        lblValor = findViewById(R.id.lblValorRe);
        lblTotal = findViewById(R.id.lblTotal);

        Bundle datos = getIntent().getExtras();

        String Cedula = datos.getString("cedula");
        String Nombre = datos.getString("nombre");
        String Placa = datos.getString("placa");
        int AnioVehiculo = datos.getInt("aniovehiculo");
        int Valor = datos.getInt("valor");
        String Marca = datos.getString("marca");
        String Tipo = datos.getString("tipo");
        String Color = datos.getString("color");
        String Multa = datos.getString("multa");

        int basico = 435;
        double renovacion = 0;
        double valorMatricula = 0;
        double multacontaminacion = 0;
        double multa = 0;
        double total = 0;

        if ('1' == Cedula.charAt(0) && 'i'== Placa.charAt(0)){
            renovacion = 0.05 * basico;
            lblRenovacion.setText("Importe por renovacion de " + renovacion +  " Dolares");
        } else {
            lblRenovacion.setText("No tiene Importe por Renovacion");
        }

        if (AnioVehiculo < 2010){
            multacontaminacion = (0.02 * Valor) * (2010 - AnioVehiculo);
            lblContaminacion.setText("Multa por contaminacion: " + multacontaminacion + " Dolares");
        } else {
            lblContaminacion.setText("No tiene multas por contaminacion");
        }

        if (Marca.equalsIgnoreCase("Toyota") && Tipo.equalsIgnoreCase("Jeep")){
            valorMatricula = 0.08 * Valor;
        } else if(Marca.equalsIgnoreCase("Toyota") && Tipo.equalsIgnoreCase("Camioneta")){
            valorMatricula = 0.12 * Valor;
        } else if (Marca.equalsIgnoreCase("Suzuki") && Tipo.equalsIgnoreCase("vitara")){
            valorMatricula = 0.10 * Valor;
        } else if (Marca.equalsIgnoreCase("Suzuki") && Tipo.equalsIgnoreCase("automovil")){
            valorMatricula = 0.9 * Valor;
        }
        lblValor.setText("Valor por matricula es: " + valorMatricula + " Dolares");

        if (Multa.equalsIgnoreCase("Si")) {
            multa = 0.25 * basico;
            lblMulta.setText("la multa es de: " + multa + " Dolares");
        } else {
            lblMulta.setText("no tienes Multas");
        }

        total = renovacion + valorMatricula + multacontaminacion + multa;
        lblTotal.setText("Total a pagar: " + total + " Dolares");
    }



}