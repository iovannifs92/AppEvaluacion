package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosAbandonoEstado;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosEscolarLaboral;
import com.sistemas.evaluacion.entidades.datosEvaluacion;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosHabitantes;
import com.sistemas.evaluacion.entidades.datosObservaciones;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.itextpdf.text.BaseColor;

public class Instrumento extends AppCompatActivity implements View.OnClickListener {

    //region Variables Globales
    private String [] sometimiento = {"Si, colaboración durante la detención", "No, resistencia a la detención"};
    private String [] antecedentes = {"Absuelto, sin sentencia o termino de prescripción", "Vinculado a proceso, con proceso vigente", "Sentenciado"};
    private String [] medidas = {"No se impusieron medidas", "Si", "No"};
    private String[] header={"ASPECTOS", "VALORACIÓN"};
    private Integer [] V4 = {-3, 3};
    private Integer [] V5 = {-2, 1, 2};
    private Integer [] V6 = {0, -1, 2};
    private Integer v, v1, v2, v3, v4, v5, v6, total;
    private TemplatePDF templatePDF;
    private ArrayList<datosGenerales> lista;
    private ArrayList<Integer> Idx;//Indice de la lista completa de imputados
    private TextView tvNoRecords, tvA1, tvA2, tvA3, tvA4, tvA5, tvA6, tvTotal, tvScale;
    private Spinner sName, sA4, sA5, sA6;
    private Button btnGuardarEvaluacion, btnGenerarReporte;
    private LinearLayout llVisibility, llSpinners;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumento);

        final MyOpenHelper db;
        db = new MyOpenHelper(this);
        db.getReadableDatabase();

        lista = db.getDatosGenerales();

        final ArrayList<datosDomicilio> addresses;
        addresses = db.getDomicilios();

        final ArrayList<datosHabitantes> habitantes;
        habitantes = db.getHabitantes();

        final ArrayList<datosEscolarLaboral> historialEscolarLaboral;
        historialEscolarLaboral = db.getHistorialEscolarLaboral();

        final ArrayList<datosAbandonoEstado> listaAbandonoEstado;
        listaAbandonoEstado = db.getDatosAbandonoEstado();

        final ArrayList<datosObservaciones> observaciones;
        observaciones = db.getObservaciones();

        tvA1 = (TextView) findViewById(R.id.tvA1);
        tvA2 = (TextView) findViewById(R.id.tvA2);
        tvA3 = (TextView) findViewById(R.id.tvA3);
        tvA4 = (TextView) findViewById(R.id.tvA4);
        tvA5 = (TextView) findViewById(R.id.tvA5);
        tvA6 = (TextView) findViewById(R.id.tvA6);

        sA4 = (Spinner) findViewById(R.id.sA4);
        sA4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sometimiento));
        sA5 = (Spinner) findViewById(R.id.sA5);
        sA5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, antecedentes));
        sA6 = (Spinner) findViewById(R.id.sA6);
        sA6.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, medidas));

        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvScale = (TextView) findViewById(R.id.tvScale);

        llVisibility = (LinearLayout) findViewById(R.id.llVisibility);
        llSpinners = (LinearLayout) findViewById(R.id.llSpinners);

        tvNoRecords = (TextView) findViewById(R.id.tvNoRecords);

        //region Update the total score when a spinner is chosen
        sA4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v4 = V4[position];
                tvA4.setText(v4.toString());
                updateDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sA5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v5 = V5[position];
                tvA5.setText(v5.toString());
                updateDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sA6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                v6 = V6[position];
                tvA6.setText(v6.toString());
                updateDisplay();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region Inicializa un spinner con las verificaciones
        ArrayList<String> names = new ArrayList<String>();
        Idx = new ArrayList<Integer>();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getTieneVerificacion().equals("SI")) {
                names.add(lista.get(i).getNombre());
                Idx.add(i);
            }
        }

        sName = (Spinner) findViewById(R.id.sName);
        sName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //Display the last element or do not display anything when there are no elements
        if(names.isEmpty()){
            llVisibility.setVisibility(View.GONE);
            tvNoRecords.setVisibility(View.VISIBLE);
        }
        else {
            llVisibility.setVisibility(View.VISIBLE);
            tvNoRecords.setVisibility(View.GONE);
            sName.setSelection(names.size() - 1);
        }
        //endregion

        sName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int spinner_position, long id) {
                int position = Idx.get(spinner_position);
                if(lista.get(position).getTieneEvaluacion().equals("SI")){
                    llSpinners.setVisibility(View.GONE);
                    btnGuardarEvaluacion.setVisibility(View.GONE);

                    //region Load the saved evaluation to display it
                    ArrayList<datosEvaluacion> evaluacion = db.getEvaluacionRiesgos();

                    String folio = lista.get(position).getFolio();

                    int pos = 0;
                    while (pos < evaluacion.size() && evaluacion.get(pos).getFolio().equals(folio) == false) {
                        pos++;
                    }

                    v1 = evaluacion.get(pos).getArraigo();
                    v2 = evaluacion.get(pos).getResidenciaEdo();
                    v3 = evaluacion.get(pos).getAbandonoEdo();
                    v4 = evaluacion.get(pos).getVoluntadSometimiento();
                    v5 = evaluacion.get(pos).getAntecedentes();
                    v6 = evaluacion.get(pos).getMedidasNoPrivativas();

                    v = v1 + v2 + v3;
                    updateDisplay();

                    tvA1.setText(v1.toString());
                    tvA2.setText(v2.toString());
                    tvA3.setText(v3.toString());
                    tvA4.setText(v4.toString());
                    tvA5.setText(v5.toString());
                    tvA5.setText(v6.toString());
                    //endregion
                }
                else {
                    llSpinners.setVisibility(View.VISIBLE);
                    btnGuardarEvaluacion.setVisibility(View.VISIBLE);

                    boolean flag1, flag2, flag3, flag4, flag5, flag6, fakeAddress;
                    v = 0;
                    //region Imposibilidad de arraigo
                    //Falsedad del domicilio
                    String folio = lista.get(position).getFolio();
                    fakeAddress = false;
                    for (int pos = 0; pos < observaciones.size(); pos++) {
                        if (observaciones.get(pos).getFolio().equals(folio)) {
                            fakeAddress = observaciones.get(pos).getField().equals("e7") || observaciones.get(pos).getField().equals("e7_1") ||
                                    observaciones.get(pos).getField().equals("e8") || observaciones.get(pos).getField().equals("e9") ||
                                    observaciones.get(pos).getField().equals("e10");
                        }
                    }
                    flag1 = fakeAddress;
                    //Indigente
                    String tipoDomicilio = addresses.get(position).getE11();
                    flag2 = tipoDomicilio.equals("SITUACIÓN DE CALLE");
                    //Domicilio en otro estado
                    String estado = addresses.get(position).getE10();
                    flag3 = estado.equals("DURANGO") && estado.equals("DGO");
                    //Sin domicilio fijo
                    flag4 = tipoDomicilio.equals("IRREGULAR");

                    v1 = 0;
                    if (flag1 || flag2 || flag3 || flag4) {
                        v1 = 8;
                    }
                    v += v1;
                    tvA1.setText(v1.toString());
                    //endregion

                    //region Residencia habitual dentro del estado
                    //Se ha establecido por mas de 6 meses
                    flag1 = addresses.get(position).getE13().equals("ENTRE 6 MESES Y UN AÑO") ||
                            addresses.get(position).getE13().equals("ENTRE 1 Y 3 AÑOS") ||
                            addresses.get(position).getE13().equals("ENTRE 3 Y 6 AÑOS") ||
                            addresses.get(position).getE13().equals("MÁS DE 6 AÑOS");
                    //Labora con relación formal
                    flag2 = historialEscolarLaboral.get(position).getE51().equals("SI");
                    //Estudia
                    flag3 = historialEscolarLaboral.get(position).getE48().equals("SI");

                    v2 = 0;
                    if (flag1) {
                        if (flag2 || flag3) {
                            v2 = -1;
                        }
                    } else {
                        if (flag2 == false && flag3 == false) {
                            v2 = 1;
                        }
                    }
                    v += v2;
                    tvA2.setText(v2.toString());
                    //endregion

                    //region Asiento de la familia
                    flag1 = addresses.get(position).getE32_1().equals("SI");
                    String e32 = habitantes.get(position).getE32();
                    int personas;
                    personas = Integer.parseInt(e32);
                    if (personas >= 1) {
                        flag2 = habitantes.get(position).getE34().equals("HIJO") || habitantes.get(position).getE34().equals("HIJA");
                    } else {
                        flag2 = false;
                    }
                    if (personas >= 2) {
                        flag3 = habitantes.get(position).getE34_1().equals("HIJO") || habitantes.get(position).getE34_1().equals("HIJA");
                    } else {
                        flag3 = false;
                    }
                    if (personas >= 3) {
                        flag4 = habitantes.get(position).getE34_2().equals("HIJO") || habitantes.get(position).getE34_2().equals("HIJA");
                    } else {
                        flag4 = false;
                    }
                    if (personas >= 4) {
                        flag5 = habitantes.get(position).getE34_3().equals("HIJO") || habitantes.get(position).getE34_3().equals("HIJA");
                    } else {
                        flag5 = false;
                    }
                    flag6 = fakeAddress;

                    Integer v3a = 0;
                    if ((flag1 == false && (flag2 || flag3 || flag4 || flag5) == false) || flag6) {
                        v3a = 1;
                    }
                    //endregion

                    //region Facilidades para abandonar el lugar
                    //region Ha salido fuera del país
                    flag1 = listaAbandonoEstado.get(position).getE60().equals("SI");

                    Integer v3b = 0;
                    if (flag1) {
                        v3b = 1;
                    }
                    //endregion

                    //region Familia o conocidos en otro país
                    flag1 = listaAbandonoEstado.get(position).getE66().equals("SI");

                    Integer v3c = 0;
                    if (flag1) {
                        v3c = 1;
                    }
                    //endregion

                    //region Familia o conocidos en otro estado
                    flag1 = listaAbandonoEstado.get(position).getE73().equals("SI");

                    Integer v3d = 0;
                    if (flag1) {
                        v3d = 1;
                    }
                    //endregion
                    //endregion

                    //region Facilidades para permanecer oculto
                    flag1 = fakeAddress;
                    flag2 = lista.get(position).getTieneDomicilioS().equals("SI");

                    Integer v3e = 0;
                    if (flag1 || flag2) {
                        v3e = 1;
                    }
                    //endregion

                    v3 = v3a + v3b + v3c + v3d + v3e;
                    v += v3;
                    tvA3.setText(v3.toString());

                    //Initialize default selections
                    sA4.setSelection(0);
                    sA5.setSelection(0);
                    sA6.setSelection(0);

                    int pos;
                    pos = sA4.getSelectedItemPosition();
                    v4 = V4[pos];

                    pos = sA5.getSelectedItemPosition();
                    v5 = V5[pos];

                    pos = sA6.getSelectedItemPosition();
                    v6 = V6[pos];

                    updateDisplay();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGuardarEvaluacion = (Button) findViewById(R.id.btnGuardarEvaluacion);
        btnGuardarEvaluacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = sName.getSelectedItemPosition();
                String folio = lista.get(Idx.get(pos)).getFolio();
                db.insertarEvaluacionRiesgos(v1, v2, v3, v4, v5, v6, total, folio);

                db.updateTable("imputado_datos_generales", "TieneEvaluacion", "SI", folio);

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivity(intent);
            }
        });

        btnGenerarReporte = (Button) findViewById(R.id.btnGenerarReporte);
        btnGenerarReporte.setOnClickListener(this);
    }

    //region Refresh the screen to display the correct total
    void updateDisplay(){
        total = v + v4 + v5 + v6;
        tvTotal.setText(total.toString());
        if(total <= -3) {
            tvScale.setText("RIESGO BAJO");
            tvScale.setBackgroundResource(R.color.green);
        }
        else if(total >= 3){
            tvScale.setText("RIESGO ALTO");
            tvScale.setBackgroundResource(R.color.red);
        }
        else {
            tvScale.setText("RIESGO MEDIO");
            tvScale.setBackgroundResource(R.color.yellow);
        }
    }
    //endregion

    //region Create and display the report in PDF format
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGenerarReporte:
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);

                int pos = sName.getSelectedItemPosition();
                String folio = lista.get(Idx.get(pos)).getFolio();;

                templatePDF=new TemplatePDF(getApplicationContext());
                templatePDF.openDocument();
                templatePDF.addImgName("membrete.png");
                templatePDF.addMetaData("Instrumento de Evaluación", "FOLIO", "SCORPION");
                templatePDF.addTitles("INSTRUMENTO DE EVALUACIÓN PARA DELITOS CONTRA LA SALUD PÚBLICA, FEDERALES Y CUYA VÍCTIMA ES LA SOCIEDAD",folio, fecha);
                templatePDF.createTable(header, getImputado());

                //Color the risk
                String r = tvScale.getText().toString();
                if(total <= -3) {
                    templatePDF.addParagraph(r, BaseColor.GREEN);
                }
                else if(total >= 3){
                    templatePDF.addParagraph(r, BaseColor.RED);
                }
                else {
                    templatePDF.addParagraph(r, BaseColor.YELLOW);
                }

                templatePDF.closeDocument();
                templatePDF.appViewPDF(this);
                break;
        }
    }
    //endregion

    private ArrayList<String[]> getImputado(){
        ArrayList<String[]> rows=new ArrayList<>();
        rows.add(new String[]{getString(R.string.A1), v1.toString()});
        rows.add(new String[]{getString(R.string.A2), v2.toString()});
        rows.add(new String[]{getString(R.string.A3), v3.toString()});
        rows.add(new String[]{getString(R.string.A4), v4.toString()});
        rows.add(new String[]{getString(R.string.A5), v5.toString()});
        rows.add(new String[]{getString(R.string.A6), v6.toString()});
        total = v + v4 + v5 + v6;
        rows.add(new String[]{getString(R.string.total), total.toString()});
        return rows;
    }
}
