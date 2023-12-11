package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class VistaActivity extends AppCompatActivity {
    EditText edCe;
    EditText edNo;
    EditText edAni;
    EditText edMar;
    EditText edCol;
    EditText edVal;
    EditText edTip;
    Button btIr;
    Spinner spinner;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista);

        edCe = findViewById(R.id.txtCed);
        edNo = findViewById(R.id.txtNom);
        edAni = findViewById(R.id.txtAni);
        edMar = findViewById(R.id.txtMar);
        edCol = findViewById(R.id.txtCol);
        edVal = findViewById(R.id.txtValo);
        edTip = findViewById(R.id.txtTipoV);

        btIr = findViewById(R.id.btnEnviar);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.Sino,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        btIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cedula = edCe.getText().toString();
                String nombre = edNo.getText().toString();
                String anioo = edAni.getText().toString();
                String marca = edMar.getText().toString();
                String color = edCol.getText().toString();
                String valor = edVal.getText().toString();
                String tipo = edTip.getText().toString();
                String vehi = spinner.getSelectedItem().toString();

                if (!esSoloLetras(nombre) || !esSoloNumeros(anioo) || !esSoloNumeros(valor) || !esSoloLetras(tipo)) {
                    Toast.makeText(VistaActivity.this, "Verifique los tipos de datos ingresados", Toast.LENGTH_SHORT).show();
                } else {
                    Bundle parametros = new Bundle();
                    parametros.putString("Cargo", vehi);
                    parametros.putString("Nombre", nombre);
                    parametros.putString("Anio", anioo);
                    parametros.putString("Marca", marca);
                    parametros.putString("Color", color);
                    parametros.putString("Valor", valor);
                    parametros.putString("Tipo", tipo);

                    Intent intent = new Intent(VistaActivity.this, MultaActivity.class);
                    intent.putExtras(parametros);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean esSoloLetras(String cadena) {
        return cadena.matches("[a-zA-Z]+");
    }

    private boolean esSoloNumeros(String cadena) {
        return cadena.matches("\\d+");
    }
}



