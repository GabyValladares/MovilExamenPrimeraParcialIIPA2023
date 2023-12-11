package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Resultados extends AppCompatActivity {
    TextView respTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        respTextView = findViewById(R.id.txtResultado);
        Bundle datos = this.getIntent().getExtras();
        if (datos != null) {
            int ced = datos.getInt("cedulas");
            String nomb = datos.getString("nombres");
            String pla = datos.getString("placas");
            String aniosfab = datos.getString("anios_fab");
            String marc = datos.getString("marcas");
            String color = datos.getString("colores");
            String tipoVeh = datos.getString("tipoV");
            String val = datos.getString("valores");
            String mult = datos.getString("multas");

            float total_a_pagar = calcularTotalAPagar(ced, nomb, pla, aniosfab, marc, color, tipoVeh, val, mult);
            mostrarResultado(total_a_pagar);

        } else {
            Toast.makeText(Resultados.this, "Datos no válidos", Toast.LENGTH_SHORT).show();
        }
    }

    public float calcularTotalAPagar(int cedula, String nombre, String placa, String anioFab, String marca, String color, String tipoV, String valor, String multa) {

        float importeRenovacionPlacas = 0;
        float multaContaminacion = 0;
        float valorMatriculacion = 0;
        float multaPorMultas = 0;


        if (String.valueOf(cedula).startsWith("1") && placa.startsWith("I")) {
            importeRenovacionPlacas = 0.05f * 435;
        }


        int anoFabricacion = Integer.parseInt(anioFab);
        if (anoFabricacion < 2010) {
            multaContaminacion = 0.02f * (2023 - anoFabricacion) * Float.parseFloat(valor);
        }


        if (marca.equals("Toyota")) {
            if (tipoV.equals("Jeep")) {
                valorMatriculacion = 0.08f * Float.parseFloat(valor);
            } else if (tipoV.equals("Camioneta")) {
                valorMatriculacion = 0.12f * Float.parseFloat(valor);
            }
        } else if (marca.equals("Suzuki")) {
            if (tipoV.equals("Vitara")) {
                valorMatriculacion = 0.10f * Float.parseFloat(valor);
            } else if (tipoV.equals("Automóvil")) {
                valorMatriculacion = 0.09f * Float.parseFloat(valor);
            }
        }


        if (multa.equalsIgnoreCase("SI")) {
            multaPorMultas = 0.25f * 435;
        }


        return importeRenovacionPlacas + multaContaminacion + valorMatriculacion + multaPorMultas;
    }

    private void mostrarResultado(final float resultado) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                respTextView.setText(String.valueOf(resultado));
            }
        });
    }
}

