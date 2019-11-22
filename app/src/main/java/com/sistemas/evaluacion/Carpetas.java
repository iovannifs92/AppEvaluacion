package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Carpetas extends AppCompatActivity {

    Button CAdolescentes;
    Button CAdulto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpetas);

        CAdolescentes = (Button)findViewById(R.id.btnCAdolescentes);
        CAdolescentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CAdolescentes = new Intent(Carpetas.this, infoCasoAdolescente.class);
                startActivity(CAdolescentes);
            }
        });

        CAdulto = (Button)findViewById(R.id.btnCAdulto);
        CAdulto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CAdulto = new Intent(Carpetas.this, CarpetaInvestigacion.class);
                startActivity(CAdulto);
            }
        });
    }
}
