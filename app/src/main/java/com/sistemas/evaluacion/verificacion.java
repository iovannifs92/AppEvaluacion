package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sistemas.evaluacion.entidades.datosGenerales;

import java.util.ArrayList;

public class verificacion extends AppCompatActivity {

    //region Variables Globales
    private Spinner sVerificationName;
    private MyOpenHelper db;

    //region Boolean
    private boolean datosGenerales=false, datosFamiliares=false, datosEscolares=false, datosLaborales=false, datosFAestado=false, datosSalud=false;
    //endregion

    //region TextView
    private TextView tvP97, tvP100, tvO1;
    //endregion

    //region EditText
    private EditText etP1;
    //endregion

    //region CheckedTextView
    private CheckedTextView ctvP1, ctvP2, ctvP3, ctvP4, ctvP5;
    //endregion

    //region LinearLayout
    private LinearLayout llDatosGenerales, llDatosFamiliares, llDatosEscolares, llDatosLaborales, llFAEstado, llSalud;
    //endregion

    //region Button
    private Button btnDatosGenerales, btnDatosFamiliares, btnHistorialEscolar, btnHistorialLaboral, btnFAEstado, btnSalud;
    //endregion
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        ArrayList<datosGenerales> lista;
        lista = db.getDatosGenerales();

        //region Inicializa un spinner con los nombres de los entrevistados
        sVerificationName = (Spinner) findViewById(R.id.sVerificationName);
        String[] names = new String[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            names[i] = lista.get(i).getNombre();
        }
        sVerificationName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion

        sVerificationName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                //region 1. DATOS GENERALES
                ArrayList<datosGenerales> lista;
                lista = db.getDatosGenerales();

                tvP97 = (TextView) findViewById(R.id.tvP97);
                tvP97.setText(lista.get(pos).getFolio());

                tvP100 = (TextView) findViewById(R.id.tvP100);
                tvP100.setText(lista.get(pos).getTipo());

                ctvP1 = (CheckedTextView) findViewById(R.id.ctvP1);
                tvO1 = (TextView) findViewById(R.id.tvO1);
                etP1 = (EditText) findViewById(R.id.etP1);
                ctvP2 = (CheckedTextView) findViewById(R.id.ctvP2);
                ctvP3 = (CheckedTextView) findViewById(R.id.ctvP3);
                ctvP4 = (CheckedTextView) findViewById(R.id.ctvP4);
                ctvP5 = (CheckedTextView) findViewById(R.id.ctvP5);

                ctvP1.setText(lista.get(pos).getNombre());
                ctvP1.setChecked(true);
                ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);

                ctvP2.setText(lista.get(pos).getAlias());
                ctvP2.setChecked(true);
                ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);

                ctvP3.setText(lista.get(pos).getfEntrevista());
                ctvP3.setChecked(true);
                ctvP3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);

                ctvP4.setText(lista.get(pos).getEdad());
                ctvP4.setChecked(true);
                ctvP4.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);

                ctvP5.setText(lista.get(pos).getlNacimiento());
                ctvP5.setChecked(true);
                ctvP5.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);

                ctvP1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ctvP1.isChecked()) {
                            ctvP1.setChecked(false);
                            ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO1.setVisibility(View.GONE);
                            etP1.setVisibility(View.GONE);
                        }
                        else{
                            ctvP1.setChecked(true);
                            ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO1.setVisibility(View.VISIBLE);
                            etP1.setVisibility(View.VISIBLE);
                        }
                    }
                });

                ctvP2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(ctvP2.isChecked()) {
                            ctvP2.setChecked(false);
                            ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                        }
                        else{
                            ctvP2.setChecked(true);
                            ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                        }
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDatosGenerales=(Button) findViewById(R.id.btnDatosGenerales);
        llDatosGenerales=(LinearLayout) findViewById(R.id.llDatosGenerales);
        btnDatosFamiliares=(Button) findViewById(R.id.btnDatosFamiliares);
        llDatosFamiliares=(LinearLayout) findViewById(R.id.llDatosFamiliares);
        btnHistorialEscolar=(Button) findViewById(R.id.btnHistorialEscolar);
        llDatosEscolares=(LinearLayout) findViewById(R.id.llDatosEscolares);
        btnHistorialLaboral=(Button) findViewById(R.id.btnHistorialLaboral);
        llDatosLaborales=(LinearLayout) findViewById(R.id.llDatosLaborales);
        btnFAEstado=(Button) findViewById(R.id.btnFAEstado);
        llFAEstado=(LinearLayout) findViewById(R.id.llFAEstado);
        btnSalud=(Button) findViewById(R.id.btnSalud);
        llSalud=(LinearLayout) findViewById(R.id.llSalud);

        btnDatosGenerales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosGenerales){
                    llDatosGenerales.setVisibility(View.VISIBLE);
                    datosGenerales=true;
                }
                else{
                    llDatosGenerales.setVisibility(View.GONE);
                    datosGenerales=false;
                }
            }
        });

        btnDatosFamiliares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosFamiliares){
                    llDatosFamiliares.setVisibility(View.VISIBLE);
                    datosFamiliares=true;
                }
                else{
                    llDatosFamiliares.setVisibility(View.GONE);
                    datosFamiliares=false;
                }
            }
        });

        btnHistorialEscolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosEscolares){
                    llDatosEscolares.setVisibility(View.VISIBLE);
                    datosEscolares=true;
                }
                else{
                    llDatosEscolares.setVisibility(View.GONE);
                    datosEscolares=false;
                }
            }
        });

        btnHistorialLaboral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosLaborales){
                    llDatosLaborales.setVisibility(View.VISIBLE);
                    datosLaborales=true;
                }
                else{
                    llDatosLaborales.setVisibility(View.GONE);
                    datosLaborales=false;
                }
            }
        });

        btnFAEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosFAestado){
                    llFAEstado.setVisibility(View.VISIBLE);
                    datosFAestado=true;
                }
                else{
                    llFAEstado.setVisibility(View.GONE);
                    datosFAestado=false;
                }
            }
        });

        btnSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!datosSalud){
                    llSalud.setVisibility(View.VISIBLE);
                    datosSalud=true;
                }
                else{
                    llSalud.setVisibility(View.GONE);
                    datosSalud=false;
                }
            }
        });
    }
}
