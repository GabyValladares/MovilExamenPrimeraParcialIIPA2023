package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        // Obtener los valores ingresados por el usuario
        String cedula = txtCedula.getText().toString();
        String placa = txtPlaca.getText().toString();
        String anio = txtAnio.getText().toString();
        String marca = txtMarca.getText().toString();
        String tipoVehiculo = txtTipoVehiculo.getText().toString();
        String multas = txtMultas.getText().toString();

        // Realizar la lógica de cálculos aquí (usar Double.parseDouble para convertir a números)
        double importeRenovacion = 50.0; // Reemplazar con la lógica real
        double valorMatricula = 100.0;   // Reemplazar con la lógica real
        double multaContaminacion = 20.0; // Reemplazar con la lógica real
        double multaPorMultas = 30.0;    // Reemplazar con la lógica real

        // Calcular el total a pagar
        double totalPagar = importeRenovacion + valorMatricula + multaContaminacion + multaPorMultas;

        // Crear un Intent para pasar a la actividad de resultados
        Intent intent = new Intent(activity_formulario_vehiculo.this, activity_resultados_vehiculo.class);

        // Puedes agregar datos adicionales al Intent si es necesario
        intent.putExtra("IMPORTE_RENOVACION", importeRenovacion);
        intent.putExtra("VALOR_MATRICULA", valorMatricula);
        intent.putExtra("MULTA_CONTAMINACION", multaContaminacion);
        intent.putExtra("MULTA_POR_MULTAS", multaPorMultas);
        intent.putExtra("TOTAL_PAGAR", totalPagar);

        // Iniciar la actividad de resultados
        startActivity(intent);
    }
}

