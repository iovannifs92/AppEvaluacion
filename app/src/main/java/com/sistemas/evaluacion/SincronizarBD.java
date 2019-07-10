package com.sistemas.evaluacion;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosHabitantes;
import com.sistemas.evaluacion.entidades.datosReferencias;
import com.sistemas.evaluacion.entidades.datosEscolarLaboral;
import com.sistemas.evaluacion.entidades.datosAbandonoEstado;
import com.sistemas.evaluacion.entidades.datosSalud;
import com.sistemas.evaluacion.entidades.datosObservaciones;

import java.util.ArrayList;

public class SincronizarBD extends AppCompatActivity {

    //region Variables Globales
    private MyOpenHelper db;
    private Button btnSincronizar, btnAlert;
    private TextView tvMuestraResultados;
    private EditText etPass;
    String textoSincronizado="", pass="",url,
            nombre, alias, fNacimiento, edad, lNacimiento, sexo, folio, fEntrevista, duracionE, entrevistador, observacionesF, tipo, tieneDomicilio, otrosHabitantes, entrevistado, antecedentePenal,
            e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e32_1, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e7_1, e101, e102,
            e32,  e33,  e34,  e35,  e36,  e37,  e33_1,  e34_1,  e35_1,  e36_1,  e37_1,  e33_2,  e34_2,  e35_2,  e36_2,  e37_2, e33_3,  e34_3,  e35_3,  e36_3,  e37_3,  e38,
            e39,  e40,  e41,  e42,  e43,  e39_1,  e40_1,  e41_1,  e42_1,  e43_1,  e44,  e45,  e46,  e47,
            e48,  e49,  e50,  e51,  e52,  e53,  e54, e55,  e56,  e57,  e58,  e59,
            e60,  e61,  e62,  e63,  e64,  e65,  e66, e67,  e68,  e69,  e70,  e71,  e72, e67_1,  e68_1,  e69_1, e70_1,  e71_1,  e72_1, e73,  e74,  e75,  e76,  e77,  e78, e74_1,  e75_1,  e76_1,  e77_1,  e78_1, e79,  e80,  e81,
            e82,  e90_alcohol,  e91_alcohol,  e92_alcohol,  e83,  e90_tabaco,  e91_tabaco,  e92_tabaco, e84,  e90_marihuana,  e91_marihuana,  e92_marihuana, e85,  e90_pastillas,  e91_pastillas,  e92_pastillas, e86,  e90_solventes,
            e91_solventes,  e92_solventes,  e87,  e90_cristal,  e91_cristal, e92_cristal, e88,  e90_cocaina,  e91_cocaina,  e92_cocaina,  e89,  e93_otroConsumo,  e90_otroConsumo,  e91_otroConsumo,  e92_otroConsumo,  e94,  e95,
            field, observation;
    ProgressDialog progreso;
    RequestQueue request;
    StringRequest stringRequest;
    //endregion

    //region Metodos

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar_bd);

        btnSincronizar= (Button) findViewById(R.id.btnSincronizar);
        btnAlert=(Button) findViewById(R.id.btnAlert);
        tvMuestraResultados=(TextView) findViewById(R.id.tvMuestraResultados);
        db=new MyOpenHelper(this);
        db.getReadableDatabase();
        request = Volley.newRequestQueue(this);
        etPass=(EditText) findViewById(R.id.etPass);



        btnAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoSincronizado="";
                cargarWebService();
            }
        });
    }

    private void showInputDialog() {
        LayoutInflater layoutInflater=LayoutInflater.from(SincronizarBD.this);
        View promtView= layoutInflater.inflate(R.layout.input_dialog,null);
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(SincronizarBD.this);
        alertDialogBuilder.setView(promtView);
        final String contraseña="scorpio2019";

        final EditText etPass=(EditText) promtView.findViewById(R.id.etPass);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pass=etPass.getText().toString();
                        if(pass.equals(contraseña)){
                            textoSincronizado="";
                            cargarWebService();
                        }
                        else {
                            tvMuestraResultados.setText("Contraseña incorrecta");
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
    //endregion

    //region cargarWebService
    private void cargarWebService() {
        ArrayList<datosGenerales> lista;
        ArrayList<datosDomicilio> listaDomicilio;
        ArrayList<datosHabitantes> listaHabitantes;
        ArrayList<datosReferencias> listaReferencias;
        ArrayList<datosEscolarLaboral> listaEscolarLaboral;
        ArrayList<datosAbandonoEstado> listaAbandonoEstado;
        ArrayList<datosSalud> listaSalud;
        ArrayList<datosObservaciones> listaObservaciones;
        lista = db.getDatosGenerales();
        listaDomicilio=db.getDomicilios();
        listaHabitantes=db.getHabitantes();
        listaReferencias=db.getReferencias();
        listaEscolarLaboral=db.getHistorialEscolarLaboral();
        listaAbandonoEstado=db.getDatosAbandonoEstado();
        listaSalud=db.getDatosSalud();
        listaObservaciones=db.getObservaciones();
        progreso = new ProgressDialog(this);
        //progreso.setMessage("Cargando...");
        //progreso.show();

        //region Ciclo FOR
        for(int i = 0; i < lista.size(); i++){

            //region Get Datos Generales
            nombre=lista.get(i).getNombre();
            alias=lista.get(i).getAlias();
            fNacimiento=lista.get(i).getfNacimiento();
            edad=lista.get(i).getEdad();
            lNacimiento=lista.get(i).getlNacimiento();
            sexo=lista.get(i).getSexo();
            folio=lista.get(i).getFolio();
            fEntrevista=lista.get(i).getfEntrevista();
            duracionE=lista.get(i).getDuracionE();
            entrevistador=lista.get(i).getEntrevistador();
            observacionesF=lista.get(i).getObservacionesF();
            tipo=lista.get(i).getTipo();
            tieneDomicilio=lista.get(i).getTieneDomicilioS();
            otrosHabitantes=lista.get(i).getOtrosHabitantes();
            entrevistado=lista.get(i).getEntrevistado();
            antecedentePenal=lista.get(i).getAntecedentePenal();
            //endregion

            //region Get Datos Domicilio
            e7=listaDomicilio.get(i).getE7();
            e8=listaDomicilio.get(i).getE8();
            e9=listaDomicilio.get(i).getE9();
            e10=listaDomicilio.get(i).getE10();
            e11=listaDomicilio.get(i).getE11();
            e12=listaDomicilio.get(i).getE12();
            e13=listaDomicilio.get(i).getE13();
            e14=listaDomicilio.get(i).getE14();
            e15=listaDomicilio.get(i).getE15();
            e16=listaDomicilio.get(i).getE16();
            e32_1=listaDomicilio.get(i).getE32_1();
            e17=listaDomicilio.get(i).getE17();
            e18=listaDomicilio.get(i).getE18();
            e19=listaDomicilio.get(i).getE19();
            e20=listaDomicilio.get(i).getE20();
            e21=listaDomicilio.get(i).getE21();
            e22=listaDomicilio.get(i).getE22();
            e23=listaDomicilio.get(i).getE23();
            e24=listaDomicilio.get(i).getE24();
            e25=listaDomicilio.get(i).getE25();
            e26=listaDomicilio.get(i).getE26();
            e27=listaDomicilio.get(i).getE27();
            e28=listaDomicilio.get(i).getE28();
            e29=listaDomicilio.get(i).getE29();
            e30=listaDomicilio.get(i).getE30();
            e31=listaDomicilio.get(i).getE31();
            e7_1=listaDomicilio.get(i).getE7_1();
            e101=listaDomicilio.get(i).getE101();
            e102=listaDomicilio.get(i).getE102();
            //endregion

            //region Get Datos Familiares
            e32=listaHabitantes.get(i).getE32();
            e33=listaHabitantes.get(i).getE33();
            e34=listaHabitantes.get(i).getE34();
            e35=listaHabitantes.get(i).getE35();
            e36=listaHabitantes.get(i).getE36();
            e37=listaHabitantes.get(i).getE37();
            e33_1=listaHabitantes.get(i).getE33_1();
            e34_1=listaHabitantes.get(i).getE34_1();
            e35_1=listaHabitantes.get(i).getE35_1();
            e36_1=listaHabitantes.get(i).getE36_1();
            e37_1=listaHabitantes.get(i).getE37_1();
            e33_2=listaHabitantes.get(i).getE33_2();
            e34_2=listaHabitantes.get(i).getE34_2();
            e35_2=listaHabitantes.get(i).getE35_2();
            e36_2=listaHabitantes.get(i).getE36_2();
            e37_2=listaHabitantes.get(i).getE37_2();
            e33_3=listaHabitantes.get(i).getE33_3();
            e34_3=listaHabitantes.get(i).getE34_3();
            e35_3=listaHabitantes.get(i).getE35_3();
            e36_3=listaHabitantes.get(i).getE36_3();
            e37_3=listaHabitantes.get(i).getE37_3();
            e38=listaHabitantes.get(i).getE38();
            //endregion

            //region Get Datos Referencias
            e39=listaReferencias.get(i).getE39();
            e40=listaReferencias.get(i).getE40();
            e41=listaReferencias.get(i).getE41();
            e42=listaReferencias.get(i).getE42();
            e43=listaReferencias.get(i).getE43();
            e39_1=listaReferencias.get(i).getE39_1();
            e40_1=listaReferencias.get(i).getE40_1();
            e41_1=listaReferencias.get(i).getE41_1();
            e42_1=listaReferencias.get(i).getE42_1();
            e43_1=listaReferencias.get(i).getE43_1();
            e44=listaReferencias.get(i).getE44();
            e45=listaReferencias.get(i).getE45();
            e46=listaReferencias.get(i).getE46();
            e47=listaReferencias.get(i).getE47();
            //endregion

            //region Get Datos Escolar Laboral
            e48=listaEscolarLaboral.get(i).getE48();
            e49=listaEscolarLaboral.get(i).getE49();
            e50=listaEscolarLaboral.get(i).getE50();
            e51=listaEscolarLaboral.get(i).getE51();
            e52=listaEscolarLaboral.get(i).getE52();
            e53=listaEscolarLaboral.get(i).getE53();
            e54=listaEscolarLaboral.get(i).getE54();
            e55=listaEscolarLaboral.get(i).getE55();
            e56=listaEscolarLaboral.get(i).getE56();
            e57=listaEscolarLaboral.get(i).getE57();
            e58=listaEscolarLaboral.get(i).getE58();
            e59=listaEscolarLaboral.get(i).getE59();
            //endregion

            //region Get Datos Abandono Estado
            e60=listaAbandonoEstado.get(i).getE60();
            e61=listaAbandonoEstado.get(i).getE61();
            e62=listaAbandonoEstado.get(i).getE62();
            e63=listaAbandonoEstado.get(i).getE63();
            e64=listaAbandonoEstado.get(i).getE64();
            e65=listaAbandonoEstado.get(i).getE65();
            e66=listaAbandonoEstado.get(i).getE66();
            e67=listaAbandonoEstado.get(i).getE67();
            e68=listaAbandonoEstado.get(i).getE68();
            e69=listaAbandonoEstado.get(i).getE69();
            e70=listaAbandonoEstado.get(i).getE70();
            e71=listaAbandonoEstado.get(i).getE71();
            e72=listaAbandonoEstado.get(i).getE72();
            e67_1=listaAbandonoEstado.get(i).getE67_1();
            e68_1=listaAbandonoEstado.get(i).getE68_1();
            e69_1=listaAbandonoEstado.get(i).getE69_1();
            e70_1=listaAbandonoEstado.get(i).getE70_1();
            e71_1=listaAbandonoEstado.get(i).getE71_1();
            e72_1=listaAbandonoEstado.get(i).getE72_1();
            e73=listaAbandonoEstado.get(i).getE73();
            e74=listaAbandonoEstado.get(i).getE74();
            e75=listaAbandonoEstado.get(i).getE75();
            e76=listaAbandonoEstado.get(i).getE76();
            e77=listaAbandonoEstado.get(i).getE77();
            e78=listaAbandonoEstado.get(i).getE78();
            e74_1=listaAbandonoEstado.get(i).getE74_1();
            e75_1=listaAbandonoEstado.get(i).getE75_1();
            e76_1=listaAbandonoEstado.get(i).getE76_1();
            e77_1=listaAbandonoEstado.get(i).getE77_1();
            e78_1=listaAbandonoEstado.get(i).getE78_1();
            e79=listaAbandonoEstado.get(i).getE79();
            e80=listaAbandonoEstado.get(i).getE80();
            e81=listaAbandonoEstado.get(i).getE81();
            //endregion

            //region Get Datos Salud
            e82=listaSalud.get(i).getE82();
            e90_alcohol=listaSalud.get(i).getE90_alcohol();
            e91_alcohol=listaSalud.get(i).getE91_alcohol();
            e92_alcohol=listaSalud.get(i).getE92_alcohol();
            e83=listaSalud.get(i).getE83();
            e90_tabaco=listaSalud.get(i).getE90_tabaco();
            e91_tabaco=listaSalud.get(i).getE91_tabaco();
            e92_tabaco=listaSalud.get(i).getE92_tabaco();
            e84=listaSalud.get(i).getE84();
            e90_marihuana=listaSalud.get(i).getE90_marihuana();
            e91_marihuana=listaSalud.get(i).getE91_marihuana();
            e92_marihuana=listaSalud.get(i).getE92_marihuana();
            e85=listaSalud.get(i).getE85();
            e90_pastillas=listaSalud.get(i).getE90_pastillas();
            e91_pastillas=listaSalud.get(i).getE91_pastillas();
            e92_pastillas=listaSalud.get(i).getE92_pastillas();
            e86=listaSalud.get(i).getE86();
            e90_solventes=listaSalud.get(i).getE90_solventes();
            e91_solventes=listaSalud.get(i).getE91_solventes();
            e92_solventes=listaSalud.get(i).getE92_solventes();
            e87=listaSalud.get(i).getE87();
            e90_cristal=listaSalud.get(i).getE90_cristal();
            e91_cristal=listaSalud.get(i).getE91_cristal();
            e92_cristal=listaSalud.get(i).getE92_cristal();
            e88=listaSalud.get(i).getE88();
            e90_cocaina=listaSalud.get(i).getE90_cocaina();
            e91_cocaina=listaSalud.get(i).getE91_cocaina();
            e92_cocaina=listaSalud.get(i).getE92_cocaina();
            e89=listaSalud.get(i).getE89();
            e93_otroConsumo=listaSalud.get(i).getE93_otroConsumo();
            e90_otroConsumo=listaSalud.get(i).getE90_otroConsumo();
            e91_otroConsumo=listaSalud.get(i).getE91_otroConsumo();
            e92_otroConsumo=listaSalud.get(i).getE92_otroConsumo();
            e94=listaSalud.get(i).getE94();
            e95=listaSalud.get(i).getE95();
            //endregion

            //region Get Verificación Observaciones
            //field=listaObservaciones.get(i).getField();
            //observation=listaObservaciones.get(i).getObservation();
            //endregion

            url = "http://10.6.60.182/ejemploBDRemota/registraImputadoDatos.php?" +
                    "Nombre="+nombre+
                    "&Alias="+alias+
                    "&FNacimiento="+fNacimiento+
                    "&Edad="+edad+
                    "&LNacimiento="+lNacimiento+
                    "&Sexo="+sexo+
                    "&Folio="+folio+
                    "&FEntrevista="+fEntrevista+
                    "&DuracionE="+duracionE+
                    "&Entrevistador="+entrevistador+
                    "&ObservacionesF="+observacionesF+
                    "&Tipo="+tipo+
                    "&TieneDomicilio="+tieneDomicilio+
                    "&OtrosHabitantes="+otrosHabitantes+
                    "&Entrevistado="+entrevistado+
                    "&AntecedentePenal="+antecedentePenal+
                    "&e7="+e7+
                    "&e7_1="+e7_1+
                    "&e8="+e8+
                    "&e9="+e9+
                    "&e10="+e10+
                    "&e11="+e11+
                    "&e12="+e12+
                    "&e13="+e13+
                    "&e14="+e14+
                    "&e15="+e15+
                    "&e16="+e16+
                    "&e32_1="+e32_1+
                    "&e17="+e17+
                    "&e18="+e18+
                    "&e19="+e19+
                    "&e20="+e20+
                    "&e21="+e21+
                    "&e22="+e22+
                    "&e23="+e23+
                    "&e24="+e24+
                    "&e25="+e25+
                    "&e26="+e26+
                    "&e27="+e27+
                    "&e28="+e28+
                    "&e29="+e29+
                    "&e30="+e30+
                    "&e31="+e31+
                    "&e101="+e101+
                    "&e102="+e102+
                    "&folio="+folio+
                    "&e32="+e32+
                    "&e33="+e33+
                    "&e34="+e34+
                    "&e35="+e35+
                    "&e36="+e36+
                    "&e37="+e37+
                    "&e33_1="+e33_1+
                    "&e34_1="+e34_1+
                    "&e35_1="+e35_1+
                    "&e36_1="+e36_1+
                    "&e37_1="+e37_1+
                    "&e33_2="+e33_2+
                    "&e34_2="+e34_2+
                    "&e35_2="+e35_2+
                    "&e36_2="+e36_2+
                    "&e37_2="+e37_2+
                    "&e33_3="+e33_3+
                    "&e34_3="+e34_3+
                    "&e35_3="+e35_3+
                    "&e36_3="+e36_3+
                    "&e37_3="+e37_3+
                    "&e38="+e38+
                    "&folio2="+folio+
                    "&e39="+e39+
                    "&e40="+e40+
                    "&e41="+e41+
                    "&e42="+e42+
                    "&e43="+e43+
                    "&e39_1="+e39_1+
                    "&e40_1="+e40_1+
                    "&e41_1="+e41_1+
                    "&e42_1="+e42_1+
                    "&e43_1="+e43_1+
                    "&e44="+e44+
                    "&e45="+e45+
                    "&e46="+e46+
                    "&e47="+e47+
                    "&folio3="+folio+
                    "&e48="+e48+
                    "&e49="+e49+
                    "&e50="+e50+
                    "&e51="+e51+
                    "&e52="+e52+
                    "&e53="+e53+
                    "&e54="+e54+
                    "&e55="+e55+
                    "&e56="+e56+
                    "&e57="+e57+
                    "&e58="+e58+
                    "&e59="+e59+
                    "&folio4="+folio+
                    "&e60="+e60+
                    "&e61="+e61+
                    "&e62="+e62+
                    "&e63="+e63+
                    "&e64="+e64+
                    "&e65="+e65+
                    "&e66="+e66+
                    "&e67="+e67+
                    "&e68="+e68+
                    "&e69="+e69+
                    "&e70="+e70+
                    "&e71="+e71+
                    "&e72="+e72+
                    "&e67_1="+e67_1+
                    "&e68_1="+e68_1+
                    "&e69_1="+e69_1+
                    "&e70_1="+e70_1+
                    "&e71_1="+e71_1+
                    "&e72_1="+e72_1+
                    "&e73="+e73+
                    "&e74="+e74+
                    "&e75="+e75+
                    "&e76="+e76+
                    "&e77="+e77+
                    "&e78="+e78+
                    "&e74_1="+e74_1+
                    "&e75_1="+e75_1+
                    "&e76_1="+e76_1+
                    "&e77_1="+e77_1+
                    "&e78_1="+e78_1+
                    "&e79="+e79+
                    "&e80="+e80+
                    "&e81="+e81+
                    "&folio5="+folio+
                    "&e82="+e82+
                    "&e90_alcohol="+e90_alcohol+
                    "&e91_alcohol="+e91_alcohol+
                    "&e92_alcohol="+e92_alcohol+
                    "&e83="+e83+
                    "&e90_tabaco="+e90_tabaco+
                    "&e91_tabaco="+e91_tabaco+
                    "&e92_tabaco="+e92_tabaco+
                    "&e84="+e84+
                    "&e90_marihuana="+e90_marihuana+
                    "&e91_marihuana="+e91_marihuana+
                    "&e92_marihuana="+e92_marihuana+
                    "&e85="+e85+
                    "&e90_pastillas="+e90_pastillas+
                    "&e91_pastillas="+e91_pastillas+
                    "&e92_pastillas="+e92_pastillas+
                    "&e86="+e86+
                    "&e90_solventes="+e90_solventes+
                    "&e91_solventes="+e91_solventes+
                    "&e92_solventes="+e92_solventes+
                    "&e87="+e87+
                    "&e90_cristal="+e90_cristal+
                    "&e91_cristal="+e91_cristal+
                    "&e92_cristal="+e92_cristal+
                    "&e88="+e88+
                    "&e90_cocaina="+e90_cocaina+
                    "&e91_cocaina="+e91_cocaina+
                    "&e92_cocaina="+e92_cocaina+
                    "&e89="+e89+
                    "&e93_otroConsumo="+e93_otroConsumo+
                    "&e90_otroConsumo="+e90_otroConsumo+
                    "&e91_otroConsumo="+e91_otroConsumo+
                    "&e92_otroConsumo="+e92_otroConsumo+
                    "&e94="+e94+
                    "&e95="+e95+
                    "&folio6="+folio;
                    /*"&field="+field+
                    "&observation="+observation+
                    "&folio7="+folio;*/


            url = (url.replace(" ", "%20")); //reemplazo espacios por %20
            //url=(url.replace("Ñ","&Ntilde"));

            textoSincronizado+="nombre: "+nombre+" alias: "+alias+"\n";

            stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progreso.hide();
                    Toast.makeText(getApplicationContext(), "Se ha registrado exitosamente nombre: "+nombre+" alias: "+alias, Toast.LENGTH_SHORT).show();
                    tvMuestraResultados.setText("SINCRONIZACIÓN COMPLETA \n"+textoSincronizado);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    progreso.hide();
                    Toast.makeText(getApplicationContext(), "No se pudo regresar " + error.toString(), Toast.LENGTH_SHORT).show();
                    Log.i("ERROR", error.toString());
                    tvMuestraResultados.setText("SINCRONIZACIÓN ERRONEA \n"+error.toString());

                }
            });
            request.add(stringRequest);

        }
        //endregion
    }
    //endregion


    //endregion
}
