package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;

public class activity_formulario_vehiculo extends AppCompatActivity {

    private EditText txtCedula;
    private EditText txtPlaca;
    private EditText txtAnio;
    private EditText txtMarca;
    private EditText txtTipoVehiculo;
    private EditText txtMultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_vehiculo);

        // Obtener referencias de los elementos en el layout
        txtCedula = findViewById(R.id.txtCedula);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtAnio = findViewById(R.id.txtAnio);
        txtMarca = findViewById(R.id.txtMarca);
        txtTipoVehiculo = findViewById(R.id.txtTipoVehiculo);
        txtMultas = findViewById(R.id.txtMultas);

        // Configurar el evento clic del botón
        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Llamar a la función para procesar los cálculos
                procesarCalculos();
            }
        });
    }

    private void procesarCalculos() {

        String cedula = txtCedula.getText().toString();
        String placa = txtPlaca.getText().toString();
        String anio = txtAnio.getText().toString();
        String marca = txtMarca.getText().toString();
        String tipoVehiculo = txtTipoVehiculo.getText().toString();
        String multas = txtMultas.getText().toString();


        if (cedula.isEmpty() || placa.isEmpty() || anio.isEmpty() || marca.isEmpty() || tipoVehiculo.isEmpty() || multas.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        double importeRenovacion = calcularImporteRenovacion(cedula, placa);
        double multaContaminacion = calcularMultaContaminacion(anio);

        // Puedes asignar un valor de ejemplo para valorVehiculo o cambiar el método según tus necesidades
        double valorVehiculo = 10000.0;
        double valorMatricula = calcularValorMatricula(marca, tipoVehiculo, valorVehiculo);

        double multaPorMultas = multas.equalsIgnoreCase("SI") ? calcularMultaPorMultas("si") : 0.0;

        double totalPagar = importeRenovacion + valorMatricula + multaContaminacion + multaPorMultas;


        Intent intent = new Intent(activity_formulario_vehiculo.this, activity_resultados_vehiculo.class);

        intent.putExtra("IMPORTE_RENOVACION", importeRenovacion);
        intent.putExtra("VALOR_MATRICULA", valorMatricula);
        intent.putExtra("MULTA_CONTAMINACION", multaContaminacion);
        intent.putExtra("MULTA_POR_MULTAS", multaPorMultas);
        intent.putExtra("TOTAL_PAGAR", totalPagar);


        startActivity(intent);
    }



    private double calcularImporteRenovacion(String cedula, String placa) {
        // Supongamos que el 5% del sueldo básico es $435
        double sueldoBasico = 435.0;
        double porcentajeRenovacion = 0.05;

        // Verificar si el número de cédula comienza con "1" y la placa contiene la letra "I"
        if (cedula.startsWith("1") && placa.contains("I")) {
            // Calcular el importe de renovación
            double importeRenovacion = sueldoBasico * porcentajeRenovacion;
            return importeRenovacion;
        } else {
            // Si no cumple con las condiciones, el importe es cero
            return 0.0;
        }
    }



    private double calcularMultaContaminacion(String anio) {
        // Obtener el año actual
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);

        // Convertir el año de fabricación a entero
        int anioFabricacion = Integer.parseInt(anio);

        // Calcular la cantidad de años de contaminación
        int aniosContaminacion = anioActual - anioFabricacion;

        // Verificar si la multa es aplicable (solo para vehículos con más de 10 años)
        if (aniosContaminacion > 10) {
            // Supongamos que la multa es del 2% por cada año de contaminación
            double porcentajeMulta = 0.02;

            // Calcular la multa por contaminación
            double multaContaminacion = porcentajeMulta * aniosContaminacion;

            return multaContaminacion;
        } else {
            // Si el vehículo tiene 10 años o menos, la multa es cero
            return 0.0;
        }
    }


    private double calcularValorMatricula(String marca, String tipoVehiculo, double valorVehiculo) {
        // Definir porcentajes de matriculación para diferentes combinaciones de marca y tipo de vehículo
        double porcentajeToyotaJeep = 0.08;
        double porcentajeToyotaCamioneta = 0.12;
        double porcentajeSuzukiVitara = 0.10;
        double porcentajeSuzukiAutomovil = 0.09;

        // Calcular el valor de matriculación según la combinación de marca y tipo de vehículo
        if (marca.equalsIgnoreCase("Toyota")) {
            if (tipoVehiculo.equalsIgnoreCase("Jeep")) {
                return valorVehiculo * porcentajeToyotaJeep;
            } else if (tipoVehiculo.equalsIgnoreCase("Camioneta")) {
                return valorVehiculo * porcentajeToyotaCamioneta;
            }
        } else if (marca.equalsIgnoreCase("Suzuki")) {
            if (tipoVehiculo.equalsIgnoreCase("Vitara")) {
                return valorVehiculo * porcentajeSuzukiVitara;
            } else if (tipoVehiculo.equalsIgnoreCase("Automóvil")) {
                return valorVehiculo * porcentajeSuzukiAutomovil;
            }
        }

        // Valor de matriculación por defecto si no se encuentra una combinación válida
        return 0.0;
    }


    private double calcularMultaPorMultas(String tieneMultas) {
        // Supongamos que el sueldo básico es $435 y la multa es del 25%
        double sueldoBasico = 435.0;
        double porcentajeMulta = 0.25;

        // Lógica para calcular la multa por multas
        // Puedes utilizar el parámetro tieneMultas o agregar lógica adicional según tus necesidades

        // Calcular la multa por multas si el vehículo tiene multas
        if ("si".equalsIgnoreCase(tieneMultas)) {
            return sueldoBasico * porcentajeMulta;
        }

        // Si no tiene multas, la multa es cero
        return 0.0;
    }


}
