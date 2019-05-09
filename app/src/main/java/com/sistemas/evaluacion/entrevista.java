package com.sistemas.evaluacion;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class entrevista extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "Entrevista";

    private TextView tvP38,persona1,persona2,persona3,persona4, personaE1, personaE2,
            personaEstado1, personaEstado2, tv33, tv33_1, tv33_2, tv33_3, tv34, tv34_1,
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

    private EditText etP3, et33, et33_1, et33_2, et33_3, et34, et34_1, et34_2, et34_3,
            et35, et35_1, et35_2, et35_3, et36, et36_1, et36_2, et36_3, et37, et37_1,
            et37_2, et37_3, etP38, etP45, etP47, etP49, etP52, etP53, etP54 , etP55,
            etP56, etP57, etP58, etP59, etP61, etP62, etP63, etP64, etP65, etP67, etP68, etP69, etP69_1, etP70,
            etP71, etP72, etP67_1, etP68_1, etP70_1, etP71_1, etP72_1, etP74, etP75, etP77,
            etP78, etP74_1, etP75_1, etP76, etP76_1, etP77_1, etP78_1, etP91_alcohol, etP92_alcohol, etP91_tabaco,
            etP92_tabaco, etP91_marihuana, etP92_marihuana, etP91_pastillas, etP92_pastillas,
            etP91_solventes, etP92_solventes, etP91_cristal, etP92_cristal, etP91_cocaina,
            etP92_cocaina, etP91_otroConsumo, etP92_otroConsumo, etP93_otroConsumo, etP95, etP98;

    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private Spinner sP6, sP11, sP13, sP25, sP29, sP32, sP44, sP46, sP48, sP50, sP51,
                    sP60, sP66, sP73, sP79, sP80, sP82,
                    sP90_alcohol, sP83, sP90_tabaco, sP84, sP90_marihuana, sP85, sP90_pastillas,
                    sP86,sP90_solventes, sP87, sP90_cristal, sP88, sP90_cocaina, sP89, sP90_otroConsumo,
                    sP94;


    private String [] tipoDomicilio={"Rentada", "Prestada", "Propia", "Familiar", "Situación de calle", "Irregular"};
    private String [] tiempoRadicando={"Menos de un mes", "Un mes", "Entre 1 y 3 meses", "Entre 3 y 6 meses", "Entre 6 meses y un año", "Entre 1 y 3 años", "Entre 3 y 6 años", "Más de 6 años"};
    private String [] nosi={"No", "Si"};
    private String [] frecuenciaConsumo={"No consume", "Diariamente", "Cada Tercer día", "Semanalmente", "Quincenalmente", "Mensualmente", "Anualmente"};
    private String r32="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista);

        //region P3 Fecha-Nacimiento
        etP3=(EditText) findViewById(R.id.etP3);
        etP3.setOnClickListener(this);
        //endregion

        //region SP6 Sexo
        sP6 = (Spinner) findViewById(R.id.sP6);
        String [] sexo={"Masculino", "Femenino"};
        sP6.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sexo));
        //endregion Sexo Se

        //region SP11 Tipo Domicilio
        sP11 = (Spinner) findViewById(R.id.sP11);
        sP11.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoDomicilio));
        //endregion tip

        //region SP13 Tiempo Radicando
        sP13 = (Spinner) findViewById(R.id.sP13);
        sP13.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tiempoRadicando));
        //endregion

        //region SP25 Tipo de domicilio secundario
        sP25 = (Spinner) findViewById(R.id.sP25);
        sP25.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,tipoDomicilio));
        //endregion

        //region SP29 Estado Civil
        sP29 = (Spinner) findViewById(R.id.sP29);
        String [] estadoCivil={"Soltero(a)", "Casado(a)","Unión Libre"};
        sP29.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,estadoCivil));
        //endregion

        //region SP32 # Personas con las que vive actualmente
        sP32 = (Spinner) findViewById(R.id.sP32);
        String [] nPersonas={"0","1","2","3","4"};
        sP32.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,nPersonas));

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
                r32=parent.getSelectedItem().toString();
                String selectedItem=parent.getSelectedItem().toString();
                switch (selectedItem){
                    case "0":
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
        etP54=(EditText) findViewById(R.id.etP54);
        etP55=(EditText) findViewById(R.id.etP55);
        etP56=(EditText) findViewById(R.id.etP56);
        etP57=(EditText) findViewById(R.id.etP57);
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
                    etP54.setVisibility(View.VISIBLE);
                    etP55.setVisibility(View.VISIBLE);
                    etP56.setVisibility(View.VISIBLE);
                    etP57.setVisibility(View.VISIBLE);
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
                    etP54.setVisibility(View.GONE);
                    etP55.setVisibility(View.GONE);
                    etP56.setVisibility(View.GONE);
                    etP57.setVisibility(View.GONE);
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
        etP72=(EditText) findViewById(R.id.etP72);

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
        etP72_1=(EditText) findViewById(R.id.etP72_1);

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
                    etP72.setVisibility(View.VISIBLE);

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
                    etP72_1.setVisibility(View.VISIBLE);
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
                    etP72.setVisibility(View.GONE);

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
                    etP72_1.setVisibility(View.GONE);
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
        etP78=(EditText) findViewById(R.id.etP78);

        etP76=(EditText) findViewById(R.id.etP76);

        tvP74_1=(TextView) findViewById(R.id.tvP74_1);
        tvP75_1=(TextView) findViewById(R.id.tvP75_1);
        tvP76_1=(TextView) findViewById(R.id.tvP76_1);
        tvP77_1=(TextView) findViewById(R.id.tvP77_1);
        tvP78_1=(TextView) findViewById(R.id.tvP78_1);

        etP74_1=(EditText) findViewById(R.id.etP74_1);
        etP75_1=(EditText) findViewById(R.id.etP75_1);
        etP77_1=(EditText) findViewById(R.id.etP77_1);
        etP78_1=(EditText) findViewById(R.id.etP78_1);

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
                    etP78.setVisibility(View.VISIBLE);

                    etP76.setVisibility(View.VISIBLE);

                    tvP74_1.setVisibility(View.VISIBLE);
                    tvP75_1.setVisibility(View.VISIBLE);
                    tvP76_1.setVisibility(View.VISIBLE);
                    tvP77_1.setVisibility(View.VISIBLE);
                    tvP78_1.setVisibility(View.VISIBLE);

                    etP74_1.setVisibility(View.VISIBLE);
                    etP75_1.setVisibility(View.VISIBLE);
                    etP77_1.setVisibility(View.VISIBLE);
                    etP78_1.setVisibility(View.VISIBLE);

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
                    etP78.setVisibility(View.GONE);

                    etP76.setVisibility(View.GONE);

                    tvP74_1.setVisibility(View.GONE);
                    tvP75_1.setVisibility(View.GONE);
                    tvP76_1.setVisibility(View.GONE);
                    tvP77_1.setVisibility(View.GONE);
                    tvP78_1.setVisibility(View.GONE);

                    etP74_1.setVisibility(View.GONE);
                    etP75_1.setVisibility(View.GONE);
                    etP77_1.setVisibility(View.GONE);
                    etP78_1.setVisibility(View.GONE);

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
        etP98.setOnClickListener(this);
        //endregion


        //region
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
            case R.id.etP98:
                showDatePickerDialog(etP98);
                break;
        }
    }



}
