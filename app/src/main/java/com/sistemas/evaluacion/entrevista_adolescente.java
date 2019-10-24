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

public class entrevista_adolescente extends AppCompatActivity {
    //region variables globales
    private MyOpenHelper db;


    //endregion

    //regio boolean
    private boolean pR=false;

    //region TextView
    //DOMICILIOS ANTERIORES
    private TextView tvDA1, tvDA2;
    //REUBICAR ADOLECENTE
    private TextView tvCQDFa, tvRDFa, tvLDFa;
    //DEPENDIENTES ECONOMICOS
    private TextView tvNDEa1,tvRDEa1,tvEDEa1,tvTDEa1;
    //DEPENDIENTES TRABAJO ACTUAL
    private TextView tvTA,tvNTa,tvDTa,tvTTa,tvATa,tvTC,tvJTa,tvNT1,tvNT2,tvNT3,tvNT4,tvLT1,tvLT2,tvLT3,tvLT4,tvAT1,tvAT2,tvAT3,tvAT4,tvTT1,tvTT2,tvTT3,tvTT4;
    //endregion

    //region EditText
    //datos generales
    private EditText txtNc, txtFecha, txtNe, txtFolioA ,txtNpa1, txtNpa2, txtNpa3, txtNpa4, txtRa1, txtRa2, txtRa3, txtRa4, txtPOa1, txtPOa2, txtPOa3, txtPOa4, txtNa, txtEa, txtFNa, txtCURPa, txtLNa, txtEDOa, txtMa, txtLa, txtNAa ;
    //Ficha familiar Domicilio
    private EditText txtCa, txtNOa, txtCOLa, txtCPa, txtMUa, txtEDO2a, txtPa, txtTa, txtDALa1, txtDALa2, txtDALa3, txtDALa4, txtDATa1, txtDATa2, txtDATa3, txtDATa4;
    //Datos familiares
    private EditText txtNDFa1,txtNDFa2,txtRDFa1, txtRDFa2,txtEDFa1, txtEDFa2,txtTDFa1, txtTDFa2,txtCQDFa,txtRDFa,txtLDFa;
    //Dependientes economicos
    private EditText txtNDEa1,txtNDEa2,txtNDEa3,txtNDEa4, txtRDEa1,txtRDEa2,txtRDEa3,txtRDEa4,txtEDEa1,txtEDEa2,txtEDEa3,txtEDEa4,txtTDEa1,txtTDEa2,txtTDEa3,txtTDEa4;
    //Viculos comunitarios
    private EditText txtNEa,txtDEa,txtTea,txtNIEa,txtUGa,txtNEa1,txtNEa2,txtNEa3,txtNEa4,txtLE1,txtLE2,txtLE3,txtLE4,txtGC1,txtGC2,txtGC3,txtGC4;
    //Historial laboral
    private EditText txtTAa,txtNTa,txtDTa,txtTTa,txtATa,txtJTa,txtNT1,txtNT2,txtNT3,txtNT4,txtLT1,txtLT2,txtLT3,txtLT4,txtAT1,txtAT2,txtAT3,txtAT4,txtTT1,txtTT2,txtTT3,txtTT4;
    //actividades Extraescolares
    private EditText txtA1,txtA2,txtA3,txtA4,txtL1,txtL2,txtL3,txtL4,txtC1,txtC2,txtC3,txtC4,txtT1,txtT2,txtT3,txtT4;
    //Infotmacion el caso actual
    private EditText txtFp,txtF,txtDi,txtNC1,txtNC2,txtNC3,txtNC4,txtNC5,txtNC6,txtD1,txtD2,txtD3,txtD4,txtD5,txtD6,txtTM1,txtTM2,txtTM3,txtTM4,txtTM5,txtTM6,txtE1,txtE2,txtE3,txtE4,txtE5,txtE6,txtEx1,txtEx2;
    //endregion EditText


    //reguin Sppiner
    private Spinner sPSex,sP1a,sPIdio,sPTra,sPDfa,sPVDF,sPDA,sPRD,sPDE,sPAR, sPAE,sPCS,sPTA,sPTR,sPTC,sPAEA,sPEE,sPEM,sPTE,sPC,sPCD,sPSIDA,sPEV;
    //region Sppiners

    //endregion
    //region LinearLayout
    private LinearLayout llDg,llFfa,llVH,llCE,llIC,llPP,llVO,llPL;
    //endregionLinearLayout
    //region Buttons
    private Button btnGuardarA,btnDg,btnFfa,btnVH,btnCE,btnIC,btnPP,btnVO,btnPL;
    //endregion Buttons
    //regionCheckedTextView
    CheckedTextView s;
    //endregion
    //region String
    private String r1A, r2A, r3A, r4A;
    private String [] nosi={"No", "Si"};
    private String [] sexo={"Masculino", "Femenino"};
    private String [] malo={"VIH/SIDA","Enfermedades cardiovasculares","Cáncer","Enfermedad Pulmonar Obstructiva Crónica","Diabetes","Parkinson","Alzheimer","Esclerosis múltiple","Hipertensión","Lumbalgia","Colesterol","Depresión","Ansiedad","Tiroides",
            "Osteoporosis"};

    //endregion String



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista_adolescente);
        db = new MyOpenHelper(this);


        //region DIFINICION TEXTEDIT
        //region DATOS GENERALES
        txtNc=(EditText) findViewById(R.id.txtNc);
        txtFecha=(EditText) findViewById(R.id.txtFecha);
        txtNe=(EditText) findViewById(R.id.txtNe);
        txtFolioA=(EditText) findViewById(R.id.txtFolioA);
        txtNpa1=(EditText) findViewById(R.id.txtNpa1);
        txtNpa2=(EditText) findViewById(R.id.txtNpa2);
        txtNpa3=(EditText) findViewById(R.id.txtNpa3);
        txtNpa4=(EditText) findViewById(R.id.txtNpa4);
        txtRa1=(EditText) findViewById(R.id.txtRa1);
        txtRa2=(EditText) findViewById(R.id.txtRa2);
        txtRa3=(EditText) findViewById(R.id.txtRa3);
        txtRa4=(EditText) findViewById(R.id.txtRa4);
        txtPOa1=(EditText) findViewById(R.id.txtPOa1);
        txtPOa2=(EditText) findViewById(R.id.txtPOa2);
        txtPOa3=(EditText) findViewById(R.id.txtPOa3);
        txtPOa4=(EditText) findViewById(R.id.txtPOa4);
        txtNa=(EditText) findViewById(R.id.txtNa);
        txtEa=(EditText) findViewById(R.id.txtEa);
        txtFNa=(EditText) findViewById(R.id.txtFNa);
        txtCURPa=(EditText) findViewById(R.id.txtCURPa);
        txtLNa=(EditText) findViewById(R.id.txtLNa);
        txtEDOa=(EditText) findViewById(R.id.txtEDOa);
        txtMa=(EditText) findViewById(R.id.txtMa);
        txtLa=(EditText) findViewById(R.id.txtLa);
        txtNAa=(EditText) findViewById(R.id.txtNAa);
        //endregion DATOS GENERALES
        //region FICHA FAMILIAR
        txtCa=(EditText) findViewById(R.id.txtCa);
        txtNOa=(EditText) findViewById(R.id.txtNOa);
        txtCOLa=(EditText) findViewById(R.id.txtCOLa);
        txtCPa=(EditText) findViewById(R.id.txtCPa);
        txtMUa=(EditText) findViewById(R.id.txtMUa);
        txtEDO2a=(EditText) findViewById(R.id.txtEDO2a);
        txtPa=(EditText) findViewById(R.id.txtPa);
        txtTa=(EditText) findViewById(R.id.txtTa);
        txtDALa1=(EditText) findViewById(R.id.txtDALa1);
        txtDALa2=(EditText) findViewById(R.id.txtDALa2);
        txtDATa3=(EditText) findViewById(R.id.txtDATa3);
        txtDATa4=(EditText) findViewById(R.id.txtDATa4);


        //endregion FICHA FAMILIAR
        //region DATOS FAMILIARES
        txtNDFa1=(EditText) findViewById(R.id.txtNDFa1);
        txtNDFa2=(EditText) findViewById(R.id.txtNDFa2);
        txtRDFa1=(EditText) findViewById(R.id.txtRDFa1);
        txtRDFa2=(EditText) findViewById(R.id.txtRDFa2);
        txtEDFa1=(EditText) findViewById(R.id.txtEDFa1);
        txtEDFa2=(EditText) findViewById(R.id.txtEDFa2);
        txtTDFa1=(EditText) findViewById(R.id.txtTDFa1);
        txtTDFa2=(EditText) findViewById(R.id.txtTDFa2);

        /*txtVDF1=(EditText) findViewById(R.id.txtVDF1);
        txtVDF2=(EditText) findViewById(R.id.txtVDF2);
        txtVDF3=(EditText) findViewById(R.id.txtVDF3);
        txtVDF4=(EditText) findViewById(R.id.txtVDF4);*/
        txtCQDFa=(EditText) findViewById(R.id.txtCQDFa);
        txtRDFa=(EditText) findViewById(R.id.txtRDFa);
        txtLDFa=(EditText) findViewById(R.id.txtLDFa);
        //endregion DATOS FAMILIARES
        //region DEPENDIENTES ECONOMICOS
        txtNDEa1=(EditText) findViewById(R.id.txtNDEa1);
        txtNDEa2=(EditText) findViewById(R.id.txtNDEa2);
        txtNDEa3=(EditText) findViewById(R.id.txtNDEa3);
        txtNDEa4=(EditText) findViewById(R.id.txtNDEa4);
        txtRDEa1=(EditText) findViewById(R.id.txtRDEa1);
        txtRDEa2=(EditText) findViewById(R.id.txtRDEa2);
        txtRDEa3=(EditText) findViewById(R.id.txtRDEa3);
        txtRDEa4=(EditText) findViewById(R.id.txtRDEa4);
        txtEDEa1=(EditText) findViewById(R.id.txtEDEa1);
        txtEDEa2=(EditText) findViewById(R.id.txtEDEa2);
        txtEDEa3=(EditText) findViewById(R.id.txtEDEa3);
        txtEDEa4=(EditText) findViewById(R.id.txtEDEa4);
        txtTDEa1=(EditText) findViewById(R.id.txtTDEa1);
        txtTDEa2=(EditText) findViewById(R.id.txtTDEa2);
        txtTDEa3=(EditText) findViewById(R.id.txtTDEa3);
        txtTDEa4=(EditText) findViewById(R.id.txtTDEa4);
        //endregion DEPENDIENTES ECONOMICOS
        //region VINCULOS COMUNITARIOS
        txtNEa=(EditText) findViewById(R.id.txtNEa);
        txtDEa=(EditText) findViewById(R.id.txtDEa);
        txtTea=(EditText) findViewById(R.id.txtTea);
        txtNIEa=(EditText) findViewById(R.id.txtNIEa);
        txtUGa=(EditText) findViewById(R.id.txtUGa);
        txtNEa1=(EditText) findViewById(R.id.txtNEa1);
        txtNEa2=(EditText) findViewById(R.id.txtNEa2);
        txtNEa3=(EditText) findViewById(R.id.txtNEa3);
        txtNEa4=(EditText) findViewById(R.id.txtNEa4);
        txtLE1=(EditText) findViewById(R.id.txtLE1);
        txtLE2=(EditText) findViewById(R.id.txtLE2);
        txtLE3=(EditText) findViewById(R.id.txtLE3);
        txtLE4=(EditText) findViewById(R.id.txtLE4);
        txtGC1=(EditText) findViewById(R.id.txtGC1);
        txtGC2=(EditText) findViewById(R.id.txtGC2);
        txtGC3=(EditText) findViewById(R.id.txtGC3);
        txtGC4=(EditText) findViewById(R.id.txtGC4);
        //endregion
        //region HISTORIAL LABORAL
        txtTAa=(EditText) findViewById(R.id.txtTAa);
        txtNTa=(EditText) findViewById(R.id.txtNTa);
        txtDTa=(EditText) findViewById(R.id.txtDTa);
        txtTTa=(EditText) findViewById(R.id.txtTTa);
        txtATa=(EditText) findViewById(R.id.txtATa);
        txtJTa=(EditText) findViewById(R.id.txtJTa);
        txtNT1=(EditText) findViewById(R.id.txtNT1);
        txtNT2=(EditText) findViewById(R.id.txtNT2);
        txtNT3=(EditText) findViewById(R.id.txtNT3);
        txtNT4=(EditText) findViewById(R.id.txtNT4);
        txtLT1=(EditText) findViewById(R.id.txtLT1);
        txtLT2=(EditText) findViewById(R.id.txtLT2);
        txtLT3=(EditText) findViewById(R.id.txtLT3);
        txtLT4=(EditText) findViewById(R.id.txtLT4);
        txtAT1=(EditText) findViewById(R.id.txtAT1);
        txtAT2=(EditText) findViewById(R.id.txtAT2);
        txtAT3=(EditText) findViewById(R.id.txtAT3);
        txtAT4=(EditText) findViewById(R.id.txtAT4);
        txtTT1=(EditText) findViewById(R.id.txtTT1);
        txtTT2=(EditText) findViewById(R.id.txtTT2);
        txtTT3=(EditText) findViewById(R.id.txtTT3);
        txtTT4=(EditText) findViewById(R.id.txtTT4);
        //endregion
        //region ACTIVIDADRES EXTRAESCOLARES
        txtA1=(EditText) findViewById(R.id.txtA1);
        txtA2=(EditText) findViewById(R.id.txtA2);
        txtA3=(EditText) findViewById(R.id.txtA3);
        txtA4=(EditText) findViewById(R.id.txtA4);
        txtL1=(EditText) findViewById(R.id.txtL1);
        txtL2=(EditText) findViewById(R.id.txtL2);
        txtL3=(EditText) findViewById(R.id.txtL3);
        txtL4=(EditText) findViewById(R.id.txtL4);
        txtC1=(EditText) findViewById(R.id.txtC1);
        txtC2=(EditText) findViewById(R.id.txtC2);
        txtC3=(EditText) findViewById(R.id.txtC3);
        txtC4=(EditText) findViewById(R.id.txtC4);
        txtT1=(EditText) findViewById(R.id.txtT1);
        txtT2=(EditText) findViewById(R.id.txtT2);
        txtT3=(EditText) findViewById(R.id.txtT3);
        txtT4=(EditText) findViewById(R.id.txtT4);
        //endregion
        /*//region INFORMACION DE CASO ACTUAL
        txtFp=(EditText) findViewById(R.id.txtFp);
        txtF=(EditText) findViewById(R.id.txtF);
        txtDi=(EditText) findViewById(R.id.txtDi);
        txtNC1=(EditText) findViewById(R.id.txtNC1);
        txtNC2=(EditText) findViewById(R.id.txtNC2);
        txtNC3=(EditText) findViewById(R.id.txtNC3);
        txtNC4=(EditText) findViewById(R.id.txtNC4);
        txtNC5=(EditText) findViewById(R.id.txtNC5);
        txtNC6=(EditText) findViewById(R.id.txtNC6);
        txtD1=(EditText) findViewById(R.id.txtD1);
        txtD2=(EditText) findViewById(R.id.txtD2);
        txtD3=(EditText) findViewById(R.id.txtD3);
        txtD4=(EditText) findViewById(R.id.txtD4);
        txtD5=(EditText) findViewById(R.id.txtD5);
        txtD6=(EditText) findViewById(R.id.txtD6);
        txtTM1=(EditText) findViewById(R.id.txtTM1);
        txtTM2=(EditText) findViewById(R.id.txtTM2);
        txtTM3=(EditText) findViewById(R.id.txtTM3);
        txtTM4=(EditText) findViewById(R.id.txtTM4);
        txtTM5=(EditText) findViewById(R.id.txtTM5);
        txtTM6=(EditText) findViewById(R.id.txTM6);
        txtE1=(EditText) findViewById(R.id.txtE1);
        txtE2=(EditText) findViewById(R.id.txtE2);
        txtE3=(EditText) findViewById(R.id.txtE3);
        txtE4=(EditText) findViewById(R.id.txtE4);
        txtE5=(EditText) findViewById(R.id.txtE5);
        txtE6=(EditText) findViewById(R.id.txtE6);
        txtEx1=(EditText) findViewById(R.id.txtEx1);
        txtEx2=(EditText) findViewById(R.id.txtEx2);
        //endregion*/
        //endregion variabels
        //region DIFINICION DE TEXTVIEW
        //region DOMICILIOS ANTERIORES
        tvDA1=(TextView) findViewById(R.id.tvDA1);
        tvDA2=(TextView) findViewById(R.id.tvDA2);
        //endregion
        //region REUBICAR ADOLECENTE
        tvCQDFa=(TextView) findViewById(R.id.tvCQDFa);
        tvRDFa=(TextView) findViewById(R.id.tvRDFa);
        tvLDFa=(TextView) findViewById(R.id.tvLDFa);
        //endregion

        //region DEPENDIENTES ECONOMICOS
        tvNDEa1=(TextView) findViewById(R.id.tvNDEa1);

        tvRDEa1=(TextView) findViewById(R.id.tvRDEa1);

        tvEDEa1=(TextView) findViewById(R.id.tvEDEa1);

        tvTDEa1=(TextView) findViewById(R.id.tvTDEa1);

        //endregion
        //region TRABAJO ACTUAL
        tvTA=(TextView) findViewById(R.id.tvTA);
        tvNTa=(TextView) findViewById(R.id.tvNTa);
        tvDTa=(TextView) findViewById(R.id.tvDTa);
        tvTTa=(TextView) findViewById(R.id.tvTTa);
        tvATa=(TextView) findViewById(R.id.tvATa);
        tvTC=(TextView) findViewById(R.id.tvTC);
        tvJTa=(TextView) findViewById(R.id.tvJTa);
        tvNT1=(TextView) findViewById(R.id.tvNT1);
        tvLT1=(TextView) findViewById(R.id.tvLT1);
        tvAT1=(TextView) findViewById(R.id.tvAT1);
        tvTT1=(TextView) findViewById(R.id.tvTT1);
        //endregion
        //endregion





        //region sP1a Spinner
        sP1a = (Spinner) findViewById(R.id.sP1a);
        sP1a.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPSes
        sPSex = (Spinner) findViewById(R.id.sPSex);
        sPSex.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sexo));
        //endregion
        // region sPIdio
        sPIdio = (Spinner) findViewById(R.id.sPIdio);
        sPIdio.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTra
        sPTra = (Spinner) findViewById(R.id.sPTra);
        sPTra.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPDfa
        sPDfa = (Spinner) findViewById(R.id.sPDfa);
        sPDfa.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPVDF
        sPVDF = (Spinner) findViewById(R.id.sPVDF);
        sPVDF.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPAR  ADOLECENTE REubicado
        sPAR = (Spinner) findViewById(R.id.sPAR);
        sPAR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPAR  ADOLECENTE RESPONSABLE
        sPAR = (Spinner) findViewById(R.id.sPAR);
        sPAR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPCS  CONCLUYO LA SECUNDARIA
        sPCS = (Spinner) findViewById(R.id.sPCS);
        sPCS.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTR  TRABAJO RECURRENTE
        sPTR = (Spinner) findViewById(R.id.sPTR);
        sPTR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTC  TIEMPO COMPLETO
        sPTC = (Spinner) findViewById(R.id.sPTC);
        sPTC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        /*// region sPEE  ESTA ENBARAZADA
        sPEE = (Spinner) findViewById(R.id.sPEE);
        sPEE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPEM  ES MADRE
        sPEM = (Spinner) findViewById(R.id.sPEM);
        sPEM.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTE  TIENE ENFERMEDAD
        sPTE = (Spinner) findViewById(R.id.sPTE);
        sPTE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPC  CUAL?
        sPC = (Spinner) findViewById(R.id.sPC);
        sPC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, malo));
        //endregion

        // region sPCD  CUENTA CON DISCAPACIDAD
        sPCD = (Spinner) findViewById(R.id.sPCD);
        sPCD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion

        // region sPCD  CUENTA CON DISCAPACIDAD
        sPSIDA = (Spinner) findViewById(R.id.sPSIDA);
        sPSIDA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPCD  CEVALUADOR
        sPEV = (Spinner) findViewById(R.id.sPEV);
        sPEV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
*/



        //region VisibleSpinner
        // region sPDA DOMICILIOS ANTERIORES
        sPDA = (Spinner) findViewById(R.id.sPDA);
        sPDA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));

        sPDA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtDALa1.setVisibility(View.VISIBLE);
                    txtDALa2.setVisibility(View.VISIBLE);
                    txtDATa3.setVisibility(View.VISIBLE);
                    txtDATa4.setVisibility(View.VISIBLE);
                    tvDA1.setVisibility(View.VISIBLE);
                    tvDA2.setVisibility(View.VISIBLE);


                }
                else{
                    txtDALa1.setVisibility(View.GONE);
                    txtDALa2.setVisibility(View.GONE);
                    txtDATa3.setVisibility(View.GONE);
                    txtDATa4.setVisibility(View.GONE);
                    tvDA1.setVisibility(View.GONE);
                    tvDA2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });


        //endregion
        // region sPRD REUBICA DOMICILIO
        sPRD = (Spinner) findViewById(R.id.sPRD);
        sPRD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPRD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtCQDFa.setVisibility(View.VISIBLE);
                    txtRDFa.setVisibility(View.VISIBLE);
                    txtLDFa.setVisibility(View.VISIBLE);
                    tvCQDFa.setVisibility(View.VISIBLE);
                    tvRDFa.setVisibility(View.VISIBLE);
                    tvLDFa.setVisibility(View.VISIBLE);
                }
                else{
                    txtCQDFa.setVisibility(View.GONE);
                    txtRDFa.setVisibility(View.GONE);
                    txtLDFa.setVisibility(View.GONE);
                    tvCQDFa.setVisibility(View.GONE);
                    tvRDFa.setVisibility(View.GONE);
                    tvLDFa.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });



        //endregion
        // region sPDE DEPENDIENTES ECONOMICOS
        sPDE = (Spinner) findViewById(R.id.sPDE);
        sPDE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPDE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    txtNDEa1.setVisibility(View.VISIBLE);
                    txtNDEa2.setVisibility(View.VISIBLE);
                    txtNDEa3.setVisibility(View.VISIBLE);
                    txtNDEa4.setVisibility(View.VISIBLE);
                    txtRDEa1.setVisibility(View.VISIBLE);
                    txtRDEa2.setVisibility(View.VISIBLE);
                    txtRDEa3.setVisibility(View.VISIBLE);
                    txtRDEa4.setVisibility(View.VISIBLE);
                    txtEDEa1.setVisibility(View.VISIBLE);
                    txtEDEa2.setVisibility(View.VISIBLE);
                    txtEDEa3.setVisibility(View.VISIBLE);
                    txtEDEa4.setVisibility(View.VISIBLE);
                    txtTDEa1.setVisibility(View.VISIBLE);
                    txtTDEa2.setVisibility(View.VISIBLE);
                    txtTDEa3.setVisibility(View.VISIBLE);
                    txtTDEa4.setVisibility(View.VISIBLE);
                    tvNDEa1.setVisibility(View.VISIBLE);

                    tvRDEa1.setVisibility(View.VISIBLE);

                    tvEDEa1.setVisibility(View.VISIBLE);

                    tvTDEa1.setVisibility(View.VISIBLE);

                }
                else{
                    txtNDEa1.setVisibility(View.GONE);
                    txtNDEa2.setVisibility(View.GONE);
                    txtNDEa3.setVisibility(View.GONE);
                    txtNDEa4.setVisibility(View.GONE);
                    txtRDEa1.setVisibility(View.GONE);
                    txtRDEa2.setVisibility(View.GONE);
                    txtRDEa3.setVisibility(View.GONE);
                    txtRDEa4.setVisibility(View.GONE);
                    txtEDEa1.setVisibility(View.GONE);
                    txtEDEa2.setVisibility(View.GONE);
                    txtEDEa3.setVisibility(View.GONE);
                    txtEDEa4.setVisibility(View.GONE);
                    txtTDEa1.setVisibility(View.GONE);
                    txtTDEa2.setVisibility(View.GONE);
                    txtTDEa3.setVisibility(View.GONE);
                    txtTDEa4.setVisibility(View.GONE);
                    tvNDEa1.setVisibility(View.GONE);

                    tvRDEa1.setVisibility(View.GONE);

                    tvEDEa1.setVisibility(View.GONE);

                    tvTDEa1.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion
        //region sPAE ESCUELA ACTUAL
        sPAE = (Spinner) findViewById(R.id.sPAE);
        sPAE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));



        //endregion
        // region sPTA  TRABAJOA ACTUALMENTE
        sPTA = (Spinner) findViewById(R.id.sPTA);
        sPTA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtTAa.setVisibility(View.VISIBLE);
                    txtNTa.setVisibility(View.VISIBLE);
                    txtDTa.setVisibility(View.VISIBLE);
                    txtTTa.setVisibility(View.VISIBLE);
                    txtATa.setVisibility(View.VISIBLE);
                    txtJTa.setVisibility(View.VISIBLE);
                    txtNT1.setVisibility(View.VISIBLE);
                    txtNT2.setVisibility(View.VISIBLE);
                    txtNT3.setVisibility(View.VISIBLE);
                    txtNT4.setVisibility(View.VISIBLE);
                    txtLT1.setVisibility(View.VISIBLE);
                    txtLT2.setVisibility(View.VISIBLE);
                    txtLT3.setVisibility(View.VISIBLE);
                    txtLT4.setVisibility(View.VISIBLE);
                    txtAT1.setVisibility(View.VISIBLE);
                    txtAT2.setVisibility(View.VISIBLE);
                    txtAT3.setVisibility(View.VISIBLE);
                    txtAT4.setVisibility(View.VISIBLE);
                    txtTT1.setVisibility(View.VISIBLE);
                    txtTT2.setVisibility(View.VISIBLE);
                    txtTT3.setVisibility(View.VISIBLE);
                    txtTT4.setVisibility(View.VISIBLE);
                    tvTA.setVisibility(View.VISIBLE);
                    tvNTa.setVisibility(View.VISIBLE);
                    tvDTa.setVisibility(View.VISIBLE);
                    tvTTa.setVisibility(View.VISIBLE);
                    tvATa.setVisibility(View.VISIBLE);
                    tvTC.setVisibility(View.VISIBLE);
                    tvJTa.setVisibility(View.VISIBLE);
                    tvNT1.setVisibility(View.VISIBLE);
                    tvNT2.setVisibility(View.VISIBLE);
                    tvNT3.setVisibility(View.VISIBLE);
                    tvNT4.setVisibility(View.VISIBLE);
                    tvLT1.setVisibility(View.VISIBLE);
                    tvLT2.setVisibility(View.VISIBLE);
                    tvLT3.setVisibility(View.VISIBLE);
                    tvLT4.setVisibility(View.VISIBLE);
                    tvAT1.setVisibility(View.VISIBLE);
                    tvAT2.setVisibility(View.VISIBLE);
                    tvAT3.setVisibility(View.VISIBLE);
                    tvAT4.setVisibility(View.VISIBLE);
                    tvTT1.setVisibility(View.VISIBLE);
                    tvTT2.setVisibility(View.VISIBLE);
                    tvTT3.setVisibility(View.VISIBLE);
                    tvTT4.setVisibility(View.VISIBLE);
                }
                else{
                    txtTAa.setVisibility(View.GONE);
                    txtNTa.setVisibility(View.GONE);
                    txtDTa.setVisibility(View.GONE);
                    txtTTa.setVisibility(View.GONE);
                    txtATa.setVisibility(View.GONE);
                    txtJTa.setVisibility(View.GONE);
                    txtNT1.setVisibility(View.GONE);
                    txtNT2.setVisibility(View.GONE);
                    txtNT3.setVisibility(View.GONE);
                    txtNT4.setVisibility(View.GONE);
                    txtLT1.setVisibility(View.GONE);
                    txtLT2.setVisibility(View.GONE);
                    txtLT3.setVisibility(View.GONE);
                    txtLT4.setVisibility(View.GONE);
                    txtAT1.setVisibility(View.GONE);
                    txtAT2.setVisibility(View.GONE);
                    txtAT3.setVisibility(View.GONE);
                    txtAT4.setVisibility(View.GONE);
                    txtTT1.setVisibility(View.GONE);
                    txtTT2.setVisibility(View.GONE);
                    txtTT3.setVisibility(View.GONE);
                    txtTT4.setVisibility(View.GONE);
                    tvTA.setVisibility(View.GONE);
                    tvNTa.setVisibility(View.GONE);
                    tvDTa.setVisibility(View.GONE);
                    tvTTa.setVisibility(View.GONE);
                    tvATa.setVisibility(View.GONE);
                    tvJTa.setVisibility(View.GONE);
                    tvNT1.setVisibility(View.GONE);
                    tvNT2.setVisibility(View.GONE);
                    tvNT3.setVisibility(View.GONE);
                    tvNT4.setVisibility(View.GONE);
                    tvLT1.setVisibility(View.GONE);
                    tvLT2.setVisibility(View.GONE);
                    tvLT3.setVisibility(View.GONE);
                    tvLT4.setVisibility(View.GONE);
                    tvAT1.setVisibility(View.GONE);
                    tvAT2.setVisibility(View.GONE);
                    tvAT3.setVisibility(View.GONE);
                    tvAT4.setVisibility(View.GONE);
                    tvTT1.setVisibility(View.GONE);
                    tvTT2.setVisibility(View.GONE);
                    tvTT3.setVisibility(View.GONE);
                    tvTT4.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });


        //endregion
        // region sPAEA  TACTIVIDADES EXTRAESCOLARES ACTUALES
        sPAEA = (Spinner) findViewById(R.id.sPAEA);
        sPAEA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));




        //endregion
        //endregion VisibleSpinner










        btnGuardarA=(Button) findViewById(R.id.btnGuardarA);
        btnGuardarA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnGuardarA.setEnabled(false);
                //region Datos Generales
                r1A=txtNc.getText().toString().toUpperCase();
                r2A=txtFecha.getText().toString().toUpperCase();
                r3A=txtNe.getText().toString().toUpperCase();
                r4A=txtFolioA.getText().toString().toUpperCase();
                //endregion

                // Base de datos  db.insertarDatosGeneralesA(r1A, r2A, r3A);

            }
        });

        btnDg=(Button) findViewById(R.id.btnDg);
        llDg=(LinearLayout) findViewById(R.id.llDg);
        btnFfa=(Button) findViewById(R.id.btnFfa);
        llFfa=(LinearLayout) findViewById(R.id.llFfa);
        btnVH=(Button) findViewById(R.id.btnVH);
        llVH=(LinearLayout) findViewById(R.id.llVH);
        btnCE=(Button) findViewById(R.id.btnCE);
        llCE=(LinearLayout) findViewById(R.id.llCE);
       btnIC=(Button) findViewById(R.id.btnIC);
        llIC=(LinearLayout) findViewById(R.id.llIC);
        /*btnPP=(Button) findViewById(R.id.btnPP);
        llPP=(LinearLayout) findViewById(R.id.llPP);
        btnVO=(Button) findViewById(R.id.btnVO);
        llVO=(LinearLayout) findViewById(R.id.llVO);
        btnPL=(Button) findViewById(R.id.btnPL);
        llPL=(LinearLayout) findViewById(R.id.llPL);*/

        //region Visibles

        btnDg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llDg.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llDg.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });


        btnFfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llFfa.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llFfa.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnVH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llVH.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llVH.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llCE.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llCE.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llIC.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llIC.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

       /* btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llPP.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llPP.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

        btnVO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llVO.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llVO.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

        btnPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llPL.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llPL.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });*/
        //endregion



    }
}
