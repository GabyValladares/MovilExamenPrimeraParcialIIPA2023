package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class Formulario extends AppCompatActivity {
    EditText ed_cedula, ed_nombre, ed_placa, ed_anioFabricacion, ed_marca, ed_color, ed_tipoVehiculo, ed_valor;
    Spinner sp_tipoMulta;
    Button btn_genera;
    ArrayAdapter<String> multas;
    String[] opc = {"SI", "NO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        ed_cedula = findViewById(R.id.edCedula);
        ed_nombre = findViewById(R.id.edNombre);
        ed_placa = findViewById(R.id.edPlaca);
        ed_anioFabricacion = findViewById(R.id.edAnioFab);
        ed_marca = findViewById(R.id.edMarcas);
        ed_color = findViewById(R.id.edColor);
        ed_tipoVehiculo = findViewById(R.id.edTipoV);
        ed_valor = findViewById(R.id.edValor);
        sp_tipoMulta = findViewById(R.id.MULTAS);
        btn_genera = findViewById(R.id.btnCalcular);
        multas = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opc);
        sp_tipoMulta.setAdapter(multas);

        btn_genera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Validar campos vacíos
                if (camposVacios()) {
                    Toast.makeText(Formulario.this, "Todos los campos deben ser completados", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int cedula = Integer.parseInt(ed_cedula.getText().toString());
                    String nombre = ed_nombre.getText().toString();
                    String placa = ed_placa.getText().toString();
                    int anio_fabricacion = Integer.parseInt(ed_anioFabricacion.getText().toString());
                    String marca = ed_marca.getText().toString();
                    String color = ed_color.getText().toString();
                    String tipoVehiculo = ed_tipoVehiculo.getText().toString();
                    float valor = Float.parseFloat(ed_valor.getText().toString());
                    String multa = "no";

                    Bundle datos = new Bundle();
                    datos.putInt("cedulas", cedula);
                    datos.putString("nombres", nombre);
                    datos.putString("placas", placa);
                    datos.putInt("anios_fab", anio_fabricacion);
                    datos.putString("marcas", marca);
                    datos.putString("colores", color);
                    datos.putString("tipoV", tipoVehiculo);
                    datos.putFloat("valores", valor);
                    datos.putString("multas", multa);

                    Intent in = new Intent(Formulario.this, Resultados.class);
                    in.putExtras(datos);
                    startActivity(in);
                } catch (NumberFormatException e) {
                    Toast.makeText(Formulario.this, "Error: Ingrese valores numéricos válidos en los campos correspondientes", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


    }

    private boolean camposVacios() {
        return ed_cedula.getText().toString().isEmpty() ||
                ed_nombre.getText().toString().isEmpty() ||
                ed_placa.getText().toString().isEmpty() ||
                ed_anioFabricacion.getText().toString().isEmpty() ||
                ed_marca.getText().toString().isEmpty() ||
                ed_color.getText().toString().isEmpty() ||
                ed_tipoVehiculo.getText().toString().isEmpty() ||
                ed_valor.getText().toString().isEmpty();
    }
}
