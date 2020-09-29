//carpeta de investigacion de adolescentes
package com.sistemas.evaluacion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosGeneralesA;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class infoCasoAdolescente extends AppCompatActivity {

    //regio boolean
    private boolean pR=false,ICA=false,PP=false,VO=false,PL=false ;

    //INFORMACION DE CASO ACTUAL
    private TextView tvEspe,tvTPc,tvFp,tvF,tvEVS,tvVD,tvVV,tvCV,tvRR,tvRR_1,tvEx1,tvEx2,tvNC1,tvNC2,tvNC3,tvNC4,tvNC5,tvD1,tvD2,tvD3,tvD4,tvD5,tvTM1,tvTM2,tvTM3,tvTM4,tvTM5,tvE1,tvE2,tvE3,tvE4,tvE5,tvSL,tvPPP1,tvPPP2,tvPPP3,tvPPP4,tvPPP5;
    //endregion

    //Infotmacion el caso actual
    private EditText txtEspe,txtCCD,txtFp,txtF,txtDi,txtNC1,txtNC2,txtNC3,txtNC4,txtNC5,txtD1,txtD2,txtD3,txtD4,txtD5,txtTM1,txtTM2,txtTM3,txtTM4,txtTM5,txtEx1,txtEx2;
    //endregion EditText
    //region SPINNERS
    private Spinner sPE1,sPE2,sPE3,sPE4,sPE5,sPICA,sPTE,sPTI,sPDI,sPUA,sPUD,sPMC,sPHO,sPTP,sPTPc,sPSL,sPVO,sPVD,sPVV,sPRR,sPDV,sPEVF,sPSE,sPSA;
    //endregion
    //region BOTTONES
    private Button btnGuardarIA,btnICA,btnPP,btnVO,btnPL;
    //endregion
    String folio, carpeta;
    //region Strings
    private String r1,r2,r3,r3_1,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25;
    /////SPINNERS
    private String rS1,rS2,rS3,rS4,rS5,rS6,rS7,rS8,rS8_1,rS9,rS10,rS11,rS12,rS14,rS15,rS16,rS17,rS18;
    //endregion
    //region String
    private String [] nosi={"No", "Si"};
    private String [] nosia={"N/A","No", "Si"};
    private String [] delito={"Otro", "Robo", "Robo Simple", "Violación", "Violencia Familiar", "Daños y Lesiones",
            "Lesiones menores a 15 dias", "Contra la Salud", "Comercio o Suministro", "Portación de Armas de Fuego"};

    private String[] estatus={"N/A","Vigente", "Suspendido", "Revocado", "Cumplido"};
    private String[] otroProceso={"N/A","1","2","3","4","5"};
    //endregion
    //region LinearLayout
    private LinearLayout llControlA ,llICA, llPP,llVO,llPL;
    //endregion


    TextView tvControlA;
    private MyOpenHelper db;
    ArrayList<datosGeneralesA> lista1;
    final ArrayList<Integer> Idx = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_caso_adolescente);


        //region TRAER DATOS DE ENTREVISTRADOS
        txtCCD=(EditText) findViewById(R.id.txtCCD);
        btnGuardarIA=(Button) findViewById(R.id.btnGuardarIA);
        sPICA = (Spinner) findViewById(R.id.sPICA);

        sPE1 =(Spinner) findViewById(R.id.sPE1);
        sPE2 = (Spinner) findViewById(R.id.sPE2);
        sPE3= (Spinner) findViewById(R.id.sPE3);
        sPE4 = (Spinner) findViewById(R.id.sPE4);
        sPE5 = (Spinner) findViewById(R.id.sPE5);
        //endregion

        tvControlA=(TextView) findViewById(R.id.tvControlA);
        llControlA=(LinearLayout) findViewById(R.id.llControlA);

        //region Inicio BD
        db=new MyOpenHelper(this);
        //db.getReadableDatabase();

        lista1 = db.getdatosGeneralesA();

        ArrayList<String> names = new ArrayList<String>();

        for(int i = 0; i < lista1.size(); i++){
            if(lista1.get(i).getAcarpetainvestigacion().equals("SI") == false && lista1.get(i).getAverificacion().equals("SI")) {
                names.add(lista1.get(i).getAnombre()+" "+lista1.get(i).getApaterno()+" "+lista1.get(i).getAmaterno());
                Idx.add(i);
            }
        }

        if(names.size()!=0){
            sPICA.setSelection(names.size() - 1);

            llControlA.setVisibility(View.VISIBLE);
            tvControlA.setVisibility(View.GONE);

        }else{
            llControlA.setVisibility(View.GONE);
            tvControlA.setVisibility(View.VISIBLE);

        }


        sPICA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        sPE1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estatus));
        sPE2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estatus));
        sPE3.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estatus));
        sPE4.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estatus));
        sPE5.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estatus));
        //endregion





        //region INFORMACION DE CASO ACTUAL
        tvTPc=(TextView) findViewById(R.id.tvTPc);
        txtFp=(EditText) findViewById(R.id.txtFp);
        tvFp=(TextView) findViewById(R.id.tvFp);
        txtF=(EditText) findViewById(R.id.txtF);
        tvF=(TextView) findViewById(R.id.tvF);
        txtNC1=(EditText) findViewById(R.id.txtNC1);
        txtNC2=(EditText) findViewById(R.id.txtNC2);
        txtNC3=(EditText) findViewById(R.id.txtNC3);
        txtNC4=(EditText) findViewById(R.id.txtNC4);
        txtNC5=(EditText) findViewById(R.id.txtNC5);

        txtD1=(EditText) findViewById(R.id.txtD1);
        txtD2=(EditText) findViewById(R.id.txtD2);
        txtD3=(EditText) findViewById(R.id.txtD3);
        txtD4=(EditText) findViewById(R.id.txtD4);
        txtD5=(EditText) findViewById(R.id.txtD5);

        txtTM1=(EditText) findViewById(R.id.txtTM1);
        txtTM2=(EditText) findViewById(R.id.txtTM2);
        txtTM3=(EditText) findViewById(R.id.txtTM3);
        txtTM4=(EditText) findViewById(R.id.txtTM4);
        txtTM5=(EditText) findViewById(R.id.txtTM5);


        tvEspe=(TextView) findViewById(R.id.tvEspe);
        txtEspe=(EditText) findViewById(R.id.txtEspe);
        tvNC1=(TextView) findViewById(R.id.tvNC1);
        tvNC2=(TextView) findViewById(R.id.tvNC2);
        tvNC3=(TextView) findViewById(R.id.tvNC3);
        tvNC4=(TextView) findViewById(R.id.tvNC4);
        tvNC5=(TextView) findViewById(R.id.tvNC5);
        tvD1=(TextView) findViewById(R.id.tvD1);
        tvD2=(TextView) findViewById(R.id.tvD2);
        tvD3=(TextView) findViewById(R.id.tvD3);
        tvD4=(TextView) findViewById(R.id.tvD4);
        tvD5=(TextView) findViewById(R.id.tvD5);
        tvTM1=(TextView) findViewById(R.id.tvTM1);
        tvTM2=(TextView) findViewById(R.id.tvTM2);
        tvTM3=(TextView) findViewById(R.id.tvTM3);
        tvTM4=(TextView) findViewById(R.id.tvTM4);
        tvTM5=(TextView) findViewById(R.id.tvTM5);
        tvE1=(TextView) findViewById(R.id.tvE1);
        tvE2=(TextView) findViewById(R.id.tvE2);
        tvE3=(TextView) findViewById(R.id.tvE3);
        tvE4=(TextView) findViewById(R.id.tvE4);
        tvE5=(TextView) findViewById(R.id.tvE5);
        tvPPP1=(TextView) findViewById(R.id.tvPPP1);
        tvPPP2=(TextView) findViewById(R.id.tvPPP2);
        tvPPP3=(TextView) findViewById(R.id.tvPPP3);
        tvPPP4=(TextView) findViewById(R.id.tvPPP4);
        tvPPP5=(TextView) findViewById(R.id.tvPPP5);
        tvSL=(TextView) findViewById(R.id.tvSL);
        tvEVS=(TextView) findViewById(R.id.tvEVS);
        tvVD=(TextView) findViewById(R.id.tvVD);
        tvVV=(TextView) findViewById(R.id.tvVV);
        tvCV=(TextView) findViewById(R.id.tvCV);
        tvRR=(TextView) findViewById(R.id.tvRR);
        tvRR_1=(TextView) findViewById(R.id.tvRR_1);
        txtEx1=(EditText) findViewById(R.id.txtEx1);
        txtEx2=(EditText) findViewById(R.id.txtEx2);
        tvEx1=(TextView) findViewById(R.id.tvEx1);
        tvEx2=(TextView) findViewById(R.id.tvEx2);
        //endregion

        // region sPUA  UNO DE LO DELITOS
        sPTE = (Spinner) findViewById(R.id.sPTE);
        sPTE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));

        sPTE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    btnICA.setVisibility(View.VISIBLE);
                    btnPP.setVisibility(View.VISIBLE);
                    btnVO.setVisibility(View.VISIBLE);
                    btnPL.setVisibility(View.VISIBLE);

                }
                else{
                    btnICA.setVisibility(View.GONE);
                    btnPP.setVisibility(View.GONE);
                    btnVO.setVisibility(View.GONE);
                    btnPL.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion
        // region sPTI Tiene acceso a otras fuentes de info
        sPTI = (Spinner) findViewById(R.id.sPTI);
        sPTI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvF.setVisibility(View.VISIBLE);
                    txtF.setVisibility(View.VISIBLE);
                }
                else{
                    tvF.setVisibility(View.GONE);
                    txtF.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        // region sPUA  UNO DE LO DELITOS
        sPUA = (Spinner) findViewById(R.id.sPUA);
        sPUA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPUD UNO DE LOS DELITOS 2
        sPUD = (Spinner) findViewById(R.id.sPUD);
        sPUD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPMC  MEDIDAS DE INTERNAMIENTO
        sPMC = (Spinner) findViewById(R.id.sPMC);
        sPMC.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPHO  LOS ECHOS ALEGADOS
        sPHO = (Spinner) findViewById(R.id.sPHO);
        sPHO.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPSL SE IMPONIA A MEDIDA CAUTELAR sPEVO
        sPSL = (Spinner) findViewById(R.id.sPSL);
        sPSL.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion




        // region sPVV VIVE CON LA VICTIMA



        sPVV = (Spinner) findViewById(R.id.sPVV);
        sPVV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosia));

        sPVV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvCV.setVisibility(View.VISIBLE);
                    tvRR.setVisibility(View.VISIBLE);
                    tvRR_1.setVisibility(View.VISIBLE);
                    sPRR.setVisibility(View.VISIBLE);
                    tvEVS.setVisibility(View.VISIBLE);

                }
                else{
                    tvCV.setVisibility(View.GONE);
                    tvRR.setVisibility(View.GONE);
                    tvRR_1.setVisibility(View.GONE);
                    sPRR.setVisibility(View.GONE);
                    tvEVS.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //endregion
        // region sPDV DELITO VIOLENTO
        sPDV = (Spinner) findViewById(R.id.sPDV);
        sPDV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosia));
        //endregion
        // region sPEVF EL ADOLECENTE HA EXPRESADO
        sPEVF = (Spinner) findViewById(R.id.sPEVF);
        sPEVF.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosia));
        //endregion


        // region sPDI  UNO DE LO DELITOS
        sPDI = (Spinner) findViewById(R.id.sPDI);
        sPDI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, delito));
        sPDI.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Otro"){
                    tvEspe.setVisibility(View.VISIBLE);
                    txtEspe.setVisibility(View.VISIBLE);
                }
                else{
                    tvEspe.setVisibility(View.GONE);
                    txtEspe.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        // region Cuantos procesos
        sPTP = (Spinner) findViewById(R.id.sPTP);
        sPTP.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    sPTPc.setVisibility(View.VISIBLE);
                    tvTPc.setVisibility(View.VISIBLE);
                }
                else{
                    sPTPc.setVisibility(View.GONE);
                    tvTPc.setVisibility(View.GONE);
                    txtNC1.setVisibility(View.GONE);
                    txtNC2.setVisibility(View.GONE);
                    txtNC3.setVisibility(View.GONE);
                    txtNC4.setVisibility(View.GONE);
                    txtNC5.setVisibility(View.GONE);
                    txtD1.setVisibility(View.GONE);
                    txtD2.setVisibility(View.GONE);
                    txtD3.setVisibility(View.GONE);
                    txtD4.setVisibility(View.GONE);
                    txtD5.setVisibility(View.GONE);
                    txtTM1.setVisibility(View.GONE);
                    txtTM2.setVisibility(View.GONE);
                    txtTM3.setVisibility(View.GONE);
                    txtTM4.setVisibility(View.GONE);
                    txtTM5.setVisibility(View.GONE);
                    sPE1.setVisibility(View.GONE);
                    sPE2.setVisibility(View.GONE);
                    sPE3.setVisibility(View.GONE);
                    sPE4.setVisibility(View.GONE);
                    sPE5.setVisibility(View.GONE);
                    tvNC1.setVisibility(View.GONE);
                    tvNC2.setVisibility(View.GONE);
                    tvNC3.setVisibility(View.GONE);
                    tvNC4.setVisibility(View.GONE);
                    tvNC5.setVisibility(View.GONE);
                    tvD1.setVisibility(View.GONE);
                    tvD2.setVisibility(View.GONE);
                    tvD3.setVisibility(View.GONE);
                    tvD4.setVisibility(View.GONE);
                    tvD5.setVisibility(View.GONE);
                    tvTM1.setVisibility(View.GONE);
                    tvTM2.setVisibility(View.GONE);
                    tvTM3.setVisibility(View.GONE);
                    tvTM4.setVisibility(View.GONE);
                    tvTM5.setVisibility(View.GONE);
                    tvE1.setVisibility(View.GONE);
                    tvE2.setVisibility(View.GONE);
                    tvE3.setVisibility(View.GONE);
                    tvE4.setVisibility(View.GONE);
                    tvE5.setVisibility(View.GONE);
                    tvPPP1.setVisibility(View.GONE);
                    tvPPP2.setVisibility(View.GONE);
                    tvPPP3.setVisibility(View.GONE);
                    tvPPP4.setVisibility(View.GONE);
                    tvPPP5.setVisibility(View.GONE);
                    tvSL.setVisibility(View.GONE);
                    sPSL.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion
        // region sPTPc TIENE OTRO PROCESO
        sPTPc = (Spinner) findViewById(R.id.sPTPc);
        sPTPc.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, otroProceso));
        sPTPc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                switch (selectedItem) {
                    case "NA":
                        txtNC1.setVisibility(View.GONE);
                        txtNC2.setVisibility(View.GONE);
                        txtNC3.setVisibility(View.GONE);
                        txtNC4.setVisibility(View.GONE);
                        txtNC5.setVisibility(View.GONE);
                        txtD1.setVisibility(View.GONE);
                        txtD2.setVisibility(View.GONE);
                        txtD3.setVisibility(View.GONE);
                        txtD4.setVisibility(View.GONE);
                        txtD5.setVisibility(View.GONE);
                        txtTM1.setVisibility(View.GONE);
                        txtTM2.setVisibility(View.GONE);
                        txtTM3.setVisibility(View.GONE);
                        txtTM4.setVisibility(View.GONE);
                        txtTM5.setVisibility(View.GONE);
                        sPE1.setVisibility(View.GONE);
                        sPE2.setVisibility(View.GONE);
                        sPE3.setVisibility(View.GONE);
                        sPE4.setVisibility(View.GONE);
                        sPE5.setVisibility(View.GONE);
                        tvNC1.setVisibility(View.GONE);
                        tvNC2.setVisibility(View.GONE);
                        tvNC3.setVisibility(View.GONE);
                        tvNC4.setVisibility(View.GONE);
                        tvNC5.setVisibility(View.GONE);
                        tvD1.setVisibility(View.GONE);
                        tvD2.setVisibility(View.GONE);
                        tvD3.setVisibility(View.GONE);
                        tvD4.setVisibility(View.GONE);
                        tvD5.setVisibility(View.GONE);
                        tvTM1.setVisibility(View.GONE);
                        tvTM2.setVisibility(View.GONE);
                        tvTM3.setVisibility(View.GONE);
                        tvTM4.setVisibility(View.GONE);
                        tvTM5.setVisibility(View.GONE);
                        tvE1.setVisibility(View.GONE);
                        tvE2.setVisibility(View.GONE);
                        tvE3.setVisibility(View.GONE);
                        tvE4.setVisibility(View.GONE);
                        tvE5.setVisibility(View.GONE);
                        tvPPP1.setVisibility(View.GONE);
                        tvPPP2.setVisibility(View.GONE);
                        tvPPP3.setVisibility(View.GONE);
                        tvPPP4.setVisibility(View.GONE);
                        tvPPP5.setVisibility(View.GONE);
                        tvSL.setVisibility(View.GONE);
                        sPSL.setVisibility(View.GONE);
                        break;
                    case "1":
                        txtNC1.setVisibility(View.VISIBLE);
                        txtNC2.setVisibility(View.GONE);
                        txtNC3.setVisibility(View.GONE);
                        txtNC4.setVisibility(View.GONE);
                        txtNC5.setVisibility(View.GONE);
                        txtD1.setVisibility(View.VISIBLE);
                        txtD2.setVisibility(View.GONE);
                        txtD3.setVisibility(View.GONE);
                        txtD4.setVisibility(View.GONE);
                        txtD5.setVisibility(View.GONE);
                        txtTM1.setVisibility(View.VISIBLE);
                        txtTM2.setVisibility(View.GONE);
                        txtTM3.setVisibility(View.GONE);
                        txtTM4.setVisibility(View.GONE);
                        txtTM5.setVisibility(View.GONE);
                        sPE1.setVisibility(View.VISIBLE);
                        sPE2.setVisibility(View.GONE);
                        sPE3.setVisibility(View.GONE);
                        sPE4.setVisibility(View.GONE);
                        sPE5.setVisibility(View.GONE);
                        tvNC1.setVisibility(View.VISIBLE);
                        tvNC2.setVisibility(View.GONE);
                        tvNC3.setVisibility(View.GONE);
                        tvNC4.setVisibility(View.GONE);
                        tvNC5.setVisibility(View.GONE);
                        tvD1.setVisibility(View.VISIBLE);
                        tvD2.setVisibility(View.GONE);
                        tvD3.setVisibility(View.GONE);
                        tvD4.setVisibility(View.GONE);
                        tvD5.setVisibility(View.GONE);
                        tvTM1.setVisibility(View.VISIBLE);
                        tvTM2.setVisibility(View.GONE);
                        tvTM3.setVisibility(View.GONE);
                        tvTM4.setVisibility(View.GONE);
                        tvTM5.setVisibility(View.GONE);
                        tvE1.setVisibility(View.VISIBLE);
                        tvE2.setVisibility(View.GONE);
                        tvE3.setVisibility(View.GONE);
                        tvE4.setVisibility(View.GONE);
                        tvE5.setVisibility(View.GONE);
                        tvPPP1.setVisibility(View.VISIBLE);
                        tvPPP2.setVisibility(View.GONE);
                        tvPPP3.setVisibility(View.GONE);
                        tvPPP4.setVisibility(View.GONE);
                        tvPPP5.setVisibility(View.GONE);
                        tvSL.setVisibility(View.VISIBLE);
                        sPSL.setVisibility(View.VISIBLE);
                        break;
                    case "2":
                        txtNC1.setVisibility(View.VISIBLE);
                        txtNC2.setVisibility(View.VISIBLE);
                        txtNC3.setVisibility(View.GONE);
                        txtNC4.setVisibility(View.GONE);
                        txtNC5.setVisibility(View.GONE);
                        txtD1.setVisibility(View.VISIBLE);
                        txtD2.setVisibility(View.VISIBLE);
                        txtD3.setVisibility(View.GONE);
                        txtD4.setVisibility(View.GONE);
                        txtD5.setVisibility(View.GONE);
                        txtTM1.setVisibility(View.VISIBLE);
                        txtTM2.setVisibility(View.VISIBLE);
                        txtTM3.setVisibility(View.GONE);
                        txtTM4.setVisibility(View.GONE);
                        txtTM5.setVisibility(View.GONE);
                        sPE1.setVisibility(View.VISIBLE);
                        sPE2.setVisibility(View.VISIBLE);
                        sPE3.setVisibility(View.GONE);
                        sPE4.setVisibility(View.GONE);
                        sPE5.setVisibility(View.GONE);
                        tvNC1.setVisibility(View.VISIBLE);
                        tvNC2.setVisibility(View.VISIBLE);
                        tvNC3.setVisibility(View.GONE);
                        tvNC4.setVisibility(View.GONE);
                        tvNC5.setVisibility(View.GONE);
                        tvD1.setVisibility(View.VISIBLE);
                        tvD2.setVisibility(View.VISIBLE);
                        tvD3.setVisibility(View.GONE);
                        tvD4.setVisibility(View.GONE);
                        tvD5.setVisibility(View.GONE);
                        tvTM1.setVisibility(View.VISIBLE);
                        tvTM2.setVisibility(View.VISIBLE);
                        tvTM3.setVisibility(View.GONE);
                        tvTM4.setVisibility(View.GONE);
                        tvTM5.setVisibility(View.GONE);
                        tvE1.setVisibility(View.VISIBLE);
                        tvE2.setVisibility(View.VISIBLE);
                        tvE3.setVisibility(View.GONE);
                        tvE4.setVisibility(View.GONE);
                        tvE5.setVisibility(View.GONE);
                        tvPPP1.setVisibility(View.VISIBLE);
                        tvPPP2.setVisibility(View.VISIBLE);
                        tvPPP3.setVisibility(View.GONE);
                        tvPPP4.setVisibility(View.GONE);
                        tvPPP5.setVisibility(View.GONE);
                        tvSL.setVisibility(View.VISIBLE);
                        sPSL.setVisibility(View.VISIBLE);
                        break;
                    case "3":
                        txtNC1.setVisibility(View.VISIBLE);
                        txtNC2.setVisibility(View.VISIBLE);
                        txtNC3.setVisibility(View.VISIBLE);
                        txtNC4.setVisibility(View.GONE);
                        txtNC5.setVisibility(View.GONE);
                        txtD1.setVisibility(View.VISIBLE);
                        txtD2.setVisibility(View.VISIBLE);
                        txtD3.setVisibility(View.VISIBLE);
                        txtD4.setVisibility(View.GONE);
                        txtD5.setVisibility(View.GONE);
                        txtTM1.setVisibility(View.VISIBLE);
                        txtTM2.setVisibility(View.VISIBLE);
                        txtTM3.setVisibility(View.VISIBLE);
                        txtTM4.setVisibility(View.GONE);
                        txtTM5.setVisibility(View.GONE);
                        sPE1.setVisibility(View.VISIBLE);
                        sPE2.setVisibility(View.VISIBLE);
                        sPE3.setVisibility(View.VISIBLE);
                        sPE4.setVisibility(View.GONE);
                        sPE5.setVisibility(View.GONE);
                        tvNC1.setVisibility(View.VISIBLE);
                        tvNC2.setVisibility(View.VISIBLE);
                        tvNC3.setVisibility(View.VISIBLE);
                        tvNC4.setVisibility(View.GONE);
                        tvNC5.setVisibility(View.GONE);
                        tvD1.setVisibility(View.VISIBLE);
                        tvD2.setVisibility(View.VISIBLE);
                        tvD3.setVisibility(View.VISIBLE);
                        tvD4.setVisibility(View.GONE);
                        tvD5.setVisibility(View.GONE);
                        tvTM1.setVisibility(View.VISIBLE);
                        tvTM2.setVisibility(View.VISIBLE);
                        tvTM3.setVisibility(View.VISIBLE);
                        tvTM4.setVisibility(View.GONE);
                        tvTM5.setVisibility(View.GONE);
                        tvE1.setVisibility(View.VISIBLE);
                        tvE2.setVisibility(View.VISIBLE);
                        tvE3.setVisibility(View.VISIBLE);
                        tvE4.setVisibility(View.GONE);
                        tvE5.setVisibility(View.GONE);
                        tvPPP1.setVisibility(View.VISIBLE);
                        tvPPP2.setVisibility(View.VISIBLE);
                        tvPPP3.setVisibility(View.VISIBLE);
                        tvPPP4.setVisibility(View.GONE);
                        tvPPP5.setVisibility(View.GONE);
                        tvSL.setVisibility(View.VISIBLE);
                        sPSL.setVisibility(View.VISIBLE);
                        break;
                    case "4":
                        txtNC1.setVisibility(View.VISIBLE);
                        txtNC2.setVisibility(View.VISIBLE);
                        txtNC3.setVisibility(View.VISIBLE);
                        txtNC4.setVisibility(View.VISIBLE);
                        txtNC5.setVisibility(View.GONE);
                        txtD1.setVisibility(View.VISIBLE);
                        txtD2.setVisibility(View.VISIBLE);
                        txtD3.setVisibility(View.VISIBLE);
                        txtD4.setVisibility(View.VISIBLE);
                        txtD5.setVisibility(View.GONE);
                        txtTM1.setVisibility(View.VISIBLE);
                        txtTM2.setVisibility(View.VISIBLE);
                        txtTM3.setVisibility(View.VISIBLE);
                        txtTM4.setVisibility(View.VISIBLE);
                        txtTM5.setVisibility(View.GONE);
                        sPE1.setVisibility(View.VISIBLE);
                        sPE2.setVisibility(View.VISIBLE);
                        sPE3.setVisibility(View.VISIBLE);
                        sPE4.setVisibility(View.VISIBLE);
                        sPE5.setVisibility(View.GONE);
                        tvNC1.setVisibility(View.VISIBLE);
                        tvNC2.setVisibility(View.VISIBLE);
                        tvNC3.setVisibility(View.VISIBLE);
                        tvNC4.setVisibility(View.VISIBLE);
                        tvNC5.setVisibility(View.GONE);
                        tvD1.setVisibility(View.VISIBLE);
                        tvD2.setVisibility(View.VISIBLE);
                        tvD3.setVisibility(View.VISIBLE);
                        tvD4.setVisibility(View.VISIBLE);
                        tvD5.setVisibility(View.GONE);
                        tvTM1.setVisibility(View.VISIBLE);
                        tvTM2.setVisibility(View.VISIBLE);
                        tvTM3.setVisibility(View.VISIBLE);
                        tvTM4.setVisibility(View.VISIBLE);
                        tvTM5.setVisibility(View.GONE);
                        tvE1.setVisibility(View.VISIBLE);
                        tvE2.setVisibility(View.VISIBLE);
                        tvE3.setVisibility(View.VISIBLE);
                        tvE4.setVisibility(View.VISIBLE);
                        tvE5.setVisibility(View.GONE);
                        tvPPP1.setVisibility(View.VISIBLE);
                        tvPPP2.setVisibility(View.VISIBLE);
                        tvPPP3.setVisibility(View.VISIBLE);
                        tvPPP4.setVisibility(View.VISIBLE);
                        tvPPP5.setVisibility(View.GONE);
                        tvSL.setVisibility(View.VISIBLE);
                        sPSL.setVisibility(View.VISIBLE);
                        break;
                    case "5":
                        txtNC1.setVisibility(View.VISIBLE);
                        txtNC2.setVisibility(View.VISIBLE);
                        txtNC3.setVisibility(View.VISIBLE);
                        txtNC4.setVisibility(View.VISIBLE);
                        txtNC5.setVisibility(View.VISIBLE);
                        txtD1.setVisibility(View.VISIBLE);
                        txtD2.setVisibility(View.VISIBLE);
                        txtD3.setVisibility(View.VISIBLE);
                        txtD4.setVisibility(View.VISIBLE);
                        txtD5.setVisibility(View.VISIBLE);
                        txtTM1.setVisibility(View.VISIBLE);
                        txtTM2.setVisibility(View.VISIBLE);
                        txtTM3.setVisibility(View.VISIBLE);
                        txtTM4.setVisibility(View.VISIBLE);
                        txtTM5.setVisibility(View.VISIBLE);
                        sPE1.setVisibility(View.VISIBLE);
                        sPE2.setVisibility(View.VISIBLE);
                        sPE3.setVisibility(View.VISIBLE);
                        sPE4.setVisibility(View.VISIBLE);
                        sPE5.setVisibility(View.VISIBLE);
                        tvNC1.setVisibility(View.VISIBLE);
                        tvNC2.setVisibility(View.VISIBLE);
                        tvNC3.setVisibility(View.VISIBLE);
                        tvNC4.setVisibility(View.VISIBLE);
                        tvNC5.setVisibility(View.VISIBLE);
                        tvD1.setVisibility(View.VISIBLE);
                        tvD2.setVisibility(View.VISIBLE);
                        tvD3.setVisibility(View.VISIBLE);
                        tvD4.setVisibility(View.VISIBLE);
                        tvD5.setVisibility(View.VISIBLE);
                        tvTM1.setVisibility(View.VISIBLE);
                        tvTM2.setVisibility(View.VISIBLE);
                        tvTM3.setVisibility(View.VISIBLE);
                        tvTM4.setVisibility(View.VISIBLE);
                        tvTM5.setVisibility(View.VISIBLE);
                        tvE1.setVisibility(View.VISIBLE);
                        tvE2.setVisibility(View.VISIBLE);
                        tvE3.setVisibility(View.VISIBLE);
                        tvE4.setVisibility(View.VISIBLE);
                        tvE5.setVisibility(View.VISIBLE);
                        tvPPP1.setVisibility(View.VISIBLE);
                        tvPPP2.setVisibility(View.VISIBLE);
                        tvPPP3.setVisibility(View.VISIBLE);
                        tvPPP4.setVisibility(View.VISIBLE);
                        tvPPP5.setVisibility(View.VISIBLE);
                        tvSL.setVisibility(View.VISIBLE);
                        sPSL.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        // region sPEVO EXIXTE VICTIMA
        sPVO = (Spinner) findViewById(R.id.sPVO);
        sPVO.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPVO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvVD.setVisibility(View.VISIBLE);
                    sPVD.setVisibility(View.VISIBLE);
                    tvVV.setVisibility(View.VISIBLE);
                    sPVV.setVisibility(View.VISIBLE);
                    tvCV.setVisibility(View.VISIBLE);
                    tvRR.setVisibility(View.VISIBLE);
                    tvRR_1.setVisibility(View.VISIBLE);
                    sPRR.setVisibility(View.VISIBLE);
                    tvEVS.setVisibility(View.VISIBLE);

                }
                else{
                    tvVD.setVisibility(View.GONE);
                    sPVD.setVisibility(View.GONE);
                    tvVV.setVisibility(View.GONE);
                    sPVV.setVisibility(View.GONE);
                    tvCV.setVisibility(View.GONE);
                    tvRR.setVisibility(View.GONE);
                    tvRR_1.setVisibility(View.GONE);
                    sPRR.setVisibility(View.GONE);
                    tvEVS.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        // region sPVD VIVE EN EL MISMO DOMICILIO
        sPVD = (Spinner) findViewById(R.id.sPVD);
        sPVD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosia));
        sPVD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvCV.setVisibility(View.VISIBLE);
                    tvRR.setVisibility(View.VISIBLE);
                    tvRR_1.setVisibility(View.VISIBLE);
                    sPRR.setVisibility(View.VISIBLE);
                    tvEVS.setVisibility(View.VISIBLE);
                    tvVV.setVisibility(View.GONE);
                    sPVV.setVisibility(View.GONE);

                }
                else{
                    tvVV.setVisibility(View.VISIBLE);
                    sPVV.setVisibility(View.VISIBLE);
                    tvCV.setVisibility(View.GONE);
                    tvRR.setVisibility(View.GONE);
                    tvRR_1.setVisibility(View.GONE);
                    sPRR.setVisibility(View.GONE);
                    tvEVS.setVisibility(View.GONE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion


        // region sCV REUBICA DOMICILIO
        sPRR = (Spinner) findViewById(R.id.sPRR);
        sPRR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosia));
        //endregion

        // region PRESENTA UN POSIBLE RIESGO
        sPSE = (Spinner) findViewById(R.id.sPSE);
        sPSE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPSE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtEx1.setVisibility(View.VISIBLE);
                    tvEx1.setVisibility(view.VISIBLE);

                }
                else{
                    txtEx1.setVisibility(View.GONE);
                    tvEx1.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion


        // region SA
        sPSA = (Spinner) findViewById(R.id.sPSA);
        sPSA.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPSA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    txtEx2.setVisibility(View.VISIBLE);
                    tvEx2.setVisibility(view.VISIBLE);

                }
                else{
                    txtEx2.setVisibility(View.GONE);
                    tvEx2.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        txtFp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDatePickerDialog(txtFp);
            }

        });


        btnGuardarIA=(Button) findViewById(R.id.btnGuardarIA);
        btnGuardarIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnGuardarIA.setEnabled(false);

                r1=txtFp.getText().toString().toUpperCase();
                r2=txtF.getText().toString().toUpperCase();
                r3=sPDI.getSelectedItem().toString().toUpperCase();

                r4=txtNC1.getText().toString().toUpperCase();
                r5=txtNC2.getText().toString().toUpperCase();
                r6=txtNC3.getText().toString().toUpperCase();
                r7=txtNC4.getText().toString().toUpperCase();
                r8=txtNC5.getText().toString().toUpperCase();

                r9=txtD1.getText().toString().toUpperCase();
                r10=txtD2.getText().toString().toUpperCase();
                r11=txtD3.getText().toString().toUpperCase();
                r12=txtD4.getText().toString().toUpperCase();
                r13=txtD5.getText().toString().toUpperCase();

                r14=txtTM1.getText().toString().toUpperCase();
                r15=txtTM2.getText().toString().toUpperCase();
                r16=txtTM3.getText().toString().toUpperCase();
                r17=txtTM4.getText().toString().toUpperCase();
                r18=txtTM5.getText().toString().toUpperCase();

                r19=sPE1.getSelectedItem().toString().toUpperCase();
                r20=sPE2.getSelectedItem().toString().toUpperCase();
                r21=sPE3.getSelectedItem().toString().toUpperCase();
                r22=sPE4.getSelectedItem().toString().toUpperCase();
                r23=sPE5.getSelectedItem().toString().toUpperCase();

                r24=txtEx1.getText().toString().toUpperCase();
                r25=txtEx2.getText().toString().toUpperCase();
                //////////////////SPINNER
                rS1=sPTE.getSelectedItem().toString().toUpperCase();
                rS2=sPTI.getSelectedItem().toString().toUpperCase();
                rS3=sPDI.getSelectedItem().toString().toUpperCase();
                r3_1=txtEspe.getText().toString().toUpperCase();
                rS4=sPUA.getSelectedItem().toString().toUpperCase();
                rS5=sPUD.getSelectedItem().toString().toUpperCase();
                rS6=sPMC.getSelectedItem().toString().toUpperCase();
                rS7=sPHO.getSelectedItem().toString().toUpperCase();

                rS8=sPTP.getSelectedItem().toString().toUpperCase();
                rS8_1=sPTPc.getSelectedItem().toString().toUpperCase();
                rS9=sPSL.getSelectedItem().toString().toUpperCase();
                rS10=sPVO.getSelectedItem().toString().toUpperCase();
                rS11=sPVD.getSelectedItem().toString().toUpperCase();
                rS12=sPVV.getSelectedItem().toString().toUpperCase();
                //  rS13=sPEVS.getSelectedItem().toString().toUpperCase();
                rS14=sPDV.getSelectedItem().toString().toUpperCase();
                rS15=sPEVF.getSelectedItem().toString().toUpperCase();
                rS16=sPSE.getSelectedItem().toString().toUpperCase();
                rS17=sPSA.getSelectedItem().toString().toUpperCase();
                rS18=sPRR.getSelectedItem().toString().toUpperCase();

                int pos = sPICA.getSelectedItemPosition();
                folio = lista1.get(Idx.get(pos)).getAfolio();
                carpeta=txtCCD.getText().toString();

                db.insertarDatosInformacionCasoA(carpeta,rS1,r1,rS2,r2,rS3,r3_1,rS4,rS5,rS6,rS7,folio);
                db.insertarDatosProcesosPenalesA(rS8,rS8_1,rS9,r4,r9,r14,r19,r5,r10,r15,r20,r6,r11,r16,r21,r7,r12,r17,r22,r8,r13,r18,r23,folio);
                db.insertarDatosVictimaOfendidoA(rS10,rS11,rS12,rS18,rS14,rS15,folio);
                db.insertarDatosProcesoLegalA(rS16,r24,rS17,r25,folio);
                db.updateTableA("datos_generales_a", "Acarpetainvestigacion", "SI", folio);
                Toast.makeText(getApplicationContext(), "Datos Guardados correctamete", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), MainMenu.class);
                startActivity(intent);




            }
        });
        btnICA=(Button) findViewById(R.id.btnICA);
        llICA=(LinearLayout) findViewById(R.id.llICA);
        btnPP=(Button) findViewById(R.id.btnPP);
        llPP=(LinearLayout) findViewById(R.id.llPP);
        btnVO=(Button) findViewById(R.id.btnVO);
        llVO=(LinearLayout) findViewById(R.id.llVO);
        btnPL=(Button) findViewById(R.id.btnPL);
        llPL=(LinearLayout) findViewById(R.id.llPL);




        btnICA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ICA){
                    llICA.setVisibility(View.VISIBLE);
                    ICA=true;
                }
                else{
                    llICA.setVisibility(View.GONE);
                    ICA=false;
                }
            }
        });
        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!PP){
                    llPP.setVisibility(View.VISIBLE);
                    PP=true;
                }
                else{
                    llPP.setVisibility(View.GONE);
                    PP=false;
                }
            }
        });

        btnVO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!VO){
                    llVO.setVisibility(View.VISIBLE);
                    VO=true;
                }
                else{
                    llVO.setVisibility(View.GONE);
                    VO=false;
                }
            }
        });

        btnPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!PL){
                    llPL.setVisibility(View.VISIBLE);
                    PL=true;
                }
                else{
                    llPL.setVisibility(View.GONE);
                    PL=false;
                }
            }
        });

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
    //endregion
    private long backPressedTime = 0;
    @Override
    public void onBackPressed(){        // to prevent irritating accidental logouts
        long t = System.currentTimeMillis();
        if (t - backPressedTime > 2000) {    // 2 secs
            backPressedTime = t;
            Toast.makeText(this, "Presiona nuevamente para salir al menu principal",
                    Toast.LENGTH_SHORT).show();
        } else {    // this guy is serious
            // clean up
            super.onBackPressed();       // bye
        }
    }
}

