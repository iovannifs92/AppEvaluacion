package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyOpenHelper db;
    private ArrayList<Comentario> lista;
    private TextView tvLista;

    ListToCSV convierte=new ListToCSV();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new MyOpenHelper(this);

        //Contamos el número de registros

        lista=db.getComments();
        String tamaño=""+(lista.size());
        tvLista = (TextView) findViewById(R.id.tvLista);
        tvLista.setText(tamaño);
        //final List<String> list=lista;


        //Ir a segundo activity
        Button btnCambioActivity= (Button) findViewById(R.id.btnCambiarActivity);
        btnCambioActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), entrevista.class);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(), "Presiono boton para ir a segundo activity", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnExport= (Button) findViewById(R.id.btnExport);
        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res=convierte.exportDB(getApplicationContext());

                if (res==true){
                    Toast.makeText(getApplicationContext(), "El archivo se guardo correctamente",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "El archivo NO se pudo guardar, ponerse en contacto con el administrador",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
