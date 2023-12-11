package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Matricula extends AppCompatActivity {

    TextView lblRenovacion, lblContaminacion, lblMulta, lblValor, lblTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matricula);
        lblRenovacion = findViewById(R.id.lblRenovacion);
        lblContaminacion = findViewById(R.id.lblContaminacion);
        lblMulta = findViewById(R.id.lblMultasRe);
        lblValor = findViewById(R.id.lblValorRe);
        lblTotal = findViewById(R.id.lblTotal);

        Bundle datos = getIntent().getExtras();
    }
}