package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MatriculaMain extends AppCompatActivity {

    Spinner sprMarca, sprTipo, sprColor, sprMultas;
    EditText edCedula, edNombre, edPlaca, edAnioVehiculo, edValor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula_main);

        sprMarca = findViewById(R.id.sprMarca);
        sprMultas = findViewById(R.id.sprMultas);
        sprColor = findViewById(R.id.sprColor);
        sprTipo = findViewById(R.id.sprTipo);
        edCedula = findViewById(R.id.txtCedula);
        edNombre = findViewById(R.id.txtNombre);
        edPlaca = findViewById(R.id.txtPlaca);
        edAnioVehiculo = findViewById(R.id.txtAnioVehiculo);
        edValor = findViewById(R.id.txtValor);

        String[] marcas = getResources().getStringArray(R.array.Marcas);
        ArrayAdapter<String> adapterMarcas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, marcas);
        adapterMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String[] Opciones = getResources().getStringArray(R.array.Opciones);
        ArrayAdapter<String> adapterOpciones = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Opciones);
        adapterOpciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String[] Tipos = getResources().getStringArray(R.array.Tipo);
        ArrayAdapter<String> adapterTipos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Tipos);
        adapterTipos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String[] Color = getResources().getStringArray(R.array.Colores);
        ArrayAdapter<String> adapterColor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Color);
        adapterColor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sprMarca.setAdapter(adapterMarcas);
        sprTipo.setAdapter(adapterTipos);
        sprColor.setAdapter(adapterColor);
        sprMultas.setAdapter(adapterOpciones);

    }

    public void Enviar(View view){
        Bundle Matricula = new Bundle();

        Matricula.putString("cedula", edCedula.getText().toString());
        Matricula.putString("nombre", edNombre.getText().toString());
        Matricula.putString("placa", edPlaca.getText().toString());
        Matricula.putString("aniovehiculo", edAnioVehiculo.getText().toString());
        Matricula.putString("valor", edValor.getText().toString());
        Matricula.putString("marca", sprMarca.getSelectedItem().toString());
        Matricula.putString("tipo", sprTipo.getSelectedItem().toString());
        Matricula.putString("color", sprColor.getSelectedItem().toString());
        Matricula.putString("multa", sprMultas.getSelectedItem().toString());

        Intent i = new Intent(this, Matricula.class);
        i.putExtras(Matricula);
        startActivity(i);
    }
}