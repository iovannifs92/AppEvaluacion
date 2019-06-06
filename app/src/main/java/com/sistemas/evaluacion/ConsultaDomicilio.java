package com.sistemas.evaluacion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosGenerales;

import java.util.ArrayList;

public class ConsultaDomicilio extends AppCompatActivity {

    private Button btnLauncher;
    private MyOpenHelper db;
    private Spinner sConsultaDomicilio;
    private TextView tvCalleNumero;
    private TextView tvColonia;
    private TextView tvEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_domicilio);

        tvCalleNumero = (TextView) findViewById(R.id.tvCalleNumero);
        tvColonia = (TextView) findViewById(R.id.tvColonia);
        tvEstado = (TextView) findViewById(R.id.tvEstado);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        ArrayList<datosGenerales> lista;
        lista = db.getDatosGenerales();

        //region Inicializa un spinner con los nombres de los entrevistados
        sConsultaDomicilio = (Spinner) findViewById(R.id.sConsultaDomicilio);
        String[] names = new String[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            names[i] = lista.get(i).getNombre();
        }
        sConsultaDomicilio.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion

        //region Displays the selected address
        sConsultaDomicilio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<datosDomicilio> addresses;
                addresses = db.getDomicilios();

                tvCalleNumero.setText(addresses.get(position).getE7());
                tvColonia.setText(addresses.get(position).getE8());
                tvEstado.setText(addresses.get(position).getE10());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region Launches Google Maps directions to the selected interview
        btnLauncher = (Button) findViewById(R.id.GMapsLauncher);
        btnLauncher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<datosDomicilio> addresses;
                addresses = db.getDomicilios();

                int pos=sConsultaDomicilio.getSelectedItemPosition();
                Uri gmmIntentUri = Uri.parse("http://maps.google.com/maps?daddr=" + Uri.encode(
                        addresses.get(pos).getE7() + " " +
                                addresses.get(pos).getE8() + " " +
                                addresses.get(pos).getE9() + " " +
                                addresses.get(pos).getE10()));
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
