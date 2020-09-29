package com.sistemas.evaluacion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosGeneralesA;


import java.util.ArrayList;

public class ConsultaDomicilioA extends AppCompatActivity {

    private Button btnLauncher1;
    private MyOpenHelper db;
    private Spinner sConsultaDomicilio1;
    private TextView tvCalleNumero1, tvEstado1, tvColonia1, tvControl1;
    LinearLayout llControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_domicilio2);

        tvCalleNumero1 = (TextView) findViewById(R.id.tvCalleNumero1);
        tvColonia1 = (TextView) findViewById(R.id.tvColonia1);
        tvEstado1 = (TextView) findViewById(R.id.tvEstado1);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        ArrayList<datosGeneralesA> lista1;
        lista1 = db.getdatosGeneralesA();

        ArrayList<datosFichaFamiliarA> ficha;
        ficha = db.getdatosFichaFamiliarA();

        //region Inicializa un spinner con los nombres de los entrevistados
        sConsultaDomicilio1 = (Spinner) findViewById(R.id.sConsultaDomicilio1);
        String[] names = new String[lista1.size()];
        for(int i = 0; i < lista1.size(); i++){
            names[i] = lista1.get(i).getAnombre()+" "+lista1.get(i).getApaterno()+" "+lista1.get(i).getAmaterno();
        }

        //region Verificar si hay registros
        if(lista1.size()!=0){
            tvControl1=(TextView) findViewById(R.id.tvControl1);
            llControl=(LinearLayout) findViewById(R.id.llControl);

            llControl.setVisibility(View.VISIBLE);
            tvControl1.setVisibility(View.GONE);
        }
        //endregion



        sConsultaDomicilio1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion

        //region Displays the selected address
        sConsultaDomicilio1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<datosFichaFamiliarA> ficha;
                ficha = db.getdatosFichaFamiliarA();

                tvCalleNumero1.setText(ficha.get(position).getAcalle()+" "+ ficha.get(position).getAnumero());
                tvColonia1.setText(ficha.get(position).getAcolonia());
                tvEstado1.setText(ficha.get(position).getAestado());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region Launches Google Maps directions to the selected interview
        btnLauncher1 = (Button) findViewById(R.id.GMapsLauncher);
        btnLauncher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<datosFichaFamiliarA> ficha;
                ficha = db.getdatosFichaFamiliarA();

                ArrayList<datosDomicilio> addresses;
                addresses = db.getDomicilios();

                int pos=sConsultaDomicilio1.getSelectedItemPosition();
                Uri gmmIntentUri;

                gmmIntentUri = Uri.parse("http://maps.google.com/maps?daddr=" + Uri.encode(ficha.get(pos).getAcalle() + " " +
                        ficha.get(pos).getAnumero() + " " + ficha.get(pos).getAnombrecol() + " " + ficha.get(pos).getAmunicipio() + " " +
                        ficha.get(pos).getAestado()));

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
        //endregion
    }
}
