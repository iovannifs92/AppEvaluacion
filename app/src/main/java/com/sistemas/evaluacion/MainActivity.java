package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.MyOpenHelper;

public class MainActivity extends AppCompatActivity {

    //region Variables Globales
    private MyOpenHelper db;
    private ArrayList<datosGenerales> lista;
    //private ArrayList<Comentario> lista;
    private TextView tvLista;
    public String tamaño="";
    ListToCSV convierte=new ListToCSV();
    //endregion

    //region Metodos

    //region OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new MyOpenHelper(this);

        //Contamos el número de registros
        lista=db.getDatosGenerales();
        //lista=db.getComments();
        tamaño=""+(lista.size());
        tvLista = (TextView) findViewById(R.id.tvLista);
        tvLista.setText(tamaño);
        //final List<String> list=lista;


        //Ir a segundo activity
        Button btnCambioActivity= (Button) findViewById(R.id.btnCambiarActivity);
        btnCambioActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), entrevista.class);
                //Intent intent= new Intent(view.getContext(), encuesta.class);
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
    //endregion

    //endregion

    //region Codigo prueba
    /*Button btnCambioActivityVerificacion=(Button) findViewById(R.id.btnCambiarActivityVerificacion);
        btnCambioActivityVerificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(view.getContext(), verificacion.class);
                startActivity(intent);
            }
        });*/
    //endregion

}
