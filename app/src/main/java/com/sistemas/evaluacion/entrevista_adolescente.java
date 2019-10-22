package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sistemas.evaluacion.entidades.datosGenerales;

import java.util.ArrayList;

public class entrevista_adolescente extends AppCompatActivity {
    //region variables globales
    private MyOpenHelper db;
    private ArrayList<datosGenerales> lista;
    //endregion

    //region TextView
    private TextView tvNc;
    //endregion
    //region Boolean
    private  Boolean pR=false;
    //endregion

    //region EditText
    private EditText txtNc, txtFecha, txtNe, txtFolioA ,txtNpa1, txtNpa2, txtNpa3, txtNpa4, txtRa1, txtRa2, txtRa3, txtRa4, txtPOa1, txtPOa2, txtPOa3, txtPOa4, txtNa, txtEa, txtFNa, txtCURPa, txtLNa, txtEDOa, txtMa, txtLa, txtNAa ;
    //Ficha familiar Domicilio
    private EditText txtCa, txtNOa, txtCOLa, txtCPa, txtMUa, txtEDO2a, txtPa, txtTa, txtDALa1, txtDALa2, txtDALa3, txtDALa4, txtDATa1, txtDATa2, txtDATa3, txtDATa4;
    //Datos familiares
    private EditText txtNDFa1,txtNDFa2,txtNDFa3,txtNDFa4,txtRDFa1, txtRDFa2, txtRDFa3, txtRDFa4, txtEDFa1, txtEDFa2, txtEDFa3, txtEDFa4, txtTDFa1, txtTDFa2, txtTDFa3, txtTDFa4, txtVDF1, txtVDF2, txtVDF3, txtVDF4, txtCQDFa,txtRDFa,txtLDFa;
    //Dependientes economicos
    private EditText txtNDEa1,txtNDEa2,txtNDEa3,txtNDEa4, txtRDEa1,txtRDEa2,txtRDEa3,txtRDEa4,txtTDEa1,txtTDEa2,txtTDEa3,txtTDEa4,txtADE1,txtADE2,txtADE3,txtADE4;
    //Viculos comunitarios
    private EditText txtEAa,txtNEa,txtDEa,txtTea,txtNIEa,txtUGa,txtNEa1,txtNEa2,txtNEa3,txtNEa4,txtLE1,txtLE2,txtLE3,txtLE4,txtGC1,txtGC2,txtGC3,txtGC4;
    //Historial laboral
    private EditText txtTAa,txtNTa,txtDTa,txtTTa,txtATa,txtJTa,txtNT1,txtNT2,txtNT3,txtNT4,txtLT1,txtLT2,txtLT3,txtLT4,txtAT1,txtAT2,txtAT3,txtAT4,txtTT1,txtTT2,txtTT3,txtTT4;
    //actividades Extraescolares
    private EditText txtA1,txtA2,txtA3,txtA4,txtL1,txtL2,txtL3,txtL4,txtC1,txtC2,txtC3,txtC4;
    //Consideraciones Excepcionales
    private EditText txtCual;
    //endregion EditText


    //region Sppiners
    private Spinner a;
    //endregion
    //region LinearLayout
    private LinearLayout llPersonasPresentes;
    //endregionLinearLayout
    //region Buttons
    private Button btnGuardarA, btnPersonasPresentes;
    //endregion Buttons
    //regionCheckedTextView
    CheckedTextView s;
    //endregion

    //Region String
    private String r1A, r2A, r3A, r4A;
    //endregion String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista_adolescente);
        db=new MyOpenHelper(this);


            btnGuardarA=(Button) findViewById(R.id.btnGuardarA);
            btnGuardarA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnGuardarA.setEnabled(false);
                    //region Datos Generales
                    //region Difinicion de variables
                    txtNc=(EditText) findViewById(R.id.txtNc);
                    txtFecha=(EditText) findViewById(R.id.txtFecha);
                    txtNe=(EditText) findViewById(R.id.txtNe);
                    txtFolioA=(EditText) findViewById(R.id.txtFolioA);
                    //endregion variabels

                    r1A=txtNc.getText().toString().toUpperCase();
                    r2A=txtFecha.getText().toString().toUpperCase();
                    r3A=txtNe.getText().toString().toUpperCase();
                    r4A=txtFolioA.getText().toString().toUpperCase();
                    //endregion

                  // Base de datos  db.insertarDatosGeneralesA(r1A, r2A, r3A);

                }
            });
        btnPersonasPresentes=(Button) findViewById(R.id.btnPersonasPresentes);
        llPersonasPresentes=(LinearLayout) findViewById(R.id.llPersonasPresentes);

        btnPersonasPresentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llPersonasPresentes.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llPersonasPresentes.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

    }
}
