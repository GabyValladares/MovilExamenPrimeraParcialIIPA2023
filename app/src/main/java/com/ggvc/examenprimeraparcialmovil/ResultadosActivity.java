package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {
    TextView tvResultados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvResultados=findViewById(R.id.txtRESULTADOS);

        setContentView(R.layout.activity_resultados);
        Bundle enviar = this.getIntent().getExtras();
        if(enviar != null){
            String nombre = enviar.getString("nom");


        }
    }
}