package com.sistemas.evaluacion;

import android.content.Intent;
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
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosAbandonoEstado;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosEscolarLaboral;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosHabitantes;
import com.sistemas.evaluacion.entidades.datosReferencias;
import com.sistemas.evaluacion.entidades.datosSalud;
import com.sistemas.evaluacion.entidades.datosVictima;

import java.util.ArrayList;

public class verificacion extends AppCompatActivity {

    //region Variables Globales
    private MyOpenHelper db;

    //region Spinner
    private Spinner sVerificationName, sP108;
    //endregion

    //region Boolean
    private boolean datosGenerales=false, datosFamiliares=false, datosEscolares=false, datosLaborales=false, datosFAestado=false, datosSalud=false;
    //endregion

    //region TextView
    private TextView tvP1, tvP1_1, tvP1_2, tvP2, tvP3, tvP4, tvP5, tvP6, tvP7,  tvP7_1, tvP8, tvP9, tvP10, tvP11, tvP12,
            tvP13, tvP14, tvP15, tvP16, tvP32_1, tvP17, tvP18, tvP19, tvP20, tvP21_1, tvP21, tvP22,
            tvP23, tvP24, tvP25, tvP26, tvP27, tvP28, tvP101, tvP102, tvP103, tvP104, tvP105, tvP29, tvP30, tvP31, tvP31_1,
            tvP31_2, tvP32, tvP33, tvP34, tvP35, tvP36, tvP37, tvP33_1, tvP34_1, tvP35_1, tvP36_1, tvP37_1, tvP33_2, tvP34_2,
            tvP35_2, tvP36_2, tvP37_2, tvP33_3, tvP34_3, tvP35_3, tvP36_3, tvP37_3, tvP38, tvP39,
            tvP40, tvP41, tvP42, tvP43, tvP39_1, tvP40_1, tvP41_1, tvP42_1, tvP43_1, tvP44, tvP45,
            tvP46, tvP47, tvP48, tvP49, tvP50, tvP51, tvP52, tvP53, tvP54, tvP55, tvP57, tvP56,
            tvP58, tvP51_1, tvP59, tvP60, tvP61, tvP62, tvP63, tvP64, tvP65, tvP66, tvP67, tvP68, tvP69,
            tvP70, tvP71, tvP72, tvP67_1, tvP68_1, tvP69_1, tvP70_1, tvP71_1, tvP72_1, tvP73, tvP74,
            tvP75, tvP76, tvP77, tvP78, tvP74_1, tvP75_1, tvP76_1, tvP77_1, tvP78_1, tvP79, tvP80,
            tvP81, tvP82, tvP90_alcohol, tvP91_alcohol, tvP92_alcohol, tvP83, tvP90_tabaco,
            tvP91_tabaco, tvP92_tabaco, tvP84, tvP90_marihuana, tvP91_marihuana, tvP92_marihuana,
            tvP85, tvP90_pastillas, tvP91_pastillas, tvP92_pastillas, tvP86, tvP90_solventes,
            tvP91_solventes, tvP92_solventes, tvP87, tvP90_cristal, tvP91_cristal, tvP92_cristal,
            tvP88, tvP90_cocaina, tvP91_cocaina, tvP92_cocaina, tvP89, tvP93_otroConsumo,
            tvP90_otroConsumo, tvP91_otroConsumo, tvP92_otroConsumo, tvP94, tvP95, tvP96, tvP97,
            tvP99, tvP109, tvP110, persona1, persona2, persona3, persona4, personaE1, personaE2,
            personaEstado1, personaEstado2;
    private TextView tvO1, tvO1_1, tvO1_2, tvO2, tvO3, tvO4, tvO5, tvO6, tvO7, tvO7_1, tvO8, tvO9, tvO10, tvO11, tvO12,
            tvO13, tvO14, tvO15, tvO16, tvO32_1, tvO17, tvO18, tvO19, tvO20, tvO21_1, tvO21, tvO22,
            tvO23, tvO24, tvO25, tvO26, tvO27, tvO28, tvO101, tvO102, tvO103, tvO104, tvO105, tvO29, tvO30, tvO31, tvO31_1,
            tvO31_2, tvO32, tvO33, tvO34, tvO35, tvO36, tvO37, tvO33_1, tvO34_1, tvO35_1, tvO36_1, tvO37_1, tvO33_2, tvO34_2,
            tvO35_2, tvO36_2, tvO37_2, tvO33_3, tvO34_3, tvO35_3, tvO36_3, tvO37_3, tvO38, tvO39,
            tvO40, tvO41, tvO42, tvO43, tvO39_1, tvO40_1, tvO41_1, tvO42_1, tvO43_1, tvO44, tvO45,
            tvO46, tvO47, tvO48, tvO49, tvO50, tvO51, tvO52, tvO53, tvO54, tvO55, tvO57, tvO56,
            tvO58, tvO51_1, tvO59, tvO60, tvO61, tvO62, tvO63, tvO64, tvO65, tvO66, tvO67, tvO68, tvO69,
            tvO70, tvO71, tvO72, tvO67_1, tvO68_1, tvO69_1, tvO70_1, tvO71_1, tvO72_1, tvO73, tvO74,
            tvO75, tvO76, tvO77, tvO78, tvO74_1, tvO75_1, tvO76_1, tvO77_1, tvO78_1, tvO79, tvO80,
            tvO81, tvO82, tvO90_alcohol, tvO91_alcohol, tvO92_alcohol, tvO83, tvO90_tabaco,
            tvO91_tabaco, tvO92_tabaco, tvO84, tvO90_marihuana, tvO91_marihuana, tvO92_marihuana,
            tvO85, tvO90_pastillas, tvO91_pastillas, tvO92_pastillas, tvO86, tvO90_solventes,
            tvO91_solventes, tvO92_solventes, tvO87, tvO90_cristal, tvO91_cristal, tvO92_cristal,
            tvO88, tvO90_cocaina, tvO91_cocaina, tvO92_cocaina, tvO89, tvO93_otroConsumo,
            tvO90_otroConsumo, tvO91_otroConsumo, tvO92_otroConsumo, tvO94, tvO95;
    //endregion

    //region EditText
    private EditText etP1, etP1_1, etP1_2, etP2, etP3, etP4, etP5, etP6, etP7, etP7_1, etP8, etP9, etP10, etP11, etP12,
            etP13, etP14, etP15, etP16, etP32_1, etP17, etP18, etP19, etP20, etP21_1, etP21, etP22,
            etP23, etP24, etP25, etP26, etP27, etP28, etP101, etP102, etP103, etP104, etP105, etP29, etP30, etP31, etP31_1,
            etP31_2, etP32, etP33, etP34, etP35, etP36, etP37, etP33_1, etP34_1, etP35_1, etP36_1, etP37_1, etP33_2, etP34_2,
            etP35_2, etP36_2, etP37_2, etP33_3, etP34_3, etP35_3, etP36_3, etP37_3, etP38, etP39,
            etP40, etP41, etP42, etP43, etP39_1, etP40_1, etP41_1, etP42_1, etP43_1, etP44, etP45,
            etP46, etP47, etP48, etP49, etP50, etP51, etP52, etP53, etP54, etP55, etP57, etP56,
            etP58, etP51_1, etP59, etP60, etP61, etP62, etP63, etP64, etP65, etP66, etP67, etP68, etP69,
            etP70, etP71, etP72, etP67_1, etP68_1, etP69_1, etP70_1, etP71_1, etP72_1, etP73, etP74,
            etP75, etP76, etP77, etP78, etP74_1, etP75_1, etP76_1, etP77_1, etP78_1, etP79, etP80,
            etP81, etP82, etP90_alcohol, etP91_alcohol, etP92_alcohol, etP83, etP90_tabaco,
            etP91_tabaco, etP92_tabaco, etP84, etP90_marihuana, etP91_marihuana, etP92_marihuana,
            etP85, etP90_pastillas, etP91_pastillas, etP92_pastillas, etP86, etP90_solventes,
            etP91_solventes, etP92_solventes, etP87, etP90_cristal, etP91_cristal, etP92_cristal,
            etP88, etP90_cocaina, etP91_cocaina, etP92_cocaina, etP89, etP93_otroConsumo,
            etP90_otroConsumo, etP91_otroConsumo, etP92_otroConsumo, etP94, etP95, etP109, etP110;
    //endregion

    //region CheckedTextView
    private CheckedTextView ctvP1, ctvP1_1, ctvP1_2, ctvP2, ctvP3, ctvP4, ctvP5, ctvP6, ctvP7, ctvP7_1, ctvP8, ctvP9,
            ctvP10, ctvP11, ctvP12, ctvP13, ctvP14, ctvP15, ctvP16, ctvP32_1, ctvP17, ctvP18,
            ctvP19, ctvP20, ctvP21_1, ctvP21, ctvP22, ctvP23, ctvP24, ctvP25, ctvP26,
            ctvP27, ctvP28, ctvP101, ctvP102, ctvP103, ctvP104, ctvP105, ctvP29, ctvP30, ctvP31, ctvP31_1, ctvP31_2, ctvP32,
            ctvP33, ctvP34, ctvP35, ctvP36, ctvP37, ctvP33_1, ctvP34_1, ctvP35_1, ctvP36_1, ctvP37_1, ctvP33_2, ctvP34_2, ctvP35_2,
            ctvP36_2, ctvP37_2, ctvP33_3, ctvP34_3, ctvP35_3, ctvP36_3, ctvP37_3, ctvP38, ctvP39,
            ctvP40, ctvP41, ctvP42, ctvP43, ctvP39_1, ctvP40_1, ctvP41_1, ctvP42_1, ctvP43_1,
            ctvP44, ctvP45, ctvP46, ctvP47, ctvP48, ctvP49, ctvP50, ctvP51, ctvP52, ctvP53, ctvP54,
            ctvP55, ctvP57, ctvP56, ctvP58, ctvP51_1, ctvP59, ctvP60, ctvP61, ctvP62, ctvP63, ctvP64, ctvP65,
            ctvP66, ctvP67, ctvP68, ctvP69, ctvP70, ctvP71, ctvP72, ctvP67_1, ctvP68_1, ctvP69_1,
            ctvP70_1, ctvP71_1, ctvP72_1, ctvP73, ctvP74, ctvP75, ctvP76, ctvP77, ctvP78, ctvP74_1,
            ctvP75_1, ctvP76_1, ctvP77_1, ctvP78_1, ctvP79, ctvP80, ctvP81, ctvP82, ctvP90_alcohol,
            ctvP91_alcohol, ctvP92_alcohol, ctvP83, ctvP90_tabaco, ctvP91_tabaco, ctvP92_tabaco,
            ctvP84, ctvP90_marihuana, ctvP91_marihuana, ctvP92_marihuana, ctvP85, ctvP90_pastillas,
            ctvP91_pastillas, ctvP92_pastillas, ctvP86, ctvP90_solventes, ctvP91_solventes,
            ctvP92_solventes, ctvP87, ctvP90_cristal, ctvP91_cristal, ctvP92_cristal, ctvP88,
            ctvP90_cocaina, ctvP91_cocaina, ctvP92_cocaina, ctvP89, ctvP93_otroConsumo,
            ctvP90_otroConsumo, ctvP91_otroConsumo, ctvP92_otroConsumo, ctvP94, ctvP95;
    //endregion

    //region LinearLayout
    private LinearLayout llDatosGenerales, llDatosFamiliares, llDatosEscolares, llDatosLaborales, llFAEstado, llSalud, llDatosVictima;
    //endregion

    //region Button
    private Button btnDatosGenerales, btnDatosFamiliares, btnHistorialEscolar, btnHistorialLaboral, btnFAEstado, btnSalud, btnGuardarObservaciones;
    //endregion

    //region String
    String r1, r1_1, r1_2, r2, r3, r4, r5, r6, r7, r7_1, r8, r9, r10, r11, r12, r13, r14, r15, r16, r32_1, r17, r18,
            r19, r20, r21_1, r21, r22, r23, r24, r25, r26, r27, r28, r101, r102, r103, r104, r105, r29, r30, r31, r31_1,
            r31_2, r32, r33, r34, r35, r36, r37, r33_1, r34_1, r35_1, r36_1, r37_1, r33_2, r34_2, r35_2, r36_2, r37_2,
            r33_3, r34_3, r35_3, r36_3, r37_3, r38, r39, r40, r41, r42, r43, r39_1, r40_1, r41_1,
            r42_1, r43_1, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r57, r56, r58,
            r51_1, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r67_1, r68_1,
            r69_1, r70_1, r71_1, r72_1, r73, r74, r75, r76, r77, r78, r74_1, r75_1, r76_1, r77_1,
            r78_1, r79, r80, r81, r82, r90_alcohol, r91_alcohol, r92_alcohol, r83, r90_tabaco,
            r91_tabaco, r92_tabaco, r84, r90_marihuana, r91_marihuana, r92_marihuana, r85,
            r90_pastillas, r91_pastillas, r92_pastillas, r86, r90_solventes, r91_solventes,
            r92_solventes, r87, r90_cristal, r91_cristal, r92_cristal, r88, r90_cocaina,
            r91_cocaina, r92_cocaina, r89, r93_otroConsumo, r90_otroConsumo, r91_otroConsumo,
            r92_otroConsumo, r94, r95, r109, r110;

    String[] opers = {"Verificar", "Editar"};
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
        if(lista.isEmpty() == false) {
            sVerificationName.setSelection(lista.size() - 1);
        }
        //endregion

        //region setOnItemSelectedListener
        sVerificationName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                final ArrayList<datosGenerales> lista;
                lista = db.getDatosGenerales();

                final ArrayList<datosDomicilio> addresses;
                addresses = db.getDomicilios();

                final ArrayList<datosHabitantes> habitantes;
                habitantes = db.getHabitantes();

                final ArrayList<datosReferencias> referencias;
                referencias = db.getReferencias();

                final ArrayList<datosEscolarLaboral> historialEscolarLaboral;
                historialEscolarLaboral = db.getHistorialEscolarLaboral();

                final ArrayList<datosAbandonoEstado> listaAbandonoEstado;
                listaAbandonoEstado = db.getDatosAbandonoEstado();

                final ArrayList<datosSalud> listaSalud;
                listaSalud = db.getDatosSalud();

                final ArrayList<datosVictima> victima;
                victima = db.getVictima();

                //region Verification beginning
                tvP97 = (TextView) findViewById(R.id.tvP97);
                tvP97.setText(lista.get(pos).getFolio());
                //endregion

                //region Verification ending
                tvP96 = (TextView) findViewById(R.id.tvP96);
                tvP96.setText(lista.get(pos).getEntrevistador());

                tvP99 = (TextView) findViewById(R.id.tvP99);
                tvP99.setText(lista.get(pos).getObservacionesF());
                //endregion

                //region Identifies the verificacion elements
                tvP1 = (TextView) findViewById(R.id.tvP1);
                ctvP1 = (CheckedTextView) findViewById(R.id.ctvP1);
                tvO1 = (TextView)findViewById(R.id.tvO1);
                etP1 = (EditText)findViewById(R.id.etP1);
                tvP1_1 = (TextView) findViewById(R.id.tvP1_1);
                ctvP1_1 = (CheckedTextView) findViewById(R.id.ctvP1_1);
                tvO1_1 = (TextView)findViewById(R.id.tvO1_1);
                etP1_1 = (EditText)findViewById(R.id.etP1_1);
                tvP1_2 = (TextView) findViewById(R.id.tvP1_2);
                ctvP1_2 = (CheckedTextView) findViewById(R.id.ctvP1_2);
                tvO1_2 = (TextView)findViewById(R.id.tvO1_2);
                etP1_2 = (EditText)findViewById(R.id.etP1_2);
                tvP2 = (TextView) findViewById(R.id.tvP2);
                ctvP2 = (CheckedTextView) findViewById(R.id.ctvP2);
                tvO2 = (TextView)findViewById(R.id.tvO2);
                etP2 = (EditText)findViewById(R.id.etP2);
                tvP3 = (TextView) findViewById(R.id.tvP3);
                ctvP3 = (CheckedTextView) findViewById(R.id.ctvP3);
                tvO3 = (TextView)findViewById(R.id.tvO3);
                etP3 = (EditText)findViewById(R.id.etP3);
                tvP4 = (TextView) findViewById(R.id.tvP4);
                ctvP4 = (CheckedTextView) findViewById(R.id.ctvP4);
                tvO4 = (TextView)findViewById(R.id.tvO4);
                etP4 = (EditText)findViewById(R.id.etP4);
                tvP5 = (TextView) findViewById(R.id.tvP5);
                ctvP5 = (CheckedTextView) findViewById(R.id.ctvP5);
                tvO5 = (TextView)findViewById(R.id.tvO5);
                etP5 = (EditText)findViewById(R.id.etP5);
                tvP6 = (TextView) findViewById(R.id.tvP6);
                ctvP6 = (CheckedTextView) findViewById(R.id.ctvP6);
                tvO6 = (TextView)findViewById(R.id.tvO6);
                etP6 = (EditText)findViewById(R.id.etP6);

                //region 1. DATOS GENERALES domicilio
                tvP7 = (TextView) findViewById(R.id.tvP7);
                ctvP7 = (CheckedTextView) findViewById(R.id.ctvP7);
                tvO7 = (TextView)findViewById(R.id.tvO7);
                etP7 = (EditText)findViewById(R.id.etP7);
                tvP7_1 = (TextView) findViewById(R.id.tvP7_1);
                ctvP7_1 = (CheckedTextView) findViewById(R.id.ctvP7_1);
                tvO7_1 = (TextView)findViewById(R.id.tvO7_1);
                etP7_1 = (EditText)findViewById(R.id.etP7_1);
                tvP8 = (TextView) findViewById(R.id.tvP8);
                ctvP8 = (CheckedTextView) findViewById(R.id.ctvP8);
                tvO8 = (TextView)findViewById(R.id.tvO8);
                etP8 = (EditText)findViewById(R.id.etP8);
                tvP9 = (TextView) findViewById(R.id.tvP9);
                ctvP9 = (CheckedTextView) findViewById(R.id.ctvP9);
                tvO9 = (TextView)findViewById(R.id.tvO9);
                etP9 = (EditText)findViewById(R.id.etP9);
                tvP10 = (TextView) findViewById(R.id.tvP10);
                ctvP10 = (CheckedTextView) findViewById(R.id.ctvP10);
                tvO10 = (TextView)findViewById(R.id.tvO10);
                etP10 = (EditText)findViewById(R.id.etP10);
                tvP11 = (TextView) findViewById(R.id.tvP11);
                ctvP11 = (CheckedTextView) findViewById(R.id.ctvP11);
                tvO11 = (TextView)findViewById(R.id.tvO11);
                etP11 = (EditText)findViewById(R.id.etP11);
                tvP12 = (TextView) findViewById(R.id.tvP12);
                ctvP12 = (CheckedTextView) findViewById(R.id.ctvP12);
                tvO12 = (TextView)findViewById(R.id.tvO12);
                etP12 = (EditText)findViewById(R.id.etP12);
                tvP13 = (TextView) findViewById(R.id.tvP13);
                ctvP13 = (CheckedTextView) findViewById(R.id.ctvP13);
                tvO13 = (TextView)findViewById(R.id.tvO13);
                etP13 = (EditText)findViewById(R.id.etP13);
                tvP14 = (TextView) findViewById(R.id.tvP14);
                ctvP14 = (CheckedTextView) findViewById(R.id.ctvP14);
                tvO14 = (TextView)findViewById(R.id.tvO14);
                etP14 = (EditText)findViewById(R.id.etP14);
                tvP15 = (TextView) findViewById(R.id.tvP15);
                ctvP15 = (CheckedTextView) findViewById(R.id.ctvP15);
                tvO15 = (TextView)findViewById(R.id.tvO15);
                etP15 = (EditText)findViewById(R.id.etP15);
                tvP16 = (TextView) findViewById(R.id.tvP16);
                ctvP16 = (CheckedTextView) findViewById(R.id.ctvP16);
                tvO16 = (TextView)findViewById(R.id.tvO16);
                etP16 = (EditText)findViewById(R.id.etP16);
                tvP32_1 = (TextView) findViewById(R.id.tvP32_1);
                ctvP32_1 = (CheckedTextView) findViewById(R.id.ctvP32_1);
                tvO32_1 = (TextView)findViewById(R.id.tvO32_1);
                etP32_1 = (EditText)findViewById(R.id.etP32_1);
                tvP17 = (TextView) findViewById(R.id.tvP17);
                ctvP17 = (CheckedTextView) findViewById(R.id.ctvP17);
                tvO17 = (TextView)findViewById(R.id.tvO17);
                etP17 = (EditText)findViewById(R.id.etP17);
                tvP18 = (TextView) findViewById(R.id.tvP18);
                ctvP18 = (CheckedTextView) findViewById(R.id.ctvP18);
                tvO18 = (TextView)findViewById(R.id.tvO18);
                etP18 = (EditText)findViewById(R.id.etP18);
                tvP19 = (TextView) findViewById(R.id.tvP19);
                ctvP19 = (CheckedTextView) findViewById(R.id.ctvP19);
                tvO19 = (TextView)findViewById(R.id.tvO19);
                etP19 = (EditText)findViewById(R.id.etP19);
                tvP20 = (TextView) findViewById(R.id.tvP20);
                ctvP20 = (CheckedTextView) findViewById(R.id.ctvP20);
                tvO20 = (TextView)findViewById(R.id.tvO20);
                etP20 = (EditText)findViewById(R.id.etP20);
                tvP21_1 = (TextView) findViewById(R.id.tvP21_1);
                ctvP21_1 = (CheckedTextView) findViewById(R.id.ctvP21_1);
                tvO21_1 = (TextView)findViewById(R.id.tvO21_1);
                etP21_1 = (EditText)findViewById(R.id.etP21_1);
                tvP21 = (TextView) findViewById(R.id.tvP21);
                ctvP21 = (CheckedTextView) findViewById(R.id.ctvP21);
                tvO21 = (TextView)findViewById(R.id.tvO21);
                etP21 = (EditText)findViewById(R.id.etP21);
                tvP22 = (TextView) findViewById(R.id.tvP22);
                ctvP22 = (CheckedTextView) findViewById(R.id.ctvP22);
                tvO22 = (TextView)findViewById(R.id.tvO22);
                etP22 = (EditText)findViewById(R.id.etP22);
                tvP23 = (TextView) findViewById(R.id.tvP23);
                ctvP23 = (CheckedTextView) findViewById(R.id.ctvP23);
                tvO23 = (TextView)findViewById(R.id.tvO23);
                etP23 = (EditText)findViewById(R.id.etP23);
                tvP24 = (TextView) findViewById(R.id.tvP24);
                ctvP24 = (CheckedTextView) findViewById(R.id.ctvP24);
                tvO24 = (TextView)findViewById(R.id.tvO24);
                etP24 = (EditText)findViewById(R.id.etP24);
                tvP25 = (TextView) findViewById(R.id.tvP25);
                ctvP25 = (CheckedTextView) findViewById(R.id.ctvP25);
                tvO25 = (TextView)findViewById(R.id.tvO25);
                etP25 = (EditText)findViewById(R.id.etP25);
                tvP26 = (TextView) findViewById(R.id.tvP26);
                ctvP26 = (CheckedTextView) findViewById(R.id.ctvP26);
                tvO26 = (TextView)findViewById(R.id.tvO26);
                etP26 = (EditText)findViewById(R.id.etP26);
                tvP27 = (TextView) findViewById(R.id.tvP27);
                ctvP27 = (CheckedTextView) findViewById(R.id.ctvP27);
                tvO27 = (TextView)findViewById(R.id.tvO27);
                etP27 = (EditText)findViewById(R.id.etP27);
                tvP28 = (TextView) findViewById(R.id.tvP28);
                ctvP28 = (CheckedTextView) findViewById(R.id.ctvP28);
                tvO28 = (TextView)findViewById(R.id.tvO28);
                etP28 = (EditText)findViewById(R.id.etP28);
                tvP101 = (TextView) findViewById(R.id.tvP101);
                ctvP101 = (CheckedTextView) findViewById(R.id.ctvP101);
                tvO101 = (TextView)findViewById(R.id.tvO101);
                etP101 = (EditText)findViewById(R.id.etP101);
                tvP102 = (TextView) findViewById(R.id.tvP102);
                ctvP102 = (CheckedTextView) findViewById(R.id.ctvP102);
                tvO102 = (TextView)findViewById(R.id.tvO102);
                etP102 = (EditText)findViewById(R.id.etP102);
                tvP103 = (TextView) findViewById(R.id.tvP103);
                ctvP103 = (CheckedTextView) findViewById(R.id.ctvP103);
                tvO103 = (TextView)findViewById(R.id.tvO103);
                etP103 = (EditText)findViewById(R.id.etP103);
                tvP104 = (TextView) findViewById(R.id.tvP104);
                ctvP104 = (CheckedTextView) findViewById(R.id.ctvP104);
                tvO104 = (TextView)findViewById(R.id.tvO104);
                etP104 = (EditText)findViewById(R.id.etP104);
                tvP105 = (TextView) findViewById(R.id.tvP105);
                ctvP105 = (CheckedTextView) findViewById(R.id.ctvP105);
                tvO105 = (TextView)findViewById(R.id.tvO105);
                etP105 = (EditText)findViewById(R.id.etP105);
                tvP29 = (TextView) findViewById(R.id.tvP29);
                ctvP29 = (CheckedTextView) findViewById(R.id.ctvP29);
                tvO29 = (TextView)findViewById(R.id.tvO29);
                etP29 = (EditText)findViewById(R.id.etP29);
                tvP30 = (TextView) findViewById(R.id.tvP30);
                ctvP30 = (CheckedTextView) findViewById(R.id.ctvP30);
                tvO30 = (TextView)findViewById(R.id.tvO30);
                etP30 = (EditText)findViewById(R.id.etP30);
                tvP31 = (TextView) findViewById(R.id.tvP31);
                ctvP31 = (CheckedTextView) findViewById(R.id.ctvP31);
                tvO31 = (TextView)findViewById(R.id.tvO31);
                etP31 = (EditText)findViewById(R.id.etP31);
                tvP31_1 = (TextView) findViewById(R.id.tvP31_1);
                ctvP31_1 = (CheckedTextView) findViewById(R.id.ctvP31_1);
                tvO31_1 = (TextView)findViewById(R.id.tvO31_1);
                etP31_1 = (EditText)findViewById(R.id.etP31_1);
                tvP31_2 = (TextView) findViewById(R.id.tvP31_2);
                ctvP31_2 = (CheckedTextView) findViewById(R.id.ctvP31_2);
                tvO31_2 = (TextView)findViewById(R.id.tvO31_2);
                etP31_2 = (EditText)findViewById(R.id.etP31_2);
                //endregion

                //region 2. DATOS FAMILIARES Y PERSONAS CON LAS QUE HABITA EL IMPUTADO
                tvP32 = (TextView) findViewById(R.id.tvP32);
                ctvP32 = (CheckedTextView) findViewById(R.id.ctvP32);
                tvO32 = (TextView)findViewById(R.id.tvO32);
                etP32 = (EditText)findViewById(R.id.etP32);

                persona1 = (TextView) findViewById(R.id.persona1);
                persona2 = (TextView) findViewById(R.id.persona2);
                persona3 = (TextView) findViewById(R.id.persona3);
                persona4 = (TextView) findViewById(R.id.persona4);

                tvP33 = (TextView) findViewById(R.id.tvP33);
                ctvP33 = (CheckedTextView) findViewById(R.id.ctvP33);
                tvO33 = (TextView)findViewById(R.id.tvO33);
                etP33 = (EditText)findViewById(R.id.etP33);
                tvP34 = (TextView) findViewById(R.id.tvP34);
                ctvP34 = (CheckedTextView) findViewById(R.id.ctvP34);
                tvO34 = (TextView)findViewById(R.id.tvO34);
                etP34 = (EditText)findViewById(R.id.etP34);
                tvP35 = (TextView) findViewById(R.id.tvP35);
                ctvP35 = (CheckedTextView) findViewById(R.id.ctvP35);
                tvO35 = (TextView)findViewById(R.id.tvO35);
                etP35 = (EditText)findViewById(R.id.etP35);
                tvP36 = (TextView) findViewById(R.id.tvP36);
                ctvP36 = (CheckedTextView) findViewById(R.id.ctvP36);
                tvO36 = (TextView)findViewById(R.id.tvO36);
                etP36 = (EditText)findViewById(R.id.etP36);
                tvP37 = (TextView) findViewById(R.id.tvP37);
                ctvP37 = (CheckedTextView) findViewById(R.id.ctvP37);
                tvO37 = (TextView)findViewById(R.id.tvO37);
                etP37 = (EditText)findViewById(R.id.etP37);
                tvP33_1 = (TextView) findViewById(R.id.tvP33_1);
                ctvP33_1 = (CheckedTextView) findViewById(R.id.ctvP33_1);
                tvO33_1 = (TextView)findViewById(R.id.tvO33_1);
                etP33_1 = (EditText)findViewById(R.id.etP33_1);
                tvP34_1 = (TextView) findViewById(R.id.tvP34_1);
                ctvP34_1 = (CheckedTextView) findViewById(R.id.ctvP34_1);
                tvO34_1 = (TextView)findViewById(R.id.tvO34_1);
                etP34_1 = (EditText)findViewById(R.id.etP34_1);
                tvP35_1 = (TextView) findViewById(R.id.tvP35_1);
                ctvP35_1 = (CheckedTextView) findViewById(R.id.ctvP35_1);
                tvO35_1 = (TextView)findViewById(R.id.tvO35_1);
                etP35_1 = (EditText)findViewById(R.id.etP35_1);
                tvP36_1 = (TextView) findViewById(R.id.tvP36_1);
                ctvP36_1 = (CheckedTextView) findViewById(R.id.ctvP36_1);
                tvO36_1 = (TextView)findViewById(R.id.tvO36_1);
                etP36_1 = (EditText)findViewById(R.id.etP36_1);
                tvP37_1 = (TextView) findViewById(R.id.tvP37_1);
                ctvP37_1 = (CheckedTextView) findViewById(R.id.ctvP37_1);
                tvO37_1 = (TextView)findViewById(R.id.tvO37_1);
                etP37_1 = (EditText)findViewById(R.id.etP37_1);
                tvP33_2 = (TextView) findViewById(R.id.tvP33_2);
                ctvP33_2 = (CheckedTextView) findViewById(R.id.ctvP33_2);
                tvO33_2 = (TextView)findViewById(R.id.tvO33_2);
                etP33_2 = (EditText)findViewById(R.id.etP33_2);
                tvP34_2 = (TextView) findViewById(R.id.tvP34_2);
                ctvP34_2 = (CheckedTextView) findViewById(R.id.ctvP34_2);
                tvO34_2 = (TextView)findViewById(R.id.tvO34_2);
                etP34_2 = (EditText)findViewById(R.id.etP34_2);
                tvP35_2 = (TextView) findViewById(R.id.tvP35_2);
                ctvP35_2 = (CheckedTextView) findViewById(R.id.ctvP35_2);
                tvO35_2 = (TextView)findViewById(R.id.tvO35_2);
                etP35_2 = (EditText)findViewById(R.id.etP35_2);
                tvP36_2 = (TextView) findViewById(R.id.tvP36_2);
                ctvP36_2 = (CheckedTextView) findViewById(R.id.ctvP36_2);
                tvO36_2 = (TextView)findViewById(R.id.tvO36_2);
                etP36_2 = (EditText)findViewById(R.id.etP36_2);
                tvP37_2 = (TextView) findViewById(R.id.tvP37_2);
                ctvP37_2 = (CheckedTextView) findViewById(R.id.ctvP37_2);
                tvO37_2 = (TextView)findViewById(R.id.tvO37_2);
                etP37_2 = (EditText)findViewById(R.id.etP37_2);
                tvP33_3 = (TextView) findViewById(R.id.tvP33_3);
                ctvP33_3 = (CheckedTextView) findViewById(R.id.ctvP33_3);
                tvO33_3 = (TextView)findViewById(R.id.tvO33_3);
                etP33_3 = (EditText)findViewById(R.id.etP33_3);
                tvP34_3 = (TextView) findViewById(R.id.tvP34_3);
                ctvP34_3 = (CheckedTextView) findViewById(R.id.ctvP34_3);
                tvO34_3 = (TextView)findViewById(R.id.tvO34_3);
                etP34_3 = (EditText)findViewById(R.id.etP34_3);
                tvP35_3 = (TextView) findViewById(R.id.tvP35_3);
                ctvP35_3 = (CheckedTextView) findViewById(R.id.ctvP35_3);
                tvO35_3 = (TextView)findViewById(R.id.tvO35_3);
                etP35_3 = (EditText)findViewById(R.id.etP35_3);
                tvP36_3 = (TextView) findViewById(R.id.tvP36_3);
                ctvP36_3 = (CheckedTextView) findViewById(R.id.ctvP36_3);
                tvO36_3 = (TextView)findViewById(R.id.tvO36_3);
                etP36_3 = (EditText)findViewById(R.id.etP36_3);
                tvP37_3 = (TextView) findViewById(R.id.tvP37_3);
                ctvP37_3 = (CheckedTextView) findViewById(R.id.ctvP37_3);
                tvO37_3 = (TextView)findViewById(R.id.tvO37_3);
                etP37_3 = (EditText)findViewById(R.id.etP37_3);
                tvP38 = (TextView) findViewById(R.id.tvP38);
                ctvP38 = (CheckedTextView) findViewById(R.id.ctvP38);
                tvO38 = (TextView)findViewById(R.id.tvO38);
                etP38 = (EditText)findViewById(R.id.etP38);
                //endregion

                //region Referencias
                tvP39 = (TextView) findViewById(R.id.tvP39);
                ctvP39 = (CheckedTextView) findViewById(R.id.ctvP39);
                tvO39 = (TextView)findViewById(R.id.tvO39);
                etP39 = (EditText)findViewById(R.id.etP39);
                tvP40 = (TextView) findViewById(R.id.tvP40);
                ctvP40 = (CheckedTextView) findViewById(R.id.ctvP40);
                tvO40 = (TextView)findViewById(R.id.tvO40);
                etP40 = (EditText)findViewById(R.id.etP40);
                tvP41 = (TextView) findViewById(R.id.tvP41);
                ctvP41 = (CheckedTextView) findViewById(R.id.ctvP41);
                tvO41 = (TextView)findViewById(R.id.tvO41);
                etP41 = (EditText)findViewById(R.id.etP41);
                tvP42 = (TextView) findViewById(R.id.tvP42);
                ctvP42 = (CheckedTextView) findViewById(R.id.ctvP42);
                tvO42 = (TextView)findViewById(R.id.tvO42);
                etP42 = (EditText)findViewById(R.id.etP42);
                tvP43 = (TextView) findViewById(R.id.tvP43);
                ctvP43 = (CheckedTextView) findViewById(R.id.ctvP43);
                tvO43 = (TextView)findViewById(R.id.tvO43);
                etP43 = (EditText)findViewById(R.id.etP43);
                tvP39_1 = (TextView) findViewById(R.id.tvP39_1);
                ctvP39_1 = (CheckedTextView) findViewById(R.id.ctvP39_1);
                tvO39_1 = (TextView)findViewById(R.id.tvO39_1);
                etP39_1 = (EditText)findViewById(R.id.etP39_1);
                tvP40_1 = (TextView) findViewById(R.id.tvP40_1);
                ctvP40_1 = (CheckedTextView) findViewById(R.id.ctvP40_1);
                tvO40_1 = (TextView)findViewById(R.id.tvO40_1);
                etP40_1 = (EditText)findViewById(R.id.etP40_1);
                tvP41_1 = (TextView) findViewById(R.id.tvP41_1);
                ctvP41_1 = (CheckedTextView) findViewById(R.id.ctvP41_1);
                tvO41_1 = (TextView)findViewById(R.id.tvO41_1);
                etP41_1 = (EditText)findViewById(R.id.etP41_1);
                tvP42_1 = (TextView) findViewById(R.id.tvP42_1);
                ctvP42_1 = (CheckedTextView) findViewById(R.id.ctvP42_1);
                tvO42_1 = (TextView)findViewById(R.id.tvO42_1);
                etP42_1 = (EditText)findViewById(R.id.etP42_1);
                tvP43_1 = (TextView) findViewById(R.id.tvP43_1);
                ctvP43_1 = (CheckedTextView) findViewById(R.id.ctvP43_1);
                tvO43_1 = (TextView)findViewById(R.id.tvO43_1);
                etP43_1 = (EditText)findViewById(R.id.etP43_1);
                tvP44 = (TextView) findViewById(R.id.tvP44);
                ctvP44 = (CheckedTextView) findViewById(R.id.ctvP44);
                tvO44 = (TextView)findViewById(R.id.tvO44);
                etP44 = (EditText)findViewById(R.id.etP44);
                tvP45 = (TextView) findViewById(R.id.tvP45);
                ctvP45 = (CheckedTextView) findViewById(R.id.ctvP45);
                tvO45 = (TextView)findViewById(R.id.tvO45);
                etP45 = (EditText)findViewById(R.id.etP45);
                tvP46 = (TextView) findViewById(R.id.tvP46);
                ctvP46 = (CheckedTextView) findViewById(R.id.ctvP46);
                tvO46 = (TextView)findViewById(R.id.tvO46);
                etP46 = (EditText)findViewById(R.id.etP46);
                tvP47 = (TextView) findViewById(R.id.tvP47);
                ctvP47 = (CheckedTextView) findViewById(R.id.ctvP47);
                tvO47 = (TextView)findViewById(R.id.tvO47);
                etP47 = (EditText)findViewById(R.id.etP47);
                //endregion

                //region 3 y 4 HISTORIAL ESCOLAR Y LABORAL OCUPACIONAL
                tvP48 = (TextView) findViewById(R.id.tvP48);
                ctvP48 = (CheckedTextView) findViewById(R.id.ctvP48);
                tvO48 = (TextView)findViewById(R.id.tvO48);
                etP48 = (EditText)findViewById(R.id.etP48);
                tvP49 = (TextView) findViewById(R.id.tvP49);
                ctvP49 = (CheckedTextView) findViewById(R.id.ctvP49);
                tvO49 = (TextView)findViewById(R.id.tvO49);
                etP49 = (EditText)findViewById(R.id.etP49);
                tvP50 = (TextView) findViewById(R.id.tvP50);
                ctvP50 = (CheckedTextView) findViewById(R.id.ctvP50);
                tvO50 = (TextView)findViewById(R.id.tvO50);
                etP50 = (EditText)findViewById(R.id.etP50);
                tvP51 = (TextView) findViewById(R.id.tvP51);
                ctvP51 = (CheckedTextView) findViewById(R.id.ctvP51);
                tvO51 = (TextView)findViewById(R.id.tvO51);
                etP51 = (EditText)findViewById(R.id.etP51);
                tvP52 = (TextView) findViewById(R.id.tvP52);
                ctvP52 = (CheckedTextView) findViewById(R.id.ctvP52);
                tvO52 = (TextView)findViewById(R.id.tvO52);
                etP52 = (EditText)findViewById(R.id.etP52);
                tvP53 = (TextView) findViewById(R.id.tvP53);
                ctvP53 = (CheckedTextView) findViewById(R.id.ctvP53);
                tvO53 = (TextView)findViewById(R.id.tvO53);
                etP53 = (EditText)findViewById(R.id.etP53);
                tvP54 = (TextView) findViewById(R.id.tvP54);
                ctvP54 = (CheckedTextView) findViewById(R.id.ctvP54);
                tvO54 = (TextView)findViewById(R.id.tvO54);
                etP54 = (EditText)findViewById(R.id.etP54);
                tvP55 = (TextView) findViewById(R.id.tvP55);
                ctvP55 = (CheckedTextView) findViewById(R.id.ctvP55);
                tvO55 = (TextView)findViewById(R.id.tvO55);
                etP55 = (EditText)findViewById(R.id.etP55);
                tvP57 = (TextView) findViewById(R.id.tvP57);
                ctvP57 = (CheckedTextView) findViewById(R.id.ctvP57);
                tvO57 = (TextView)findViewById(R.id.tvO57);
                etP57 = (EditText)findViewById(R.id.etP57);
                tvP56 = (TextView) findViewById(R.id.tvP56);
                ctvP56 = (CheckedTextView) findViewById(R.id.ctvP56);
                tvO56 = (TextView)findViewById(R.id.tvO56);
                etP56 = (EditText)findViewById(R.id.etP56);
                tvP58 = (TextView) findViewById(R.id.tvP58);
                ctvP58 = (CheckedTextView) findViewById(R.id.ctvP58);
                tvO58 = (TextView)findViewById(R.id.tvO58);
                etP58 = (EditText)findViewById(R.id.etP58);
                tvP51_1 = (TextView) findViewById(R.id.tvP51_1);
                ctvP51_1 = (CheckedTextView) findViewById(R.id.ctvP51_1);
                tvO51_1 = (TextView)findViewById(R.id.tvO51_1);
                etP51_1 = (EditText)findViewById(R.id.etP51_1);
                tvP59 = (TextView) findViewById(R.id.tvP59);
                ctvP59 = (CheckedTextView) findViewById(R.id.ctvP59);
                tvO59 = (TextView)findViewById(R.id.tvO59);
                etP59 = (EditText)findViewById(R.id.etP59);
                //endregion

                //region 5. INFORMACIÓN DE FACILIDADES PARA ABANDONAR EL ESTADO
                tvP60 = (TextView) findViewById(R.id.tvP60);
                ctvP60 = (CheckedTextView) findViewById(R.id.ctvP60);
                tvO60 = (TextView)findViewById(R.id.tvO60);
                etP60 = (EditText)findViewById(R.id.etP60);
                tvP61 = (TextView) findViewById(R.id.tvP61);
                ctvP61 = (CheckedTextView) findViewById(R.id.ctvP61);
                tvO61 = (TextView)findViewById(R.id.tvO61);
                etP61 = (EditText)findViewById(R.id.etP61);
                tvP62 = (TextView) findViewById(R.id.tvP62);
                ctvP62 = (CheckedTextView) findViewById(R.id.ctvP62);
                tvO62 = (TextView)findViewById(R.id.tvO62);
                etP62 = (EditText)findViewById(R.id.etP62);
                tvP63 = (TextView) findViewById(R.id.tvP63);
                ctvP63 = (CheckedTextView) findViewById(R.id.ctvP63);
                tvO63 = (TextView)findViewById(R.id.tvO63);
                etP63 = (EditText)findViewById(R.id.etP63);
                tvP64 = (TextView) findViewById(R.id.tvP64);
                ctvP64 = (CheckedTextView) findViewById(R.id.ctvP64);
                tvO64 = (TextView)findViewById(R.id.tvO64);
                etP64 = (EditText)findViewById(R.id.etP64);
                tvP65 = (TextView) findViewById(R.id.tvP65);
                ctvP65 = (CheckedTextView) findViewById(R.id.ctvP65);
                tvO65 = (TextView)findViewById(R.id.tvO65);
                etP65 = (EditText)findViewById(R.id.etP65);
                tvP66 = (TextView) findViewById(R.id.tvP66);
                ctvP66 = (CheckedTextView) findViewById(R.id.ctvP66);
                tvO66 = (TextView)findViewById(R.id.tvO66);
                etP66 = (EditText)findViewById(R.id.etP66);

                personaE1 = (TextView) findViewById(R.id.personaE1);
                personaE2 = (TextView) findViewById(R.id.personaE2);

                tvP67 = (TextView) findViewById(R.id.tvP67);
                ctvP67 = (CheckedTextView) findViewById(R.id.ctvP67);
                tvO67 = (TextView)findViewById(R.id.tvO67);
                etP67 = (EditText)findViewById(R.id.etP67);
                tvP68 = (TextView) findViewById(R.id.tvP68);
                ctvP68 = (CheckedTextView) findViewById(R.id.ctvP68);
                tvO68 = (TextView)findViewById(R.id.tvO68);
                etP68 = (EditText)findViewById(R.id.etP68);
                tvP69 = (TextView) findViewById(R.id.tvP69);
                ctvP69 = (CheckedTextView) findViewById(R.id.ctvP69);
                tvO69 = (TextView)findViewById(R.id.tvO69);
                etP69 = (EditText)findViewById(R.id.etP69);
                tvP70 = (TextView) findViewById(R.id.tvP70);
                ctvP70 = (CheckedTextView) findViewById(R.id.ctvP70);
                tvO70 = (TextView)findViewById(R.id.tvO70);
                etP70 = (EditText)findViewById(R.id.etP70);
                tvP71 = (TextView) findViewById(R.id.tvP71);
                ctvP71 = (CheckedTextView) findViewById(R.id.ctvP71);
                tvO71 = (TextView)findViewById(R.id.tvO71);
                etP71 = (EditText)findViewById(R.id.etP71);
                tvP72 = (TextView) findViewById(R.id.tvP72);
                ctvP72 = (CheckedTextView) findViewById(R.id.ctvP72);
                tvO72 = (TextView)findViewById(R.id.tvO72);
                etP72 = (EditText)findViewById(R.id.etP72);
                tvP67_1 = (TextView) findViewById(R.id.tvP67_1);
                ctvP67_1 = (CheckedTextView) findViewById(R.id.ctvP67_1);
                tvO67_1 = (TextView)findViewById(R.id.tvO67_1);
                etP67_1 = (EditText)findViewById(R.id.etP67_1);
                tvP68_1 = (TextView) findViewById(R.id.tvP68_1);
                ctvP68_1 = (CheckedTextView) findViewById(R.id.ctvP68_1);
                tvO68_1 = (TextView)findViewById(R.id.tvO68_1);
                etP68_1 = (EditText)findViewById(R.id.etP68_1);
                tvP69_1 = (TextView) findViewById(R.id.tvP69_1);
                ctvP69_1 = (CheckedTextView) findViewById(R.id.ctvP69_1);
                tvO69_1 = (TextView)findViewById(R.id.tvO69_1);
                etP69_1 = (EditText)findViewById(R.id.etP69_1);
                tvP70_1 = (TextView) findViewById(R.id.tvP70_1);
                ctvP70_1 = (CheckedTextView) findViewById(R.id.ctvP70_1);
                tvO70_1 = (TextView)findViewById(R.id.tvO70_1);
                etP70_1 = (EditText)findViewById(R.id.etP70_1);
                tvP71_1 = (TextView) findViewById(R.id.tvP71_1);
                ctvP71_1 = (CheckedTextView) findViewById(R.id.ctvP71_1);
                tvO71_1 = (TextView)findViewById(R.id.tvO71_1);
                etP71_1 = (EditText)findViewById(R.id.etP71_1);
                tvP72_1 = (TextView) findViewById(R.id.tvP72_1);
                ctvP72_1 = (CheckedTextView) findViewById(R.id.ctvP72_1);
                tvO72_1 = (TextView)findViewById(R.id.tvO72_1);
                etP72_1 = (EditText)findViewById(R.id.etP72_1);
                tvP73 = (TextView) findViewById(R.id.tvP73);
                ctvP73 = (CheckedTextView) findViewById(R.id.ctvP73);
                tvO73 = (TextView)findViewById(R.id.tvO73);
                etP73 = (EditText)findViewById(R.id.etP73);

                personaEstado1 = (TextView) findViewById(R.id.personaEstado1);
                personaEstado2 = (TextView) findViewById(R.id.personaEstado2);

                tvP74 = (TextView) findViewById(R.id.tvP74);
                ctvP74 = (CheckedTextView) findViewById(R.id.ctvP74);
                tvO74 = (TextView)findViewById(R.id.tvO74);
                etP74 = (EditText)findViewById(R.id.etP74);
                tvP75 = (TextView) findViewById(R.id.tvP75);
                ctvP75 = (CheckedTextView) findViewById(R.id.ctvP75);
                tvO75 = (TextView)findViewById(R.id.tvO75);
                etP75 = (EditText)findViewById(R.id.etP75);
                tvP76 = (TextView) findViewById(R.id.tvP76);
                ctvP76 = (CheckedTextView) findViewById(R.id.ctvP76);
                tvO76 = (TextView)findViewById(R.id.tvO76);
                etP76 = (EditText)findViewById(R.id.etP76);
                tvP77 = (TextView) findViewById(R.id.tvP77);
                ctvP77 = (CheckedTextView) findViewById(R.id.ctvP77);
                tvO77 = (TextView)findViewById(R.id.tvO77);
                etP77 = (EditText)findViewById(R.id.etP77);
                tvP78 = (TextView) findViewById(R.id.tvP78);
                ctvP78 = (CheckedTextView) findViewById(R.id.ctvP78);
                tvO78 = (TextView)findViewById(R.id.tvO78);
                etP78 = (EditText)findViewById(R.id.etP78);
                tvP74_1 = (TextView) findViewById(R.id.tvP74_1);
                ctvP74_1 = (CheckedTextView) findViewById(R.id.ctvP74_1);
                tvO74_1 = (TextView)findViewById(R.id.tvO74_1);
                etP74_1 = (EditText)findViewById(R.id.etP74_1);
                tvP75_1 = (TextView) findViewById(R.id.tvP75_1);
                ctvP75_1 = (CheckedTextView) findViewById(R.id.ctvP75_1);
                tvO75_1 = (TextView)findViewById(R.id.tvO75_1);
                etP75_1 = (EditText)findViewById(R.id.etP75_1);
                tvP76_1 = (TextView) findViewById(R.id.tvP76_1);
                ctvP76_1 = (CheckedTextView) findViewById(R.id.ctvP76_1);
                tvO76_1 = (TextView)findViewById(R.id.tvO76_1);
                etP76_1 = (EditText)findViewById(R.id.etP76_1);
                tvP77_1 = (TextView) findViewById(R.id.tvP77_1);
                ctvP77_1 = (CheckedTextView) findViewById(R.id.ctvP77_1);
                tvO77_1 = (TextView)findViewById(R.id.tvO77_1);
                etP77_1 = (EditText)findViewById(R.id.etP77_1);
                tvP78_1 = (TextView) findViewById(R.id.tvP78_1);
                ctvP78_1 = (CheckedTextView) findViewById(R.id.ctvP78_1);
                tvO78_1 = (TextView)findViewById(R.id.tvO78_1);
                etP78_1 = (EditText)findViewById(R.id.etP78_1);
                tvP79 = (TextView) findViewById(R.id.tvP79);
                ctvP79 = (CheckedTextView) findViewById(R.id.ctvP79);
                tvO79 = (TextView)findViewById(R.id.tvO79);
                etP79 = (EditText)findViewById(R.id.etP79);
                tvP80 = (TextView) findViewById(R.id.tvP80);
                ctvP80 = (CheckedTextView) findViewById(R.id.ctvP80);
                tvO80 = (TextView)findViewById(R.id.tvO80);
                etP80 = (EditText)findViewById(R.id.etP80);
                tvP81 = (TextView) findViewById(R.id.tvP81);
                ctvP81 = (CheckedTextView) findViewById(R.id.ctvP81);
                tvO81 = (TextView)findViewById(R.id.tvO81);
                etP81 = (EditText)findViewById(R.id.etP81);
                //endregion

                //region 6. SALUD Y CONDICIÓN FÍSICA
                tvP82 = (TextView) findViewById(R.id.tvP82);
                ctvP82 = (CheckedTextView) findViewById(R.id.ctvP82);
                tvO82 = (TextView)findViewById(R.id.tvO82);
                etP82 = (EditText)findViewById(R.id.etP82);
                tvP90_alcohol = (TextView) findViewById(R.id.tvP90_alcohol);
                ctvP90_alcohol = (CheckedTextView) findViewById(R.id.ctvP90_alcohol);
                tvO90_alcohol = (TextView)findViewById(R.id.tvO90_alcohol);
                etP90_alcohol = (EditText)findViewById(R.id.etP90_alcohol);
                tvP91_alcohol = (TextView) findViewById(R.id.tvP91_alcohol);
                ctvP91_alcohol = (CheckedTextView) findViewById(R.id.ctvP91_alcohol);
                tvO91_alcohol = (TextView)findViewById(R.id.tvO91_alcohol);
                etP91_alcohol = (EditText)findViewById(R.id.etP91_alcohol);
                tvP92_alcohol = (TextView) findViewById(R.id.tvP92_alcohol);
                ctvP92_alcohol = (CheckedTextView) findViewById(R.id.ctvP92_alcohol);
                tvO92_alcohol = (TextView)findViewById(R.id.tvO92_alcohol);
                etP92_alcohol = (EditText)findViewById(R.id.etP92_alcohol);
                tvP83 = (TextView) findViewById(R.id.tvP83);
                ctvP83 = (CheckedTextView) findViewById(R.id.ctvP83);
                tvO83 = (TextView)findViewById(R.id.tvO83);
                etP83 = (EditText)findViewById(R.id.etP83);
                tvP90_tabaco = (TextView) findViewById(R.id.tvP90_tabaco);
                ctvP90_tabaco = (CheckedTextView) findViewById(R.id.ctvP90_tabaco);
                tvO90_tabaco = (TextView)findViewById(R.id.tvO90_tabaco);
                etP90_tabaco = (EditText)findViewById(R.id.etP90_tabaco);
                tvP91_tabaco = (TextView) findViewById(R.id.tvP91_tabaco);
                ctvP91_tabaco = (CheckedTextView) findViewById(R.id.ctvP91_tabaco);
                tvO91_tabaco = (TextView)findViewById(R.id.tvO91_tabaco);
                etP91_tabaco = (EditText)findViewById(R.id.etP91_tabaco);
                tvP92_tabaco = (TextView) findViewById(R.id.tvP92_tabaco);
                ctvP92_tabaco = (CheckedTextView) findViewById(R.id.ctvP92_tabaco);
                tvO92_tabaco = (TextView)findViewById(R.id.tvO92_tabaco);
                etP92_tabaco = (EditText)findViewById(R.id.etP92_tabaco);
                tvP84 = (TextView) findViewById(R.id.tvP84);
                ctvP84 = (CheckedTextView) findViewById(R.id.ctvP84);
                tvO84 = (TextView)findViewById(R.id.tvO84);
                etP84 = (EditText)findViewById(R.id.etP84);
                tvP90_marihuana = (TextView) findViewById(R.id.tvP90_marihuana);
                ctvP90_marihuana = (CheckedTextView) findViewById(R.id.ctvP90_marihuana);
                tvO90_marihuana = (TextView)findViewById(R.id.tvO90_marihuana);
                etP90_marihuana = (EditText)findViewById(R.id.etP90_marihuana);
                tvP91_marihuana = (TextView) findViewById(R.id.tvP91_marihuana);
                ctvP91_marihuana = (CheckedTextView) findViewById(R.id.ctvP91_marihuana);
                tvO91_marihuana = (TextView)findViewById(R.id.tvO91_marihuana);
                etP91_marihuana = (EditText)findViewById(R.id.etP91_marihuana);
                tvP92_marihuana = (TextView) findViewById(R.id.tvP92_marihuana);
                ctvP92_marihuana = (CheckedTextView) findViewById(R.id.ctvP92_marihuana);
                tvO92_marihuana = (TextView)findViewById(R.id.tvO92_marihuana);
                etP92_marihuana = (EditText)findViewById(R.id.etP92_marihuana);
                tvP85 = (TextView) findViewById(R.id.tvP85);
                ctvP85 = (CheckedTextView) findViewById(R.id.ctvP85);
                tvO85 = (TextView)findViewById(R.id.tvO85);
                etP85 = (EditText)findViewById(R.id.etP85);
                tvP90_pastillas = (TextView) findViewById(R.id.tvP90_pastillas);
                ctvP90_pastillas = (CheckedTextView) findViewById(R.id.ctvP90_pastillas);
                tvO90_pastillas = (TextView)findViewById(R.id.tvO90_pastillas);
                etP90_pastillas = (EditText)findViewById(R.id.etP90_pastillas);
                tvP91_pastillas = (TextView) findViewById(R.id.tvP91_pastillas);
                ctvP91_pastillas = (CheckedTextView) findViewById(R.id.ctvP91_pastillas);
                tvO91_pastillas = (TextView)findViewById(R.id.tvO91_pastillas);
                etP91_pastillas = (EditText)findViewById(R.id.etP91_pastillas);
                tvP92_pastillas = (TextView) findViewById(R.id.tvP92_pastillas);
                ctvP92_pastillas = (CheckedTextView) findViewById(R.id.ctvP92_pastillas);
                tvO92_pastillas = (TextView)findViewById(R.id.tvO92_pastillas);
                etP92_pastillas = (EditText)findViewById(R.id.etP92_pastillas);
                tvP86 = (TextView) findViewById(R.id.tvP86);
                ctvP86 = (CheckedTextView) findViewById(R.id.ctvP86);
                tvO86 = (TextView)findViewById(R.id.tvO86);
                etP86 = (EditText)findViewById(R.id.etP86);
                tvP90_solventes = (TextView) findViewById(R.id.tvP90_solventes);
                ctvP90_solventes = (CheckedTextView) findViewById(R.id.ctvP90_solventes);
                tvO90_solventes = (TextView)findViewById(R.id.tvO90_solventes);
                etP90_solventes = (EditText)findViewById(R.id.etP90_solventes);
                tvP91_solventes = (TextView) findViewById(R.id.tvP91_solventes);
                ctvP91_solventes = (CheckedTextView) findViewById(R.id.ctvP91_solventes);
                tvO91_solventes = (TextView)findViewById(R.id.tvO91_solventes);
                etP91_solventes = (EditText)findViewById(R.id.etP91_solventes);
                tvP92_solventes = (TextView) findViewById(R.id.tvP92_solventes);
                ctvP92_solventes = (CheckedTextView) findViewById(R.id.ctvP92_solventes);
                tvO92_solventes = (TextView)findViewById(R.id.tvO92_solventes);
                etP92_solventes = (EditText)findViewById(R.id.etP92_solventes);
                tvP87 = (TextView) findViewById(R.id.tvP87);
                ctvP87 = (CheckedTextView) findViewById(R.id.ctvP87);
                tvO87 = (TextView)findViewById(R.id.tvO87);
                etP87 = (EditText)findViewById(R.id.etP87);
                tvP90_cristal = (TextView) findViewById(R.id.tvP90_cristal);
                ctvP90_cristal = (CheckedTextView) findViewById(R.id.ctvP90_cristal);
                tvO90_cristal = (TextView)findViewById(R.id.tvO90_cristal);
                etP90_cristal = (EditText)findViewById(R.id.etP90_cristal);
                tvP91_cristal = (TextView) findViewById(R.id.tvP91_cristal);
                ctvP91_cristal = (CheckedTextView) findViewById(R.id.ctvP91_cristal);
                tvO91_cristal = (TextView)findViewById(R.id.tvO91_cristal);
                etP91_cristal = (EditText)findViewById(R.id.etP91_cristal);
                tvP92_cristal = (TextView) findViewById(R.id.tvP92_cristal);
                ctvP92_cristal = (CheckedTextView) findViewById(R.id.ctvP92_cristal);
                tvO92_cristal = (TextView)findViewById(R.id.tvO92_cristal);
                etP92_cristal = (EditText)findViewById(R.id.etP92_cristal);
                tvP88 = (TextView) findViewById(R.id.tvP88);
                ctvP88 = (CheckedTextView) findViewById(R.id.ctvP88);
                tvO88 = (TextView)findViewById(R.id.tvO88);
                etP88 = (EditText)findViewById(R.id.etP88);
                tvP90_cocaina = (TextView) findViewById(R.id.tvP90_cocaina);
                ctvP90_cocaina = (CheckedTextView) findViewById(R.id.ctvP90_cocaina);
                tvO90_cocaina = (TextView)findViewById(R.id.tvO90_cocaina);
                etP90_cocaina = (EditText)findViewById(R.id.etP90_cocaina);
                tvP91_cocaina = (TextView) findViewById(R.id.tvP91_cocaina);
                ctvP91_cocaina = (CheckedTextView) findViewById(R.id.ctvP91_cocaina);
                tvO91_cocaina = (TextView)findViewById(R.id.tvO91_cocaina);
                etP91_cocaina = (EditText)findViewById(R.id.etP91_cocaina);
                tvP92_cocaina = (TextView) findViewById(R.id.tvP92_cocaina);
                ctvP92_cocaina = (CheckedTextView) findViewById(R.id.ctvP92_cocaina);
                tvO92_cocaina = (TextView)findViewById(R.id.tvO92_cocaina);
                etP92_cocaina = (EditText)findViewById(R.id.etP92_cocaina);
                tvP89 = (TextView) findViewById(R.id.tvP89);
                ctvP89 = (CheckedTextView) findViewById(R.id.ctvP89);
                tvO89 = (TextView)findViewById(R.id.tvO89);
                etP89 = (EditText)findViewById(R.id.etP89);
                tvP93_otroConsumo = (TextView) findViewById(R.id.tvP93_otroConsumo);
                ctvP93_otroConsumo = (CheckedTextView) findViewById(R.id.ctvP93_otroConsumo);
                tvO93_otroConsumo = (TextView)findViewById(R.id.tvO93_otroConsumo);
                etP93_otroConsumo = (EditText)findViewById(R.id.etP93_otroConsumo);
                tvP90_otroConsumo = (TextView) findViewById(R.id.tvP90_otroConsumo);
                ctvP90_otroConsumo = (CheckedTextView) findViewById(R.id.ctvP90_otroConsumo);
                tvO90_otroConsumo = (TextView)findViewById(R.id.tvO90_otroConsumo);
                etP90_otroConsumo = (EditText)findViewById(R.id.etP90_otroConsumo);
                tvP91_otroConsumo = (TextView) findViewById(R.id.tvP91_otroConsumo);
                ctvP91_otroConsumo = (CheckedTextView) findViewById(R.id.ctvP91_otroConsumo);
                tvO91_otroConsumo = (TextView)findViewById(R.id.tvO91_otroConsumo);
                etP91_otroConsumo = (EditText)findViewById(R.id.etP91_otroConsumo);
                tvP92_otroConsumo = (TextView) findViewById(R.id.tvP92_otroConsumo);
                ctvP92_otroConsumo = (CheckedTextView) findViewById(R.id.ctvP92_otroConsumo);
                tvO92_otroConsumo = (TextView)findViewById(R.id.tvO92_otroConsumo);
                etP92_otroConsumo = (EditText)findViewById(R.id.etP92_otroConsumo);
                tvP94 = (TextView) findViewById(R.id.tvP94);
                ctvP94 = (CheckedTextView) findViewById(R.id.ctvP94);
                tvO94 = (TextView)findViewById(R.id.tvO94);
                etP94 = (EditText)findViewById(R.id.etP94);
                tvP95 = (TextView) findViewById(R.id.tvP95);
                ctvP95 = (CheckedTextView) findViewById(R.id.ctvP95);
                tvO95 = (TextView)findViewById(R.id.tvO95);
                etP95 = (EditText)findViewById(R.id.etP95);
                //endregion
                llDatosVictima = (LinearLayout) findViewById(R.id.llDatosVictima);
                //endregion

                //region Initializes the verification elements
                //Resets interviewee name and relationship
                etP109.setText("");
                etP110.setText("");

                ctvP1.setText(lista.get(pos).getNombre());
                ctvP1.setChecked(true);
                ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO1.setVisibility(View.GONE);
                etP1.setVisibility(View.GONE);
                etP1.setText("");

                ctvP1_1.setText(lista.get(pos).getEntrevistado());
                ctvP1_1.setChecked(true);
                ctvP1_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO1_1.setVisibility(View.GONE);
                etP1_1.setVisibility(View.GONE);
                etP1_1.setText("");

                ctvP1_2.setText(lista.get(pos).getAntecedentePenal());
                ctvP1_2.setChecked(true);
                ctvP1_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO1_2.setVisibility(View.GONE);
                etP1_2.setVisibility(View.GONE);
                etP1_2.setText("");

                ctvP2.setText(lista.get(pos).getAlias());
                ctvP2.setChecked(true);
                ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO2.setVisibility(View.GONE);
                etP2.setVisibility(View.GONE);
                etP2.setText("");

                ctvP3.setText(lista.get(pos).getfEntrevista());
                ctvP3.setChecked(true);
                ctvP3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO3.setVisibility(View.GONE);
                etP3.setVisibility(View.GONE);
                etP3.setText("");

                ctvP4.setText(lista.get(pos).getEdad());
                ctvP4.setChecked(true);
                ctvP4.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO4.setVisibility(View.GONE);
                etP4.setVisibility(View.GONE);
                etP4.setText("");

                ctvP5.setText(lista.get(pos).getlNacimiento());
                ctvP5.setChecked(true);
                ctvP5.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO5.setVisibility(View.GONE);
                etP5.setVisibility(View.GONE);
                etP5.setText("");

                ctvP6.setText(lista.get(pos).getSexo());
                ctvP6.setChecked(true);
                ctvP6.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO6.setVisibility(View.GONE);
                etP6.setVisibility(View.GONE);
                etP6.setText("");

                ctvP7.setText(addresses.get(pos).getE7());
                ctvP7.setChecked(true);
                ctvP7.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO7.setVisibility(View.GONE);
                etP7.setVisibility(View.GONE);
                etP7.setText("");

                ctvP7_1.setText(addresses.get(pos).getE7_1());
                ctvP7_1.setChecked(true);
                ctvP7_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO7_1.setVisibility(View.GONE);
                etP7_1.setVisibility(View.GONE);
                etP7_1.setText("");

                ctvP8.setText(addresses.get(pos).getE8());
                ctvP8.setChecked(true);
                ctvP8.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO8.setVisibility(View.GONE);
                etP8.setVisibility(View.GONE);
                etP8.setText("");

                ctvP9.setText(addresses.get(pos).getE9());
                ctvP9.setChecked(true);
                ctvP9.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO9.setVisibility(View.GONE);
                etP9.setVisibility(View.GONE);
                etP9.setText("");

                ctvP10.setText(addresses.get(pos).getE10());
                ctvP10.setChecked(true);
                ctvP10.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO10.setVisibility(View.GONE);
                etP10.setVisibility(View.GONE);
                etP10.setText("");

                ctvP11.setText(addresses.get(pos).getE11());
                ctvP11.setChecked(true);
                ctvP11.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO11.setVisibility(View.GONE);
                etP11.setVisibility(View.GONE);
                etP11.setText("");

                ctvP12.setText(addresses.get(pos).getE12());
                ctvP12.setChecked(true);
                ctvP12.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO12.setVisibility(View.GONE);
                etP12.setVisibility(View.GONE);
                etP12.setText("");

                ctvP13.setText(addresses.get(pos).getE13());
                ctvP13.setChecked(true);
                ctvP13.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO13.setVisibility(View.GONE);
                etP13.setVisibility(View.GONE);
                etP13.setText("");

                ctvP14.setText(addresses.get(pos).getE14());
                ctvP14.setChecked(true);
                ctvP14.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO14.setVisibility(View.GONE);
                etP14.setVisibility(View.GONE);
                etP14.setText("");

                ctvP15.setText(addresses.get(pos).getE15());
                ctvP15.setChecked(true);
                ctvP15.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO15.setVisibility(View.GONE);
                etP15.setVisibility(View.GONE);
                etP15.setText("");

                ctvP16.setText(addresses.get(pos).getE16());
                ctvP16.setChecked(true);
                ctvP16.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO16.setVisibility(View.GONE);
                etP16.setVisibility(View.GONE);
                etP16.setText("");

                ctvP32_1.setText(addresses.get(pos).getE32_1());
                ctvP32_1.setChecked(true);
                ctvP32_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO32_1.setVisibility(View.GONE);
                etP32_1.setVisibility(View.GONE);
                etP32_1.setText("");

                ctvP17.setText(addresses.get(pos).getE17());
                ctvP17.setChecked(true);
                ctvP17.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO17.setVisibility(View.GONE);
                etP17.setVisibility(View.GONE);
                etP17.setText("");

                ctvP18.setText(addresses.get(pos).getE18());
                ctvP18.setChecked(true);
                ctvP18.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO18.setVisibility(View.GONE);
                etP18.setVisibility(View.GONE);
                etP18.setText("");

                ctvP19.setText(addresses.get(pos).getE19());
                ctvP19.setChecked(true);
                ctvP19.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO19.setVisibility(View.GONE);
                etP19.setVisibility(View.GONE);
                etP19.setText("");

                ctvP20.setText(addresses.get(pos).getE20());
                ctvP20.setChecked(true);
                ctvP20.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO20.setVisibility(View.GONE);
                etP20.setVisibility(View.GONE);
                etP20.setText("");

                //region Domicilio secundario
                ctvP21_1.setText(lista.get(pos).getTieneDomicilioS());
                ctvP21_1.setChecked(true);
                ctvP21_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO21_1.setVisibility(View.GONE);
                etP21_1.setVisibility(View.GONE);
                etP21_1.setText("");

                ctvP21.setText(addresses.get(pos).getE21());
                ctvP21.setChecked(true);
                ctvP21.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO21.setVisibility(View.GONE);
                etP21.setVisibility(View.GONE);
                etP21.setText("");

                ctvP22.setText(addresses.get(pos).getE22());
                ctvP22.setChecked(true);
                ctvP22.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO22.setVisibility(View.GONE);
                etP22.setVisibility(View.GONE);
                etP22.setText("");

                ctvP23.setText(addresses.get(pos).getE23());
                ctvP23.setChecked(true);
                ctvP23.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO23.setVisibility(View.GONE);
                etP23.setVisibility(View.GONE);
                etP23.setText("");

                ctvP24.setText(addresses.get(pos).getE24());
                ctvP24.setChecked(true);
                ctvP24.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO24.setVisibility(View.GONE);
                etP24.setVisibility(View.GONE);
                etP24.setText("");

                ctvP25.setText(addresses.get(pos).getE25());
                ctvP25.setChecked(true);
                ctvP25.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO25.setVisibility(View.GONE);
                etP25.setVisibility(View.GONE);
                etP25.setText("");

                ctvP26.setText(addresses.get(pos).getE26());
                ctvP26.setChecked(true);
                ctvP26.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO26.setVisibility(View.GONE);
                etP26.setVisibility(View.GONE);
                etP26.setText("");

                ctvP27.setText(addresses.get(pos).getE27());
                ctvP27.setChecked(true);
                ctvP27.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO27.setVisibility(View.GONE);
                etP27.setVisibility(View.GONE);
                etP27.setText("");

                ctvP28.setText(addresses.get(pos).getE28());
                ctvP28.setChecked(true);
                ctvP28.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO28.setVisibility(View.GONE);
                etP28.setVisibility(View.GONE);
                etP28.setText("");

                if(lista.get(pos).getTieneDomicilioS().equals("SI")) {
                    tvP21.setVisibility(View.VISIBLE);
                    ctvP21.setVisibility(View.VISIBLE);
                    tvP22.setVisibility(View.VISIBLE);
                    ctvP22.setVisibility(View.VISIBLE);
                    tvP23.setVisibility(View.VISIBLE);
                    ctvP23.setVisibility(View.VISIBLE);
                    tvP24.setVisibility(View.VISIBLE);
                    ctvP24.setVisibility(View.VISIBLE);
                    tvP25.setVisibility(View.VISIBLE);
                    ctvP25.setVisibility(View.VISIBLE);
                    tvP26.setVisibility(View.VISIBLE);
                    ctvP26.setVisibility(View.VISIBLE);
                    tvP27.setVisibility(View.VISIBLE);
                    ctvP27.setVisibility(View.VISIBLE);
                    tvP28.setVisibility(View.VISIBLE);
                    ctvP28.setVisibility(View.VISIBLE);
                }
                else {
                    tvP21.setVisibility(View.GONE);
                    ctvP21.setVisibility(View.GONE);
                    tvP22.setVisibility(View.GONE);
                    ctvP22.setVisibility(View.GONE);
                    tvP23.setVisibility(View.GONE);
                    ctvP23.setVisibility(View.GONE);
                    tvP24.setVisibility(View.GONE);
                    ctvP24.setVisibility(View.GONE);
                    tvP25.setVisibility(View.GONE);
                    ctvP25.setVisibility(View.GONE);
                    tvP26.setVisibility(View.GONE);
                    ctvP26.setVisibility(View.GONE);
                    tvP27.setVisibility(View.GONE);
                    ctvP27.setVisibility(View.GONE);
                    tvP28.setVisibility(View.GONE);
                    ctvP28.setVisibility(View.GONE);
                }
                //endregion

                //region Victima
                ctvP101.setText(victima.get(pos).getE101());
                ctvP101.setChecked(true);
                ctvP101.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO101.setVisibility(View.GONE);
                etP101.setVisibility(View.GONE);
                etP101.setText("");

                ctvP102.setText(victima.get(pos).getE102());
                ctvP102.setChecked(true);
                ctvP102.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO102.setVisibility(View.GONE);
                etP102.setVisibility(View.GONE);
                etP102.setText("");

                ctvP103.setText(victima.get(pos).getE103());
                ctvP103.setChecked(true);
                ctvP103.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO103.setVisibility(View.GONE);
                etP103.setVisibility(View.GONE);
                etP103.setText("");

                ctvP104.setText(victima.get(pos).getE104());
                ctvP104.setChecked(true);
                ctvP104.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO104.setVisibility(View.GONE);
                etP104.setVisibility(View.GONE);
                etP104.setText("");

                ctvP105.setText(victima.get(pos).getE105());
                ctvP105.setChecked(true);
                ctvP105.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO105.setVisibility(View.GONE);
                etP105.setVisibility(View.GONE);
                etP105.setText("");

                if(victima.get(pos).getE101().equals("NA")) {
                    llDatosVictima.setVisibility(View.GONE);
                }
                else{
                    llDatosVictima.setVisibility(View.VISIBLE);
                }
                //endregion

                ctvP29.setText(addresses.get(pos).getE29());
                ctvP29.setChecked(true);
                ctvP29.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO29.setVisibility(View.GONE);
                etP29.setVisibility(View.GONE);
                etP29.setText("");

                ctvP30.setText(addresses.get(pos).getE30());
                ctvP30.setChecked(true);
                ctvP30.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO30.setVisibility(View.GONE);
                etP30.setVisibility(View.GONE);
                etP30.setText("");

                ctvP31.setText(addresses.get(pos).getE31());
                ctvP31.setChecked(true);
                ctvP31.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO31.setVisibility(View.GONE);
                etP31.setVisibility(View.GONE);
                etP31.setText("");

                ctvP31_1.setText(lista.get(pos).getDelito());
                ctvP31_1.setChecked(true);
                ctvP31_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO31_1.setVisibility(View.GONE);
                etP31_1.setVisibility(View.GONE);
                etP31_1.setText("");

                ctvP31_2.setText(lista.get(pos).getDelito());
                ctvP31_2.setChecked(true);
                ctvP31_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO31_2.setVisibility(View.GONE);
                etP31_2.setVisibility(View.GONE);
                etP31_2.setText("");

                if(lista.get(pos).getDelito().equals("OTRO")) {
                    tvP31_2.setVisibility(View.VISIBLE);
                    ctvP31_2.setVisibility(View.VISIBLE);
                }
                else{
                    tvP31_2.setVisibility(View.GONE);
                    ctvP31_2.setVisibility(View.GONE);
                }

                ctvP32.setText(lista.get(pos).getOtrosHabitantes());
                ctvP32.setChecked(true);
                ctvP32.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO32.setVisibility(View.GONE);
                etP32.setVisibility(View.GONE);
                etP32.setText("");

                //region Personas con las que habita el imputado
                ctvP33.setText(habitantes.get(pos).getE33());
                ctvP33.setChecked(true);
                ctvP33.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO33.setVisibility(View.GONE);
                etP33.setVisibility(View.GONE);
                etP33.setText("");

                ctvP34.setText(habitantes.get(pos).getE34());
                ctvP34.setChecked(true);
                ctvP34.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO34.setVisibility(View.GONE);
                etP34.setVisibility(View.GONE);
                etP34.setText("");

                ctvP35.setText(habitantes.get(pos).getE35());
                ctvP35.setChecked(true);
                ctvP35.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO35.setVisibility(View.GONE);
                etP35.setVisibility(View.GONE);
                etP35.setText("");

                ctvP36.setText(habitantes.get(pos).getE36());
                ctvP36.setChecked(true);
                ctvP36.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO36.setVisibility(View.GONE);
                etP36.setVisibility(View.GONE);
                etP36.setText("");

                ctvP37.setText(habitantes.get(pos).getE37());
                ctvP37.setChecked(true);
                ctvP37.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO37.setVisibility(View.GONE);
                etP37.setVisibility(View.GONE);
                etP37.setText("");

                ctvP33_1.setText(habitantes.get(pos).getE33_1());
                ctvP33_1.setChecked(true);
                ctvP33_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO33_1.setVisibility(View.GONE);
                etP33_1.setVisibility(View.GONE);
                etP33_1.setText("");

                ctvP34_1.setText(habitantes.get(pos).getE34_1());
                ctvP34_1.setChecked(true);
                ctvP34_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO34_1.setVisibility(View.GONE);
                etP34_1.setVisibility(View.GONE);
                etP34_1.setText("");

                ctvP35_1.setText(habitantes.get(pos).getE35_1());
                ctvP35_1.setChecked(true);
                ctvP35_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO35_1.setVisibility(View.GONE);
                etP35_1.setVisibility(View.GONE);
                etP35_1.setText("");

                ctvP36_1.setText(habitantes.get(pos).getE36_1());
                ctvP36_1.setChecked(true);
                ctvP36_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO36_1.setVisibility(View.GONE);
                etP36_1.setVisibility(View.GONE);
                etP36_1.setText("");

                ctvP37_1.setText(habitantes.get(pos).getE37_1());
                ctvP37_1.setChecked(true);
                ctvP37_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO37_1.setVisibility(View.GONE);
                etP37_1.setVisibility(View.GONE);
                etP37_1.setText("");

                ctvP33_2.setText(habitantes.get(pos).getE33_2());
                ctvP33_2.setChecked(true);
                ctvP33_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO33_2.setVisibility(View.GONE);
                etP33_2.setVisibility(View.GONE);
                etP33_2.setText("");

                ctvP34_2.setText(habitantes.get(pos).getE34_2());
                ctvP34_2.setChecked(true);
                ctvP34_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO34_2.setVisibility(View.GONE);
                etP34_2.setVisibility(View.GONE);
                etP34_2.setText("");

                ctvP35_2.setText(habitantes.get(pos).getE35_2());
                ctvP35_2.setChecked(true);
                ctvP35_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO35_2.setVisibility(View.GONE);
                etP35_2.setVisibility(View.GONE);
                etP35_2.setText("");

                ctvP36_2.setText(habitantes.get(pos).getE36_2());
                ctvP36_2.setChecked(true);
                ctvP36_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO36_2.setVisibility(View.GONE);
                etP36_2.setVisibility(View.GONE);
                etP36_2.setText("");

                ctvP37_2.setText(habitantes.get(pos).getE37_2());
                ctvP37_2.setChecked(true);
                ctvP37_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO37_2.setVisibility(View.GONE);
                etP37_2.setVisibility(View.GONE);
                etP37_2.setText("");

                ctvP33_3.setText(habitantes.get(pos).getE33_3());
                ctvP33_3.setChecked(true);
                ctvP33_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO33_3.setVisibility(View.GONE);
                etP33_3.setVisibility(View.GONE);
                etP33_3.setText("");

                ctvP34_3.setText(habitantes.get(pos).getE34_3());
                ctvP34_3.setChecked(true);
                ctvP34_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO34_3.setVisibility(View.GONE);
                etP34_3.setVisibility(View.GONE);
                etP34_3.setText("");

                ctvP35_3.setText(habitantes.get(pos).getE35_3());
                ctvP35_3.setChecked(true);
                ctvP35_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO35_3.setVisibility(View.GONE);
                etP35_3.setVisibility(View.GONE);
                etP35_3.setText("");

                ctvP36_3.setText(habitantes.get(pos).getE36_3());
                ctvP36_3.setChecked(true);
                ctvP36_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO36_3.setVisibility(View.GONE);
                etP36_3.setVisibility(View.GONE);
                etP36_3.setText("");

                ctvP37_3.setText(habitantes.get(pos).getE37_3());
                ctvP37_3.setChecked(true);
                ctvP37_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO37_3.setVisibility(View.GONE);
                etP37_3.setVisibility(View.GONE);
                etP37_3.setText("");

                ctvP38.setText(habitantes.get(pos).getE38());
                ctvP38.setChecked(true);
                ctvP38.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO38.setVisibility(View.GONE);
                etP38.setVisibility(View.GONE);
                etP38.setText("");

                //region Hacer visible hasta numHabitantes bloques
                String str=lista.get(pos).getOtrosHabitantes();
                int numHabitantes = Integer.parseInt(lista.get(pos).getOtrosHabitantes());

                if(numHabitantes >= 1) {
                    persona1.setVisibility(View.VISIBLE);
                    tvP33.setVisibility(View.VISIBLE);
                    ctvP33.setVisibility(View.VISIBLE);
                    tvP34.setVisibility(View.VISIBLE);
                    ctvP34.setVisibility(View.VISIBLE);
                    tvP35.setVisibility(View.VISIBLE);
                    ctvP35.setVisibility(View.VISIBLE);
                    tvP36.setVisibility(View.VISIBLE);
                    ctvP36.setVisibility(View.VISIBLE);
                    tvP37.setVisibility(View.VISIBLE);
                    ctvP37.setVisibility(View.VISIBLE);
                }
                else {
                    persona1.setVisibility(View.GONE);
                    tvP33.setVisibility(View.GONE);
                    ctvP33.setVisibility(View.GONE);
                    tvP34.setVisibility(View.GONE);
                    ctvP34.setVisibility(View.GONE);
                    tvP35.setVisibility(View.GONE);
                    ctvP35.setVisibility(View.GONE);
                    tvP36.setVisibility(View.GONE);
                    ctvP36.setVisibility(View.GONE);
                    tvP37.setVisibility(View.GONE);
                    ctvP37.setVisibility(View.GONE);
                }

                if(numHabitantes >= 2) {
                    persona2.setVisibility(View.VISIBLE);
                    tvP33_1.setVisibility(View.VISIBLE);
                    ctvP33_1.setVisibility(View.VISIBLE);
                    tvP34_1.setVisibility(View.VISIBLE);
                    ctvP34_1.setVisibility(View.VISIBLE);
                    tvP35_1.setVisibility(View.VISIBLE);
                    ctvP35_1.setVisibility(View.VISIBLE);
                    tvP36_1.setVisibility(View.VISIBLE);
                    ctvP36_1.setVisibility(View.VISIBLE);
                    tvP37_1.setVisibility(View.VISIBLE);
                    ctvP37_1.setVisibility(View.VISIBLE);
                }
                else {
                    persona2.setVisibility(View.GONE);
                    tvP33_1.setVisibility(View.GONE);
                    ctvP33_1.setVisibility(View.GONE);
                    tvP34_1.setVisibility(View.GONE);
                    ctvP34_1.setVisibility(View.GONE);
                    tvP35_1.setVisibility(View.GONE);
                    ctvP35_1.setVisibility(View.GONE);
                    tvP36_1.setVisibility(View.GONE);
                    ctvP36_1.setVisibility(View.GONE);
                    tvP37_1.setVisibility(View.GONE);
                    ctvP37_1.setVisibility(View.GONE);
                }

                if(numHabitantes >= 3) {
                    persona3.setVisibility(View.VISIBLE);
                    tvP33_2.setVisibility(View.VISIBLE);
                    ctvP33_2.setVisibility(View.VISIBLE);
                    tvP34_2.setVisibility(View.VISIBLE);
                    ctvP34_2.setVisibility(View.VISIBLE);
                    tvP35_2.setVisibility(View.VISIBLE);
                    ctvP35_2.setVisibility(View.VISIBLE);
                    tvP36_2.setVisibility(View.VISIBLE);
                    ctvP36_2.setVisibility(View.VISIBLE);
                    tvP37_2.setVisibility(View.VISIBLE);
                    ctvP37_2.setVisibility(View.VISIBLE);
                }
                else{
                    persona3.setVisibility(View.GONE);
                    tvP33_2.setVisibility(View.GONE);
                    ctvP33_2.setVisibility(View.GONE);
                    tvP34_2.setVisibility(View.GONE);
                    ctvP34_2.setVisibility(View.GONE);
                    tvP35_2.setVisibility(View.GONE);
                    ctvP35_2.setVisibility(View.GONE);
                    tvP36_2.setVisibility(View.GONE);
                    ctvP36_2.setVisibility(View.GONE);
                    tvP37_2.setVisibility(View.GONE);
                    ctvP37_2.setVisibility(View.GONE);
                }

                if(numHabitantes >= 4) {
                    persona4.setVisibility(View.VISIBLE);
                    tvP33_3.setVisibility(View.VISIBLE);
                    ctvP33_3.setVisibility(View.VISIBLE);
                    tvP34_3.setVisibility(View.VISIBLE);
                    ctvP34_3.setVisibility(View.VISIBLE);
                    tvP35_3.setVisibility(View.VISIBLE);
                    ctvP35_3.setVisibility(View.VISIBLE);
                    tvP36_3.setVisibility(View.VISIBLE);
                    ctvP36_3.setVisibility(View.VISIBLE);
                    tvP37_3.setVisibility(View.VISIBLE);
                    ctvP37_3.setVisibility(View.VISIBLE);
                }
                else{
                    persona4.setVisibility(View.GONE);
                    tvP33_3.setVisibility(View.GONE);
                    ctvP33_3.setVisibility(View.GONE);
                    tvP34_3.setVisibility(View.GONE);
                    ctvP34_3.setVisibility(View.GONE);
                    tvP35_3.setVisibility(View.GONE);
                    ctvP35_3.setVisibility(View.GONE);
                    tvP36_3.setVisibility(View.GONE);
                    ctvP36_3.setVisibility(View.GONE);
                    tvP37_3.setVisibility(View.GONE);
                    ctvP37_3.setVisibility(View.GONE);
                    tvP38.setVisibility(View.GONE);
                    ctvP38.setVisibility(View.GONE);
                }
                //endregion
                //endregion

                ctvP39.setText(referencias.get(pos).getE39());
                ctvP39.setChecked(true);
                ctvP39.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO39.setVisibility(View.GONE);
                etP39.setVisibility(View.GONE);
                etP39.setText("");

                ctvP40.setText(referencias.get(pos).getE40());
                ctvP40.setChecked(true);
                ctvP40.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO40.setVisibility(View.GONE);
                etP40.setVisibility(View.GONE);
                etP40.setText("");

                ctvP41.setText(referencias.get(pos).getE41());
                ctvP41.setChecked(true);
                ctvP41.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO41.setVisibility(View.GONE);
                etP41.setVisibility(View.GONE);
                etP41.setText("");

                ctvP42.setText(referencias.get(pos).getE42());
                ctvP42.setChecked(true);
                ctvP42.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO42.setVisibility(View.GONE);
                etP42.setVisibility(View.GONE);
                etP42.setText("");

                ctvP43.setText(referencias.get(pos).getE43());
                ctvP43.setChecked(true);
                ctvP43.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO43.setVisibility(View.GONE);
                etP43.setVisibility(View.GONE);
                etP43.setText("");

                ctvP39_1.setText(referencias.get(pos).getE39_1());
                ctvP39_1.setChecked(true);
                ctvP39_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO39_1.setVisibility(View.GONE);
                etP39_1.setVisibility(View.GONE);
                etP39_1.setText("");

                ctvP40_1.setText(referencias.get(pos).getE40_1());
                ctvP40_1.setChecked(true);
                ctvP40_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO40_1.setVisibility(View.GONE);
                etP40_1.setVisibility(View.GONE);
                etP40_1.setText("");

                ctvP41_1.setText(referencias.get(pos).getE41_1());
                ctvP41_1.setChecked(true);
                ctvP41_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO41_1.setVisibility(View.GONE);
                etP41_1.setVisibility(View.GONE);
                etP41_1.setText("");

                ctvP42_1.setText(referencias.get(pos).getE42_1());
                ctvP42_1.setChecked(true);
                ctvP42_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO42_1.setVisibility(View.GONE);
                etP42_1.setVisibility(View.GONE);
                etP42_1.setText("");

                ctvP43_1.setText(referencias.get(pos).getE43_1());
                ctvP43_1.setChecked(true);
                ctvP43_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO43_1.setVisibility(View.GONE);
                etP43_1.setVisibility(View.GONE);
                etP43_1.setText("");

                //region Esconder/mostrar cambio de domicilio
                ctvP44.setText(referencias.get(pos).getE44());
                ctvP44.setChecked(true);
                ctvP44.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO44.setVisibility(View.GONE);
                etP44.setVisibility(View.GONE);
                etP44.setText("");

                ctvP45.setText(referencias.get(pos).getE45());
                ctvP45.setChecked(true);
                ctvP45.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO45.setVisibility(View.GONE);
                etP45.setVisibility(View.GONE);
                etP45.setText("");

                ctvP46.setText(referencias.get(pos).getE46());
                ctvP46.setChecked(true);
                ctvP46.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO46.setVisibility(View.GONE);
                etP46.setVisibility(View.GONE);
                etP46.setText("");

                ctvP47.setText(referencias.get(pos).getE47());
                ctvP47.setChecked(true);
                ctvP47.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO47.setVisibility(View.GONE);
                etP47.setVisibility(View.GONE);
                etP47.setText("");

                if(referencias.get(pos).getE44().equals("SI")) {
                    tvP45.setVisibility(View.VISIBLE);
                    ctvP45.setVisibility(View.VISIBLE);
                    tvP46.setVisibility(View.VISIBLE);
                    ctvP46.setVisibility(View.VISIBLE);
                    tvP47.setVisibility(View.VISIBLE);
                    ctvP47.setVisibility(View.VISIBLE);
                }
                else{
                    tvP45.setVisibility(View.GONE);
                    ctvP45.setVisibility(View.GONE);
                    tvP46.setVisibility(View.GONE);
                    ctvP46.setVisibility(View.GONE);
                    tvP47.setVisibility(View.GONE);
                    ctvP47.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar historial escolar
                ctvP48.setText(historialEscolarLaboral.get(pos).getE48());
                ctvP48.setChecked(true);
                ctvP48.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO48.setVisibility(View.GONE);
                etP48.setVisibility(View.GONE);
                etP48.setText("");

                ctvP49.setText(historialEscolarLaboral.get(pos).getE49());
                ctvP49.setChecked(true);
                ctvP49.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO49.setVisibility(View.GONE);
                etP49.setVisibility(View.GONE);
                etP49.setText("");

                if(historialEscolarLaboral.get(pos).getE48().equals("SI")) {
                    tvP49.setVisibility(View.VISIBLE);
                    ctvP49.setVisibility(View.VISIBLE);
                }
                else{
                    tvP49.setVisibility(View.GONE);
                    ctvP49.setVisibility(View.GONE);
                }
                //endregion

                ctvP50.setText(historialEscolarLaboral.get(pos).getE50());
                ctvP50.setChecked(true);
                ctvP50.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO50.setVisibility(View.GONE);
                etP50.setVisibility(View.GONE);
                etP50.setText("");

                //region Esconder/mostrar historial laboral
                ctvP51.setText(historialEscolarLaboral.get(pos).getE51());
                ctvP51.setChecked(true);
                ctvP51.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO51.setVisibility(View.GONE);
                etP51.setVisibility(View.GONE);
                etP51.setText("");

                ctvP52.setText(historialEscolarLaboral.get(pos).getE52());
                ctvP52.setChecked(true);
                ctvP52.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO52.setVisibility(View.GONE);
                etP52.setVisibility(View.GONE);
                etP52.setText("");

                ctvP53.setText(historialEscolarLaboral.get(pos).getE53());
                ctvP53.setChecked(true);
                ctvP53.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO53.setVisibility(View.GONE);
                etP53.setVisibility(View.GONE);
                etP53.setText("");

                ctvP54.setText(historialEscolarLaboral.get(pos).getE54());
                ctvP54.setChecked(true);
                ctvP54.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO54.setVisibility(View.GONE);
                etP54.setVisibility(View.GONE);
                etP54.setText("");

                ctvP55.setText(historialEscolarLaboral.get(pos).getE55());
                ctvP55.setChecked(true);
                ctvP55.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO55.setVisibility(View.GONE);
                etP55.setVisibility(View.GONE);
                etP55.setText("");

                ctvP57.setText(historialEscolarLaboral.get(pos).getE57());
                ctvP57.setChecked(true);
                ctvP57.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO57.setVisibility(View.GONE);
                etP57.setVisibility(View.GONE);
                etP57.setText("");

                ctvP56.setText(historialEscolarLaboral.get(pos).getE56());
                ctvP56.setChecked(true);
                ctvP56.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO56.setVisibility(View.GONE);
                etP56.setVisibility(View.GONE);
                etP56.setText("");

                ctvP58.setText(historialEscolarLaboral.get(pos).getE58());
                ctvP58.setChecked(true);
                ctvP58.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO58.setVisibility(View.GONE);
                etP58.setVisibility(View.GONE);
                etP58.setText("");

                ctvP51_1.setText(historialEscolarLaboral.get(pos).getE51_1());
                ctvP51_1.setChecked(true);
                ctvP51_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO51_1.setVisibility(View.GONE);
                etP51_1.setVisibility(View.GONE);
                etP51_1.setText("");

                ctvP59.setText(historialEscolarLaboral.get(pos).getE59());
                ctvP59.setChecked(true);
                ctvP59.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO59.setVisibility(View.GONE);
                etP59.setVisibility(View.GONE);
                etP59.setText("");

                if(historialEscolarLaboral.get(pos).getE51().equals("SI")) {
                    tvP52.setVisibility(View.VISIBLE);
                    ctvP52.setVisibility(View.VISIBLE);
                    tvP53.setVisibility(View.VISIBLE);
                    ctvP53.setVisibility(View.VISIBLE);
                    tvP54.setVisibility(View.VISIBLE);
                    ctvP54.setVisibility(View.VISIBLE);
                    tvP55.setVisibility(View.VISIBLE);
                    ctvP55.setVisibility(View.VISIBLE);
                    tvP57.setVisibility(View.VISIBLE);
                    ctvP57.setVisibility(View.VISIBLE);
                    tvP56.setVisibility(View.VISIBLE);
                    ctvP56.setVisibility(View.VISIBLE);
                    tvP58.setVisibility(View.VISIBLE);
                    ctvP58.setVisibility(View.VISIBLE);
                    tvP59.setVisibility(View.GONE);
                    ctvP59.setVisibility(View.GONE);
                }
                else{
                    tvP52.setVisibility(View.GONE);
                    ctvP52.setVisibility(View.GONE);
                    tvP53.setVisibility(View.GONE);
                    ctvP53.setVisibility(View.GONE);
                    tvP54.setVisibility(View.GONE);
                    ctvP54.setVisibility(View.GONE);
                    tvP55.setVisibility(View.GONE);
                    ctvP55.setVisibility(View.GONE);
                    tvP57.setVisibility(View.GONE);
                    ctvP57.setVisibility(View.GONE);
                    tvP56.setVisibility(View.GONE);
                    ctvP56.setVisibility(View.GONE);
                    tvP58.setVisibility(View.GONE);
                    ctvP58.setVisibility(View.GONE);
                    tvP59.setVisibility(View.VISIBLE);
                    ctvP59.setVisibility(View.VISIBLE);
                }
                //endregion

                //region Mostrar/esconder si ha viajado fuera de la República Mexicana
                ctvP60.setText(listaAbandonoEstado.get(pos).getE60());
                ctvP60.setChecked(true);
                ctvP60.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO60.setVisibility(View.GONE);
                etP60.setVisibility(View.GONE);
                etP60.setText("");

                ctvP61.setText(listaAbandonoEstado.get(pos).getE61());
                ctvP61.setChecked(true);
                ctvP61.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO61.setVisibility(View.GONE);
                etP61.setVisibility(View.GONE);
                etP61.setText("");

                ctvP62.setText(listaAbandonoEstado.get(pos).getE62());
                ctvP62.setChecked(true);
                ctvP62.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO62.setVisibility(View.GONE);
                etP62.setVisibility(View.GONE);
                etP62.setText("");

                ctvP63.setText(listaAbandonoEstado.get(pos).getE63());
                ctvP63.setChecked(true);
                ctvP63.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO63.setVisibility(View.GONE);
                etP63.setVisibility(View.GONE);
                etP63.setText("");

                ctvP64.setText(listaAbandonoEstado.get(pos).getE64());
                ctvP64.setChecked(true);
                ctvP64.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO64.setVisibility(View.GONE);
                etP64.setVisibility(View.GONE);
                etP64.setText("");

                ctvP65.setText(listaAbandonoEstado.get(pos).getE65());
                ctvP65.setChecked(true);
                ctvP65.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO65.setVisibility(View.GONE);
                etP65.setVisibility(View.GONE);
                etP65.setText("");

                if(listaAbandonoEstado.get(pos).getE60().equals("SI")) {
                    tvP61.setVisibility(View.VISIBLE);
                    ctvP61.setVisibility(View.VISIBLE);
                    tvP62.setVisibility(View.VISIBLE);
                    ctvP62.setVisibility(View.VISIBLE);
                    tvP63.setVisibility(View.VISIBLE);
                    ctvP63.setVisibility(View.VISIBLE);
                    tvP64.setVisibility(View.VISIBLE);
                    ctvP64.setVisibility(View.VISIBLE);
                    tvP65.setVisibility(View.VISIBLE);
                    ctvP65.setVisibility(View.VISIBLE);
                }
                else{
                    tvP61.setVisibility(View.GONE);
                    ctvP61.setVisibility(View.GONE);
                    tvP62.setVisibility(View.GONE);
                    ctvP62.setVisibility(View.GONE);
                    tvP63.setVisibility(View.GONE);
                    ctvP63.setVisibility(View.GONE);
                    tvP64.setVisibility(View.GONE);
                    ctvP64.setVisibility(View.GONE);
                    tvP65.setVisibility(View.GONE);
                    ctvP65.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar familiares en el extranjero
                ctvP66.setText(listaAbandonoEstado.get(pos).getE66());
                ctvP66.setChecked(true);
                ctvP66.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO66.setVisibility(View.GONE);
                etP66.setVisibility(View.GONE);
                etP66.setText("");

                ctvP67.setText(listaAbandonoEstado.get(pos).getE67());
                ctvP67.setChecked(true);
                ctvP67.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO67.setVisibility(View.GONE);
                etP67.setVisibility(View.GONE);
                etP67.setText("");

                ctvP68.setText(listaAbandonoEstado.get(pos).getE68());
                ctvP68.setChecked(true);
                ctvP68.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO68.setVisibility(View.GONE);
                etP68.setVisibility(View.GONE);
                etP68.setText("");

                ctvP69.setText(listaAbandonoEstado.get(pos).getE69());
                ctvP69.setChecked(true);
                ctvP69.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO69.setVisibility(View.GONE);
                etP69.setVisibility(View.GONE);
                etP69.setText("");

                ctvP70.setText(listaAbandonoEstado.get(pos).getE70());
                ctvP70.setChecked(true);
                ctvP70.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO70.setVisibility(View.GONE);
                etP70.setVisibility(View.GONE);
                etP70.setText("");

                ctvP71.setText(listaAbandonoEstado.get(pos).getE71());
                ctvP71.setChecked(true);
                ctvP71.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO71.setVisibility(View.GONE);
                etP71.setVisibility(View.GONE);
                etP71.setText("");

                ctvP72.setText(listaAbandonoEstado.get(pos).getE72());
                ctvP72.setChecked(true);
                ctvP72.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO72.setVisibility(View.GONE);
                etP72.setVisibility(View.GONE);
                etP72.setText("");

                ctvP67_1.setText(listaAbandonoEstado.get(pos).getE67_1());
                ctvP67_1.setChecked(true);
                ctvP67_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO67_1.setVisibility(View.GONE);
                etP67_1.setVisibility(View.GONE);
                etP67_1.setText("");

                ctvP68_1.setText(listaAbandonoEstado.get(pos).getE68_1());
                ctvP68_1.setChecked(true);
                ctvP68_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO68_1.setVisibility(View.GONE);
                etP68_1.setVisibility(View.GONE);
                etP68_1.setText("");

                ctvP69_1.setText(listaAbandonoEstado.get(pos).getE69_1());
                ctvP69_1.setChecked(true);
                ctvP69_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO69_1.setVisibility(View.GONE);
                etP69_1.setVisibility(View.GONE);
                etP69_1.setText("");

                ctvP70_1.setText(listaAbandonoEstado.get(pos).getE70_1());
                ctvP70_1.setChecked(true);
                ctvP70_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO70_1.setVisibility(View.GONE);
                etP70_1.setVisibility(View.GONE);
                etP70_1.setText("");

                ctvP71_1.setText(listaAbandonoEstado.get(pos).getE71_1());
                ctvP71_1.setChecked(true);
                ctvP71_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO71_1.setVisibility(View.GONE);
                etP71_1.setVisibility(View.GONE);
                etP71_1.setText("");

                ctvP72_1.setText(listaAbandonoEstado.get(pos).getE72_1());
                ctvP72_1.setChecked(true);
                ctvP72_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO72_1.setVisibility(View.GONE);
                etP72_1.setVisibility(View.GONE);
                etP72_1.setText("");

                if(listaAbandonoEstado.get(pos).getE66().equals("SI")) {
                    personaE1.setVisibility(View.VISIBLE);
                    personaE2.setVisibility(View.VISIBLE);
                    tvP67.setVisibility(View.VISIBLE);
                    ctvP67.setVisibility(View.VISIBLE);
                    tvP68.setVisibility(View.VISIBLE);
                    ctvP68.setVisibility(View.VISIBLE);
                    tvP69.setVisibility(View.VISIBLE);
                    ctvP69.setVisibility(View.VISIBLE);
                    tvP70.setVisibility(View.VISIBLE);
                    ctvP70.setVisibility(View.VISIBLE);
                    tvP71.setVisibility(View.VISIBLE);
                    ctvP71.setVisibility(View.VISIBLE);
                    tvP72.setVisibility(View.VISIBLE);
                    ctvP72.setVisibility(View.VISIBLE);
                    tvP67_1.setVisibility(View.VISIBLE);
                    ctvP67_1.setVisibility(View.VISIBLE);
                    tvP68_1.setVisibility(View.VISIBLE);
                    ctvP68_1.setVisibility(View.VISIBLE);
                    tvP69_1.setVisibility(View.VISIBLE);
                    ctvP69_1.setVisibility(View.VISIBLE);
                    tvP70_1.setVisibility(View.VISIBLE);
                    ctvP70_1.setVisibility(View.VISIBLE);
                    tvP71_1.setVisibility(View.VISIBLE);
                    ctvP71_1.setVisibility(View.VISIBLE);
                    tvP72_1.setVisibility(View.VISIBLE);
                    ctvP72_1.setVisibility(View.VISIBLE);
                }
                else{
                    personaE1.setVisibility(View.GONE);
                    personaE2.setVisibility(View.GONE);
                    tvP67.setVisibility(View.GONE);
                    ctvP67.setVisibility(View.GONE);
                    tvP68.setVisibility(View.GONE);
                    ctvP68.setVisibility(View.GONE);
                    tvP69.setVisibility(View.GONE);
                    ctvP69.setVisibility(View.GONE);
                    tvP70.setVisibility(View.GONE);
                    ctvP70.setVisibility(View.GONE);
                    tvP71.setVisibility(View.GONE);
                    ctvP71.setVisibility(View.GONE);
                    tvP72.setVisibility(View.GONE);
                    ctvP72.setVisibility(View.GONE);
                    tvP67_1.setVisibility(View.GONE);
                    ctvP67_1.setVisibility(View.GONE);
                    tvP68_1.setVisibility(View.GONE);
                    ctvP68_1.setVisibility(View.GONE);
                    tvP69_1.setVisibility(View.GONE);
                    ctvP69_1.setVisibility(View.GONE);
                    tvP70_1.setVisibility(View.GONE);
                    ctvP70_1.setVisibility(View.GONE);
                    tvP71_1.setVisibility(View.GONE);
                    ctvP71_1.setVisibility(View.GONE);
                    tvP72_1.setVisibility(View.GONE);
                    ctvP72_1.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar familiares en la republica
                ctvP73.setText(listaAbandonoEstado.get(pos).getE73());
                ctvP73.setChecked(true);
                ctvP73.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO73.setVisibility(View.GONE);
                etP73.setVisibility(View.GONE);
                etP73.setText("");

                ctvP74.setText(listaAbandonoEstado.get(pos).getE74());
                ctvP74.setChecked(true);
                ctvP74.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO74.setVisibility(View.GONE);
                etP74.setVisibility(View.GONE);
                etP74.setText("");

                ctvP75.setText(listaAbandonoEstado.get(pos).getE75());
                ctvP75.setChecked(true);
                ctvP75.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO75.setVisibility(View.GONE);
                etP75.setVisibility(View.GONE);
                etP75.setText("");

                ctvP76.setText(listaAbandonoEstado.get(pos).getE76());
                ctvP76.setChecked(true);
                ctvP76.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO76.setVisibility(View.GONE);
                etP76.setVisibility(View.GONE);
                etP76.setText("");

                ctvP77.setText(listaAbandonoEstado.get(pos).getE77());
                ctvP77.setChecked(true);
                ctvP77.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO77.setVisibility(View.GONE);
                etP77.setVisibility(View.GONE);
                etP77.setText("");

                ctvP78.setText(listaAbandonoEstado.get(pos).getE78());
                ctvP78.setChecked(true);
                ctvP78.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO78.setVisibility(View.GONE);
                etP78.setVisibility(View.GONE);
                etP78.setText("");

                ctvP74_1.setText(listaAbandonoEstado.get(pos).getE74_1());
                ctvP74_1.setChecked(true);
                ctvP74_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO74_1.setVisibility(View.GONE);
                etP74_1.setVisibility(View.GONE);
                etP74_1.setText("");

                ctvP75_1.setText(listaAbandonoEstado.get(pos).getE75_1());
                ctvP75_1.setChecked(true);
                ctvP75_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO75_1.setVisibility(View.GONE);
                etP75_1.setVisibility(View.GONE);
                etP75_1.setText("");

                ctvP76_1.setText(listaAbandonoEstado.get(pos).getE76_1());
                ctvP76_1.setChecked(true);
                ctvP76_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO76_1.setVisibility(View.GONE);
                etP76_1.setVisibility(View.GONE);
                etP76_1.setText("");

                ctvP77_1.setText(listaAbandonoEstado.get(pos).getE77_1());
                ctvP77_1.setChecked(true);
                ctvP77_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO77_1.setVisibility(View.GONE);
                etP77_1.setVisibility(View.GONE);
                etP77_1.setText("");

                ctvP78_1.setText(listaAbandonoEstado.get(pos).getE78_1());
                ctvP78_1.setChecked(true);
                ctvP78_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO78_1.setVisibility(View.GONE);
                etP78_1.setVisibility(View.GONE);
                etP78_1.setText("");

                if(listaAbandonoEstado.get(pos).getE73().equals("SI")) {
                    personaEstado1.setVisibility(View.VISIBLE);
                    personaEstado2.setVisibility(View.VISIBLE);
                    tvP74.setVisibility(View.VISIBLE);
                    ctvP74.setVisibility(View.VISIBLE);
                    tvP75.setVisibility(View.VISIBLE);
                    ctvP75.setVisibility(View.VISIBLE);
                    tvP76.setVisibility(View.VISIBLE);
                    ctvP76.setVisibility(View.VISIBLE);
                    tvP77.setVisibility(View.VISIBLE);
                    ctvP77.setVisibility(View.VISIBLE);
                    tvP78.setVisibility(View.VISIBLE);
                    ctvP78.setVisibility(View.VISIBLE);
                    tvP74_1.setVisibility(View.VISIBLE);
                    ctvP74_1.setVisibility(View.VISIBLE);
                    tvP75_1.setVisibility(View.VISIBLE);
                    ctvP75_1.setVisibility(View.VISIBLE);
                    tvP76_1.setVisibility(View.VISIBLE);
                    ctvP76_1.setVisibility(View.VISIBLE);
                    tvP77_1.setVisibility(View.VISIBLE);
                    ctvP77_1.setVisibility(View.VISIBLE);
                    tvP78_1.setVisibility(View.VISIBLE);
                    ctvP78_1.setVisibility(View.VISIBLE);
                }
                else{
                    personaEstado1.setVisibility(View.GONE);
                    personaEstado2.setVisibility(View.GONE);
                    tvP74.setVisibility(View.GONE);
                    ctvP74.setVisibility(View.GONE);
                    tvP75.setVisibility(View.GONE);
                    ctvP75.setVisibility(View.GONE);
                    tvP76.setVisibility(View.GONE);
                    ctvP76.setVisibility(View.GONE);
                    tvP77.setVisibility(View.GONE);
                    ctvP77.setVisibility(View.GONE);
                    tvP78.setVisibility(View.GONE);
                    ctvP78.setVisibility(View.GONE);
                    tvP74_1.setVisibility(View.GONE);
                    ctvP74_1.setVisibility(View.GONE);
                    tvP75_1.setVisibility(View.GONE);
                    ctvP75_1.setVisibility(View.GONE);
                    tvP76_1.setVisibility(View.GONE);
                    ctvP76_1.setVisibility(View.GONE);
                    tvP77_1.setVisibility(View.GONE);
                    ctvP77_1.setVisibility(View.GONE);
                    tvP78_1.setVisibility(View.GONE);
                    ctvP78_1.setVisibility(View.GONE);
                }
                //endregion

                ctvP79.setText(listaAbandonoEstado.get(pos).getE79());
                ctvP79.setChecked(true);
                ctvP79.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO79.setVisibility(View.GONE);
                etP79.setVisibility(View.GONE);
                etP79.setText("");

                ctvP80.setText(listaAbandonoEstado.get(pos).getE80());
                ctvP80.setChecked(true);
                ctvP80.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO80.setVisibility(View.GONE);
                etP80.setVisibility(View.GONE);
                etP80.setText("");

                ctvP81.setText(listaAbandonoEstado.get(pos).getE81());
                ctvP81.setChecked(true);
                ctvP81.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO81.setVisibility(View.GONE);
                etP81.setVisibility(View.GONE);
                etP81.setText("");

                //region Esconder/mostrar consumo de alcohol
                ctvP82.setText(listaSalud.get(pos).getE82());
                ctvP82.setChecked(true);
                ctvP82.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO82.setVisibility(View.GONE);
                etP82.setVisibility(View.GONE);
                etP82.setText("");

                ctvP90_alcohol.setText(listaSalud.get(pos).getE90_alcohol());
                ctvP90_alcohol.setChecked(true);
                ctvP90_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_alcohol.setVisibility(View.GONE);
                etP90_alcohol.setVisibility(View.GONE);
                etP90_alcohol.setText("");

                ctvP91_alcohol.setText(listaSalud.get(pos).getE91_alcohol());
                ctvP91_alcohol.setChecked(true);
                ctvP91_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_alcohol.setVisibility(View.GONE);
                etP91_alcohol.setVisibility(View.GONE);
                etP91_alcohol.setText("");

                ctvP92_alcohol.setText(listaSalud.get(pos).getE92_alcohol());
                ctvP92_alcohol.setChecked(true);
                ctvP92_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_alcohol.setVisibility(View.GONE);
                etP92_alcohol.setVisibility(View.GONE);
                etP92_alcohol.setText("");

                if(listaSalud.get(pos).getE82().equals("SI")) {
                    tvP90_alcohol.setVisibility(View.VISIBLE);
                    ctvP90_alcohol.setVisibility(View.VISIBLE);
                    tvP91_alcohol.setVisibility(View.VISIBLE);
                    ctvP91_alcohol.setVisibility(View.VISIBLE);
                    tvP92_alcohol.setVisibility(View.VISIBLE);
                    ctvP92_alcohol.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_alcohol.setVisibility(View.GONE);
                    ctvP90_alcohol.setVisibility(View.GONE);
                    tvP91_alcohol.setVisibility(View.GONE);
                    ctvP91_alcohol.setVisibility(View.GONE);
                    tvP92_alcohol.setVisibility(View.GONE);
                    ctvP92_alcohol.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar consumo de tabaco
                ctvP83.setText(listaSalud.get(pos).getE83());
                ctvP83.setChecked(true);
                ctvP83.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO83.setVisibility(View.GONE);
                etP83.setVisibility(View.GONE);
                etP83.setText("");

                ctvP90_tabaco.setText(listaSalud.get(pos).getE90_tabaco());
                ctvP90_tabaco.setChecked(true);
                ctvP90_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_tabaco.setVisibility(View.GONE);
                etP90_tabaco.setVisibility(View.GONE);
                etP90_tabaco.setText("");

                ctvP91_tabaco.setText(listaSalud.get(pos).getE91_tabaco());
                ctvP91_tabaco.setChecked(true);
                ctvP91_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_tabaco.setVisibility(View.GONE);
                etP91_tabaco.setVisibility(View.GONE);
                etP91_tabaco.setText("");

                ctvP92_tabaco.setText(listaSalud.get(pos).getE92_tabaco());
                ctvP92_tabaco.setChecked(true);
                ctvP92_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_tabaco.setVisibility(View.GONE);
                etP92_tabaco.setVisibility(View.GONE);
                etP92_tabaco.setText("");

                if(listaSalud.get(pos).getE83().equals("SI")) {
                    tvP90_tabaco.setVisibility(View.VISIBLE);
                    ctvP90_tabaco.setVisibility(View.VISIBLE);
                    tvP91_tabaco.setVisibility(View.VISIBLE);
                    ctvP91_tabaco.setVisibility(View.VISIBLE);
                    tvP92_tabaco.setVisibility(View.VISIBLE);
                    ctvP92_tabaco.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_tabaco.setVisibility(View.GONE);
                    ctvP90_tabaco.setVisibility(View.GONE);
                    tvP91_tabaco.setVisibility(View.GONE);
                    ctvP91_tabaco.setVisibility(View.GONE);
                    tvP92_tabaco.setVisibility(View.GONE);
                    ctvP92_tabaco.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar consumo de ctvP90_marihuana
                ctvP84.setText(listaSalud.get(pos).getE84());
                ctvP84.setChecked(true);
                ctvP84.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO84.setVisibility(View.GONE);
                etP84.setVisibility(View.GONE);
                etP84.setText("");

                ctvP90_marihuana.setText(listaSalud.get(pos).getE90_marihuana());
                ctvP90_marihuana.setChecked(true);
                ctvP90_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_marihuana.setVisibility(View.GONE);
                etP90_marihuana.setVisibility(View.GONE);
                etP90_marihuana.setText("");

                ctvP91_marihuana.setText(listaSalud.get(pos).getE91_marihuana());
                ctvP91_marihuana.setChecked(true);
                ctvP91_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_marihuana.setVisibility(View.GONE);
                etP91_marihuana.setVisibility(View.GONE);
                etP91_marihuana.setText("");

                ctvP92_marihuana.setText(listaSalud.get(pos).getE92_marihuana());
                ctvP92_marihuana.setChecked(true);
                ctvP92_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_marihuana.setVisibility(View.GONE);
                etP92_marihuana.setVisibility(View.GONE);
                etP92_marihuana.setText("");

                if(listaSalud.get(pos).getE84().equals("SI")) {
                    tvP90_marihuana.setVisibility(View.VISIBLE);
                    ctvP90_marihuana.setVisibility(View.VISIBLE);
                    tvP91_marihuana.setVisibility(View.VISIBLE);
                    ctvP91_marihuana.setVisibility(View.VISIBLE);
                    tvP92_marihuana.setVisibility(View.VISIBLE);
                    ctvP92_marihuana.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_marihuana.setVisibility(View.GONE);
                    ctvP90_marihuana.setVisibility(View.GONE);
                    tvP91_marihuana.setVisibility(View.GONE);
                    ctvP91_marihuana.setVisibility(View.GONE);
                    tvP92_marihuana.setVisibility(View.GONE);
                    ctvP92_marihuana.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar consumo de pastillas
                ctvP85.setText(listaSalud.get(pos).getE85());
                ctvP85.setChecked(true);
                ctvP85.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO85.setVisibility(View.GONE);
                etP85.setVisibility(View.GONE);
                etP85.setText("");

                ctvP90_pastillas.setText(listaSalud.get(pos).getE90_pastillas());
                ctvP90_pastillas.setChecked(true);
                ctvP90_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_pastillas.setVisibility(View.GONE);
                etP90_pastillas.setVisibility(View.GONE);
                etP90_pastillas.setText("");

                ctvP91_pastillas.setText(listaSalud.get(pos).getE91_pastillas());
                ctvP91_pastillas.setChecked(true);
                ctvP91_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_pastillas.setVisibility(View.GONE);
                etP91_pastillas.setVisibility(View.GONE);
                etP91_pastillas.setText("");

                ctvP92_pastillas.setText(listaSalud.get(pos).getE92_pastillas());
                ctvP92_pastillas.setChecked(true);
                ctvP92_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_pastillas.setVisibility(View.GONE);
                etP92_pastillas.setVisibility(View.GONE);
                etP92_pastillas.setText("");

                if(listaSalud.get(pos).getE85().equals("SI")) {
                    tvP90_pastillas.setVisibility(View.VISIBLE);
                    ctvP90_pastillas.setVisibility(View.VISIBLE);
                    tvP91_pastillas.setVisibility(View.VISIBLE);
                    ctvP91_pastillas.setVisibility(View.VISIBLE);
                    tvP92_pastillas.setVisibility(View.VISIBLE);
                    ctvP92_pastillas.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_pastillas.setVisibility(View.GONE);
                    ctvP90_pastillas.setVisibility(View.GONE);
                    tvP91_pastillas.setVisibility(View.GONE);
                    ctvP91_pastillas.setVisibility(View.GONE);
                    tvP92_pastillas.setVisibility(View.GONE);
                    ctvP92_pastillas.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostar consumo de solventes
                ctvP86.setText(listaSalud.get(pos).getE86());
                ctvP86.setChecked(true);
                ctvP86.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO86.setVisibility(View.GONE);
                etP86.setVisibility(View.GONE);
                etP86.setText("");

                ctvP90_solventes.setText(listaSalud.get(pos).getE90_solventes());
                ctvP90_solventes.setChecked(true);
                ctvP90_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_solventes.setVisibility(View.GONE);
                etP90_solventes.setVisibility(View.GONE);
                etP90_solventes.setText("");

                ctvP91_solventes.setText(listaSalud.get(pos).getE91_solventes());
                ctvP91_solventes.setChecked(true);
                ctvP91_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_solventes.setVisibility(View.GONE);
                etP91_solventes.setVisibility(View.GONE);
                etP91_solventes.setText("");

                ctvP92_solventes.setText(listaSalud.get(pos).getE92_solventes());
                ctvP92_solventes.setChecked(true);
                ctvP92_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_solventes.setVisibility(View.GONE);
                etP92_solventes.setVisibility(View.GONE);
                etP92_solventes.setText("");

                if(listaSalud.get(pos).getE86().equals("SI")) {
                    tvP90_solventes.setVisibility(View.VISIBLE);
                    ctvP90_solventes.setVisibility(View.VISIBLE);
                    tvP91_solventes.setVisibility(View.VISIBLE);
                    ctvP91_solventes.setVisibility(View.VISIBLE);
                    tvP92_solventes.setVisibility(View.VISIBLE);
                    ctvP92_solventes.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_solventes.setVisibility(View.GONE);
                    ctvP90_solventes.setVisibility(View.GONE);
                    tvP91_solventes.setVisibility(View.GONE);
                    ctvP91_solventes.setVisibility(View.GONE);
                    tvP92_solventes.setVisibility(View.GONE);
                    ctvP92_solventes.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar consumo de cristal
                ctvP87.setText(listaSalud.get(pos).getE87());
                ctvP87.setChecked(true);
                ctvP87.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO87.setVisibility(View.GONE);
                etP87.setVisibility(View.GONE);
                etP87.setText("");

                ctvP90_cristal.setText(listaSalud.get(pos).getE90_cristal());
                ctvP90_cristal.setChecked(true);
                ctvP90_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_cristal.setVisibility(View.GONE);
                etP90_cristal.setVisibility(View.GONE);
                etP90_cristal.setText("");

                ctvP91_cristal.setText(listaSalud.get(pos).getE91_cristal());
                ctvP91_cristal.setChecked(true);
                ctvP91_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_cristal.setVisibility(View.GONE);
                etP91_cristal.setVisibility(View.GONE);
                etP91_cristal.setText("");

                ctvP92_cristal.setText(listaSalud.get(pos).getE92_cristal());
                ctvP92_cristal.setChecked(true);
                ctvP92_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_cristal.setVisibility(View.GONE);
                etP92_cristal.setVisibility(View.GONE);
                etP92_cristal.setText("");

                if(listaSalud.get(pos).getE89().equals("SI")) {
                    tvP90_cristal.setVisibility(View.VISIBLE);
                    ctvP90_cristal.setVisibility(View.VISIBLE);
                    tvP91_cristal.setVisibility(View.VISIBLE);
                    ctvP91_cristal.setVisibility(View.VISIBLE);
                    tvP92_cristal.setVisibility(View.VISIBLE);
                    ctvP92_cristal.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_cristal.setVisibility(View.GONE);
                    ctvP90_cristal.setVisibility(View.GONE);
                    tvP91_cristal.setVisibility(View.GONE);
                    ctvP91_cristal.setVisibility(View.GONE);
                    tvP92_cristal.setVisibility(View.GONE);
                    ctvP92_cristal.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostar consumo de cocaina
                ctvP88.setText(listaSalud.get(pos).getE88());
                ctvP88.setChecked(true);
                ctvP88.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO88.setVisibility(View.GONE);
                etP88.setVisibility(View.GONE);
                etP88.setText("");

                ctvP90_cocaina.setText(listaSalud.get(pos).getE90_cocaina());
                ctvP90_cocaina.setChecked(true);
                ctvP90_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_cocaina.setVisibility(View.GONE);
                etP90_cocaina.setVisibility(View.GONE);
                etP90_cocaina.setText("");

                ctvP91_cocaina.setText(listaSalud.get(pos).getE91_cocaina());
                ctvP91_cocaina.setChecked(true);
                ctvP91_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_cocaina.setVisibility(View.GONE);
                etP91_cocaina.setVisibility(View.GONE);
                etP91_cocaina.setText("");

                ctvP92_cocaina.setText(listaSalud.get(pos).getE92_cocaina());
                ctvP92_cocaina.setChecked(true);
                ctvP92_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_cocaina.setVisibility(View.GONE);
                etP92_cocaina.setVisibility(View.GONE);
                etP92_cocaina.setText("");

                if(listaSalud.get(pos).getE88().equals("SI")) {
                    tvP90_cocaina.setVisibility(View.VISIBLE);
                    ctvP90_cocaina.setVisibility(View.VISIBLE);
                    tvP91_cocaina.setVisibility(View.VISIBLE);
                    ctvP91_cocaina.setVisibility(View.VISIBLE);
                    tvP92_cocaina.setVisibility(View.VISIBLE);
                    ctvP92_cocaina.setVisibility(View.VISIBLE);
                }
                else{
                    tvP90_cocaina.setVisibility(View.GONE);
                    ctvP90_cocaina.setVisibility(View.GONE);
                    tvP91_cocaina.setVisibility(View.GONE);
                    ctvP91_cocaina.setVisibility(View.GONE);
                    tvP92_cocaina.setVisibility(View.GONE);
                    ctvP92_cocaina.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar otro consumo
                ctvP89.setText(listaSalud.get(pos).getE89());
                ctvP89.setChecked(true);
                ctvP89.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO89.setVisibility(View.GONE);
                etP89.setVisibility(View.GONE);
                etP89.setText("");

                ctvP93_otroConsumo.setText(listaSalud.get(pos).getE93_otroConsumo());
                ctvP93_otroConsumo.setChecked(true);
                ctvP93_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO93_otroConsumo.setVisibility(View.GONE);
                etP93_otroConsumo.setVisibility(View.GONE);
                etP93_otroConsumo.setText("");

                ctvP90_otroConsumo.setText(listaSalud.get(pos).getE90_otroConsumo());
                ctvP90_otroConsumo.setChecked(true);
                ctvP90_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO90_otroConsumo.setVisibility(View.GONE);
                etP90_otroConsumo.setVisibility(View.GONE);
                etP90_otroConsumo.setText("");

                ctvP91_otroConsumo.setText(listaSalud.get(pos).getE91_otroConsumo());
                ctvP91_otroConsumo.setChecked(true);
                ctvP91_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO91_otroConsumo.setVisibility(View.GONE);
                etP91_otroConsumo.setVisibility(View.GONE);
                etP91_otroConsumo.setText("");

                ctvP92_otroConsumo.setText(listaSalud.get(pos).getE92_otroConsumo());
                ctvP92_otroConsumo.setChecked(true);
                ctvP92_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO92_otroConsumo.setVisibility(View.GONE);
                etP92_otroConsumo.setVisibility(View.GONE);
                etP92_otroConsumo.setText("");

                if(listaSalud.get(pos).getE89().equals("SI")) {
                    tvP93_otroConsumo.setVisibility(View.VISIBLE);
                    ctvP93_otroConsumo.setVisibility(View.VISIBLE);
                    tvP90_otroConsumo.setVisibility(View.VISIBLE);
                    ctvP90_otroConsumo.setVisibility(View.VISIBLE);
                    tvP91_otroConsumo.setVisibility(View.VISIBLE);
                    ctvP91_otroConsumo.setVisibility(View.VISIBLE);
                    tvP92_otroConsumo.setVisibility(View.VISIBLE);
                    ctvP92_otroConsumo.setVisibility(View.VISIBLE);
                }
                else{
                    tvP93_otroConsumo.setVisibility(View.GONE);
                    ctvP93_otroConsumo.setVisibility(View.GONE);
                    tvP90_otroConsumo.setVisibility(View.GONE);
                    ctvP90_otroConsumo.setVisibility(View.GONE);
                    tvP91_otroConsumo.setVisibility(View.GONE);
                    ctvP91_otroConsumo.setVisibility(View.GONE);
                    tvP92_otroConsumo.setVisibility(View.GONE);
                    ctvP92_otroConsumo.setVisibility(View.GONE);
                }
                //endregion

                //region Esconder/mostrar enfermedad
                ctvP94.setText(listaSalud.get(pos).getE94());
                ctvP94.setChecked(true);
                ctvP94.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO94.setVisibility(View.GONE);
                etP94.setVisibility(View.GONE);
                etP94.setText("");

                ctvP95.setText(listaSalud.get(pos).getE95());
                ctvP95.setChecked(true);
                ctvP95.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvO95.setVisibility(View.GONE);
                etP95.setVisibility(View.GONE);
                etP95.setText("");

                if(listaSalud.get(pos).getE94().equals("SI")) {
                    tvP95.setVisibility(View.VISIBLE);
                    ctvP95.setVisibility(View.VISIBLE);
                }
                else{
                    tvP95.setVisibility(View.GONE);
                    ctvP95.setVisibility(View.GONE);
                }
                //endregion
                //endregion

                //region Checkbox click listeners
                ctvP1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP1.isChecked()) {
                            ctvP1.setChecked(false);
                            ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO1.setVisibility(View.VISIBLE);
                            etP1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP1.setChecked(true);
                            ctvP1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO1.setVisibility(View.GONE);
                            etP1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP1_1.isChecked()) {
                            ctvP1_1.setChecked(false);
                            ctvP1_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO1_1.setVisibility(View.VISIBLE);
                            etP1_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP1_1.setChecked(true);
                            ctvP1_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO1_1.setVisibility(View.GONE);
                            etP1_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP1_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP1_2.isChecked()) {
                            ctvP1_2.setChecked(false);
                            ctvP1_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO1_2.setVisibility(View.VISIBLE);
                            etP1_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP1_2.setChecked(true);
                            ctvP1_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO1_2.setVisibility(View.GONE);
                            etP1_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP2.isChecked()) {
                            ctvP2.setChecked(false);
                            ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO2.setVisibility(View.VISIBLE);
                            etP2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP2.setChecked(true);
                            ctvP2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO2.setVisibility(View.GONE);
                            etP2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP3.isChecked()) {
                            ctvP3.setChecked(false);
                            ctvP3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO3.setVisibility(View.VISIBLE);
                            etP3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP3.setChecked(true);
                            ctvP3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO3.setVisibility(View.GONE);
                            etP3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP4.isChecked()) {
                            ctvP4.setChecked(false);
                            ctvP4.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO4.setVisibility(View.VISIBLE);
                            etP4.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP4.setChecked(true);
                            ctvP4.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO4.setVisibility(View.GONE);
                            etP4.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP5.isChecked()) {
                            ctvP5.setChecked(false);
                            ctvP5.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO5.setVisibility(View.VISIBLE);
                            etP5.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP5.setChecked(true);
                            ctvP5.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO5.setVisibility(View.GONE);
                            etP5.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP6.isChecked()) {
                            ctvP6.setChecked(false);
                            ctvP6.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO6.setVisibility(View.VISIBLE);
                            etP6.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP6.setChecked(true);
                            ctvP6.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO6.setVisibility(View.GONE);
                            etP6.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP7.isChecked()) {
                            ctvP7.setChecked(false);
                            ctvP7.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO7.setVisibility(View.VISIBLE);
                            etP7.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP7.setChecked(true);
                            ctvP7.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO7.setVisibility(View.GONE);
                            etP7.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP7_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP7_1.isChecked()) {
                            ctvP7_1.setChecked(false);
                            ctvP7_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO7_1.setVisibility(View.VISIBLE);
                            etP7_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP7_1.setChecked(true);
                            ctvP7_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO7_1.setVisibility(View.GONE);
                            etP7_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP8.isChecked()) {
                            ctvP8.setChecked(false);
                            ctvP8.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO8.setVisibility(View.VISIBLE);
                            etP8.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP8.setChecked(true);
                            ctvP8.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO8.setVisibility(View.GONE);
                            etP8.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP9.isChecked()) {
                            ctvP9.setChecked(false);
                            ctvP9.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO9.setVisibility(View.VISIBLE);
                            etP9.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP9.setChecked(true);
                            ctvP9.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO9.setVisibility(View.GONE);
                            etP9.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP10.isChecked()) {
                            ctvP10.setChecked(false);
                            ctvP10.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO10.setVisibility(View.VISIBLE);
                            etP10.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP10.setChecked(true);
                            ctvP10.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO10.setVisibility(View.GONE);
                            etP10.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP11.isChecked()) {
                            ctvP11.setChecked(false);
                            ctvP11.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO11.setVisibility(View.VISIBLE);
                            etP11.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP11.setChecked(true);
                            ctvP11.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO11.setVisibility(View.GONE);
                            etP11.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP12.isChecked()) {
                            ctvP12.setChecked(false);
                            ctvP12.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO12.setVisibility(View.VISIBLE);
                            etP12.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP12.setChecked(true);
                            ctvP12.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO12.setVisibility(View.GONE);
                            etP12.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP13.isChecked()) {
                            ctvP13.setChecked(false);
                            ctvP13.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO13.setVisibility(View.VISIBLE);
                            etP13.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP13.setChecked(true);
                            ctvP13.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO13.setVisibility(View.GONE);
                            etP13.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP14.isChecked()) {
                            ctvP14.setChecked(false);
                            ctvP14.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO14.setVisibility(View.VISIBLE);
                            etP14.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP14.setChecked(true);
                            ctvP14.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO14.setVisibility(View.GONE);
                            etP14.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP15.isChecked()) {
                            ctvP15.setChecked(false);
                            ctvP15.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO15.setVisibility(View.VISIBLE);
                            etP15.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP15.setChecked(true);
                            ctvP15.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO15.setVisibility(View.GONE);
                            etP15.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP16.isChecked()) {
                            ctvP16.setChecked(false);
                            ctvP16.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO16.setVisibility(View.VISIBLE);
                            etP16.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP16.setChecked(true);
                            ctvP16.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO16.setVisibility(View.GONE);
                            etP16.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP32_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP32_1.isChecked()) {
                            ctvP32_1.setChecked(false);
                            ctvP32_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO32_1.setVisibility(View.VISIBLE);
                            etP32_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP32_1.setChecked(true);
                            ctvP32_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO32_1.setVisibility(View.GONE);
                            etP32_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP17.isChecked()) {
                            ctvP17.setChecked(false);
                            ctvP17.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO17.setVisibility(View.VISIBLE);
                            etP17.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP17.setChecked(true);
                            ctvP17.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO17.setVisibility(View.GONE);
                            etP17.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP18.isChecked()) {
                            ctvP18.setChecked(false);
                            ctvP18.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO18.setVisibility(View.VISIBLE);
                            etP18.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP18.setChecked(true);
                            ctvP18.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO18.setVisibility(View.GONE);
                            etP18.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP19.isChecked()) {
                            ctvP19.setChecked(false);
                            ctvP19.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO19.setVisibility(View.VISIBLE);
                            etP19.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP19.setChecked(true);
                            ctvP19.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO19.setVisibility(View.GONE);
                            etP19.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP20.isChecked()) {
                            ctvP20.setChecked(false);
                            ctvP20.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO20.setVisibility(View.VISIBLE);
                            etP20.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP20.setChecked(true);
                            ctvP20.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO20.setVisibility(View.GONE);
                            etP20.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP21_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP21_1.isChecked()) {
                            ctvP21_1.setChecked(false);
                            ctvP21_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO21_1.setVisibility(View.VISIBLE);
                            etP21_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP21_1.setChecked(true);
                            ctvP21_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO21_1.setVisibility(View.GONE);
                            etP21_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP21.isChecked()) {
                            ctvP21.setChecked(false);
                            ctvP21.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO21.setVisibility(View.VISIBLE);
                            etP21.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP21.setChecked(true);
                            ctvP21.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO21.setVisibility(View.GONE);
                            etP21.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP22.isChecked()) {
                            ctvP22.setChecked(false);
                            ctvP22.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO22.setVisibility(View.VISIBLE);
                            etP22.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP22.setChecked(true);
                            ctvP22.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO22.setVisibility(View.GONE);
                            etP22.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP23.isChecked()) {
                            ctvP23.setChecked(false);
                            ctvP23.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO23.setVisibility(View.VISIBLE);
                            etP23.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP23.setChecked(true);
                            ctvP23.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO23.setVisibility(View.GONE);
                            etP23.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP24.isChecked()) {
                            ctvP24.setChecked(false);
                            ctvP24.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO24.setVisibility(View.VISIBLE);
                            etP24.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP24.setChecked(true);
                            ctvP24.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO24.setVisibility(View.GONE);
                            etP24.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP25.isChecked()) {
                            ctvP25.setChecked(false);
                            ctvP25.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO25.setVisibility(View.VISIBLE);
                            etP25.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP25.setChecked(true);
                            ctvP25.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO25.setVisibility(View.GONE);
                            etP25.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP26.isChecked()) {
                            ctvP26.setChecked(false);
                            ctvP26.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO26.setVisibility(View.VISIBLE);
                            etP26.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP26.setChecked(true);
                            ctvP26.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO26.setVisibility(View.GONE);
                            etP26.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP27.isChecked()) {
                            ctvP27.setChecked(false);
                            ctvP27.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO27.setVisibility(View.VISIBLE);
                            etP27.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP27.setChecked(true);
                            ctvP27.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO27.setVisibility(View.GONE);
                            etP27.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP28.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP28.isChecked()) {
                            ctvP28.setChecked(false);
                            ctvP28.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO28.setVisibility(View.VISIBLE);
                            etP28.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP28.setChecked(true);
                            ctvP28.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO28.setVisibility(View.GONE);
                            etP28.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP101.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP101.isChecked()) {
                            ctvP101.setChecked(false);
                            ctvP101.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO101.setVisibility(View.VISIBLE);
                            etP101.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP101.setChecked(true);
                            ctvP101.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO101.setVisibility(View.GONE);
                            etP101.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP102.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP102.isChecked()) {
                            ctvP102.setChecked(false);
                            ctvP102.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO102.setVisibility(View.VISIBLE);
                            etP102.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP102.setChecked(true);
                            ctvP102.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO102.setVisibility(View.GONE);
                            etP102.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP103.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP103.isChecked()) {
                            ctvP103.setChecked(false);
                            ctvP103.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO103.setVisibility(View.VISIBLE);
                            etP103.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP103.setChecked(true);
                            ctvP103.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO103.setVisibility(View.GONE);
                            etP103.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP104.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP104.isChecked()) {
                            ctvP104.setChecked(false);
                            ctvP104.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO104.setVisibility(View.VISIBLE);
                            etP104.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP104.setChecked(true);
                            ctvP104.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO104.setVisibility(View.GONE);
                            etP104.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP105.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP105.isChecked()) {
                            ctvP105.setChecked(false);
                            ctvP105.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO105.setVisibility(View.VISIBLE);
                            etP105.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP105.setChecked(true);
                            ctvP105.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO105.setVisibility(View.GONE);
                            etP105.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP29.isChecked()) {
                            ctvP29.setChecked(false);
                            ctvP29.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO29.setVisibility(View.VISIBLE);
                            etP29.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP29.setChecked(true);
                            ctvP29.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO29.setVisibility(View.GONE);
                            etP29.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP30.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP30.isChecked()) {
                            ctvP30.setChecked(false);
                            ctvP30.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO30.setVisibility(View.VISIBLE);
                            etP30.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP30.setChecked(true);
                            ctvP30.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO30.setVisibility(View.GONE);
                            etP30.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP31.isChecked()) {
                            ctvP31.setChecked(false);
                            ctvP31.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO31.setVisibility(View.VISIBLE);
                            etP31.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP31.setChecked(true);
                            ctvP31.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO31.setVisibility(View.GONE);
                            etP31.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP31_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP31_1.isChecked()) {
                            ctvP31_1.setChecked(false);
                            ctvP31_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO31_1.setVisibility(View.VISIBLE);
                            etP31_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP31_1.setChecked(true);
                            ctvP31_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO31_1.setVisibility(View.GONE);
                            etP31_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP31_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP31_2.isChecked()) {
                            ctvP31_2.setChecked(false);
                            ctvP31_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO31_2.setVisibility(View.VISIBLE);
                            etP31_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP31_2.setChecked(true);
                            ctvP31_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO31_2.setVisibility(View.GONE);
                            etP31_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP32.isChecked()) {
                            ctvP32.setChecked(false);
                            ctvP32.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO32.setVisibility(View.VISIBLE);
                            etP32.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP32.setChecked(true);
                            ctvP32.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO32.setVisibility(View.GONE);
                            etP32.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP33.isChecked()) {
                            ctvP33.setChecked(false);
                            ctvP33.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO33.setVisibility(View.VISIBLE);
                            etP33.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP33.setChecked(true);
                            ctvP33.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO33.setVisibility(View.GONE);
                            etP33.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP34.isChecked()) {
                            ctvP34.setChecked(false);
                            ctvP34.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO34.setVisibility(View.VISIBLE);
                            etP34.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP34.setChecked(true);
                            ctvP34.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO34.setVisibility(View.GONE);
                            etP34.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP35.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP35.isChecked()) {
                            ctvP35.setChecked(false);
                            ctvP35.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO35.setVisibility(View.VISIBLE);
                            etP35.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP35.setChecked(true);
                            ctvP35.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO35.setVisibility(View.GONE);
                            etP35.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP36.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP36.isChecked()) {
                            ctvP36.setChecked(false);
                            ctvP36.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO36.setVisibility(View.VISIBLE);
                            etP36.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP36.setChecked(true);
                            ctvP36.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO36.setVisibility(View.GONE);
                            etP36.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP37.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP37.isChecked()) {
                            ctvP37.setChecked(false);
                            ctvP37.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO37.setVisibility(View.VISIBLE);
                            etP37.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP37.setChecked(true);
                            ctvP37.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO37.setVisibility(View.GONE);
                            etP37.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP33_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP33_1.isChecked()) {
                            ctvP33_1.setChecked(false);
                            ctvP33_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO33_1.setVisibility(View.VISIBLE);
                            etP33_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP33_1.setChecked(true);
                            ctvP33_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO33_1.setVisibility(View.GONE);
                            etP33_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP34_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP34_1.isChecked()) {
                            ctvP34_1.setChecked(false);
                            ctvP34_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO34_1.setVisibility(View.VISIBLE);
                            etP34_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP34_1.setChecked(true);
                            ctvP34_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO34_1.setVisibility(View.GONE);
                            etP34_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP35_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP35_1.isChecked()) {
                            ctvP35_1.setChecked(false);
                            ctvP35_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO35_1.setVisibility(View.VISIBLE);
                            etP35_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP35_1.setChecked(true);
                            ctvP35_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO35_1.setVisibility(View.GONE);
                            etP35_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP36_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP36_1.isChecked()) {
                            ctvP36_1.setChecked(false);
                            ctvP36_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO36_1.setVisibility(View.VISIBLE);
                            etP36_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP36_1.setChecked(true);
                            ctvP36_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO36_1.setVisibility(View.GONE);
                            etP36_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP37_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP37_1.isChecked()) {
                            ctvP37_1.setChecked(false);
                            ctvP37_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO37_1.setVisibility(View.VISIBLE);
                            etP37_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP37_1.setChecked(true);
                            ctvP37_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO37_1.setVisibility(View.GONE);
                            etP37_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP33_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP33_2.isChecked()) {
                            ctvP33_2.setChecked(false);
                            ctvP33_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO33_2.setVisibility(View.VISIBLE);
                            etP33_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP33_2.setChecked(true);
                            ctvP33_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO33_2.setVisibility(View.GONE);
                            etP33_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP34_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP34_2.isChecked()) {
                            ctvP34_2.setChecked(false);
                            ctvP34_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO34_2.setVisibility(View.VISIBLE);
                            etP34_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP34_2.setChecked(true);
                            ctvP34_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO34_2.setVisibility(View.GONE);
                            etP34_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP35_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP35_2.isChecked()) {
                            ctvP35_2.setChecked(false);
                            ctvP35_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO35_2.setVisibility(View.VISIBLE);
                            etP35_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP35_2.setChecked(true);
                            ctvP35_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO35_2.setVisibility(View.GONE);
                            etP35_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP36_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP36_2.isChecked()) {
                            ctvP36_2.setChecked(false);
                            ctvP36_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO36_2.setVisibility(View.VISIBLE);
                            etP36_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP36_2.setChecked(true);
                            ctvP36_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO36_2.setVisibility(View.GONE);
                            etP36_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP37_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP37_2.isChecked()) {
                            ctvP37_2.setChecked(false);
                            ctvP37_2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO37_2.setVisibility(View.VISIBLE);
                            etP37_2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP37_2.setChecked(true);
                            ctvP37_2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO37_2.setVisibility(View.GONE);
                            etP37_2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP33_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP33_3.isChecked()) {
                            ctvP33_3.setChecked(false);
                            ctvP33_3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO33_3.setVisibility(View.VISIBLE);
                            etP33_3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP33_3.setChecked(true);
                            ctvP33_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO33_3.setVisibility(View.GONE);
                            etP33_3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP34_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP34_3.isChecked()) {
                            ctvP34_3.setChecked(false);
                            ctvP34_3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO34_3.setVisibility(View.VISIBLE);
                            etP34_3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP34_3.setChecked(true);
                            ctvP34_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO34_3.setVisibility(View.GONE);
                            etP34_3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP35_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP35_3.isChecked()) {
                            ctvP35_3.setChecked(false);
                            ctvP35_3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO35_3.setVisibility(View.VISIBLE);
                            etP35_3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP35_3.setChecked(true);
                            ctvP35_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO35_3.setVisibility(View.GONE);
                            etP35_3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP36_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP36_3.isChecked()) {
                            ctvP36_3.setChecked(false);
                            ctvP36_3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO36_3.setVisibility(View.VISIBLE);
                            etP36_3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP36_3.setChecked(true);
                            ctvP36_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO36_3.setVisibility(View.GONE);
                            etP36_3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP37_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP37_3.isChecked()) {
                            ctvP37_3.setChecked(false);
                            ctvP37_3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO37_3.setVisibility(View.VISIBLE);
                            etP37_3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP37_3.setChecked(true);
                            ctvP37_3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO37_3.setVisibility(View.GONE);
                            etP37_3.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP38.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP38.isChecked()) {
                            ctvP38.setChecked(false);
                            ctvP38.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO38.setVisibility(View.VISIBLE);
                            etP38.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP38.setChecked(true);
                            ctvP38.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO38.setVisibility(View.GONE);
                            etP38.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP39.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP39.isChecked()) {
                            ctvP39.setChecked(false);
                            ctvP39.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO39.setVisibility(View.VISIBLE);
                            etP39.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP39.setChecked(true);
                            ctvP39.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO39.setVisibility(View.GONE);
                            etP39.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP40.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP40.isChecked()) {
                            ctvP40.setChecked(false);
                            ctvP40.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO40.setVisibility(View.VISIBLE);
                            etP40.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP40.setChecked(true);
                            ctvP40.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO40.setVisibility(View.GONE);
                            etP40.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP41.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP41.isChecked()) {
                            ctvP41.setChecked(false);
                            ctvP41.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO41.setVisibility(View.VISIBLE);
                            etP41.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP41.setChecked(true);
                            ctvP41.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO41.setVisibility(View.GONE);
                            etP41.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP42.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP42.isChecked()) {
                            ctvP42.setChecked(false);
                            ctvP42.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO42.setVisibility(View.VISIBLE);
                            etP42.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP42.setChecked(true);
                            ctvP42.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO42.setVisibility(View.GONE);
                            etP42.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP43.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP43.isChecked()) {
                            ctvP43.setChecked(false);
                            ctvP43.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO43.setVisibility(View.VISIBLE);
                            etP43.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP43.setChecked(true);
                            ctvP43.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO43.setVisibility(View.GONE);
                            etP43.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP39_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP39_1.isChecked()) {
                            ctvP39_1.setChecked(false);
                            ctvP39_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO39_1.setVisibility(View.VISIBLE);
                            etP39_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP39_1.setChecked(true);
                            ctvP39_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO39_1.setVisibility(View.GONE);
                            etP39_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP40_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP40_1.isChecked()) {
                            ctvP40_1.setChecked(false);
                            ctvP40_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO40_1.setVisibility(View.VISIBLE);
                            etP40_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP40_1.setChecked(true);
                            ctvP40_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO40_1.setVisibility(View.GONE);
                            etP40_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP41_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP41_1.isChecked()) {
                            ctvP41_1.setChecked(false);
                            ctvP41_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO41_1.setVisibility(View.VISIBLE);
                            etP41_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP41_1.setChecked(true);
                            ctvP41_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO41_1.setVisibility(View.GONE);
                            etP41_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP42_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP42_1.isChecked()) {
                            ctvP42_1.setChecked(false);
                            ctvP42_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO42_1.setVisibility(View.VISIBLE);
                            etP42_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP42_1.setChecked(true);
                            ctvP42_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO42_1.setVisibility(View.GONE);
                            etP42_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP43_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP43_1.isChecked()) {
                            ctvP43_1.setChecked(false);
                            ctvP43_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO43_1.setVisibility(View.VISIBLE);
                            etP43_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP43_1.setChecked(true);
                            ctvP43_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO43_1.setVisibility(View.GONE);
                            etP43_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP44.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP44.isChecked()) {
                            ctvP44.setChecked(false);
                            ctvP44.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO44.setVisibility(View.VISIBLE);
                            etP44.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP44.setChecked(true);
                            ctvP44.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO44.setVisibility(View.GONE);
                            etP44.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP45.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP45.isChecked()) {
                            ctvP45.setChecked(false);
                            ctvP45.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO45.setVisibility(View.VISIBLE);
                            etP45.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP45.setChecked(true);
                            ctvP45.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO45.setVisibility(View.GONE);
                            etP45.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP46.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP46.isChecked()) {
                            ctvP46.setChecked(false);
                            ctvP46.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO46.setVisibility(View.VISIBLE);
                            etP46.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP46.setChecked(true);
                            ctvP46.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO46.setVisibility(View.GONE);
                            etP46.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP47.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP47.isChecked()) {
                            ctvP47.setChecked(false);
                            ctvP47.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO47.setVisibility(View.VISIBLE);
                            etP47.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP47.setChecked(true);
                            ctvP47.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO47.setVisibility(View.GONE);
                            etP47.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP48.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP48.isChecked()) {
                            ctvP48.setChecked(false);
                            ctvP48.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO48.setVisibility(View.VISIBLE);
                            etP48.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP48.setChecked(true);
                            ctvP48.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO48.setVisibility(View.GONE);
                            etP48.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP49.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP49.isChecked()) {
                            ctvP49.setChecked(false);
                            ctvP49.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO49.setVisibility(View.VISIBLE);
                            etP49.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP49.setChecked(true);
                            ctvP49.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO49.setVisibility(View.GONE);
                            etP49.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP50.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP50.isChecked()) {
                            ctvP50.setChecked(false);
                            ctvP50.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO50.setVisibility(View.VISIBLE);
                            etP50.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP50.setChecked(true);
                            ctvP50.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO50.setVisibility(View.GONE);
                            etP50.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP51.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP51.isChecked()) {
                            ctvP51.setChecked(false);
                            ctvP51.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO51.setVisibility(View.VISIBLE);
                            etP51.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP51.setChecked(true);
                            ctvP51.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO51.setVisibility(View.GONE);
                            etP51.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP52.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP52.isChecked()) {
                            ctvP52.setChecked(false);
                            ctvP52.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO52.setVisibility(View.VISIBLE);
                            etP52.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP52.setChecked(true);
                            ctvP52.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO52.setVisibility(View.GONE);
                            etP52.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP53.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP53.isChecked()) {
                            ctvP53.setChecked(false);
                            ctvP53.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO53.setVisibility(View.VISIBLE);
                            etP53.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP53.setChecked(true);
                            ctvP53.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO53.setVisibility(View.GONE);
                            etP53.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP54.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP54.isChecked()) {
                            ctvP54.setChecked(false);
                            ctvP54.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO54.setVisibility(View.VISIBLE);
                            etP54.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP54.setChecked(true);
                            ctvP54.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO54.setVisibility(View.GONE);
                            etP54.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP55.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP55.isChecked()) {
                            ctvP55.setChecked(false);
                            ctvP55.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO55.setVisibility(View.VISIBLE);
                            etP55.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP55.setChecked(true);
                            ctvP55.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO55.setVisibility(View.GONE);
                            etP55.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP57.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP57.isChecked()) {
                            ctvP57.setChecked(false);
                            ctvP57.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO57.setVisibility(View.VISIBLE);
                            etP57.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP57.setChecked(true);
                            ctvP57.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO57.setVisibility(View.GONE);
                            etP57.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP56.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP56.isChecked()) {
                            ctvP56.setChecked(false);
                            ctvP56.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO56.setVisibility(View.VISIBLE);
                            etP56.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP56.setChecked(true);
                            ctvP56.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO56.setVisibility(View.GONE);
                            etP56.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP58.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP58.isChecked()) {
                            ctvP58.setChecked(false);
                            ctvP58.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO58.setVisibility(View.VISIBLE);
                            etP58.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP58.setChecked(true);
                            ctvP58.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO58.setVisibility(View.GONE);
                            etP58.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP51_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP51_1.isChecked()) {
                            ctvP51_1.setChecked(false);
                            ctvP51_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO51_1.setVisibility(View.VISIBLE);
                            etP51_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP51_1.setChecked(true);
                            ctvP51_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO51_1.setVisibility(View.GONE);
                            etP51_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP59.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP59.isChecked()) {
                            ctvP59.setChecked(false);
                            ctvP59.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO59.setVisibility(View.VISIBLE);
                            etP59.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP59.setChecked(true);
                            ctvP59.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO59.setVisibility(View.GONE);
                            etP59.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP60.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP60.isChecked()) {
                            ctvP60.setChecked(false);
                            ctvP60.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO60.setVisibility(View.VISIBLE);
                            etP60.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP60.setChecked(true);
                            ctvP60.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO60.setVisibility(View.GONE);
                            etP60.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP61.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP61.isChecked()) {
                            ctvP61.setChecked(false);
                            ctvP61.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO61.setVisibility(View.VISIBLE);
                            etP61.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP61.setChecked(true);
                            ctvP61.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO61.setVisibility(View.GONE);
                            etP61.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP62.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP62.isChecked()) {
                            ctvP62.setChecked(false);
                            ctvP62.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO62.setVisibility(View.VISIBLE);
                            etP62.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP62.setChecked(true);
                            ctvP62.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO62.setVisibility(View.GONE);
                            etP62.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP63.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP63.isChecked()) {
                            ctvP63.setChecked(false);
                            ctvP63.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO63.setVisibility(View.VISIBLE);
                            etP63.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP63.setChecked(true);
                            ctvP63.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO63.setVisibility(View.GONE);
                            etP63.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP64.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP64.isChecked()) {
                            ctvP64.setChecked(false);
                            ctvP64.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO64.setVisibility(View.VISIBLE);
                            etP64.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP64.setChecked(true);
                            ctvP64.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO64.setVisibility(View.GONE);
                            etP64.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP65.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP65.isChecked()) {
                            ctvP65.setChecked(false);
                            ctvP65.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO65.setVisibility(View.VISIBLE);
                            etP65.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP65.setChecked(true);
                            ctvP65.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO65.setVisibility(View.GONE);
                            etP65.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP66.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP66.isChecked()) {
                            ctvP66.setChecked(false);
                            ctvP66.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO66.setVisibility(View.VISIBLE);
                            etP66.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP66.setChecked(true);
                            ctvP66.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO66.setVisibility(View.GONE);
                            etP66.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP67.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP67.isChecked()) {
                            ctvP67.setChecked(false);
                            ctvP67.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO67.setVisibility(View.VISIBLE);
                            etP67.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP67.setChecked(true);
                            ctvP67.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO67.setVisibility(View.GONE);
                            etP67.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP68.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP68.isChecked()) {
                            ctvP68.setChecked(false);
                            ctvP68.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO68.setVisibility(View.VISIBLE);
                            etP68.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP68.setChecked(true);
                            ctvP68.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO68.setVisibility(View.GONE);
                            etP68.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP69.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP69.isChecked()) {
                            ctvP69.setChecked(false);
                            ctvP69.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO69.setVisibility(View.VISIBLE);
                            etP69.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP69.setChecked(true);
                            ctvP69.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO69.setVisibility(View.GONE);
                            etP69.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP70.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP70.isChecked()) {
                            ctvP70.setChecked(false);
                            ctvP70.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO70.setVisibility(View.VISIBLE);
                            etP70.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP70.setChecked(true);
                            ctvP70.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO70.setVisibility(View.GONE);
                            etP70.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP71.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP71.isChecked()) {
                            ctvP71.setChecked(false);
                            ctvP71.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO71.setVisibility(View.VISIBLE);
                            etP71.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP71.setChecked(true);
                            ctvP71.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO71.setVisibility(View.GONE);
                            etP71.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP72.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP72.isChecked()) {
                            ctvP72.setChecked(false);
                            ctvP72.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO72.setVisibility(View.VISIBLE);
                            etP72.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP72.setChecked(true);
                            ctvP72.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO72.setVisibility(View.GONE);
                            etP72.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP67_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP67_1.isChecked()) {
                            ctvP67_1.setChecked(false);
                            ctvP67_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO67_1.setVisibility(View.VISIBLE);
                            etP67_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP67_1.setChecked(true);
                            ctvP67_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO67_1.setVisibility(View.GONE);
                            etP67_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP68_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP68_1.isChecked()) {
                            ctvP68_1.setChecked(false);
                            ctvP68_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO68_1.setVisibility(View.VISIBLE);
                            etP68_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP68_1.setChecked(true);
                            ctvP68_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO68_1.setVisibility(View.GONE);
                            etP68_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP69_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP69_1.isChecked()) {
                            ctvP69_1.setChecked(false);
                            ctvP69_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO69_1.setVisibility(View.VISIBLE);
                            etP69_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP69_1.setChecked(true);
                            ctvP69_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO69_1.setVisibility(View.GONE);
                            etP69_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP70_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP70_1.isChecked()) {
                            ctvP70_1.setChecked(false);
                            ctvP70_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO70_1.setVisibility(View.VISIBLE);
                            etP70_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP70_1.setChecked(true);
                            ctvP70_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO70_1.setVisibility(View.GONE);
                            etP70_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP71_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP71_1.isChecked()) {
                            ctvP71_1.setChecked(false);
                            ctvP71_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO71_1.setVisibility(View.VISIBLE);
                            etP71_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP71_1.setChecked(true);
                            ctvP71_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO71_1.setVisibility(View.GONE);
                            etP71_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP72_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP72_1.isChecked()) {
                            ctvP72_1.setChecked(false);
                            ctvP72_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO72_1.setVisibility(View.VISIBLE);
                            etP72_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP72_1.setChecked(true);
                            ctvP72_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO72_1.setVisibility(View.GONE);
                            etP72_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP73.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP73.isChecked()) {
                            ctvP73.setChecked(false);
                            ctvP73.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO73.setVisibility(View.VISIBLE);
                            etP73.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP73.setChecked(true);
                            ctvP73.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO73.setVisibility(View.GONE);
                            etP73.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP74.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP74.isChecked()) {
                            ctvP74.setChecked(false);
                            ctvP74.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO74.setVisibility(View.VISIBLE);
                            etP74.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP74.setChecked(true);
                            ctvP74.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO74.setVisibility(View.GONE);
                            etP74.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP75.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP75.isChecked()) {
                            ctvP75.setChecked(false);
                            ctvP75.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO75.setVisibility(View.VISIBLE);
                            etP75.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP75.setChecked(true);
                            ctvP75.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO75.setVisibility(View.GONE);
                            etP75.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP76.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP76.isChecked()) {
                            ctvP76.setChecked(false);
                            ctvP76.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO76.setVisibility(View.VISIBLE);
                            etP76.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP76.setChecked(true);
                            ctvP76.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO76.setVisibility(View.GONE);
                            etP76.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP77.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP77.isChecked()) {
                            ctvP77.setChecked(false);
                            ctvP77.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO77.setVisibility(View.VISIBLE);
                            etP77.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP77.setChecked(true);
                            ctvP77.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO77.setVisibility(View.GONE);
                            etP77.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP78.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP78.isChecked()) {
                            ctvP78.setChecked(false);
                            ctvP78.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO78.setVisibility(View.VISIBLE);
                            etP78.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP78.setChecked(true);
                            ctvP78.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO78.setVisibility(View.GONE);
                            etP78.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP74_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP74_1.isChecked()) {
                            ctvP74_1.setChecked(false);
                            ctvP74_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO74_1.setVisibility(View.VISIBLE);
                            etP74_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP74_1.setChecked(true);
                            ctvP74_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO74_1.setVisibility(View.GONE);
                            etP74_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP75_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP75_1.isChecked()) {
                            ctvP75_1.setChecked(false);
                            ctvP75_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO75_1.setVisibility(View.VISIBLE);
                            etP75_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP75_1.setChecked(true);
                            ctvP75_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO75_1.setVisibility(View.GONE);
                            etP75_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP76_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP76_1.isChecked()) {
                            ctvP76_1.setChecked(false);
                            ctvP76_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO76_1.setVisibility(View.VISIBLE);
                            etP76_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP76_1.setChecked(true);
                            ctvP76_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO76_1.setVisibility(View.GONE);
                            etP76_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP77_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP77_1.isChecked()) {
                            ctvP77_1.setChecked(false);
                            ctvP77_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO77_1.setVisibility(View.VISIBLE);
                            etP77_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP77_1.setChecked(true);
                            ctvP77_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO77_1.setVisibility(View.GONE);
                            etP77_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP78_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP78_1.isChecked()) {
                            ctvP78_1.setChecked(false);
                            ctvP78_1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO78_1.setVisibility(View.VISIBLE);
                            etP78_1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP78_1.setChecked(true);
                            ctvP78_1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO78_1.setVisibility(View.GONE);
                            etP78_1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP79.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP79.isChecked()) {
                            ctvP79.setChecked(false);
                            ctvP79.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO79.setVisibility(View.VISIBLE);
                            etP79.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP79.setChecked(true);
                            ctvP79.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO79.setVisibility(View.GONE);
                            etP79.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP80.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP80.isChecked()) {
                            ctvP80.setChecked(false);
                            ctvP80.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO80.setVisibility(View.VISIBLE);
                            etP80.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP80.setChecked(true);
                            ctvP80.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO80.setVisibility(View.GONE);
                            etP80.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP81.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP81.isChecked()) {
                            ctvP81.setChecked(false);
                            ctvP81.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO81.setVisibility(View.VISIBLE);
                            etP81.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP81.setChecked(true);
                            ctvP81.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO81.setVisibility(View.GONE);
                            etP81.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP82.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP82.isChecked()) {
                            ctvP82.setChecked(false);
                            ctvP82.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO82.setVisibility(View.VISIBLE);
                            etP82.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP82.setChecked(true);
                            ctvP82.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO82.setVisibility(View.GONE);
                            etP82.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_alcohol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_alcohol.isChecked()) {
                            ctvP90_alcohol.setChecked(false);
                            ctvP90_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_alcohol.setVisibility(View.VISIBLE);
                            etP90_alcohol.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_alcohol.setChecked(true);
                            ctvP90_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_alcohol.setVisibility(View.GONE);
                            etP90_alcohol.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_alcohol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_alcohol.isChecked()) {
                            ctvP91_alcohol.setChecked(false);
                            ctvP91_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_alcohol.setVisibility(View.VISIBLE);
                            etP91_alcohol.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_alcohol.setChecked(true);
                            ctvP91_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_alcohol.setVisibility(View.GONE);
                            etP91_alcohol.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_alcohol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_alcohol.isChecked()) {
                            ctvP92_alcohol.setChecked(false);
                            ctvP92_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_alcohol.setVisibility(View.VISIBLE);
                            etP92_alcohol.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_alcohol.setChecked(true);
                            ctvP92_alcohol.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_alcohol.setVisibility(View.GONE);
                            etP92_alcohol.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP83.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP83.isChecked()) {
                            ctvP83.setChecked(false);
                            ctvP83.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO83.setVisibility(View.VISIBLE);
                            etP83.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP83.setChecked(true);
                            ctvP83.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO83.setVisibility(View.GONE);
                            etP83.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_tabaco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_tabaco.isChecked()) {
                            ctvP90_tabaco.setChecked(false);
                            ctvP90_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_tabaco.setVisibility(View.VISIBLE);
                            etP90_tabaco.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_tabaco.setChecked(true);
                            ctvP90_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_tabaco.setVisibility(View.GONE);
                            etP90_tabaco.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_tabaco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_tabaco.isChecked()) {
                            ctvP91_tabaco.setChecked(false);
                            ctvP91_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_tabaco.setVisibility(View.VISIBLE);
                            etP91_tabaco.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_tabaco.setChecked(true);
                            ctvP91_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_tabaco.setVisibility(View.GONE);
                            etP91_tabaco.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_tabaco.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_tabaco.isChecked()) {
                            ctvP92_tabaco.setChecked(false);
                            ctvP92_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_tabaco.setVisibility(View.VISIBLE);
                            etP92_tabaco.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_tabaco.setChecked(true);
                            ctvP92_tabaco.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_tabaco.setVisibility(View.GONE);
                            etP92_tabaco.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP84.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP84.isChecked()) {
                            ctvP84.setChecked(false);
                            ctvP84.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO84.setVisibility(View.VISIBLE);
                            etP84.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP84.setChecked(true);
                            ctvP84.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO84.setVisibility(View.GONE);
                            etP84.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_marihuana.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_marihuana.isChecked()) {
                            ctvP90_marihuana.setChecked(false);
                            ctvP90_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_marihuana.setVisibility(View.VISIBLE);
                            etP90_marihuana.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_marihuana.setChecked(true);
                            ctvP90_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_marihuana.setVisibility(View.GONE);
                            etP90_marihuana.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_marihuana.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_marihuana.isChecked()) {
                            ctvP91_marihuana.setChecked(false);
                            ctvP91_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_marihuana.setVisibility(View.VISIBLE);
                            etP91_marihuana.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_marihuana.setChecked(true);
                            ctvP91_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_marihuana.setVisibility(View.GONE);
                            etP91_marihuana.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_marihuana.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_marihuana.isChecked()) {
                            ctvP92_marihuana.setChecked(false);
                            ctvP92_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_marihuana.setVisibility(View.VISIBLE);
                            etP92_marihuana.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_marihuana.setChecked(true);
                            ctvP92_marihuana.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_marihuana.setVisibility(View.GONE);
                            etP92_marihuana.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP85.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP85.isChecked()) {
                            ctvP85.setChecked(false);
                            ctvP85.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO85.setVisibility(View.VISIBLE);
                            etP85.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP85.setChecked(true);
                            ctvP85.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO85.setVisibility(View.GONE);
                            etP85.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_pastillas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_pastillas.isChecked()) {
                            ctvP90_pastillas.setChecked(false);
                            ctvP90_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_pastillas.setVisibility(View.VISIBLE);
                            etP90_pastillas.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_pastillas.setChecked(true);
                            ctvP90_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_pastillas.setVisibility(View.GONE);
                            etP90_pastillas.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_pastillas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_pastillas.isChecked()) {
                            ctvP91_pastillas.setChecked(false);
                            ctvP91_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_pastillas.setVisibility(View.VISIBLE);
                            etP91_pastillas.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_pastillas.setChecked(true);
                            ctvP91_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_pastillas.setVisibility(View.GONE);
                            etP91_pastillas.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_pastillas.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_pastillas.isChecked()) {
                            ctvP92_pastillas.setChecked(false);
                            ctvP92_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_pastillas.setVisibility(View.VISIBLE);
                            etP92_pastillas.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_pastillas.setChecked(true);
                            ctvP92_pastillas.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_pastillas.setVisibility(View.GONE);
                            etP92_pastillas.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP86.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP86.isChecked()) {
                            ctvP86.setChecked(false);
                            ctvP86.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO86.setVisibility(View.VISIBLE);
                            etP86.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP86.setChecked(true);
                            ctvP86.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO86.setVisibility(View.GONE);
                            etP86.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_solventes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_solventes.isChecked()) {
                            ctvP90_solventes.setChecked(false);
                            ctvP90_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_solventes.setVisibility(View.VISIBLE);
                            etP90_solventes.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_solventes.setChecked(true);
                            ctvP90_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_solventes.setVisibility(View.GONE);
                            etP90_solventes.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_solventes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_solventes.isChecked()) {
                            ctvP91_solventes.setChecked(false);
                            ctvP91_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_solventes.setVisibility(View.VISIBLE);
                            etP91_solventes.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_solventes.setChecked(true);
                            ctvP91_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_solventes.setVisibility(View.GONE);
                            etP91_solventes.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_solventes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_solventes.isChecked()) {
                            ctvP92_solventes.setChecked(false);
                            ctvP92_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_solventes.setVisibility(View.VISIBLE);
                            etP92_solventes.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_solventes.setChecked(true);
                            ctvP92_solventes.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_solventes.setVisibility(View.GONE);
                            etP92_solventes.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP87.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP87.isChecked()) {
                            ctvP87.setChecked(false);
                            ctvP87.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO87.setVisibility(View.VISIBLE);
                            etP87.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP87.setChecked(true);
                            ctvP87.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO87.setVisibility(View.GONE);
                            etP87.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_cristal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_cristal.isChecked()) {
                            ctvP90_cristal.setChecked(false);
                            ctvP90_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_cristal.setVisibility(View.VISIBLE);
                            etP90_cristal.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_cristal.setChecked(true);
                            ctvP90_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_cristal.setVisibility(View.GONE);
                            etP90_cristal.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_cristal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_cristal.isChecked()) {
                            ctvP91_cristal.setChecked(false);
                            ctvP91_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_cristal.setVisibility(View.VISIBLE);
                            etP91_cristal.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_cristal.setChecked(true);
                            ctvP91_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_cristal.setVisibility(View.GONE);
                            etP91_cristal.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_cristal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_cristal.isChecked()) {
                            ctvP92_cristal.setChecked(false);
                            ctvP92_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_cristal.setVisibility(View.VISIBLE);
                            etP92_cristal.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_cristal.setChecked(true);
                            ctvP92_cristal.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_cristal.setVisibility(View.GONE);
                            etP92_cristal.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP88.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP88.isChecked()) {
                            ctvP88.setChecked(false);
                            ctvP88.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO88.setVisibility(View.VISIBLE);
                            etP88.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP88.setChecked(true);
                            ctvP88.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO88.setVisibility(View.GONE);
                            etP88.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_cocaina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_cocaina.isChecked()) {
                            ctvP90_cocaina.setChecked(false);
                            ctvP90_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_cocaina.setVisibility(View.VISIBLE);
                            etP90_cocaina.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_cocaina.setChecked(true);
                            ctvP90_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_cocaina.setVisibility(View.GONE);
                            etP90_cocaina.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_cocaina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_cocaina.isChecked()) {
                            ctvP91_cocaina.setChecked(false);
                            ctvP91_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_cocaina.setVisibility(View.VISIBLE);
                            etP91_cocaina.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_cocaina.setChecked(true);
                            ctvP91_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_cocaina.setVisibility(View.GONE);
                            etP91_cocaina.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_cocaina.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_cocaina.isChecked()) {
                            ctvP92_cocaina.setChecked(false);
                            ctvP92_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_cocaina.setVisibility(View.VISIBLE);
                            etP92_cocaina.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_cocaina.setChecked(true);
                            ctvP92_cocaina.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_cocaina.setVisibility(View.GONE);
                            etP92_cocaina.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP89.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP89.isChecked()) {
                            ctvP89.setChecked(false);
                            ctvP89.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO89.setVisibility(View.VISIBLE);
                            etP89.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP89.setChecked(true);
                            ctvP89.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO89.setVisibility(View.GONE);
                            etP89.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP93_otroConsumo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP93_otroConsumo.isChecked()) {
                            ctvP93_otroConsumo.setChecked(false);
                            ctvP93_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO93_otroConsumo.setVisibility(View.VISIBLE);
                            etP93_otroConsumo.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP93_otroConsumo.setChecked(true);
                            ctvP93_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO93_otroConsumo.setVisibility(View.GONE);
                            etP93_otroConsumo.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP90_otroConsumo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP90_otroConsumo.isChecked()) {
                            ctvP90_otroConsumo.setChecked(false);
                            ctvP90_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO90_otroConsumo.setVisibility(View.VISIBLE);
                            etP90_otroConsumo.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP90_otroConsumo.setChecked(true);
                            ctvP90_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO90_otroConsumo.setVisibility(View.GONE);
                            etP90_otroConsumo.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP91_otroConsumo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP91_otroConsumo.isChecked()) {
                            ctvP91_otroConsumo.setChecked(false);
                            ctvP91_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO91_otroConsumo.setVisibility(View.VISIBLE);
                            etP91_otroConsumo.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP91_otroConsumo.setChecked(true);
                            ctvP91_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO91_otroConsumo.setVisibility(View.GONE);
                            etP91_otroConsumo.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP92_otroConsumo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP92_otroConsumo.isChecked()) {
                            ctvP92_otroConsumo.setChecked(false);
                            ctvP92_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO92_otroConsumo.setVisibility(View.VISIBLE);
                            etP92_otroConsumo.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP92_otroConsumo.setChecked(true);
                            ctvP92_otroConsumo.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO92_otroConsumo.setVisibility(View.GONE);
                            etP92_otroConsumo.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP94.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP94.isChecked()) {
                            ctvP94.setChecked(false);
                            ctvP94.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO94.setVisibility(View.VISIBLE);
                            etP94.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP94.setChecked(true);
                            ctvP94.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO94.setVisibility(View.GONE);
                            etP94.setVisibility(View.GONE);
                        }
                    }
                });

                ctvP95.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvP95.isChecked()) {
                            ctvP95.setChecked(false);
                            ctvP95.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvO95.setVisibility(View.VISIBLE);
                            etP95.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvP95.setChecked(true);
                            ctvP95.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvO95.setVisibility(View.GONE);
                            etP95.setVisibility(View.GONE);
                        }
                    }
                });
                //endregion

                //region Guardar Observaciones
                btnGuardarObservaciones=(Button) findViewById(R.id.btnGuardarObservaciones);
                btnGuardarObservaciones.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ArrayList<datosGenerales> lista;
                        lista = db.getDatosGenerales();
                        int pos = sVerificationName.getSelectedItemPosition();
                        String folio = lista.get(pos).getFolio();

                        //region Get the observations
                        r1 = etP1.getText().toString().toUpperCase();
                        r1_1 = etP1_1.getText().toString().toUpperCase();
                        r1_2 = etP1_2.getText().toString().toUpperCase();
                        r2 = etP2.getText().toString().toUpperCase();
                        r3 = etP3.getText().toString().toUpperCase();
                        r4 = etP4.getText().toString().toUpperCase();
                        r5 = etP5.getText().toString().toUpperCase();
                        r6 = etP6.getText().toString().toUpperCase();
                        r7 = etP7.getText().toString().toUpperCase();
                        r7_1 = etP7_1.getText().toString().toUpperCase();
                        r8 = etP8.getText().toString().toUpperCase();
                        r9 = etP9.getText().toString().toUpperCase();
                        r10 = etP10.getText().toString().toUpperCase();
                        r11 = etP11.getText().toString().toUpperCase();
                        r12 = etP12.getText().toString().toUpperCase();
                        r13 = etP13.getText().toString().toUpperCase();
                        r14 = etP14.getText().toString().toUpperCase();
                        r15 = etP15.getText().toString().toUpperCase();
                        r16 = etP16.getText().toString().toUpperCase();
                        r32_1 = etP32_1.getText().toString().toUpperCase();
                        r17 = etP17.getText().toString().toUpperCase();
                        r18 = etP18.getText().toString().toUpperCase();
                        r19 = etP19.getText().toString().toUpperCase();
                        r20 = etP20.getText().toString().toUpperCase();
                        r21_1 = etP21_1.getText().toString().toUpperCase();
                        r21 = etP21.getText().toString().toUpperCase();
                        r22 = etP22.getText().toString().toUpperCase();
                        r23 = etP23.getText().toString().toUpperCase();
                        r24 = etP24.getText().toString().toUpperCase();
                        r25 = etP25.getText().toString().toUpperCase();
                        r26 = etP26.getText().toString().toUpperCase();
                        r27 = etP27.getText().toString().toUpperCase();
                        r28 = etP28.getText().toString().toUpperCase();
                        r101 = etP101.getText().toString().toUpperCase();
                        r102 = etP102.getText().toString().toUpperCase();
                        r103 = etP103.getText().toString().toUpperCase();
                        r104 = etP104.getText().toString().toUpperCase();
                        r105 = etP105.getText().toString().toUpperCase();
                        r29 = etP29.getText().toString().toUpperCase();
                        r30 = etP30.getText().toString().toUpperCase();
                        r31 = etP31.getText().toString().toUpperCase();
                        r31_1 = etP31_1.getText().toString().toUpperCase();
                        r31_2 = etP31_2.getText().toString().toUpperCase();
                        r32 = etP32.getText().toString().toUpperCase();
                        r33 = etP33.getText().toString().toUpperCase();
                        r34 = etP34.getText().toString().toUpperCase();
                        r35 = etP35.getText().toString().toUpperCase();
                        r36 = etP36.getText().toString().toUpperCase();
                        r37 = etP37.getText().toString().toUpperCase();
                        r33_1 = etP33_1.getText().toString().toUpperCase();
                        r34_1 = etP34_1.getText().toString().toUpperCase();
                        r35_1 = etP35_1.getText().toString().toUpperCase();
                        r36_1 = etP36_1.getText().toString().toUpperCase();
                        r37_1 = etP37_1.getText().toString().toUpperCase();
                        r33_2 = etP33_2.getText().toString().toUpperCase();
                        r34_2 = etP34_2.getText().toString().toUpperCase();
                        r35_2 = etP35_2.getText().toString().toUpperCase();
                        r36_2 = etP36_2.getText().toString().toUpperCase();
                        r37_2 = etP37_2.getText().toString().toUpperCase();
                        r33_3 = etP33_3.getText().toString().toUpperCase();
                        r34_3 = etP34_3.getText().toString().toUpperCase();
                        r35_3 = etP35_3.getText().toString().toUpperCase();
                        r36_3 = etP36_3.getText().toString().toUpperCase();
                        r37_3 = etP37_3.getText().toString().toUpperCase();
                        r38 = etP38.getText().toString().toUpperCase();
                        r39 = etP39.getText().toString().toUpperCase();
                        r40 = etP40.getText().toString().toUpperCase();
                        r41 = etP41.getText().toString().toUpperCase();
                        r42 = etP42.getText().toString().toUpperCase();
                        r43 = etP43.getText().toString().toUpperCase();
                        r39_1 = etP39_1.getText().toString().toUpperCase();
                        r40_1 = etP40_1.getText().toString().toUpperCase();
                        r41_1 = etP41_1.getText().toString().toUpperCase();
                        r42_1 = etP42_1.getText().toString().toUpperCase();
                        r43_1 = etP43_1.getText().toString().toUpperCase();
                        r44 = etP44.getText().toString().toUpperCase();
                        r45 = etP45.getText().toString().toUpperCase();
                        r46 = etP46.getText().toString().toUpperCase();
                        r47 = etP47.getText().toString().toUpperCase();
                        r48 = etP48.getText().toString().toUpperCase();
                        r49 = etP49.getText().toString().toUpperCase();
                        r50 = etP50.getText().toString().toUpperCase();
                        r51 = etP51.getText().toString().toUpperCase();
                        r52 = etP52.getText().toString().toUpperCase();
                        r53 = etP53.getText().toString().toUpperCase();
                        r54 = etP54.getText().toString().toUpperCase();
                        r55 = etP55.getText().toString().toUpperCase();
                        r57 = etP57.getText().toString().toUpperCase();
                        r56 = etP56.getText().toString().toUpperCase();
                        r58 = etP58.getText().toString().toUpperCase();
                        r51_1 = etP51_1.getText().toString().toUpperCase();
                        r59 = etP59.getText().toString().toUpperCase();
                        r60 = etP60.getText().toString().toUpperCase();
                        r61 = etP61.getText().toString().toUpperCase();
                        r62 = etP62.getText().toString().toUpperCase();
                        r63 = etP63.getText().toString().toUpperCase();
                        r64 = etP64.getText().toString().toUpperCase();
                        r65 = etP65.getText().toString().toUpperCase();
                        r66 = etP66.getText().toString().toUpperCase();
                        r67 = etP67.getText().toString().toUpperCase();
                        r68 = etP68.getText().toString().toUpperCase();
                        r69 = etP69.getText().toString().toUpperCase();
                        r70 = etP70.getText().toString().toUpperCase();
                        r71 = etP71.getText().toString().toUpperCase();
                        r72 = etP72.getText().toString().toUpperCase();
                        r67_1 = etP67_1.getText().toString().toUpperCase();
                        r68_1 = etP68_1.getText().toString().toUpperCase();
                        r69_1 = etP69_1.getText().toString().toUpperCase();
                        r70_1 = etP70_1.getText().toString().toUpperCase();
                        r71_1 = etP71_1.getText().toString().toUpperCase();
                        r72_1 = etP72_1.getText().toString().toUpperCase();
                        r73 = etP73.getText().toString().toUpperCase();
                        r74 = etP74.getText().toString().toUpperCase();
                        r75 = etP75.getText().toString().toUpperCase();
                        r76 = etP76.getText().toString().toUpperCase();
                        r77 = etP77.getText().toString().toUpperCase();
                        r78 = etP78.getText().toString().toUpperCase();
                        r74_1 = etP74_1.getText().toString().toUpperCase();
                        r75_1 = etP75_1.getText().toString().toUpperCase();
                        r76_1 = etP76_1.getText().toString().toUpperCase();
                        r77_1 = etP77_1.getText().toString().toUpperCase();
                        r78_1 = etP78_1.getText().toString().toUpperCase();
                        r79 = etP79.getText().toString().toUpperCase();
                        r80 = etP80.getText().toString().toUpperCase();
                        r81 = etP81.getText().toString().toUpperCase();
                        r82 = etP82.getText().toString().toUpperCase();
                        r90_alcohol = etP90_alcohol.getText().toString().toUpperCase();
                        r91_alcohol = etP91_alcohol.getText().toString().toUpperCase();
                        r92_alcohol = etP92_alcohol.getText().toString().toUpperCase();
                        r83 = etP83.getText().toString().toUpperCase();
                        r90_tabaco = etP90_tabaco.getText().toString().toUpperCase();
                        r91_tabaco = etP91_tabaco.getText().toString().toUpperCase();
                        r92_tabaco = etP92_tabaco.getText().toString().toUpperCase();
                        r84 = etP84.getText().toString().toUpperCase();
                        r90_marihuana = etP90_marihuana.getText().toString().toUpperCase();
                        r91_marihuana = etP91_marihuana.getText().toString().toUpperCase();
                        r92_marihuana = etP92_marihuana.getText().toString().toUpperCase();
                        r85 = etP85.getText().toString().toUpperCase();
                        r90_pastillas = etP90_pastillas.getText().toString().toUpperCase();
                        r91_pastillas = etP91_pastillas.getText().toString().toUpperCase();
                        r92_pastillas = etP92_pastillas.getText().toString().toUpperCase();
                        r86 = etP86.getText().toString().toUpperCase();
                        r90_solventes = etP90_solventes.getText().toString().toUpperCase();
                        r91_solventes = etP91_solventes.getText().toString().toUpperCase();
                        r92_solventes = etP92_solventes.getText().toString().toUpperCase();
                        r87 = etP87.getText().toString().toUpperCase();
                        r90_cristal = etP90_cristal.getText().toString().toUpperCase();
                        r91_cristal = etP91_cristal.getText().toString().toUpperCase();
                        r92_cristal = etP92_cristal.getText().toString().toUpperCase();
                        r88 = etP88.getText().toString().toUpperCase();
                        r90_cocaina = etP90_cocaina.getText().toString().toUpperCase();
                        r91_cocaina = etP91_cocaina.getText().toString().toUpperCase();
                        r92_cocaina = etP92_cocaina.getText().toString().toUpperCase();
                        r89 = etP89.getText().toString().toUpperCase();
                        r93_otroConsumo = etP93_otroConsumo.getText().toString().toUpperCase();
                        r90_otroConsumo = etP90_otroConsumo.getText().toString().toUpperCase();
                        r91_otroConsumo = etP91_otroConsumo.getText().toString().toUpperCase();
                        r92_otroConsumo = etP92_otroConsumo.getText().toString().toUpperCase();
                        r94 = etP94.getText().toString().toUpperCase();
                        r95 = etP95.getText().toString().toUpperCase();
                        r109 = etP109.getText().toString().toUpperCase();
                        r110 = etP110.getText().toString().toUpperCase();
                        //endregion

                        //region Insertar Observaciones a Base de Datos
                        String oper = sP108.getSelectedItem().toString();
                        //== "Verificar"
                        if(oper.equals(opers[0])) {
                            if(ctvP1.isChecked() == false && r1.isEmpty() == false) {
                                db.insertarObservaciones("Nombre", r1, lista.get(pos).getNombre(), folio);
                            }
                            if(ctvP1_1.isChecked() == false && r1_1.isEmpty() == false) {
                                db.insertarObservaciones("Entrevistada", r1_1, lista.get(pos).getEntrevistado(), folio);
                            }
                            if(ctvP1_2.isChecked() == false && r1_2.isEmpty() == false) {
                                db.insertarObservaciones("AntecedentePenal", r1_2, lista.get(pos).getAntecedentePenal(), folio);
                            }
                            if(ctvP2.isChecked() == false && r2.isEmpty() == false) {
                                db.insertarObservaciones("Alias", r2, lista.get(pos).getAlias(), folio);
                            }
                            if(ctvP3.isChecked() == false && r3.isEmpty() == false) {
                                db.insertarObservaciones("FNacimiento", r3, lista.get(pos).getfNacimiento(), folio);
                            }
                            if(ctvP4.isChecked() == false && r4.isEmpty() == false) {
                                db.insertarObservaciones("Edad", r4, lista.get(pos).getEdad(), folio);
                            }
                            if(ctvP5.isChecked() == false && r5.isEmpty() == false) {
                                db.insertarObservaciones("LNacimiento", r5, lista.get(pos).getlNacimiento(), folio);
                            }
                            if(ctvP6.isChecked() == false && r6.isEmpty() == false) {
                                db.insertarObservaciones("Sexo", r6, lista.get(pos).getSexo(), folio);
                            }
                            if(ctvP7.isChecked() == false && r7.isEmpty() == false) {
                                db.insertarObservaciones("e7", r7, addresses.get(pos).getE7(), folio);
                            }
                            if(ctvP7_1.isChecked() == false && r7_1.isEmpty() == false) {
                                db.insertarObservaciones("e7_1", r7_1, addresses.get(pos).getE7_1(), folio);
                            }
                            if(ctvP8.isChecked() == false && r8.isEmpty() == false) {
                                db.insertarObservaciones("e8", r8, addresses.get(pos).getE8(), folio);
                            }
                            if(ctvP9.isChecked() == false && r9.isEmpty() == false) {
                                db.insertarObservaciones("e9", r9, addresses.get(pos).getE9(), folio);
                            }
                            if(ctvP10.isChecked() == false && r10.isEmpty() == false) {
                                db.insertarObservaciones("e10", r10, addresses.get(pos).getE10(), folio);
                            }
                            if(ctvP11.isChecked() == false && r11.isEmpty() == false) {
                                db.insertarObservaciones("e11", r11, addresses.get(pos).getE11(), folio);
                            }
                            if(ctvP12.isChecked() == false && r12.isEmpty() == false) {
                                db.insertarObservaciones("e12", r12, addresses.get(pos).getE12(), folio);
                            }
                            if(ctvP13.isChecked() == false && r13.isEmpty() == false) {
                                db.insertarObservaciones("e13", r13, addresses.get(pos).getE13(), folio);
                            }
                            if(ctvP14.isChecked() == false && r14.isEmpty() == false) {
                                db.insertarObservaciones("e14", r14, addresses.get(pos).getE14(), folio);
                            }
                            if(ctvP15.isChecked() == false && r15.isEmpty() == false) {
                                db.insertarObservaciones("e15", r15, addresses.get(pos).getE15(), folio);
                            }
                            if(ctvP16.isChecked() == false && r16.isEmpty() == false) {
                                db.insertarObservaciones("e16", r16, addresses.get(pos).getE16(), folio);
                            }
                            if(ctvP32_1.isChecked() == false && r32_1.isEmpty() == false) {
                                db.insertarObservaciones("e32_1", r32_1, addresses.get(pos).getE32_1(), folio);
                            }
                            if(ctvP17.isChecked() == false && r17.isEmpty() == false) {
                                db.insertarObservaciones("e17", r17, addresses.get(pos).getE17(), folio);
                            }
                            if(ctvP18.isChecked() == false && r18.isEmpty() == false) {
                                db.insertarObservaciones("e18", r18, addresses.get(pos).getE18(), folio);
                            }
                            if(ctvP19.isChecked() == false && r19.isEmpty() == false) {
                                db.insertarObservaciones("e19", r19, addresses.get(pos).getE19(), folio);
                            }
                            if(ctvP20.isChecked() == false && r20.isEmpty() == false) {
                                db.insertarObservaciones("e20", r20, addresses.get(pos).getE20(), folio);
                            }
                            if(ctvP21_1.isChecked() == false && r21_1.isEmpty() == false) {
                                db.insertarObservaciones("TieneDomicilioS", r21_1, lista.get(pos).getTieneDomicilioS(), folio);
                            }
                            if(ctvP21.isChecked() == false && r21.isEmpty() == false) {
                                db.insertarObservaciones("e21", r21, addresses.get(pos).getE21(), folio);
                            }
                            if(ctvP22.isChecked() == false && r22.isEmpty() == false) {
                                db.insertarObservaciones("e22", r22, addresses.get(pos).getE22(), folio);
                            }
                            if(ctvP23.isChecked() == false && r23.isEmpty() == false) {
                                db.insertarObservaciones("e23", r23, addresses.get(pos).getE23(), folio);
                            }
                            if(ctvP24.isChecked() == false && r24.isEmpty() == false) {
                                db.insertarObservaciones("e24", r24, addresses.get(pos).getE24(), folio);
                            }
                            if(ctvP25.isChecked() == false && r25.isEmpty() == false) {
                                db.insertarObservaciones("e25", r25, addresses.get(pos).getE25(), folio);
                            }
                            if(ctvP26.isChecked() == false && r26.isEmpty() == false) {
                                db.insertarObservaciones("e26", r26, addresses.get(pos).getE26(), folio);
                            }
                            if(ctvP27.isChecked() == false && r27.isEmpty() == false) {
                                db.insertarObservaciones("e27", r27, addresses.get(pos).getE27(), folio);
                            }
                            if(ctvP28.isChecked() == false && r28.isEmpty() == false) {
                                db.insertarObservaciones("e28", r28, addresses.get(pos).getE28(), folio);
                            }
                            if(ctvP101.isChecked() == false && r101.isEmpty() == false) {
                                db.insertarObservaciones("e101", r101, victima.get(pos).getE101(), folio);
                            }
                            if(ctvP102.isChecked() == false && r102.isEmpty() == false) {
                                db.insertarObservaciones("e102", r102, victima.get(pos).getE102(), folio);
                            }
                            if(ctvP103.isChecked() == false && r103.isEmpty() == false) {
                                db.insertarObservaciones("e103", r103, victima.get(pos).getE103(), folio);
                            }
                            if(ctvP104.isChecked() == false && r104.isEmpty() == false) {
                                db.insertarObservaciones("e104", r104, victima.get(pos).getE104(), folio);
                            }
                            if(ctvP105.isChecked() == false && r105.isEmpty() == false) {
                                db.insertarObservaciones("e105", r105, victima.get(pos).getE105(), folio);
                            }
                            if(ctvP29.isChecked() == false && r29.isEmpty() == false) {
                                db.insertarObservaciones("e29", r29, addresses.get(pos).getE29(), folio);
                            }
                            if(ctvP30.isChecked() == false && r30.isEmpty() == false) {
                                db.insertarObservaciones("e30", r30, addresses.get(pos).getE30(), folio);
                            }
                            if(ctvP31.isChecked() == false && r31.isEmpty() == false) {
                                db.insertarObservaciones("e31", r31, addresses.get(pos).getE31(), folio);
                            }
                            if(ctvP31_1.isChecked() == false && r31_1.isEmpty() == false) {
                                db.insertarObservaciones("e31_1", r31_1, lista.get(pos).getDelito(), folio);
                            }
                            if(ctvP31_2.isChecked() == false && r31_2.isEmpty() == false) {
                                db.insertarObservaciones("e31_2", r31_2, lista.get(pos).getOtroDelito(), folio);
                            }
                            if(ctvP32.isChecked() == false && r32.isEmpty() == false) {
                                db.insertarObservaciones("OtrosHabitantes", r32, lista.get(pos).getOtrosHabitantes(), folio);
                            }
                            if(ctvP33.isChecked() == false && r33.isEmpty() == false) {
                                db.insertarObservaciones("e33", r33, habitantes.get(pos).getE33(), folio);
                            }
                            if(ctvP34.isChecked() == false && r34.isEmpty() == false) {
                                db.insertarObservaciones("e34", r34, habitantes.get(pos).getE34(), folio);
                            }
                            if(ctvP35.isChecked() == false && r35.isEmpty() == false) {
                                db.insertarObservaciones("e35", r35, habitantes.get(pos).getE35(), folio);
                            }
                            if(ctvP36.isChecked() == false && r36.isEmpty() == false) {
                                db.insertarObservaciones("e36", r36, habitantes.get(pos).getE36(), folio);
                            }
                            if(ctvP37.isChecked() == false && r37.isEmpty() == false) {
                                db.insertarObservaciones("e37", r37, habitantes.get(pos).getE37(), folio);
                            }
                            if(ctvP33_1.isChecked() == false && r33_1.isEmpty() == false) {
                                db.insertarObservaciones("e33_1", r33_1, habitantes.get(pos).getE33_1(), folio);
                            }
                            if(ctvP34_1.isChecked() == false && r34_1.isEmpty() == false) {
                                db.insertarObservaciones("e34_1", r34_1, habitantes.get(pos).getE34_1(), folio);
                            }
                            if(ctvP35_1.isChecked() == false && r35_1.isEmpty() == false) {
                                db.insertarObservaciones("e35_1", r35_1, habitantes.get(pos).getE35_1(), folio);
                            }
                            if(ctvP36_1.isChecked() == false && r36_1.isEmpty() == false) {
                                db.insertarObservaciones("e36_1", r36_1, habitantes.get(pos).getE36_1(), folio);
                            }
                            if(ctvP37_1.isChecked() == false && r37_1.isEmpty() == false) {
                                db.insertarObservaciones("e37_1", r37_1, habitantes.get(pos).getE37_1(), folio);
                            }
                            if(ctvP33_2.isChecked() == false && r33_2.isEmpty() == false) {
                                db.insertarObservaciones("e33_2", r33_2, habitantes.get(pos).getE33_2(), folio);
                            }
                            if(ctvP34_2.isChecked() == false && r34_2.isEmpty() == false) {
                                db.insertarObservaciones("e34_2", r34_2, habitantes.get(pos).getE34_2(), folio);
                            }
                            if(ctvP35_2.isChecked() == false && r35_2.isEmpty() == false) {
                                db.insertarObservaciones("e35_2", r35_2, habitantes.get(pos).getE35_2(), folio);
                            }
                            if(ctvP36_2.isChecked() == false && r36_2.isEmpty() == false) {
                                db.insertarObservaciones("e36_2", r36_2, habitantes.get(pos).getE36_2(), folio);
                            }
                            if(ctvP37_2.isChecked() == false && r37_2.isEmpty() == false) {
                                db.insertarObservaciones("e37_2", r37_2, habitantes.get(pos).getE37_2(), folio);
                            }
                            if(ctvP33_3.isChecked() == false && r33_3.isEmpty() == false) {
                                db.insertarObservaciones("e33_3", r33_3, habitantes.get(pos).getE33_3(), folio);
                            }
                            if(ctvP34_3.isChecked() == false && r34_3.isEmpty() == false) {
                                db.insertarObservaciones("e34_3", r34_3, habitantes.get(pos).getE34_3(), folio);
                            }
                            if(ctvP35_3.isChecked() == false && r35_3.isEmpty() == false) {
                                db.insertarObservaciones("e35_3", r35_3, habitantes.get(pos).getE35_3(), folio);
                            }
                            if(ctvP36_3.isChecked() == false && r36_3.isEmpty() == false) {
                                db.insertarObservaciones("e36_3", r36_3, habitantes.get(pos).getE36_3(), folio);
                            }
                            if(ctvP37_3.isChecked() == false && r37_3.isEmpty() == false) {
                                db.insertarObservaciones("e37_3", r37_3, habitantes.get(pos).getE37_3(), folio);
                            }
                            if(ctvP38.isChecked() == false && r38.isEmpty() == false) {
                                db.insertarObservaciones("e38", r38, habitantes.get(pos).getE38(), folio);
                            }
                            if(ctvP39.isChecked() == false && r39.isEmpty() == false) {
                                db.insertarObservaciones("e39", r39, referencias.get(pos).getE39(), folio);
                            }
                            if(ctvP40.isChecked() == false && r40.isEmpty() == false) {
                                db.insertarObservaciones("e40", r40, referencias.get(pos).getE40(), folio);
                            }
                            if(ctvP41.isChecked() == false && r41.isEmpty() == false) {
                                db.insertarObservaciones("e41", r41, referencias.get(pos).getE41(), folio);
                            }
                            if(ctvP42.isChecked() == false && r42.isEmpty() == false) {
                                db.insertarObservaciones("e42", r42, referencias.get(pos).getE42(), folio);
                            }
                            if(ctvP43.isChecked() == false && r43.isEmpty() == false) {
                                db.insertarObservaciones("e43", r43, referencias.get(pos).getE43(), folio);
                            }
                            if(ctvP39_1.isChecked() == false && r39_1.isEmpty() == false) {
                                db.insertarObservaciones("e39_1", r39_1, referencias.get(pos).getE39_1(), folio);
                            }
                            if(ctvP40_1.isChecked() == false && r40_1.isEmpty() == false) {
                                db.insertarObservaciones("e40_1", r40_1, referencias.get(pos).getE40_1(), folio);
                            }
                            if(ctvP41_1.isChecked() == false && r41_1.isEmpty() == false) {
                                db.insertarObservaciones("e41_1", r41_1, referencias.get(pos).getE41_1(), folio);
                            }
                            if(ctvP42_1.isChecked() == false && r42_1.isEmpty() == false) {
                                db.insertarObservaciones("e42_1", r42_1, referencias.get(pos).getE42_1(), folio);
                            }
                            if(ctvP43_1.isChecked() == false && r43_1.isEmpty() == false) {
                                db.insertarObservaciones("e43_1", r43_1, referencias.get(pos).getE43_1(), folio);
                            }
                            if(ctvP44.isChecked() == false && r44.isEmpty() == false) {
                                db.insertarObservaciones("e44", r44, referencias.get(pos).getE44(), folio);
                            }
                            if(ctvP45.isChecked() == false && r45.isEmpty() == false) {
                                db.insertarObservaciones("e45", r45, referencias.get(pos).getE45(), folio);
                            }
                            if(ctvP46.isChecked() == false && r46.isEmpty() == false) {
                                db.insertarObservaciones("e46", r46, referencias.get(pos).getE46(), folio);
                            }
                            if(ctvP47.isChecked() == false && r47.isEmpty() == false) {
                                db.insertarObservaciones("e47", r47, referencias.get(pos).getE47(), folio);
                            }
                            if(ctvP48.isChecked() == false && r48.isEmpty() == false) {
                                db.insertarObservaciones("e48", r48, historialEscolarLaboral.get(pos).getE48(), folio);
                            }
                            if(ctvP49.isChecked() == false && r49.isEmpty() == false) {
                                db.insertarObservaciones("e49", r49, historialEscolarLaboral.get(pos).getE49(), folio);
                            }
                            if(ctvP50.isChecked() == false && r50.isEmpty() == false) {
                                db.insertarObservaciones("e50", r50, historialEscolarLaboral.get(pos).getE50(), folio);
                            }
                            if(ctvP51.isChecked() == false && r51.isEmpty() == false) {
                                db.insertarObservaciones("e51", r51, historialEscolarLaboral.get(pos).getE51(), folio);
                            }
                            if(ctvP52.isChecked() == false && r52.isEmpty() == false) {
                                db.insertarObservaciones("e52", r52, historialEscolarLaboral.get(pos).getE52(), folio);
                            }
                            if(ctvP53.isChecked() == false && r53.isEmpty() == false) {
                                db.insertarObservaciones("e53", r53, historialEscolarLaboral.get(pos).getE53(), folio);
                            }
                            if(ctvP54.isChecked() == false && r54.isEmpty() == false) {
                                db.insertarObservaciones("e54", r54, historialEscolarLaboral.get(pos).getE54(), folio);
                            }
                            if(ctvP55.isChecked() == false && r55.isEmpty() == false) {
                                db.insertarObservaciones("e55", r55, historialEscolarLaboral.get(pos).getE55(), folio);
                            }
                            if(ctvP57.isChecked() == false && r57.isEmpty() == false) {
                                db.insertarObservaciones("e57", r57, historialEscolarLaboral.get(pos).getE57(), folio);
                            }
                            if(ctvP56.isChecked() == false && r56.isEmpty() == false) {
                                db.insertarObservaciones("e56", r56, historialEscolarLaboral.get(pos).getE56(), folio);
                            }
                            if(ctvP58.isChecked() == false && r58.isEmpty() == false) {
                                db.insertarObservaciones("e58", r58, historialEscolarLaboral.get(pos).getE58(), folio);
                            }
                            if(ctvP51_1.isChecked() == false && r51_1.isEmpty() == false) {
                                db.insertarObservaciones("e51_1", r51_1, historialEscolarLaboral.get(pos).getE51_1(), folio);
                            }
                            if(ctvP59.isChecked() == false && r59.isEmpty() == false) {
                                db.insertarObservaciones("e59", r59, historialEscolarLaboral.get(pos).getE59(), folio);
                            }
                            if(ctvP60.isChecked() == false && r60.isEmpty() == false) {
                                db.insertarObservaciones("e60", r60, listaAbandonoEstado.get(pos).getE60(), folio);
                            }
                            if(ctvP61.isChecked() == false && r61.isEmpty() == false) {
                                db.insertarObservaciones("e61", r61, listaAbandonoEstado.get(pos).getE61(), folio);
                            }
                            if(ctvP62.isChecked() == false && r62.isEmpty() == false) {
                                db.insertarObservaciones("e62", r62, listaAbandonoEstado.get(pos).getE62(), folio);
                            }
                            if(ctvP63.isChecked() == false && r63.isEmpty() == false) {
                                db.insertarObservaciones("e63", r63, listaAbandonoEstado.get(pos).getE63(), folio);
                            }
                            if(ctvP64.isChecked() == false && r64.isEmpty() == false) {
                                db.insertarObservaciones("e64", r64, listaAbandonoEstado.get(pos).getE64(), folio);
                            }
                            if(ctvP65.isChecked() == false && r65.isEmpty() == false) {
                                db.insertarObservaciones("e65", r65, listaAbandonoEstado.get(pos).getE65(), folio);
                            }
                            if(ctvP66.isChecked() == false && r66.isEmpty() == false) {
                                db.insertarObservaciones("e66", r66, listaAbandonoEstado.get(pos).getE66(), folio);
                            }
                            if(ctvP67.isChecked() == false && r67.isEmpty() == false) {
                                db.insertarObservaciones("e67", r67, listaAbandonoEstado.get(pos).getE67(), folio);
                            }
                            if(ctvP68.isChecked() == false && r68.isEmpty() == false) {
                                db.insertarObservaciones("e68", r68, listaAbandonoEstado.get(pos).getE68(), folio);
                            }
                            if(ctvP69.isChecked() == false && r69.isEmpty() == false) {
                                db.insertarObservaciones("e69", r69, listaAbandonoEstado.get(pos).getE69(), folio);
                            }
                            if(ctvP70.isChecked() == false && r70.isEmpty() == false) {
                                db.insertarObservaciones("e70", r70, listaAbandonoEstado.get(pos).getE70(), folio);
                            }
                            if(ctvP71.isChecked() == false && r71.isEmpty() == false) {
                                db.insertarObservaciones("e71", r71, listaAbandonoEstado.get(pos).getE71(), folio);
                            }
                            if(ctvP72.isChecked() == false && r72.isEmpty() == false) {
                                db.insertarObservaciones("e72", r72, listaAbandonoEstado.get(pos).getE72(), folio);
                            }
                            if(ctvP67_1.isChecked() == false && r67_1.isEmpty() == false) {
                                db.insertarObservaciones("e67_1", r67_1, listaAbandonoEstado.get(pos).getE67_1(), folio);
                            }
                            if(ctvP68_1.isChecked() == false && r68_1.isEmpty() == false) {
                                db.insertarObservaciones("e68_1", r68_1, listaAbandonoEstado.get(pos).getE68_1(), folio);
                            }
                            if(ctvP69_1.isChecked() == false && r69_1.isEmpty() == false) {
                                db.insertarObservaciones("e69_1", r69_1, listaAbandonoEstado.get(pos).getE69_1(), folio);
                            }
                            if(ctvP70_1.isChecked() == false && r70_1.isEmpty() == false) {
                                db.insertarObservaciones("e70_1", r70_1, listaAbandonoEstado.get(pos).getE70_1(), folio);
                            }
                            if(ctvP71_1.isChecked() == false && r71_1.isEmpty() == false) {
                                db.insertarObservaciones("e71_1", r71_1, listaAbandonoEstado.get(pos).getE71_1(), folio);
                            }
                            if(ctvP72_1.isChecked() == false && r72_1.isEmpty() == false) {
                                db.insertarObservaciones("e72_1", r72_1, listaAbandonoEstado.get(pos).getE72_1(), folio);
                            }
                            if(ctvP73.isChecked() == false && r73.isEmpty() == false) {
                                db.insertarObservaciones("e73", r73, listaAbandonoEstado.get(pos).getE73(), folio);
                            }
                            if(ctvP74.isChecked() == false && r74.isEmpty() == false) {
                                db.insertarObservaciones("e74", r74, listaAbandonoEstado.get(pos).getE74(), folio);
                            }
                            if(ctvP75.isChecked() == false && r75.isEmpty() == false) {
                                db.insertarObservaciones("e75", r75, listaAbandonoEstado.get(pos).getE75(), folio);
                            }
                            if(ctvP76.isChecked() == false && r76.isEmpty() == false) {
                                db.insertarObservaciones("e76", r76, listaAbandonoEstado.get(pos).getE76(), folio);
                            }
                            if(ctvP77.isChecked() == false && r77.isEmpty() == false) {
                                db.insertarObservaciones("e77", r77, listaAbandonoEstado.get(pos).getE77(), folio);
                            }
                            if(ctvP78.isChecked() == false && r78.isEmpty() == false) {
                                db.insertarObservaciones("e78", r78, listaAbandonoEstado.get(pos).getE78(), folio);
                            }
                            if(ctvP74_1.isChecked() == false && r74_1.isEmpty() == false) {
                                db.insertarObservaciones("e74_1", r74_1, listaAbandonoEstado.get(pos).getE74_1(), folio);
                            }
                            if(ctvP75_1.isChecked() == false && r75_1.isEmpty() == false) {
                                db.insertarObservaciones("e75_1", r75_1, listaAbandonoEstado.get(pos).getE75_1(), folio);
                            }
                            if(ctvP76_1.isChecked() == false && r76_1.isEmpty() == false) {
                                db.insertarObservaciones("e76_1", r76_1, listaAbandonoEstado.get(pos).getE76_1(), folio);
                            }
                            if(ctvP77_1.isChecked() == false && r77_1.isEmpty() == false) {
                                db.insertarObservaciones("e77_1", r77_1, listaAbandonoEstado.get(pos).getE77_1(), folio);
                            }
                            if(ctvP78_1.isChecked() == false && r78_1.isEmpty() == false) {
                                db.insertarObservaciones("e78_1", r78_1, listaAbandonoEstado.get(pos).getE78_1(), folio);
                            }
                            if(ctvP79.isChecked() == false && r79.isEmpty() == false) {
                                db.insertarObservaciones("e79", r79, listaAbandonoEstado.get(pos).getE79(), folio);
                            }
                            if(ctvP80.isChecked() == false && r80.isEmpty() == false) {
                                db.insertarObservaciones("e80", r80, listaAbandonoEstado.get(pos).getE80(), folio);
                            }
                            if(ctvP81.isChecked() == false && r81.isEmpty() == false) {
                                db.insertarObservaciones("e81", r81, listaAbandonoEstado.get(pos).getE81(), folio);
                            }
                            if(ctvP82.isChecked() == false && r82.isEmpty() == false) {
                                db.insertarObservaciones("e82", r82, listaSalud.get(pos).getE82(), folio);
                            }
                            if(ctvP90_alcohol.isChecked() == false && r90_alcohol.isEmpty() == false) {
                                db.insertarObservaciones("e90_alcohol", r90_alcohol, listaSalud.get(pos).getE90_alcohol(), folio);
                            }
                            if(ctvP91_alcohol.isChecked() == false && r91_alcohol.isEmpty() == false) {
                                db.insertarObservaciones("e91_alcohol", r91_alcohol, listaSalud.get(pos).getE91_alcohol(), folio);
                            }
                            if(ctvP92_alcohol.isChecked() == false && r92_alcohol.isEmpty() == false) {
                                db.insertarObservaciones("e92_alcohol", r92_alcohol, listaSalud.get(pos).getE92_alcohol(), folio);
                            }
                            if(ctvP83.isChecked() == false && r83.isEmpty() == false) {
                                db.insertarObservaciones("e83", r83, listaSalud.get(pos).getE83(), folio);
                            }
                            if(ctvP90_tabaco.isChecked() == false && r90_tabaco.isEmpty() == false) {
                                db.insertarObservaciones("e90_tabaco", r90_tabaco, listaSalud.get(pos).getE90_tabaco(), folio);
                            }
                            if(ctvP91_tabaco.isChecked() == false && r91_tabaco.isEmpty() == false) {
                                db.insertarObservaciones("e91_tabaco", r91_tabaco, listaSalud.get(pos).getE91_tabaco(), folio);
                            }
                            if(ctvP92_tabaco.isChecked() == false && r92_tabaco.isEmpty() == false) {
                                db.insertarObservaciones("e92_tabaco", r92_tabaco, listaSalud.get(pos).getE92_tabaco(), folio);
                            }
                            if(ctvP84.isChecked() == false && r84.isEmpty() == false) {
                                db.insertarObservaciones("e84", r84, listaSalud.get(pos).getE84(), folio);
                            }
                            if(ctvP90_marihuana.isChecked() == false && r90_marihuana.isEmpty() == false) {
                                db.insertarObservaciones("e90_marihuana", r90_marihuana, listaSalud.get(pos).getE90_marihuana(), folio);
                            }
                            if(ctvP91_marihuana.isChecked() == false && r91_marihuana.isEmpty() == false) {
                                db.insertarObservaciones("e91_marihuana", r91_marihuana, listaSalud.get(pos).getE91_marihuana(), folio);
                            }
                            if(ctvP92_marihuana.isChecked() == false && r92_marihuana.isEmpty() == false) {
                                db.insertarObservaciones("e92_marihuana", r92_marihuana, listaSalud.get(pos).getE92_marihuana(), folio);
                            }
                            if(ctvP85.isChecked() == false && r85.isEmpty() == false) {
                                db.insertarObservaciones("e85", r85, listaSalud.get(pos).getE85(), folio);
                            }
                            if(ctvP90_pastillas.isChecked() == false && r90_pastillas.isEmpty() == false) {
                                db.insertarObservaciones("e90_pastillas", r90_pastillas, listaSalud.get(pos).getE90_pastillas(), folio);
                            }
                            if(ctvP91_pastillas.isChecked() == false && r91_pastillas.isEmpty() == false) {
                                db.insertarObservaciones("e91_pastillas", r91_pastillas, listaSalud.get(pos).getE91_pastillas(), folio);
                            }
                            if(ctvP92_pastillas.isChecked() == false && r92_pastillas.isEmpty() == false) {
                                db.insertarObservaciones("e92_pastillas", r92_pastillas, listaSalud.get(pos).getE92_pastillas(), folio);
                            }
                            if(ctvP86.isChecked() == false && r86.isEmpty() == false) {
                                db.insertarObservaciones("e86", r86, listaSalud.get(pos).getE86(), folio);
                            }
                            if(ctvP90_solventes.isChecked() == false && r90_solventes.isEmpty() == false) {
                                db.insertarObservaciones("e90_solventes", r90_solventes, listaSalud.get(pos).getE90_solventes(), folio);
                            }
                            if(ctvP91_solventes.isChecked() == false && r91_solventes.isEmpty() == false) {
                                db.insertarObservaciones("e91_solventes", r91_solventes, listaSalud.get(pos).getE91_solventes(), folio);
                            }
                            if(ctvP92_solventes.isChecked() == false && r92_solventes.isEmpty() == false) {
                                db.insertarObservaciones("e92_solventes", r92_solventes, listaSalud.get(pos).getE92_solventes(), folio);
                            }
                            if(ctvP87.isChecked() == false && r87.isEmpty() == false) {
                                db.insertarObservaciones("e87", r87, listaSalud.get(pos).getE87(), folio);
                            }
                            if(ctvP90_cristal.isChecked() == false && r90_cristal.isEmpty() == false) {
                                db.insertarObservaciones("e90_cristal", r90_cristal, listaSalud.get(pos).getE90_cristal(), folio);
                            }
                            if(ctvP91_cristal.isChecked() == false && r91_cristal.isEmpty() == false) {
                                db.insertarObservaciones("e91_cristal", r91_cristal, listaSalud.get(pos).getE91_cristal(), folio);
                            }
                            if(ctvP92_cristal.isChecked() == false && r92_cristal.isEmpty() == false) {
                                db.insertarObservaciones("e92_cristal", r92_cristal, listaSalud.get(pos).getE92_cristal(), folio);
                            }
                            if(ctvP88.isChecked() == false && r88.isEmpty() == false) {
                                db.insertarObservaciones("e88", r88, listaSalud.get(pos).getE88(), folio);
                            }
                            if(ctvP90_cocaina.isChecked() == false && r90_cocaina.isEmpty() == false) {
                                db.insertarObservaciones("e90_cocaina", r90_cocaina, listaSalud.get(pos).getE90_cocaina(), folio);
                            }
                            if(ctvP91_cocaina.isChecked() == false && r91_cocaina.isEmpty() == false) {
                                db.insertarObservaciones("e91_cocaina", r91_cocaina, listaSalud.get(pos).getE91_cocaina(), folio);
                            }
                            if(ctvP92_cocaina.isChecked() == false && r92_cocaina.isEmpty() == false) {
                                db.insertarObservaciones("e92_cocaina", r92_cocaina, listaSalud.get(pos).getE92_cocaina(), folio);
                            }
                            if(ctvP89.isChecked() == false && r89.isEmpty() == false) {
                                db.insertarObservaciones("e89", r89, listaSalud.get(pos).getE89(), folio);
                            }
                            if(ctvP93_otroConsumo.isChecked() == false && r93_otroConsumo.isEmpty() == false) {
                                db.insertarObservaciones("e93_otroConsumo", r93_otroConsumo, listaSalud.get(pos).getE93_otroConsumo(), folio);
                            }
                            if(ctvP90_otroConsumo.isChecked() == false && r90_otroConsumo.isEmpty() == false) {
                                db.insertarObservaciones("e90_otroConsumo", r90_otroConsumo, listaSalud.get(pos).getE90_otroConsumo(), folio);
                            }
                            if(ctvP91_otroConsumo.isChecked() == false && r91_otroConsumo.isEmpty() == false) {
                                db.insertarObservaciones("e91_otroConsumo", r91_otroConsumo, listaSalud.get(pos).getE91_otroConsumo(), folio);
                            }
                            if(ctvP92_otroConsumo.isChecked() == false && r92_otroConsumo.isEmpty() == false) {
                                db.insertarObservaciones("e92_otroConsumo", r92_otroConsumo, listaSalud.get(pos).getE92_otroConsumo(), folio);
                            }
                            if(ctvP94.isChecked() == false && r94.isEmpty() == false) {
                                db.insertarObservaciones("e94", r94, listaSalud.get(pos).getE94(), folio);
                            }
                            if(ctvP95.isChecked() == false && r95.isEmpty() == false) {
                                db.insertarObservaciones("e95", r95, listaSalud.get(pos).getE95(), folio);
                            }

                            //Save the interviewee information
                            db.insertarDatosVerificacion(r109, r110, folio);
                        }
                        //endregion

                        //region Updates the database with the observations
                        if(ctvP1.isChecked() == false && r1.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Nombre", r1, folio);
                        }
                        if(ctvP1_1.isChecked() == false && r1_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Entrevistada", r1_1, folio);
                        }
                        if(ctvP1_2.isChecked() == false && r1_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "AntecedentePenal", r1_2, folio);
                        }
                        if(ctvP2.isChecked() == false && r2.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Alias", r2, folio);
                        }
                        if(ctvP3.isChecked() == false && r3.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "FEntrevista", r3, folio);
                        }
                        if(ctvP4.isChecked() == false && r4.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Edad", r4, folio);
                        }
                        if(ctvP5.isChecked() == false && r5.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "LNacimiento", r5, folio);
                        }
                        if(ctvP6.isChecked() == false && r6.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Sexo", r6, folio);
                        }
                        if(ctvP7.isChecked() == false && r7.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e7", r7, folio);
                        }
                        if(ctvP7_1.isChecked() == false && r7_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e7_1", r7_1, folio);
                        }
                        if(ctvP8.isChecked() == false && r8.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e8", r8, folio);
                        }
                        if(ctvP9.isChecked() == false && r9.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e9", r9, folio);
                        }
                        if(ctvP10.isChecked() == false && r10.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e10", r10, folio);
                        }
                        if(ctvP11.isChecked() == false && r11.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e11", r11, folio);
                        }
                        if(ctvP12.isChecked() == false && r12.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e12", r12, folio);
                        }
                        if(ctvP13.isChecked() == false && r13.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e13", r13, folio);
                        }
                        if(ctvP14.isChecked() == false && r14.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e14", r14, folio);
                        }
                        if(ctvP15.isChecked() == false && r15.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e15", r15, folio);
                        }
                        if(ctvP16.isChecked() == false && r16.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e16", r16, folio);
                        }
                        if(ctvP32_1.isChecked() == false && r32_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e32_1", r32_1, folio);
                        }
                        if(ctvP17.isChecked() == false && r17.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e17", r17, folio);
                        }
                        if(ctvP18.isChecked() == false && r18.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e18", r18, folio);
                        }
                        if(ctvP19.isChecked() == false && r19.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e19", r19, folio);
                        }
                        if(ctvP20.isChecked() == false && r20.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e20", r20, folio);
                        }
                        if(ctvP21_1.isChecked() == false && r21_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "TieneDomicilioS", r21_1, folio);
                        }
                        if(ctvP21.isChecked() == false && r21.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e21", r21, folio);
                        }
                        if(ctvP22.isChecked() == false && r22.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e22", r22, folio);
                        }
                        if(ctvP23.isChecked() == false && r23.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e23", r23, folio);
                        }
                        if(ctvP24.isChecked() == false && r24.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e24", r24, folio);
                        }
                        if(ctvP25.isChecked() == false && r25.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e25", r25, folio);
                        }
                        if(ctvP26.isChecked() == false && r26.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e26", r26, folio);
                        }
                        if(ctvP27.isChecked() == false && r27.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e27", r27, folio);
                        }
                        if(ctvP28.isChecked() == false && r28.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e28", r28, folio);
                        }
                        if(ctvP101.isChecked() == false && r101.isEmpty() == false) {
                            db.updateTable("imputado_datos_victima", "e101", r101, folio);
                        }
                        if(ctvP102.isChecked() == false && r102.isEmpty() == false) {
                            db.updateTable("imputado_datos_victima", "e102", r102, folio);
                        }
                        if(ctvP103.isChecked() == false && r103.isEmpty() == false) {
                            db.updateTable("imputado_datos_victima", "e103", r103, folio);
                        }
                        if(ctvP104.isChecked() == false && r104.isEmpty() == false) {
                            db.updateTable("imputado_datos_victima", "e104", r104, folio);
                        }
                        if(ctvP105.isChecked() == false && r105.isEmpty() == false) {
                            db.updateTable("imputado_datos_victima", "e105", r105, folio);
                        }
                        if(ctvP29.isChecked() == false && r29.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e29", r29, folio);
                        }
                        if(ctvP30.isChecked() == false && r30.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e30", r30, folio);
                        }
                        if(ctvP31.isChecked() == false && r31.isEmpty() == false) {
                            db.updateTable("imputado_datos_domicilio", "e31", r31, folio);
                        }
                        if(ctvP31_1.isChecked() == false && r31_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "Delito", r31_1, folio);
                        }
                        if(ctvP31_2.isChecked() == false && r31_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "OtroDelito", r31_2, folio);
                        }
                        if(ctvP32.isChecked() == false && r32.isEmpty() == false) {
                            db.updateTable("imputado_datos_generales", "OtrosHabitantes", r32, folio);
                        }
                        if(ctvP33.isChecked() == false && r33.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e33", r33, folio);
                        }
                        if(ctvP34.isChecked() == false && r34.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e34", r34, folio);
                        }
                        if(ctvP35.isChecked() == false && r35.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e35", r35, folio);
                        }
                        if(ctvP36.isChecked() == false && r36.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e36", r36, folio);
                        }
                        if(ctvP37.isChecked() == false && r37.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e37", r37, folio);
                        }
                        if(ctvP33_1.isChecked() == false && r33_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e33_1", r33_1, folio);
                        }
                        if(ctvP34_1.isChecked() == false && r34_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e34_1", r34_1, folio);
                        }
                        if(ctvP35_1.isChecked() == false && r35_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e35_1", r35_1, folio);
                        }
                        if(ctvP36_1.isChecked() == false && r36_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e36_1", r36_1, folio);
                        }
                        if(ctvP37_1.isChecked() == false && r37_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e37_1", r37_1, folio);
                        }
                        if(ctvP33_2.isChecked() == false && r33_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e33_2", r33_2, folio);
                        }
                        if(ctvP34_2.isChecked() == false && r34_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e34_2", r34_2, folio);
                        }
                        if(ctvP35_2.isChecked() == false && r35_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e35_2", r35_2, folio);
                        }
                        if(ctvP36_2.isChecked() == false && r36_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e36_2", r36_2, folio);
                        }
                        if(ctvP37_2.isChecked() == false && r37_2.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e37_2", r37_2, folio);
                        }
                        if(ctvP33_3.isChecked() == false && r33_3.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e33_3", r33_3, folio);
                        }
                        if(ctvP34_3.isChecked() == false && r34_3.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e34_3", r34_3, folio);
                        }
                        if(ctvP35_3.isChecked() == false && r35_3.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e35_3", r35_3, folio);
                        }
                        if(ctvP36_3.isChecked() == false && r36_3.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e36_3", r36_3, folio);
                        }
                        if(ctvP37_3.isChecked() == false && r37_3.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e37_3", r37_3, folio);
                        }
                        if(ctvP38.isChecked() == false && r38.isEmpty() == false) {
                            db.updateTable("imputado_datos_habitantes", "e38", r38, folio);
                        }
                        if(ctvP39.isChecked() == false && r39.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e39", r39, folio);
                        }
                        if(ctvP40.isChecked() == false && r40.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e40", r40, folio);
                        }
                        if(ctvP41.isChecked() == false && r41.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e41", r41, folio);
                        }
                        if(ctvP42.isChecked() == false && r42.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e42", r42, folio);
                        }
                        if(ctvP43.isChecked() == false && r43.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e43", r43, folio);
                        }
                        if(ctvP39_1.isChecked() == false && r39_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e39_1", r39_1, folio);
                        }
                        if(ctvP40_1.isChecked() == false && r40_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e40_1", r40_1, folio);
                        }
                        if(ctvP41_1.isChecked() == false && r41_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e41_1", r41_1, folio);
                        }
                        if(ctvP42_1.isChecked() == false && r42_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e42_1", r42_1, folio);
                        }
                        if(ctvP43_1.isChecked() == false && r43_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e43_1", r43_1, folio);
                        }
                        if(ctvP44.isChecked() == false && r44.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e44", r44, folio);
                        }
                        if(ctvP45.isChecked() == false && r45.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e45", r45, folio);
                        }
                        if(ctvP46.isChecked() == false && r46.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e46", r46, folio);
                        }
                        if(ctvP47.isChecked() == false && r47.isEmpty() == false) {
                            db.updateTable("imputado_datos_referencias", "e47", r47, folio);
                        }
                        if(ctvP48.isChecked() == false && r48.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e48", r48, folio);
                        }
                        if(ctvP49.isChecked() == false && r49.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e49", r49, folio);
                        }
                        if(ctvP50.isChecked() == false && r50.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e50", r50, folio);
                        }
                        if(ctvP51.isChecked() == false && r51.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e51", r51, folio);
                        }
                        if(ctvP52.isChecked() == false && r52.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e52", r52, folio);
                        }
                        if(ctvP53.isChecked() == false && r53.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e53", r53, folio);
                        }
                        if(ctvP54.isChecked() == false && r54.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e54", r54, folio);
                        }
                        if(ctvP55.isChecked() == false && r55.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e55", r55, folio);
                        }
                        if(ctvP57.isChecked() == false && r57.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e57", r57, folio);
                        }
                        if(ctvP56.isChecked() == false && r56.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e56", r56, folio);
                        }
                        if(ctvP58.isChecked() == false && r58.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e58", r58, folio);
                        }
                        if(ctvP51_1.isChecked() == false && r51_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e51_1", r51_1, folio);
                        }
                        if(ctvP59.isChecked() == false && r59.isEmpty() == false) {
                            db.updateTable("imputado_datos_historial_escolar_laboral", "e59", r59, folio);
                        }
                        if(ctvP60.isChecked() == false && r60.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e60", r60, folio);
                        }
                        if(ctvP61.isChecked() == false && r61.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e61", r61, folio);
                        }
                        if(ctvP62.isChecked() == false && r62.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e62", r62, folio);
                        }
                        if(ctvP63.isChecked() == false && r63.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e63", r63, folio);
                        }
                        if(ctvP64.isChecked() == false && r64.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e64", r64, folio);
                        }
                        if(ctvP65.isChecked() == false && r65.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e65", r65, folio);
                        }
                        if(ctvP66.isChecked() == false && r66.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e66", r66, folio);
                        }
                        if(ctvP67.isChecked() == false && r67.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e67", r67, folio);
                        }
                        if(ctvP68.isChecked() == false && r68.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e68", r68, folio);
                        }
                        if(ctvP69.isChecked() == false && r69.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e69", r69, folio);
                        }
                        if(ctvP70.isChecked() == false && r70.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e70", r70, folio);
                        }
                        if(ctvP71.isChecked() == false && r71.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e71", r71, folio);
                        }
                        if(ctvP72.isChecked() == false && r72.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e72", r72, folio);
                        }
                        if(ctvP67_1.isChecked() == false && r67_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e67_1", r67_1, folio);
                        }
                        if(ctvP68_1.isChecked() == false && r68_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e68_1", r68_1, folio);
                        }
                        if(ctvP69_1.isChecked() == false && r69_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e69_1", r69_1, folio);
                        }
                        if(ctvP70_1.isChecked() == false && r70_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e70_1", r70_1, folio);
                        }
                        if(ctvP71_1.isChecked() == false && r71_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e71_1", r71_1, folio);
                        }
                        if(ctvP72_1.isChecked() == false && r72_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e72_1", r72_1, folio);
                        }
                        if(ctvP73.isChecked() == false && r73.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e73", r73, folio);
                        }
                        if(ctvP74.isChecked() == false && r74.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e74", r74, folio);
                        }
                        if(ctvP75.isChecked() == false && r75.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e75", r75, folio);
                        }
                        if(ctvP76.isChecked() == false && r76.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e76", r76, folio);
                        }
                        if(ctvP77.isChecked() == false && r77.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e77", r77, folio);
                        }
                        if(ctvP78.isChecked() == false && r78.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e78", r78, folio);
                        }
                        if(ctvP74_1.isChecked() == false && r74_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e74_1", r74_1, folio);
                        }
                        if(ctvP75_1.isChecked() == false && r75_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e75_1", r75_1, folio);
                        }
                        if(ctvP76_1.isChecked() == false && r76_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e76_1", r76_1, folio);
                        }
                        if(ctvP77_1.isChecked() == false && r77_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e77_1", r77_1, folio);
                        }
                        if(ctvP78_1.isChecked() == false && r78_1.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e78_1", r78_1, folio);
                        }
                        if(ctvP79.isChecked() == false && r79.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e79", r79, folio);
                        }
                        if(ctvP80.isChecked() == false && r80.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e80", r80, folio);
                        }
                        if(ctvP81.isChecked() == false && r81.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_estado", "e81", r81, folio);
                        }
                        if(ctvP82.isChecked() == false && r82.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e82", r82, folio);
                        }
                        if(ctvP90_alcohol.isChecked() == false && r90_alcohol.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_alcohol", r90_alcohol, folio);
                        }
                        if(ctvP91_alcohol.isChecked() == false && r91_alcohol.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_alcohol", r91_alcohol, folio);
                        }
                        if(ctvP92_alcohol.isChecked() == false && r92_alcohol.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_alcohol", r92_alcohol, folio);
                        }
                        if(ctvP83.isChecked() == false && r83.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e83", r83, folio);
                        }
                        if(ctvP90_tabaco.isChecked() == false && r90_tabaco.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_tabaco", r90_tabaco, folio);
                        }
                        if(ctvP91_tabaco.isChecked() == false && r91_tabaco.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_tabaco", r91_tabaco, folio);
                        }
                        if(ctvP92_tabaco.isChecked() == false && r92_tabaco.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_tabaco", r92_tabaco, folio);
                        }
                        if(ctvP84.isChecked() == false && r84.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e84", r84, folio);
                        }
                        if(ctvP90_marihuana.isChecked() == false && r90_marihuana.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_marihuana", r90_marihuana, folio);
                        }
                        if(ctvP91_marihuana.isChecked() == false && r91_marihuana.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_marihuana", r91_marihuana, folio);
                        }
                        if(ctvP92_marihuana.isChecked() == false && r92_marihuana.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_marihuana", r92_marihuana, folio);
                        }
                        if(ctvP85.isChecked() == false && r85.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e85", r85, folio);
                        }
                        if(ctvP90_pastillas.isChecked() == false && r90_pastillas.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_pastillas", r90_pastillas, folio);
                        }
                        if(ctvP91_pastillas.isChecked() == false && r91_pastillas.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_pastillas", r91_pastillas, folio);
                        }
                        if(ctvP92_pastillas.isChecked() == false && r92_pastillas.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_pastillas", r92_pastillas, folio);
                        }
                        if(ctvP86.isChecked() == false && r86.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e86", r86, folio);
                        }
                        if(ctvP90_solventes.isChecked() == false && r90_solventes.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_solventes", r90_solventes, folio);
                        }
                        if(ctvP91_solventes.isChecked() == false && r91_solventes.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_solventes", r91_solventes, folio);
                        }
                        if(ctvP92_solventes.isChecked() == false && r92_solventes.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_solventes", r92_solventes, folio);
                        }
                        if(ctvP87.isChecked() == false && r87.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e87", r87, folio);
                        }
                        if(ctvP90_cristal.isChecked() == false && r90_cristal.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_cristal", r90_cristal, folio);
                        }
                        if(ctvP91_cristal.isChecked() == false && r91_cristal.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_cristal", r91_cristal, folio);
                        }
                        if(ctvP92_cristal.isChecked() == false && r92_cristal.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_cristal", r92_cristal, folio);
                        }
                        if(ctvP88.isChecked() == false && r88.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e88", r88, folio);
                        }
                        if(ctvP90_cocaina.isChecked() == false && r90_cocaina.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_cocaina", r90_cocaina, folio);
                        }
                        if(ctvP91_cocaina.isChecked() == false && r91_cocaina.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_cocaina", r91_cocaina, folio);
                        }
                        if(ctvP92_cocaina.isChecked() == false && r92_cocaina.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_cocaina", r92_cocaina, folio);
                        }
                        if(ctvP89.isChecked() == false && r89.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e89", r89, folio);
                        }
                        if(ctvP93_otroConsumo.isChecked() == false && r93_otroConsumo.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e93_otroConsumo", r93_otroConsumo, folio);
                        }
                        if(ctvP90_otroConsumo.isChecked() == false && r90_otroConsumo.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e90_otroConsumo", r90_otroConsumo, folio);
                        }
                        if(ctvP91_otroConsumo.isChecked() == false && r91_otroConsumo.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e91_otroConsumo", r91_otroConsumo, folio);
                        }
                        if(ctvP92_otroConsumo.isChecked() == false && r92_otroConsumo.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e92_otroConsumo", r92_otroConsumo, folio);
                        }
                        if(ctvP94.isChecked() == false && r94.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e94", r94, folio);
                        }
                        if(ctvP95.isChecked() == false && r95.isEmpty() == false) {
                            db.updateTable("imputado_datos_abandono_salud", "e95", r95, folio);
                        }
                        //endregion

                        //Verificación
                        if(oper.equals(opers[0])) {
                            Toast.makeText(getApplicationContext(), "Entrevista Verificada", Toast.LENGTH_SHORT).show();
                        }
                        //Edición
                        else {
                            Toast.makeText(getApplicationContext(), "Entrevista Actualizada", Toast.LENGTH_SHORT).show();
                        }

                        Intent intent= new Intent(v.getContext(), MainMenu.class);
                        startActivity(intent);
                    }
                });
                //endregion
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        sP108 = (Spinner) findViewById(R.id.sP108);
        sP108.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opers));

        tvP109 = (TextView) findViewById(R.id.tvP109);
        etP109 = (EditText) findViewById(R.id.etP109);
        tvP110 = (TextView) findViewById(R.id.tvP110);
        etP110 = (EditText) findViewById(R.id.etP110);

        sP108.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Verificación
                if(position == 0){
                    tvP109.setVisibility(View.VISIBLE);
                    etP109.setVisibility(View.VISIBLE);
                    tvP110.setVisibility(View.VISIBLE);
                    etP110.setVisibility(View.VISIBLE);
                }
                //Edición
                else{
                    tvP109.setVisibility(View.GONE);
                    etP109.setVisibility(View.GONE);
                    tvP110.setVisibility(View.GONE);
                    etP110.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //region Separators
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
}