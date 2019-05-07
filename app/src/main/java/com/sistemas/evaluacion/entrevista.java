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

import java.util.Calendar;

public class entrevista extends AppCompatActivity {

    private static final String TAG = "Entrevista";

    private EditText p3, et33, et33_1, et33_2, et33_3, et34, et34_1, et34_2, et34_3, et35, et35_1, et35_2, et35_3, et36, et36_1, et36_2, et36_3, et37, et37_1, et37_2, et37_3, etP38;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Spinner sP6, sP11, sP13, sP25, sP29, sP32;
    private TextView tvP38,persona1,persona2,persona3,persona4,tv33, tv33_1, tv33_2, tv33_3, tv34, tv34_1, tv34_2, tv34_3, tv35, tv35_1, tv35_2, tv35_3, tv36, tv36_1, tv36_2, tv36_3, tv37, tv37_1, tv37_2, tv37_3;

    private String [] tipoDomicilio={"Rentada", "Prestada", "Propia", "Familiar", "Situación de calle", "Irregular"};
    private String [] tiempoRadicando={"Menos de un mes", "Un mes", "Entre 1 y 3 meses", "Entre 3 y 6 meses", "Entre 6 meses y un año", "Entre 1 y 3 años", "Entre 3 y 6 años", "Más de 6 años"};
    private String r32="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista);

        //region P3 Fecha-Nacimiento
        p3=(EditText) findViewById(R.id.etP3);

        p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        entrevista.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date =  day+ "/" +month  + "/" + year;
                p3.setText(date);
            }
        };
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

        //region

        //endregion

        //region

        //endregion

        //region

        //endregion

        //region

        //endregion

        //region

        //endregion

        //region

        //endregion




    }


}
