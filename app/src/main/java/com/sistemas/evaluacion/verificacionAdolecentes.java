package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.sistemas.evaluacion.entidades.datosGenerales;

import java.util.ArrayList;

public class verificacionAdolecentes extends AppCompatActivity {
    private MyOpenHelper db;
    ArrayList<datosGenerales> lista1;

    //region EDITTEXT
    //datos generales
    private EditText txtNc, txtFecha, txtNe, txtFolioA ,txtNpa1, txtNpa2, txtNpa3, txtNpa4, txtRa1, txtRa2, txtRa3, txtRa4, txtPOa1, txtPOa2, txtPOa3, txtPOa4,
            txtNa, txtEa, txtFNa, txtCURPa, txtLNa, txtEDOa, txtMa, txtLa, txtNAa ;
    //Ficha familiar Domicilio
    private EditText txtCa, txtNOa, txtCOLa, txtCPa, txtMUa, txtEDO2a, txtPa, txtTa, txtDALa1, txtDALa2,txtDALa3,txtDATa3,txtDATa4,txtDATa1,txtDATa2;
    //Datos familiares
    private EditText txtNDFa1,txtNDFa2,txtRDFa1, txtRDFa2,txtEDFa1, txtEDFa2,txtTDFa1, txtTDFa2,txtCQDFa,txtRDFa,txtLDFa;
    //Dependientes economicos
    private EditText txtNDEa1,txtNDEa2,txtNDEa3,txtRDEa1,txtRDEa2,txtRDEa3,txtEDEa1,txtEDEa2,txtEDEa3,txtTDEa1,txtTDEa2,txtTDEa3;
    //Viculos comunitarios
    private EditText txtNEa,txtDEa,txtTea,txtNIEa,txtUGa,txtNEa1,txtNEa2,txtLE1,txtLE2,txtGC1,txtGC2;
    //Historial laboral
    private EditText txtNTa,txtDTa,txtTTa,txtATa,txtJTa,txtNT1,txtLT1,txtAT1,txtTT1;
    //actividades Extraescolares
    private EditText txtA1,txtL1,txtC1,txtT1;
    //Consumo de sustancias
    private EditText txtCaA,txtCaT,txtFDCA,txtFDCT,txtFDCMAR,txtCaMAR,txtFDCPAS,txtCaPAS,txtFDCSOL,txtCaSOL,txtFDCMET,txtCaMET,txtCaCOCA,txtFDCCOCA;
    //endregion

    //region TEXTVIEW
    //DATOS GENERALES
    private TextView a;
    //DOMICILIOS ANTERIORES
    private TextView tvD1A,tvD2A,tvD3A,tvDA1, tvDA2,tvDATa1,tvDALa3,tvDATa3,tvDATa2;
    //REUBICAR ADOLECENTE
    private TextView tvCQDFa, tvRDFa, tvLDFa;
    //DEPENDIENTES ECONOMICOS
    private TextView tvDPA1,tvDPA2,tvDPA3,tvNDEa1,tvRDEa1,tvEDEa1,tvTDEa1,tvNDEa2,tvRDEa2,tvEDEa2,tvTDEa2,tvNDEa3,tvRDEa3,tvEDEa3,tvTDEa3,tvAR,tvAR2,tvAR3;
    //DEPENDIENTES TRABAJO ACTUAL
    private TextView tvTA,tvNTa,tvTAA,tvTR,tvDTa,tvTTa,tvATa,tvTC,tvJTa,tvNT1,tvLT1,tvAT1,tvTT1;
    ///////ESCUELAS ANTERIORES
    private TextView tvTVEA,tvNEa,tvDEa,tvTea,tvNIEa,tvNEa1,tvLE1,tvGC1;
    //////////ACTIVIDADRES EXTRAESCOLARES
    private TextView tvA1,tvL1,tvC1,tvCT;
    /////////////CONSUMOS
    private TextView tvA,tvFREA,tvCaA,tvFDCA,tvT,tvFRET,tvCaT,tvFDCT,tvMAR,tvFREMAR,tvCaMAR,tvFDCMAR,tvPAS,tvFREPAS,tvCaPAS,tvFDCPAS,tvSOL,tvFRESOL,tvCaSOL,tvFDCSOL,tvMET,tvFREMET,tvCaMET,tvFDCMET,tvCOCA,tvFRECOCA,tvCaCOCA,tvFDCCOCA;
    //////
    private TextView tvPC;
    //endregion

    //region SPINNER
    private Spinner sPverificacionAname;
    //endregion

    //region BOTON
    private Button btnverificacionA,btnDg,btnFfa,btnVH,btnCE,btnIC;
    //endregion

    //region BOOLEAN
    //endregion

    //region CheckedTextView
    //endregion

    //region LinearLayaout
    private LinearLayout llDg,llFfa,llVH,llCE,llIC;
    //endregion

    //region String
    private String r1A,r2A,r3A,r4A,r5A,r6A,r7A,r8A,r9A,r10A,r11A,r13A,r14A,r17A,r18A,r19A,r20A,r21A,r22A,r23A,r24A,
            r25A,r26A,r27A,r28A,r29A,r30A,r31A,r32A,r33A,r34A,r35A,r36A,r38A,r39A,r40A,r41A,r42A,r43A,r44A,r45A,r46A,r47A,r48A,
            r49A,r50A,r51A,r52A,r53A,r54A,r55A,r56A,r57A,r58A,r59A,r60A,r61A,r62A,r63A,r64A,r65A,r66A,r67A,r68A,r69A,r70A,r71A,
            r73A,r75A,r76A,r77A,r78A,r79A,r80A,r81A,r82A,r83A,r84A,r85A,r86A,r87A,r88A,r89A,r90A,r91A,r92A,r93A,r94A,r95A,r96A,r97A,r98A,
            r99A,r100A;
    //SPINNERS
    private String rS1,rS2,rS3,rS4,rS5,rS6,rS7,rS8,rS9,rS10,rS11,rS12,rS13,rS14,rS15,rS16,rS17,rS18,rS19,rS20,rS21,rS22,rS23,rS24,rS25,rS26,rS27,
            rS28,rS29,rS30,rS31,rS32,rS33,rS34,rS35,rS36,rS37,rS38,rS39,rS40,rS41;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_adolecentes);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        lista1 = db.getDatosGenerales();

        //region Inicializa un spinner con los nombres de los entrevistados
        sPverificacionAname = (Spinner) findViewById(R.id.sPverificacionAname);
        String[] names = new String[lista1.size()];
        for(int i = 0; i < lista1.size(); i++){
            names[i] = lista1.get(i).getNombre();
        }
        sPverificacionAname.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion
        //region Verificar si hay registros
        if(lista1.isEmpty() == false){
            sPverificacionAname.setSelection(lista1.size() - 1);

            /*tvControlA=(TextView) findViewById(R.id.tvControlA);
            llControlA=(LinearLayout) findViewById(R.id.llControlA);

            llControlA.setVisibility(View.VISIBLE);
            tvControlA.setVisibility(View.GONE);*/
        }
        //endregion

        sPverificacionAname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {

                /*vtNa=(TextView) findViewById(R.id.tvNa);
                txtNa=(EditText) findViewById(R.id.txtNa);
                tvNaO = (TextView)findViewById(R.id.tvNaO);
                etNaO = (EditText)findViewById(R.id.etNaO);

                vtSex=(TextView) findViewById(R.id.tvSex);
                sPsex=(Spinner) findViewById(R.id.sPSex);
                tvSexO = (TextView)findViewById(R.id.tvSexO);
                etSexO = (EditText)findViewById(R.id.etSexO);*/

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }
}
