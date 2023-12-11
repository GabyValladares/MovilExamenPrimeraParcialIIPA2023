package com.rycry.movilexamenprimeraparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén referencia al Spinner desde el archivo de diseño (layout)
        Spinner spnMarcaModelo = findViewById(R.id.spnMarcaModelo);
        EditText edNombre = findViewById(R.id.edNombre);
        EditText edCedula = findViewById(R.id.edCedula);
        EditText edAnioFabricacion = findViewById(R.id.edAnioFabricacion);
        EditText edValor = findViewById(R.id.edValor);
        EditText edPlaca = findViewById(R.id.edPlaca);
        CheckBox cbxMultas = findViewById(R.id.cbxMultas);

        // Define las opciones en un array de cadenas
        String[] opciones = {"Toyota-Jeep", "Toyota-Camioneta", "Suzuki-Vitara", "Suzuki-Automóvil"};

        // Crea un adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);

        // Especifica el diseño para el menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica el adaptador al Spinner
        spnMarcaModelo.setAdapter(adapter);

        // Manejar la selección del Spinner
        spnMarcaModelo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Puedes hacer algo con la opción seleccionada, por ejemplo, mostrar un mensaje
                Toast.makeText(MainActivity.this, "Opción seleccionada: " + opciones[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Manejar la falta de selección si es necesario
            }
        });

        // Manejar el evento del botón "Ingresar Datos"
        Button btnIngresarDatos = findViewById(R.id.btnIngresarDatos);
        btnIngresarDatos.setOnClickListener(view -> {
            // Obtener los datos ingresados por el usuario
            String nombre = edNombre.getText().toString();
            String cedula = edCedula.getText().toString();
            int anioFabricacion = Integer.parseInt(edAnioFabricacion.getText().toString());
            double valor = Double.parseDouble(edValor.getText().toString());
            String placa = edPlaca.getText().toString();
            boolean tieneMultas = cbxMultas.isChecked();

            // Realizar los cálculos necesarios (lógica implementada en la actividad)
            double importeRenovacion = calcularImporteRenovacion(cedula, placa);
            double multaContaminacion = calcularMultaContaminacion(anioFabricacion);
            double valorMarcaTipo = calcularValorMarcaTipo(spnMarcaModelo.getSelectedItem().toString(), valor);
            double valorTotal = calcularValorTotal(valorMarcaTipo, tieneMultas);

            // Lanzar la actividad de resultado con los datos calculados
            launchResultadoActivity(nombre, cedula, importeRenovacion, tieneMultas, valorTotal, valorMarcaTipo, multaContaminacion);
        });
    }

    private double calcularImporteRenovacion(String cedula, String placa) {
        // Lógica de cálculo de importe de renovación según las condiciones dadas
        if (cedula.startsWith("1") && placa.contains("I")) {
            return 0.05 * 435; // 5% del sueldo básico
        } else {
            return 0.0;
        }
    }

    private double calcularMultaContaminacion(int anioFabricacion) {
        // Lógica de cálculo de multa por contaminación según las condiciones dadas
        if (anioFabricacion < 2010) {
            return 0.02 * (2023 - anioFabricacion) * 435; // 2% por cada año de contaminación
        } else {
            return 0.0;
        }
    }

    private double calcularValorMarcaTipo(String marcaTipo, double valor) {
        // Lógica de cálculo de valor según marca y tipo de vehículo
        switch (marcaTipo) {
            case "Toyota-Jeep":
                return 0.08 * valor; // 8% del valor
            case "Toyota-Camioneta":
                return 0.12 * valor; // 12% del valor
            case "Suzuki-Vitara":
                return 0.10 * valor; // 10% del valor
            case "Suzuki-Automóvil":
                return 0.09 * valor; // 9% del valor
            default:
                return 0.0;
        }
    }

    private double calcularValorTotal(double valorMarcaTipo, boolean tieneMultas) {
        // Lógica de cálculo del valor total
        double valorTotal = valorMarcaTipo;
        if (tieneMultas) {
            valorTotal += 0.25 * 435; // 25% del sueldo básico
        }
        return valorTotal;
    }

    private void launchResultadoActivity(String nombre, String cedula, double importeRenovacion,
                                         boolean tieneMultas, double valorTotal, double valorMarcaTipo,
                                         double multaContaminacion) {
        // Lanzar la actividad de resultado con los datos calculados
        // y los resultados se pasan como extras en el Intent
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        intent.putExtra("NOMBRE", nombre);
        intent.putExtra("CEDULA", cedula);
        intent.putExtra("IMPORTE_RENOVACION", importeRenovacion);
        intent.putExtra("TIENE_MULTAS", tieneMultas);
        intent.putExtra("VALOR_TOTAL", valorTotal);
        intent.putExtra("VALOR_MARCA_TIPO", valorMarcaTipo);
        intent.putExtra("MULTA_CONTAMINACION", multaContaminacion);
        startActivity(intent);
    }
}
