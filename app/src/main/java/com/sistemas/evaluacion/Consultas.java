package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Consultas extends AppCompatActivity {

    Button CAdolescentes;
    Button CAdulto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        CAdolescentes = (Button)findViewById(R.id.btnConsultaA);
        CAdolescentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CAdolescentes = new Intent(Consultas.this, ConsultaDomicilioA.class);
                startActivity(CAdolescentes);
            }
        });

        CAdulto = (Button)findViewById(R.id.btnConsulta);
        CAdulto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CAdulto = new Intent(Consultas.this, ConsultaDomicilio.class);
                startActivity(CAdulto);
            }
        });
    }
}
