package com.sistemas.evaluacion;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.VolleySingleton;

import java.util.ArrayList;

public class SincronizarBD extends AppCompatActivity {

    //region Variables Globales
    private MyOpenHelper db;
    private Button btnSincronizar;
    private TextView tvMuestraResultados;
    int id;
    String textoSincronizado="",url, nombre, alias, fNacimiento, edad, lNacimiento, sexo, folio, fEntrevista, duracionE, entrevistador, observacionesF, tipo;
    ProgressDialog progreso;
    RequestQueue request;
    StringRequest stringRequest;
    //endregion

    //region Metodos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar_bd);

        btnSincronizar= (Button) findViewById(R.id.btnSincronizar);
        tvMuestraResultados=(TextView) findViewById(R.id.tvMuestraResultados);
        db=new MyOpenHelper(this);
        db.getReadableDatabase();
        request = Volley.newRequestQueue(this);

        btnSincronizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoSincronizado="";
                cargarWebService();
            }
        });



    }

    private void cargarWebService() {
        ArrayList<datosGenerales> lista;
        lista = db.getDatosGenerales();


        progreso = new ProgressDialog(this);
        progreso.setMessage("Cargando...");
        progreso.show();
        //region Ciclo FOR
        for(int i = 0; i < lista.size(); i++){
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
            url = "http://10.6.60.182/ejemploBDRemota/Registra_imputado_datos_generales.php?" +
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
                    "&Tipo="+tipo;

            url = url.replace(" ", "%20"); //reemplazo espacios por %20
            textoSincronizado+="nombre: "+nombre+" alias: "+alias+"\n";

            stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
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
                            tvMuestraResultados.setText("SINCRONIZACIÓN ERRONEA \n"+textoSincronizado);

                        }
                });
            request.add(stringRequest);

        }
        //endregion



    }

    //endregion
}
