package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reportes extends AppCompatActivity {

    Button RAdolescentes;
    Button RAdulto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);

        RAdolescentes = (Button)findViewById(R.id.btnReporteA);
        RAdolescentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RAdolescentes = new Intent(Reportes.this, ReporteAdolescentes.class);
                startActivity(RAdolescentes);
            }
        });

        RAdulto = (Button)findViewById(R.id.btnReporte);
        RAdulto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RAdulto = new Intent(Reportes.this, ReporteEntrevista.class);
                startActivity(RAdulto);
            }
        });
    }
}
