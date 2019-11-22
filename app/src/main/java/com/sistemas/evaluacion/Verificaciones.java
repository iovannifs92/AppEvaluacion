package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Verificaciones extends AppCompatActivity {
    Button VAdolescentes;
    Button VAdulto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificaciones);

        VAdolescentes = (Button)findViewById(R.id.btnVAdolescentes);
        VAdolescentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VAdolescentes = new Intent(Verificaciones.this, verificacionAdolecentes.class);
                startActivity(VAdolescentes);
            }
        });

        VAdulto = (Button)findViewById(R.id.btnVAdulto);
        VAdulto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent VAdulto = new Intent(Verificaciones.this, verificacion.class);
                startActivity(VAdulto);
            }
        });
    }
}
