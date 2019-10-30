package com.sistemas.evaluacion;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosGenerales;

import java.util.ArrayList;
import java.util.Date;

public class entrevista_adolescente extends AppCompatActivity {
    //region variables globales
    private MyOpenHelper db;


    //endregion

    //regio boolean
    private boolean pR=false;

    //region TextView
    //DOMICILIOS ANTERIORES
    private TextView tvDA1, tvDA2,tvDATa1,tvDALa3,tvDATa3;
    //REUBICAR ADOLECENTE
    private TextView tvCQDFa, tvRDFa, tvLDFa;
    //DEPENDIENTES ECONOMICOS
    private TextView tvNDEa1,tvRDEa1,tvEDEa1,tvTDEa1,tvNDEa2,tvRDEa2,tvEDEa2,tvTDEa2,tvNDEa3,tvRDEa3,tvEDEa3,tvTDEa3,tvAR,tvAR2,tvAR3;
    //DEPENDIENTES TRABAJO ACTUAL
    private TextView tvTA,tvNTa,tvDTa,tvTTa,tvATa,tvTC,tvJTa,tvNT1,tvLT1,tvAT1,tvTT1;
    ///////ESCUELAS ANTERIORES
    private TextView tvNEa1,tvLE1,tvGC1;
    //////////ACTIVIDADRES EXTRAESCOLARES
    private TextView tvA1,tvL1,tvC1,tvCT;
    /////////////CONSUMOS
    private TextView tvA,tvFREA,tvCaA,tvFDCA,tvT,tvFRET,tvCaT,tvFDCT,tvMAR,tvFREMAR,tvCaMAR,tvFDCMAR,tvPAS,tvFREPAS,tvCaPAS,tvFDCPAS,tvSOL,tvFRESOL,tvCaSOL,tvFDCSOL,tvMET,tvFREMET,tvCaMET,tvFDCMET,tvCOCA,tvFRECOCA,tvCaCOCA,tvFDCCOCA;


    //region EditText
    //datos generales
    private EditText txtNc, txtFecha, txtNe, txtFolioA ,txtNpa1, txtNpa2, txtNpa3, txtNpa4, txtRa1, txtRa2, txtRa3, txtRa4, txtPOa1, txtPOa2, txtPOa3, txtPOa4, txtNa, txtEa, txtFNa, txtCURPa, txtLNa, txtEDOa, txtMa, txtLa, txtNAa ;
    //Ficha familiar Domicilio
    private EditText txtCa, txtNOa, txtCOLa, txtCPa, txtMUa, txtEDO2a, txtPa, txtTa, txtDALa1, txtDALa2,txtDALa3,txtDATa3,txtDATa4,txtDATa1;
    //Datos familiares
    private EditText txtNDFa1,txtNDFa2,txtRDFa1, txtRDFa2,txtEDFa1, txtEDFa2,txtTDFa1, txtTDFa2,txtCQDFa,txtRDFa,txtLDFa;
    //Dependientes economicos
    private EditText txtNDEa1,txtNDEa2,txtNDEa3,txtRDEa1,txtRDEa2,txtRDEa3,txtEDEa1,txtEDEa2,txtEDEa3,txtTDEa1,txtTDEa2,txtTDEa3;
    //Viculos comunitarios
    private EditText txtNEa,txtDEa,txtTea,txtNIEa,txtUGa,txtNEa1,txtNEa2,txtLE1,txtLE2,txtGC1,txtGC2;
    //Historial laboral
    private EditText txtTAa,txtNTa,txtDTa,txtTTa,txtATa,txtJTa,txtNT1,txtLT1,txtAT1,txtTT1;
    //actividades Extraescolares
    private EditText txtA1,txtL1,txtC1,txtT1;
    //Consumo de sustancias
    private EditText txtCaA,txtCaT,txtFDCA,txtFDCT,txtFDCMAR,txtCaMAR,txtFDCPAS,txtCaPAS,txtFDCSOL,txtCaSOL,txtFDCMET,txtCaMET,txtCaCOCA,txtFDCCOCA;





    //reguin Sppiner
    private Spinner sPSex,sP1a,sPIdio,sPTra,sPDfa,sPVDF1,sPVDF2,sPVDF3,sPDA,sPRD,sPDE,sPAR1,sPAR2,sPAR3, sPAE,sPCS,sPTA,sPTR,sPTAA,sPTC,sPAEA,sPEE,sPEM,sPTE,sPC,sPCD,sPSIDA,sPEV,sPTI,sPUA,sPLO,sPMC,sPHO,sPTP,sPSL,sPEVO,sPVD,sPVV,sPEVS,sPCV,sPDV,sPEVF,SE,SA;
    //region Sppiners
    private Spinner sPALC,sPTBC,sPSOL,sPMAR,sPCOCA,sPPAS,sPMET,sPCALC,sPCTBC,sPCSOL,sPCMAR,sPCCOCA,sPCPAS,sPCMET;
    //endregion
    //region LinearLayout
    private LinearLayout llDg,llFfa,llVH,llCE,llIC;
    //endregionLinearLayout
    //region Buttons
    private Button btnGuardarA,btnDg,btnFfa,btnVH,btnCE,btnIC;
    //endregion Buttons
    //regionCheckedTextView
    CheckedTextView s;
    //endregion
    //region String
    private String r1A,r2A,r3A,r4A,r5A,r6A,r7A,r8A,r9A,r10A,r11A,r12A,r13A,r14A,r15A,r16A,r17A,r18A,r19A,r20A,r21A,r22A,r23A,r24A,
            r25A,r26A,r27A,r28A,r29A,r30A,r31A,r32A,r33A,r34A,r35A,r36A,r37A,r38A,r39A,r40A,r41A,r42A,r43A,r44A,r45A,r46A,r47A,r48A,
            r49A,r50A,r51A,r52A,r53A,r54A,r55A,r56A,r57A,r58A,r59A,r60A,r61A,r62A,r63A,r64A,r65A,r66A,r67A,r68A,r69A,r70A,r71A,r72A,
            r73A,r74A,r75A,r76A,r77A,r78A,r79A,r80A,r81A,r82A,r83A,r84A,r85A,r86A,r87A,r88A,r89A,r90A,r91A,r92A,r93A,r94A,r95A,r96A,r97A,r98A,
            r99A,r100A;
    //SPINNERS
    private String rS1,rS2,rS3,rS4,rS5,rS6,rS7,rS8,rS9,rS10,rS11,rS12,rS13,rS14,rS15,rS16,rS17,rS18,rS19,rS20,rS21,rS22,rS23,rS24,rS25,rS26,rS27,rS28,rS29,rS30,rS31,rS32,rS33;

    private String [] nosi={"No", "Si"};
    private String [] sexo={"Masculino", "Femenino"};
    private String [] malo={"VIH/SIDA","Enfermedades cardiovasculares","Cáncer","Enfermedad Pulmonar Obstructiva Crónica","Diabetes","Parkinson","Alzheimer","Esclerosis múltiple","Hipertensión","Lumbalgia","Colesterol","Depresión","Ansiedad","Tiroides",
            "Osteoporosis"};
    ////////Consumo//////////////7
    private String [] frecuenciaConsumo={"No consume", "Diariamente", "Cada Tercer día", "Semanalmente", "Quincenalmente", "Mensualmente", "Anualmente"};


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
        txtRa1=(EditText) findViewById(R.id.txtRa1);
        txtRa2=(EditText) findViewById(R.id.txtRa2);
        txtPOa1=(EditText) findViewById(R.id.txtPOa1);
        txtPOa2=(EditText) findViewById(R.id.txtPOa2);
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
        txtDALa3=(EditText) findViewById(R.id.txtDALa3);


        txtDATa3=(EditText) findViewById(R.id.txtDATa3);
        txtDATa1=(EditText) findViewById(R.id.txtDATa1);
        txtDATa1=(EditText) findViewById(R.id.txtDATa1);



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
        txtCQDFa=(EditText) findViewById(R.id.txtCQDFa);
        txtRDFa=(EditText) findViewById(R.id.txtRDFa);
        txtLDFa=(EditText) findViewById(R.id.txtLDFa);
        //endregion DATOS FAMILIARES
        //region DEPENDIENTES ECONOMICOS
        txtNDEa1=(EditText) findViewById(R.id.txtNDEa1);
        txtNDEa2=(EditText) findViewById(R.id.txtNDEa2);
        txtNDEa3=(EditText) findViewById(R.id.txtNDEa3);

        txtRDEa1=(EditText) findViewById(R.id.txtRDEa1);
        txtRDEa2=(EditText) findViewById(R.id.txtRDEa2);
        txtRDEa3=(EditText) findViewById(R.id.txtRDEa3);

        txtEDEa1=(EditText) findViewById(R.id.txtEDEa1);
        txtEDEa2=(EditText) findViewById(R.id.txtEDEa2);
        txtEDEa3=(EditText) findViewById(R.id.txtEDEa3);

        txtTDEa1=(EditText) findViewById(R.id.txtTDEa1);
        txtTDEa2=(EditText) findViewById(R.id.txtTDEa2);
        txtTDEa3=(EditText) findViewById(R.id.txtTDEa3);

        //endregion DEPENDIENTES ECONOMICOS
        //region VINCULOS COMUNITARIOS
        txtNEa=(EditText) findViewById(R.id.txtNEa);
        txtDEa=(EditText) findViewById(R.id.txtDEa);
        txtTea=(EditText) findViewById(R.id.txtTea);
        txtNIEa=(EditText) findViewById(R.id.txtNIEa);
        txtUGa=(EditText) findViewById(R.id.txtUGa);
        txtNEa1=(EditText) findViewById(R.id.txtNEa1);
        txtNEa2=(EditText) findViewById(R.id.txtNEa2);

        txtLE1=(EditText) findViewById(R.id.txtLE1);
        txtLE2=(EditText) findViewById(R.id.txtLE2);

        txtGC1=(EditText) findViewById(R.id.txtGC1);
        txtGC2=(EditText) findViewById(R.id.txtGC2);


        //endregion
        //region HISTORIAL LABORAL
        txtTAa=(EditText) findViewById(R.id.txtTAa);
        txtNTa=(EditText) findViewById(R.id.txtNTa);
        txtDTa=(EditText) findViewById(R.id.txtDTa);
        txtTTa=(EditText) findViewById(R.id.txtTTa);
        txtATa=(EditText) findViewById(R.id.txtATa);
        txtJTa=(EditText) findViewById(R.id.txtJTa);
        txtNT1=(EditText) findViewById(R.id.txtNT1);
        txtLT1=(EditText) findViewById(R.id.txtLT1);
        txtAT1=(EditText) findViewById(R.id.txtAT1);
        txtTT1=(EditText) findViewById(R.id.txtTT1);
        //endregion
        //region ACTIVIDADRES EXTRAESCOLARES
        txtA1=(EditText) findViewById(R.id.txtA1);
        txtL1=(EditText) findViewById(R.id.txtL1);
        txtC1=(EditText) findViewById(R.id.txtC1);
        txtT1=(EditText) findViewById(R.id.txtT1);
        //endregion
        //region CONSUMOS/////////////////////////////
        tvA=(TextView) findViewById(R.id.tvA);
        tvFREA=(TextView) findViewById(R.id.tvFREA);
        tvCaA=(TextView) findViewById(R.id.tvCaA);
        txtCaA=(EditText)findViewById(R.id.txtCaA);
        tvFDCA=(TextView)findViewById(R.id.tvFDCA);
        txtFDCA=(EditText)findViewById(R.id.txtFDCA);


        tvT=(TextView) findViewById(R.id.tvT);
        tvFRET=(TextView) findViewById(R.id.tvFRET);
        tvCaT=(TextView) findViewById(R.id.tvCaT);
        txtCaT=(EditText) findViewById(R.id.txtCaT);
        tvFDCT=(TextView) findViewById(R.id.tvFDCT);
        txtFDCT=(EditText) findViewById(R.id.txtFDCT);

        tvMAR=(TextView) findViewById(R.id.tvMAR);
        tvFREMAR=(TextView) findViewById(R.id.tvFREMAR);
        tvCaMAR=(TextView) findViewById(R.id.tvCaMAR);
        txtCaMAR=(EditText) findViewById(R.id.txtCaMAR);
        tvFDCMAR=(TextView) findViewById(R.id.tvFDCMAR);
        txtFDCMAR=(EditText) findViewById(R.id.txtFDCMAR);

        tvPAS=(TextView) findViewById(R.id.tvPAS);
        tvFREPAS=(TextView) findViewById(R.id.tvFREPAS);
        tvCaPAS=(TextView) findViewById(R.id.tvCaPAS);
        txtCaPAS=(EditText) findViewById(R.id.txtCaPAS);
        tvFDCPAS=(TextView) findViewById(R.id.tvFDCPAS);
        txtFDCPAS=(EditText) findViewById(R.id.txtFDCPAS);

        tvSOL=(TextView) findViewById(R.id.tvSOL);
        tvFRESOL=(TextView) findViewById(R.id.tvFRESOL);
        tvCaSOL=(TextView) findViewById(R.id.tvCaSOL);
        txtCaSOL=(EditText) findViewById(R.id.txtCaSOL);
        tvFDCSOL=(TextView) findViewById(R.id.tvFDCSOL);
        txtFDCSOL=(EditText) findViewById(R.id.txtFDCSOL);

        tvMET=(TextView) findViewById(R.id.tvMET);
        tvFREMET=(TextView) findViewById(R.id.tvFREMET);
        tvCaMET=(TextView) findViewById(R.id.tvCaMET);
        txtCaMET=(EditText) findViewById(R.id.txtCaMET);
        tvFDCMET=(TextView) findViewById(R.id.tvFDCMET);
        txtFDCMET=(EditText) findViewById(R.id.txtFDCMET);

        tvCOCA=(TextView) findViewById(R.id.tvCOCA);
        tvFRECOCA=(TextView) findViewById(R.id.tvFRECOCA);
        tvCaCOCA=(TextView) findViewById(R.id.tvCaCOCA);
        txtCaCOCA=(EditText) findViewById(R.id.txtCaCOCA);
        tvFDCCOCA=(TextView) findViewById(R.id.tvFDCCOCA);
        txtFDCCOCA=(EditText) findViewById(R.id.txtFDCCOCA);
        //endregion

        //endregion variabels



        //region DIFINICION DE TEXTVIEW
        //region DOMICILIOS ANTERIORES
        tvDA1=(TextView) findViewById(R.id.tvDA1);
        tvDA2=(TextView) findViewById(R.id.tvDA2);
        tvDATa1=(TextView) findViewById(R.id.tvDATa1);
        tvDALa3=(TextView) findViewById(R.id.tvDALa3);
        tvDATa3=(TextView) findViewById(R.id.tvDATa3);
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

        tvNDEa2=(TextView) findViewById(R.id.tvNDEa2);
        tvRDEa2=(TextView) findViewById(R.id.tvRDEa2);
        tvEDEa2=(TextView) findViewById(R.id.tvEDEa2);
        tvTDEa2=(TextView) findViewById(R.id.tvTDEa2);

        tvNDEa3=(TextView) findViewById(R.id.tvNDEa3);
        tvRDEa3=(TextView) findViewById(R.id.tvRDEa3);
        tvEDEa3=(TextView) findViewById(R.id.tvEDEa3);
        tvTDEa3=(TextView) findViewById(R.id.tvTDEa3);
        tvAR=(TextView) findViewById(R.id.tvAR);
        tvAR2=(TextView) findViewById(R.id.tvAR2);
        tvAR3=(TextView) findViewById(R.id.tvAR3);
        //endregion
        //region ESCUELAS ANTERIORES
        tvNEa1=(TextView) findViewById(R.id.tvNEa1);
        tvLE1=(TextView) findViewById(R.id.tvLE1);
        tvGC1=(TextView) findViewById(R.id.tvGC1);
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
        //region ACTIVIDADES EXTRAESCOLARES
        tvA1=(TextView) findViewById(R.id.tvA1);
        tvL1=(TextView) findViewById(R.id.tvL1);
        tvC1=(TextView) findViewById(R.id.tvC1);
        tvCT=(TextView) findViewById(R.id.tvCT);
        //endregion
        //endregion

        txtFecha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFecha);
            }

        });

        txtFNa.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFNa);
            }

        });

        txtFDCCOCA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCCOCA);
            }

        });

        txtFDCMET.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCMET);
            }

        });

        txtFDCSOL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCSOL);
            }

        });

        txtFDCPAS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCPAS);
            }

        });

        txtFDCMAR.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCMAR);
                ////////
            }

        });

        txtFDCT.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCT);
            }

        });

        txtFDCA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFDCA);
            }

        });










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
        // region sPVDF vive con el
        sPVDF1 = (Spinner) findViewById(R.id.sPVDF1);
        sPVDF1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPVDF
        sPVDF2 = (Spinner) findViewById(R.id.sPVDF2);
        sPVDF2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        /*// region sPVDF
        sPVDF3 = (Spinner) findViewById(R.id.sPVDF3);
        sPVDF3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion*/
        // region sPAR  ADOLECENTE REubicado
        sPRD = (Spinner) findViewById(R.id.sPRD);
        sPRD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPAR  ADOLECENTE RESPONSABLE1
        sPAR1 = (Spinner) findViewById(R.id.sPAR1);
        sPAR1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPAR  ADOLECENTE RESPONSABLE1
        sPAR2 = (Spinner) findViewById(R.id.sPAR2);
        sPAR2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPAR  ADOLECENTE RESPONSABLE1
        sPAR3 = (Spinner) findViewById(R.id.sPAR3);
        sPAR3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        //region sPAE ESCUELA ACTUAL
        sPAE = (Spinner) findViewById(R.id.sPAE);
        sPAE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));

        //endregion
        // region sPCS  CONCLUYO LA SECUNDARIA
        sPCS = (Spinner) findViewById(R.id.sPCS);
        sPCS.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTAA  TRABAJO RE|CURRENTE
        sPTAA = (Spinner) findViewById(R.id.sPTAA);
        sPTAA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTR  TRABAJO RE|CURRENTE
        sPTR = (Spinner) findViewById(R.id.sPTR);
        sPTR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPTC  TIEMPO COMPLETO
        sPTC = (Spinner) findViewById(R.id.sPTC);
        sPTC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPEE  ESTA ENBARAZADA
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

        // region sPCD  CUENTA CON DISCAPACIDAD////////////////////////
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
        //region CONSUMOSSSSS sPCALC
        sPCALC= (Spinner) findViewById(R.id.sPCALC);
        sPCALC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        sPCTBC= (Spinner) findViewById(R.id.sPCTBC);
        sPCTBC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));


        sPCSOL= (Spinner) findViewById(R.id.sPCSOL);
        sPCSOL.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        sPCMAR= (Spinner) findViewById(R.id.sPCMAR);
        sPCMAR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        sPCCOCA= (Spinner) findViewById(R.id.sPCCOCA);
        sPCCOCA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        sPCPAS= (Spinner) findViewById(R.id.sPCPAS);
        sPCPAS.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        sPCMET= (Spinner) findViewById(R.id.sPCMET);
        sPCMET.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, frecuenciaConsumo));

        //endregion

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
                    tvDA1.setVisibility(View.VISIBLE);
                    tvDA2.setVisibility(View.VISIBLE);
                    tvDATa1.setVisibility(View.VISIBLE);
                    txtDATa1.setVisibility(View.VISIBLE);
                    tvDALa3.setVisibility(View.VISIBLE);
                    txtDALa3.setVisibility(View.VISIBLE);
                    tvDATa3.setVisibility(View.VISIBLE);

                }
                else{
                    txtDALa1.setVisibility(View.GONE);
                    txtDALa2.setVisibility(View.GONE);
                    txtDATa3.setVisibility(View.GONE);
                    tvDA1.setVisibility(View.GONE);
                    tvDA2.setVisibility(View.GONE);
                    tvDATa1.setVisibility(View.GONE);
                    txtDATa1.setVisibility(View.GONE);
                    tvDALa3.setVisibility(View.GONE);
                    txtDALa3.setVisibility(View.GONE);
                    tvDATa3.setVisibility(View.GONE);

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
                    txtRDEa1.setVisibility(View.VISIBLE);
                    txtRDEa2.setVisibility(View.VISIBLE);
                    txtRDEa3.setVisibility(View.VISIBLE);
                    txtEDEa1.setVisibility(View.VISIBLE);
                    txtEDEa2.setVisibility(View.VISIBLE);
                    txtEDEa3.setVisibility(View.VISIBLE);
                    txtTDEa1.setVisibility(View.VISIBLE);
                    txtTDEa2.setVisibility(View.VISIBLE);
                    txtTDEa3.setVisibility(View.VISIBLE);
                    tvNDEa1.setVisibility(View.VISIBLE);
                    tvRDEa1.setVisibility(View.VISIBLE);
                    tvEDEa1.setVisibility(View.VISIBLE);
                    tvTDEa1.setVisibility(View.VISIBLE);
                    tvNDEa2.setVisibility(View.VISIBLE);
                    tvRDEa2.setVisibility(View.VISIBLE);
                    tvEDEa2.setVisibility(View.VISIBLE);
                    tvTDEa2.setVisibility(View.VISIBLE);
                    tvNDEa3.setVisibility(View.VISIBLE);
                    tvRDEa3.setVisibility(View.VISIBLE);
                    tvEDEa3.setVisibility(View.VISIBLE);
                    tvTDEa3.setVisibility(View.VISIBLE);
                    tvAR.setVisibility(View.VISIBLE);
                    tvAR2.setVisibility(View.VISIBLE);
                    tvAR3.setVisibility(View.VISIBLE);
                    sPAR1.setVisibility(View.VISIBLE);
                    sPAR2.setVisibility(View.VISIBLE);
                    sPAR2.setVisibility(View.VISIBLE);
                    sPAR3.setVisibility(View.VISIBLE);
                }
                else{
                    txtNDEa1.setVisibility(View.GONE);
                    txtNDEa2.setVisibility(View.GONE);
                    txtNDEa3.setVisibility(View.GONE);
                    txtRDEa1.setVisibility(View.GONE);
                    txtRDEa2.setVisibility(View.GONE);
                    txtRDEa3.setVisibility(View.GONE);
                    txtEDEa1.setVisibility(View.GONE);
                    txtEDEa2.setVisibility(View.GONE);
                    txtEDEa3.setVisibility(View.GONE);
                    txtTDEa1.setVisibility(View.GONE);
                    txtTDEa2.setVisibility(View.GONE);
                    txtTDEa3.setVisibility(View.GONE);
                    tvNDEa1.setVisibility(View.GONE);
                    tvRDEa1.setVisibility(View.GONE);
                    tvEDEa1.setVisibility(View.GONE);
                    tvTDEa1.setVisibility(View.GONE);
                    tvNDEa2.setVisibility(View.GONE);
                    tvRDEa2.setVisibility(View.GONE);
                    tvEDEa2.setVisibility(View.GONE);
                    tvTDEa2.setVisibility(View.GONE);
                    tvNDEa3.setVisibility(View.GONE);
                    tvRDEa3.setVisibility(View.GONE);
                    tvEDEa3.setVisibility(View.GONE);
                    tvTDEa3.setVisibility(View.GONE);
                    tvAR.setVisibility(View.GONE);
                    tvAR2.setVisibility(View.GONE);
                    tvAR3.setVisibility(View.GONE);
                    sPAR1.setVisibility(View.GONE);
                    sPAR2.setVisibility(View.GONE);
                    sPAR3.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion



        // region sPTA  TRABAJOA ANTERIORES FALTA sPPINER EN XML
        sPTA = (Spinner) findViewById(R.id.sPTA);
        sPTA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtNT1.setVisibility(View.VISIBLE);

                    txtLT1.setVisibility(View.VISIBLE);

                    txtAT1.setVisibility(View.VISIBLE);

                    txtTT1.setVisibility(View.VISIBLE);

                    tvNT1.setVisibility(View.VISIBLE);

                    tvLT1.setVisibility(View.VISIBLE);

                    tvAT1.setVisibility(View.VISIBLE);

                    tvTT1.setVisibility(View.VISIBLE);

                }
                else{
                    txtNT1.setVisibility(View.GONE);

                    txtLT1.setVisibility(View.GONE);

                    txtAT1.setVisibility(View.GONE);

                    txtTT1.setVisibility(View.GONE);

                    tvTA.setVisibility(View.GONE);
                    tvNTa.setVisibility(View.GONE);
                    tvDTa.setVisibility(View.GONE);
                    tvTTa.setVisibility(View.GONE);
                    tvATa.setVisibility(View.GONE);
                    tvJTa.setVisibility(View.GONE);
                    tvNT1.setVisibility(View.GONE);

                    tvLT1.setVisibility(View.GONE);

                    tvAT1.setVisibility(View.GONE);

                    tvTT1.setVisibility(View.GONE);


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
        sPAEA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtA1.setVisibility(View.VISIBLE);

                    txtL1.setVisibility(View.VISIBLE);

                    txtC1.setVisibility(View.VISIBLE);

                    txtT1.setVisibility(View.VISIBLE);

                    tvA1.setVisibility(View.VISIBLE);
                    tvL1.setVisibility(View.VISIBLE);
                    tvC1.setVisibility(View.VISIBLE);
                    tvCT.setVisibility(View.VISIBLE);


                }
                else{
                    txtA1.setVisibility(View.GONE);

                    txtL1.setVisibility(View.GONE);

                    txtC1.setVisibility(View.GONE);

                    txtT1.setVisibility(View.GONE);

                    tvA1.setVisibility(View.GONE);
                    tvL1.setVisibility(View.GONE);
                    tvC1.setVisibility(View.GONE);
                    tvCT.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region CONSUMO ALCOHOL sPALC///////////////////////
        sPALC = (Spinner) findViewById(R.id.sPALC);
        sPALC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPALC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFREA.setVisibility(View.VISIBLE);
                    tvCaA.setVisibility(View.VISIBLE);
                    txtCaA.setVisibility(View.VISIBLE);
                    tvFDCA.setVisibility(View.VISIBLE);
                    txtFDCA.setVisibility(View.VISIBLE);
                    sPCALC.setVisibility(View.VISIBLE);
                }
                else{

                    tvFREA.setVisibility(View.GONE);
                    tvCaA.setVisibility(View.GONE);
                    txtCaA.setVisibility(View.GONE);
                    tvFDCA.setVisibility(View.GONE);
                    txtFDCA.setVisibility(View.GONE);
                    sPCALC.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //////TABACO
        sPTBC = (Spinner) findViewById(R.id.sPTBC);
        sPTBC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTBC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFRET.setVisibility(View.VISIBLE);
                    tvCaT.setVisibility(View.VISIBLE);
                    txtCaT.setVisibility(View.VISIBLE);
                    tvFDCT.setVisibility(View.VISIBLE);
                    txtFDCT.setVisibility(View.VISIBLE);
                    sPCTBC.setVisibility(View.VISIBLE);
                }
                else{

                    tvFRET.setVisibility(View.GONE);
                    tvCaT.setVisibility(View.GONE);
                    txtCaT.setVisibility(View.GONE);
                    tvFDCT.setVisibility(View.GONE);
                    txtFDCT.setVisibility(View.GONE);
                    sPCTBC.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //////SOLVENTES
        sPSOL = (Spinner) findViewById(R.id.sPSOL);
        sPSOL.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPSOL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFRESOL.setVisibility(View.VISIBLE);
                    tvCaSOL.setVisibility(View.VISIBLE);
                    txtCaSOL.setVisibility(View.VISIBLE);
                    tvFDCSOL.setVisibility(View.VISIBLE);
                    txtFDCSOL.setVisibility(View.VISIBLE);
                    sPCSOL.setVisibility(View.VISIBLE);
                }
                else{

                    tvFRESOL.setVisibility(View.GONE);
                    tvCaSOL.setVisibility(View.GONE);
                    txtCaSOL.setVisibility(View.GONE);
                    tvFDCSOL.setVisibility(View.GONE);
                    txtFDCSOL.setVisibility(View.GONE);
                    sPCSOL.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //////MARIHUANA
        sPMAR = (Spinner) findViewById(R.id.sPMAR);
        sPMAR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPMAR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFREMAR.setVisibility(View.VISIBLE);
                    tvCaMAR.setVisibility(View.VISIBLE);
                    txtCaMAR.setVisibility(View.VISIBLE);
                    tvFDCMAR.setVisibility(View.VISIBLE);
                    txtFDCMAR.setVisibility(View.VISIBLE);
                    sPCMAR.setVisibility(View.VISIBLE);
                }
                else{

                    tvFREMAR.setVisibility(View.GONE);
                    tvCaMAR.setVisibility(View.GONE);
                    txtCaMAR.setVisibility(View.GONE);
                    tvFDCMAR.setVisibility(View.GONE);
                    txtFDCMAR.setVisibility(View.GONE);
                    sPCMAR.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //////COCA
        sPCOCA = (Spinner) findViewById(R.id.sPCOCA);
        sPCOCA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPCOCA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFRECOCA.setVisibility(View.VISIBLE);
                    tvCaCOCA.setVisibility(View.VISIBLE);
                    txtCaCOCA.setVisibility(View.VISIBLE);
                    tvFDCCOCA.setVisibility(View.VISIBLE);
                    txtFDCCOCA.setVisibility(View.VISIBLE);
                    sPCCOCA.setVisibility(View.VISIBLE);
                }
                else{

                    tvFRECOCA.setVisibility(View.GONE);
                    tvCaCOCA.setVisibility(View.GONE);
                    txtCaCOCA.setVisibility(View.GONE);
                    tvFDCCOCA.setVisibility(View.GONE);
                    txtFDCCOCA.setVisibility(View.GONE);
                    sPCCOCA.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //////PASTILLAS
        sPPAS = (Spinner) findViewById(R.id.sPPAS);
        sPPAS.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPPAS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFREPAS.setVisibility(View.VISIBLE);
                    tvCaPAS.setVisibility(View.VISIBLE);
                    txtCaPAS.setVisibility(View.VISIBLE);
                    tvFDCPAS.setVisibility(View.VISIBLE);
                    txtFDCPAS.setVisibility(View.VISIBLE);
                    sPCPAS.setVisibility(View.VISIBLE);
                }
                else{

                    tvFREPAS.setVisibility(View.GONE);
                    tvCaPAS.setVisibility(View.GONE);
                    txtCaPAS.setVisibility(View.GONE);
                    tvFDCPAS.setVisibility(View.GONE);
                    txtFDCPAS.setVisibility(View.GONE);
                    sPCPAS.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //////METANFETAMINA
        sPMET = (Spinner) findViewById(R.id.sPMET);
        sPMET.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPMET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){

                    tvFREMET.setVisibility(View.VISIBLE);
                    tvCaMET.setVisibility(View.VISIBLE);
                    txtCaMET.setVisibility(View.VISIBLE);
                    tvFDCMET.setVisibility(View.VISIBLE);
                    txtFDCMET.setVisibility(View.VISIBLE);
                    sPCMET.setVisibility(View.VISIBLE);
                }
                else{

                    tvFREMET.setVisibility(View.GONE);
                    tvCaMET.setVisibility(View.GONE);
                    txtCaMET.setVisibility(View.GONE);
                    tvFDCMET.setVisibility(View.GONE);
                    txtFDCMET.setVisibility(View.GONE);
                    sPCMET.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
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
                r5A=txtNpa1.getText().toString().toUpperCase();
                r6A=txtNpa2.getText().toString().toUpperCase();
                r7A=txtNpa3.getText().toString().toUpperCase();
                r8A=txtNpa4.getText().toString().toUpperCase();
                r9A=txtRa1.getText().toString().toUpperCase();
                r10A=txtRa2.getText().toString().toUpperCase();
                r11A=txtRa3.getText().toString().toUpperCase();
                r12A=txtRa4.getText().toString().toUpperCase();
                r13A=txtPOa1.getText().toString().toUpperCase();
                r14A=txtPOa2.getText().toString().toUpperCase();
                r15A=txtPOa3.getText().toString().toUpperCase();
                r16A=txtPOa4.getText().toString().toUpperCase();
                r17A=txtNa.getText().toString().toUpperCase();
                r18A=txtEa.getText().toString().toUpperCase();
                r19A=txtFNa.getText().toString().toUpperCase();
                r20A=txtCURPa.getText().toString().toUpperCase();
                r21A=txtLNa.getText().toString().toUpperCase();
                r22A=txtEDOa.getText().toString().toUpperCase();
                r23A=txtMa.getText().toString().toUpperCase();
                r24A=txtLa.getText().toString().toUpperCase();
                r25A=txtNAa.getText().toString().toUpperCase();
                //endregion DDATOS GENERALES
                //region FICHA FAMILIAR
                r26A=txtCa.getText().toString().toUpperCase();
                r27A=txtNOa.getText().toString().toUpperCase();
                r28A=txtCOLa.getText().toString().toUpperCase();
                r29A=txtCPa.getText().toString().toUpperCase();
                r30A=txtMUa.getText().toString().toUpperCase();
                r31A=txtEDO2a.getText().toString().toUpperCase();
                r32A=txtPa.getText().toString().toUpperCase();
                r33A=txtTa.getText().toString().toUpperCase();
                r34A=txtDALa1.getText().toString().toUpperCase();
                r35A=txtDALa2.getText().toString().toUpperCase();
                r36A=txtDATa3.getText().toString().toUpperCase();
                r37A=txtDATa4.getText().toString().toUpperCase();
                //endregion FICHA FAMILIAR
                //region DATOS FAMILIARES
                r38A=txtNDFa1.getText().toString().toUpperCase();
                r39A=txtNDFa2.getText().toString().toUpperCase();
                r40A=txtRDFa1.getText().toString().toUpperCase();
                r41A=txtRDFa2.getText().toString().toUpperCase();
                r42A=txtEDFa1.getText().toString().toUpperCase();
                r43A=txtEDFa2.getText().toString().toUpperCase();
                r44A=txtTDFa1.getText().toString().toUpperCase();
                r45A=txtTDFa2.getText().toString().toUpperCase();
                r46A=txtCQDFa.getText().toString().toUpperCase();
                r47A=txtRDFa.getText().toString().toUpperCase();
                r48A=txtLDFa.getText().toString().toUpperCase();
                //endregion DATOS FAMILIARES
                //region DEEPENDIENTES ECONOMICOS
                r49A=txtNDEa1.getText().toString().toUpperCase();
                r50A=txtNDEa2.getText().toString().toUpperCase();
                r51A=txtNDEa3.getText().toString().toUpperCase();
                r52A=txtRDEa1.getText().toString().toUpperCase();
                r53A=txtRDEa2.getText().toString().toUpperCase();
                r54A=txtRDEa3.getText().toString().toUpperCase();
                r55A=txtEDEa1.getText().toString().toUpperCase();
                r56A=txtEDEa2.getText().toString().toUpperCase();
                r57A=txtEDEa3.getText().toString().toUpperCase();
                r58A=txtTDEa1.getText().toString().toUpperCase();
                r59A=txtTDEa2.getText().toString().toUpperCase();
                r60A=txtTDEa3.getText().toString().toUpperCase();

                //endregion DEPENDIENTES ECONOMICOS
                //region VINCULOS COMINITARIOS
                r61A=txtNEa.getText().toString().toUpperCase();
                r62A=txtDEa.getText().toString().toUpperCase();
                r63A=txtTea.getText().toString().toUpperCase();
                r64A=txtNIEa.getText().toString().toUpperCase();
                r65A=txtUGa.getText().toString().toUpperCase();
                r66A=txtNEa1.getText().toString().toUpperCase();
                r67A=txtNEa2.getText().toString().toUpperCase();
                r68A=txtLE1.getText().toString().toUpperCase();
                r69A=txtLE2.getText().toString().toUpperCase();
                r70A=txtGC1.getText().toString().toUpperCase();
                r71A=txtGC2.getText().toString().toUpperCase();
                //endregion VINCULOS COMUNITARIOS
                //region HISTORIAL LABORAL
                r72A=txtTAa.getText().toString().toUpperCase();
                r73A=txtNTa.getText().toString().toUpperCase();
                r75A=txtDTa.getText().toString().toUpperCase();
                r76A=txtTTa.getText().toString().toUpperCase();
                r77A=txtATa.getText().toString().toUpperCase();
                r78A=txtJTa.getText().toString().toUpperCase();
                r79A=txtNT1.getText().toString().toUpperCase();
                r80A=txtLT1.getText().toString().toUpperCase();
                r81A=txtAT1.getText().toString().toUpperCase();
                r82A=txtTT1.getText().toString().toUpperCase();
                //endregion HISTORIAL LABORAL
                //region ACTIVIDADRES ESTRAESCOLARES
                r83A=txtA1.getText().toString().toUpperCase();
                r84A=txtL1.getText().toString().toUpperCase();
                r85A=txtC1.getText().toString().toUpperCase();
                r86A=txtT1.getText().toString().toUpperCase();
                //endregion
                //region CONSUMOS
                r87A=txtCaA.getText().toString().toUpperCase();
                r88A=txtCaT.getText().toString().toUpperCase();
                r89A=txtFDCA.getText().toString().toUpperCase();
                r90A=txtFDCT.getText().toString().toUpperCase();
                r91A=txtFDCMAR.getText().toString().toUpperCase();
                r92A=txtCaMAR.getText().toString().toUpperCase();
                r93A=txtFDCPAS.getText().toString().toUpperCase();
                r94A=txtCaPAS.getText().toString().toUpperCase();
                r95A=txtFDCSOL.getText().toString().toUpperCase();
                r96A=txtCaSOL.getText().toString().toUpperCase();
                r97A=txtFDCMET.getText().toString().toUpperCase();
                r98A=txtCaMET.getText().toString().toUpperCase();
                r99A=txtCaCOCA.getText().toString().toUpperCase();
                r100A=txtFDCCOCA.getText().toString().toUpperCase();
                //endregion CONSUMOS

                //region SPINNERS
                rS1=sP1a.getSelectedItem().toString().toUpperCase();
                rS2=sPSex.getSelectedItem().toString().toUpperCase();
                rS3=sPIdio.getSelectedItem().toString().toUpperCase();
                rS4=sPTra.getSelectedItem().toString().toUpperCase();
                rS5=sPDfa.getSelectedItem().toString().toUpperCase();

                rS6=sPVDF1.getSelectedItem().toString().toUpperCase();
                rS7=sPVDF2.getSelectedItem().toString().toUpperCase();
                rS8=sPVDF3.getSelectedItem().toString().toUpperCase();
                rS9=sPRD.getSelectedItem().toString().toUpperCase();
                rS10=sPAR1.getSelectedItem().toString().toUpperCase();
                rS11=sPAR2.getSelectedItem().toString().toUpperCase();
                rS12=sPAR3.getSelectedItem().toString().toUpperCase();
                rS13=sPAE.getSelectedItem().toString().toUpperCase();
                rS14=sPCS.getSelectedItem().toString().toUpperCase();
                rS15=sPTA.getSelectedItem().toString().toUpperCase();
                rS16=sPTAA.getSelectedItem().toString().toUpperCase();
                rS17=sPTR.getSelectedItem().toString().toUpperCase();
                rS18=sPTC.getSelectedItem().toString().toUpperCase();
                rS19=sPAEA.getSelectedItem().toString().toUpperCase();
                rS20=sPEE.getSelectedItem().toString().toUpperCase();
                rS21=sPEM.getSelectedItem().toString().toUpperCase();
                rS22=sPTE.getSelectedItem().toString().toUpperCase();
                rS23=sPC.getSelectedItem().toString().toUpperCase();
                rS24=sPCD.getSelectedItem().toString().toUpperCase();
                rS25=sPSIDA.getSelectedItem().toString().toUpperCase();
                rS26=sPEV.getSelectedItem().toString().toUpperCase();
                rS27=sPCALC.getSelectedItem().toString().toUpperCase();
                rS28=sPCTBC.getSelectedItem().toString().toUpperCase();
                rS29=sPCSOL.getSelectedItem().toString().toUpperCase();
                rS30=sPCMAR.getSelectedItem().toString().toUpperCase();
                rS31=sPCCOCA.getSelectedItem().toString().toUpperCase();
                rS32=sPCPAS.getSelectedItem().toString().toUpperCase();
                rS33=sPCMET.getSelectedItem().toString().toUpperCase();
                //endregion


                Date fin=new Date();


                /*db.insertardatosEntrevistadorA(r1A,r2A,r3A,r4A);
                db.insertarDatosResponsablesA(rS1,r5A,r6A,r7A,r8A,r9A,r10A,r11A,r12A,r13A,r14A,r15A,r16A);
                db.insertaDatosGeneralesA(r17A,rS2,r18A,r19A,r20A,r21A,r22A,r23A,r24A,r25A,rS3,rS4);
                db.insertarDatosFichaFamiliarA(r26A,r27A,r28A,r29A,r30A,r31A,r32A,r33A,rS5,34A,r35A,r36A,r37A);
                db.insertarDstosFamiliaresA(r38A,r39A,r40A,r41A,r42A,r43A,r44A,r45A,rS6,rS7,rS9,r46A,r47A,r48A);
                db.insertarDatosDependientesEconomicoasA(r49A,r50A,r51A,r52A,r53A,r54A,r55A,r56A,r57A,r58A,r59A,r60A,rS10,rS11);
                db.insertarDatosHistorialEscolarA(rS13,rS14,r61A,r62A,r63A,r64A,r65A,r66A,r67A,r68A,r69A,r70A,r71A);
                db.insertarDatosHistorialLaboralA(rS15,rS16,r72A,r73A,r74A,r75A,r76A,rS17,r77A,r78A,r79A,r82A);
                db.insertarDatosActividadesExtraescolaresA(rS18,r83A,r84A,r85A,r86A);
                db.insertarDatosRvicionMedicaA(rS19,rS20,rS21,rS22,rS23,rS24,rS25);
                db.insertarDatosConsumoSustanciasA(r87A,r88A,r89A,r90A,r92A,r93A,r94A,r95A,r96A,r97A,r98A,r99A,r100A);*/

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
/*       public boolean ValidarFormularioA(){
            String verifica="";
            boolean validacion=true;
            if(r3A.equals("")){
                validacion=false;
                verifica="\nNuemro de Causa"+verifica;
                insertardatosEntrevistadorA.setVisibility(View.VISIBLE);
                txtNe.requestFocus();
                //etP1.setBackground(Color.parseColor();
            }

        }*/
        //endregion



    }

    private void showDatePickerDialog(final EditText editText) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because january is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                editText.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
