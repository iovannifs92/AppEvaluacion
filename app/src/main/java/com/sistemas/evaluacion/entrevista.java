package com.sistemas.evaluacion;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import com.sistemas.evaluacion.entidades.datosGenerales;

import static java.lang.Thread.sleep;

public class entrevista extends AppCompatActivity implements View.OnClickListener {

    public static SharedPreferences preference;
    public static SharedPreferences.Editor pEditor;


    //region Variables Globales

    private MyOpenHelper db;
    private ArrayList<datosGenerales> lista;
    private static final int PICK_ADDRESS_REQUEST = 1;

    //region Boolean
    private boolean vivePadres=false, datosGenerales=false, datosFamiliares=false, datosEscolares=false, datosLaborales=false, datosFAestado=false, datosSalud=false;
    //endregion

    //region TextView
    private TextView tvP38,persona1,persona2,persona3,persona4, personaE1, personaE2,
            personaEstado1, personaEstado2, tvP31_2, tv33, tv33_1, tv33_2, tv33_3, tv34, tv34_1,
            tv34_2, tv34_3, tv35, tv35_1, tv35_2, tv35_3, tv36, tv36_1, tv36_2, tv36_3,
            tv37, tv37_1, tv37_2, tv37_3, tvP45, tvP46, tvP47, tvP49, tvP52, tvP53, tvP54,
            tvP55, tvP56, tvP57, tvP58, tvP59, tvP61, tvP62, tvP63, tvP64, tvP65, tvP67,
            tvP68, tvP69, tvP70, tvP71, tvP72, tvP67_1, tvP68_1, tvP69_1, tvP70_1, tvP71_1,
            tvP72_1, tvP74, tvP75, tvP76, tvP77, tvP78, tvP74_1, tvP75_1, tvP76_1, tvP77_1,
            tvP78_1, tvP90_alcohol, tvP91_alcohol, tvP92_alcohol, tvP90_tabaco, tvP91_tabaco,
            tvP92_tabaco, tvP90_marihuana, tvP91_marihuana, tvP92_marihuana, tvP90_pastillas,
            tvP91_pastillas, tvP92_pastillas, tvP90_solventes, tvP91_solventes, tvP92_solventes,
            tvP90_cristal, tvP91_cristal, tvP92_cristal, tvP90_cocaina, tvP91_cocaina, tvP92_cocaina,
            tvP90_otroConsumo, tvP91_otroConsumo, tvP92_otroConsumo, tvP93_otroConsumo, tvP95;
    //endregion

    //region EditText
    private EditText etP3, et33, et33_1, et33_2, et33_3, et34, et34_1, et34_2, et34_3,
            et35, et35_1, et35_2, et35_3, et36, et36_1, et36_2, et36_3, et37, et37_1,
            et37_2, et37_3, etP38, etP45, etP47, etP49, etP52, etP53, etP55,
            etP56, etP58, etP59, etP61, etP62, etP63, etP64, etP65, etP67, etP68, etP69, etP69_1, etP70,
            etP71, etP67_1, etP68_1, etP70_1, etP71_1, etP74, etP75, etP77,
            etP74_1, etP75_1, etP76, etP76_1, etP77_1, etP91_alcohol, etP92_alcohol, etP91_tabaco,
            etP92_tabaco, etP91_marihuana, etP92_marihuana, etP91_pastillas, etP92_pastillas,
            etP91_solventes, etP92_solventes, etP91_cristal, etP92_cristal, etP91_cocaina,
            etP92_cocaina, etP91_otroConsumo, etP92_otroConsumo, etP93_otroConsumo, etP95, etP98,
            etP102, etP103, etP104, etP105;

    private EditText etP97, etP1, etP2, etP4, etP5, etP7, etP7_1, etP8, etP9, etP10, etP12, etP14, etP15,
            etP16, etP17, etP18, etP19, etP20, etP21_1, etP21, etP22, etP23, etP24, etP26, etP28, etP30,
            etP31, etP31_2, etP39, etP40, etP41, etP42, etP43, etP39_1, etP40_1, etP41_1, etP42_1, etP43_1, etP81, etP96, etP99;
    //endregion

    //region Spinner
    private Spinner sP1_1, sP1_2, sP6, sP8, sP11, sP13, sP21_1, sP22, sP25, sP27, sP29, sP31_1, sP32, sP32_1, sP44, sP46, sP48, sP50, sP51,
            sP54, sP57, sP51_1, sP60, sP66, sP72, sP72_1, sP73, sP78, sP78_1, sP79, sP80, sP82,
            sP90_alcohol, sP83, sP90_tabaco, sP84, sP90_marihuana, sP85, sP90_pastillas,
            sP86,sP90_solventes, sP87, sP90_cristal, sP88, sP90_cocaina, sP89, sP90_otroConsumo,
            sP94, sP100, sP101;
    //endregion

    //region LinearLayout
    private LinearLayout llDomicilioSec, llDatosGenerales, llDatosFamiliares, llDatosEscolares, llDatosLaborales, llFAEstado, llSalud, llDatosVictima;
    //endregion

    //region Button
    private Button btnGuardar, btnDatosGenerales, btnDatosFamiliares, btnHistorialEscolar, btnHistorialLaboral, btnFAEstado, btnSalud, btnFind;
    //endregion

    //region String
    private String r1, r1_1, r1_2, r2,r3,r4,r5,r6, r7, r7_1, r8, r9, r10, r11, r12, r13, r14, r15, r16, r32_1, r17, r18, r19, r20,
            r21_1, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r31_1, r31_2, r33, r34, r35, r36, r37, r33_1, r34_1,
            r35_1, r36_1, r37_1, r33_2, r34_2, r35_2, r36_2, r37_2, r33_3, r34_3, r35_3, r36_3, r37_3, r38,
            r39, r40, r41, r42, r43, r39_1, r40_1, r41_1, r42_1, r43_1, r44, r45, r46, r47, r48, r49, r50,
            r51, r52, r53, r54, r55, r56, r57, r58, r51_1, r59, r60, r61, r62, r63, r64, r65, r66,
            r67, r68, r69, r70, r71, r72, r67_1, r68_1, r69_1, r70_1, r71_1, r72_1, r73,
            r74, r75, r76, r77, r78, r74_1, r75_1, r76_1, r77_1, r78_1, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89,
            r90_alcohol, r91_alcohol, r92_alcohol, r90_tabaco, r91_tabaco, r92_tabaco, r90_marihuana, r91_marihuana, r92_marihuana,
            r90_pastillas, r91_pastillas, r92_pastillas, r90_solventes, r91_solventes, r92_solventes,
            r90_cristal, r91_cristal, r92_cristal, r90_cocaina, r91_cocaina, r92_cocaina, r93_otroConsumo, r90_otroConsumo, r91_otroConsumo, r92_otroConsumo, r94, r95,
            r96, r98, r99, r100, r101, r102, r103, r104, r105;
    private String FOLIO;
    private String confirmedMainLatitude, confirmedMainLongitude;

    private String [] tipoDomicilio={"NA","Rentada", "Prestada", "Propia", "Familiar", "Situación de calle", "Irregular"};
    private String [] tiempoRadicando={"NA","Menos de un mes", "Un mes", "Entre 1 y 3 meses", "Entre 3 y 6 meses", "Entre 6 meses y un año", "Entre 1 y 3 años", "Entre 3 y 6 años", "Más de 6 años"};
    private String [] nosi={"No", "Si"};
    private String [] frecuenciaConsumo={"No consume", "Diariamente", "Cada Tercer día", "Semanalmente", "Quincenalmente", "Mensualmente", "Anualmente"};
    private String [] tipoEntrevista={"Normal", "Adolescente", "PPL"};
    private String [] ocupacion={"NA","Informal", "Formal"};
    private String [] colfracc={"NA","Colonia", "Fraccionamiento","Domicilio Conocido", "Ejido"};
    private String [] diasLaboral={"NA","Lunes a Viernes","Lunes a Domingo","Lunes a Sábado","Fines de Semana","Sin días Establecidos","Otro"};
    private String [] frecuenciaContacto={"NA", "Diariamente", "Semanalmente","Quincenalmente","Mensualmente","Anualmente"};
    private String r32="0";
    private String [] antecedentes={"No", "Si", "No sabe"};
    private String [] dVictima={"NA", "Persona", "Tienda departamental", "No sabe", "Otro"};
    private String [] seguro={"No", "IMSS", "ISSSTE", "Seguro Popular", "Privado", "Otro"};
    private String [] delito={"Otro", "Robo", "Robo Simple", "Violación", "Violencia Familiar", "Daños y Lesiones",
            "Lesiones menores a 15 dias", "Contra la Salud", "Comercio o Suministro", "Portación de Armas de Fuego"};
    //endregion
    //endregion

    //region Métodos
    //region OnCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista);



        db=new MyOpenHelper(this);

        //region Programación de Formulario
        //region P3 Fecha-Nacimiento
        etP3=(EditText) findViewById(R.id.etP3);
        etP3.setOnClickListener(this);
        //endregion

        //region sP1_1 Entrevistado
        sP1_1=(Spinner) findViewById(R.id.sP1_1);
        sP1_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,antecedentes));
        //endregion

        //region sP1_2 Antecedente Penal
        sP1_2=(Spinner) findViewById(R.id.sP1_2);
        sP1_2.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,antecedentes));
        //endregion

        //region SP6 Sexo
        sP6 = (Spinner) findViewById(R.id.sP6);
        String [] sexo={"Masculino", "Femenino"};
        sP6.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sexo));
        //endregion Sexo Se

        //region sP8 Colonia o fraccionamiento
        sP8 = (Spinner) findViewById(R.id.sP8);
        sP8.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colfracc));
        //endregion

        //region SP11 Tipo Domicilio
        sP11 = (Spinner) findViewById(R.id.sP11);
        sP11.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoDomicilio));
        //endregion tip

        //region SP13 Tiempo Radicando
        sP13 = (Spinner) findViewById(R.id.sP13);
        sP13.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tiempoRadicando));
        //endregion

        //region sP21_1 Domicilio Secundario
        sP21_1 = (Spinner) findViewById(R.id.sP21_1);
        sP21_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        llDomicilioSec=(LinearLayout) findViewById(R.id.llDomicilioSec);

        sP21_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    llDomicilioSec.setVisibility(View.VISIBLE);
                }
                else {
                    llDomicilioSec.setVisibility(View.GONE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        //region sP22 Colonia o Fraccionamiento Secundario
        sP22 = (Spinner) findViewById(R.id.sP22);
        sP22.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,colfracc));
        //endregion

        //region SP25 Tipo de domicilio secundario
        sP25 = (Spinner) findViewById(R.id.sP25);
        sP25.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoDomicilio));
        //endregion

        //region sP27 tiempo radicando secundario
        sP27 = (Spinner) findViewById(R.id.sP27);
        sP27.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tiempoRadicando));
        //endregion

        //region SP29 Estado Civil
        sP29 = (Spinner) findViewById(R.id.sP29);
        String [] estadoCivil={"Soltero(a)", "Casado(a)","Unión Libre", "Divorciado (a)", "Viudo (a)"};
        sP29.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,estadoCivil));
        //endregion

        //region SP31_1 Tipo de delito
        sP31_1 = (Spinner) findViewById(R.id.sP31_1);
        //robo simple, violencia familiar, lesiones menores a 15 dias
        sP31_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,delito));

        tvP31_2=(TextView) findViewById(R.id.tvP31_2);
        etP31_2=(EditText) findViewById(R.id.etP31_2);

        sP31_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Otro"){
                    tvP31_2.setVisibility(View.VISIBLE);
                    etP31_2.setVisibility(View.VISIBLE);
                }
                else {
                    tvP31_2.setVisibility(View.GONE);
                    etP31_2.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        //region SP32 # Personas con las que vive actualmente
        sP32 = (Spinner) findViewById(R.id.sP32);
        String [] nPersonas={"0","1","2","3","4"};
        sP32.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nPersonas));

        sP32_1 = (Spinner) findViewById(R.id.sP32_1);
        sP32_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        etP7=(EditText) findViewById(R.id.etP7);
        etP7_1=(EditText) findViewById(R.id.etP7_1);
        etP8=(EditText) findViewById(R.id.etP8);
        etP9=(EditText) findViewById(R.id.etP9);
        etP10=(EditText) findViewById(R.id.etP10);

        etP18=(EditText) findViewById(R.id.etP18);
        etP20=(EditText) findViewById(R.id.etP20);
        etP17=(EditText) findViewById(R.id.etP17);
        etP19=(EditText) findViewById(R.id.etP19);


        tvP38=(TextView) findViewById(R.id.tvP38);
        etP38=(EditText) findViewById(R.id.etP38);

        //region Definicion 0
        persona1=(TextView)findViewById(R.id.persona1);
        tv33=(TextView) findViewById(R.id.tv33);
        et33=(EditText) findViewById(R.id.etP33);

        tv34=(TextView) findViewById(R.id.tv34);
        et34=(EditText) findViewById(R.id.etP34);

        tv35=(TextView) findViewById(R.id.tv35);
        et35=(EditText) findViewById(R.id.etP35);

        tv36=(TextView) findViewById(R.id.tv36);
        et36=(EditText) findViewById(R.id.etP36);

        tv37=(TextView) findViewById(R.id.tv37);
        et37=(EditText) findViewById(R.id.etP37);

        sP32_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(position!=0){
                    String dom;
                    if(sP8.getSelectedItem().toString().equals("NA")) {
                        dom = etP7.getText().toString() + etP7_1.getText().toString() + " " + etP8.getText().toString();
                    }
                    else {
                        dom = etP7.getText().toString() + etP7_1.getText().toString() + " " + sP8.getSelectedItem().toString() + " " + etP8.getText().toString();
                    }
                    etP18.setText(dom, TextView.BufferType.EDITABLE);
                    etP20.setText(dom, TextView.BufferType.EDITABLE);
                    vivePadres=true;
                }
                else{
                    etP18.setText("");
                    etP20.setText("");
                    vivePadres=false;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //endregion

        //region Definicion 1
        persona2=(TextView)findViewById(R.id.persona2);
        tv33_1=(TextView) findViewById(R.id.tv33_1);
        et33_1=(EditText) findViewById(R.id.etP33_1);

        tv34_1=(TextView) findViewById(R.id.tv34_1);
        et34_1=(EditText) findViewById(R.id.etP34_1);

        tv35_1=(TextView) findViewById(R.id.tv35_1);
        et35_1=(EditText) findViewById(R.id.etP35_1);

        tv36_1=(TextView) findViewById(R.id.tv36_1);
        et36_1=(EditText) findViewById(R.id.etP36_1);

        tv37_1=(TextView) findViewById(R.id.tv37_1);
        et37_1=(EditText) findViewById(R.id.etP37_1);
        //endregion

        //region Definicion 2
        persona3=(TextView)findViewById(R.id.persona3);
        tv33_2=(TextView) findViewById(R.id.tv33_2);
        et33_2=(EditText) findViewById(R.id.etP33_2);

        tv34_2=(TextView) findViewById(R.id.tv34_2);
        et34_2=(EditText) findViewById(R.id.etP34_2);

        tv35_2=(TextView) findViewById(R.id.tv35_2);
        et35_2=(EditText) findViewById(R.id.etP35_2);

        tv36_2=(TextView) findViewById(R.id.tv36_2);
        et36_2=(EditText) findViewById(R.id.etP36_2);

        tv37_2=(TextView) findViewById(R.id.tv37_2);
        et37_2=(EditText) findViewById(R.id.etP37_2);
        //endregion

        //region Definicion 3
        persona4=(TextView)findViewById(R.id.persona4);
        tv33_3=(TextView) findViewById(R.id.tv33_3);
        et33_3=(EditText) findViewById(R.id.etP33_3);

        tv34_3=(TextView) findViewById(R.id.tv34_3);
        et34_3=(EditText) findViewById(R.id.etP34_3);

        tv35_3=(TextView) findViewById(R.id.tv35_3);
        et35_3=(EditText) findViewById(R.id.etP35_3);

        tv36_3=(TextView) findViewById(R.id.tv36_3);
        et36_3=(EditText) findViewById(R.id.etP36_3);

        tv37_3=(TextView) findViewById(R.id.tv37_3);
        et37_3=(EditText) findViewById(R.id.etP37_3);

        //endregion


        sP32.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                switch (selectedItem){
                    case "0":
                        viveConPadres();
                        tvP38.setVisibility(View.VISIBLE);
                        etP38.setVisibility(View.VISIBLE);
                        //region _0
                        persona1.setVisibility(View.GONE);
                        tv33.setVisibility(View.GONE);
                        et33.setVisibility(View.GONE);
                        tv34.setVisibility(View.GONE);
                        et34.setVisibility(View.GONE);
                        tv35.setVisibility(View.GONE);
                        et35.setVisibility(View.GONE);
                        tv36.setVisibility(View.GONE);
                        et36.setVisibility(View.GONE);
                        tv37.setVisibility(View.GONE);
                        et37.setVisibility(View.GONE);
                        //endregion
                        //region _1
                        persona2.setVisibility(View.GONE);
                        tv33_1.setVisibility(View.GONE);
                        et33_1.setVisibility(View.GONE);
                        tv34_1.setVisibility(View.GONE);
                        et34_1.setVisibility(View.GONE);
                        tv35_1.setVisibility(View.GONE);
                        et35_1.setVisibility(View.GONE);
                        tv36_1.setVisibility(View.GONE);
                        et36_1.setVisibility(View.GONE);
                        tv37_1.setVisibility(View.GONE);
                        et37_1.setVisibility(View.GONE);
                        //endregion
                        //region _2
                        persona3.setVisibility(View.GONE);
                        tv33_2.setVisibility(View.GONE);
                        et33_2.setVisibility(View.GONE);
                        tv34_2.setVisibility(View.GONE);
                        et34_2.setVisibility(View.GONE);
                        tv35_2.setVisibility(View.GONE);
                        et35_2.setVisibility(View.GONE);
                        tv36_2.setVisibility(View.GONE);
                        et36_2.setVisibility(View.GONE);
                        tv37_2.setVisibility(View.GONE);
                        et37_2.setVisibility(View.GONE);
                        //endregion
                        //region _3
                        persona4.setVisibility(View.GONE);
                        tv33_3.setVisibility(View.GONE);
                        et33_3.setVisibility(View.GONE);
                        tv34_3.setVisibility(View.GONE);
                        et34_3.setVisibility(View.GONE);
                        tv35_3.setVisibility(View.GONE);
                        et35_3.setVisibility(View.GONE);
                        tv36_3.setVisibility(View.GONE);
                        et36_3.setVisibility(View.GONE);
                        tv37_3.setVisibility(View.GONE);
                        et37_3.setVisibility(View.GONE);
                        //endregion
                        break;
                    case "1":
                        viveConPadres();
                        tvP38.setVisibility(View.GONE);
                        etP38.setVisibility(View.GONE);
                        //region _0
                        persona1.setVisibility(View.VISIBLE);
                        tv33.setVisibility(View.VISIBLE);
                        et33.setVisibility(View.VISIBLE);
                        tv34.setVisibility(View.VISIBLE);
                        et34.setVisibility(View.VISIBLE);
                        tv35.setVisibility(View.VISIBLE);
                        et35.setVisibility(View.VISIBLE);
                        tv36.setVisibility(View.VISIBLE);
                        et36.setVisibility(View.VISIBLE);
                        tv37.setVisibility(View.VISIBLE);
                        et37.setVisibility(View.VISIBLE);
                        //endregion
                        //region _1
                        tv33_1.setVisibility(View.GONE);
                        et33_1.setVisibility(View.GONE);
                        tv34_1.setVisibility(View.GONE);
                        et34_1.setVisibility(View.GONE);
                        tv35_1.setVisibility(View.GONE);
                        et35_1.setVisibility(View.GONE);
                        tv36_1.setVisibility(View.GONE);
                        et36_1.setVisibility(View.GONE);
                        tv37_1.setVisibility(View.GONE);
                        et37_1.setVisibility(View.GONE);
                        //endregion
                        //region _2
                        persona3.setVisibility(View.GONE);
                        tv33_2.setVisibility(View.GONE);
                        et33_2.setVisibility(View.GONE);
                        tv34_2.setVisibility(View.GONE);
                        et34_2.setVisibility(View.GONE);
                        tv35_2.setVisibility(View.GONE);
                        et35_2.setVisibility(View.GONE);
                        tv36_2.setVisibility(View.GONE);
                        et36_2.setVisibility(View.GONE);
                        tv37_2.setVisibility(View.GONE);
                        et37_2.setVisibility(View.GONE);
                        //endregion
                        //region _3
                        persona4.setVisibility(View.GONE);
                        tv33_3.setVisibility(View.GONE);
                        et33_3.setVisibility(View.GONE);
                        tv34_3.setVisibility(View.GONE);
                        et34_3.setVisibility(View.GONE);
                        tv35_3.setVisibility(View.GONE);
                        et35_3.setVisibility(View.GONE);
                        tv36_3.setVisibility(View.GONE);
                        et36_3.setVisibility(View.GONE);
                        tv37_3.setVisibility(View.GONE);
                        et37_3.setVisibility(View.GONE);
                        //endregion
                        break;
                    case "2":
                        viveConPadres();
                        tvP38.setVisibility(View.GONE);
                        etP38.setVisibility(View.GONE);
                        //region _0
                        persona1.setVisibility(View.VISIBLE);
                        tv33.setVisibility(View.VISIBLE);
                        et33.setVisibility(View.VISIBLE);
                        tv34.setVisibility(View.VISIBLE);
                        et34.setVisibility(View.VISIBLE);
                        tv35.setVisibility(View.VISIBLE);
                        et35.setVisibility(View.VISIBLE);
                        tv36.setVisibility(View.VISIBLE);
                        et36.setVisibility(View.VISIBLE);
                        tv37.setVisibility(View.VISIBLE);
                        et37.setVisibility(View.VISIBLE);
                        //endregion
                        //region _1
                        persona2.setVisibility(View.VISIBLE);
                        tv33_1.setVisibility(View.VISIBLE);
                        et33_1.setVisibility(View.VISIBLE);
                        tv34_1.setVisibility(View.VISIBLE);
                        et34_1.setVisibility(View.VISIBLE);
                        tv35_1.setVisibility(View.VISIBLE);
                        et35_1.setVisibility(View.VISIBLE);
                        tv36_1.setVisibility(View.VISIBLE);
                        et36_1.setVisibility(View.VISIBLE);
                        tv37_1.setVisibility(View.VISIBLE);
                        et37_1.setVisibility(View.VISIBLE);
                        //endregion
                        //region _2
                        persona3.setVisibility(View.GONE);
                        tv33_2.setVisibility(View.GONE);
                        et33_2.setVisibility(View.GONE);
                        tv34_2.setVisibility(View.GONE);
                        et34_2.setVisibility(View.GONE);
                        tv35_2.setVisibility(View.GONE);
                        et35_2.setVisibility(View.GONE);
                        tv36_2.setVisibility(View.GONE);
                        et36_2.setVisibility(View.GONE);
                        tv37_2.setVisibility(View.GONE);
                        et37_2.setVisibility(View.GONE);
                        //endregion
                        //region _3
                        persona4.setVisibility(View.GONE);
                        tv33_3.setVisibility(View.GONE);
                        et33_3.setVisibility(View.GONE);
                        tv34_3.setVisibility(View.GONE);
                        et34_3.setVisibility(View.GONE);
                        tv35_3.setVisibility(View.GONE);
                        et35_3.setVisibility(View.GONE);
                        tv36_3.setVisibility(View.GONE);
                        et36_3.setVisibility(View.GONE);
                        tv37_3.setVisibility(View.GONE);
                        et37_3.setVisibility(View.GONE);
                        //endregion
                        break;
                    case "3":
                        viveConPadres();
                        tvP38.setVisibility(View.GONE);
                        etP38.setVisibility(View.GONE);
                        //region _0
                        persona1.setVisibility(View.VISIBLE);
                        tv33.setVisibility(View.VISIBLE);
                        et33.setVisibility(View.VISIBLE);
                        tv34.setVisibility(View.VISIBLE);
                        et34.setVisibility(View.VISIBLE);
                        tv35.setVisibility(View.VISIBLE);
                        et35.setVisibility(View.VISIBLE);
                        tv36.setVisibility(View.VISIBLE);
                        et36.setVisibility(View.VISIBLE);
                        tv37.setVisibility(View.VISIBLE);
                        et37.setVisibility(View.VISIBLE);
                        //endregion
                        //region _1
                        persona2.setVisibility(View.VISIBLE);
                        tv33_1.setVisibility(View.VISIBLE);
                        et33_1.setVisibility(View.VISIBLE);
                        tv34_1.setVisibility(View.VISIBLE);
                        et34_1.setVisibility(View.VISIBLE);
                        tv35_1.setVisibility(View.VISIBLE);
                        et35_1.setVisibility(View.VISIBLE);
                        tv36_1.setVisibility(View.VISIBLE);
                        et36_1.setVisibility(View.VISIBLE);
                        tv37_1.setVisibility(View.VISIBLE);
                        et37_1.setVisibility(View.VISIBLE);
                        //endregion
                        //region _2
                        persona3.setVisibility(View.VISIBLE);
                        tv33_2.setVisibility(View.VISIBLE);
                        et33_2.setVisibility(View.VISIBLE);
                        tv34_2.setVisibility(View.VISIBLE);
                        et34_2.setVisibility(View.VISIBLE);
                        tv35_2.setVisibility(View.VISIBLE);
                        et35_2.setVisibility(View.VISIBLE);
                        tv36_2.setVisibility(View.VISIBLE);
                        et36_2.setVisibility(View.VISIBLE);
                        tv37_2.setVisibility(View.VISIBLE);
                        et37_2.setVisibility(View.VISIBLE);
                        //endregion
                        //region _3
                        persona4.setVisibility(View.GONE);
                        tv33_3.setVisibility(View.GONE);
                        et33_3.setVisibility(View.GONE);
                        tv34_3.setVisibility(View.GONE);
                        et34_3.setVisibility(View.GONE);
                        tv35_3.setVisibility(View.GONE);
                        et35_3.setVisibility(View.GONE);
                        tv36_3.setVisibility(View.GONE);
                        et36_3.setVisibility(View.GONE);
                        tv37_3.setVisibility(View.GONE);
                        et37_3.setVisibility(View.GONE);
                        //endregion
                        break;
                    case "4":
                        viveConPadres();
                        //region _0
                        persona1.setVisibility(View.VISIBLE);
                        tv33.setVisibility(View.VISIBLE);
                        et33.setVisibility(View.VISIBLE);
                        tv34.setVisibility(View.VISIBLE);
                        et34.setVisibility(View.VISIBLE);
                        tv35.setVisibility(View.VISIBLE);
                        et35.setVisibility(View.VISIBLE);
                        tv36.setVisibility(View.VISIBLE);
                        et36.setVisibility(View.VISIBLE);
                        tv37.setVisibility(View.VISIBLE);
                        et37.setVisibility(View.VISIBLE);
                        //endregion
                        //region _1
                        persona2.setVisibility(View.VISIBLE);
                        tv33_1.setVisibility(View.VISIBLE);
                        et33_1.setVisibility(View.VISIBLE);
                        tv34_1.setVisibility(View.VISIBLE);
                        et34_1.setVisibility(View.VISIBLE);
                        tv35_1.setVisibility(View.VISIBLE);
                        et35_1.setVisibility(View.VISIBLE);
                        tv36_1.setVisibility(View.VISIBLE);
                        et36_1.setVisibility(View.VISIBLE);
                        tv37_1.setVisibility(View.VISIBLE);
                        et37_1.setVisibility(View.VISIBLE);
                        //endregion
                        //region _2
                        persona3.setVisibility(View.VISIBLE);
                        tv33_2.setVisibility(View.VISIBLE);
                        et33_2.setVisibility(View.VISIBLE);
                        tv34_2.setVisibility(View.VISIBLE);
                        et34_2.setVisibility(View.VISIBLE);
                        tv35_2.setVisibility(View.VISIBLE);
                        et35_2.setVisibility(View.VISIBLE);
                        tv36_2.setVisibility(View.VISIBLE);
                        et36_2.setVisibility(View.VISIBLE);
                        tv37_2.setVisibility(View.VISIBLE);
                        et37_2.setVisibility(View.VISIBLE);
                        //endregion
                        //region _3
                        persona4.setVisibility(View.VISIBLE);
                        tv33_3.setVisibility(View.VISIBLE);
                        et33_3.setVisibility(View.VISIBLE);
                        tv34_3.setVisibility(View.VISIBLE);
                        et34_3.setVisibility(View.VISIBLE);
                        tv35_3.setVisibility(View.VISIBLE);
                        et35_3.setVisibility(View.VISIBLE);
                        tv36_3.setVisibility(View.VISIBLE);
                        et36_3.setVisibility(View.VISIBLE);
                        tv37_3.setVisibility(View.VISIBLE);
                        et37_3.setVisibility(View.VISIBLE);
                        //endregion
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region SP44 Cambio de domicilio y SP46
        sP44 = (Spinner) findViewById(R.id.sP44);
        sP44.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        sP46 = (Spinner) findViewById(R.id.sP46);
        sP46.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoDomicilio));

        etP45=(EditText) findViewById(R.id.etP45);
        etP47=(EditText) findViewById(R.id.etP47);

        tvP45=(TextView) findViewById(R.id.tvP45);
        tvP46=(TextView) findViewById(R.id.tvP46);
        tvP47=(TextView) findViewById(R.id.tvP47);


        sP44.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP45.setVisibility(View.VISIBLE);
                    tvP46.setVisibility(View.VISIBLE);
                    tvP47.setVisibility(View.VISIBLE);
                    etP45.setVisibility(View.VISIBLE);
                    etP47.setVisibility(View.VISIBLE);
                    sP46.setVisibility(View.VISIBLE);
                }
                else{
                    tvP45.setVisibility(View.GONE);
                    tvP46.setVisibility(View.GONE);
                    tvP47.setVisibility(View.GONE);
                    etP45.setVisibility(View.GONE);
                    etP47.setVisibility(View.GONE);
                    sP46.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP48 Actualmente estudia
        sP48 = (Spinner) findViewById(R.id.sP48);
        sP48.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        tvP49=(TextView) findViewById(R.id.tvP49);
        etP49=(EditText) findViewById(R.id.etP49);


        sP48.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    tvP49.setVisibility(View.VISIBLE);
                    etP49.setVisibility(View.VISIBLE);

                }
                else{
                    tvP49.setVisibility(View.GONE);
                    etP49.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region sP50 Último grado de estudios
        sP50 = (Spinner) findViewById(R.id.sP50);
        String [] gradoEstudios={"Sin estudios", "Primaria","Secundaria", "Preparatoria", "Licenciatura", "Maestría", "Doctorado"};
        sP50.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gradoEstudios));
        //endregion

        //region sP51 Actualmente trabaja
        sP51 = (Spinner) findViewById(R.id.sP51);
        sP51.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        sP54=(Spinner) findViewById(R.id.sP54);
        sP54.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ocupacion));

        sP57=(Spinner) findViewById(R.id.sP57);
        sP57.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,diasLaboral));

        sP51_1 = (Spinner) findViewById(R.id.sP51_1);
        sP51_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,seguro));

        tvP52=(TextView) findViewById(R.id.tvP52);
        tvP53=(TextView) findViewById(R.id.tvP53);
        tvP54=(TextView) findViewById(R.id.tvP54);
        tvP55=(TextView) findViewById(R.id.tvP55);
        tvP56=(TextView) findViewById(R.id.tvP56);
        tvP57=(TextView) findViewById(R.id.tvP57);
        tvP58=(TextView) findViewById(R.id.tvP58);
        tvP59=(TextView) findViewById(R.id.tvP59);

        etP52=(EditText) findViewById(R.id.etP52);
        etP53=(EditText) findViewById(R.id.etP53);

        etP55=(EditText) findViewById(R.id.etP55);
        etP56=(EditText) findViewById(R.id.etP56);

        etP58=(EditText) findViewById(R.id.etP58);
        etP59=(EditText) findViewById(R.id.etP59);

        //region etP56 DatePicker
        etP56.setOnClickListener(this);
        //endregion

        sP51.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP52.setVisibility(View.VISIBLE);
                    tvP53.setVisibility(View.VISIBLE);
                    tvP54.setVisibility(View.VISIBLE);
                    tvP55.setVisibility(View.VISIBLE);
                    tvP56.setVisibility(View.VISIBLE);
                    tvP57.setVisibility(View.VISIBLE);
                    tvP58.setVisibility(View.VISIBLE);
                    tvP59.setVisibility(View.GONE);
                    etP52.setVisibility(View.VISIBLE);
                    etP53.setVisibility(View.VISIBLE);
                    sP54.setVisibility(View.VISIBLE);
                    etP55.setVisibility(View.VISIBLE);
                    etP56.setVisibility(View.VISIBLE);
                    sP57.setVisibility(View.VISIBLE);
                    etP58.setVisibility(View.VISIBLE);
                    etP59.setVisibility(View.GONE);
                }
                else{
                    tvP52.setVisibility(View.GONE);
                    tvP53.setVisibility(View.GONE);
                    tvP54.setVisibility(View.GONE);
                    tvP55.setVisibility(View.GONE);
                    tvP56.setVisibility(View.GONE);
                    tvP57.setVisibility(View.GONE);
                    tvP58.setVisibility(View.GONE);
                    tvP59.setVisibility(View.VISIBLE);
                    etP52.setVisibility(View.GONE);
                    etP53.setVisibility(View.GONE);
                    sP54.setVisibility(View.GONE);
                    etP55.setVisibility(View.GONE);
                    etP56.setVisibility(View.GONE);
                    sP57.setVisibility(View.GONE);
                    etP58.setVisibility(View.GONE);
                    etP59.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP60 Ha salido fuera del país
        sP60 = (Spinner) findViewById(R.id.sP60);
        sP60.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        tvP61 =(TextView) findViewById(R.id.tvP61);
        tvP62 =(TextView) findViewById(R.id.tvP62);
        tvP63 =(TextView) findViewById(R.id.tvP63);
        tvP64 =(TextView) findViewById(R.id.tvP64);
        tvP65 =(TextView) findViewById(R.id.tvP65);

        etP61 = (EditText) findViewById(R.id.etP61);

        etP62=(EditText) findViewById(R.id.etP62);
        etP63=(EditText) findViewById(R.id.etP63);
        etP64=(EditText) findViewById(R.id.etP64);
        etP65=(EditText) findViewById(R.id.etP65);

        //region DatePicker etP64 Fecha ingreso
        etP64.setOnClickListener(this);
        //endregion

        //region DatePicker etP65 Fecha salida
        etP65.setOnClickListener(this);
        //endregion

        sP60.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    tvP61.setVisibility(View.VISIBLE);
                    tvP62.setVisibility(View.VISIBLE);
                    tvP63.setVisibility(View.VISIBLE);
                    tvP64.setVisibility(View.VISIBLE);
                    tvP65.setVisibility(View.VISIBLE);
                    etP61.setVisibility(View.VISIBLE);
                    etP62.setVisibility(View.VISIBLE);
                    etP63.setVisibility(View.VISIBLE);
                    etP64.setVisibility(View.VISIBLE);
                    etP65.setVisibility(View.VISIBLE);
                }
                else {
                    tvP61.setVisibility(View.GONE);
                    tvP62.setVisibility(View.GONE);
                    tvP63.setVisibility(View.GONE);
                    tvP64.setVisibility(View.GONE);
                    tvP65.setVisibility(View.GONE);
                    etP61.setVisibility(View.GONE);
                    etP62.setVisibility(View.GONE);
                    etP63.setVisibility(View.GONE);
                    etP64.setVisibility(View.GONE);
                    etP65.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP66 Familiares en el extranjero
        sP66 = (Spinner) findViewById(R.id.sP66);
        sP66.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        sP72 = (Spinner) findViewById(R.id.sP72);
        sP72.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaContacto));
        sP72_1 = (Spinner) findViewById(R.id.sP72_1);
        sP72_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaContacto));

        //region Declaración variables
        personaE1=(TextView) findViewById(R.id.personaE1);
        personaE2=(TextView) findViewById(R.id.personaE2);

        tvP67=(TextView) findViewById(R.id.tvP67);
        tvP68=(TextView) findViewById(R.id.tvP68);
        tvP69=(TextView) findViewById(R.id.tvP69);
        tvP70=(TextView) findViewById(R.id.tvP70);
        tvP71=(TextView) findViewById(R.id.tvP71);
        tvP72=(TextView) findViewById(R.id.tvP72);

        etP67=(EditText) findViewById(R.id.etP67);
        etP68=(EditText) findViewById(R.id.etP68);
        etP70=(EditText) findViewById(R.id.etP70);
        etP71=(EditText) findViewById(R.id.etP71);

        etP69=(EditText) findViewById(R.id.etP69);

        tvP67_1=(TextView) findViewById(R.id.tvP67_1);
        tvP68_1=(TextView) findViewById(R.id.tvP68_1);
        tvP69_1=(TextView) findViewById(R.id.tvP69_1);
        tvP70_1=(TextView) findViewById(R.id.tvP70_1);
        tvP71_1=(TextView) findViewById(R.id.tvP71_1);
        tvP72_1=(TextView) findViewById(R.id.tvP72_1);

        etP67_1=(EditText) findViewById(R.id.etP67_1);
        etP68_1=(EditText) findViewById(R.id.etP68_1);
        etP70_1=(EditText) findViewById(R.id.etP70_1);
        etP71_1=(EditText) findViewById(R.id.etP71_1);

        etP69_1=(EditText) findViewById(R.id.etP69_1);
        //endregion

        sP66.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    //region VISIBLE
                    personaE1.setVisibility(View.VISIBLE);
                    personaE2.setVisibility(View.VISIBLE);
                    tvP67.setVisibility(View.VISIBLE);
                    tvP68.setVisibility(View.VISIBLE);
                    tvP69.setVisibility(View.VISIBLE);
                    tvP70.setVisibility(View.VISIBLE);
                    tvP71.setVisibility(View.VISIBLE);
                    tvP72.setVisibility(View.VISIBLE);

                    etP69.setVisibility(View.VISIBLE);

                    etP67.setVisibility(View.VISIBLE);
                    etP68.setVisibility(View.VISIBLE);
                    etP70.setVisibility(View.VISIBLE);
                    etP71.setVisibility(View.VISIBLE);
                    sP72.setVisibility(View.VISIBLE);

                    tvP67_1.setVisibility(View.VISIBLE);
                    tvP68_1.setVisibility(View.VISIBLE);
                    tvP69_1.setVisibility(View.VISIBLE);
                    tvP70_1.setVisibility(View.VISIBLE);
                    tvP71_1.setVisibility(View.VISIBLE);
                    tvP72_1.setVisibility(View.VISIBLE);

                    etP69_1.setVisibility(View.VISIBLE);

                    etP67_1.setVisibility(View.VISIBLE);
                    etP68_1.setVisibility(View.VISIBLE);
                    etP70_1.setVisibility(View.VISIBLE);
                    etP71_1.setVisibility(View.VISIBLE);
                    sP72_1.setVisibility(View.VISIBLE);
                    //endregion
                }
                else{
                    //region GONE
                    personaE1.setVisibility(View.GONE);
                    personaE2.setVisibility(View.GONE);
                    tvP67.setVisibility(View.GONE);
                    tvP68.setVisibility(View.GONE);
                    tvP69.setVisibility(View.GONE);
                    tvP70.setVisibility(View.GONE);
                    tvP71.setVisibility(View.GONE);
                    tvP72.setVisibility(View.GONE);

                    etP69.setVisibility(View.GONE);

                    etP67.setVisibility(View.GONE);
                    etP68.setVisibility(View.GONE);
                    etP70.setVisibility(View.GONE);
                    etP71.setVisibility(View.GONE);
                    sP72.setVisibility(View.GONE);

                    tvP67_1.setVisibility(View.GONE);
                    tvP68_1.setVisibility(View.GONE);
                    tvP69_1.setVisibility(View.GONE);
                    tvP70_1.setVisibility(View.GONE);
                    tvP71_1.setVisibility(View.GONE);
                    tvP72_1.setVisibility(View.GONE);

                    etP69_1.setVisibility(View.GONE);

                    etP67_1.setVisibility(View.GONE);
                    etP68_1.setVisibility(View.GONE);
                    etP70_1.setVisibility(View.GONE);
                    etP71_1.setVisibility(View.GONE);
                    sP72_1.setVisibility(View.GONE);
                    //endregion
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });



        //endregion

        //region sP73 Familiares en otros estados
        sP73 = (Spinner) findViewById(R.id.sP73);
        sP73.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        sP78 = (Spinner) findViewById(R.id.sP78);
        sP78.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaContacto));
        sP78_1 = (Spinner) findViewById(R.id.sP78_1);
        sP78_1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaContacto));

        //region Declaración de variables
        personaEstado1=(TextView) findViewById(R.id.personaEstado1);
        personaEstado2=(TextView) findViewById(R.id.personaEstado2);

        tvP74=(TextView) findViewById(R.id.tvP74);
        tvP75=(TextView) findViewById(R.id.tvP75);
        tvP76=(TextView) findViewById(R.id.tvP76);
        tvP77=(TextView) findViewById(R.id.tvP77);
        tvP78=(TextView) findViewById(R.id.tvP78);

        etP74=(EditText) findViewById(R.id.etP74);
        etP75=(EditText) findViewById(R.id.etP75);
        etP77=(EditText) findViewById(R.id.etP77);

        etP76=(EditText) findViewById(R.id.etP76);

        tvP74_1=(TextView) findViewById(R.id.tvP74_1);
        tvP75_1=(TextView) findViewById(R.id.tvP75_1);
        tvP76_1=(TextView) findViewById(R.id.tvP76_1);
        tvP77_1=(TextView) findViewById(R.id.tvP77_1);
        tvP78_1=(TextView) findViewById(R.id.tvP78_1);

        etP74_1=(EditText) findViewById(R.id.etP74_1);
        etP75_1=(EditText) findViewById(R.id.etP75_1);
        etP77_1=(EditText) findViewById(R.id.etP77_1);

        etP76_1=(EditText) findViewById(R.id.etP76_1);
        //endregion

        sP73.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    //region VISIBLE
                    personaEstado1.setVisibility(View.VISIBLE);
                    personaEstado2.setVisibility(View.VISIBLE);

                    tvP74.setVisibility(View.VISIBLE);
                    tvP75.setVisibility(View.VISIBLE);
                    tvP76.setVisibility(View.VISIBLE);
                    tvP77.setVisibility(View.VISIBLE);
                    tvP78.setVisibility(View.VISIBLE);

                    etP74.setVisibility(View.VISIBLE);
                    etP75.setVisibility(View.VISIBLE);
                    etP77.setVisibility(View.VISIBLE);
                    sP78.setVisibility(View.VISIBLE);

                    etP76.setVisibility(View.VISIBLE);

                    tvP74_1.setVisibility(View.VISIBLE);
                    tvP75_1.setVisibility(View.VISIBLE);
                    tvP76_1.setVisibility(View.VISIBLE);
                    tvP77_1.setVisibility(View.VISIBLE);
                    tvP78_1.setVisibility(View.VISIBLE);

                    etP74_1.setVisibility(View.VISIBLE);
                    etP75_1.setVisibility(View.VISIBLE);
                    etP77_1.setVisibility(View.VISIBLE);
                    sP78_1.setVisibility(View.VISIBLE);

                    etP76_1.setVisibility(View.VISIBLE);
                    //endregion
                }
                else{
                    //region GONE
                    personaEstado1.setVisibility(View.GONE);
                    personaEstado2.setVisibility(View.GONE);

                    tvP74.setVisibility(View.GONE);
                    tvP75.setVisibility(View.GONE);
                    tvP76.setVisibility(View.GONE);
                    tvP77.setVisibility(View.GONE);
                    tvP78.setVisibility(View.GONE);

                    etP74.setVisibility(View.GONE);
                    etP75.setVisibility(View.GONE);
                    etP77.setVisibility(View.GONE);
                    sP78.setVisibility(View.GONE);

                    etP76.setVisibility(View.GONE);

                    tvP74_1.setVisibility(View.GONE);
                    tvP75_1.setVisibility(View.GONE);
                    tvP76_1.setVisibility(View.GONE);
                    tvP77_1.setVisibility(View.GONE);
                    tvP78_1.setVisibility(View.GONE);

                    etP74_1.setVisibility(View.GONE);
                    etP75_1.setVisibility(View.GONE);
                    etP77_1.setVisibility(View.GONE);
                    sP78_1.setVisibility(View.GONE);

                    etP76_1.setVisibility(View.GONE);
                    //endregion
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP79 Tiene Pasaporte
        sP79 = (Spinner) findViewById(R.id.sP79);
        sP79.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));
        //endregion

        //region sP80 Tiene VISA
        sP80 = (Spinner) findViewById(R.id.sP80);
        sP80.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));
        //endregion

        //region sP82 Tomas Alcohol
        sP82 = (Spinner) findViewById(R.id.sP82);
        sP82.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_alcohol=(TextView) findViewById(R.id.tvP90_alcohol);
        tvP91_alcohol=(TextView) findViewById(R.id.tvP91_alcohol);
        tvP92_alcohol=(TextView) findViewById(R.id.tvP92_alcohol);

        etP91_alcohol=(EditText) findViewById(R.id.etP91_alcohol);
        etP92_alcohol=(EditText) findViewById(R.id.etP92_alcohol);//DatePicker

        sP90_alcohol=(Spinner) findViewById(R.id.sP90_alcohol);
        //endregion

        sP90_alcohol.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_alcohol.setOnClickListener(this);

        sP82.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_alcohol.setVisibility(View.VISIBLE);
                    tvP91_alcohol.setVisibility(View.VISIBLE);
                    tvP92_alcohol.setVisibility(View.VISIBLE);

                    sP90_alcohol.setVisibility(View.VISIBLE);

                    etP91_alcohol.setVisibility(View.VISIBLE);
                    etP92_alcohol.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_alcohol.setVisibility(View.GONE);
                    tvP91_alcohol.setVisibility(View.GONE);
                    tvP92_alcohol.setVisibility(View.GONE);

                    sP90_alcohol.setVisibility(View.GONE);

                    etP91_alcohol.setVisibility(View.GONE);
                    etP92_alcohol.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP83 Consume Tabaco
        sP83 = (Spinner) findViewById(R.id.sP83);
        sP83.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_tabaco=(TextView) findViewById(R.id.tvP90_tabaco);
        tvP91_tabaco=(TextView) findViewById(R.id.tvP91_tabaco);
        tvP92_tabaco=(TextView) findViewById(R.id.tvP92_tabaco);

        etP91_tabaco=(EditText) findViewById(R.id.etP91_tabaco);
        etP92_tabaco=(EditText) findViewById(R.id.etP92_tabaco);//DatePicker

        sP90_tabaco=(Spinner) findViewById(R.id.sP90_tabaco);
        //endregion

        sP90_tabaco.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_tabaco.setOnClickListener(this);

        sP83.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_tabaco.setVisibility(View.VISIBLE);
                    tvP91_tabaco.setVisibility(View.VISIBLE);
                    tvP92_tabaco.setVisibility(View.VISIBLE);

                    sP90_tabaco.setVisibility(View.VISIBLE);

                    etP91_tabaco.setVisibility(View.VISIBLE);
                    etP92_tabaco.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_tabaco.setVisibility(View.GONE);
                    tvP91_tabaco.setVisibility(View.GONE);
                    tvP92_tabaco.setVisibility(View.GONE);

                    sP90_tabaco.setVisibility(View.GONE);

                    etP91_tabaco.setVisibility(View.GONE);
                    etP92_tabaco.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP84 Consume Marihuana
        sP84 = (Spinner) findViewById(R.id.sP84);
        sP84.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_marihuana=(TextView) findViewById(R.id.tvP90_marihuana);
        tvP91_marihuana=(TextView) findViewById(R.id.tvP91_marihuana);
        tvP92_marihuana=(TextView) findViewById(R.id.tvP92_marihuana);

        etP91_marihuana=(EditText) findViewById(R.id.etP91_marihuana);
        etP92_marihuana=(EditText) findViewById(R.id.etP92_marihuana);//DatePicker

        sP90_marihuana=(Spinner) findViewById(R.id.sP90_marihuana);
        //endregion

        sP90_marihuana.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_marihuana.setOnClickListener(this);

        sP84.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_marihuana.setVisibility(View.VISIBLE);
                    tvP91_marihuana.setVisibility(View.VISIBLE);
                    tvP92_marihuana.setVisibility(View.VISIBLE);

                    sP90_marihuana.setVisibility(View.VISIBLE);

                    etP91_marihuana.setVisibility(View.VISIBLE);
                    etP92_marihuana.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_marihuana.setVisibility(View.GONE);
                    tvP91_marihuana.setVisibility(View.GONE);
                    tvP92_marihuana.setVisibility(View.GONE);

                    sP90_marihuana.setVisibility(View.GONE);

                    etP91_marihuana.setVisibility(View.GONE);
                    etP92_marihuana.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP85 Consume Pastillas
        sP85 = (Spinner) findViewById(R.id.sP85);
        sP85.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_pastillas=(TextView) findViewById(R.id.tvP90_pastillas);
        tvP91_pastillas=(TextView) findViewById(R.id.tvP91_pastillas);
        tvP92_pastillas=(TextView) findViewById(R.id.tvP92_pastillas);

        etP91_pastillas=(EditText) findViewById(R.id.etP91_pastillas);
        etP92_pastillas=(EditText) findViewById(R.id.etP92_pastillas);//DatePicker

        sP90_pastillas=(Spinner) findViewById(R.id.sP90_pastillas);
        //endregion

        sP90_pastillas.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_pastillas.setOnClickListener(this);

        sP85.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_pastillas.setVisibility(View.VISIBLE);
                    tvP91_pastillas.setVisibility(View.VISIBLE);
                    tvP92_pastillas.setVisibility(View.VISIBLE);

                    sP90_pastillas.setVisibility(View.VISIBLE);

                    etP91_pastillas.setVisibility(View.VISIBLE);
                    etP92_pastillas.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_pastillas.setVisibility(View.GONE);
                    tvP91_pastillas.setVisibility(View.GONE);
                    tvP92_pastillas.setVisibility(View.GONE);

                    sP90_pastillas.setVisibility(View.GONE);

                    etP91_pastillas.setVisibility(View.GONE);
                    etP92_pastillas.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });


        //endregion

        //region sP86 Consume Solventes
        sP86 = (Spinner) findViewById(R.id.sP86);
        sP86.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_solventes=(TextView) findViewById(R.id.tvP90_solventes);
        tvP91_solventes=(TextView) findViewById(R.id.tvP91_solventes);
        tvP92_solventes=(TextView) findViewById(R.id.tvP92_solventes);

        etP91_solventes=(EditText) findViewById(R.id.etP91_solventes);
        etP92_solventes=(EditText) findViewById(R.id.etP92_solventes);//DatePicker

        sP90_solventes=(Spinner) findViewById(R.id.sP90_solventes);
        //endregion

        sP90_solventes.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_solventes.setOnClickListener(this);

        sP86.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_solventes.setVisibility(View.VISIBLE);
                    tvP91_solventes.setVisibility(View.VISIBLE);
                    tvP92_solventes.setVisibility(View.VISIBLE);

                    sP90_solventes.setVisibility(View.VISIBLE);

                    etP91_solventes.setVisibility(View.VISIBLE);
                    etP92_solventes.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_solventes.setVisibility(View.GONE);
                    tvP91_solventes.setVisibility(View.GONE);
                    tvP92_solventes.setVisibility(View.GONE);

                    sP90_solventes.setVisibility(View.GONE);

                    etP91_solventes.setVisibility(View.GONE);
                    etP92_solventes.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP87 Consume Cristal
        sP87 = (Spinner) findViewById(R.id.sP87);
        sP87.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_cristal=(TextView) findViewById(R.id.tvP90_cristal);
        tvP91_cristal=(TextView) findViewById(R.id.tvP91_cristal);
        tvP92_cristal=(TextView) findViewById(R.id.tvP92_cristal);

        etP91_cristal=(EditText) findViewById(R.id.etP91_cristal);
        etP92_cristal=(EditText) findViewById(R.id.etP92_cristal);//DatePicker

        sP90_cristal=(Spinner) findViewById(R.id.sP90_cristal);
        //endregion

        sP90_cristal.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_cristal.setOnClickListener(this);

        sP87.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_cristal.setVisibility(View.VISIBLE);
                    tvP91_cristal.setVisibility(View.VISIBLE);
                    tvP92_cristal.setVisibility(View.VISIBLE);

                    sP90_cristal.setVisibility(View.VISIBLE);

                    etP91_cristal.setVisibility(View.VISIBLE);
                    etP92_cristal.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_cristal.setVisibility(View.GONE);
                    tvP91_cristal.setVisibility(View.GONE);
                    tvP92_cristal.setVisibility(View.GONE);

                    sP90_cristal.setVisibility(View.GONE);

                    etP91_cristal.setVisibility(View.GONE);
                    etP92_cristal.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP88 Consume cocaina
        sP88 = (Spinner) findViewById(R.id.sP88);
        sP88.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_cocaina=(TextView) findViewById(R.id.tvP90_cocaina);
        tvP91_cocaina=(TextView) findViewById(R.id.tvP91_cocaina);
        tvP92_cocaina=(TextView) findViewById(R.id.tvP92_cocaina);

        etP91_cocaina=(EditText) findViewById(R.id.etP91_cocaina);
        etP92_cocaina=(EditText) findViewById(R.id.etP92_cocaina);//DatePicker

        sP90_cocaina=(Spinner) findViewById(R.id.sP90_cocaina);
        //endregion

        sP90_cocaina.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_cocaina.setOnClickListener(this);

        sP88.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_cocaina.setVisibility(View.VISIBLE);
                    tvP91_cocaina.setVisibility(View.VISIBLE);
                    tvP92_cocaina.setVisibility(View.VISIBLE);

                    sP90_cocaina.setVisibility(View.VISIBLE);

                    etP91_cocaina.setVisibility(View.VISIBLE);
                    etP92_cocaina.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_cocaina.setVisibility(View.GONE);
                    tvP91_cocaina.setVisibility(View.GONE);
                    tvP92_cocaina.setVisibility(View.GONE);

                    sP90_cocaina.setVisibility(View.GONE);

                    etP91_cocaina.setVisibility(View.GONE);
                    etP92_cocaina.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion


        //region sP89 Otro Consumo

        sP89 = (Spinner) findViewById(R.id.sP89);
        sP89.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP90_otroConsumo=(TextView) findViewById(R.id.tvP90_otroConsumo);
        tvP91_otroConsumo=(TextView) findViewById(R.id.tvP91_otroConsumo);
        tvP92_otroConsumo=(TextView) findViewById(R.id.tvP92_otroConsumo);
        tvP93_otroConsumo=(TextView) findViewById(R.id.tvP93_otroConsumo);

        etP91_otroConsumo=(EditText) findViewById(R.id.etP91_otroConsumo);
        etP92_otroConsumo=(EditText) findViewById(R.id.etP92_otroConsumo);//DatePicker
        etP93_otroConsumo=(EditText) findViewById(R.id.etP93_otroConsumo);

        sP90_otroConsumo=(Spinner) findViewById(R.id.sP90_otroConsumo);
        //endregion

        sP90_otroConsumo.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,frecuenciaConsumo));
        etP92_otroConsumo.setOnClickListener(this);

        sP89.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvP90_otroConsumo.setVisibility(View.VISIBLE);
                    tvP91_otroConsumo.setVisibility(View.VISIBLE);
                    tvP92_otroConsumo.setVisibility(View.VISIBLE);
                    tvP93_otroConsumo.setVisibility(View.VISIBLE);

                    sP90_otroConsumo.setVisibility(View.VISIBLE);

                    etP91_otroConsumo.setVisibility(View.VISIBLE);
                    etP92_otroConsumo.setVisibility(View.VISIBLE);
                    etP93_otroConsumo.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_otroConsumo.setVisibility(View.GONE);
                    tvP91_otroConsumo.setVisibility(View.GONE);
                    tvP92_otroConsumo.setVisibility(View.GONE);
                    tvP93_otroConsumo.setVisibility(View.GONE);

                    sP90_otroConsumo.setVisibility(View.GONE);

                    etP91_otroConsumo.setVisibility(View.GONE);
                    etP92_otroConsumo.setVisibility(View.GONE);
                    etP93_otroConsumo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region sP94 Padece enfermedad
        sP94 = (Spinner) findViewById(R.id.sP94);
        sP94.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nosi));

        //region Declaración de variables
        tvP95=(TextView) findViewById(R.id.tvP95);
        etP95=(EditText) findViewById(R.id.etP95);
        //endregion

        sP94.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Si"){
                    tvP95.setVisibility(View.VISIBLE);
                    etP95.setVisibility(View.VISIBLE);
                }
                else{
                    tvP95.setVisibility(View.GONE);
                    etP95.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion

        //region etP98 Fecha Entrevista
        etP98=(EditText) findViewById(R.id.etP98);
        SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/ MM / yyyy HH:mm:ss");
        String fechaFormato=formatoFecha.format(new Date());
        etP98.setText(fechaFormato);
        //etP98.setOnClickListener(this);
        //endregion

        //region sP101 Datos Victima
        sP101=(Spinner) findViewById(R.id.sP101);
        sP101.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,dVictima));

        llDatosVictima=(LinearLayout) findViewById(R.id.llDatosVictima);

        sP101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if(selectedItem=="Persona"||selectedItem=="Tienda departamental"||selectedItem=="Otro"){
                    llDatosVictima.setVisibility(View.VISIBLE);
                }
                else{
                    llDatosVictima.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        //region etP97 FOLIO
        lista=db.getDatosGenerales();
        String tamaño=""+((lista.size())+1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);
        etP97=(EditText) findViewById(R.id.etP97);
        etP97.setText(MainMenu.entrevistador+"-"+fecha+"-"+tamaño);
        //endregion

        //region sp100
        sP100 = (Spinner) findViewById(R.id.sP100);
        sP100.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoEntrevista));
        //endregion


        final Date inicio=new Date();


        //endregion

        //region Sends the address to the map
        btnFind = (Button) findViewById(R.id.btnFind);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address = "";
                //street
                if(etP7.getText().toString().isEmpty() == false) {
                    address += etP7.getText().toString();
                }
                //number
                if(etP7_1.getText().toString().isEmpty() == false) {
                    if(address.isEmpty() == false) {
                        address += " ";
                    }
                    address += etP7_1.getText().toString();
                }
                //neighborhood
                if(etP8.getText().toString().isEmpty() == false) {
                    if(address.isEmpty() == false) {
                        address += ", ";
                    }

                    if(sP8.getSelectedItem().toString().equals("NA") == false) {
                        address += sP8.getSelectedItem().toString() + " ";
                    }

                    address += etP8.getText().toString();
                }
                //municipality
                if(etP9.getText().toString().isEmpty() == false) {
                    if(address.isEmpty() == false) {
                        address += ", ";
                    }
                    address += etP9.getText().toString();
                }
                //state
                if(etP10.getText().toString().isEmpty() == false) {
                    if(address.isEmpty() == false) {
                        address += ", ";
                    }
                    address += etP10.getText().toString();
                }

                if(address.isEmpty() == false) {
                    Intent intent = new Intent(v.getContext(), verificacion.class);
                    intent.putExtra("address", address);
                    startActivityForResult(intent, PICK_ADDRESS_REQUEST);
                }
            }
        });
        //endregion

        //region Guardar Datos

        btnGuardar=(Button) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Disable the button to avoid registering several clicks
                btnGuardar.setEnabled(false);

                //region Obtener Valores de formulario

                //region 1. DATOS GENERALES

                //region Definicion de variables
                etP1=(EditText) findViewById(R.id.etP1);
                etP2=(EditText) findViewById(R.id.etP2);
                etP3=(EditText) findViewById(R.id.etP3);
                etP4=(EditText) findViewById(R.id.etP4);
                etP5=(EditText) findViewById(R.id.etP5);

                etP96=(EditText) findViewById(R.id.etP96);
                etP99=(EditText) findViewById(R.id.etP99);


                r1=etP1.getText().toString().toUpperCase();
                r2=etP2.getText().toString().toUpperCase();
                r3=etP3.getText().toString().toUpperCase();
                r4=etP4.getText().toString().toUpperCase();
                r5=etP5.getText().toString().toUpperCase();
                r6=sP6.getSelectedItem().toString().toUpperCase();
                r98=etP98.getText().toString().toUpperCase();
                r96=etP96.getText().toString().toUpperCase();
                r99=etP99.getText().toString().toUpperCase();
                r100=sP100.getSelectedItem().toString().toUpperCase();
                r21_1=sP21_1.getSelectedItem().toString().toUpperCase();
                r32=sP32.getSelectedItem().toString().toUpperCase();
                r1_1=sP1_1.getSelectedItem().toString().toUpperCase();//Entrevistado
                r1_2=sP1_2.getSelectedItem().toString().toUpperCase();//Antecedente Penal

                Date fin=new Date();
                int min=fechasDiferenciaEnDias(inicio, fin);
                //endregion

                //region 1. DATOS GENERALES domicilio

                etP12=(EditText) findViewById(R.id.etP12);

                etP14=(EditText) findViewById(R.id.etP14);
                etP15=(EditText) findViewById(R.id.etP15);
                etP16=(EditText) findViewById(R.id.etP16);

                etP21=(EditText) findViewById(R.id.etP21);
                etP22=(EditText) findViewById(R.id.etP22);
                etP23=(EditText) findViewById(R.id.etP23);
                etP24=(EditText) findViewById(R.id.etP24);

                etP26=(EditText) findViewById(R.id.etP26);
                etP28=(EditText) findViewById(R.id.etP28);

                etP30=(EditText) findViewById(R.id.etP30);
                etP31=(EditText) findViewById(R.id.etP31);

                r7=etP7.getText().toString().toUpperCase();
                r7_1=etP7_1.getText().toString().toUpperCase();
                if(sP8.getSelectedItem().toString().equals("NA") == true) {
                    r8 = (etP8.getText().toString()).toUpperCase();
                }
                else {
                    r8 = ((sP8.getSelectedItem().toString() + " ") + (etP8.getText().toString())).toUpperCase();
                }
                r9=etP9.getText().toString().toUpperCase();
                r10=etP10.getText().toString().toUpperCase();
                r11=sP11.getSelectedItem().toString().toUpperCase();
                r12=etP12.getText().toString().toUpperCase();
                r13=sP13.getSelectedItem().toString().toUpperCase();
                r14=etP14.getText().toString().toUpperCase();
                r15=etP15.getText().toString().toUpperCase();
                r16=etP16.getText().toString().toUpperCase();
                r32_1=sP32_1.getSelectedItem().toString().toUpperCase();
                r17=etP17.getText().toString().toUpperCase();
                r18=etP18.getText().toString().toUpperCase();
                r19=etP19.getText().toString().toUpperCase();
                r20=etP20.getText().toString().toUpperCase();
                r21=etP21.getText().toString().toUpperCase();
                if(sP22.getSelectedItem().toString().equals("NA") == true) {
                    r22 = (etP22.getText().toString()).toUpperCase();
                }
                else {
                    r22 = ((sP22.getSelectedItem().toString() + " ") + (etP22.getText().toString())).toUpperCase();
                }
                r23=etP23.getText().toString().toUpperCase();
                r24=etP24.getText().toString().toUpperCase();
                r25=sP25.getSelectedItem().toString().toUpperCase();
                r26=etP26.getText().toString().toUpperCase();
                r27=sP27.getSelectedItem().toString().toUpperCase();
                r28=etP28.getText().toString().toUpperCase();
                r29=sP29.getSelectedItem().toString().toUpperCase();
                r30=etP30.getText().toString().toUpperCase();
                r31=etP31.getText().toString().toUpperCase();
                r31_1=sP31_1.getSelectedItem().toString().toUpperCase();
                r31_2=etP31_2.getText().toString().toUpperCase();

                //region Definición de variables
                //endregion

                //endregion

                //endregion

                //region 2. DATOS FAMILIARES Y PERSONAS CON LAS QUE HABITA EL IMPUTADO

                //region Datos Familiares

                r32=sP32.getSelectedItem().toString().toUpperCase();
                r33=et33.getText().toString().toUpperCase();
                r34=et34.getText().toString().toUpperCase();
                r35=et35.getText().toString().toUpperCase();
                r36=et36.getText().toString().toUpperCase();
                r37=et37.getText().toString().toUpperCase();
                r33_1=et33_1.getText().toString().toUpperCase();
                r34_1=et34_1.getText().toString().toUpperCase();
                r35_1=et35_1.getText().toString().toUpperCase();
                r36_1=et36_1.getText().toString().toUpperCase();
                r37_1=et37_1.getText().toString().toUpperCase();
                r33_2=et33_2.getText().toString().toUpperCase();
                r34_2=et34_2.getText().toString().toUpperCase();
                r35_2=et35_2.getText().toString().toUpperCase();
                r36_2=et36_2.getText().toString().toUpperCase();
                r37_2=et37_2.getText().toString().toUpperCase();
                r33_3=et33_3.getText().toString().toUpperCase();
                r34_3=et34_3.getText().toString().toUpperCase();
                r35_3=et35_3.getText().toString().toUpperCase();
                r36_3=et36_3.getText().toString().toUpperCase();
                r37_3=et37_3.getText().toString().toUpperCase();
                r38=etP38.getText().toString().toUpperCase();

                //endregion

                //region Referencias
                etP39=(EditText) findViewById(R.id.etP39);
                etP40=(EditText) findViewById(R.id.etP40);
                etP41=(EditText) findViewById(R.id.etP41);
                etP42=(EditText) findViewById(R.id.etP42);
                etP43=(EditText) findViewById(R.id.etP43);
                etP39_1=(EditText) findViewById(R.id.etP39_1);
                etP40_1=(EditText) findViewById(R.id.etP40_1);
                etP41_1=(EditText) findViewById(R.id.etP41_1);
                etP42_1=(EditText) findViewById(R.id.etP42_1);
                etP43_1=(EditText) findViewById(R.id.etP43_1);


                r39=etP39.getText().toString().toUpperCase();
                r40=etP40.getText().toString().toUpperCase();
                r41=etP41.getText().toString().toUpperCase();
                r42=etP42.getText().toString().toUpperCase();
                r43=etP43.getText().toString().toUpperCase();
                r39_1=etP39_1.getText().toString().toUpperCase();
                r40_1=etP40_1.getText().toString().toUpperCase();
                r41_1=etP41_1.getText().toString().toUpperCase();
                r42_1=etP42_1.getText().toString().toUpperCase();
                r43_1=etP43_1.getText().toString().toUpperCase();

                r44=sP44.getSelectedItem().toString().toUpperCase();
                r45=etP45.getText().toString().toUpperCase();
                r46=sP46.getSelectedItem().toString().toUpperCase();
                r47=etP47.getText().toString().toUpperCase();

                //endregion

                //endregion

                //region 3 y 4 HISTORIAL ESCOLAR Y LABORAL OCUPACIONAL
                r48=sP48.getSelectedItem().toString().toUpperCase();
                r49=etP49.getText().toString().toUpperCase();
                r50=sP50.getSelectedItem().toString().toUpperCase();

                r51=sP51.getSelectedItem().toString().toUpperCase();
                r52=etP52.getText().toString().toUpperCase();
                r53=etP53.getText().toString().toUpperCase();
                r54=sP54.getSelectedItem().toString().toUpperCase();
                r55=etP55.getText().toString().toUpperCase();
                r56=etP56.getText().toString().toUpperCase();
                r57=sP57.getSelectedItem().toString().toUpperCase();
                r58=etP58.getText().toString().toUpperCase();
                r51_1=sP51_1.getSelectedItem().toString().toUpperCase();
                r59=etP59.getText().toString().toUpperCase();
                //endregion

                //region 5. INFORMACIÓN DE FACILIDADES PARA ABANDONAR EL ESTADO
                etP81=(EditText) findViewById(R.id.etP81);

                r60=sP60.getSelectedItem().toString().toUpperCase();
                r61=etP61.getText().toString().toUpperCase();
                r62=etP62.getText().toString().toUpperCase();
                r63=etP63.getText().toString().toUpperCase();
                r64=etP64.getText().toString().toUpperCase();
                r65=etP65.getText().toString().toUpperCase();
                r66=sP66.getSelectedItem().toString().toUpperCase();
                r67=etP67.getText().toString().toUpperCase();
                r68=etP68.getText().toString().toUpperCase();
                r69=etP69.getText().toString().toUpperCase();
                r70=etP70.getText().toString().toUpperCase();
                r71=etP71.getText().toString().toUpperCase();
                r72=sP72.getSelectedItem().toString().toUpperCase();
                r67_1=etP67_1.getText().toString().toUpperCase();
                r68_1=etP68_1.getText().toString().toUpperCase();
                r69_1=etP69_1.getText().toString().toUpperCase();
                r70_1=etP70_1.getText().toString().toUpperCase();
                r71_1=etP71_1.getText().toString().toUpperCase();
                r72_1=sP72_1.getSelectedItem().toString().toUpperCase();
                r73=sP73.getSelectedItem().toString().toUpperCase();
                r74=etP74.getText().toString().toUpperCase();
                r75=etP75.getText().toString().toUpperCase();
                r76=etP76.getText().toString().toUpperCase();
                r77=etP77.getText().toString().toUpperCase();
                r78=sP78.getSelectedItem().toString().toUpperCase();
                r74_1=etP74_1.getText().toString().toUpperCase();
                r75_1=etP75_1.getText().toString().toUpperCase();
                r76_1=etP76_1.getText().toString().toUpperCase();
                r77_1=etP77_1.getText().toString().toUpperCase();
                r78_1=sP78_1.getSelectedItem().toString().toUpperCase();
                r79=sP79.getSelectedItem().toString().toUpperCase();
                r80=sP80.getSelectedItem().toString().toUpperCase();
                r81=etP81.getText().toString().toUpperCase();

                //endregion

                //region 6. SALUD Y CONDICIÓN FÍSICA
                r82=sP82.getSelectedItem().toString().toUpperCase();
                r90_alcohol=sP90_alcohol.getSelectedItem().toString().toUpperCase();
                r91_alcohol=etP91_alcohol.getText().toString().toUpperCase();
                r92_alcohol=etP92_alcohol.getText().toString().toUpperCase();
                r83=sP83.getSelectedItem().toString().toUpperCase();
                r90_tabaco=sP90_tabaco.getSelectedItem().toString().toUpperCase();
                r91_tabaco=etP91_tabaco.getText().toString().toUpperCase();
                r92_tabaco=etP92_tabaco.getText().toString().toUpperCase();
                r84=sP84.getSelectedItem().toString().toUpperCase();
                r90_marihuana=sP90_marihuana.getSelectedItem().toString().toUpperCase();
                r91_marihuana=etP91_marihuana.getText().toString().toUpperCase();
                r92_marihuana=etP92_marihuana.getText().toString().toUpperCase();
                r85=sP85.getSelectedItem().toString().toUpperCase();
                r90_pastillas=sP90_pastillas.getSelectedItem().toString().toUpperCase();
                r91_pastillas=etP91_pastillas.getText().toString().toUpperCase();
                r92_pastillas=etP92_pastillas.getText().toString().toUpperCase();
                r86=sP86.getSelectedItem().toString().toUpperCase();
                r90_solventes=sP90_solventes.getSelectedItem().toString().toUpperCase();
                r91_solventes=etP91_solventes.getText().toString().toUpperCase();
                r92_solventes=etP92_solventes.getText().toString().toUpperCase();
                r87=sP87.getSelectedItem().toString().toUpperCase();
                r90_cristal=sP90_cristal.getSelectedItem().toString().toUpperCase();
                r91_cristal=etP91_cristal.getText().toString().toUpperCase();
                r92_cristal=etP92_cristal.getText().toString().toUpperCase();
                r88=sP88.getSelectedItem().toString().toUpperCase();
                r90_cocaina=sP90_cocaina.getSelectedItem().toString().toUpperCase();
                r91_cocaina=etP91_cocaina.getText().toString().toUpperCase();
                r92_cocaina=etP92_cocaina.getText().toString().toUpperCase();
                r89=sP89.getSelectedItem().toString().toUpperCase();
                r93_otroConsumo=etP93_otroConsumo.getText().toString().toUpperCase();
                r90_otroConsumo=sP90_otroConsumo.getSelectedItem().toString().toUpperCase();
                r91_otroConsumo=etP91_otroConsumo.getText().toString().toUpperCase();
                r92_otroConsumo=etP92_otroConsumo.getText().toString().toUpperCase();
                r94=sP94.getSelectedItem().toString().toUpperCase();
                r95=etP95.getText().toString().toUpperCase();
                //endregion

                //region Datos Victima
                etP102=(EditText) findViewById(R.id.etP102);
                etP103=(EditText) findViewById(R.id.etP103);
                etP104=(EditText) findViewById(R.id.etP104);
                etP105=(EditText) findViewById(R.id.etP105);


                r101=sP101.getSelectedItem().toString().toUpperCase();
                r102=etP102.getText().toString().toUpperCase();
                r103=etP103.getText().toString().toUpperCase();
                r104=etP104.getText().toString().toUpperCase();
                r105=etP105.getText().toString().toUpperCase();
                //endregion

                r98=etP98.getText().toString().toUpperCase();// dato de fecha de entrevista



                FOLIO=etP97.getText().toString().toUpperCase();

                //endregion

                //region Insertar a Base de Datos
                if(ValidaFormulario()) {
                    db.insertarDatosGenerales(r1, r2, r3, r4, r5, r6, FOLIO, r98, min, r96, r99, r100, "", "", "", r21_1, r32,r1_1,r1_2, r31_1, r31_2);
                    db.insertarDatosGeneralesDomicilio(r7, r7_1, r8, r9, r10, r11, r12, r13, r14, r15, r16, r32_1, r17,
                            r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, confirmedMainLatitude, confirmedMainLongitude, FOLIO);
                    db.insertarDatosFamiliares(r32, r33, r34, r35, r36, r37, r33_1, r34_1, r35_1, r36_1, r37_1, r33_2, r34_2, r35_2, r36_2, r37_2,
                            r33_3, r34_3, r35_3, r36_3, r37_3, r38, FOLIO);
                    db.insertarDatosReferencias(r39, r40, r41, r42, r43, r39_1, r40_1, r41_1, r42_1, r43_1, r44, r45, r46, r47, FOLIO);
                    db.insertarDatosEscolarLaboral(r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r51_1, r59, FOLIO);
                    db.insertarDatosAbandonoEstado(r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r67_1, r68_1, r69_1, r70_1, r71_1, r72_1, r73, r74,
                            r75, r76, r77, r78, r74_1, r75_1, r76_1, r77_1, r78_1, r79, r80, r81, FOLIO);
                    db.insertarDatosSalud(r82, r90_alcohol, r91_alcohol, r92_alcohol, r83, r90_tabaco, r91_tabaco, r92_tabaco, r84, r90_marihuana, r91_marihuana, r92_marihuana,
                            r85, r90_pastillas, r91_pastillas, r92_pastillas, r86, r90_solventes, r91_solventes, r92_solventes, r87, r90_cristal, r91_cristal, r92_cristal,
                            r88, r90_cocaina, r91_cocaina, r92_cocaina, r89, r93_otroConsumo, r90_otroConsumo, r91_otroConsumo, r92_otroConsumo, r94, r95, FOLIO);
                    Toast.makeText(getApplicationContext(), "Datos Guardados", Toast.LENGTH_SHORT).show();
                    db.insertarDatosVictima(r101, r102, r103, r104, r105, FOLIO);

                    Intent intent = new Intent(v.getContext(), MainMenu.class);
                    startActivity(intent);
                }
                else{
                    btnGuardar.setEnabled(true);
                }
                //endregion

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
        //endregion

    }
    //endregion

    //region Display the address from the map
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        if (requestCode == PICK_ADDRESS_REQUEST) {
            if (resultCode == RESULT_OK) {
                String confirmedStreet = "";
                String confirmedNumber = "";
                String confirmedNeighborhood = "";
                String confirmedMunicipality = "";
                String confirmedState = "";

                Bundle bundle = resultIntent.getExtras();
                if (bundle != null) {
                    confirmedStreet = bundle.getString("confirmedStreet");
                    etP7.setText(confirmedStreet);
                    confirmedNumber = bundle.getString("confirmedNumber");
                    etP7_1.setText(confirmedNumber);
                    confirmedNeighborhood = bundle.getString("confirmedNeighborhood");
                    etP8.setText(confirmedNeighborhood);
                    confirmedMunicipality = bundle.getString("confirmedMunicipality");
                    etP9.setText(confirmedMunicipality);
                    confirmedState = bundle.getString("confirmedState");
                    etP10.setText(confirmedState);

                    confirmedMainLatitude = bundle.getString("confirmedLatitude");
                    confirmedMainLongitude = bundle.getString("confirmedLongitude");
                }
            }
        }
    }
    //endregion

    //region Crear y seleccionar DatePicker
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.etP3:
                showDatePickerDialog(etP3);
                break;
            case R.id.etP56:
                showDatePickerDialog(etP56);
                break;
            case R.id.etP64:
                showDatePickerDialog(etP64);
                break;
            case R.id.etP65:
                showDatePickerDialog(etP65);
                break;
            case R.id.etP92_alcohol:
                showDatePickerDialog(etP92_alcohol);
                break;
            case R.id.etP92_tabaco:
                showDatePickerDialog(etP92_tabaco);
                break;
            case R.id.etP92_marihuana:
                showDatePickerDialog(etP92_marihuana);
                break;
            case R.id.etP92_pastillas:
                showDatePickerDialog(etP92_pastillas);
                break;
            case R.id.etP92_solventes:
                showDatePickerDialog(etP92_solventes);
                break;
            case R.id.etP92_cristal:
                showDatePickerDialog(etP92_cristal);
                break;
            case R.id.etP92_cocaina:
                showDatePickerDialog(etP92_cocaina);
                break;
            case R.id.etP92_otroConsumo:
                showDatePickerDialog(etP92_otroConsumo);
                break;

            /*case R.id.etP98:
                showDatePickerDialog(etP98);
                break;*/
        }
    }
    //endregion

    //region fechasDiferenciaEnDias
    public static int fechasDiferenciaEnDias(Date fechaInicial, Date fechaFinal) {

        String diferenciaFinal="";

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        String fechaInicioString = df.format(fechaInicial);
        try {
            fechaInicial = df.parse(fechaInicioString);
        }
        catch (ParseException ex) {
        }

        String fechaFinalString = df.format(fechaFinal);
        try {
            fechaFinal = df.parse(fechaFinalString);
        }
        catch (ParseException ex) {
        }

        int diferencia=(int) ((fechaFinal.getTime()-fechaInicial.getTime())/1000);
        /*int dias=0;
        int horas=0;
        int minutos=0;
        if(diferencia>86400) {
            dias=(int)Math.floor(diferencia/86400);
            diferencia=diferencia-(dias*86400);
        }
        if(diferencia>3600) {
            horas=(int)Math.floor(diferencia/3600);
            diferencia=diferencia-(horas*3600);
        }
        if(diferencia>60) {
            minutos=(int)Math.floor(diferencia/60);
            diferencia=diferencia-(minutos*60);
        }*/

        int minutos=(int)Math.floor(diferencia/60);

        return minutos;
    }
    //endregion

    //region viveConPadres
    public void viveConPadres(){
        if (vivePadres==true){
            et33.setText(etP17.getText().toString());
            et34.setText("Papá");
            et33_1.setText(etP19.getText().toString());
            et34_1.setText("Mamá");
        }
        else{
            et33.setText("");
            et34.setText("");
            et33_1.setText("");
            et34_1.setText("");
        }

    }

    //endregion

    //region ValidaFormulario
    public boolean ValidaFormulario(){
        String verifica="";
        boolean validacion=true;

        if(r66.equals("SI")){
            if(r67.equals("")||r68.equals("")||r69.equals("")||r70.equals("")||r71.equals("")||r72.equals("")){
                validacion=false;
                verifica="\nDatos de familiares en el extranjero"+verifica;
                llFAEstado.setVisibility(View.VISIBLE);
                sP32.requestFocus();
            }
        }
        if(r60.equals("SI")){
            if(r61.equals("")||r62.equals("")||r63.equals("")||r64.equals("")||r65.equals("")){
                validacion=false;
                verifica="\nDatos de si ha Viajado fuera del país"+verifica;
                llFAEstado.setVisibility(View.VISIBLE);
                sP32.requestFocus();
            }
        }
        if(r51.equals("SI")){
            if(r52.equals("")||r58.equals("")){
                validacion=false;
                verifica="\nTrabajo"+verifica;
                llDatosLaborales.setVisibility(View.VISIBLE);
                sP51.requestFocus();
            }
        }
        else if(r59.equals("")){
            validacion=false;
            verifica="\nTrabajo"+verifica;
            llDatosLaborales.setVisibility(View.VISIBLE);
            sP51.requestFocus();
        }
        if(r48.equals("SI")){
            if(r49.equals("")||r50.equals("")){
                validacion=false;
                verifica="\nEstudios"+verifica;
                llDatosEscolares.setVisibility(View.VISIBLE);
                sP48.requestFocus();
            }
        }
        if (!(r32.equals("0"))){
            if(r33.equals("")||r34.equals("")||r35.equals("")||r36.equals("")||r37.equals("")){
                validacion=false;
                verifica="\nFamiliares con los que habita"+verifica;
                llDatosFamiliares.setVisibility(View.VISIBLE);
                sP32.requestFocus();
            }
        }
        if(r29.equals("")){
            validacion=false;
            verifica="\nEstado Civil"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            sP29.requestFocus();
        }
        if(r21_1.equals("SI")){
            if(r21.equals("")||r22.equals("")||r23.equals("")||r24.equals("")){
                validacion=false;
                verifica="\nDomicilio Secundario"+verifica;
                llDatosGenerales.setVisibility(View.VISIBLE);
                etP21.requestFocus();
            }
        }
        if(r17.equals("")||r19.equals("")){
            validacion=false;
            verifica="\nNombre de los padres"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            etP17.requestFocus();
        }
        if(r13.equals("NA")){
            validacion=false;
            verifica="\nIngrese un valor en tiempo habitando en domicilio"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            sP13.requestFocus();
        }
        if(r7.equals("")||r7_1.equals("")||r8.equals("")||r9.equals("")||r10.equals("")){
            validacion=false;
            verifica="\nDatos de domicilio"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            etP7.requestFocus();
        }
        if(r5.equals("")){
            validacion=false;
            verifica="\nLugar de nacimiento"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            etP5.requestFocus();
        }
        if(r3.equals("")){
            validacion=false;
            verifica="\nFecha de nacimiento"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            etP3.requestFocus();
        }
        if(r1.equals("")){
            validacion=false;
            verifica="\nNombre"+verifica;
            llDatosGenerales.setVisibility(View.VISIBLE);
            etP1.requestFocus();
            //etP1.setBackground(Color.parseColor();
        }

        if(!validacion){
            Toast.makeText(getApplicationContext(), "Verifica los siguientes datos:"+verifica,Toast.LENGTH_LONG).show();
        }

        return validacion;
    }
    //endregion
    private long backPressedTime = 0;
    @Override
    public void onBackPressed() {        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 2 secs
            backPressedTime = t;
            Toast.makeText(this, "Presiona nuevamente para salir al menu principal",
                    Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    }
    //endregion

}

