package com.sistemas.evaluacion;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
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

import com.sistemas.evaluacion.entidades.datosActividadesExtraescolaresA;
import com.sistemas.evaluacion.entidades.datosConsumoSustanciasA;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosFamiliaresA;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosGeneralesA;
import com.sistemas.evaluacion.entidades.datosHistorialEscolarA;
import com.sistemas.evaluacion.entidades.datosHistorialLaboralA;
import com.sistemas.evaluacion.entidades.datosRevisionMedicaA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.sistemas.evaluacion.verificacion.REQUEST_IMAGE_CAPTURE;
import static com.sistemas.evaluacion.verificacion.REQUEST_TAKE_PHOTO;

public class verificacionAdolecentes extends AppCompatActivity {
    private MyOpenHelper db;
    ArrayList<datosGeneralesA> lista1;

    //region EDITTEXT
    //datos generales
    private EditText txt2049,txt2050;
    private EditText txtOA1,txtOA2,txtOA3,txtOA4,txtOA5,txtOA6,txtOA7,txtOA8,txtOA9,txtOA10,txtOA11,txtOA12,txtOA13,txtOA14,txtOA15,txtOA16,txtOA17,txtOA18,txtOA19,txtOA20,txtOA21,txtOA22,txtOA23,txtOA24,txtOA25,txtOA26,txtOA27,txtOA28,txtOA29,txtOA30;
    //endregion

    //region TEXTVIEW
    //DATOS GENERALES
    private TextView e131 ,tv2049,tv2050 ,tvControlA; //folio
    private TextView tvOA1,tvOA2,tvOA3,tvOA4,tvOA5,tvOA6,tvOA7,tvOA8,tvOA9,tvOA10,tvOA11,tvOA12,tvOA13,tvOA14,tvOA15,tvOA16,tvOA17,tvOA18,tvOA19,tvOA20,tvOA21,tvOA22,tvOA23,tvOA24,tvOA25,tvOA26,tvOA27,tvOA28,tvOA29,tvOA30;
    ///////
    private TextView tvEa,tvCa,tvNOa,tvCOLa,tvCPa,tvMUa,tvEDO2a,tvPa,tvTa,tvDfa,tvRD,tvCQDFa,tvRDFa,tvLDFa,tvAE,tvCS,tvTAA,tvTR,tvAEA,tvEM,tvSIDA,tvA,tvT,tvMAR,tvPAS,tvSOL,tvMET,tvCOCA,tvSUSF;
    //endregion

    //region SPINNER
    private Spinner sPVerifica1 ,sP2048;
    //endregion

    //region BOTON
    private Button btnGuardarObservacionesA,btnverificacionA,btnDg,btnFfa,btnVH,btnCE,btnIC,btnPhotoA;
    //endregion

    //region BOOLEAN
    private Boolean pR=false;
    //endregion

    //region CheckedTextView
    private CheckedTextView ctvA1,ctvA2,ctvA3,ctvA4,ctvA5,ctvA6,ctvA7,ctvA8,ctvA9,ctvA10,ctvA11,ctvA12,ctvA13,ctvA14,ctvA15,ctvA16,ctvA17,ctvA18,ctvA19,ctvA20,ctvA21,ctvA22,ctvA23,ctvA24,ctvA25,ctvA26,ctvA27,ctvA28,ctvA29,ctvA30;
    //endregion

    //region LinearLayaout
    private LinearLayout llControlA,llDg,llFfa,llVH,llCE,llIC;
    //endregion

    //region String
    private String r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25,r26,r27,r28,r29,r30,r31;
    //SPINNERS
    private String rS1,rS2,rS3,rS4,rS5,rS6,rS7,rS8,rS9,rS10,rS11,rS12,rS13,rS14,rS15,rS16,rS17,rS18,rS19,rS20,rS21,rS22,rS23,rS24,rS25,rS26,rS27,
            rS28,rS29,rS30,rS31,rS32,rS33,rS34,rS35,rS36,rS37,rS38,rS39,rS40,rS41;

    String[] opers = {"Verificar", "Editar"};
    String currentPhotoPath;

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_adolecentes);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();


        tvControlA=(TextView) findViewById(R.id.tvControlA);
        llControlA=(LinearLayout) findViewById(R.id.llControlA);

        lista1 = db.getdatosGeneralesA();

        //region Inicializa un spinner con los nombres de los entrevistados
        sPVerifica1 = (Spinner) findViewById(R.id.sPVerifica1);
        String[] names = new String[lista1.size()];
        for(int i = 0; i < lista1.size(); i++){
            names[i] = lista1.get(i).getAnombre();
        }



        //endregion
        //region Verificar si hay registros
       if(lista1.isEmpty() == false){
           sPVerifica1.setSelection(lista1.size() - 1);
           llControlA.setVisibility(View.VISIBLE);
           tvControlA.setVisibility(View.GONE);
        }else{
           llControlA.setVisibility(View.GONE);
           tvControlA.setVisibility(View.VISIBLE);
       }
        //endregion
        sPVerifica1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));


        sPVerifica1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                final ArrayList<datosGeneralesA> lista1;
                lista1 = db.getdatosGeneralesA();

                final ArrayList<datosFichaFamiliarA> famili;
                famili = db.getdatosFichaFamiliarA();

                final ArrayList<datosFamiliaresA> dfamili;
                dfamili = db.getdatosFamiliaresA(); //

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


                e131=(TextView) findViewById(R.id.e131);
                e131.setText(lista1.get(pos).getAfolio());


                tvEa=(TextView) findViewById(R.id.tvNa);
                ctvA1=(CheckedTextView)findViewById(R.id.ctvA1);
                tvOA1=(TextView)findViewById(R.id.tvobseA1);
                txtOA1=(EditText) findViewById(R.id.txtobseA1);

                tvCa=(TextView) findViewById(R.id.tvCa);
                ctvA2=(CheckedTextView)findViewById(R.id.ctvA2);
                tvOA2=(TextView)findViewById(R.id.tvOA2);
                txtOA2=(EditText) findViewById(R.id.txtOA2);

                tvNOa=(TextView) findViewById(R.id.tvNOa);
                ctvA3=(CheckedTextView)findViewById(R.id.ctvA3);
                tvOA3=(TextView)findViewById(R.id.tvOA3);
                txtOA3=(EditText) findViewById(R.id.txtOA3);

                tvCOLa=(TextView) findViewById(R.id.tvCOLa);
                ctvA4=(CheckedTextView)findViewById(R.id.ctvA4);
                tvOA4=(TextView)findViewById(R.id.tvOA4);
                txtOA4=(EditText) findViewById(R.id.txtOA4);

                tvCPa=(TextView) findViewById(R.id.tvCPa);
                ctvA5=(CheckedTextView)findViewById(R.id.ctvA5);
                tvOA5=(TextView)findViewById(R.id.tvOA5);
                txtOA5=(EditText) findViewById(R.id.txtOA5);

                tvMUa=(TextView) findViewById(R.id.tvMUa);
                ctvA6=(CheckedTextView)findViewById(R.id.ctvA6);
                tvOA6=(TextView)findViewById(R.id.tvOA6);
                txtOA6=(EditText) findViewById(R.id.txtOA6);

                tvEDO2a=(TextView) findViewById(R.id.tvEDO2a);
                ctvA7=(CheckedTextView)findViewById(R.id.ctvA7);
                tvOA7=(TextView)findViewById(R.id.tvOA7);
                txtOA7=(EditText) findViewById(R.id.txtOA7);

                tvPa=(TextView) findViewById(R.id.tvPa);
                ctvA8=(CheckedTextView)findViewById(R.id.ctvA8);
                tvOA8=(TextView)findViewById(R.id.tvOA8);
                txtOA8=(EditText) findViewById(R.id.txtOA8);

                tvTa=(TextView) findViewById(R.id.tvTa);
                ctvA9=(CheckedTextView)findViewById(R.id.ctvA9);
                tvOA9=(TextView)findViewById(R.id.tvOA9);
                txtOA9=(EditText) findViewById(R.id.txtOA9);

                tvDfa=(TextView) findViewById(R.id.tvDfa);
                ctvA10=(CheckedTextView)findViewById(R.id.ctvA10);
                tvOA10=(TextView)findViewById(R.id.tvOA10);
                txtOA10=(EditText) findViewById(R.id.txtOA10);

                tvRD=(TextView) findViewById(R.id.tvRD);
                ctvA11=(CheckedTextView)findViewById(R.id.ctvA11);
                tvOA11=(TextView)findViewById(R.id.tvOA11);
                txtOA11=(EditText) findViewById(R.id.txtOA11);

                tvCQDFa=(TextView) findViewById(R.id.tvCQDFa);
                ctvA12=(CheckedTextView)findViewById(R.id.ctvA12);
                tvOA12=(TextView)findViewById(R.id.tvOA12);
                txtOA12=(EditText) findViewById(R.id.txtOA12);

                tvRDFa=(TextView) findViewById(R.id.tvRDFa);
                ctvA13=(CheckedTextView)findViewById(R.id.ctvA13);
                tvOA13=(TextView)findViewById(R.id.tvOA13);
                txtOA13=(EditText) findViewById(R.id.txtOA13);

                tvLDFa=(TextView) findViewById(R.id.tvRDFa);
                ctvA14=(CheckedTextView)findViewById(R.id.ctvA14);
                tvOA14=(TextView)findViewById(R.id.tvOA14);
                txtOA14=(EditText) findViewById(R.id.txtOA14);

                tvAE=(TextView) findViewById(R.id.tvAE);
                ctvA15=(CheckedTextView)findViewById(R.id.ctvA15);
                tvOA15=(TextView)findViewById(R.id.tvOA15);
                txtOA15=(EditText) findViewById(R.id.txtOA15);

                tvCS=(TextView) findViewById(R.id.tvCS);
                ctvA16=(CheckedTextView)findViewById(R.id.ctvA16);
                tvOA16=(TextView)findViewById(R.id.tvOA16);
                txtOA16=(EditText) findViewById(R.id.txtOA16);

                tvTAA=(TextView) findViewById(R.id.tvTAA);
                ctvA17=(CheckedTextView)findViewById(R.id.ctvA17);
                tvOA17=(TextView)findViewById(R.id.tvOA17);
                txtOA17=(EditText) findViewById(R.id.txtOA17);

                tvTR=(TextView) findViewById(R.id.tvTR);
                ctvA18=(CheckedTextView)findViewById(R.id.ctvA18);
                tvOA18=(TextView)findViewById(R.id.tvOA18);
                txtOA18=(EditText) findViewById(R.id.txtOA18);

                tvAEA=(TextView) findViewById(R.id.tvAEA);
                ctvA19=(CheckedTextView)findViewById(R.id.ctvA19);
                tvOA19=(TextView)findViewById(R.id.tvOA19);
                txtOA19=(EditText) findViewById(R.id.txtOA19);

                tvEM=(TextView) findViewById(R.id.tvEM);
                ctvA20=(CheckedTextView)findViewById(R.id.ctvA20);
                tvOA20=(TextView)findViewById(R.id.tvOA20);
                txtOA20=(EditText) findViewById(R.id.txtOA20);

                tvSIDA=(TextView) findViewById(R.id.tvSIDA);
                ctvA21=(CheckedTextView)findViewById(R.id.ctvA21);
                tvOA21=(TextView)findViewById(R.id.tvOA21);
                txtOA21=(EditText) findViewById(R.id.txtOA21);

                tvA=(TextView) findViewById(R.id.tvA);
                ctvA22=(CheckedTextView)findViewById(R.id.ctvA22);
                tvOA22=(TextView)findViewById(R.id.tvOA22);
                txtOA22=(EditText) findViewById(R.id.txtOA22);

                tvT=(TextView) findViewById(R.id.tvT);
                ctvA23=(CheckedTextView)findViewById(R.id.ctvA23);
                tvOA23=(TextView)findViewById(R.id.tvOA23);
                txtOA23=(EditText) findViewById(R.id.txtOA23);

                tvMAR=(TextView) findViewById(R.id.tvMAR);
                ctvA24=(CheckedTextView)findViewById(R.id.ctvA24);
                tvOA24=(TextView)findViewById(R.id.tvOA24);
                txtOA24=(EditText) findViewById(R.id.txtOA24);

                tvPAS=(TextView) findViewById(R.id.tvPAS);
                ctvA25=(CheckedTextView)findViewById(R.id.ctvA25);
                tvOA25=(TextView)findViewById(R.id.tvOA25);
                txtOA25=(EditText) findViewById(R.id.txtOA25);

                tvSOL=(TextView) findViewById(R.id.tvPAS);
                ctvA26=(CheckedTextView)findViewById(R.id.ctvA26);
                tvOA26=(TextView)findViewById(R.id.tvOA26);
                txtOA26=(EditText) findViewById(R.id.txtOA26);

                tvMET=(TextView) findViewById(R.id.tvMET);
                ctvA27=(CheckedTextView)findViewById(R.id.ctvA27);
                tvOA27=(TextView)findViewById(R.id.tvOA27);
                txtOA27=(EditText) findViewById(R.id.txtOA27);

                tvCOCA=(TextView) findViewById(R.id.tvCOCA);
                ctvA28=(CheckedTextView)findViewById(R.id.ctvA28);
                tvOA28=(TextView)findViewById(R.id.tvOA28);
                txtOA28=(EditText) findViewById(R.id.txtOA28);

                tvSUSF=(TextView) findViewById(R.id.tvSUSF);
                ctvA29=(CheckedTextView)findViewById(R.id.ctvA29);
                tvOA29=(TextView)findViewById(R.id.tvOA29);
                txtOA29=(EditText) findViewById(R.id.txtOA29);

                txt2049.setText("");
                txt2050.setText("");

                ctvA1.setText(lista1.get(pos).getAedad());
                ctvA1.setChecked(true);
                ctvA1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA1.setVisibility(View.GONE);
                txtOA1.setVisibility(View.GONE);
                txtOA1.setText("");

                ctvA2.setText(famili.get(pos).getAcalle());
                ctvA2.setChecked(true);
                ctvA2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA2.setVisibility(View.GONE);
                txtOA2.setVisibility(View.GONE);
                txtOA2.setText("");

                ctvA3.setText(famili.get(pos).getAnumero());
                ctvA3.setChecked(true);
                ctvA3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA3.setVisibility(View.GONE);
                txtOA3.setVisibility(View.GONE);
                txtOA3.setText("");

                ctvA4.setText(famili.get(pos).getAcolonia());
                ctvA4.setChecked(true);
                ctvA4.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA4.setVisibility(View.GONE);
                txtOA4.setVisibility(View.GONE);
                txtOA4.setText("");

                ctvA5.setText(famili.get(pos).getAcp());
                ctvA5.setChecked(true);
                ctvA5.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA5.setVisibility(View.GONE);
                txtOA5.setVisibility(View.GONE);
                txtOA5.setText("");

                ctvA6.setText(famili.get(pos).getAmunicipio());
                ctvA6.setChecked(true);
                ctvA6.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA6.setVisibility(View.GONE);
                txtOA6.setVisibility(View.GONE);
                txtOA6.setText("");

                ctvA7.setText(famili.get(pos).getAestado());
                ctvA7.setChecked(true);
                ctvA7.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA7.setVisibility(View.GONE);
                txtOA7.setVisibility(View.GONE);
                txtOA7.setText("");

                ctvA8.setText(famili.get(pos).getApais());
                ctvA8.setChecked(true);
                ctvA8.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA8.setVisibility(View.GONE);
                txtOA8.setVisibility(View.GONE);
                txtOA8.setText("");

                ctvA9.setText(famili.get(pos).getAtemporalidad());
                ctvA9.setChecked(true);
                ctvA9.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA9.setVisibility(View.GONE);
                txtOA9.setVisibility(View.GONE);
                txtOA9.setText("");

                ctvA10.setText(famili.get(pos).getAdomiciliof());
                ctvA10.setChecked(true);
                ctvA10.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA10.setVisibility(View.GONE);
                txtOA10.setVisibility(View.GONE);
                txtOA10.setText("");

                ctvA11.setText(dfamili.get(pos).getAubicarfam());
                ctvA11.setChecked(true);
                ctvA11.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA11.setVisibility(View.GONE);
                txtOA11.setVisibility(View.GONE);
                txtOA11.setText("");

                ctvA12.setText(dfamili.get(pos).getAnombrefam());
                ctvA12.setChecked(true);
                ctvA12.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA12.setVisibility(View.GONE);
                txtOA12.setVisibility(View.GONE);
                txtOA12.setText("");

                ctvA13.setText(dfamili.get(pos).getArelacionfam());
                ctvA13.setChecked(true);
                ctvA13.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA13.setVisibility(View.GONE);
                txtOA13.setVisibility(View.GONE);
                txtOA13.setText("");

                ctvA14.setText(dfamili.get(pos).getAubicarfam());
                ctvA14.setChecked(true);
                ctvA14.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA14.setVisibility(View.GONE);
                txtOA14.setVisibility(View.GONE);
                txtOA14.setText("");

                ctvA15.setText(escolar.get(pos).getAasiste());
                ctvA15.setChecked(true);
                ctvA15.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA15.setVisibility(View.GONE);
                txtOA15.setVisibility(View.GONE);
                txtOA15.setText("");

                ctvA16.setText(escolar.get(pos).getAconcluyo());
                ctvA16.setChecked(true);
                ctvA16.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA16.setVisibility(View.GONE);
                txtOA16.setVisibility(View.GONE);
                txtOA16.setText("");

                ctvA17.setText(labor.get(pos).getAtrabaja());
                ctvA17.setChecked(true);
                ctvA17.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA17.setVisibility(View.GONE);
                txtOA17.setVisibility(View.GONE);
                txtOA17.setText("");

                ctvA18.setText(labor.get(pos).getArecurrente());
                ctvA18.setChecked(true);
                ctvA18.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA18.setVisibility(View.GONE);
                txtOA18.setVisibility(View.GONE);
                txtOA18.setText("");

                ctvA19.setText(actividades.get(pos).getArealiza());
                ctvA19.setChecked(true);
                ctvA19.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA19.setVisibility(View.GONE);
                txtOA19.setVisibility(View.GONE);
                txtOA19.setText("");

                ctvA20.setText(salud.get(pos).getAmadre());
                ctvA20.setChecked(true);
                ctvA20.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA20.setVisibility(View.GONE);
                txtOA20.setVisibility(View.GONE);
                txtOA20.setText("");

                ctvA21.setText(salud.get(pos).getAmedicamento());
                ctvA21.setChecked(true);
                ctvA21.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA21.setVisibility(View.GONE);
                txtOA21.setVisibility(View.GONE);
                txtOA21.setText("");

                ctvA22.setText(consumo.get(pos).getAconsume_alcohol());
                ctvA22.setChecked(true);
                ctvA22.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA22.setVisibility(View.GONE);
                txtOA22.setVisibility(View.GONE);
                txtOA22.setText("");

                ctvA23.setText(consumo.get(pos).getAconsume_tabaco());
                ctvA23.setChecked(true);
                ctvA23.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA23.setVisibility(View.GONE);
                txtOA23.setVisibility(View.GONE);
                txtOA23.setText("");

                ctvA24.setText(consumo.get(pos).getAconsume_marihuana());
                ctvA24.setChecked(true);
                ctvA24.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA24.setVisibility(View.GONE);
                txtOA24.setVisibility(View.GONE);
                txtOA24.setText("");

                ctvA25.setText(consumo.get(pos).getAconsume_pastillas());
                ctvA25.setChecked(true);
                ctvA25.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA25.setVisibility(View.GONE);
                txtOA25.setVisibility(View.GONE);
                txtOA25.setText("");

                ctvA26.setText(consumo.get(pos).getAconsume_solventes());
                ctvA26.setChecked(true);
                ctvA26.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA26.setVisibility(View.GONE);
                txtOA26.setVisibility(View.GONE);
                txtOA26.setText("");

                ctvA27.setText(consumo.get(pos).getAconsume_metanfetaminas());
                ctvA27.setChecked(true);
                ctvA27.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA27.setVisibility(View.GONE);
                txtOA27.setVisibility(View.GONE);
                txtOA27.setText("");

                ctvA28.setText(consumo.get(pos).getAconsume_cocaina());
                ctvA28.setChecked(true);
                ctvA28.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA28.setVisibility(View.GONE);
                txtOA28.setVisibility(View.GONE);
                txtOA28.setText("");

                ctvA29.setText(consumo.get(pos).getAconsumemas());
                ctvA29.setChecked(true);
                ctvA29.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                tvOA29.setVisibility(View.GONE);
                txtOA29.setVisibility(View.GONE);
                txtOA29.setText("");

                //region Checkbox click listeners
                //region edad
                ctvA1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA1.isChecked()) {
                            ctvA1.setChecked(false);
                            ctvA1.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA1.setVisibility(View.VISIBLE);
                            txtOA1.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA1.setChecked(true);
                            ctvA1.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA1.setVisibility(View.GONE);
                            txtOA1.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA2.isChecked()) {
                            ctvA2.setChecked(false);
                            ctvA2.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA2.setVisibility(View.VISIBLE);
                            txtOA2.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA2.setChecked(true);
                            ctvA2.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA2.setVisibility(View.GONE);
                            txtOA2.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA3.isChecked()) {
                            ctvA3.setChecked(false);
                            ctvA3.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA3.setVisibility(View.VISIBLE);
                            txtOA3.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA3.setChecked(true);
                            ctvA3.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA3.setVisibility(View.GONE);
                            txtOA3.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA4.isChecked()) {
                            ctvA4.setChecked(false);
                            ctvA4.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA4.setVisibility(View.VISIBLE);
                            txtOA4.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA4.setChecked(true);
                            ctvA4.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA4.setVisibility(View.GONE);
                            txtOA4.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA5.isChecked()) {
                            ctvA5.setChecked(false);
                            ctvA5.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA5.setVisibility(View.VISIBLE);
                            txtOA5.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA5.setChecked(true);
                            ctvA5.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA5.setVisibility(View.GONE);
                            txtOA5.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA6.isChecked()) {
                            ctvA6.setChecked(false);
                            ctvA6.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA6.setVisibility(View.VISIBLE);
                            txtOA6.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA6.setChecked(true);
                            ctvA6.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA6.setVisibility(View.GONE);
                            txtOA6.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA7.isChecked()) {
                            ctvA7.setChecked(false);
                            ctvA7.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA7.setVisibility(View.VISIBLE);
                            txtOA7.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA7.setChecked(true);
                            ctvA7.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA7.setVisibility(View.GONE);
                            txtOA7.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA8.isChecked()) {
                            ctvA8.setChecked(false);
                            ctvA8.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA8.setVisibility(View.VISIBLE);
                            txtOA8.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA8.setChecked(true);
                            ctvA8.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA8.setVisibility(View.GONE);
                            txtOA8.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA9.isChecked()) {
                            ctvA9.setChecked(false);
                            ctvA9.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA9.setVisibility(View.VISIBLE);
                            txtOA9.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA9.setChecked(true);
                            ctvA9.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA9.setVisibility(View.GONE);
                            txtOA9.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA10.isChecked()) {
                            ctvA10.setChecked(false);
                            ctvA10.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA10.setVisibility(View.VISIBLE);
                            txtOA10.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA10.setChecked(true);
                            ctvA10.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA10.setVisibility(View.GONE);
                            txtOA10.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA11.isChecked()) {
                            ctvA11.setChecked(false);
                            ctvA11.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA11.setVisibility(View.VISIBLE);
                            txtOA11.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA11.setChecked(true);
                            ctvA11.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA11.setVisibility(View.GONE);
                            txtOA11.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA12.isChecked()) {
                            ctvA12.setChecked(false);
                            ctvA12.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA12.setVisibility(View.VISIBLE);
                            txtOA12.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA12.setChecked(true);
                            ctvA12.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA12.setVisibility(View.GONE);
                            txtOA12.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA13.isChecked()) {
                            ctvA13.setChecked(false);
                            ctvA13.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA13.setVisibility(View.VISIBLE);
                            txtOA13.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA13.setChecked(true);
                            ctvA13.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA13.setVisibility(View.GONE);
                            txtOA13.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA14.isChecked()) {
                            ctvA14.setChecked(false);
                            ctvA14.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA14.setVisibility(View.VISIBLE);
                            txtOA14.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA14.setChecked(true);
                            ctvA14.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA14.setVisibility(View.GONE);
                            txtOA14.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA15.isChecked()) {
                            ctvA15.setChecked(false);
                            ctvA15.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA15.setVisibility(View.VISIBLE);
                            txtOA15.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA15.setChecked(true);
                            ctvA15.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA15.setVisibility(View.GONE);
                            txtOA15.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA16.isChecked()) {
                            ctvA16.setChecked(false);
                            ctvA16.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA16.setVisibility(View.VISIBLE);
                            txtOA16.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA16.setChecked(true);
                            ctvA16.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA16.setVisibility(View.GONE);
                            txtOA16.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA17.isChecked()) {
                            ctvA17.setChecked(false);
                            ctvA17.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA17.setVisibility(View.VISIBLE);
                            txtOA17.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA17.setChecked(true);
                            ctvA17.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA17.setVisibility(View.GONE);
                            txtOA17.setVisibility(View.GONE);
                        }
                    }
                });

                ctvA18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA18.isChecked()) {
                            ctvA18.setChecked(false);
                            ctvA18.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA18.setVisibility(View.VISIBLE);
                            txtOA18.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA18.setChecked(true);
                            ctvA18.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA18.setVisibility(View.GONE);
                            txtOA18.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA19.isChecked()) {
                            ctvA19.setChecked(false);
                            ctvA19.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA19.setVisibility(View.VISIBLE);
                            txtOA19.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA19.setChecked(true);
                            ctvA19.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA19.setVisibility(View.GONE);
                            txtOA19.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA20.isChecked()) {
                            ctvA20.setChecked(false);
                            ctvA20.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA20.setVisibility(View.VISIBLE);
                            txtOA20.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA20.setChecked(true);
                            ctvA20.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA20.setVisibility(View.GONE);
                            txtOA20.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA21.isChecked()) {
                            ctvA21.setChecked(false);
                            ctvA21.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA21.setVisibility(View.VISIBLE);
                            txtOA21.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA21.setChecked(true);
                            ctvA21.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA21.setVisibility(View.GONE);
                            txtOA21.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA22.isChecked()) {
                            ctvA22.setChecked(false);
                            ctvA22.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA22.setVisibility(View.VISIBLE);
                            txtOA22.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA22.setChecked(true);
                            ctvA22.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA22.setVisibility(View.GONE);
                            txtOA22.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA23.isChecked()) {
                            ctvA23.setChecked(false);
                            ctvA23.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA23.setVisibility(View.VISIBLE);
                            txtOA23.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA23.setChecked(true);
                            ctvA23.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA23.setVisibility(View.GONE);
                            txtOA23.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA24.isChecked()) {
                            ctvA24.setChecked(false);
                            ctvA24.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA24.setVisibility(View.VISIBLE);
                            txtOA24.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA24.setChecked(true);
                            ctvA24.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA24.setVisibility(View.GONE);
                            txtOA24.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA25.isChecked()) {
                            ctvA25.setChecked(false);
                            ctvA25.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA25.setVisibility(View.VISIBLE);
                            txtOA25.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA25.setChecked(true);
                            ctvA25.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA25.setVisibility(View.GONE);
                            txtOA25.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA26.isChecked()) {
                            ctvA26.setChecked(false);
                            ctvA26.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA26.setVisibility(View.VISIBLE);
                            txtOA26.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA26.setChecked(true);
                            ctvA26.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA26.setVisibility(View.GONE);
                            txtOA26.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA27.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA27.isChecked()) {
                            ctvA27.setChecked(false);
                            ctvA27.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA27.setVisibility(View.VISIBLE);
                            txtOA27.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA27.setChecked(true);
                            ctvA27.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA27.setVisibility(View.GONE);
                            txtOA27.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA28.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA28.isChecked()) {
                            ctvA28.setChecked(false);
                            ctvA28.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA28.setVisibility(View.VISIBLE);
                            txtOA28.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA28.setChecked(true);
                            ctvA28.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA28.setVisibility(View.GONE);
                            txtOA28.setVisibility(View.GONE);
                        }
                    }
                });
                ctvA29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (ctvA29.isChecked()) {
                            ctvA29.setChecked(false);
                            ctvA29.setCheckMarkDrawable(R.drawable.ic_check_box_outline_blank_black_24dp);
                            tvOA29.setVisibility(View.VISIBLE);
                            txtOA29.setVisibility(View.VISIBLE);
                        }
                        else {
                            ctvA29.setChecked(true);
                            ctvA29.setCheckMarkDrawable(R.drawable.ic_check_box_black_24dp);
                            tvOA29.setVisibility(View.GONE);
                            txtOA29.setVisibility(View.GONE);
                        }
                    }
                });
                //endregion
                //endregion

                btnGuardarObservacionesA=(Button) findViewById(R.id.btnGuardarObservacionesA);
                btnGuardarObservacionesA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ArrayList<datosGeneralesA> lista1;
                        lista1 = db.getdatosGeneralesA();
                        int pos = sPVerifica1.getSelectedItemPosition();
                        String afolio = lista1.get(pos).getAfolio();

                        //region Get de Observaciones
                        r1=txtOA1.getText().toString().toUpperCase();
                        r2=txtOA2.getText().toString().toUpperCase();
                        r3=txtOA3.getText().toString().toUpperCase();
                        r4=txtOA4.getText().toString().toUpperCase();
                        r5=txtOA5.getText().toString().toUpperCase();
                        r6=txtOA6.getText().toString().toUpperCase();
                        r7=txtOA7.getText().toString().toUpperCase();
                        r8=txtOA8.getText().toString().toUpperCase();
                        r9=txtOA9.getText().toString().toUpperCase();
                        r10=txtOA10.getText().toString().toUpperCase();
                        r11=txtOA11.getText().toString().toUpperCase();
                        r12=txtOA12.getText().toString().toUpperCase();
                        r13=txtOA13.getText().toString().toUpperCase();
                        r14=txtOA14.getText().toString().toUpperCase();
                        r15=txtOA15.getText().toString().toUpperCase();
                        r16=txtOA16.getText().toString().toUpperCase();
                        r17=txtOA17.getText().toString().toUpperCase();
                        r18=txtOA18.getText().toString().toUpperCase();
                        r19=txtOA19.getText().toString().toUpperCase();
                        r20=txtOA20.getText().toString().toUpperCase();
                        r21=txtOA21.getText().toString().toUpperCase();
                        r22=txtOA22.getText().toString().toUpperCase();
                        r23=txtOA23.getText().toString().toUpperCase();
                        r24=txtOA24.getText().toString().toUpperCase();
                        r25=txtOA25.getText().toString().toUpperCase();
                        r26=txtOA26.getText().toString().toUpperCase();
                        r27=txtOA27.getText().toString().toUpperCase();
                        r28=txtOA28.getText().toString().toUpperCase();
                        r29=txtOA29.getText().toString().toUpperCase();

                        r30=txt2049.getText().toString().toUpperCase();
                        r31=txt2050.getText().toString().toUpperCase();
                        //endregion

                        //region Insertar observaciones en datos generales
                        String oper = sP2048.getSelectedItem().toString();
                        //== "Verificar"
                        if(oper.equals(opers[0])){
                            if(ctvA1.isChecked() == false && r1.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aedad", r1, lista1.get(pos).getAedad(), afolio);
                            }
                            if(ctvA2.isChecked() == false && r2.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Acalle", r2, famili.get(pos).getAcalle(), afolio);
                            }
                            if(ctvA3.isChecked() == false && r3.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Anumero", r3, famili.get(pos).getAnumero(), afolio);
                            }
                            if(ctvA4.isChecked() == false && r4.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Acolonia", r4, famili.get(pos).getAcolonia(), afolio);
                            }
                            if(ctvA5.isChecked() == false && r5.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Acp", r5, famili.get(pos).getAcp(), afolio);
                            }
                            if(ctvA6.isChecked() == false && r6.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Amunicipio", r6, famili.get(pos).getAmunicipio(), afolio);
                            }
                            if(ctvA7.isChecked() == false && r7.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aestado", r7, famili.get(pos).getAestado(), afolio);
                            }
                            if(ctvA8.isChecked() == false && r8.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Apais", r8, famili.get(pos).getApais(), afolio);
                            }
                            if(ctvA9.isChecked() == false && r9.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Atemporalidad", r9, famili.get(pos).getAtemporalidad(), afolio);
                            }
                            if(ctvA10.isChecked() == false && r10.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Adomiciliof", r10, famili.get(pos).getAdomiciliof(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r11.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aubicarfam", r11, dfamili.get(pos).getAubicarfam(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r12.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Anombrefam", r12, dfamili.get(pos).getAnombrefam(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r13.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Arelacionfam", r13, dfamili.get(pos).getArelacionfam(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r14.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Alocalidadfam", r14, dfamili.get(pos).getAlocalidadfam(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r15.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aasiste", r15, escolar.get(pos).getAasiste(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r16.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconcluyo", r16, escolar.get(pos).getAconcluyo(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r17.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Atrabaja", r17, labor.get(pos).getAtrabaja(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r18.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Arecurrente", r18, labor.get(pos).getArecurrente(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r19.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Arealiza", r19, actividades.get(pos).getArealiza(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r20.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Amadre", r20, salud.get(pos).getAmadre(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r21.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Amedicamento", r21, salud.get(pos).getAmedicamento(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r22.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_alcohol", r22, consumo.get(pos).getAconsume_alcohol(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r23.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_tabaco", r23, consumo.get(pos).getAconsume_tabaco(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r24.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_marihuana", r24, consumo.get(pos).getAconsume_marihuana(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r25.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_pastillas", r25, consumo.get(pos).getAconsume_pastillas(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r26.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_solventes", r26, consumo.get(pos).getAconsume_solventes(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r27.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_metanfetaminas", r27, consumo.get(pos).getAconsume_metanfetaminas(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r28.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsume_cocaina", r28, consumo.get(pos).getAconsume_cocaina(), afolio);
                            }
                            if(ctvA11.isChecked() == false && r29.isEmpty() == false) {
                                db.insertarDatosObservacionesA("Aconsumemas", r29, consumo.get(pos).getAconsumemas(), afolio);
                            }

                            //Save the interviewee information
                            db.insertarDatosVerificacionA(r30,r31,afolio);
                            //endregion
                        }
                        //region Actualizar
                        if(ctvA1.isChecked() == false && r1.isEmpty() == false) {
                            db.updateTable("datos_generales_a", "Aedad", r1, afolio);
                        }
                        if(ctvA2.isChecked() == false && r2.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a", "Acalle", r2, afolio);
                        }
                        if(ctvA3.isChecked() == false && r3.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a", "Anumero", r3,afolio);
                        }
                        if(ctvA4.isChecked() == false && r4.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Acolonia", r4, afolio);
                        }
                        if(ctvA5.isChecked() == false && r5.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Acp", r5, afolio);
                        }
                        if(ctvA6.isChecked() == false && r6.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Amunicipio", r6, afolio);
                        }
                        if(ctvA7.isChecked() == false && r7.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Aestado", r7, afolio);
                        }
                        if(ctvA8.isChecked() == false && r8.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Apais", r8, afolio);
                        }
                        if(ctvA9.isChecked() == false && r9.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Atemporalidad", r9, afolio);
                        }
                        if(ctvA10.isChecked() == false && r10.isEmpty() == false) {
                            db.updateTable("ficha_familiar_a","Adomiciliof", r10,  afolio);//////////77
                        }
                        if(ctvA11.isChecked() == false && r11.isEmpty() == false) {
                            db.updateTable("datos_familiares_a","Aubicarfam", r11, afolio);
                        }
                        if(ctvA11.isChecked() == false && r12.isEmpty() == false) {
                            db.updateTable("datos_familiares_a","Anombrefam", r12, afolio);
                        }
                        if(ctvA11.isChecked() == false && r13.isEmpty() == false) {
                            db.updateTable("datos_familiares_a","Arelacionfam", r13, afolio);
                        }
                        if(ctvA11.isChecked() == false && r14.isEmpty() == false) {
                            db.updateTable("datos_familiares_a","Alocalidadfam", r14,  afolio);
                        }
                        if(ctvA11.isChecked() == false && r15.isEmpty() == false) {
                            db.updateTable("historial_escolar_a","Aasiste", r15, afolio);
                        }
                        if(ctvA11.isChecked() == false && r16.isEmpty() == false) {
                            db.updateTable("historial_escolar_a","Aconcluyo", r16, afolio);
                        }
                        if(ctvA11.isChecked() == false && r17.isEmpty() == false) {
                            db.updateTable("historial_laboral_a","Atrabaja", r17, afolio);
                        }
                        if(ctvA11.isChecked() == false && r18.isEmpty() == false) {
                            db.updateTable("historial_laboral_a","Arecurrente", r18, afolio);
                        }
                        if(ctvA11.isChecked() == false && r19.isEmpty() == false) {
                            db.updateTable("actividades_extraescolares_a","Arealiza", r19, afolio);
                        }
                        if(ctvA11.isChecked() == false && r20.isEmpty() == false) {
                            db.updateTable("revision_medica_a","Amadre", r20, afolio);
                        }
                        if(ctvA11.isChecked() == false && r21.isEmpty() == false) {
                            db.updateTable("revision_medica_a","Amedicamento", r21,afolio);
                        }
                        if(ctvA11.isChecked() == false && r22.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_alcohol", r22, afolio);
                        }
                        if(ctvA11.isChecked() == false && r23.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_tabaco", r23, afolio);
                        }
                        if(ctvA11.isChecked() == false && r24.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_marihuana", r24, afolio);
                        }
                        if(ctvA11.isChecked() == false && r25.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_pastillas", r25, afolio);
                        }
                        if(ctvA11.isChecked() == false && r26.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_solventes", r26, afolio);
                        }
                        if(ctvA11.isChecked() == false && r27.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_metanfetaminas", r27, afolio);
                        }
                        if(ctvA11.isChecked() == false && r28.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsume_cocaina", r28, afolio);
                        }
                        if(ctvA11.isChecked() == false && r29.isEmpty() == false) {
                            db.updateTable("consumo_sustancias_a","Aconsumemas", r29, afolio);
                        }
                        //endregion

                        db.updateTable("datos_generales_a", "Averificacion", "SI", afolio);

                        //Verificación
                        if(oper.equals(opers[0])) {
                            Toast.makeText(getApplicationContext(), "Entrevista Verificada", Toast.LENGTH_SHORT).show();
                        }
                        //Edición
                        else {
                            Toast.makeText(getApplicationContext(), "Entrevista Actualizada", Toast.LENGTH_SHORT).show();
                        }

                        Intent intent= new Intent(view.getContext(), MainMenu.class);
                        startActivity(intent);

                    }
                });

                btnPhotoA = (Button) findViewById(R.id.btnPhotoA);
                btnPhotoA.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dispatchTakePictureIntent();
                    }
                });


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            //region Spinner
            sP2048 = (Spinner) findViewById(R.id.sP2048);
                sP2048.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opers));
        tv2049=(TextView) findViewById(R.id.tv2049);
        txt2049=(EditText) findViewById(R.id.txt2049);
        tv2050=(TextView) findViewById(R.id.tv2050);
        txt2050=(EditText) findViewById(R.id.txt2050);
                sP2048.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem=parent.getSelectedItem().toString();
                    if (position == 0){
                        tv2049.setVisibility(View.VISIBLE);
                        txt2049.setVisibility(View.VISIBLE);
                        tv2050.setVisibility(View.VISIBLE);
                        txt2050.setVisibility(View.VISIBLE);
                    }
                    else{
                        tv2049.setVisibility(View.GONE);
                        txt2049.setVisibility(View.GONE);
                        tv2050.setVisibility(View.GONE);
                        txt2050.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    return;
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


        //region Visibles

        btnDg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llDg.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llDg.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });


        btnFfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llFfa.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llFfa.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnVH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llVH.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llVH.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llCE.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llCE.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnIC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llIC.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llIC.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        //endregion Visibles
            //endregion
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == RESULT_OK) {
                //Show toast after image has been saved
                Toast.makeText(getApplicationContext(), "Foto Guardada", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "La foto no se guardo", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name in /storage/sdcard0/Android/data/com.sistemas.evaluacion/files/Pictures/
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        int pos = sPVerifica1.getSelectedItemPosition();
        String folio = lista1.get(pos).getAfolio();
        File image;
        Integer counter = 0;
        do {
            counter++;
            image = new File(storageDir, "VERIFICACION-" + folio + "-" + counter.toString() + ".png");
        }
        while(image.exists());

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
                ex.printStackTrace();
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    photoURI = FileProvider.getUriForFile(this,
                            "com.sistemas.evaluacion",
                            photoFile);
                } else {
                    photoURI = Uri.fromFile(photoFile);
                }
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
            else{
                Toast.makeText(getApplicationContext(), "La foto no se pudo crear", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
