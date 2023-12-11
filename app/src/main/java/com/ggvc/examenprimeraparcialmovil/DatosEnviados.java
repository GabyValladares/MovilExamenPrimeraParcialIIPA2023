package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class DatosEnviados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_enviados);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String cedula = extras.getString("cedula");
            String nombreCompleto = extras.getString("nombreCompleto");
            String placa = extras.getString("placa");
            int anioFabricacion = extras.getInt("anioFabricacion");
            String color = extras.getString("color");
            String tipoVehiculo = extras.getString("tipoVehiculo");
            String multa = extras.getString("multa");

            double sueldoBasico = 435.0;
            double impuestoRenovacionPlacas = 0.0;
            double multaContaminacion = 0.0;
            double valorMatriculacion = 0.0;
            double multaPorcentajeSueldo = 0.0;

            if (cedula.startsWith("1") && placa.startsWith("I")) {
                impuestoRenovacionPlacas = 0.05 * sueldoBasico;
            }

            if (anioFabricacion < 2010) {
                multaContaminacion = 0.02 * sueldoBasico * (2010 - anioFabricacion);
            }

            if (tipoVehiculo != null) {
                if (tipoVehiculo.equals("Jeep")) {
                    valorMatriculacion = 0.08 * sueldoBasico;
                } else if (tipoVehiculo.equals("Camioneta")) {
                    valorMatriculacion = 0.12 * sueldoBasico;
                } else if (tipoVehiculo.equals("Vitara")) {
                    valorMatriculacion = 0.10 * sueldoBasico;
                } else if (tipoVehiculo.equals("Automóvil")) {
                    valorMatriculacion = 0.09 * sueldoBasico;
                }
            }

            if (multa != null && multa.equals("true")) {
                multaPorcentajeSueldo = 0.25 * sueldoBasico;
            }

            double totalPagar = impuestoRenovacionPlacas + multaContaminacion + valorMatriculacion + multaPorcentajeSueldo;

            String mensaje = "Cédula: " + cedula + "\n"
                    + "Nombre: " + nombreCompleto + "\n"
                    + "Placa: " + placa + "\n"
                    + "Año de Fabricación: " + anioFabricacion + "\n"
                    + "Color: " + color + "\n"
                    + "Tipo de Vehículo: " + tipoVehiculo + "\n"
                    + "Impuesto Renovación Placas: $" + impuestoRenovacionPlacas + "\n"
                    + "Multa Contaminación: $" + multaContaminacion + "\n"
                    + "Valor Matriculación: $" + valorMatriculacion + "\n"
                    + "Multa Porcentaje Sueldo: $" + multaPorcentajeSueldo + "\n"
                    + "Total a Pagar: $" + totalPagar;

            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No se recibieron datos", Toast.LENGTH_SHORT).show();
        }
    }
}
