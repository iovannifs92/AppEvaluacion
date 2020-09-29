package com.sistemas.evaluacion;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosActividadesExtraescolaresA;
import com.sistemas.evaluacion.entidades.datosConsumoSustanciasA;
import com.sistemas.evaluacion.entidades.datosDependientesEconomicosA;
import com.sistemas.evaluacion.entidades.datosFamiliaresA;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosGeneralesA;
import com.sistemas.evaluacion.entidades.datosHistorialEscolarA;
import com.sistemas.evaluacion.entidades.datosHistorialLaboralA;
import com.sistemas.evaluacion.entidades.datosInformacionCasoA;
import com.sistemas.evaluacion.entidades.datosProcesoLegalA;
import com.sistemas.evaluacion.entidades.datosProcesosPenalesA;
import com.sistemas.evaluacion.entidades.datosResponsablesA;
import com.sistemas.evaluacion.entidades.datosRevisionMedicaA;
import com.sistemas.evaluacion.entidades.datosVictimaOfendidoA;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class editar_adolescente extends AppCompatActivity {
    private MyOpenHelper db;
    ArrayList<datosGeneralesA> lista1;
    ArrayList<datosFamiliaresA> datosfamiliares;
    private ArrayList<Integer> IdxA;
    //regio boolean
    private boolean Dg=false,Ffa=false,VH=false,CE=false,IC=false,pR=false,ICA=false,PP=false,VO=false,PL=false;

    private Spinner sPNombres;
    //region ENTREVISTA ADOLECENTE
    //region TextView
    //DOMICILIOS ANTERIORES
    private TextView txtFolioA ,tvD1A,tvD2A,tvD3A,tvDA1, tvDA2,tvDATa1,tvDALa3,tvDATa3,tvDATa2,tvCOLa1;
    //REUBICAR ADOLECENTE
    private TextView tvCQDFa, tvRDFa, tvLDFa;
    //DEPENDIENTES ECONOMICOS
    private TextView tvDE,tvDPA1,tvDPA2,tvDPA3,tvNDEa1,tvRDEa1,tvEDEa1,tvTDEa1,tvNDEa2,tvRDEa2,tvEDEa2,tvTDEa2,tvNDEa3,tvRDEa3,tvEDEa3,tvTDEa3,tvAR,tvAR2,tvAR3;
    //DEPENDIENTES TRABAJO ACTUAL
    private TextView tvTA,tvNTa,tvTAA,tvTR,tvDTa,tvTTa,tvATa,tvTC,tvJTa,tvNT1,tvLT1,tvAT1,tvTT1;
    ///////ESCUELAS ANTERIORES
    private TextView tvTVEA,tvNEa,tvDEa,tvTea,tvNIEa,tvNEa1,tvLE1,tvGC1;
    //////////ACTIVIDADRES EXTRAESCOLARES
    private TextView tvA1,tvL1,tvC1,tvCT;
    /////////////CONSUMOS
    private TextView tvA,tvFREA,tvCaA,tvFDCA,tvT,tvFRET,tvCaT,tvFDCT,tvMAR,tvFREMAR,tvCaMAR,tvFDCMAR,tvPAS,tvFREPAS,tvCaPAS,tvFDCPAS,tvSOL,tvFRESOL,tvCaSOL,tvFDCSOL,tvMET,tvFREMET,tvCaMET,tvFDCMET,tvCOCA,tvFRECOCA,tvCaCOCA,tvFDCCOCA;
    //////
    private TextView tvPC,CPPe;
    //////
    private TextView tvOPS,datosFinalesA;

    //region EditText
    //datos generales
    private EditText txtNpa1, txtNpa2, txtNpa3, txtNpa4, txtRa1, txtRa2, txtRa3, txtRa4, txtPOa3, txtPOa4,txtApeP,txtApeM,txtNa, txtEa, txtFNa, txtCURPa, txtEDOa, txtMa, txtLa, txtNAa ;
    //Ficha familiar Domicilio
    private EditText txtCa, txtNOa, txtCOLa, txtCPa, txtMUa, txtEDO2a, txtPa, txtTa, txtDALa1, txtDALa2,txtDALa3,txtDATa3,txtDATa4,txtDATa1,txtDATa2;
    //Datos familiares
    private EditText txtNDFa1,txtNDFa2,txtEDFa1, txtEDFa2,txtTDFa1, txtTDFa2,txtCQDFa,txtRDFa,txtLDFa;
    //Dependientes economicos
    private EditText txtNDEa1,txtNDEa2,txtNDEa3,txtRDEa1,txtRDEa2,txtRDEa3,txtEDEa1,txtEDEa2,txtEDEa3,txtTDEa1,txtTDEa2,txtTDEa3;
    //Viculos comunitarios
    private EditText txtNEa,txtDEa,txtTea,txtNIEa,txtUGa,txtNEa1,txtLE1,txtGC1;
    //Historial laboral
    private EditText txtNTa,txtDTa,txtTTa,txtATa,txtJTa,txtNT1,txtLT1,txtAT1,txtTT1;
    //actividades Extraescolares
    private EditText txtA1,txtL1,txtC1,txtT1;
    //Consumo de sustancias
    private EditText txtCaA,txtCaT,txtFDCA,txtFDCT,txtFDCMAR,txtCaMAR,txtFDCPAS,txtCaPAS,txtFDCSOL,txtCaSOL,txtFDCMET,txtCaMET,txtCaCOCA,txtFDCCOCA;
    ////
    private EditText txtOPS;
    //endregion
    private TextView Referencia2A,tvP2,tvNDFa2,tvRDFa2,tvEDFa2,tvTDFa2,tvVDF2,Referencia1A,tvNDFa1,tvRDFa1,tvEDFa1,tvTDFa1,tvVDF1,tvEE,tvEM;


    //reguin Sppiner
    private Spinner sPRef,sPPe,sPRDFa1,sPRDFa2 ,sPPar1,sPPar2,sPRa1,sPRa2,sPSex,sPCOLa,sPTa,sPUGa,sP1a,sPIdio,sPTra,sPDfa,sPVDF1,sPVDF2,sP,sPDA,sPRD,sPDE,sPDE_1,sPAR1,sPAR2,sPAR3, sPAE,sPCS,sPTA,sPTR,sPTAA,sPTC,sPAEA,sPEE,sPEM,sPTE,sPC,sPCD,sPSIDA,sPEV,sPUA,sPLO,sPMC,sPHO,sPTP,sPEVO,sPEVS,sPCV,SE,SA;
    //region Sppiners
    private Spinner sPALC,sPTBC,sPSOL,sPMAR,sPCOCA,sPPAS,sPMET,sPCALC,sPCTBC,sPCSOL,sPCMAR,sPCCOCA,sPCPAS,sPCMET,sPSUSF;
    //endregion



    private String [] tipoR={"N/A","PADRE","MADRE","ABUELO","ABUELA","HERMANO(A)","TUTOR(A)","FAMILIA INDIRECTA","CONOCIDO(A)"};
    private String [] part={"N/A","OYENTE", "PARTICIPANTE"};
    private String [] nPersonas={"N/A","1","2","3"};
    private String [] nPersonasR={"N/A","1","2"};
    private String [] nosi={"NO", "SI"};
    private String [] sino={"SI", "NO"};
    private String [] nosia={"N/A","NO", "SI"};
    private String [] sexo={"MASCULINO", "FEMENINO"};
    private String [] malo={"N/A","VIH/SIDA","ENFERMEDADES CARDIOVASCULARES","CÁNCER","ENFERMEDAD PULMONAR OBSTRUCTIVA CRÓNICA","DIABETES","PARKINSON","ALZHEIMER","ESCLEROSIS MÚLTIPLE","HIPERTENSIÓN","LUMBALGIA","COLESTEROL","DEPRESIÓN","ANSIEDAD","TIROIDES","OSTEOPOROSIS"};
    ////////Consumo//////////////7
    private String [] frecuenciaConsumo={"NO CONSUME", "DIARIAMENTE", "CADA TERCER DÍA", "SEMANALMENTE", "QUINCENALMENTE", "MENSUALMENTE", "ANUALMENTE"};

    private String [] colfracc={"N/A","COLONIA", "FRACCIONAMIENTO","DOMICILIO CONOCIDO", "EJIDO"};

    private String [] tiempoRadicando={"N/A","MENOS DE 1 AÑO Y MENOS DE 3 EN EL MUNICIPIO", "MENOS DE 1 AÑO Y MÁS DE 3 EN EL MUNICIPIO", "ENTRE 1 Y 2 AÑOS", "ENTRE 2 Y 5 AÑOS", "MÁS DE 5 AÑOS"};

    private String [] gradoEstudios={"SIN ESTUDIOS", "PRIMARIA","SECUNDARIA", "PREPARATORIA", "LICENCIATURA", "MAESTRIA", "DOCTORADO"};

    private String [] referencia={"0","1","2"};

    private String [] delito={"OTRO", "ROBO", "ROBO SIMPLE", "VIOLACION", "VIOLENCIA FAMILIAR", "DAÑOS Y LESIONES",
            "LESIONES MENORES A 15 DIAS", "CONTRA LA SALUD", "COMERCIO O SUMINISTRO", "PORTACIÓN DE ARMAS DE FUEGO"};

    private String[] estatus={"N/A","VIGENTE", "SUSPENDIDO", "REVOCADO", "CUMPLIDO"};
    private String[] otroProceso={"N/A","1","2","3","4","5"};

    //region LinearLayout
    private LinearLayout llDg,llFfa,llVH,llCE,llIC,llICA, llPP,llVO,llPL,llVisibilityA;
    //endregionLinearLayout
    //region Buttons
    private Button btnGuardarA,btnDg,btnFfa,btnVH,btnCE,btnIC,btnICA,btnPP,btnVO,btnPL;
    //endregion Buttons
    //endregion
    //endregion ENTREVISTA ADOLECENTE

    //region INFOCASO ADOLECENTE
    //region INFORMACION DE CASO ACTUAL
    private TextView tvNoRecords,e131,tvEspe,tvTPc,tvFp,tvF,tvEVS,tvVD,tvVV,tvCV,tvRR,tvRR_1,tvEx1,tvEx2,tvNC1,tvNC2,tvNC3,tvNC4,tvNC5,tvD1,tvD2,tvD3,tvD4,tvD5,tvTM1,tvTM2,tvTM3,tvTM4,tvTM5,tvE1,tvE2,tvE3,tvE4,tvE5,tvSL,tvPPP1,tvPPP2,tvPPP3,tvPPP4,tvPPP5;
    //endregion

    //region Infotmacion el caso actual
    private EditText txtEspe,txtNC1,txtNC2,txtNC3,txtNC4,txtNC5,txtD1,txtD2,txtD3,txtD4,txtD5,txtTM1,txtTM2,txtTM3,txtTM4,txtTM5,txtEx1,txtEx2;
    //endregion EditText
    //region SPINNERS
    private Spinner sPE1,sPE2,sPE3,sPE4,sPE5,sPICA,sPTE1,sPTI,sPDI,sPUA1,sPUD,sPMC1,sPHO1,sPTP1,sPTPc,sPSL,sPVO,sPVD,sPVV,sPRR,sPDV,sPEVF,sPSE,sPSA;
    //endregion
    String folio, carpeta;

    private String r1A,r2A,r3A,FOLIOA,r5A,r6A,r7A,r8A,r9A,r10A,r11A,r13A,r14A,r17A,r17A_1,r17A_2,r18A,r19A,r20A,r22A,r23A,r24A,
            r25A,r26A,r27A,r28A,r28_1A,r29A,r30A,r31A,r32A,r33A,r34A,r35A,r36A,r38A,r39A,r40A,r41A,r42A,r43A,r44A,r45A,r46A,r47A,r48A,
            r49A,r50A,r51A,r52A,r53A,r54A,r55A,r56A,r57A,r58A,r59A,r60A,r61A,r62A,r63A,r64A,r65A,r66A,r67A,r68A,r69A,r70A,r71A,
            r73A,r75A,r76A,r77A,r78A,r79A,r80A,r81A,r82A,r83A,r84A,r85A,r86A,r87A,r88A,r89A,r90A,r91A,r92A,r93A,r94A,r95A,r96A,r97A,r98A,r98_A,
            r99A,r100A;
    //SPINNERS
    private String rS1f,rS2f,rS3f,rS4f,rS5f,rS6f,rS7f,rS8f,rS9f,rS9_1f,rS9_2f,rS10f,rS11f,rS12f,rS13f,rS14f,rS15f,rS16f,rS17f,rS18f,rS19f,rS20f,rS21f,rS22f,rS23f,rS24f,rS25f,rS26f,rS27f,
            rS28f,rS29f,rS30f,rS31f,rS32f,rS33f,rS34f,rS35f,rS36f,rS37f,rS38f,rS39f,rS40f,rS41f,rS42f,rS42_1f;

    private String r1,r2,r3,r3_1,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25;
    private String rS_1,rS_2,rS_3,rS_4,rS_5,rS_6,rS_7,rS_8,rS_81,rS_9,rS_10,rS_11,rS_12,rS_14,rS_15,rS_16,rS_17,rS_18;
    String textoSincronizado="", pass="";

    //endregion INFO CASO ADOLECENTE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_adolescente);
        db=new MyOpenHelper(this);
        db.getReadableDatabase();
        showInputDialog(findViewById(android.R.id.content).getRootView());
        lista1 = db.getdatosGeneralesA();


        //region Inicializa un spinner con los nombres de los entrevistados
        ArrayList<String> names = new ArrayList<String>();
        IdxA = new ArrayList<Integer>();
        for(int i = 0; i < lista1.size(); i++){
            if(lista1.get(i).getAverificacion().equals("SI")) {
                names.add(lista1.get(i).getAnombre()+" "+lista1.get(i).getApaterno()+" "+ lista1.get(i).getAmaterno());
                IdxA.add(i);
            }
        }
        sPNombres = (Spinner) findViewById(R.id.sPNombres);
        sPNombres.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //Display the last element or do not display anything when there are no elements
        tvNoRecords=(TextView) findViewById(R.id.tvNoRecords);
        llVisibilityA=(LinearLayout) findViewById(R.id.llVisibilityA);

        if(names.isEmpty()){
            llVisibilityA.setVisibility(View.GONE);
            sPNombres.setVisibility(View.VISIBLE);
        }
        else {
            llVisibilityA.setVisibility(View.VISIBLE);
            tvNoRecords.setVisibility(View.GONE);
            sPNombres.setSelection(names.size() - 1);
        }
        //endregion



        sPNombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                final ArrayList<datosResponsablesA> respo;
                respo = db.getdatosResponsablesA();

                final ArrayList<datosGeneralesA> datosgenerales;
                datosgenerales = db.getdatosGeneralesA();

                final ArrayList<datosFichaFamiliarA> datosFF;
                datosFF = db.getdatosFichaFamiliarA();

                final ArrayList<datosFamiliaresA> datosFA;
                datosFA = db.getdatosFamiliaresA(); //

                final ArrayList<datosDependientesEconomicosA> dependeA;
                dependeA = db.getdatosDependientesEconomicosA();

                final ArrayList<datosHistorialEscolarA> datosHE;
                datosHE = db.getdatosHistorialEscolarA();

                final ArrayList<datosHistorialLaboralA> labor;
                labor = db.getdatosHistorialLaboralA();

                final ArrayList<datosActividadesExtraescolaresA> actividades;
                actividades = db.getdatosActividadesExtraescolaresA();

                final ArrayList<datosRevisionMedicaA> salud;
                salud = db.getdatosRevisionMedicaA();

                final ArrayList<datosConsumoSustanciasA> consumo;
                consumo = db.getdatosConsumoSustanciasA();

                final ArrayList<datosInformacionCasoA> casoA;
                casoA = db.getdatosInformacionCasoA();

                final ArrayList<datosProcesosPenalesA> prosecoA;
                prosecoA = db.getdatosProcesosPenalesA();

                final ArrayList<datosVictimaOfendidoA> victimaA;
                victimaA = db.getdatosVictimaOfendidoA();

                final ArrayList<datosProcesoLegalA> legalA;
                legalA = db.getdatosProcesoLegalA();


                //region ENTREVISTA ANDOLECENTES

                //region DIFINICION TEXTEDIT
                //region DATOS GENERALES




                e131=(TextView) findViewById(R.id.e131);
                e131.setText(lista1.get(pos).getAfolio());
                txtFolioA=(TextView) findViewById(R.id.txtFolioA);
                txtNpa1=(EditText) findViewById(R.id.txtNpa1);
                txtNpa2=(EditText) findViewById(R.id.txtNpa2);




                txtCOLa=(EditText) findViewById(R.id.txtCOLa);
                txtApeP=(EditText) findViewById(R.id.txtApeP);
                txtApeM=(EditText) findViewById(R.id.txtApeM);
                txtNa=(EditText) findViewById(R.id.txtNa);
                txtEa=(EditText) findViewById(R.id.txtEa);
                txtFNa=(EditText) findViewById(R.id.txtFNa);
                txtCURPa=(EditText) findViewById(R.id.txtCURPa);

                txtEDOa=(EditText) findViewById(R.id.txtEDOa);
                txtMa=(EditText) findViewById(R.id.txtMa);
                txtLa=(EditText) findViewById(R.id.txtLa);
                txtNAa=(EditText) findViewById(R.id.txtNAa);
                //endregion DATOS GENERALES
                //region FICHA FAMILIAR
                txtCa=(EditText) findViewById(R.id.txtCa);
                txtNOa=(EditText) findViewById(R.id.txtNOa);
                txtCPa=(EditText) findViewById(R.id.txtCPa);
                txtMUa=(EditText) findViewById(R.id.txtMUa);
                txtEDO2a=(EditText) findViewById(R.id.txtEDO2a);
                txtPa=(EditText) findViewById(R.id.txtPa);

                txtDALa1=(EditText) findViewById(R.id.txtDALa1);
                txtDALa2=(EditText) findViewById(R.id.txtDALa2);
                txtDALa3=(EditText) findViewById(R.id.txtDALa3);


                txtDATa3=(EditText) findViewById(R.id.txtDATa3);
                txtDATa1=(EditText) findViewById(R.id.txtDATa1);
                txtDATa2=(EditText) findViewById(R.id.txtDATa2);



                //endregion FICHA FAMILIAR
                //region DATOS FAMILIARES
                txtEDFa1=(EditText) findViewById(R.id.txtEDFa1);
                txtEDFa2=(EditText) findViewById(R.id.txtEDFa2);
                txtTDFa1=(EditText) findViewById(R.id.txtTDFa1);
                txtTDFa2=(EditText) findViewById(R.id.txtTDFa2);
                txtCQDFa=(EditText) findViewById(R.id.txtCQDFa);
                txtRDFa=(EditText) findViewById(R.id.txtRDFa);
                txtLDFa=(EditText) findViewById(R.id.txtLDFa);
                //endregion DATOS FAMILIARES
                //region DEPENDIENTES ECONOMICOS

                tvDE=(TextView) findViewById(R.id.tvDE);
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
                txtNEa1=(EditText) findViewById(R.id.txtNEa1);
                txtLE1=(EditText) findViewById(R.id.txtLE1);
                txtGC1=(EditText) findViewById(R.id.txtGC1);



                //endregion
                //region HISTORIAL LABORAL

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
                //region INFORMACION DEL CASO ACTUAL
                txtNC1=(EditText) findViewById(R.id.txtNC1);
                txtNC2=(EditText) findViewById(R.id.txtNC2);
                txtNC3=(EditText) findViewById(R.id.txtNC3);
                txtNC4=(EditText) findViewById(R.id.txtNC4);
                txtNC5=(EditText) findViewById(R.id.txtNC5);

                txtD1=(EditText) findViewById(R.id.txtD1);
                txtD2=(EditText) findViewById(R.id.txtD2);
                txtD3=(EditText) findViewById(R.id.txtD3);
                txtD4=(EditText) findViewById(R.id.txtD4);
                txtD5=(EditText) findViewById(R.id.txtD5);

                txtTM1=(EditText) findViewById(R.id.txtTM1);
                txtTM2=(EditText) findViewById(R.id.txtTM2);
                txtTM3=(EditText) findViewById(R.id.txtTM3);
                txtTM4=(EditText) findViewById(R.id.txtTM4);
                txtTM5=(EditText) findViewById(R.id.txtTM5);

                //endregion INFORMACION DE CASO ACTUAL


                //endregion variabels



                //region DIFINICION DE TEXTVIEW
                //region DOMICILIOS ANTERIORES
                tvD1A=(TextView) findViewById(R.id.tvD1A);
                tvD2A=(TextView) findViewById(R.id.tvD2A);
                tvD3A=(TextView) findViewById(R.id.tvD3A);
                tvDA1=(TextView) findViewById(R.id.tvDA1);
                tvDA2=(TextView) findViewById(R.id.tvDA2);
                tvDATa1=(TextView) findViewById(R.id.tvDATa1);
                tvDALa3=(TextView) findViewById(R.id.tvDALa3);
                tvDATa3=(TextView) findViewById(R.id.tvDATa3);
                tvDATa2=(TextView) findViewById(R.id.tvDATa2);
                //endregion
                //region REUBICAR ADOLECENTE
                tvCQDFa=(TextView) findViewById(R.id.tvCQDFa);
                tvRDFa=(TextView) findViewById(R.id.tvRDFa);
                tvLDFa=(TextView) findViewById(R.id.tvLDFa);
                //endregion
                //region NUMERO DE REFERENCIA
                Referencia1A=(TextView) findViewById(R.id.Referencia1A);
                tvNDFa1=(TextView) findViewById(R.id.tvNDFa1);
                txtNDFa1=(EditText) findViewById(R.id.txtNDFa1);
                tvRDFa1=(TextView) findViewById(R.id.tvRDFa1);
                sPRDFa1=(Spinner) findViewById(R.id.sPRDFa1);
                tvEDFa1=(TextView) findViewById(R.id.tvEDFa1);
                txtEDFa1=(EditText) findViewById(R.id.txtEDFa1);
                tvTDFa1=(TextView) findViewById(R.id.tvTDFa1);
                txtTDFa1=(EditText) findViewById(R.id.txtTDFa1);
                tvVDF1=(TextView) findViewById(R.id.tvVDF1);
                sPVDF1=(Spinner) findViewById(R.id.sPVDF1);

                Referencia2A=(TextView) findViewById(R.id.Referencia2A);
                tvP2=(TextView) findViewById(R.id.tvP2);
                tvNDFa2=(TextView) findViewById(R.id.tvNDFa2);
                txtNDFa2=(EditText) findViewById(R.id.txtNDFa2);
                tvRDFa2=(TextView) findViewById(R.id.tvRDFa2);
                sPRDFa2=(Spinner) findViewById(R.id.sPRDFa2);
                tvEDFa2=(TextView) findViewById(R.id.tvEDFa2);
                txtEDFa2=(EditText) findViewById(R.id.txtEDFa2);
                tvTDFa2=(TextView) findViewById(R.id.tvTDFa2);
                txtTDFa2=(EditText) findViewById(R.id.txtTDFa2);
                tvVDF2=(TextView) findViewById(R.id.tvVDF2);
                sPVDF2=(Spinner) findViewById(R.id.sPVDF2);
                //endregion

                //region DEPENDIENTES ECONOMICOS
                tvDPA1=(TextView) findViewById(R.id.tvDPA1);
                tvDPA2=(TextView) findViewById(R.id.tvDPA2);
                tvDPA3=(TextView) findViewById(R.id.tvDPA3);
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
                //region ESCUELAS y escuelas ANTERIORES
                tvTVEA=(TextView) findViewById(R.id.tvTVEA);
                tvNEa=(TextView) findViewById(R.id.tvNEa);
                tvDEa=(TextView) findViewById(R.id.tvDEa);
                tvTea=(TextView) findViewById(R.id.tvTea);
                tvNIEa=(TextView) findViewById(R.id.tvNIEa);
                tvNEa1=(TextView) findViewById(R.id.tvNEa1);
                tvLE1=(TextView) findViewById(R.id.tvLE1);
                tvGC1=(TextView) findViewById(R.id.tvGC1);
                //endregion
                //region TRABAJO ACTUAL
                tvTA=(TextView) findViewById(R.id.tvTA);
                tvNTa=(TextView) findViewById(R.id.tvNTa);
                tvTAA=(TextView) findViewById(R.id.tvTAA);
                tvTR=(TextView) findViewById(R.id.tvTR);
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
                //region ENFERMEDADES
                tvPC=(TextView) findViewById(R.id.tvPC);
                //endregion
                CPPe=(TextView) findViewById(R.id.CPPe);

                //observaciones finales
                tvOPS=(TextView) findViewById(R.id.tvOPS);
                datosFinalesA=(TextView) findViewById(R.id.datosFinalesA);
                txtOPS=(EditText) findViewById(R.id.txtOPS);
                txtEspe=(EditText) findViewById(R.id.txtEspe);
                tvEE=(TextView) findViewById(R.id.tvEE);
                tvEM=(TextView) findViewById(R.id.tvEM);
                txtEx1=(EditText) findViewById(R.id.txtEx1);
                txtEx2=(EditText) findViewById(R.id.txtEx2);
                //endregion


                txtNpa1.setText(respo.get(pos).getAnombre1());
                txtNpa2.setText(respo.get(pos).getAnombre2());
                //datos generales a
                txtApeP.setText(datosgenerales.get(pos).getApaterno());
                txtApeM.setText(datosgenerales.get(pos).getAmaterno());
                txtNa.setText(datosgenerales.get(pos).getAnombre());
                txtEa.setText(datosgenerales.get(pos).getAedad());
                txtFNa.setText(datosgenerales.get(pos).getAfechanac());
                txtCURPa.setText(datosgenerales.get(pos).getAcurp());
                txtEDOa.setText(datosgenerales.get(pos).getAestado());
                txtMa.setText(datosgenerales.get(pos).getAmunicipio());
                txtLa.setText(datosgenerales.get(pos).getAlocalidad());
                txtNAa.setText(datosgenerales.get(pos).getAnacionalidad());
                //ficha familiar domicilio actual
                txtCa.setText(datosFF.get(pos).getAcalle());
                txtNOa.setText(datosFF.get(pos).getAnumero());
                txtCOLa.setText(datosFF.get(pos).getAnombrecol());
                txtCPa.setText(datosFF.get(pos).getAcp());
                txtMUa.setText(datosFF.get(pos).getAmunicipio());
                txtEDO2a.setText(datosFF.get(pos).getAestado());
                txtPa.setText(datosFF.get(pos).getApais());
                //domicilio antrior
                txtDALa1.setText(datosFF.get(pos).getAlocalidad1());
                txtDATa1.setText(datosFF.get(pos).getAtemporalidadant1());
                txtDALa2.setText(datosFF.get(pos).getAlocalidad2());
                txtDATa2.setText(datosFF.get(pos).getAtemporalidadant2());
                txtDALa3.setText(datosFF.get(pos).getAlocalidad3());
                txtDATa3.setText(datosFF.get(pos).getAtemporalidadant3());
                //datos familiares
                txtNDFa1.setText(datosFA.get(pos).getAnombre1());
                txtEDFa1.setText(datosFA.get(pos).getAedad1());
                txtTDFa1.setText(datosFA.get(pos).getAtelefono1());
                txtNDFa2.setText(datosFA.get(pos).getAnombre2());
                txtEDFa2.setText(datosFA.get(pos).getAedad2());
                txtTDFa2.setText(datosFA.get(pos).getAtelefono2());
                //reubica familiar
                txtCQDFa.setText(datosFA.get(pos).getAnombrefam());
                txtRDFa.setText(datosFA.get(pos).getArelacionfam());
                txtLDFa.setText(datosFA.get(pos).getAlocalidadfam());
                //dependientes economicos
                txtNDEa1.setText(dependeA.get(pos).getAnombre1());
                txtRDEa1.setText(dependeA.get(pos).getArelacion1());
                txtEDEa1.setText(dependeA.get(pos).getAedad1());
                txtTDEa1.setText(dependeA.get(pos).getAtelefono1());
                txtNDEa2.setText(dependeA.get(pos).getAnombre2());
                txtRDEa2.setText(dependeA.get(pos).getArelacion2());
                txtEDEa2.setText(dependeA.get(pos).getAedad2());
                txtTDEa2.setText(dependeA.get(pos).getAtelefono2());
                txtNDEa3.setText(dependeA.get(pos).getAnombre3());
                txtRDEa3.setText(dependeA.get(pos).getArelacion3());
                txtEDEa3.setText(dependeA.get(pos).getAedad3());
                txtTDEa3.setText(dependeA.get(pos).getAtelefono3());
                //HISTORIAL ESCOLAR
                txtNEa.setText(datosHE.get(pos).getAnombreact());
                txtDEa.setText(datosHE.get(pos).getAdireccionact());
                txtTea.setText(datosHE.get(pos).getAtelefonoact());
                txtNIEa.setText(datosHE.get(pos).getAnivelact());
                txtNEa1.setText(datosHE.get(pos).getAnombreant1());
                txtLE1.setText(datosHE.get(pos).getAlocalidad1());
                txtGC1.setText(datosHE.get(pos).getAgradoant1());
                //HISTORIAL LABORAL
                txtNTa.setText(labor.get(pos).getAnombre());
                txtDTa.setText(labor.get(pos).getAdireccion());
                txtATa.setText(labor.get(pos).getAantiguedad());
                txtTTa.setText(labor.get(pos).getAtelefono());
                txtJTa.setText(labor.get(pos).getAjefe());

                txtNT1.setText(labor.get(pos).getAnombreant());
                txtLT1.setText(labor.get(pos).getAlocalidad());
                txtAT1.setText(labor.get(pos).getAatiguedadant());
                txtTT1.setText(labor.get(pos).getAtelefonoant());
                //ACTIVIDADES EXTRAESCOLARES
                txtA1.setText(actividades.get(pos).getAactividad());
                txtL1.setText(actividades.get(pos).getAlocalidad());
                txtC1.setText(actividades.get(pos).getAcontacto());
                txtT1.setText(actividades.get(pos).getAtelefono());
                //CONSUMO DE SUSUTANCIAS
                txtCaA.setText(consumo.get(pos).getAcantidad_alcohol());
                txtFDCA.setText(consumo.get(pos).getAultimo_consumo_alcohol());
                txtCaT.setText(consumo.get(pos).getAcantidad_tabaco());
                txtFDCT.setText(consumo.get(pos).getAultimo_consumo_tabaco());
                txtCaMAR.setText(consumo.get(pos).getAcantidad_marihuana());
                txtFDCMAR.setText(consumo.get(pos).getAultimo_consumo_marihuana());
                txtCaPAS.setText(consumo.get(pos).getAcantidad_pastillas());
                txtFDCPAS.setText(consumo.get(pos).getAultimo_consumo_pastillas());
                txtCaSOL.setText(consumo.get(pos).getAcantidad_solventes());
                txtFDCSOL.setText(consumo.get(pos).getAultimo_consumo_solventes());
                txtCaMET.setText(consumo.get(pos).getAcantidad_metanfetaminas());
                txtFDCMET.setText(consumo.get(pos).getAultimo_consumo_metanfetaminas());
                txtCaCOCA.setText(consumo.get(pos).getAcantidad_cocaina());
                txtFDCCOCA.setText(consumo.get(pos).getAultimo_consumo_cocaina());
                txtOPS.setText(consumo.get(pos).getAobservacionesfinales());
                //INFORME DE CASO ACTUAL
                txtEspe.setText(casoA.get(pos).getAotro());
                //PROCESOS PENALES PREVIOS
                txtNC1.setText(prosecoA.get(pos).getAcausa1());
                txtD1.setText(prosecoA.get(pos).getAdelito1());
                txtTM1.setText(prosecoA.get(pos).getAdelito1());
                txtNC2.setText(prosecoA.get(pos).getAcausa2());
                txtD2.setText(prosecoA.get(pos).getAdelito2());
                txtTM2.setText(prosecoA.get(pos).getAdelito2());
                txtNC3.setText(prosecoA.get(pos).getAcausa3());
                txtD3.setText(prosecoA.get(pos).getAdelito3());
                txtTM3.setText(prosecoA.get(pos).getAdelito3());
                txtNC4.setText(prosecoA.get(pos).getAcausa4());
                txtD4.setText(prosecoA.get(pos).getAdelito4());
                txtTM4.setText(prosecoA.get(pos).getAdelito4());
                txtNC5.setText(prosecoA.get(pos).getAcausa5());
                txtD5.setText(prosecoA.get(pos).getAdelito5());
                txtTM5.setText(prosecoA.get(pos).getAdelito5());
                //PROCESO LEGAL

                txtEx1.setText(legalA.get(pos).getAexpliquecontinuo());
                txtEx2.setText(legalA.get(pos).getAexpliqueamenaza());

                //region SPINNER


                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                Date date1 = new Date();

                String fecha1 = dateFormat1.format(date1);


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


                //endregion
                // region TIPO DE RELACION
                sPRDFa1 = (Spinner) findViewById(R.id.sPRDFa1);
                sPRDFa1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, tipoR));
                String rS13;
                rS13 = datosFA.get(pos).getArelacion1();
                for (int i=0; i<tipoR.length; i++){
                    if(rS13.equals(tipoR[i])){
                        sPRDFa1.setSelection(i);
                    }
                }
                //endregion
                // region TIPO DE RELACION 2
                sPRDFa2 = (Spinner) findViewById(R.id.sPRDFa2);
                sPRDFa2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, tipoR));
                String rS16;
                rS16 = datosFA.get(pos).getArelacion2();
                for (int i=0; i<tipoR.length; i++){
                    if(rS16.equals(tipoR[i])){
                        sPRDFa2.setSelection(i);
                    }
                }
                //endregion
                // region  Relacion Participante  1
                sPRa1 = (Spinner) findViewById(R.id.sPRa1);
                sPRa1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, tipoR));
                String rS1;
                rS1 = respo.get(pos).getArelacion1();
                for (int i=0; i<tipoR.length; i++){
                    if(rS1.equals(tipoR[i])){
                        sPRa1.setSelection(i);
                    }
                }
                //endregion
                // region Relacion Participante  2
                sPRa2 = (Spinner) findViewById(R.id.sPRa2);
                sPRa2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, tipoR));
                String rS2;
                rS2 = respo.get(pos).getArelacion2();
                for (int i=0; i<tipoR.length; i++){
                    if(rS2.equals(tipoR[i])){
                        sPRa2.setSelection(i);
                    }
                }
                //endregion
                // region Participante oyente 1
                sPPar1 = (Spinner) findViewById(R.id.sPPar1);
                sPPar1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, part));
                String rS3;
                rS3 = respo.get(pos).getAoyente1();
                for (int i=0; i<part.length; i++){
                    if(rS3.equals(part[i])){
                        sPPar1.setSelection(i);
                    }
                }
                //endregion

                // region Participante oyente 2
                sPPar2 = (Spinner) findViewById(R.id.sPPar2);
                sPPar2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, part));
                String rS4;
                rS4 = respo.get(pos).getAoyente2();
                for (int i=0; i<part.length; i++){
                    if(rS4.equals(part[i])){
                        sPPar2.setSelection(i);
                    }
                }
                //endregion

                // region sPSes
                sPSex = (Spinner) findViewById(R.id.sPSex);
                sPSex.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, sexo));
                String rS5;
                rS5 = datosgenerales.get(pos).getAsexo();
                for (int i=0; i<sexo.length; i++){
                    if(rS5.equals(sexo[i])){
                        sPSex.setSelection(i);
                    }
                }
                sPSex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="MASCULINO"){
                            tvEE.setVisibility(View.GONE);
                            sPEE.setVisibility(View.GONE);
                            tvEM.setVisibility(View.GONE);
                            sPEM.setVisibility(View.GONE);
                        }
                        if (selectedItem=="FEMENINO"){
                            tvEE.setVisibility(View.VISIBLE);
                            sPEE.setVisibility(View.VISIBLE);
                            tvEM.setVisibility(View.VISIBLE);
                            sPEM.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });



                //endregion
                // region sPCOLa
                sPCOLa = (Spinner) findViewById(R.id.sPCOLa);
                sPCOLa.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, colfracc));
                //Seleccion de lo que el sppineer traia en la base detados
                String rS8;
                rS8 = datosFF.get(pos).getAcolonia();
                for (int i=0; i<colfracc.length; i++){
                    if(rS8.equals(colfracc[i])){
                        sPCOLa.setSelection(i);
                    }
                }
                //endregion
                //region tvCOLa1 set de spinner
                tvCOLa1=(TextView) findViewById(R.id.tvCOLa1);

                sPCOLa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="N/A"){
                            tvCOLa1.setText("Nombre de ");
                        }
                        if (selectedItem=="COLONIA"){
                            tvCOLa1.setText("Nombre de Colonia");
                        }
                        if (selectedItem=="FRACCIONAMIENTO"){
                            tvCOLa1.setText("Nombre de Fraccionamiento");
                        }
                        if (selectedItem=="DOMICILIO CONOCIDO"){
                            tvCOLa1.setText("Nombre de Domicilio Conocido");
                        }
                        if (selectedItem=="EJIDO"){
                            tvCOLa1.setText("Nombre de Ejido");
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });


                //endregion


                // region sPTa

                sPTa = (Spinner) findViewById(R.id.sPTa);
                sPTa.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, tiempoRadicando));
                String rS9;
                rS9 = datosFF.get(pos).getAtemporalidad();
                for (int i=0; i<tiempoRadicando.length; i++){
                    if(rS9.equals(tiempoRadicando[i])){
                        sPTa.setSelection(i);
                    }
                }
                //endregion
                // region sPUGa
                sPUGa = (Spinner) findViewById(R.id.sPUGa);
                sPUGa.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, gradoEstudios));
                String rS26;
                rS26 = datosHE.get(pos).getAgrado();
                for (int i=0; i<gradoEstudios.length; i++){
                    if(rS26.equals(gradoEstudios[i])){
                        sPUGa.setSelection(i);
                    }
                }
                //endregion

                // region sPIdio
                sPIdio = (Spinner) findViewById(R.id.sPIdio);
                sPIdio.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS6;
                rS6 = datosgenerales.get(pos).getAtraductor();
                for (int i=0; i<nosi.length; i++){
                    if(rS6.equals(nosi[i])){
                        sPIdio.setSelection(i);
                    }
                }
                //endregion

                // region sPTra
                sPTra = (Spinner) findViewById(R.id.sPTra);
                sPTra.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, sino));
                String rS7;
                rS7 = datosgenerales.get(pos).getAespanol();
                for (int i=0; i<sino.length; i++){
                    if(rS7.equals(sino[i])){
                        sPTra.setSelection(i);
                    }
                }
                //endregion
                // region sPDfa
                sPDfa = (Spinner) findViewById(R.id.sPDfa);
                sPDfa.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS10;
                rS10 = datosFF.get(pos).getAdomiciliof();
                for (int i=0; i<nosi.length; i++){
                    if(rS10.equals(nosi[i])){
                        sPDfa.setSelection(i);
                    }
                }
                //endregions

                // region sPVDF vive con el
                sPVDF1 = (Spinner) findViewById(R.id.sPVDF1);
                sPVDF1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS15;
                rS15 = datosFA.get(pos).getAvivecon1();
                for (int i=0; i<nosia.length; i++){
                    if(rS15.equals(nosia[i])){
                        sPVDF1.setSelection(i);
                    }
                }
                //endregion
                // region sPVDF vive con el 2
                sPVDF2 = (Spinner) findViewById(R.id.sPVDF2);
                sPVDF2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS17;
                rS17 = datosFA.get(pos).getAvivecon2();
                for (int i=0; i<nosia.length; i++){
                    if(rS17.equals(nosia[i])){
                        sPVDF2.setSelection(i);
                    }
                }
                //endregion

                // region sPAR  ADOLECENTE RESPONSABLE1
                sPAR1 = (Spinner) findViewById(R.id.sPAR1);
                sPAR1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS21;
                rS21 = dependeA.get(pos).getAresponsable1();
                for (int i=0; i<nosia.length; i++){
                    if(rS21.equals(nosia[i])){
                        sPAR1.setSelection(i);
                    }
                }
                //endregion
                // region sPAR  ADOLECENTE RESPONSABLE2
                sPAR2 = (Spinner) findViewById(R.id.sPAR2);
                sPAR2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS22;
                rS22 = dependeA.get(pos).getAresponsable2();
                for (int i=0; i<nosia.length; i++){
                    if(rS22.equals(nosia[i])){
                        sPAR2.setSelection(i);
                    }
                }                //endregion
                // region sPAR  ADOLECENTE RESPONSABLE3
                sPAR3 = (Spinner) findViewById(R.id.sPAR3);
                sPAR3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS23;
                rS23 = dependeA.get(pos).getAresponsable3();
                for (int i=0; i<nosia.length; i++){
                    if(rS23.equals(nosia[i])){
                        sPAR3.setSelection(i);
                    }
                }
                //endregion

                // region sPCS  CONCLUYO LA SECUNDARIA
                sPCS = (Spinner) findViewById(R.id.sPCS);
                sPCS.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS25;
                rS25 = datosHE.get(pos).getAconcluyo();
                for (int i=0; i<nosi.length; i++){
                    if(rS25.equals(nosi[i])){
                        sPCS.setSelection(i);
                    }
                }
                //endregion
                // region sPTR  TRABAJO RE|CURRENTE
                sPTR = (Spinner) findViewById(R.id.sPTR);
                sPTR.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS28;
                rS28 = labor.get(pos).getArecurrente();
                for (int i=0; i<nosi.length; i++){
                    if(rS28.equals(nosi[i])){
                        sPTR.setSelection(i);
                    }
                }
                //endregion
                // region sPTC  TIEMPO COMPLETO
                sPTC = (Spinner) findViewById(R.id.sPTC);
                sPTC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS29;
                rS29= labor.get(pos).getArecurrente();
                for (int i=0; i<nosi.length; i++){
                    if(rS29.equals(nosi[i])){
                        sPTC.setSelection(i);
                    }
                }
                //endregion
                // region sPEE  ESTA ENBARAZADA
                sPEE = (Spinner) findViewById(R.id.sPEE);
                sPEE.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS32;
                rS32 = salud.get(pos).getAembarazada();
                for (int i=0; i<nosia.length; i++){
                    if(rS32.equals(nosia[i])){
                        sPEE.setSelection(i);
                    }
                }
                //endregion
                // region sPEM  ES MADRE
                sPEM = (Spinner) findViewById(R.id.sPEM);
                sPEM.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS33;
                rS33 = salud.get(pos).getAmadre();
                for (int i=0; i<nosia.length; i++){
                    if(rS33.equals(nosia[i])){
                        sPEM.setSelection(i);
                    }
                }
                //endregion
                // region sPC  CUAL?
                sPC = (Spinner) findViewById(R.id.sPC);
                sPC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, malo));
                String rS35;
                rS35 = salud.get(pos).getAcual();
                for (int i=0; i<malo.length; i++){
                    if(rS35.equals(malo[i])){
                        sPC.setSelection(i);
                    }
                }
                //endregion

                // region sPCD  CUENTA CON DISCAPACIDAD////////////////////////
                sPCD = (Spinner) findViewById(R.id.sPCD);
                sPCD.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS36;
                rS36 = salud.get(pos).getAdiscapacidad();
                for (int i=0; i<nosi.length; i++){
                    if(rS36.equals(nosi[i])){
                        sPCD.setSelection(i);
                    }
                }
                //endregion


                // region sPCD  CEVALUADOR
                sPEV = (Spinner) findViewById(R.id.sPEV);
                sPEV.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS38;
                rS38 = salud.get(pos).getAentrevistador();
                for (int i=0; i<nosi.length; i++){
                    if(rS38.equals(nosi[i])){
                        sPEV.setSelection(i);
                    }
                }
                //endregion

                sPSIDA= (Spinner) findViewById(R.id.sPSIDA);
                sPSIDA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS37;
                rS37 = salud.get(pos).getAmedicamento();
                for (int i=0; i<nosi.length; i++){
                    if(rS37.equals(nosi[i])){
                        sPSIDA.setSelection(i);
                    }
                }

                //region CONSUMOSSSSS sPCALC
                sPCALC= (Spinner) findViewById(R.id.sPCALC);
                sPCALC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS40;
                rS40 = consumo.get(pos).getAfrecuencia_alcohol();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS40.equals(frecuenciaConsumo[i])){
                        sPCALC.setSelection(i);
                    }
                }

                sPCTBC= (Spinner) findViewById(R.id.sPCTBC);
                sPCTBC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS42;
                rS42 = consumo.get(pos).getAfrecuencia_tabaco();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS42.equals(frecuenciaConsumo[i])){
                        sPCTBC.setSelection(i);
                    }
                }


                sPCSOL= (Spinner) findViewById(R.id.sPCSOL);
                sPCSOL.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS48;
                rS48 = consumo.get(pos).getAfrecuencia_solventes();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS48.equals(frecuenciaConsumo[i])){
                        sPCSOL.setSelection(i);
                    }
                }

                sPCMAR= (Spinner) findViewById(R.id.sPCMAR);
                sPCMAR.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS44;
                rS44 = consumo.get(pos).getAfrecuencia_marihuana();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS44.equals(frecuenciaConsumo[i])){
                        sPCMAR.setSelection(i);
                    }
                }

                sPCCOCA= (Spinner) findViewById(R.id.sPCCOCA);
                sPCCOCA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS52;
                rS52 = consumo.get(pos).getAfrecuencia_cocaina();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS52.equals(frecuenciaConsumo[i])){
                        sPCCOCA.setSelection(i);
                    }
                }


                sPCPAS= (Spinner) findViewById(R.id.sPCPAS);
                sPCPAS.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS46;
                rS46 = consumo.get(pos).getAfrecuencia_pastillas();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS46.equals(frecuenciaConsumo[i])){
                        sPCPAS.setSelection(i);
                    }
                }

                sPCMET= (Spinner) findViewById(R.id.sPCMET);
                sPCMET.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, frecuenciaConsumo));
                String rS50;
                rS50 = consumo.get(pos).getAfrecuencia_metanfetaminas();
                for (int i=0; i<frecuenciaConsumo.length; i++){
                    if(rS50.equals(frecuenciaConsumo[i])){
                        sPCMET.setSelection(i);
                    }
                }

                sPSUSF= (Spinner) findViewById(R.id.sPSUSF);
                sPSUSF.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS53;
                rS53 = consumo.get(pos).getAconsumemas();
                for (int i=0; i<nosi.length; i++){
                    if(rS53.equals(nosi[i])){
                        sPSUSF.setSelection(i);
                    }
                }

                //endregion

                //region VisibleSpinner
                // region sPDfa
                sPRef = (Spinner) findViewById(R.id.sPRef);
                sPRef.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nPersonasR));
                String rS12;
                rS12 = datosFA.get(pos).getApersonasreferencias();
                for (int i=0; i<nPersonasR.length; i++){
                    if(rS12.equals(nPersonasR[i])){
                        sPRef.setSelection(i);
                    }
                }
                sPRef.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        switch (selectedItem){
                            case "N/A":
                                Referencia1A.setVisibility(View.GONE);
                                tvNDFa1.setVisibility(View.GONE);
                                txtNDFa1.setVisibility(View.GONE);
                                tvRDFa1.setVisibility(View.GONE);
                                sPRDFa1.setVisibility(View.GONE);
                                tvEDFa1.setVisibility(View.GONE);
                                txtEDFa1.setVisibility(View.GONE);
                                tvTDFa1.setVisibility(View.GONE);
                                txtTDFa1.setVisibility(View.GONE);
                                tvVDF1.setVisibility(View.GONE);
                                sPVDF1.setVisibility(View.GONE);
                                CPPe.setVisibility(View.GONE);
                                sPPe.setVisibility(View.GONE);

                                Referencia2A.setVisibility(View.GONE);
                                tvNDFa2.setVisibility(View.GONE);
                                txtNDFa2.setVisibility(View.GONE);
                                tvRDFa2.setVisibility(View.GONE);
                                sPRDFa2.setVisibility(View.GONE);
                                tvEDFa2.setVisibility(View.GONE);
                                txtEDFa2.setVisibility(View.GONE);
                                tvTDFa2.setVisibility(View.GONE);
                                txtTDFa2.setVisibility(View.GONE);
                                tvVDF2.setVisibility(View.GONE);
                                sPVDF2.setVisibility(View.GONE);

                                break;
                            case "1":
                                Referencia1A.setVisibility(View.VISIBLE);
                                tvNDFa1.setVisibility(View.VISIBLE);
                                txtNDFa1.setVisibility(View.VISIBLE);
                                tvRDFa1.setVisibility(View.VISIBLE);
                                sPRDFa1.setVisibility(View.VISIBLE);
                                tvEDFa1.setVisibility(View.VISIBLE);
                                txtEDFa1.setVisibility(View.VISIBLE);
                                tvTDFa1.setVisibility(View.VISIBLE);
                                txtTDFa1.setVisibility(View.VISIBLE);
                                tvVDF1.setVisibility(View.VISIBLE);
                                sPVDF1.setVisibility(View.VISIBLE);
                                CPPe.setVisibility(View.VISIBLE);
                                sPPe.setVisibility(View.VISIBLE);

                                Referencia2A.setVisibility(View.GONE);
                                tvNDFa2.setVisibility(View.GONE);
                                txtNDFa2.setVisibility(View.GONE);
                                tvRDFa2.setVisibility(View.GONE);
                                sPRDFa2.setVisibility(View.GONE);
                                tvEDFa2.setVisibility(View.GONE);
                                txtEDFa2.setVisibility(View.GONE);
                                tvTDFa2.setVisibility(View.GONE);
                                txtTDFa2.setVisibility(View.GONE);
                                tvVDF2.setVisibility(View.GONE);
                                sPVDF2.setVisibility(View.GONE);
                                break;
                            case "2":
                                Referencia1A.setVisibility(View.VISIBLE);
                                tvNDFa1.setVisibility(View.VISIBLE);
                                txtNDFa1.setVisibility(View.VISIBLE);
                                tvRDFa1.setVisibility(View.VISIBLE);
                                sPRDFa1.setVisibility(View.VISIBLE);
                                tvEDFa1.setVisibility(View.VISIBLE);
                                txtEDFa1.setVisibility(View.VISIBLE);
                                tvTDFa1.setVisibility(View.VISIBLE);
                                txtTDFa1.setVisibility(View.VISIBLE);
                                tvVDF1.setVisibility(View.VISIBLE);
                                sPVDF1.setVisibility(View.VISIBLE);
                                CPPe.setVisibility(View.VISIBLE);
                                sPPe.setVisibility(View.VISIBLE);

                                Referencia2A.setVisibility(View.VISIBLE);
                                tvNDFa2.setVisibility(View.VISIBLE);
                                txtNDFa2.setVisibility(View.VISIBLE);
                                tvRDFa2.setVisibility(View.VISIBLE);
                                sPRDFa2.setVisibility(View.VISIBLE);
                                tvEDFa2.setVisibility(View.VISIBLE);
                                txtEDFa2.setVisibility(View.VISIBLE);
                                tvTDFa2.setVisibility(View.VISIBLE);
                                txtTDFa2.setVisibility(View.VISIBLE);
                                tvVDF2.setVisibility(View.VISIBLE);
                                sPVDF2.setVisibility(View.VISIBLE);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });


                //endregionsPRef


                //region sPPe vive con las personas presentes
                sPPe = (Spinner) findViewById(R.id.sPPe);
                sPPe.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS14;
                rS14 = datosFA.get(pos).getAviveconel();
                for (int i=0; i<nosia.length; i++){
                    if(rS14.equals(nosia[i])){
                        sPPe.setSelection(i);
                    }
                }
                sPPe.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtNDFa1.setText(txtNpa1.getText());
                            txtNDFa2.setText(txtNpa2.getText());
                            String relacion1 = sPRa1.getSelectedItem().toString();
                            switch(relacion1){
                                case "N/A":
                                    sPRDFa1.setSelection(0);
                                    break;
                                case "PADRE":
                                    sPRDFa1.setSelection(1);
                                    break;
                                case "MADRE":
                                    sPRDFa1.setSelection(2);
                                    break;
                                case "ABUELO":
                                    sPRDFa1.setSelection(3);
                                    break;
                                case "ABUELA":
                                    sPRDFa1.setSelection(4);
                                    break;
                                case "HERMANO(A)":
                                    sPRDFa1.setSelection(5);
                                    break;
                                case "TUTOR(A)":
                                    sPRDFa1.setSelection(6);
                                    break;
                                case "FAMILIA INDIRECTA":
                                    sPRDFa1.setSelection(7);
                                    break;
                                case "CONOCIDO(A)":
                                    sPRDFa1.setSelection(8);
                                    break;
                            }

                            String relacion2 = sPRa2.getSelectedItem().toString();
                            switch(relacion2){
                                case "N/A":
                                    sPRDFa2.setSelection(0);
                                    break;
                                case "PADRE":
                                    sPRDFa2.setSelection(1);
                                    break;
                                case "MADRE":
                                    sPRDFa2.setSelection(2);
                                    break;
                                case "ABUELO":
                                    sPRDFa2.setSelection(3);
                                    break;
                                case "ABUELA":
                                    sPRDFa2.setSelection(4);
                                    break;
                                case "HERMANO(A)":
                                    sPRDFa2.setSelection(5);
                                    break;
                                case "TUTOR(A)":
                                    sPRDFa2.setSelection(6);
                                    break;
                                case "FAMILIA INDIRECTA":
                                    sPRDFa2.setSelection(7);
                                    break;
                                case "CONOCIDO(A)":
                                    sPRDFa2.setSelection(8);
                                    break;
                            }

                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion


                // region sPDA DOMICILIOS ANTERIORES
                sPDA = (Spinner) findViewById(R.id.sPDA);
                sPDA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS11;
                rS11 = datosFF.get(pos).getAdomicilioant();
                for (int i=0; i<nosi.length; i++){
                    if(rS11.equals(nosi[i])){
                        sPDA.setSelection(i);
                    }
                }
                sPDA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            tvD1A.setVisibility(View.VISIBLE);
                            tvD2A.setVisibility(View.VISIBLE);
                            tvD3A.setVisibility(View.VISIBLE);
                            txtDALa1.setVisibility(View.VISIBLE);
                            txtDALa2.setVisibility(View.VISIBLE);
                            txtDATa3.setVisibility(View.VISIBLE);
                            tvDA1.setVisibility(View.VISIBLE);
                            tvDA2.setVisibility(View.VISIBLE);
                            tvDATa1.setVisibility(View.VISIBLE);
                            txtDATa1.setVisibility(View.VISIBLE);
                            txtDATa2.setVisibility(View.VISIBLE);
                            tvDATa2.setVisibility(View.VISIBLE);
                            tvDALa3.setVisibility(View.VISIBLE);
                            txtDALa3.setVisibility(View.VISIBLE);
                            tvDATa3.setVisibility(View.VISIBLE);

                        }
                        else{
                            tvD1A.setVisibility(View.GONE);
                            tvD2A.setVisibility(View.GONE);
                            tvD3A.setVisibility(View.GONE);
                            txtDALa1.setVisibility(View.GONE);
                            txtDALa2.setVisibility(View.GONE);
                            txtDATa3.setVisibility(View.GONE);
                            tvDA1.setVisibility(View.GONE);
                            tvDA2.setVisibility(View.GONE);
                            tvDATa1.setVisibility(View.GONE);
                            txtDATa1.setVisibility(View.GONE);
                            txtDATa2.setVisibility(View.GONE);
                            tvDATa2.setVisibility(View.GONE);
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
                sPRD.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS18;
                rS18 = datosFA.get(pos).getAubicarfam();
                for (int i=0; i<nosi.length; i++){
                    if(rS18.equals(nosi[i])){
                        sPRD.setSelection(i);
                    }
                }
                sPRD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
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

                sPDE = (Spinner) findViewById(R.id.sPDE);
                sPDE.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nPersonas));
                String rS20;
                rS20 = dependeA.get(pos).getAndependientes();
                for (int i=0; i<nPersonas.length; i++){
                    if(rS20.equals(nPersonas[i])){
                        sPDE.setSelection(i);
                    }
                }
                sPDE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        switch (selectedItem){
                            case "N/A":
                                tvDPA1.setVisibility(View.GONE);
                                tvDPA2.setVisibility(View.GONE);
                                tvDPA3.setVisibility(View.GONE);
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
                                break;
                            case "1":
                                tvDPA1.setVisibility(View.VISIBLE);
                                tvDPA2.setVisibility(View.GONE);
                                tvDPA3.setVisibility(View.GONE);
                                txtNDEa1.setVisibility(View.VISIBLE);
                                txtNDEa2.setVisibility(View.GONE);
                                txtNDEa3.setVisibility(View.GONE);
                                txtRDEa1.setVisibility(View.VISIBLE);
                                txtRDEa2.setVisibility(View.GONE);
                                txtRDEa3.setVisibility(View.GONE);
                                txtEDEa1.setVisibility(View.VISIBLE);
                                txtEDEa2.setVisibility(View.GONE);
                                txtEDEa3.setVisibility(View.GONE);
                                txtTDEa1.setVisibility(View.VISIBLE);
                                txtTDEa2.setVisibility(View.GONE);
                                txtTDEa3.setVisibility(View.GONE);
                                tvNDEa1.setVisibility(View.VISIBLE);
                                tvRDEa1.setVisibility(View.VISIBLE);
                                tvEDEa1.setVisibility(View.VISIBLE);
                                tvTDEa1.setVisibility(View.VISIBLE);
                                tvNDEa2.setVisibility(View.GONE);
                                tvRDEa2.setVisibility(View.GONE);
                                tvEDEa2.setVisibility(View.GONE);
                                tvTDEa2.setVisibility(View.GONE);
                                tvNDEa3.setVisibility(View.GONE);
                                tvRDEa3.setVisibility(View.GONE);
                                tvEDEa3.setVisibility(View.GONE);
                                tvTDEa3.setVisibility(View.GONE);
                                tvAR.setVisibility(View.VISIBLE);
                                tvAR2.setVisibility(View.GONE);
                                tvAR3.setVisibility(View.GONE);
                                sPAR1.setVisibility(View.VISIBLE);
                                sPAR2.setVisibility(View.GONE);
                                sPAR2.setVisibility(View.GONE);
                                sPAR3.setVisibility(View.GONE);
                                break;
                            case "2":
                                tvDPA1.setVisibility(View.VISIBLE);
                                tvDPA2.setVisibility(View.VISIBLE);
                                tvDPA3.setVisibility(View.GONE);
                                txtNDEa1.setVisibility(View.VISIBLE);
                                txtNDEa2.setVisibility(View.VISIBLE);
                                txtNDEa3.setVisibility(View.GONE);
                                txtRDEa1.setVisibility(View.VISIBLE);
                                txtRDEa2.setVisibility(View.VISIBLE);
                                txtRDEa3.setVisibility(View.GONE);
                                txtEDEa1.setVisibility(View.VISIBLE);
                                txtEDEa2.setVisibility(View.VISIBLE);
                                txtEDEa3.setVisibility(View.GONE);
                                txtTDEa1.setVisibility(View.VISIBLE);
                                txtTDEa2.setVisibility(View.VISIBLE);
                                txtTDEa3.setVisibility(View.GONE);
                                tvNDEa1.setVisibility(View.VISIBLE);
                                tvRDEa1.setVisibility(View.VISIBLE);
                                tvEDEa1.setVisibility(View.VISIBLE);
                                tvTDEa1.setVisibility(View.VISIBLE);
                                tvNDEa2.setVisibility(View.VISIBLE);
                                tvRDEa2.setVisibility(View.VISIBLE);
                                tvEDEa2.setVisibility(View.VISIBLE);
                                tvTDEa2.setVisibility(View.VISIBLE);
                                tvNDEa3.setVisibility(View.GONE);
                                tvRDEa3.setVisibility(View.GONE);
                                tvEDEa3.setVisibility(View.GONE);
                                tvTDEa3.setVisibility(View.GONE);
                                tvAR.setVisibility(View.VISIBLE);
                                tvAR2.setVisibility(View.VISIBLE);
                                tvAR3.setVisibility(View.GONE);
                                sPAR1.setVisibility(View.VISIBLE);
                                sPAR2.setVisibility(View.VISIBLE);
                                sPAR2.setVisibility(View.VISIBLE);
                                sPAR3.setVisibility(View.GONE);
                                break;
                            case "3":
                                tvDPA1.setVisibility(View.VISIBLE);
                                tvDPA2.setVisibility(View.VISIBLE);
                                tvDPA3.setVisibility(View.VISIBLE);
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
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });


                //endregion
                // region sPDE DEPENDIENTES ECONOMICOS
                sPDE_1 = (Spinner) findViewById(R.id.sPDE_1);
                sPDE_1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS19;
                rS19 = dependeA.get(pos).getAdependientes();
                for (int i=0; i<nosi.length; i++){
                    if(rS19.equals(nosi[i])){
                        sPDE_1.setSelection(i);
                    }
                }
                sPDE_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            sPDE.setVisibility(View.VISIBLE);
                            tvDE.setVisibility(View.VISIBLE);
                        }
                        else{
                            sPDE.setVisibility(View.GONE);
                            tvDE.setVisibility(View.GONE);
                            tvDPA1.setVisibility(View.GONE);
                            tvDPA2.setVisibility(View.GONE);
                            tvDPA3.setVisibility(View.GONE);
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
                // region sPTAA  TRABAJA ACTUALMENTE
                sPTAA = (Spinner) findViewById(R.id.sPTAA);
                sPTAA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS27;
                rS27 = labor.get(pos).getAtrabaja();
                for (int i=0; i<nosi.length; i++){
                    if(rS27.equals(nosi[i])){
                        sPTAA.setSelection(i);
                    }
                }
                sPTAA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtJTa.setVisibility(View.VISIBLE);
                            tvJTa.setVisibility(View.VISIBLE);
                            sPTC.setVisibility(View.VISIBLE);
                            tvTC.setVisibility(View.VISIBLE);
                            txtATa.setVisibility(View.VISIBLE);
                            tvATa.setVisibility(View.VISIBLE);
                            txtTTa.setVisibility(View.VISIBLE);
                            tvTTa.setVisibility(View.VISIBLE);
                            txtDTa.setVisibility(View.VISIBLE);
                            tvDTa.setVisibility(View.VISIBLE);
                            txtNTa.setVisibility(View.VISIBLE);
                            tvNTa.setVisibility(View.VISIBLE);
                            tvTAA.setVisibility(View.VISIBLE);
                            sPTR.setVisibility(View.VISIBLE);
                            tvTR.setVisibility(View.VISIBLE);
                        }
                        else{
                            txtJTa.setVisibility(View.GONE);
                            tvJTa.setVisibility(View.GONE);
                            sPTC.setVisibility(View.GONE);
                            tvTC.setVisibility(View.GONE);
                            txtATa.setVisibility(View.GONE);
                            tvATa.setVisibility(View.GONE);
                            txtTTa.setVisibility(View.GONE);
                            tvTTa.setVisibility(View.GONE);
                            txtDTa.setVisibility(View.GONE);
                            tvDTa.setVisibility(View.GONE);
                            txtNTa.setVisibility(View.GONE);
                            tvNTa.setVisibility(View.GONE);
                            tvTAA.setVisibility(View.GONE);
                            sPTR.setVisibility(View.GONE);
                            tvTR.setVisibility(View.GONE);


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
                sPTA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS30;
                rS30 = labor.get(pos).getAtrabajoant();
                for (int i=0; i<nosi.length; i++){
                    if(rS30.equals(nosi[i])){
                        sPTA.setSelection(i);
                    }
                }
                sPTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtNT1.setVisibility(View.VISIBLE);
                            txtLT1.setVisibility(View.VISIBLE);
                            txtAT1.setVisibility(View.VISIBLE);
                            txtTT1.setVisibility(View.VISIBLE);
                            tvNT1.setVisibility(View.VISIBLE);
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

                //region sPAE  TACTIVIDADES EXTRAESCOLARES ACTUALES
                sPAE = (Spinner) findViewById(R.id.sPAE);
                sPAE.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS24;
                rS24 = datosHE.get(pos).getAasiste();
                for (int i=0; i<nosi.length; i++){
                    if(rS24.equals(nosi[i])){
                        sPAE.setSelection(i);
                    }
                }
                sPAE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtNEa.setVisibility(View.VISIBLE);
                            tvTVEA.setVisibility(View.VISIBLE);
                            tvNEa.setVisibility(View.VISIBLE);
                            tvDEa.setVisibility(View.VISIBLE);
                            txtDEa.setVisibility(View.VISIBLE);
                            tvTea.setVisibility(View.VISIBLE);
                            txtTea.setVisibility(View.VISIBLE);
                            tvNIEa.setVisibility(View.VISIBLE);
                            txtNIEa.setVisibility(View.VISIBLE);
                        }
                        else{
                            txtNEa.setVisibility(View.GONE);
                            tvTVEA.setVisibility(View.GONE);
                            tvNEa.setVisibility(View.GONE);
                            tvDEa.setVisibility(View.GONE);
                            txtDEa.setVisibility(View.GONE);
                            tvTea.setVisibility(View.GONE);
                            txtTea.setVisibility(View.GONE);
                            tvNIEa.setVisibility(View.GONE);
                            txtNIEa.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion sPAE  TACTIVIDADES EXTRAESCOLARES ACTUALES


                // region sPAEA  TACTIVIDADES EXTRAESCOLARES ACTUALES
                sPAEA = (Spinner) findViewById(R.id.sPAEA);
                sPAEA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS31;
                rS31 = actividades.get(pos).getArealiza();
                for (int i=0; i<nosi.length; i++){
                    if(rS31.equals(nosi[i])){
                        sPAEA.setSelection(i);
                    }
                }
                sPAEA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
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

                // region sPCD  CUENTA CON DISCAPACIDAD
                sPTE= (Spinner) findViewById(R.id.sPTE);
                sPTE.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS34;
                rS34 = salud.get(pos).getAenfermendad();
                for (int i=0; i<nosi.length; i++){
                    if(rS34.equals(nosi[i])){
                        sPTE.setSelection(i);
                    }
                }
                sPTE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            tvPC.setVisibility(View.VISIBLE);
                            sPC.setVisibility(View.VISIBLE);
                        }
                        else{
                            sPC.setVisibility(View.GONE);
                            tvPC.setVisibility(View.GONE);
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
                sPALC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS39;
                rS39 = consumo.get(pos).getAconsume_alcohol();
                for (int i=0; i<nosi.length; i++){
                    if(rS39.equals(nosi[i])){
                        sPALC.setSelection(i);
                    }
                }
                sPALC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPTBC.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS41;
                rS41 = consumo.get(pos).getAconsume_tabaco();
                for (int i=0; i<nosi.length; i++){
                    if(rS41.equals(nosi[i])){
                        sPTBC.setSelection(i);
                    }
                }
                sPTBC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPSOL.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS47;
                rS47 = consumo.get(pos).getAconsume_solventes();
                for (int i=0; i<nosi.length; i++){
                    if(rS47.equals(nosi[i])){
                        sPSOL.setSelection(i);
                    }
                }
                sPSOL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPMAR.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS43;
                rS43 = consumo.get(pos).getAconsume_marihuana();
                for (int i=0; i<nosi.length; i++){
                    if(rS43.equals(nosi[i])){
                        sPMAR.setSelection(i);
                    }
                }
                sPMAR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPCOCA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS51;
                rS51 = consumo.get(pos).getAconsume_cocaina();
                for (int i=0; i<nosi.length; i++){
                    if(rS51.equals(nosi[i])){
                        sPCOCA.setSelection(i);
                    }
                }
                sPCOCA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPPAS.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS45;
                rS45 = consumo.get(pos).getAconsume_pastillas();
                for (int i=0; i<nosi.length; i++){
                    if(rS45.equals(nosi[i])){
                        sPPAS.setSelection(i);
                    }
                }
                sPPAS.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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
                sPMET.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS49;
                rS49 = consumo.get(pos).getAconsume_metanfetaminas();
                for (int i=0; i<nosi.length; i++){
                    if(rS49.equals(nosi[i])){
                        sPMET.setSelection(i);
                    }
                }
                sPMET.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){

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

                //endregion ENTREVISTA




                //region Info caso Adolecente
                //region INFORMACION DE CASO ACTUAL
                tvTPc=(TextView) findViewById(R.id.tvTPc);
                tvFp=(TextView) findViewById(R.id.tvFp);
                tvF=(TextView) findViewById(R.id.tvF);
                txtNC1=(EditText) findViewById(R.id.txtNC1);
                txtNC2=(EditText) findViewById(R.id.txtNC2);
                txtNC3=(EditText) findViewById(R.id.txtNC3);
                txtNC4=(EditText) findViewById(R.id.txtNC4);
                txtNC5=(EditText) findViewById(R.id.txtNC5);

                txtD1=(EditText) findViewById(R.id.txtD1);
                txtD2=(EditText) findViewById(R.id.txtD2);
                txtD3=(EditText) findViewById(R.id.txtD3);
                txtD4=(EditText) findViewById(R.id.txtD4);
                txtD5=(EditText) findViewById(R.id.txtD5);

                txtTM1=(EditText) findViewById(R.id.txtTM1);
                txtTM2=(EditText) findViewById(R.id.txtTM2);
                txtTM3=(EditText) findViewById(R.id.txtTM3);
                txtTM4=(EditText) findViewById(R.id.txtTM4);
                txtTM5=(EditText) findViewById(R.id.txtTM5);


                tvEspe=(TextView) findViewById(R.id.tvEspe);
                txtEspe=(EditText) findViewById(R.id.txtEspe);
                tvNC1=(TextView) findViewById(R.id.tvNC1);
                tvNC2=(TextView) findViewById(R.id.tvNC2);
                tvNC3=(TextView) findViewById(R.id.tvNC3);
                tvNC4=(TextView) findViewById(R.id.tvNC4);
                tvNC5=(TextView) findViewById(R.id.tvNC5);
                tvD1=(TextView) findViewById(R.id.tvD1);
                tvD2=(TextView) findViewById(R.id.tvD2);
                tvD3=(TextView) findViewById(R.id.tvD3);
                tvD4=(TextView) findViewById(R.id.tvD4);
                tvD5=(TextView) findViewById(R.id.tvD5);
                tvTM1=(TextView) findViewById(R.id.tvTM1);
                tvTM2=(TextView) findViewById(R.id.tvTM2);
                tvTM3=(TextView) findViewById(R.id.tvTM3);
                tvTM4=(TextView) findViewById(R.id.tvTM4);
                tvTM5=(TextView) findViewById(R.id.tvTM5);
                tvE1=(TextView) findViewById(R.id.tvE1);
                tvE2=(TextView) findViewById(R.id.tvE2);
                tvE3=(TextView) findViewById(R.id.tvE3);
                tvE4=(TextView) findViewById(R.id.tvE4);
                tvE5=(TextView) findViewById(R.id.tvE5);
                tvPPP1=(TextView) findViewById(R.id.tvPPP1);
                tvPPP2=(TextView) findViewById(R.id.tvPPP2);
                tvPPP3=(TextView) findViewById(R.id.tvPPP3);
                tvPPP4=(TextView) findViewById(R.id.tvPPP4);
                tvPPP5=(TextView) findViewById(R.id.tvPPP5);
                tvSL=(TextView) findViewById(R.id.tvSL);
                tvEVS=(TextView) findViewById(R.id.tvEVS);
                tvVD=(TextView) findViewById(R.id.tvVD);
                tvVV=(TextView) findViewById(R.id.tvVV);
                tvCV=(TextView) findViewById(R.id.tvCV);
                tvRR=(TextView) findViewById(R.id.tvRR);
                tvRR_1=(TextView) findViewById(R.id.tvRR_1);
                txtEx1=(EditText) findViewById(R.id.txtEx1);
                txtEx2=(EditText) findViewById(R.id.txtEx2);
                tvEx1=(TextView) findViewById(R.id.tvEx1);
                tvEx2=(TextView) findViewById(R.id.tvEx2);
                //endregion

                sPE1 =(Spinner) findViewById(R.id.sPE1);
                sPE2 = (Spinner) findViewById(R.id.sPE2);
                sPE3= (Spinner) findViewById(R.id.sPE3);
                sPE4 = (Spinner) findViewById(R.id.sPE4);
                sPE5 = (Spinner) findViewById(R.id.sPE5);

                sPE1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, estatus));
                String rS62;
                rS62 = prosecoA.get(pos).getAestatus1();
                for (int i=0; i<estatus.length; i++){
                    if(rS62.equals(estatus[i])){
                        sPE1.setSelection(i);
                    }
                }
                sPE2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, estatus));
                String rS63;
                rS63 = prosecoA.get(pos).getAestatus2();
                for (int i=0; i<estatus.length; i++){
                    if(rS63.equals(estatus[i])){
                        sPE2.setSelection(i);
                    }
                }
                sPE3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, estatus));
                String rS64;
                rS64 = prosecoA.get(pos).getAestatus3();
                for (int i=0; i<estatus.length; i++){
                    if(rS64.equals(estatus[i])){
                        sPE3.setSelection(i);
                    }
                }
                sPE4.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, estatus));
                String rS65;
                rS65 = prosecoA.get(pos).getAestatus4();
                for (int i=0; i<estatus.length; i++){
                    if(rS65.equals(estatus[i])){
                        sPE4.setSelection(i);
                    }
                }
                sPE5.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, estatus));
                String rS66;
                rS66 = prosecoA.get(pos).getAestatus5();
                for (int i=0; i<estatus.length; i++){
                    if(rS66.equals(estatus[i])){
                        sPE5.setSelection(i);
                    }
                }

                // region sPUA1  UNO DE LO DELITOS
                sPUA1 = (Spinner) findViewById(R.id.sPUA1);
                sPUA1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS55;
                rS55 = casoA.get(pos).getAdelitomencionado_145();
                for (int i=0; i<nosi.length; i++){
                    if(rS55.equals(nosi[i])){
                        sPUA1.setSelection(i);
                    }
                }
                //endregion
                // region sPUD UNO DE LOS DELITOS 2
                sPUD = (Spinner) findViewById(R.id.sPUD);
                sPUD.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS56;
                rS56 = casoA.get(pos).getAdelitomencionado_164();
                for (int i=0; i<nosi.length; i++){
                    if(rS56.equals(nosi[i])){
                        sPUD.setSelection(i);
                    }
                }
                //endregion
                // region sPMC1  MEDIDAS DE INTERNAMIENTO
                sPMC1 = (Spinner) findViewById(R.id.sPMC1);
                sPMC1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS57;
                rS57 = casoA.get(pos).getAinternamieto();
                for (int i=0; i<nosi.length; i++){
                    if(rS57.equals(nosi[i])){
                        sPMC1.setSelection(i);
                    }
                }
                //endregion
                // region sPHO1  LOS ECHOS ALEGADOS
                sPHO1 = (Spinner) findViewById(R.id.sPHO1);
                sPHO1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS58;
                rS58 = casoA.get(pos).getAhechosalegados();
                for (int i=0; i<nosi.length; i++){
                    if(rS58.equals(nosi[i])){
                        sPHO1.setSelection(i);
                    }
                }

                //endregion
                // region sPSL SE IMPONIA A MEDIDA CAUTELAR sPEVO
                sPSL = (Spinner) findViewById(R.id.sPSL);
                sPSL.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                //endregion
                String rS59;
                rS59 = prosecoA.get(pos).getAproceso();
                for (int i=0; i<nosi.length; i++){
                    if(rS59.equals(nosi[i])){
                        sPSL.setSelection(i);
                    }
                }
                // region sPVV VIVE CON LA VICTIMA
                sPVV = (Spinner) findViewById(R.id.sPVV);
                sPVV.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS69;
                rS69 = victimaA.get(pos).getAnovivevictima();
                for (int i=0; i<nosia.length; i++){
                    if(rS69.equals(nosia[i])){
                        sPVV.setSelection(i);
                    }
                }
                sPVV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            tvCV.setVisibility(View.VISIBLE);
                            tvRR.setVisibility(View.VISIBLE);
                            tvRR_1.setVisibility(View.VISIBLE);
                            sPRR.setVisibility(View.VISIBLE);
                            tvEVS.setVisibility(View.VISIBLE);

                        }
                        else{
                            tvCV.setVisibility(View.GONE);
                            tvRR.setVisibility(View.GONE);
                            tvRR_1.setVisibility(View.GONE);
                            sPRR.setVisibility(View.GONE);
                            tvEVS.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });

                //endregion
                // region sPDV DELITO VIOLENTO
                sPDV = (Spinner) findViewById(R.id.sPDV);
                sPDV.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS71;
                rS71 = victimaA.get(pos).getAintegridad();
                for (int i=0; i<nosia.length; i++){
                    if(rS71.equals(nosia[i])){
                        sPDV.setSelection(i);
                    }
                }
                //endregion
                // region sPEVF EL ADOLECENTE HA EXPRESADO
                sPEVF = (Spinner) findViewById(R.id.sPEVF);
                sPEVF.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS72;
                rS72 = victimaA.get(pos).getAintenciones();
                for (int i=0; i<nosia.length; i++){
                    if(rS72.equals(nosia[i])){
                        sPEVF.setSelection(i);
                    }
                }
                //endregion


                // region sPDI  UNO DE LO DELITOS
                sPDI = (Spinner) findViewById(R.id.sPDI);
                sPDI.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, delito));
               String rS54;
                rS54 = casoA.get(pos).getAdelito();
                for (int i=0; i<delito.length; i++){
                    if(rS54.equals(delito[i])){
                        sPDI.setSelection(i);
                    }
                }
                sPDI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="OTRO"){
                            tvEspe.setVisibility(View.VISIBLE);
                            txtEspe.setVisibility(View.VISIBLE);
                        }
                        else{
                            tvEspe.setVisibility(View.GONE);
                            txtEspe.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion

                // region Cuantos procesos
                sPTP = (Spinner) findViewById(R.id.sPTP);
                sPTP.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS60;
                rS60 = prosecoA.get(pos).getAproceso();
                for (int i=0; i<nosi.length; i++){
                    if(rS60.equals(nosi[i])){
                        sPTP.setSelection(i);
                    }
                }
                sPTP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            sPTPc.setVisibility(View.VISIBLE);
                            tvTPc.setVisibility(View.VISIBLE);
                        }
                        else{
                            sPTPc.setVisibility(View.GONE);
                            tvTPc.setVisibility(View.GONE);
                            txtNC1.setVisibility(View.GONE);
                            txtNC2.setVisibility(View.GONE);
                            txtNC3.setVisibility(View.GONE);
                            txtNC4.setVisibility(View.GONE);
                            txtNC5.setVisibility(View.GONE);
                            txtD1.setVisibility(View.GONE);
                            txtD2.setVisibility(View.GONE);
                            txtD3.setVisibility(View.GONE);
                            txtD4.setVisibility(View.GONE);
                            txtD5.setVisibility(View.GONE);
                            txtTM1.setVisibility(View.GONE);
                            txtTM2.setVisibility(View.GONE);
                            txtTM3.setVisibility(View.GONE);
                            txtTM4.setVisibility(View.GONE);
                            txtTM5.setVisibility(View.GONE);
                            sPE1.setVisibility(View.GONE);
                            sPE2.setVisibility(View.GONE);
                            sPE3.setVisibility(View.GONE);
                            sPE4.setVisibility(View.GONE);
                            sPE5.setVisibility(View.GONE);
                            tvNC1.setVisibility(View.GONE);
                            tvNC2.setVisibility(View.GONE);
                            tvNC3.setVisibility(View.GONE);
                            tvNC4.setVisibility(View.GONE);
                            tvNC5.setVisibility(View.GONE);
                            tvD1.setVisibility(View.GONE);
                            tvD2.setVisibility(View.GONE);
                            tvD3.setVisibility(View.GONE);
                            tvD4.setVisibility(View.GONE);
                            tvD5.setVisibility(View.GONE);
                            tvTM1.setVisibility(View.GONE);
                            tvTM2.setVisibility(View.GONE);
                            tvTM3.setVisibility(View.GONE);
                            tvTM4.setVisibility(View.GONE);
                            tvTM5.setVisibility(View.GONE);
                            tvE1.setVisibility(View.GONE);
                            tvE2.setVisibility(View.GONE);
                            tvE3.setVisibility(View.GONE);
                            tvE4.setVisibility(View.GONE);
                            tvE5.setVisibility(View.GONE);
                            tvPPP1.setVisibility(View.GONE);
                            tvPPP2.setVisibility(View.GONE);
                            tvPPP3.setVisibility(View.GONE);
                            tvPPP4.setVisibility(View.GONE);
                            tvPPP5.setVisibility(View.GONE);
                            tvSL.setVisibility(View.GONE);
                            sPSL.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion
                // region sPTPc TIENE OTRO PROCESO
                sPTPc = (Spinner) findViewById(R.id.sPTPc);
                sPTPc.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, otroProceso));
                String rS61;
                rS61 = prosecoA.get(pos).getAnprocesos();
                for (int i=0; i<otroProceso.length; i++){
                    if(rS61.equals(otroProceso[i])){
                        sPTPc.setSelection(i);
                    }
                }
                sPTPc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        switch (selectedItem) {
                            case "NA":
                                txtNC1.setVisibility(View.GONE);
                                txtNC2.setVisibility(View.GONE);
                                txtNC3.setVisibility(View.GONE);
                                txtNC4.setVisibility(View.GONE);
                                txtNC5.setVisibility(View.GONE);
                                txtD1.setVisibility(View.GONE);
                                txtD2.setVisibility(View.GONE);
                                txtD3.setVisibility(View.GONE);
                                txtD4.setVisibility(View.GONE);
                                txtD5.setVisibility(View.GONE);
                                txtTM1.setVisibility(View.GONE);
                                txtTM2.setVisibility(View.GONE);
                                txtTM3.setVisibility(View.GONE);
                                txtTM4.setVisibility(View.GONE);
                                txtTM5.setVisibility(View.GONE);
                                sPE1.setVisibility(View.GONE);
                                sPE2.setVisibility(View.GONE);
                                sPE3.setVisibility(View.GONE);
                                sPE4.setVisibility(View.GONE);
                                sPE5.setVisibility(View.GONE);
                                tvNC1.setVisibility(View.GONE);
                                tvNC2.setVisibility(View.GONE);
                                tvNC3.setVisibility(View.GONE);
                                tvNC4.setVisibility(View.GONE);
                                tvNC5.setVisibility(View.GONE);
                                tvD1.setVisibility(View.GONE);
                                tvD2.setVisibility(View.GONE);
                                tvD3.setVisibility(View.GONE);
                                tvD4.setVisibility(View.GONE);
                                tvD5.setVisibility(View.GONE);
                                tvTM1.setVisibility(View.GONE);
                                tvTM2.setVisibility(View.GONE);
                                tvTM3.setVisibility(View.GONE);
                                tvTM4.setVisibility(View.GONE);
                                tvTM5.setVisibility(View.GONE);
                                tvE1.setVisibility(View.GONE);
                                tvE2.setVisibility(View.GONE);
                                tvE3.setVisibility(View.GONE);
                                tvE4.setVisibility(View.GONE);
                                tvE5.setVisibility(View.GONE);
                                tvPPP1.setVisibility(View.GONE);
                                tvPPP2.setVisibility(View.GONE);
                                tvPPP3.setVisibility(View.GONE);
                                tvPPP4.setVisibility(View.GONE);
                                tvPPP5.setVisibility(View.GONE);
                                tvSL.setVisibility(View.GONE);
                                sPSL.setVisibility(View.GONE);
                                break;
                            case "1":
                                txtNC1.setVisibility(View.VISIBLE);
                                txtNC2.setVisibility(View.GONE);
                                txtNC3.setVisibility(View.GONE);
                                txtNC4.setVisibility(View.GONE);
                                txtNC5.setVisibility(View.GONE);
                                txtD1.setVisibility(View.VISIBLE);
                                txtD2.setVisibility(View.GONE);
                                txtD3.setVisibility(View.GONE);
                                txtD4.setVisibility(View.GONE);
                                txtD5.setVisibility(View.GONE);
                                txtTM1.setVisibility(View.VISIBLE);
                                txtTM2.setVisibility(View.GONE);
                                txtTM3.setVisibility(View.GONE);
                                txtTM4.setVisibility(View.GONE);
                                txtTM5.setVisibility(View.GONE);
                                sPE1.setVisibility(View.VISIBLE);
                                sPE2.setVisibility(View.GONE);
                                sPE3.setVisibility(View.GONE);
                                sPE4.setVisibility(View.GONE);
                                sPE5.setVisibility(View.GONE);
                                tvNC1.setVisibility(View.VISIBLE);
                                tvNC2.setVisibility(View.GONE);
                                tvNC3.setVisibility(View.GONE);
                                tvNC4.setVisibility(View.GONE);
                                tvNC5.setVisibility(View.GONE);
                                tvD1.setVisibility(View.VISIBLE);
                                tvD2.setVisibility(View.GONE);
                                tvD3.setVisibility(View.GONE);
                                tvD4.setVisibility(View.GONE);
                                tvD5.setVisibility(View.GONE);
                                tvTM1.setVisibility(View.VISIBLE);
                                tvTM2.setVisibility(View.GONE);
                                tvTM3.setVisibility(View.GONE);
                                tvTM4.setVisibility(View.GONE);
                                tvTM5.setVisibility(View.GONE);
                                tvE1.setVisibility(View.VISIBLE);
                                tvE2.setVisibility(View.GONE);
                                tvE3.setVisibility(View.GONE);
                                tvE4.setVisibility(View.GONE);
                                tvE5.setVisibility(View.GONE);
                                tvPPP1.setVisibility(View.VISIBLE);
                                tvPPP2.setVisibility(View.GONE);
                                tvPPP3.setVisibility(View.GONE);
                                tvPPP4.setVisibility(View.GONE);
                                tvPPP5.setVisibility(View.GONE);
                                tvSL.setVisibility(View.VISIBLE);
                                sPSL.setVisibility(View.VISIBLE);
                                break;
                            case "2":
                                txtNC1.setVisibility(View.VISIBLE);
                                txtNC2.setVisibility(View.VISIBLE);
                                txtNC3.setVisibility(View.GONE);
                                txtNC4.setVisibility(View.GONE);
                                txtNC5.setVisibility(View.GONE);
                                txtD1.setVisibility(View.VISIBLE);
                                txtD2.setVisibility(View.VISIBLE);
                                txtD3.setVisibility(View.GONE);
                                txtD4.setVisibility(View.GONE);
                                txtD5.setVisibility(View.GONE);
                                txtTM1.setVisibility(View.VISIBLE);
                                txtTM2.setVisibility(View.VISIBLE);
                                txtTM3.setVisibility(View.GONE);
                                txtTM4.setVisibility(View.GONE);
                                txtTM5.setVisibility(View.GONE);
                                sPE1.setVisibility(View.VISIBLE);
                                sPE2.setVisibility(View.VISIBLE);
                                sPE3.setVisibility(View.GONE);
                                sPE4.setVisibility(View.GONE);
                                sPE5.setVisibility(View.GONE);
                                tvNC1.setVisibility(View.VISIBLE);
                                tvNC2.setVisibility(View.VISIBLE);
                                tvNC3.setVisibility(View.GONE);
                                tvNC4.setVisibility(View.GONE);
                                tvNC5.setVisibility(View.GONE);
                                tvD1.setVisibility(View.VISIBLE);
                                tvD2.setVisibility(View.VISIBLE);
                                tvD3.setVisibility(View.GONE);
                                tvD4.setVisibility(View.GONE);
                                tvD5.setVisibility(View.GONE);
                                tvTM1.setVisibility(View.VISIBLE);
                                tvTM2.setVisibility(View.VISIBLE);
                                tvTM3.setVisibility(View.GONE);
                                tvTM4.setVisibility(View.GONE);
                                tvTM5.setVisibility(View.GONE);
                                tvE1.setVisibility(View.VISIBLE);
                                tvE2.setVisibility(View.VISIBLE);
                                tvE3.setVisibility(View.GONE);
                                tvE4.setVisibility(View.GONE);
                                tvE5.setVisibility(View.GONE);
                                tvPPP1.setVisibility(View.VISIBLE);
                                tvPPP2.setVisibility(View.VISIBLE);
                                tvPPP3.setVisibility(View.GONE);
                                tvPPP4.setVisibility(View.GONE);
                                tvPPP5.setVisibility(View.GONE);
                                tvSL.setVisibility(View.VISIBLE);
                                sPSL.setVisibility(View.VISIBLE);
                                break;
                            case "3":
                                txtNC1.setVisibility(View.VISIBLE);
                                txtNC2.setVisibility(View.VISIBLE);
                                txtNC3.setVisibility(View.VISIBLE);
                                txtNC4.setVisibility(View.GONE);
                                txtNC5.setVisibility(View.GONE);
                                txtD1.setVisibility(View.VISIBLE);
                                txtD2.setVisibility(View.VISIBLE);
                                txtD3.setVisibility(View.VISIBLE);
                                txtD4.setVisibility(View.GONE);
                                txtD5.setVisibility(View.GONE);
                                txtTM1.setVisibility(View.VISIBLE);
                                txtTM2.setVisibility(View.VISIBLE);
                                txtTM3.setVisibility(View.VISIBLE);
                                txtTM4.setVisibility(View.GONE);
                                txtTM5.setVisibility(View.GONE);
                                sPE1.setVisibility(View.VISIBLE);
                                sPE2.setVisibility(View.VISIBLE);
                                sPE3.setVisibility(View.VISIBLE);
                                sPE4.setVisibility(View.GONE);
                                sPE5.setVisibility(View.GONE);
                                tvNC1.setVisibility(View.VISIBLE);
                                tvNC2.setVisibility(View.VISIBLE);
                                tvNC3.setVisibility(View.VISIBLE);
                                tvNC4.setVisibility(View.GONE);
                                tvNC5.setVisibility(View.GONE);
                                tvD1.setVisibility(View.VISIBLE);
                                tvD2.setVisibility(View.VISIBLE);
                                tvD3.setVisibility(View.VISIBLE);
                                tvD4.setVisibility(View.GONE);
                                tvD5.setVisibility(View.GONE);
                                tvTM1.setVisibility(View.VISIBLE);
                                tvTM2.setVisibility(View.VISIBLE);
                                tvTM3.setVisibility(View.VISIBLE);
                                tvTM4.setVisibility(View.GONE);
                                tvTM5.setVisibility(View.GONE);
                                tvE1.setVisibility(View.VISIBLE);
                                tvE2.setVisibility(View.VISIBLE);
                                tvE3.setVisibility(View.VISIBLE);
                                tvE4.setVisibility(View.GONE);
                                tvE5.setVisibility(View.GONE);
                                tvPPP1.setVisibility(View.VISIBLE);
                                tvPPP2.setVisibility(View.VISIBLE);
                                tvPPP3.setVisibility(View.VISIBLE);
                                tvPPP4.setVisibility(View.GONE);
                                tvPPP5.setVisibility(View.GONE);
                                tvSL.setVisibility(View.VISIBLE);
                                sPSL.setVisibility(View.VISIBLE);
                                break;
                            case "4":
                                txtNC1.setVisibility(View.VISIBLE);
                                txtNC2.setVisibility(View.VISIBLE);
                                txtNC3.setVisibility(View.VISIBLE);
                                txtNC4.setVisibility(View.VISIBLE);
                                txtNC5.setVisibility(View.GONE);
                                txtD1.setVisibility(View.VISIBLE);
                                txtD2.setVisibility(View.VISIBLE);
                                txtD3.setVisibility(View.VISIBLE);
                                txtD4.setVisibility(View.VISIBLE);
                                txtD5.setVisibility(View.GONE);
                                txtTM1.setVisibility(View.VISIBLE);
                                txtTM2.setVisibility(View.VISIBLE);
                                txtTM3.setVisibility(View.VISIBLE);
                                txtTM4.setVisibility(View.VISIBLE);
                                txtTM5.setVisibility(View.GONE);
                                sPE1.setVisibility(View.VISIBLE);
                                sPE2.setVisibility(View.VISIBLE);
                                sPE3.setVisibility(View.VISIBLE);
                                sPE4.setVisibility(View.VISIBLE);
                                sPE5.setVisibility(View.GONE);
                                tvNC1.setVisibility(View.VISIBLE);
                                tvNC2.setVisibility(View.VISIBLE);
                                tvNC3.setVisibility(View.VISIBLE);
                                tvNC4.setVisibility(View.VISIBLE);
                                tvNC5.setVisibility(View.GONE);
                                tvD1.setVisibility(View.VISIBLE);
                                tvD2.setVisibility(View.VISIBLE);
                                tvD3.setVisibility(View.VISIBLE);
                                tvD4.setVisibility(View.VISIBLE);
                                tvD5.setVisibility(View.GONE);
                                tvTM1.setVisibility(View.VISIBLE);
                                tvTM2.setVisibility(View.VISIBLE);
                                tvTM3.setVisibility(View.VISIBLE);
                                tvTM4.setVisibility(View.VISIBLE);
                                tvTM5.setVisibility(View.GONE);
                                tvE1.setVisibility(View.VISIBLE);
                                tvE2.setVisibility(View.VISIBLE);
                                tvE3.setVisibility(View.VISIBLE);
                                tvE4.setVisibility(View.VISIBLE);
                                tvE5.setVisibility(View.GONE);
                                tvPPP1.setVisibility(View.VISIBLE);
                                tvPPP2.setVisibility(View.VISIBLE);
                                tvPPP3.setVisibility(View.VISIBLE);
                                tvPPP4.setVisibility(View.VISIBLE);
                                tvPPP5.setVisibility(View.GONE);
                                tvSL.setVisibility(View.VISIBLE);
                                sPSL.setVisibility(View.VISIBLE);
                                break;
                            case "5":
                                txtNC1.setVisibility(View.VISIBLE);
                                txtNC2.setVisibility(View.VISIBLE);
                                txtNC3.setVisibility(View.VISIBLE);
                                txtNC4.setVisibility(View.VISIBLE);
                                txtNC5.setVisibility(View.VISIBLE);
                                txtD1.setVisibility(View.VISIBLE);
                                txtD2.setVisibility(View.VISIBLE);
                                txtD3.setVisibility(View.VISIBLE);
                                txtD4.setVisibility(View.VISIBLE);
                                txtD5.setVisibility(View.VISIBLE);
                                txtTM1.setVisibility(View.VISIBLE);
                                txtTM2.setVisibility(View.VISIBLE);
                                txtTM3.setVisibility(View.VISIBLE);
                                txtTM4.setVisibility(View.VISIBLE);
                                txtTM5.setVisibility(View.VISIBLE);
                                sPE1.setVisibility(View.VISIBLE);
                                sPE2.setVisibility(View.VISIBLE);
                                sPE3.setVisibility(View.VISIBLE);
                                sPE4.setVisibility(View.VISIBLE);
                                sPE5.setVisibility(View.VISIBLE);
                                tvNC1.setVisibility(View.VISIBLE);
                                tvNC2.setVisibility(View.VISIBLE);
                                tvNC3.setVisibility(View.VISIBLE);
                                tvNC4.setVisibility(View.VISIBLE);
                                tvNC5.setVisibility(View.VISIBLE);
                                tvD1.setVisibility(View.VISIBLE);
                                tvD2.setVisibility(View.VISIBLE);
                                tvD3.setVisibility(View.VISIBLE);
                                tvD4.setVisibility(View.VISIBLE);
                                tvD5.setVisibility(View.VISIBLE);
                                tvTM1.setVisibility(View.VISIBLE);
                                tvTM2.setVisibility(View.VISIBLE);
                                tvTM3.setVisibility(View.VISIBLE);
                                tvTM4.setVisibility(View.VISIBLE);
                                tvTM5.setVisibility(View.VISIBLE);
                                tvE1.setVisibility(View.VISIBLE);
                                tvE2.setVisibility(View.VISIBLE);
                                tvE3.setVisibility(View.VISIBLE);
                                tvE4.setVisibility(View.VISIBLE);
                                tvE5.setVisibility(View.VISIBLE);
                                tvPPP1.setVisibility(View.VISIBLE);
                                tvPPP2.setVisibility(View.VISIBLE);
                                tvPPP3.setVisibility(View.VISIBLE);
                                tvPPP4.setVisibility(View.VISIBLE);
                                tvPPP5.setVisibility(View.VISIBLE);
                                tvSL.setVisibility(View.VISIBLE);
                                sPSL.setVisibility(View.VISIBLE);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion

                // region sPEVO EXIXTE VICTIMA
                sPVO = (Spinner) findViewById(R.id.sPVO);
                sPVO.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS67;
                rS67 = victimaA.get(pos).getAexistevictima();
                for (int i=0; i<nosi.length; i++){
                    if(rS67.equals(nosi[i])){
                        sPVO.setSelection(i);
                    }
                }
                sPVO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            tvVD.setVisibility(View.VISIBLE);
                            sPVD.setVisibility(View.VISIBLE);
                            tvVV.setVisibility(View.VISIBLE);
                            sPVV.setVisibility(View.VISIBLE);
                            tvCV.setVisibility(View.VISIBLE);
                            tvRR.setVisibility(View.VISIBLE);
                            tvRR_1.setVisibility(View.VISIBLE);
                            sPRR.setVisibility(View.VISIBLE);
                            tvEVS.setVisibility(View.VISIBLE);

                        }
                        else{
                            tvVD.setVisibility(View.GONE);
                            sPVD.setVisibility(View.GONE);
                            tvVV.setVisibility(View.GONE);
                            sPVV.setVisibility(View.GONE);
                            tvCV.setVisibility(View.GONE);
                            tvRR.setVisibility(View.GONE);
                            tvRR_1.setVisibility(View.GONE);
                            sPRR.setVisibility(View.GONE);
                            tvEVS.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion

                // region sPVD VIVE EN EL MISMO DOMICILIO
                sPVD = (Spinner) findViewById(R.id.sPVD);
                sPVD.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS68;
                rS68 = victimaA.get(pos).getAvivedomicilio();
                for (int i=0; i<nosia.length; i++){
                    if(rS68.equals(nosia[i])){
                        sPVD.setSelection(i);
                    }
                }
                sPVD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            tvCV.setVisibility(View.VISIBLE);
                            tvRR.setVisibility(View.VISIBLE);
                            tvRR_1.setVisibility(View.VISIBLE);
                            sPRR.setVisibility(View.VISIBLE);
                            tvEVS.setVisibility(View.VISIBLE);
                            tvVV.setVisibility(View.GONE);
                            sPVV.setVisibility(View.GONE);

                        }
                        else{
                            tvVV.setVisibility(View.VISIBLE);
                            sPVV.setVisibility(View.VISIBLE);
                            tvCV.setVisibility(View.GONE);
                            tvRR.setVisibility(View.GONE);
                            tvRR_1.setVisibility(View.GONE);
                            sPRR.setVisibility(View.GONE);
                            tvEVS.setVisibility(View.GONE);

                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion


                // region sCV REUBICA DOMICILIO
                sPRR = (Spinner) findViewById(R.id.sPRR);
                sPRR.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosia));
                String rS70;
                rS70 = victimaA.get(pos).getAcasomismodomicilio();
                for (int i=0; i<nosia.length; i++){
                    if(rS70.equals(nosia[i])){
                        sPRR.setSelection(i);
                    }
                }
                //endregion

                // region PRESENTA UN POSIBLE RIESGO
                sPSE = (Spinner) findViewById(R.id.sPSE);
                sPSE.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS73;
                rS73 = legalA.get(pos).getAriesgocontinuo();
                for (int i=0; i<nosi.length; i++){
                    if(rS73.equals(nosi[i])){
                        sPSE.setSelection(i);
                    }
                }
                sPSE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtEx1.setVisibility(View.VISIBLE);
                            tvEx1.setVisibility(view.VISIBLE);

                        }
                        else{
                            txtEx1.setVisibility(View.GONE);
                            tvEx1.setVisibility(view.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion


                // region SA
                sPSA = (Spinner) findViewById(R.id.sPSA);
                sPSA.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_item, nosi));
                String rS74;
                rS74 = legalA.get(pos).getAamanazatestigo();
                for (int i=0; i<nosi.length; i++){
                    if(rS74.equals(nosi[i])){
                        sPSA.setSelection(i);
                    }
                }
                sPSA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem=parent.getSelectedItem().toString();
                        if (selectedItem=="SI"){
                            txtEx2.setVisibility(View.VISIBLE);
                            tvEx2.setVisibility(view.VISIBLE);

                        }
                        else{
                            txtEx2.setVisibility(View.GONE);
                            tvEx2.setVisibility(view.GONE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        return;
                    }
                });
                //endregion


                //endregion Info caso Adolecente
            btnGuardarA=(Button) findViewById(R.id.btnGuardarA);
            btnGuardarA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    btnGuardarA.setEnabled(false);

                    ArrayList<datosGeneralesA> lista1;
                    lista1 = db.getdatosGeneralesA();
                    int pos = sPNombres.getSelectedItemPosition();
                    String afolio = lista1.get(pos).getAfolio();

                    //region datos Entrevistador
                    txtFolioA.setText(afolio);
                    //endregion

                    //region datos Responsables
                    r5A=txtNpa1.getText().toString().toUpperCase();
                    r6A=txtNpa2.getText().toString().toUpperCase();
                    //r7A--
                    //r8A--
                    r9A=sPRa1.getSelectedItem().toString().toUpperCase();
                    r10A=sPRa2.getSelectedItem().toString().toUpperCase();
                    //r11A--
                    //r12A
                    //////////////////////////Participantes y oyentes
                    r13A=sPPar1.getSelectedItem().toString().toUpperCase();
                    r14A=sPPar2.getSelectedItem().toString().toUpperCase();
                    //r15A
                    //r16A
                    //endregion

                    //region Datos Generales
                    r17A_1=txtApeP.getText().toString().toUpperCase();
                    r17A_2=txtApeM.getText().toString().toUpperCase();
                    r17A=txtNa.getText().toString().toUpperCase();
                    r18A=txtEa.getText().toString().toUpperCase();
                    r19A=txtFNa.getText().toString().toUpperCase();
                    r20A=txtCURPa.getText().toString().toUpperCase();

                    r22A=txtEDOa.getText().toString().toUpperCase();
                    r23A=txtMa.getText().toString().toUpperCase();
                    r24A=txtLa.getText().toString().toUpperCase();
                    r25A=txtNAa.getText().toString().toUpperCase();
                    //endregion DATOS GENERALES

                    //region FICHA FAMILIAR
                    r26A=txtCa.getText().toString().toUpperCase();
                    r27A=txtNOa.getText().toString().toUpperCase();
                    r28A=sPCOLa.getSelectedItem().toString().toUpperCase();
                    r28_1A=txtCOLa.getText().toString().toUpperCase();
                    r29A=txtCPa.getText().toString().toUpperCase();
                    r30A=txtMUa.getText().toString().toUpperCase();
                    r31A=txtEDO2a.getText().toString().toUpperCase();
                    r32A=txtPa.getText().toString().toUpperCase();
                    r33A=sPTa.getSelectedItem().toString().toUpperCase();
                    r34A=txtDALa1.getText().toString().toUpperCase();//localidad
                    r7A=txtDATa1.getText().toString().toUpperCase(); //temporalidad
                    r35A=txtDALa2.getText().toString().toUpperCase();
                    r8A=txtDATa2.getText().toString().toUpperCase();
                    r36A=txtDALa3.getText().toString().toUpperCase();
                    r11A=txtDATa3.getText().toString().toUpperCase();
                    //r37A=txtDATa4.getText().toString().toUpperCase();

                    //endregion FICHA FAMILIAR

                    //region DATOS FAMILIARES
                    rS42f=sPRef.getSelectedItem().toString().toUpperCase();
                    rS42_1f=sPPe.getSelectedItem().toString().toUpperCase();
                    r38A=txtNDFa1.getText().toString().toUpperCase();
                    r40A=sPRDFa1.getSelectedItem().toString().toUpperCase();
                    r42A=txtEDFa1.getText().toString().toUpperCase();
                    r44A=txtTDFa1.getText().toString().toUpperCase();

                    r39A=txtNDFa2.getText().toString().toUpperCase();
                    r41A=sPRDFa2.getSelectedItem().toString().toUpperCase();
                    r43A=txtEDFa2.getText().toString().toUpperCase();
                    r45A=txtTDFa2.getText().toString().toUpperCase();

                    r46A=txtCQDFa.getText().toString().toUpperCase();
                    r47A=txtRDFa.getText().toString().toUpperCase();
                    r48A=txtLDFa.getText().toString().toUpperCase();
                    //endregion DATOS FAMILIARES

                    //region DEEPENDIENTES ECONOMICOS
                    r49A=txtNDEa1.getText().toString().toUpperCase();
                    r52A=txtRDEa1.getText().toString().toUpperCase();
                    r55A=txtEDEa1.getText().toString().toUpperCase();
                    r58A=txtTDEa1.getText().toString().toUpperCase();
                    r50A=txtNDEa2.getText().toString().toUpperCase();
                    r53A=txtRDEa2.getText().toString().toUpperCase();
                    r56A=txtEDEa2.getText().toString().toUpperCase();
                    r59A=txtTDEa2.getText().toString().toUpperCase();
                    r51A=txtNDEa3.getText().toString().toUpperCase();
                    r54A=txtRDEa3.getText().toString().toUpperCase();
                    r57A=txtEDEa3.getText().toString().toUpperCase();
                    r60A=txtTDEa3.getText().toString().toUpperCase();
                    //endregion DEPENDIENTES ECONOMICOS

                    //region VINCULOS COMINITARIOS
                    r61A=txtNEa.getText().toString().toUpperCase();
                    r62A=txtDEa.getText().toString().toUpperCase();
                    r63A=txtTea.getText().toString().toUpperCase();
                    r64A=txtNIEa.getText().toString().toUpperCase();
                    r65A=sPUGa.getSelectedItem().toString().toUpperCase();
                    r66A=txtNEa1.getText().toString().toUpperCase();
                    r68A=txtLE1.getText().toString().toUpperCase();
                    r70A=txtGC1.getText().toString().toUpperCase();
                    //endregion VINCULOS COMUNITARIOS

                    //region HISTORIAL LABORAL
                    r73A=txtNTa.getText().toString().toUpperCase();
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
                    r89A=txtFDCA.getText().toString().toUpperCase();
                    r88A=txtCaT.getText().toString().toUpperCase();
                    r90A=txtFDCT.getText().toString().toUpperCase();
                    r91A=txtFDCMAR.getText().toString().toUpperCase();
                    r92A=txtCaMAR.getText().toString().toUpperCase();
                    r93A=txtFDCPAS.getText().toString().toUpperCase();
                    r94A=txtCaPAS.getText().toString().toUpperCase();
                    r95A=txtFDCSOL.getText().toString().toUpperCase();//
                    r96A=txtCaSOL.getText().toString().toUpperCase();//
                    r97A=txtFDCMET.getText().toString().toUpperCase();
                    r98A=txtCaMET.getText().toString().toUpperCase();
                    r98_A=txtOPS.getText().toString().toUpperCase();

                    r99A=txtCaCOCA.getText().toString().toUpperCase();
                    r100A=txtFDCCOCA.getText().toString().toUpperCase();
                    //endregion CONSUMOS

                    //region SPINNERS

                    rS2f=sPSex.getSelectedItem().toString().toUpperCase();
                    rS4f=sPIdio.getSelectedItem().toString().toUpperCase();
                    rS3f=sPTra.getSelectedItem().toString().toUpperCase();
                    rS5f=sPDfa.getSelectedItem().toString().toUpperCase();
                    rS6f=sPVDF1.getSelectedItem().toString().toUpperCase();
                    rS7f=sPVDF2.getSelectedItem().toString().toUpperCase();
                    rS8f=sPDA.getSelectedItem().toString().toUpperCase();
                    rS9f=sPRD.getSelectedItem().toString().toUpperCase();
                    rS9_1f=sPDE_1.getSelectedItem().toString().toUpperCase();
                    rS9_2f=sPDE.getSelectedItem().toString().toUpperCase();
                    rS10f=sPAR1.getSelectedItem().toString().toUpperCase();
                    rS11f=sPAR2.getSelectedItem().toString().toUpperCase();
                    rS12f=sPAR3.getSelectedItem().toString().toUpperCase();
                    rS13f=sPAE.getSelectedItem().toString().toUpperCase();
                    rS14f=sPCS.getSelectedItem().toString().toUpperCase();

                    rS15f=sPTA.getSelectedItem().toString().toUpperCase();//trabajos anteriores
                    rS16f=sPTAA.getSelectedItem().toString().toUpperCase();//trabaja actualmente
                    rS17f=sPTR.getSelectedItem().toString().toUpperCase();//trabajo recurrente
                    rS18f=sPTC.getSelectedItem().toString().toUpperCase();//tiempo completo

                    rS19f=sPAEA.getSelectedItem().toString().toUpperCase();//actividades extraescolares

                    //region Revision Medica
                    rS20f=sPEE.getSelectedItem().toString().toUpperCase();
                    rS21f=sPEM.getSelectedItem().toString().toUpperCase();
                    rS22f=sPTE.getSelectedItem().toString().toUpperCase();
                    rS23f=sPC.getSelectedItem().toString().toUpperCase();
                    rS24f=sPCD.getSelectedItem().toString().toUpperCase();
                    rS25f=sPSIDA.getSelectedItem().toString().toUpperCase();
                    rS26f=sPEV.getSelectedItem().toString().toUpperCase();
                    //endregion

                    //endregion
                    rS27f=sPCALC.getSelectedItem().toString().toUpperCase(); // frecuencia
                    rS28f=sPCTBC.getSelectedItem().toString().toUpperCase();//tabaco
                    rS29f=sPCSOL.getSelectedItem().toString().toUpperCase();//
                    rS30f=sPCMAR.getSelectedItem().toString().toUpperCase();
                    rS31f=sPCCOCA.getSelectedItem().toString().toUpperCase();
                    rS32f=sPCPAS.getSelectedItem().toString().toUpperCase();//
                    rS33f=sPCMET.getSelectedItem().toString().toUpperCase();

                    rS34f=sPALC.getSelectedItem().toString().toUpperCase();//consumo
                    rS35f=sPSOL.getSelectedItem().toString().toUpperCase();//
                    rS36f=sPMAR.getSelectedItem().toString().toUpperCase();//
                    rS37f=sPCOCA.getSelectedItem().toString().toUpperCase();
                    rS38f=sPPAS.getSelectedItem().toString().toUpperCase();//
                    rS39f=sPMET.getSelectedItem().toString().toUpperCase();
                    rS40f=sPTBC.getSelectedItem().toString().toUpperCase();//tabaco
                    rS41f=sPSUSF.getSelectedItem().toString().toUpperCase();


                    //region infocasoadolecente

                    r3=sPDI.getSelectedItem().toString().toUpperCase();

                    r4=txtNC1.getText().toString().toUpperCase();
                    r5=txtNC2.getText().toString().toUpperCase();
                    r6=txtNC3.getText().toString().toUpperCase();
                    r7=txtNC4.getText().toString().toUpperCase();
                    r8=txtNC5.getText().toString().toUpperCase();

                    r9=txtD1.getText().toString().toUpperCase();
                    r10=txtD2.getText().toString().toUpperCase();
                    r11=txtD3.getText().toString().toUpperCase();
                    r12=txtD4.getText().toString().toUpperCase();
                    r13=txtD5.getText().toString().toUpperCase();

                    r14=txtTM1.getText().toString().toUpperCase();
                    r15=txtTM2.getText().toString().toUpperCase();
                    r16=txtTM3.getText().toString().toUpperCase();
                    r17=txtTM4.getText().toString().toUpperCase();
                    r18=txtTM5.getText().toString().toUpperCase();

                    r19=sPE1.getSelectedItem().toString().toUpperCase();
                    r20=sPE2.getSelectedItem().toString().toUpperCase();
                    r21=sPE3.getSelectedItem().toString().toUpperCase();
                    r22=sPE4.getSelectedItem().toString().toUpperCase();
                    r23=sPE5.getSelectedItem().toString().toUpperCase();

                    r24=txtEx1.getText().toString().toUpperCase();
                    r25=txtEx2.getText().toString().toUpperCase();
                    //////////////////SPINNER

                    rS_4=sPUA1.getSelectedItem().toString().toUpperCase();
                    rS_5=sPUD.getSelectedItem().toString().toUpperCase();
                    rS_6=sPMC1.getSelectedItem().toString().toUpperCase();
                    rS_7=sPHO1.getSelectedItem().toString().toUpperCase();

                    rS_8=sPTP.getSelectedItem().toString().toUpperCase();
                    rS_81=sPTPc.getSelectedItem().toString().toUpperCase();
                    rS_9=sPSL.getSelectedItem().toString().toUpperCase();
                    rS_10=sPVO.getSelectedItem().toString().toUpperCase();
                    rS_11=sPVD.getSelectedItem().toString().toUpperCase();
                    rS_12=sPVV.getSelectedItem().toString().toUpperCase();
                    //  rS13=sPEVS.getSelectedItem().toString().toUpperCase();
                    rS_14=sPDV.getSelectedItem().toString().toUpperCase();
                    rS_15=sPEVF.getSelectedItem().toString().toUpperCase();
                    rS_16=sPSE.getSelectedItem().toString().toUpperCase();
                    rS_17=sPSA.getSelectedItem().toString().toUpperCase();
                    rS_18=sPRR.getSelectedItem().toString().toUpperCase();
                    //endregion


                    db.updateTableA("responsables_a","Anombre1", r5A,  afolio);
                    db.updateTableA("responsables_a","Anombre2", r6A,  afolio);
                    db.updateTableA("responsables_a","Arelacion1", r9A,  afolio);
                    db.updateTableA("responsables_a","Arelacion2", r10A,  afolio);
                    db.updateTableA("responsables_a","Aoyente1", r13A,  afolio);
                    db.updateTableA("responsables_a","Aoyente2", r14A,  afolio);
                    //DATOS GNENERALES
                    db.updateTableA("datos_generales_a","Apaterno", r17A_1,  afolio);
                    db.updateTableA("datos_generales_a","Amaterno", r17A_2,  afolio);
                    db.updateTableA("datos_generales_a","Anombre", r17A,  afolio);
                    db.updateTableA("datos_generales_a","Aedad", r18A,  afolio);
                    db.updateTableA("datos_generales_a","Afechanac", r19A,  afolio);
                    db.updateTableA("datos_generales_a","Acurp", r20A,  afolio);
                    db.updateTableA("datos_generales_a","Aestado", r22A,  afolio);
                    db.updateTableA("datos_generales_a","Amunicipio", r23A,  afolio);
                    db.updateTableA("datos_generales_a","Alocalidad", r24A,  afolio);
                    db.updateTableA("datos_generales_a","Anacionalidad", r25A,  afolio);
                    //FICHA FAMILIAR
                    db.updateTableA("ficha_familiar_a","Acalle", r26A,  afolio);
                    db.updateTableA("ficha_familiar_a","Anumero", r27A,  afolio);
                    db.updateTableA("ficha_familiar_a","Acolonia", r28A,  afolio);
                    db.updateTableA("ficha_familiar_a","Anombrecol", r28_1A,  afolio);
                    db.updateTableA("ficha_familiar_a","Acp", r29A,  afolio);
                    db.updateTableA("ficha_familiar_a","Amunicipio", r30A,  afolio);
                    db.updateTableA("ficha_familiar_a","Aestado", r31A,  afolio);
                    db.updateTableA("ficha_familiar_a","Apais", r32A,  afolio);
                    db.updateTableA("ficha_familiar_a","Atemporalidad", r33A,  afolio);
                    db.updateTableA("ficha_familiar_a","Alocalidad1", r34A,  afolio);
                    db.updateTableA("ficha_familiar_a","Atemporalidadant1", r7A,  afolio);
                    db.updateTableA("ficha_familiar_a","Alocalidad2", r35A,  afolio);
                    db.updateTableA("ficha_familiar_a","Atemporalidadant1", r8A,  afolio);
                    db.updateTableA("ficha_familiar_a","Alocalidad3", r36A,  afolio);
                    db.updateTableA("ficha_familiar_a","Atemporalidadant3", r11A,  afolio);
                    //DATOS FAMILIARES
                    db.updateTableA("datos_familiares_a","Apersonasreferencias", rS42f,  afolio);
                    db.updateTableA("datos_familiares_a","Aviveconel", rS42_1f,  afolio);
                    db.updateTableA("datos_familiares_a","Anombre1", r38A,  afolio);
                    db.updateTableA("datos_familiares_a","Arelacion1", r40A,  afolio);
                    db.updateTableA("datos_familiares_a","Aedad1", r42A,  afolio);
                    db.updateTableA("datos_familiares_a","Atelefono1", r44A,  afolio);

                    db.updateTableA("datos_familiares_a","Anombre2", r39A,  afolio);
                    db.updateTableA("datos_familiares_a","Arelacion2", r41A,  afolio);
                    db.updateTableA("datos_familiares_a","Aedad2", r43A,  afolio);
                    db.updateTableA("datos_familiares_a","Atelefono2", r45A,  afolio);

                    db.updateTableA("datos_familiares_a","Anombrefam", r46A,  afolio);
                    db.updateTableA("datos_familiares_a","Arelacionfam", r47A,  afolio);
                    db.updateTableA("datos_familiares_a","Alocalidadfam", r48A,  afolio);

                    //DEEPENDIENTES ECONOMICOS
                    db.updateTableA("dependientes_economicos_a","Anombre1", r49A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Anombre2", r50A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Anombre3", r51A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Arelacion1", r52A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Arelacion2", r53A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Arelacion3", r54A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aedad1", r55A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aedad2", r56A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aedad3", r57A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Atelefono1", r58A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Atelefono2", r59A,  afolio);
                    db.updateTableA("dependientes_economicos_a","Atelefono3", r60A,  afolio);
                    // VINCULOS COMINITARIOS
                    db.updateTableA("historial_escolar_a","Anombreact", r61A,  afolio);
                    db.updateTableA("historial_escolar_a","Adireccionact", r62A,  afolio);
                    db.updateTableA("historial_escolar_a","Atelefonoact", r63A,  afolio);
                    db.updateTableA("historial_escolar_a","Anivelact", r64A,  afolio);
                    db.updateTableA("historial_escolar_a","Agrado", r65A,  afolio);
                    db.updateTableA("historial_escolar_a","Anombreant1", r66A,  afolio);
                    db.updateTableA("historial_escolar_a","Alocalidad1", r68A,  afolio);
                    db.updateTableA("historial_escolar_a","Agradoant1", r70A,  afolio);
                    //HISTORIAL LABORAL
                    db.updateTableA("historial_laboral_a","Anombre", r73A,  afolio);
                    db.updateTableA("historial_laboral_a","Adireccion", r75A,  afolio);
                    db.updateTableA("historial_laboral_a","Atelefono", r76A,  afolio);
                    db.updateTableA("historial_laboral_a","Aantiguedad", r77A,  afolio);
                    db.updateTableA("historial_laboral_a","Ajefe", r78A,  afolio);
                    db.updateTableA("historial_laboral_a","Anombreant", r79A,  afolio);
                    db.updateTableA("historial_laboral_a","Alocalidad", r80A,  afolio);
                    db.updateTableA("historial_laboral_a","Aantiguedadant", r81A,  afolio);
                    db.updateTableA("historial_laboral_a","Atelefonoant", r82A,  afolio);
                    //ACTIVIDADRES ESTRAESCOLARES
                    db.updateTableA("actividades_extraescolares_a","Aactividad", r83A,  afolio);
                    db.updateTableA("actividades_extraescolares_a","Alocalidad", r84A,  afolio);
                    db.updateTableA("actividades_extraescolares_a","Acontacto", r85A,  afolio);
                    db.updateTableA("actividades_extraescolares_a","Atelefono", r86A,  afolio);
                    //CONSUMOS
                    db.updateTableA("consumo_sustancias_a","Acantidad_alcohol", r87A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_alcohol", r89A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_tabaco", r88A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_tabaco", r90A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_marihuana", r92A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_marihuana", r91A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_pastillas", r94A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_pastillas", r93A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_solventes", r96A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_solventes", r95A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_metanfetaminas", r98A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_metanfetaminas", r97A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Acantidad_cocaina", r99A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aultimo_consumo_cocaina", r100A,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aobservacionesfinales", r98_A,  afolio);

                    //region SPINNERS
                    db.updateTableA("datos_generales_a","Asexo", rS2f,  afolio);
                    db.updateTableA("datos_generales_a","Aespanol", rS3f,  afolio);
                    db.updateTableA("datos_generales_a","Atraductor", rS4f,  afolio);
                    db.updateTableA("ficha_familiar_a","Adomiciliof", rS5f,  afolio);

                    db.updateTableA("datos_familiares_a","Avivecon1", rS6f,  afolio);
                    db.updateTableA("datos_familiares_a","Avivecon2", rS7f,  afolio);

                    db.updateTableA("ficha_familiar_a","Adomicilioant", rS8f,  afolio);
                    db.updateTableA("datos_familiares_a","Aubicarfam", rS9f,  afolio);

                    db.updateTableA("dependientes_economicos_a","Adependientes", rS9_1f,  afolio);
                    db.updateTableA("dependientes_economicos_a","Andependientes", rS9_2f,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aresponsable1", rS10f,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aresponsable2", rS11f,  afolio);
                    db.updateTableA("dependientes_economicos_a","Aresponsable3", rS12f,  afolio);

                    db.updateTableA("historial_escolar_a","Aasiste", rS13f,  afolio);
                    db.updateTableA("historial_escolar_a","Aconcluyo", rS14f,  afolio);

                    db.updateTableA("historial_laboral_a","Atrabaja", rS16f,  afolio);
                    db.updateTableA("historial_laboral_a","Arecurrente", rS17f,  afolio);
                    db.updateTableA("historial_laboral_a","Atiempo", rS18f,  afolio);
                    db.updateTableA("historial_laboral_a","Atrabajoant", rS15f,  afolio);

                    db.updateTableA("actividades_extraescolares_a","Arealiza", rS19f,  afolio);//actividades extraescolares

                    //region Revision Medica
                    db.updateTableA("revision_medica_a","Aembarazada", rS20f,  afolio);
                    db.updateTableA("revision_medica_a","Amadre", rS21f,  afolio);
                    db.updateTableA("revision_medica_a","Aenfermedad", rS22f,  afolio);
                    db.updateTableA("revision_medica_a","Acual", rS23f,  afolio);
                    db.updateTableA("revision_medica_a","Adiscapacidad", rS24f,  afolio);
                    db.updateTableA("revision_medica_a","Amedicamento", rS25f,  afolio);
                    db.updateTableA("revision_medica_a","Aentrevistador", rS26f,  afolio);

                    //endregion
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_alcohol", rS27f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_tabaco", rS28f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_solventes", rS29f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_marihuana", rS30f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_cocaina", rS31f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_pastillas", rS32f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Afrecuencia_metanfetaminas", rS33f,  afolio);

                    db.updateTableA("consumo_sustancias_a","Aconsume_alcohol", rS34f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_tabaco", rS35f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_solventes", rS36f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_marihuana", rS37f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_cocaina", rS38f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_pastillas", rS39f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsume_metanfetaminas", rS40f,  afolio);
                    db.updateTableA("consumo_sustancias_a","Aconsumemas", rS41f,  afolio);


                    db.updateTableA("informacion_caso_a","Adelito", r3,  afolio);
                    db.updateTableA("informacion_caso_a","Aotro", r3_1,  afolio);
                    db.updateTableA("informacion_caso_a","Adelitomencionado_145", rS_4,  afolio);
                    db.updateTableA("informacion_caso_a","Adelitomencionado_164", rS_5,  afolio);
                    db.updateTableA("informacion_caso_a","Ainternamiento", rS_6,  afolio);
                    db.updateTableA("informacion_caso_a","Ahechosalegados", rS_7,  afolio);

                    db.updateTableA("procesos_penales_a","Aproceso", rS_8,  afolio);
                    db.updateTableA("procesos_penales_a","Anprocesos", rS_81,  afolio);
                    db.updateTableA("procesos_penales_a","Amedidacautelar", rS_9,  afolio);
                    db.updateTableA("procesos_penales_a","Acausa1", r4,  afolio);
                    db.updateTableA("procesos_penales_a","Adelito1", r9,  afolio);
                    db.updateTableA("procesos_penales_a","Atipomedida1", r14,  afolio);
                    db.updateTableA("procesos_penales_a","Aestatus1", r19,  afolio);
                    db.updateTableA("procesos_penales_a","Acausa2", r5,  afolio);
                    db.updateTableA("procesos_penales_a","Adelito2", r10,  afolio);
                    db.updateTableA("procesos_penales_a","Atipomedida2", r15,  afolio);
                    db.updateTableA("procesos_penales_a","Aestatus2", r20,  afolio);
                    db.updateTableA("procesos_penales_a","Acausa3", r6,  afolio);
                    db.updateTableA("procesos_penales_a","Adelito3", r11,  afolio);
                    db.updateTableA("procesos_penales_a","Atipomedida3", r16,  afolio);
                    db.updateTableA("procesos_penales_a","Aestatus3", r21,  afolio);
                    db.updateTableA("procesos_penales_a","Acausa4", r7,  afolio);
                    db.updateTableA("procesos_penales_a","Adelito4", r12,  afolio);
                    db.updateTableA("procesos_penales_a","Atipomedida4", r17,  afolio);
                    db.updateTableA("procesos_penales_a","Aestatus4", r22,  afolio);
                    db.updateTableA("procesos_penales_a","Acausa5", r8,  afolio);
                    db.updateTableA("procesos_penales_a","Adelito5", r13,  afolio);
                    db.updateTableA("procesos_penales_a","Atipomedida5", r18,  afolio);
                    db.updateTableA("procesos_penales_a","Aestatus5", r23,  afolio);

                    db.updateTableA("victima_ofendido_a","Aexistevictima", rS_10,  afolio);
                    db.updateTableA("victima_ofendido_a","Avivedomicilio", rS_11,  afolio);
                    db.updateTableA("victima_ofendido_a","Anovivevictima", rS_12,  afolio);
                    db.updateTableA("victima_ofendido_a","Acasomismodomicilio", rS_18,  afolio);
                    db.updateTableA("victima_ofendido_a","Aintegridad", rS_14,  afolio);
                    db.updateTableA("victima_ofendido_a","Aintenciones", rS_15,  afolio);

                    db.updateTableA("proceso_legal_a","Ariesgocontinuo", rS_16,  afolio);
                    db.updateTableA("proceso_legal_a","Aexpliquecontinuo", r24,  afolio);
                    db.updateTableA("proceso_legal_a","Aamenazatestigo", rS_17,  afolio);
                    db.updateTableA("proceso_legal_a","Aexpliqueamenaza", r25,  afolio);








                    Toast.makeText(getApplicationContext(), "Datos Actualizados ", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(view.getContext(), MainMenu.class);
                    startActivity(intent);
                    //    }
                    //    else{
                    btnGuardarA.setEnabled(true);
                    // }


                }
            });

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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
        btnICA=(Button) findViewById(R.id.btnICA);
        llICA=(LinearLayout) findViewById(R.id.llICA);
        btnPP=(Button) findViewById(R.id.btnPP);
        llPP=(LinearLayout) findViewById(R.id.llPP);
        btnVO=(Button) findViewById(R.id.btnVO);
        llVO=(LinearLayout) findViewById(R.id.llVO);
        btnPL=(Button) findViewById(R.id.btnPL);
        llPL=(LinearLayout) findViewById(R.id.llPL);



        //region Visibles


        btnDg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Dg){
                    llDg.setVisibility(View.VISIBLE);
                    Dg=true;
                }
                else{
                    llDg.setVisibility(View.GONE);
                    Dg=false;
                }
            }
        });


        btnFfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!Ffa){
                    llFfa.setVisibility(View.VISIBLE);
                    Ffa=true;
                }
                else{
                    llFfa.setVisibility(View.GONE);
                    Ffa=false;
                }
            }
        });
        btnVH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!VH){
                    llVH.setVisibility(View.VISIBLE);
                    VH=true;
                }
                else{
                    llVH.setVisibility(View.GONE);
                    VH=false;
                }
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!CE){
                    llCE.setVisibility(View.VISIBLE);
                    CE=true;
                }
                else{
                    llCE.setVisibility(View.GONE);
                    CE=false;
                }
            }
        });
        btnIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!IC){
                    llIC.setVisibility(View.VISIBLE);
                    IC=true;
                }
                else{
                    llIC.setVisibility(View.GONE);
                    IC=false;
                }
            }
        });
        btnICA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ICA){
                    llICA.setVisibility(View.VISIBLE);
                    ICA=true;
                }
                else{
                    llICA.setVisibility(View.GONE);
                    ICA=false;
                }
            }
        });
        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!PP){
                    llPP.setVisibility(View.VISIBLE);
                    PP=true;
                }
                else{
                    llPP.setVisibility(View.GONE);
                    PP=false;
                }
            }
        });

        btnVO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!VO){
                    llVO.setVisibility(View.VISIBLE);
                    VO=true;
                }
                else{
                    llVO.setVisibility(View.GONE);
                    VO=false;
                }
            }
        });

        btnPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!PL){
                    llPL.setVisibility(View.VISIBLE);
                    PL=true;
                }
                else{
                    llPL.setVisibility(View.GONE);
                    PL=false;
                }
            }
        });
        //endregion Visibles




    }
    private void showInputDialog(final View view){
        LayoutInflater layoutInflater=LayoutInflater.from(editar_adolescente.this);
        View promtView= layoutInflater.inflate(R.layout.input_dialog,null);
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(editar_adolescente.this);
        alertDialogBuilder.setView(promtView);
        final String contraseña="scorpio2019";

        final EditText etPass=(EditText) promtView.findViewById(R.id.etPass);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pass=etPass.getText().toString();
                        if(pass.equals(contraseña)){
                            textoSincronizado="";
                            dialog.dismiss();

                        }
                        else {
                            AlertDialog.Builder alt_bld = new AlertDialog.Builder(editar_adolescente.this);
                            alt_bld.setMessage("Contraseña Incorrecta!")
                                    .setCancelable(false)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                            showInputDialog(view);

                                        }
                                    });
                            AlertDialog alert = alt_bld.create();
                            // Title for AlertDialog
                            alert.setTitle("Error");
                            // Icon for AlertDialog
                            alert.show();                            }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                Intent intent = new Intent(view.getContext(), MainMenu.class);
                                finish();
                                startActivity(intent);
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
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
    private long backPressedTime = 0;
    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 2 secs
            backPressedTime = t;
            Toast.makeText(this, "Presiona nuevamente para salir al menu principal",
                    Toast.LENGTH_SHORT).show();
            finish();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();
            // bye
        }

    }

}
