package com.sistemas.evaluacion;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosActividadesExtraescolaresA;
import com.sistemas.evaluacion.entidades.datosConsumoSustanciasA;
import com.sistemas.evaluacion.entidades.datosDependientesEconomicosA;
import com.sistemas.evaluacion.entidades.datosEvaluacion;
import com.sistemas.evaluacion.entidades.datosFamiliaresA;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosGeneralesA;
import com.sistemas.evaluacion.entidades.datosHistorialEscolarA;
import com.sistemas.evaluacion.entidades.datosHistorialLaboralA;
import com.sistemas.evaluacion.entidades.datosInformacionCasoA;
import com.sistemas.evaluacion.entidades.datosObservaciones;
import com.sistemas.evaluacion.entidades.datosObservacionesA;
import com.sistemas.evaluacion.entidades.datosProcesoLegalA;
import com.sistemas.evaluacion.entidades.datosProcesosPenalesA;
import com.sistemas.evaluacion.entidades.datosRevisionMedicaA;
import com.sistemas.evaluacion.entidades.datosVictima;
import com.sistemas.evaluacion.entidades.datosVictimaOfendidoA;

import net.glxn.qrgen.android.QRCode;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class instrumento_adolescente extends AppCompatActivity implements View.OnClickListener {


    private MyOpenHelper db;
    ArrayList<datosGeneralesA> lista1;
    private ArrayList<Integer> IdxA;//Indice de la lista completa de imputados


    private TextView tvFolioAI,tvA2;
    private TextView tvPa,tvPb,tvPc,tvPd,tvRa,tvRb,tvRc;
    private Spinner sPNomAI;
    private LinearLayout llVisibilityA;

    private String[] header={"Riesgo", "Puntaje", "Riesgo"};
    private String[] header1={"RECOMENDACIONES"};
    private String[] header2={"CASOS EXCEPCIONALES Y CONSIDERACIONES"};
    private TemplatePDF templatePDF1;
    ////TOTALES
    private Integer v,vt1,vt2,vt3,vt4,vt5,tv6,vt7,vtt;
    //respuestas largas
    private Integer vr1,vr2,vr3,vr4,vr5,vr6,vr7,vr8,vr123,vr46,vr57;
    //respuestascortas
    private Integer r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16;

    private Button btnGuardarEvaluacionA;
    private Button btnGenerarReporteA;
    // Strings para gusardar respuestas en las db
    private String FOLIOA,ra123,rb46,rc57,rarec,racaso1,racaso2,racaso3;//,gr1,gr2,gr3,gr4,gr5,gr6,gr7,gr8,gr9,gr10,gr11,gr12;
    private Integer gr1,gr2,gr3,gr4,gr5,gr6,gr7,gr8,gr9,gr10,gr11,gr12;

    private TextView tvNoRecords,tr1,tr2,tr3,tr4,tr5,tr6,tr7,tr8,tr9,tr10,tr11,tr12,tr13,tr14,tr15,tr16,tr17,tr18,tr19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrumento_adolescente);

        final MyOpenHelper db;
        db=new MyOpenHelper(this);
        db.getReadableDatabase();
        lista1 = db.getdatosGeneralesA();

        final ArrayList<datosGeneralesA> lista1;
        lista1 = db.getdatosGeneralesA();

        final ArrayList<datosFichaFamiliarA> famili;
        famili = db.getdatosFichaFamiliarA();

        final ArrayList<datosFamiliaresA> dfamili;
        dfamili = db.getdatosFamiliaresA(); //

        final ArrayList<datosDependientesEconomicosA> dependientes;
        dependientes = db.getdatosDependientesEconomicosA();

        final ArrayList<datosHistorialEscolarA> escolar;
        escolar = db.getdatosHistorialEscolarA();

        final ArrayList<datosHistorialLaboralA> labor;
        labor = db.getdatosHistorialLaboralA();

        final ArrayList<datosActividadesExtraescolaresA> actividades;
        actividades = db.getdatosActividadesExtraescolaresA();

        final ArrayList<datosRevisionMedicaA> salud;
        salud = db.getdatosRevisionMedicaA();

        final ArrayList<datosConsumoSustanciasA> consumo;
        consumo = db.getdatosConsumoSustanciasA();

        final ArrayList<datosInformacionCasoA> caso;
        caso = db.getdatosInformacionCasoA();

        final ArrayList<datosProcesosPenalesA> penal;
        penal = db.getdatosProcesosPenalesA();

        final ArrayList<datosVictimaOfendidoA> victima;
        victima = db.getdatosVictimaOfendidoA();

        final ArrayList<datosProcesoLegalA> proceso;
        proceso = db.getdatosProcesoLegalA();


        final ArrayList<datosObservacionesA> observacionesA;
        observacionesA = db.insertarDatosObservacionesA();

        tvA2 = (TextView) findViewById(R.id.tvA2);
        tr8 = (TextView) findViewById(R.id.tr8);
        tr9 = (TextView) findViewById(R.id.tr9);
        tr10 = (TextView) findViewById(R.id.tr10);
        tr11 = (TextView) findViewById(R.id.tr11);

        tvPa = (TextView) findViewById(R.id.tvPa);
        tvPb = (TextView) findViewById(R.id.tvPb);
        tvPc = (TextView) findViewById(R.id.tvPc);
        tvPd = (TextView) findViewById(R.id.tvPd);

        tvRa = (TextView) findViewById(R.id.tvRa);
        tvRb = (TextView) findViewById(R.id.tvRb);
        tvRc = (TextView) findViewById(R.id.tvRc);

        llVisibilityA=(LinearLayout) findViewById(R.id.llVisibilityA);

        //region Inicializa un spinner con los nombres de los entrevistados
        ArrayList<String> names = new ArrayList<String>();
        IdxA = new ArrayList<Integer>();
        for(int i = 0; i < lista1.size(); i++){
            if(lista1.get(i).getAverificacion().equals("SI") && lista1.get(i).getAcarpetainvestigacion().equals("SI")) {
                names.add(lista1.get(i).getAnombre()+" "+lista1.get(i).getApaterno()+" "+ lista1.get(i).getAmaterno());
                IdxA.add(i);
            }
        }
        sPNomAI = (Spinner) findViewById(R.id.sPNomAI);
        sPNomAI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion
        //Display the last element or do not display anything when there are no elements
        tvNoRecords=(TextView) findViewById(R.id.tvNoRecords);
        if(names.isEmpty()){
            llVisibilityA.setVisibility(View.GONE);
            tvNoRecords.setVisibility(View.VISIBLE);
        }
        else {
            llVisibilityA.setVisibility(View.VISIBLE);
            tvNoRecords.setVisibility(View.GONE);
            sPNomAI.setSelection(names.size() - 1);
        }
        //endregion

        sPNomAI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int spinner_position, long id) {
                int position = IdxA.get(spinner_position);
                //region Folio de Adolecente
                tvFolioAI = (TextView) findViewById(R.id.tvFolioAI);
                tvFolioAI.setText(lista1.get(position).getAfolio());
                FOLIOA=tvFolioAI.getText().toString().toUpperCase();

                //endregion
                v = 0;
                vr123 = 0;
                vr46 = 0;
                vr57 = 0;
                //region falsedad de domicilio
                boolean v1_1, v1_2, v1_3, v1_4, v1_5,v1_6;
                Integer r1a = 0, r1b = 0;
                v1_6 = famili.get(position).getAdomiciliof().equals("NO");
                v1_1 = famili.get(position).getAtemporalidad().equals("MENOS DE 1 AÑO Y MENOS DE 3 EN EL MUNICIPIO");
                v1_2 = famili.get(position).getAtemporalidad().equals("MENOS DE 1 AÑO Y MÁS DE 3 EN EL MUNICIPIO");
                v1_3 = famili.get(position).getAtemporalidad().equals("ENTRE 1 Y 2 AÑOS");
                v1_4 = famili.get(position).getAtemporalidad().equals("ENTRE 2 Y 5 AÑOS");
                v1_5 = famili.get(position).getAtemporalidad().equals("MÁS DE 5 AÑOS");
                //el campo temporalidad es obligatorio por lo cual nunca caera en N/A
                if (v1_5){
                    r1a=3;
                }else
                if (v1_4){
                    r1a=2;
                }else
                if (v1_3){
                    r1a=1;
                }else
                if (v1_2){
                    r1a=1;
                }else
                if (v1_1){
                    r1a=0;
                }else
                if (v1_6){
                    r1a=-1;
                }

                r1=r1a;


                //endregion

                //region de referencias
                boolean nd,v12_1a,v12_2a,v12_3a,v12_4a,v12_1b,v12_2b,v12_3b,v12_4b;
                Integer r12_1a = 0,r12_2a = 0,r12_3a = 0,r12_1b = 0,r12_2b = 0,r12_3b = 0,ra,rb,rc,rd;
                v12_1a = dfamili.get(position).getArelacion1().equals("PADRE") || dfamili.get(position).getArelacion1().equals("MADRE") ||
                        dfamili.get(position).getArelacion1().equals("ABUELO") || dfamili.get(position).getArelacion1().equals("ABUELA") ||
                        dfamili.get(position).getArelacion1().equals("HERMANO(A)") || dfamili.get(position).getArelacion1().equals("TUTOR(A)");
                v12_2a = dfamili.get(position).getArelacion1().equals("FAMILIA INDIRECTA");
                v12_3a = dfamili.get(position).getArelacion1().equals("CONOCIDO(A)");
                v12_4a = dfamili.get(position).getArelacion2().equals("N/A");
                //////
                v12_1b = dfamili.get(position).getArelacion2().equals("PADRE") || dfamili.get(position).getArelacion2().equals("MADRE") ||
                        dfamili.get(position).getArelacion2().equals("ABUELO") || dfamili.get(position).getArelacion2().equals("ABUELA") ||
                        dfamili.get(position).getArelacion2().equals("HERMANO(A)") || dfamili.get(position).getArelacion2().equals("TUTOR(A)");
                v12_2b = dfamili.get(position).getArelacion2().equals("FAMILIA INDIRECTA");
                v12_3b = dfamili.get(position).getArelacion2().equals("CONOCIDO(A)");



                switch (dfamili.get(position).getApersonasreferencias()){
                    case "N/A":
                        r2=0;
                        break;
                    case "1":
                        if (v12_1a){
                            r12_1a=3;
                        }else
                        if (v12_2a){
                            r12_1a=2;
                        }else
                        if (v12_3a){
                            r12_1a=0;
                        }r2=r12_1a;
                        break;
                    case "2":
                        if (v12_1a){
                            r12_1a=3;
                        }else
                        if (v12_2a){
                            r12_1a=2;
                        }else
                        if (v12_3a){
                            r12_1a=0;
                        }

                        if (v12_1b){
                            r12_1b=3;
                        }else
                        if (v12_2b){
                            r12_1b=2;
                        }else
                        if (v12_3b){
                            r12_1b=0;
                        }

                        if (r12_1a >= r12_1b){
                            r2=r12_1a;
                        }else{
                            r2=r12_1b;
                        }
                        break;
                }
                ///////////////DEPENDIENTES
                boolean v13;
                v13 = dependientes.get(position).getAdependientes().equals("SI");

                Integer r13_1 = 0;
                if (v13) {
                    r13_1 = 1;
                }
                r3 = r13_1;
                vr1=r1+r2+r3;
                //endregion

                //region HISTORIAL ESCOLAR Y LABORAL
                boolean v21_1, v21_2, v21_3, v21_4;
                Integer r2a = 0, r2b = 0, r2c = 0;
                v21_1 = escolar.get(position).getAasiste().equals("SI");
                v21_2 = escolar.get(position).getAasiste().equals("NO");
                v21_3 = escolar.get(position).getAconcluyo().equals("SI");
                v21_4 = escolar.get(position).getAconcluyo().equals("NO");


                if (v21_2 && v21_3) {
                    r2a = 1;
                }
                if (v21_1) {
                    r2a = 2;
                }else if (v21_2 && v21_4) {
                    r2a = -1;
                }
                r4 = r2a;

                ///////LABORAL
                boolean v22_1, v22_2, v22_3, v22_4;
                v22_1 = labor.get(position).getAtrabaja().equals("SI");
                v22_2 = labor.get(position).getAtrabaja().equals("SI") && labor.get(position).getAtiempo().equals("SI");
                v22_3 = labor.get(position).getAtrabaja().equals("NO");
                if (v22_2) {
                    r2b = 2;
                }else if (v22_1) {
                    r2b = 1;
                }else if (v22_3) {
                    r2b = 0;
                }
                r5 = r2b;


                //activides
                Boolean v23_1;
                v23_1 = actividades.get(position).getArealiza().equals("SI");
                if (v23_1) {
                    r2c = 1;
                }
                r6 = r2c;
                vr2=r4+r5+r6;
                //endregion

                //region CONSIDERACIONES EXEPCIONALES DEL ADOLECENTE
                Boolean v3_1, v3_2, v3_3, v3_4;
                Integer r3a = 0, r3b = 0, r3c = 0;
                v3_1 = salud.get(position).getAembarazada().equals("SI");
                v3_2 = salud.get(position).getAmadre().equals("SI");
                v3_3 = salud.get(position).getAdiscapacidad().equals("SI");
                v3_4 = salud.get(position).getAenfermendad().equals("SI");
                if (v3_1 || v3_2) {
                    r3a = 1;
                }
                if (v3_3) {
                    r3b = 1;
                }
                if (v3_4) {
                    r3c = 1;
                }
                r7 = r3a + r3b + r3c;
                vr3=r7;
                vr123=vr1+vr2+vr3;
                //endregion

                //encontrar el folio correspondiente
                int casoPos = -1;
                for(int i = 0; i < caso.size(); i++) {
                    if (caso.get(i).getAfolio().equals(lista1.get(position).getAfolio())) {
                        casoPos = i;
                        break;
                    }
                }

                if(caso.get(casoPos).getAexpedinte().equals("SI")) {
                    //region INFORMACION DEL CASO
                    Boolean v4_1, v4_2, v4_3, v4_4;
                    Integer r4a = 0, r4b = 0, r4c = 0, r4d = 0;
                    v4_1 = caso.get(casoPos).getAdelitomencionado_145().equals("SI");
                    v4_2 = caso.get(casoPos).getAdelitomencionado_164().equals("SI");
                    v4_3 = caso.get(casoPos).getAinternamieto().equals("SI");
                    if (v4_1) {
                        r4a = -6;
                    } else if (v4_2) {
                        r4a = -4;
                    } else if (v4_3) {
                        r4a = 0;
                    }
                    r8 = r4a;


                    v4_4 = caso.get(casoPos).getAhechosalegados().equals("SI");

                    if (v4_4) {
                        r4b = -2;
                    }
                    r9 = r4b;
                    vr4 = r8 + r9;

                    //endregion

                    //region PROCESOS PENALES PREVIOS*************
                    Boolean v5_1, v51_2, v52_2, v53_2, v54_2, v55_2, v5_3, v5_4;
                    Integer r5a = 0, r5b = 0, r5c = 0, r5d = 0;
                    v5_1 = penal.get(casoPos).getAproceso().equals("NO");
                    v51_2 = penal.get(casoPos).getAestatus1().equals("SUSPENDIDO") || penal.get(casoPos).getAestatus1().equals("REVOCADO");
                    v52_2 = penal.get(casoPos).getAestatus2().equals("SUSPENDIDO") || penal.get(casoPos).getAestatus1().equals("REVOCADO");
                    v53_2 = penal.get(casoPos).getAestatus3().equals("SUSPENDIDO") || penal.get(casoPos).getAestatus1().equals("REVOCADO");
                    v54_2 = penal.get(casoPos).getAestatus4().equals("SUSPENDIDO") || penal.get(casoPos).getAestatus1().equals("REVOCADO");
                    v55_2 = penal.get(casoPos).getAestatus5().equals("SUSPENDIDO") || penal.get(casoPos).getAestatus1().equals("REVOCADO");

                    if (v5_1) {
                        r5a = 0;
                    }
                    switch (penal.get(casoPos).getAnprocesos()) {
                        case "N/A":
                            r5a = 0;
                            break;
                        case "1":
                            if (v51_2) {
                                r5a = 0;
                            } else {
                                r5a = 2;
                            }
                            break;
                        case "2":
                            if (v51_2 || v52_2) {
                                r5a = 0;
                            } else {
                                r5a = 2;
                            }

                            break;
                        case "3":
                            if (v51_2 || v52_2 || v53_2) {
                                r5a = 0;
                            } else {
                                r5a = 2;
                            }
                            break;
                        case "4":
                            if (v51_2 || v52_2 || v53_2 || v54_2) {
                                r5a = 0;
                            } else {
                                r5a = 2;
                            }
                            break;
                        case "5":
                            if (v51_2 || v52_2 || v53_2 || v54_2 || v55_2) {
                                r5a = 0;
                            } else {
                                r5a = 2;
                            }
                            break;

                    }
                    r10 = r5a;
                    vr5 = r10;
                    //endregion

                    //region Victima u ofendido
                    Boolean v6_1, v6_2, v6_3, v6_4, v6_5, v6_6, v6_7, v6_8;
                    Integer r6a = 0, r6b = 0, r6c = 0, r6d = 0, r6e = 0;
                    v6_1 = victima.get(casoPos).getAexistevictima().equals("NO");
                    if (v6_1) {
                        r6a = 1;
                    }
                    r11 = r6a;

                    //SELECIONA UNA SOLA
                    v6_2 = victima.get(casoPos).getAvivedomicilio().equals("SI");
                    v6_4 = victima.get(casoPos).getAnovivevictima().equals("SI");
                    v6_5 = victima.get(casoPos).getAnovivevictima().equals("NO");
                    v6_3 = victima.get(casoPos).getAvivedomicilio().equals("NO");

                    if (v6_2) {
                        r6b = -3;
                    } else if (v6_3 && v6_4) {
                        r6b = -2;
                    } else if (v6_5 && v6_3) {
                        r6b = 0;
                    }
                    r12 = r6b;

                    v6_6 = victima.get(casoPos).getAcasomismodomicilio().equals("SI");
                    if (v6_6) {
                        r6c = 2;
                    }
                    r13 = r6c;

                    //ES UN DELITO
                    v6_7 = victima.get(casoPos).getAintegridad().equals("SI");
                    if (v6_7) {
                        r6d = -2;
                    }
                    v6_8 = victima.get(casoPos).getAintenciones().equals("SI");
                    if (v6_8) {
                        r6e = -2;
                    }
                    r14 = r6e;
                    r15 = r6d;
                    vr6 = r11 + r12 + r13 + r14 + r15;
                    vr46 = vr4 + vr6;

                    //endregion

                    //region PROCESOS LEGALES
                    Boolean v7_1, v7_2;
                    Integer r7a = 0, r7b = 0;
                    v7_1 = proceso.get(casoPos).getAriesgocontinuo().equals("SI");
                    if (v7_1) {
                        r7a = -2;
                    }
                    v7_2 = proceso.get(casoPos).getAamanazatestigo().equals("SI");
                    if (v7_2) {
                        r7b = -2;
                    }
                    r16 = r7a + r7b;
                    vr7 = r16;
                    vr57 = vr5 + vr7;
                }

                //region RECOMENDACION
                vtt = vr123 + vr46 + vr57;
                tvPd.setText("TOTAL: " + vtt.toString());
                //endregion

                String recomendacion = "";
                if (vtt >= 11) {
                    recomendacion = "Medida en libertad sin condiciones ";
                } else if (vtt >= 0 && vtt <= 10) {
                    recomendacion = "Medida cautelar en libertad";
                } else if (vtt <= -1) {
                    recomendacion = "Internamiento preventivo";
                }

                tr8.setText(recomendacion);
                rarec = tr8.getText().toString().toUpperCase();
                //endregion

                //region casos Exepcionales
                Boolean casoE;
                String CasoEx="";
                casoE = victima.get(casoPos).getAcasomismodomicilio().equals("SI");
                if (casoE){
                    CasoEx="A. Es necesario poner las condiciones adecuadas para que el adolescente se reubique";
                    tr9.setText(CasoEx);
                    tr9.setVisibility(View.VISIBLE);
                }else{
                    tr9.setVisibility(View.GONE);
                }
                //endregion

                //region Consumos
                Boolean cA,cT,cS,cM,cC,cP,cMe;
                String CA="",CT="",CS="",CM="",CC="",CP="",CME="";
                cA=consumo.get(position).getAconsume_alcohol().equals("SI");
                cT=consumo.get(position).getAconsume_tabaco().equals("SI");
                cM=consumo.get(position).getAconsume_marihuana().equals("SI");
                cP=consumo.get(position).getAconsume_pastillas().equals("SI");
                cS=consumo.get(position).getAconsume_solventes().equals("SI");
                cMe=consumo.get(position).getAconsume_metanfetaminas().equals("SI");
                cC=consumo.get(position).getAconsume_cocaina().equals("SI");

                if (cA){
                    CA="Alcohol ";
                }
                if (cT){
                    CT="Tabaco ";
                }
                if (cM){
                    CM="Marihuana ";
                }
                if (cP){
                    CP="Pasitillas ";
                }
                if (cS){
                    CS="Solventes ";
                }
                if (cMe){
                    CME="Metanfetamina ";
                }
                if (cC){
                    CC="Cocaina ";
                }

                Boolean consume;
                consume=consumo.get(position).getAconsume_alcohol().equals("NO") && consumo.get(position).getAconsume_tabaco().equals("NO")
                        && consumo.get(position).getAconsume_marihuana().equals("NO") && consumo.get(position).getAconsume_pastillas().equals("NO")
                        && consumo.get(position).getAconsume_solventes().equals("NO") && consumo.get(position).getAconsume_metanfetaminas().equals("NO")
                        && consumo.get(position).getAconsume_cocaina().equals("NO");

                if (consume){
                    tr10.setVisibility(View.GONE);
                }else{
                    tr10.setVisibility(View.VISIBLE);
                    tr10.setText("B. Poner en consideración que el adolescente consume("+CA+CT+CM+CP+CS+CME+CC+")");
                }
                //endregion
                //region MENOR
                Boolean menor;
                menor=Integer.parseInt(lista1.get(position).getAedad())<=14;
                if (menor){
                    tr11.setVisibility(View.VISIBLE);
                    tr11.setText("C. Se recomienda libertad cautelar");
                }else{
                    tr11.setVisibility(View.GONE);
                }
                //endregion
                racaso1 = tr9.getText().toString().toUpperCase();
                racaso2 = tr10.getText().toString().toUpperCase();
                racaso3 = tr11.getText().toString().toUpperCase();
                //region Color depending on the risk
                //region Color a
                if(vr123 > 3){
                    tvRa.setText("Bajo");
                    tvRa.setBackgroundResource(R.color.green);
                }
                else if(vr123 <= 3){
                    tvRa.setText("Alto");
                    tvRa.setBackgroundResource(R.color.red);
                }
                ra123 = tvRa.getText().toString();
                //endregion

                //region Color depending on the risk
                //region Color a
                if (vr46 <= 1 && vr46 >=-4){
                    tvRb.setText("Bajo");
                    tvRb.setBackgroundResource(R.color.green);
                }else
                if (vr46 <=-5){
                    tvRb.setText("Alto");
                    tvRb.setBackgroundResource(R.color.red);
                }
                rb46 = tvRb.getText().toString();


                //region Color depending on the risk
                //region Color a
                if (vr57 <= -1 && vr57 >=-4){
                    tvRc.setText("Alto");
                    tvRc.setBackgroundResource(R.color.red);
                }else
                if (vr57 >= 0 && vr57 <=2){
                    tvRc.setText("Bajo");
                    tvRc.setBackgroundResource(R.color.green);
                }
                rc57 = tvRc.getText().toString();

                tvPa.setText(vr123.toString());
                tvPb.setText(vr46.toString());
                tvPc.setText(vr57.toString());

                //endregion

                btnGuardarEvaluacionA= (Button) findViewById(R.id.btnGuardarEvaluacionA);
                btnGuardarEvaluacionA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnGuardarEvaluacionA.setEnabled(false);

                        gr1=vr1;
                        gr2=vr2;
                        gr3=vr3;
                        gr4=vr4;
                        gr5=vr5;
                        gr6=vr6;
                        gr7=vr7;
                        gr8=vr123;
                        gr9=vr46;
                        gr10=vr57;

                        db.insertarDatosInvestigacionFichaFamiliarA(3,2,1,1,0,-1,3,2,0,1,gr1,FOLIOA);
                        db.insertarDatosInvestigacionConexionesComunidadA(2,1,-1,2,1,0,1,gr2,FOLIOA);
                        db.insertarDatosInvestigacionConsideracionesExcepcionalesA(1,1,1,gr3,FOLIOA);
                        db.insertarDatosInvestigacionInformacionCasoA(-6,-4,0,-2,gr4,FOLIOA);
                        db.insertarDatosInvestigacionProcesosPenalesA(2,0,gr5,FOLIOA);
                        db.insertarDatosInvestigacionVictimaOfendidoA(1,-3,-2,0,2,-2,-2,gr6,FOLIOA);
                        db.insertarDatosInvestigacionProcesoLegalA(-2,-2,gr7,FOLIOA);
                        db.insertarDatosInvestigacionResultadoA(gr8,gr9,gr10,rarec,racaso1,racaso2,racaso3,FOLIOA);
                        Toast.makeText(getApplicationContext(), "Datos Guardados", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(v.getContext(), MainMenu.class);
                        startActivity(intent);
                    }
                });



            }


            //region EDAD

            //endregion





            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnGenerarReporteA = (Button) findViewById(R.id.btnGenerarReporteA);
        btnGenerarReporteA.setOnClickListener(this);

    }

    //region Create and display the report in PDF format
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGenerarReporteA:
                int pos = sPNomAI.getSelectedItemPosition();
                String folio = lista1.get(IdxA.get(pos)).getAfolio();
                String Anombre = lista1.get(pos).getAnombre()+" "+ lista1.get(pos).getApaterno()+" "+lista1.get(pos).getAmaterno();
                //region Generar Código QR
                String texto = FOLIOA;
                String texto1 = Anombre;
                if (texto.isEmpty() && texto1.isEmpty()) return;
                ByteArrayOutputStream byteArrayOutputStream = QRCode.from(texto+" "+texto1).withSize(200, 200).stream();
                FileOutputStream fos;
                try {
                    fos = new FileOutputStream(Environment.getExternalStorageDirectory() + "/PDF/codigo.png");
                    byteArrayOutputStream.writeTo(fos);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //endregion

                SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
                Date date = new Date();
                String fecha = dateFormat.format(date);

                templatePDF1=new TemplatePDF(getApplicationContext());
                templatePDF1.openDocument();
                templatePDF1.addImgName();
                templatePDF1.addMetaData("Instrumento de Evaluación", "FOLIO", "SCORPION");
                templatePDF1.addTitles("INSTRUMENTO PARA LA EVALUACIÓN DE RIESGOS PROCESALES EN ADOLESCENTES",folio, fecha);
                templatePDF1.createTable(header, getImputado());
                templatePDF1.createTable(header1, getRecomendaciones());
                templatePDF1.createTable(header2, getCaso());

                templatePDF1.addImgQR();
                templatePDF1.closeDocument();
                templatePDF1.appViewPDF(this);
                break;
        }
    }
    private ArrayList<String[]> getImputado(){
        ArrayList<String[]> rows=new ArrayList<>();
        rows.add(new String[]{"I. Riesgo de no comparecencia", vr123.toString(),ra123});
        rows.add(new String[]{"II. Riesgo a la víctima", vr46.toString(),rb46});
        rows.add(new String[]{"III. Riesgo de obstaculizar", vr57.toString(),rc57});
        vtt= vr123 + vr46 + vr57;
        rows.add(new String[]{"Total", vtt.toString(),""});
        return rows;
    }
    private ArrayList<String[]> getRecomendaciones(){
        ArrayList<String[]> rows=new ArrayList<>();
        rows.add(new String[]{rarec});
        return rows;
    }
    private ArrayList<String[]> getCaso(){
        ArrayList<String[]> rows=new ArrayList<>();
        rows.add(new String[]{racaso1});
        rows.add(new String[]{racaso2});
        rows.add(new String[]{racaso3});
        return rows;
    }
}
