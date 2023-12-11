package com.rycry.movilexamenprimeraparcial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtén referencia al Spinner desde el archivo de diseño (layout)
        Spinner spnMarcaModelo = findViewById(R.id.spnMarcaModelo);

        // Define las opciones en un array de cadenas
        String[] opciones = {"Toyota-Jeep", "Toyota-Camioneta", "Suzuki-Vitara", "Suzuki-Automóvil"};

        // Crea un adaptador para el Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);

        // Especifica el diseño para el menú desplegable
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica el adaptador al Spinner
        spnMarcaModelo.setAdapter(adapter);
    }
}
