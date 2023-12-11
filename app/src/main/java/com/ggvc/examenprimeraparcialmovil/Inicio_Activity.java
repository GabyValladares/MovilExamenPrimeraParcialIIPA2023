package com.ggvc.examenprimeraparcialmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio_Activity extends AppCompatActivity {

    EditText edCedula,edNombres,edPlaca,edAnFab,edMarca,edColor,edTipo,edValor,edMultas;
    Button btnCalcular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        edCedula=findViewById(R.id.txtCedula);
        edNombres=findViewById(R.id.txtNombres);
        edPlaca=findViewById(R.id.txtPlaca);
        edAnFab=findViewById(R.id.txtAniofab);
        edMarca=findViewById(R.id.txtMarca);
        edColor=findViewById(R.id.txtColor);
        edTipo=findViewById(R.id.txtTipo);
        edValor=findViewById(R.id.txtValor);
        edMultas=findViewById(R.id.txtNumMultas);
        btnCalcular=findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String nombres = edNombres.getText().toString();
               String placa = edPlaca.getText().toString();

                Bundle enviar=new Bundle();
                enviar.putString("nom",nombres);
                enviar.putString("pla",placa);

                Intent intent=new Intent(Inicio_Activity.this,ResultadosActivity.class);
                intent.putExtras(enviar);
                startActivity(intent);
            }
        });
    }
}