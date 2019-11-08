package com.sistemas.evaluacion;

import android.content.Intent;
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
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosGeneralesA;

import java.util.ArrayList;

public class infoCasoAdolescente extends AppCompatActivity {

    //regio boolean
    private boolean pR=false;

    //INFORMACION DE CASO ACTUAL
    private TextView tvFp,tvF,tvEVS,tvVD,tvVV,tvCV,tvRR,tvEx1,tvEx2,tvNC1,tvNC2,tvNC3,tvNC4,tvNC5,tvD1,tvD2,tvD3,tvD4,tvD5,tvTM1,tvTM2,tvTM3,tvTM4,tvTM5,tvE1,tvE2,tvE3,tvE4,tvE5,tvSL,tvPPP1,tvPPP2,tvPPP3,tvPPP4,tvPPP5;
    //endregion

    //Infotmacion el caso actual
    private EditText txtCCD,txtFp,txtF,txtDi,txtNC1,txtNC2,txtNC3,txtNC4,txtNC5,txtD1,txtD2,txtD3,txtD4,txtD5,txtTM1,txtTM2,txtTM3,txtTM4,txtTM5,txtE1,txtE2,txtE3,txtE4,txtE5,txtEx1,txtEx2;
    //endregion EditText
    //region SPINNERS
    private Spinner sPICA,sPTE,sPTI,sPDI,sPUA,sPUD,sPMC,sPHO,sPTP,sPSL,sPVO,sPVD,sPVV,sPRR,sPEVS,sPDV,sPEVF,sPSE,sPSA;
    //endregion
    //region BOTTONES
    private Button btnGuardarIA,btnICA,btnPP,btnVO,btnPL;
    //endregion
    String folio, carpeta;
    //region Strings
    private String r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16,r17,r18,r19,r20,r21,r22,r23,r24,r25;
    /////SPINNERS
    private String rS1,rS2,rS3,rS4,rS5,rS6,rS7,rS8,rS9,rS10,rS11,rS12,rS13,rS14,rS15,rS16,rS17,rS18;
    //endregion
    //region String
    private String [] nosi={"No", "Si"};
    private String [] delito={"Otro", "Robo", "Robo Simple", "Violación", "Violencia Familiar", "Daños y Lesiones",
            "Lesiones menores a 15 dias", "Contra la Salud", "Comercio o Suministro", "Portación de Armas de Fuego"};

    private String[] estatus={"Vigente", "Suspendido", "Revocado", "Cumplido"};

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


        //region TREAER DATOS DE ENTREVISTRADOS
        txtCCD=(EditText) findViewById(R.id.txtCCD);
        btnGuardarIA=(Button) findViewById(R.id.btnGuardarIA);
        sPICA = (Spinner) findViewById(R.id.sPICA);
        //endregion

        tvControlA=(TextView) findViewById(R.id.tvControlA);
        llControlA=(LinearLayout) findViewById(R.id.llControlA);

        //region Inicio BD
        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        lista1 = db.getdatosGeneralesA();

        ArrayList<String> names = new ArrayList<String>();

        for(int i = 0; i < lista1.size(); i++){
            if(lista1.get(i).getAcarpetainvestigacion().equals("SI") == false) {
                names.add(lista1.get(i).getAnombre());
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
        //endregion*





        //region INFORMACION DE CASO ACTUAL
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

        txtE1=(EditText) findViewById(R.id.txtE1);
        txtE2=(EditText) findViewById(R.id.txtE2);
        txtE3=(EditText) findViewById(R.id.txtE3);
        txtE4=(EditText) findViewById(R.id.txtE4);
        txtE5=(EditText) findViewById(R.id.txtE5);



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
        txtEx1=(EditText) findViewById(R.id.txtEx1);
        txtEx2=(EditText) findViewById(R.id.txtEx2);
        tvEx1=(TextView) findViewById(R.id.tvEx1);
        tvEx2=(TextView) findViewById(R.id.tvEx2);
        //endregion

        // region sPUA  UNO DE LO DELITOS
        sPTE = (Spinner) findViewById(R.id.sPTE);
        sPTE.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPUA  UNO DE LO DELITOS
        sPTI = (Spinner) findViewById(R.id.sPTI);
        sPTI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion

        // region sPDI  UNO DE LO DELITOS
        sPDI = (Spinner) findViewById(R.id.sPDI);
        sPDI.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, delito));
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
        sPVV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPEVS ELIMINA LA CERCANIA
        sPEVS = (Spinner) findViewById(R.id.sPEVS);
        sPEVS.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPDV DELITO VIOLENTO
        sPDV = (Spinner) findViewById(R.id.sPDV);
        sPDV.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion
        // region sPEVF EL ADOLECENTE HA EXPRESADO
        sPEVF = (Spinner) findViewById(R.id.sPEVF);
        sPEVF.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        //endregion



        // region sPTP TIENE OTRO PROCESO
        sPTP = (Spinner) findViewById(R.id.sPTP);
        sPTP.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPTP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
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
                    txtE1.setVisibility(View.VISIBLE);
                    txtE2.setVisibility(View.VISIBLE);
                    txtE3.setVisibility(View.VISIBLE);
                    txtE4.setVisibility(View.VISIBLE);
                    txtE5.setVisibility(View.VISIBLE);
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
                }
                else{
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
                    txtE1.setVisibility(View.GONE);
                    txtE2.setVisibility(View.GONE);
                    txtE3.setVisibility(View.GONE);
                    txtE4.setVisibility(View.GONE);
                    txtE5.setVisibility(View.GONE);
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

                }
                else{
                    tvVD.setVisibility(View.GONE);
                    sPVD.setVisibility(View.GONE);
                    tvVV.setVisibility(View.GONE);
                    sPVV.setVisibility(View.GONE);
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
        sPVD.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPVD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvCV.setVisibility(View.VISIBLE);
                    tvRR.setVisibility(View.VISIBLE);
                    sPRR.setVisibility(View.VISIBLE);

                }
                else{
                    tvCV.setVisibility(View.GONE);
                    tvRR.setVisibility(View.GONE);
                    sPRR.setVisibility(View.GONE);
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
        sPRR.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nosi));
        sPRR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=parent.getSelectedItem().toString();
                if (selectedItem=="Si"){
                    tvEVS.setVisibility(View.VISIBLE);
                    sPEVS.setVisibility(view.VISIBLE);

                }
                else{
                    tvEVS.setVisibility(View.GONE);
                    sPEVS.setVisibility(view.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
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

                r19=txtE1.getText().toString().toUpperCase();
                r20=txtE2.getText().toString().toUpperCase();
                r21=txtE3.getText().toString().toUpperCase();
                r22=txtE4.getText().toString().toUpperCase();
                r23=txtE5.getText().toString().toUpperCase();

                r24=txtEx1.getText().toString().toUpperCase();
                r25=txtEx1.getText().toString().toUpperCase();
                //////////////////SPINNER
                rS1=sPTE.getSelectedItem().toString().toUpperCase();
                rS2=sPTI.getSelectedItem().toString().toUpperCase();
                rS3=sPDI.getSelectedItem().toString().toUpperCase();
                rS4=sPUA.getSelectedItem().toString().toUpperCase();
                rS5=sPUD.getSelectedItem().toString().toUpperCase();
                rS6=sPMC.getSelectedItem().toString().toUpperCase();
                rS7=sPHO.getSelectedItem().toString().toUpperCase();

                rS8=sPTP.getSelectedItem().toString().toUpperCase();
                rS9=sPSL.getSelectedItem().toString().toUpperCase();
                rS10=sPVO.getSelectedItem().toString().toUpperCase();
                rS11=sPVD.getSelectedItem().toString().toUpperCase();
                rS12=sPVV.getSelectedItem().toString().toUpperCase();
                rS13=sPEVS.getSelectedItem().toString().toUpperCase();
                rS14=sPDV.getSelectedItem().toString().toUpperCase();
                rS15=sPEVF.getSelectedItem().toString().toUpperCase();
                rS16=sPSE.getSelectedItem().toString().toUpperCase();
                rS17=sPSA.getSelectedItem().toString().toUpperCase();
                rS18=sPRR.getSelectedItem().toString().toUpperCase();

                int pos = sPICA.getSelectedItemPosition();
                folio = lista1.get(Idx.get(pos)).getAfolio();
                carpeta=txtCCD.getText().toString();

                db.insertarDatosInformacionCasoA(carpeta,rS1,r1,rS2,r2,rS3,rS4,rS5,rS6,rS7,folio);
                db.insertarDatosProcesosPenalesA(rS8,rS9,r4,r9,r14,r19,r5,r10,r15,r20,r6,r11,r16,r21,r7,r12,r17,r22,r8,r13,r18,r23,folio);
                db.insertarDatosVictimaOfendidoA(rS10,rS11,rS12,rS13,rS18,rS14,rS15,folio);
                db.insertarDatosProcesoLegalA(rS16,r22,rS17,r23,folio);
                db.updateTable("datos_generales_a", "Acarpetainvestigacion", "SI", folio);
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
                if(!pR){
                    llICA.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llICA.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });
        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llPP.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llPP.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

        btnVO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llVO.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llVO.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

        btnPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pR){
                    llPL.setVisibility(View.VISIBLE);
                    pR=true;
                }
                else{
                    llPL.setVisibility(View.GONE);
                    pR=false;
                }
            }
        });

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

