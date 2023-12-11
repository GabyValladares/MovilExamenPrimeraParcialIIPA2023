package com.ggvc.examenprimeraparcialmovil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener datos del formulario
                EditText etCedula = findViewById(R.id.etCedula);
                EditText etNombres = findViewById(R.id.etNombres);
                EditText etPlaca = findViewById(R.id.etPlaca);
                EditText etAnioFabricacion = findViewById(R.id.etAnioFabricacion);
                EditText etMarca = findViewById(R.id.etMarca);
                EditText etColor = findViewById(R.id.etColor);
                EditText etTipoVehiculo = findViewById(R.id.etTipoVehiculo);
                EditText etValorVehiculo = findViewById(R.id.etValorVehiculo);
                CheckBox cbMultas = findViewById(R.id.cbMultas);

                // Enviar datos a la siguiente actividad
                Intent intent = new Intent(MainActivity.this, ValidacionActivity.class);
                intent.putExtra("cedula", etCedula.getText().toString());
                intent.putExtra("nombres", etNombres.getText().toString());
                intent.putExtra("placa", etPlaca.getText().toString());
                intent.putExtra("anioFabricacion", etAnioFabricacion.getText().toString());
                intent.putExtra("marca", etMarca.getText().toString());
                intent.putExtra("color", etColor.getText().toString());
                intent.putExtra("tipoVehiculo", etTipoVehiculo.getText().toString());
                intent.putExtra("valorVehiculo", etValorVehiculo.getText().toString());
                intent.putExtra("tieneMultas", cbMultas.isChecked());
                startActivity(intent);
            }
        });
    }
}
