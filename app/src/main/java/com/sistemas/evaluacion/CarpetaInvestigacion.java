package com.sistemas.evaluacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosGenerales;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class CarpetaInvestigacion extends AppCompatActivity implements View.OnClickListener {

    //region Variables Globales
    final String[] NoSi = {"No", "Si"};
    final String[] p111 = {"Si cumplió", "No cumplió", "No existe otro proceso"};
    final String[] p112 = {"Si fue sustraído o se le giro alguna orden de aprehensión en un proceso diverso", "No fue sustraído o se le giro alguna orden de aprehensión en un proceso diverso", "No existe otro proceso"};
    final String[] p113 = {"Si proporciono información falsa", "Proporciono información correcta"};
    final String[] p115 = {"No se resistió", "Si se resistió"};

    final String[] p118 = {"Si","No","No existen testigos registrados en la carpeta de investigación"};
    final String[] p119 = {"Si tiene relación familiar con otros detenidos por los mismos hechos","Si tiene alguna relación no familiar con otros detenidos por los mismos hechos","No tiene ninguna relación con otros detenidos por los mismos hechos"};

    final String[] p123 = {"Conoce a la víctima u ofendido y tiene una relación FAMILIAR con él/ella",
                            "Conoce a la víctima u ofendido y tiene una relación FRATERNAL con él/ella",
                            "Conoce a la víctima u ofendido y tiene una relación VECINAL Oo COMUNITARIA con él/ella",
                            "Conoce a la víctima u ofendido y tiene una relación LABORAL o ESCOLAR con él/ella",
                            "No conoce a la víctima u ofendido pero la ubica (tiene datos de contacto, ubicación o localización)",
                            "No conoce a la víctima u ofendido, ni la ubica"};
    final String[] p124 = {"Reside en el mismo domicilio de la víctima y ofendido",
                            "Labora en el mismo lugar con la víctima y ofendido",
                            "Su domicilio, lugar de trabajo o la casa de sus familiares esta cerca de la víctima u ofendido",
                            "No vive, no trabaja, ni frecuenta lugares cercanos a la víctima u ofendido"};


    LinearLayout llControl, llVoluntadSometimiento, llTestigos, llVictima;
    Button btnVoluntadSometimiento, btnTestigos, btnVictima, btnGuardar;
    boolean voluntadSometimiento=true, testigos=true, victima=true;
    ArrayAdapter<String> aNoSi, ap111, ap112, ap113, ap115,
                        ap118, ap119,
                        ap123, ap124;

    MaterialBetterSpinner sP111, sP112, sP113, sP114, sP115, sP116,
                        sP117, sP118, sP119, sP120, sP121,
                        sP122, sP123, sP124, sP125, sP126;

    MyOpenHelper db;
    Spinner sConsultaEntrevistados;
    TextView tvControl;
    EditText etCarpetaInvestigacion;


    String strP111, strP112, strP113, strP114, strP115, strP116, strP117, strP118, strP119, strP120, strP121, strP122, strP123, strP124, strP125, strP126;
    String folio, carpeta;
    ArrayList<datosGenerales> lista;
    final ArrayList<Integer> Idx = new ArrayList<Integer>();
    //endregion

    //region Métodos

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpeta_investigacion);
        etCarpetaInvestigacion=(EditText) findViewById(R.id.etCarpetaInvestigacion);
        btnGuardar=(Button) findViewById(R.id.btnGuardar);
        sConsultaEntrevistados = (Spinner) findViewById(R.id.sConsultaEntrevistados);


        //region Inicio BD
        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        lista = db.getDatosGenerales();

        ArrayList<String> names = new ArrayList<String>();

        for(int i = 0; i < lista.size(); i++){
            if((lista.get(i).getCarpetaInvestigacion().toString()).equals("NO")) {
                names.add(lista.get(i).getNombre());
                Idx.add(i);
            }
        }

        if(lista.size()!=0){
            tvControl=(TextView) findViewById(R.id.tvControl);
            llControl=(LinearLayout) findViewById(R.id.llControl);

            llControl.setVisibility(View.VISIBLE);
            tvControl.setVisibility(View.GONE);
        }

        sConsultaEntrevistados.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));

        //endregion

        //region Controles
        llVoluntadSometimiento=(LinearLayout) findViewById(R.id.llVoluntadSometimiento);
        llTestigos=(LinearLayout) findViewById(R.id.llTestigos);
        llVictima=(LinearLayout) findViewById(R.id.llVictima);
        btnVoluntadSometimiento=(Button) findViewById(R.id.btnVoluntadSometimiento);
        btnTestigos=(Button) findViewById(R.id.btnTestigos);
        btnVictima=(Button) findViewById(R.id.btnVictima);

        btnVoluntadSometimiento.setOnClickListener(this);
        btnTestigos.setOnClickListener(this);
        btnVictima.setOnClickListener(this);
        //endregion

        //region Voluntad de sometimiento al proceso penal actual
        aNoSi= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, NoSi);
        ap111= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p111);
        ap112= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p112);
        ap113= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p113);
        ap115= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p115);

        sP111=(MaterialBetterSpinner) findViewById(R.id.sP111);
        sP111.setAdapter(ap111);
        sP112=(MaterialBetterSpinner) findViewById(R.id.sP112);
        sP112.setAdapter(ap112);
        sP113=(MaterialBetterSpinner) findViewById(R.id.sP113);
        sP113.setAdapter(ap113);
        sP114=(MaterialBetterSpinner) findViewById(R.id.sP114);
        sP114.setAdapter(aNoSi);
        sP115=(MaterialBetterSpinner) findViewById(R.id.sP115);
        sP115.setAdapter(ap115);
        sP116=(MaterialBetterSpinner) findViewById(R.id.sP116);
        sP116.setAdapter(aNoSi);
        //endregion

        //region Testigos, coimputados y agentes aprensores
        ap118=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p118);
        ap119=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p119);

        sP117=(MaterialBetterSpinner) findViewById(R.id.sP117);
        sP117.setAdapter(aNoSi);
        sP118=(MaterialBetterSpinner) findViewById(R.id.sP118);
        sP118.setAdapter(ap118);
        sP119=(MaterialBetterSpinner) findViewById(R.id.sP119);
        sP119.setAdapter(ap119);
        sP120=(MaterialBetterSpinner) findViewById(R.id.sP120);
        sP120.setAdapter(aNoSi);
        sP121=(MaterialBetterSpinner) findViewById(R.id.sP121);
        sP121.setAdapter(aNoSi);
        //endregion

        //region Víctima u ofendido
        ap123=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p123);
        ap124=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, p124);

        sP122=(MaterialBetterSpinner) findViewById(R.id.sP122);
        sP122.setAdapter(aNoSi);
        sP123=(MaterialBetterSpinner) findViewById(R.id.sP123);
        sP123.setAdapter(ap123);
        sP124=(MaterialBetterSpinner) findViewById(R.id.sP124);
        sP124.setAdapter(ap124);
        sP125=(MaterialBetterSpinner) findViewById(R.id.sP125);
        sP125.setAdapter(aNoSi);
        sP126=(MaterialBetterSpinner) findViewById(R.id.sP126);
        sP126.setAdapter(aNoSi);
        //endregion

        btnGuardar.setOnClickListener(this);


    }
    //endregion

    //region onClick
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnVoluntadSometimiento:
                if(voluntadSometimiento){
                    llVoluntadSometimiento.setVisibility(View.VISIBLE);
                    voluntadSometimiento=false;
                }
                else{
                    llVoluntadSometimiento.setVisibility(View.GONE);
                    voluntadSometimiento=true;
                }
                break;
            case R.id.btnTestigos:
                if(testigos){
                    llTestigos.setVisibility(View.VISIBLE);
                    testigos=false;
                }
                else{
                    llTestigos.setVisibility(View.GONE);
                    testigos=true;
                }
                break;
            case R.id.btnVictima:
                if(victima){
                    llVictima.setVisibility(View.VISIBLE);
                    victima=false;
                }
                else{
                    llVictima.setVisibility(View.GONE);
                    victima=true;
                }
                break;
            case R.id.btnGuardar:
                strP111=sP111.getText().toString();
                strP112=sP112.getText().toString();
                strP113=sP113.getText().toString();
                strP114=sP114.getText().toString();
                strP115=sP115.getText().toString();
                strP116=sP116.getText().toString();
                strP117=sP117.getText().toString();
                strP118=sP118.getText().toString();
                strP119=sP119.getText().toString();
                strP120=sP120.getText().toString();
                strP121=sP121.getText().toString();
                strP122=sP122.getText().toString();
                strP123=sP123.getText().toString();
                strP124=sP124.getText().toString();
                strP125=sP125.getText().toString();
                strP126=sP126.getText().toString();
                int pos = sConsultaEntrevistados.getSelectedItemPosition();
                folio = lista.get(Idx.get(pos)).getFolio();
                carpeta=etCarpetaInvestigacion.getText().toString();

                db.insertarCarpetaInvestigacion(carpeta,strP111,strP112,strP113,strP114,strP115,strP116,strP117,strP118,strP119,strP120,strP121,strP122,strP123,strP124,strP125,strP126,folio);
                db.updateTable("imputado_datos_generales", "CarpetaInvestigacion", "SI", folio);
                Toast.makeText(getApplicationContext(), "Datos Guardados correctamete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivity(intent);
                break;
        }

    }
    //endregion

    //endregion

}
