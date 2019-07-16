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

import com.sistemas.evaluacion.entidades.datosGenerales;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class Assist extends AppCompatActivity implements View.OnClickListener{

    //region Variables Globales

    String[] lista1 = {"Nunca", "Una o dos veces", "Mensualmente", "Semanalmente","Diariamente o casi diariamente"};
    String[] lista2={"No, nunca","Si, en los ultimos 3 meses","Si, pero no en los últimos 3 meses"};
    String[] nosi={"NO", "SI"};
    EditText etP1j;
    String otro;
    MyOpenHelper db;
    int[] arrayControl={0,0,0,0,0,0,0,0,0,0};
    int[][] P = {{0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 2, 3, 4, 6},
            {0, 3, 4, 5, 6},
            {0, 4, 5, 6, 7},
            {0, 5, 6, 7, 8},
            {0, 6, 3, 0, 0},
            {0, 6, 3, 0, 0}};

    TextView tvP2a, tvP2b, tvP2c, tvP2d, tvP2e, tvP2f, tvP2g, tvP2h, tvP2i, tvP2j,
            tvP3a, tvP3b, tvP3c, tvP3d, tvP3e, tvP3f, tvP3g, tvP3h, tvP3i, tvP3j,
            tvP4a, tvP4b, tvP4c, tvP4d, tvP4e, tvP4f, tvP4g, tvP4h, tvP4i, tvP4j,
            tvP5a, tvP5b, tvP5c, tvP5d, tvP5e, tvP5f, tvP5g, tvP5h, tvP5i, tvP5j,
            tvP6a, tvP6b, tvP6c, tvP6d, tvP6e, tvP6f, tvP6g, tvP6h, tvP6i, tvP6j,
            tvP7a, tvP7b, tvP7c, tvP7d, tvP7e, tvP7f, tvP7g, tvP7h, tvP7i, tvP7j;

    Button btnP1, btnP2, btnP3, btnP4, btnP5, btnP6, btnP7, btnP8, btnGuardarASSIST;

    LinearLayout ll, llP1, llP2, llP3, llP4, llP5, llP6, llP7, llP8;

    boolean p1=false, p2=false, p3=false, p4=false, p5=false, p6=false, p7=false, p8=false,
            a=false, b=false, c=false, d=false, e=false, f=false, g=false, h=false, i=false, j=false;

    MaterialBetterSpinner sP1a, sP1b, sP1c, sP1d, sP1e, sP1f, sP1g, sP1h, sP1i, sP1j,
                        sP2a, sP2b, sP2c, sP2d, sP2e, sP2f, sP2g, sP2h, sP2i, sP2j,
                        sP3a, sP3b, sP3c, sP3d, sP3e, sP3f, sP3g, sP3h, sP3i, sP3j,
                        sP4a, sP4b, sP4c, sP4d, sP4e, sP4f, sP4g, sP4h, sP4i, sP4j,
                        sP5a, sP5b, sP5c, sP5d, sP5e, sP5f, sP5g, sP5h, sP5i, sP5j,
                        sP6a, sP6b, sP6c, sP6d, sP6e, sP6f, sP6g, sP6h, sP6i, sP6j,
                        sP7a, sP7b, sP7c, sP7d, sP7e, sP7f, sP7g, sP7h, sP7i, sP7j,
                        sP8;

    Spinner sName;

    ArrayAdapter<String> array1, array2, array3;

    //endregion

    //region Metodos

    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist);

        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        ArrayList<datosGenerales> lista;
        lista = db.getDatosGenerales();

        ArrayList<String> names = new ArrayList<String>();
        final ArrayList<Integer> Idx = new ArrayList<Integer>();//Indice de la lista completa de imputados
        //Delitos para el assist "Robo Simple", "Violencia Familiar", "Lesiones menores a 15 dias"
        for(int i = 0; i < lista.size(); i++){
            if((lista.get(i).getDelito().equals("ROBO SIMPLE") ||
                    lista.get(i).getDelito().equals("VIOLENCIA FAMILIAR") ||
                    lista.get(i).getDelito().equals("LESIONES MENORES A 15 DIAS")) &&
                    lista.get(i).getAntecedentePenal().equals("NO") == false &&
                    lista.get(i).getASSIST().equals("SI") == false) {
                names.add(lista.get(i).getNombre());
                Idx.add(i);
            }
        }

        sName = (Spinner) findViewById(R.id.sName);
        sName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        if(lista.isEmpty() == false) {
            sName.setSelection(names.size() - 1);
        }

        array1= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lista1);
        array2= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lista2);
        array3= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, nosi);

        etP1j=(EditText) findViewById(R.id.etP1j); //Edit Text para otro tipo de adicción

        ll = (LinearLayout) findViewById(R.id.ll);

        //region Lista 1
        btnP1=(Button) findViewById(R.id.btnP1);
        llP1=(LinearLayout) findViewById(R.id.llP1);
        btnP1.setOnClickListener(this);
        sP1a=(MaterialBetterSpinner) findViewById(R.id.sp1a);
        sP1b=(MaterialBetterSpinner) findViewById(R.id.sp1b);
        sP1c=(MaterialBetterSpinner) findViewById(R.id.sp1c);
        sP1d=(MaterialBetterSpinner) findViewById(R.id.sp1d);
        sP1e=(MaterialBetterSpinner) findViewById(R.id.sp1e);
        sP1f=(MaterialBetterSpinner) findViewById(R.id.sp1f);
        sP1g=(MaterialBetterSpinner) findViewById(R.id.sp1g);
        sP1h=(MaterialBetterSpinner) findViewById(R.id.sp1h);
        sP1i=(MaterialBetterSpinner) findViewById(R.id.sp1i);
        sP1j=(MaterialBetterSpinner) findViewById(R.id.sp1j);
        sP1a.setAdapter(array3);
        sP1b.setAdapter(array3);
        sP1c.setAdapter(array3);
        sP1d.setAdapter(array3);
        sP1e.setAdapter(array3);
        sP1f.setAdapter(array3);
        sP1g.setAdapter(array3);
        sP1h.setAdapter(array3);
        sP1i.setAdapter(array3);
        sP1j.setAdapter(array3);
        //endregion

        //region Lista 2
        btnP2=(Button) findViewById(R.id.btnP2);
        llP2=(LinearLayout) findViewById(R.id.llP2);
        btnP2.setOnClickListener(this);
        tvP2a=(TextView) findViewById(R.id.tvP2a);
        tvP2b=(TextView) findViewById(R.id.tvP2b);
        tvP2c=(TextView) findViewById(R.id.tvP2c);
        tvP2d=(TextView) findViewById(R.id.tvP2d);
        tvP2e=(TextView) findViewById(R.id.tvP2e);
        tvP2f=(TextView) findViewById(R.id.tvP2f);
        tvP2g=(TextView) findViewById(R.id.tvP2g);
        tvP2h=(TextView) findViewById(R.id.tvP2h);
        tvP2i=(TextView) findViewById(R.id.tvP2i);
        tvP2j=(TextView) findViewById(R.id.tvP2j);

        sP2a=(MaterialBetterSpinner) findViewById(R.id.sp2a);
        sP2b=(MaterialBetterSpinner) findViewById(R.id.sp2b);
        sP2c=(MaterialBetterSpinner) findViewById(R.id.sP2c);
        sP2d=(MaterialBetterSpinner) findViewById(R.id.sP2d);
        sP2e=(MaterialBetterSpinner) findViewById(R.id.sP2e);
        sP2f=(MaterialBetterSpinner) findViewById(R.id.sP2f);
        sP2g=(MaterialBetterSpinner) findViewById(R.id.sP2g);
        sP2h=(MaterialBetterSpinner) findViewById(R.id.sP2h);
        sP2i=(MaterialBetterSpinner) findViewById(R.id.sP2i);
        sP2j=(MaterialBetterSpinner) findViewById(R.id.sP2j);
        sP2a.setAdapter(array1);
        sP2b.setAdapter(array1);
        sP2c.setAdapter(array1);
        sP2d.setAdapter(array1);
        sP2e.setAdapter(array1);
        sP2f.setAdapter(array1);
        sP2g.setAdapter(array1);
        sP2h.setAdapter(array1);
        sP2i.setAdapter(array1);
        sP2j.setAdapter(array1);
        //endregion

        //region Lista 3
        btnP3=(Button) findViewById(R.id.btnP3);
        llP3=(LinearLayout) findViewById(R.id.llP3);
        btnP3.setOnClickListener(this);

        tvP3a=(TextView) findViewById(R.id.tvP3a);
        tvP3b=(TextView) findViewById(R.id.tvP3b);
        tvP3c=(TextView) findViewById(R.id.tvP3c);
        tvP3d=(TextView) findViewById(R.id.tvP3d);
        tvP3e=(TextView) findViewById(R.id.tvP3e);
        tvP3f=(TextView) findViewById(R.id.tvP3f);
        tvP3g=(TextView) findViewById(R.id.tvP3g);
        tvP3h=(TextView) findViewById(R.id.tvP3h);
        tvP3i=(TextView) findViewById(R.id.tvP3i);
        tvP3j=(TextView) findViewById(R.id.tvP3j);

        sP3a=(MaterialBetterSpinner) findViewById(R.id.sp3a);
        sP3b=(MaterialBetterSpinner) findViewById(R.id.sp3b);
        sP3c=(MaterialBetterSpinner) findViewById(R.id.sP3c);
        sP3d=(MaterialBetterSpinner) findViewById(R.id.sP3d);
        sP3e=(MaterialBetterSpinner) findViewById(R.id.sP3e);
        sP3f=(MaterialBetterSpinner) findViewById(R.id.sP3f);
        sP3g=(MaterialBetterSpinner) findViewById(R.id.sP3g);
        sP3h=(MaterialBetterSpinner) findViewById(R.id.sP3h);
        sP3i=(MaterialBetterSpinner) findViewById(R.id.sP3i);
        sP3j=(MaterialBetterSpinner) findViewById(R.id.sP3j);


        sP3a.setAdapter(array1);
        sP3b.setAdapter(array1);
        sP3c.setAdapter(array1);
        sP3d.setAdapter(array1);
        sP3e.setAdapter(array1);
        sP3f.setAdapter(array1);
        sP3g.setAdapter(array1);
        sP3h.setAdapter(array1);
        sP3i.setAdapter(array1);
        sP3j.setAdapter(array1);

        //endregion

        //region Lista 4
        btnP4=(Button) findViewById(R.id.btnP4);
        llP4=(LinearLayout) findViewById(R.id.llP4);
        btnP4.setOnClickListener(this);

        tvP4a=(TextView) findViewById(R.id.tvP4a);
        tvP4b=(TextView) findViewById(R.id.tvP4b);
        tvP4c=(TextView) findViewById(R.id.tvP4c);
        tvP4d=(TextView) findViewById(R.id.tvP4d);
        tvP4e=(TextView) findViewById(R.id.tvP4e);
        tvP4f=(TextView) findViewById(R.id.tvP4f);
        tvP4g=(TextView) findViewById(R.id.tvP4g);
        tvP4h=(TextView) findViewById(R.id.tvP4h);
        tvP4i=(TextView) findViewById(R.id.tvP4i);
        tvP4j=(TextView) findViewById(R.id.tvP4j);

        sP4a=(MaterialBetterSpinner) findViewById(R.id.sP4a);
        sP4b=(MaterialBetterSpinner) findViewById(R.id.sP4b);
        sP4c=(MaterialBetterSpinner) findViewById(R.id.sP4c);
        sP4d=(MaterialBetterSpinner) findViewById(R.id.sP4d);
        sP4e=(MaterialBetterSpinner) findViewById(R.id.sP4e);
        sP4f=(MaterialBetterSpinner) findViewById(R.id.sP4f);
        sP4g=(MaterialBetterSpinner) findViewById(R.id.sP4g);
        sP4h=(MaterialBetterSpinner) findViewById(R.id.sP4h);
        sP4i=(MaterialBetterSpinner) findViewById(R.id.sP4i);
        sP4j=(MaterialBetterSpinner) findViewById(R.id.sP4j);


        sP4a.setAdapter(array1);
        sP4b.setAdapter(array1);
        sP4c.setAdapter(array1);
        sP4d.setAdapter(array1);
        sP4e.setAdapter(array1);
        sP4f.setAdapter(array1);
        sP4g.setAdapter(array1);
        sP4h.setAdapter(array1);
        sP4i.setAdapter(array1);
        sP4j.setAdapter(array1);
        //endregion

        //region Lista 5
        btnP5=(Button) findViewById(R.id.btnP5);
        llP5=(LinearLayout) findViewById(R.id.llP5);
        btnP5.setOnClickListener(this);

        tvP5a=(TextView) findViewById(R.id.tvP5a);
        tvP5b=(TextView) findViewById(R.id.tvP5b);
        tvP5c=(TextView) findViewById(R.id.tvP5c);
        tvP5d=(TextView) findViewById(R.id.tvP5d);
        tvP5e=(TextView) findViewById(R.id.tvP5e);
        tvP5f=(TextView) findViewById(R.id.tvP5f);
        tvP5g=(TextView) findViewById(R.id.tvP5g);
        tvP5h=(TextView) findViewById(R.id.tvP5h);
        tvP5i=(TextView) findViewById(R.id.tvP5i);
        tvP5j=(TextView) findViewById(R.id.tvP5j);

        sP5a=(MaterialBetterSpinner) findViewById(R.id.sP5a);
        sP5b=(MaterialBetterSpinner) findViewById(R.id.sP5b);
        sP5c=(MaterialBetterSpinner) findViewById(R.id.sP5c);
        sP5d=(MaterialBetterSpinner) findViewById(R.id.sP5d);
        sP5e=(MaterialBetterSpinner) findViewById(R.id.sP5e);
        sP5f=(MaterialBetterSpinner) findViewById(R.id.sP5f);
        sP5g=(MaterialBetterSpinner) findViewById(R.id.sP5g);
        sP5h=(MaterialBetterSpinner) findViewById(R.id.sP5h);
        sP5i=(MaterialBetterSpinner) findViewById(R.id.sP5i);
        sP5j=(MaterialBetterSpinner) findViewById(R.id.sP5j);


        sP5a.setAdapter(array1);
        sP5b.setAdapter(array1);
        sP5c.setAdapter(array1);
        sP5d.setAdapter(array1);
        sP5e.setAdapter(array1);
        sP5f.setAdapter(array1);
        sP5g.setAdapter(array1);
        sP5h.setAdapter(array1);
        sP5i.setAdapter(array1);
        sP5j.setAdapter(array1);
        //endregion

        //region Lista 6
        btnP6=(Button) findViewById(R.id.btnP6);
        llP6=(LinearLayout) findViewById(R.id.llP6);
        btnP6.setOnClickListener(this);

        tvP6a=(TextView) findViewById(R.id.tvP6a);
        tvP6b=(TextView) findViewById(R.id.tvP6b);
        tvP6c=(TextView) findViewById(R.id.tvP6c);
        tvP6d=(TextView) findViewById(R.id.tvP6d);
        tvP6e=(TextView) findViewById(R.id.tvP6e);
        tvP6f=(TextView) findViewById(R.id.tvP6f);
        tvP6g=(TextView) findViewById(R.id.tvP6g);
        tvP6h=(TextView) findViewById(R.id.tvP6h);
        tvP6i=(TextView) findViewById(R.id.tvP6i);
        tvP6j=(TextView) findViewById(R.id.tvP6j);

        sP6a=(MaterialBetterSpinner) findViewById(R.id.sP6a);
        sP6b=(MaterialBetterSpinner) findViewById(R.id.sP6b);
        sP6c=(MaterialBetterSpinner) findViewById(R.id.sP6c);
        sP6d=(MaterialBetterSpinner) findViewById(R.id.sP6d);
        sP6e=(MaterialBetterSpinner) findViewById(R.id.sP6e);
        sP6f=(MaterialBetterSpinner) findViewById(R.id.sP6f);
        sP6g=(MaterialBetterSpinner) findViewById(R.id.sP6g);
        sP6h=(MaterialBetterSpinner) findViewById(R.id.sP6h);
        sP6i=(MaterialBetterSpinner) findViewById(R.id.sP6i);
        sP6j=(MaterialBetterSpinner) findViewById(R.id.sP6j);


        sP6a.setAdapter(array2);
        sP6b.setAdapter(array2);
        sP6c.setAdapter(array2);
        sP6d.setAdapter(array2);
        sP6e.setAdapter(array2);
        sP6f.setAdapter(array2);
        sP6g.setAdapter(array2);
        sP6h.setAdapter(array2);
        sP6i.setAdapter(array2);
        sP6j.setAdapter(array2);
        //endregion

        //region Lista 7
        btnP7=(Button) findViewById(R.id.btnP7);
        llP7=(LinearLayout) findViewById(R.id.llP7);
        btnP7.setOnClickListener(this);

        tvP7a=(TextView) findViewById(R.id.tvP7a);
        tvP7b=(TextView) findViewById(R.id.tvP7b);
        tvP7c=(TextView) findViewById(R.id.tvP7c);
        tvP7d=(TextView) findViewById(R.id.tvP7d);
        tvP7e=(TextView) findViewById(R.id.tvP7e);
        tvP7f=(TextView) findViewById(R.id.tvP7f);
        tvP7g=(TextView) findViewById(R.id.tvP7g);
        tvP7h=(TextView) findViewById(R.id.tvP7h);
        tvP7i=(TextView) findViewById(R.id.tvP7i);
        tvP7j=(TextView) findViewById(R.id.tvP7j);

        sP7a=(MaterialBetterSpinner) findViewById(R.id.sP7a);
        sP7b=(MaterialBetterSpinner) findViewById(R.id.sP7b);
        sP7c=(MaterialBetterSpinner) findViewById(R.id.sP7c);
        sP7d=(MaterialBetterSpinner) findViewById(R.id.sP7d);
        sP7e=(MaterialBetterSpinner) findViewById(R.id.sP7e);
        sP7f=(MaterialBetterSpinner) findViewById(R.id.sP7f);
        sP7g=(MaterialBetterSpinner) findViewById(R.id.sP7g);
        sP7h=(MaterialBetterSpinner) findViewById(R.id.sP7h);
        sP7i=(MaterialBetterSpinner) findViewById(R.id.sP7i);
        sP7j=(MaterialBetterSpinner) findViewById(R.id.sP7j);


        sP7a.setAdapter(array2);
        sP7b.setAdapter(array2);
        sP7c.setAdapter(array2);
        sP7d.setAdapter(array2);
        sP7e.setAdapter(array2);
        sP7f.setAdapter(array2);
        sP7g.setAdapter(array2);
        sP7h.setAdapter(array2);
        sP7i.setAdapter(array2);
        sP7j.setAdapter(array2);
        //endregion

        //region Lista 8
        btnP8=(Button) findViewById(R.id.btnP8);
        llP8=(LinearLayout) findViewById(R.id.llP8);
        btnP8.setOnClickListener(this);
        sP8=(MaterialBetterSpinner) findViewById(R.id.sP8);
        sP8.setAdapter(array2);
        //endregion

        sName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //region Initialize selected person interview
                for(int i = 0;i < arrayControl.length;i++) {
                    arrayControl[i] = 0;
                }

                p1=false;
                p2=false;
                p3=false;
                p4=false;
                p5=false;
                p6=false;
                p7=false;
                p8=false;

                a=false;
                b=false;
                c=false;
                d=false;
                e=false;
                f=false;
                g=false;
                h=false;
                i=false;
                j=false;

                etP1j.setText("");
                etP1j.setVisibility(View.GONE);

                llP1.setVisibility(View.GONE);
                llP2.setVisibility(View.GONE);
                llP3.setVisibility(View.GONE);
                llP4.setVisibility(View.GONE);
                llP5.setVisibility(View.GONE);
                llP6.setVisibility(View.GONE);
                llP7.setVisibility(View.GONE);
                llP8.setVisibility(View.GONE);

                //region Lista 1
                sP1a.setText("");
                sP1b.setText("");
                sP1c.setText("");
                sP1d.setText("");
                sP1e.setText("");
                sP1f.setText("");
                sP1g.setText("");
                sP1h.setText("");
                sP1i.setText("");
                sP1j.setText("");
                //endregion

                //region Lista 2
                sP2a.setText("");
                sP2b.setText("");
                sP2c.setText("");
                sP2d.setText("");
                sP2e.setText("");
                sP2f.setText("");
                sP2g.setText("");
                sP2h.setText("");
                sP2i.setText("");
                sP2j.setText("");
                //endregion

                //region Lista 3
                sP3a.setText("");
                sP3b.setText("");
                sP3c.setText("");
                sP3d.setText("");
                sP3e.setText("");
                sP3f.setText("");
                sP3g.setText("");
                sP3h.setText("");
                sP3i.setText("");
                sP3j.setText("");
                //endregion

                //region Lista 4
                sP4a.setText("");
                sP4b.setText("");
                sP4c.setText("");
                sP4d.setText("");
                sP4e.setText("");
                sP4f.setText("");
                sP4g.setText("");
                sP4h.setText("");
                sP4i.setText("");
                sP4j.setText("");
                //endregion

                //region Lista 5
                sP5a.setText("");
                sP5b.setText("");
                sP5c.setText("");
                sP5d.setText("");
                sP5e.setText("");
                sP5f.setText("");
                sP5g.setText("");
                sP5h.setText("");
                sP5i.setText("");
                sP5j.setText("");
                //endregion

                //region Lista 6
                sP6a.setText("");
                sP6b.setText("");
                sP6c.setText("");
                sP6d.setText("");
                sP6e.setText("");
                sP6f.setText("");
                sP6g.setText("");
                sP6h.setText("");
                sP6i.setText("");
                sP6j.setText("");
                //endregion

                //region Lista 7
                sP7a.setText("");
                sP7b.setText("");
                sP7c.setText("");
                sP7d.setText("");
                sP7e.setText("");
                sP7f.setText("");
                sP7g.setText("");
                sP7h.setText("");
                sP7i.setText("");
                sP7j.setText("");
                //endregion

                sP8.setText("");
                //endregion
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //region Control de preguntas 2-8 A-J
        sP1a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        a=true;
                        break;
                    default:
                        a=false;
                        break;
                }
            }
        });
        sP1b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        b=true;
                        break;
                    default:
                        b=false;
                        break;
                }
            }
        });
        sP1c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        c=true;
                        break;
                    default:
                        c=false;
                        break;
                }
            }
        });
        sP1d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        d=true;
                        break;
                    default:
                        d=false;
                        break;
                }
            }
        });
        sP1e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        e=true;
                        break;
                    default:
                        e=false;
                        break;
                }
            }
        });
        sP1f.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        f=true;
                        break;
                    default:
                        f=false;
                        break;
                }
            }
        });
        sP1g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        g=true;
                        break;
                    default:
                        g=false;
                        break;
                }
            }
        });
        sP1h.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        h=true;
                        break;
                    default:
                        h=false;
                        break;
                }
            }
        });
        sP1i.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        i=true;
                        break;
                    default:
                        i=false;
                        break;
                }
            }
        });
        sP1j.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 1:
                        j=true;
                        etP1j.setVisibility(View.VISIBLE);
                        break;
                    default:
                        j=false;
                        etP1j.setVisibility(View.GONE);
                        break;
                }
            }
        });
        //endregion

        //region Control de preguntas 3-5 A-J
        sP2a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[0]=0;
                        break;
                    default:
                        arrayControl[0]=1;
                        break;
                }
                control();
            }
        });
        sP2b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[1]=0;
                        break;
                    default:
                        arrayControl[1]=1;
                        break;
                }
                control();
            }
        });
        sP2c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[2]=0;
                        break;
                    default:
                        arrayControl[2]=1;
                        break;
                }
                control();
            }
        });
        sP2d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[3]=0;
                        break;
                    default:
                        arrayControl[3]=1;
                        break;
                }
                control();
            }
        });
        sP2e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[4]=0;
                        break;
                    default:
                        arrayControl[4]=1;
                        break;
                }
                control();
            }
        });
        sP2f.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[5]=0;
                        break;
                    default:
                        arrayControl[5]=1;
                        break;
                }
                control();
            }
        });
        sP2g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[6]=0;
                        break;
                    default:
                        arrayControl[6]=1;
                        break;
                }
                control();
            }
        });
        sP2h.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[7]=0;
                        break;
                    default:
                        arrayControl[7]=1;
                        break;
                }
                control();
            }
        });
        sP2i.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[8]=0;
                        break;
                    default:
                        arrayControl[8]=1;
                        break;
                }
                control();
            }
        });
        sP2j.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        arrayControl[9]=0;
                        break;
                    default:
                        arrayControl[9]=1;
                        break;
                }
                control();
            }
        });
        //endregion

        btnGuardarASSIST = (Button) findViewById(R.id.btnGuardarASSIST);
        btnGuardarASSIST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer Pa = 0, Pb = 0, Pc = 0, Pd = 0, Pe = 0, Pf = 0, Pg = 0, Ph = 0, Pi = 0, Pj = 0;

                //region Calcula la puntuación total
                //region Lista 2
                for(int i = 0;i < sP2a.getAdapter().getCount();i++) {
                    if (sP2a.getAdapter().getItem(i).toString().equals(sP2a.getText().toString())) {
                        Pa += P[2][i];
                    }
                    if (sP2b.getAdapter().getItem(i).toString().equals(sP2b.getText().toString())) {
                        Pb += P[2][i];
                    }
                    if (sP2c.getAdapter().getItem(i).toString().equals(sP2c.getText().toString())) {
                        Pc += P[2][i];
                    }
                    if (sP2d.getAdapter().getItem(i).toString().equals(sP2d.getText().toString())) {
                        Pd += P[2][i];
                    }
                    if (sP2e.getAdapter().getItem(i).toString().equals(sP2e.getText().toString())) {
                        Pe += P[2][i];
                    }
                    if (sP2f.getAdapter().getItem(i).toString().equals(sP2f.getText().toString())) {
                        Pf += P[2][i];
                    }
                    if (sP2g.getAdapter().getItem(i).toString().equals(sP2g.getText().toString())) {
                        Pg += P[2][i];
                    }
                    if (sP2h.getAdapter().getItem(i).toString().equals(sP2h.getText().toString())) {
                        Ph += P[2][i];
                    }
                    if (sP2i.getAdapter().getItem(i).toString().equals(sP2i.getText().toString())) {
                        Pi += P[2][i];
                    }
                    if (sP2j.getAdapter().getItem(i).toString().equals(sP2j.getText().toString())) {
                        Pj += P[2][i];
                    }
                }
                //endregion

                //region Lista 3
                for(int i = 0;i < sP3a.getAdapter().getCount();i++) {
                    if (sP3a.getAdapter().getItem(i).toString().equals(sP3a.getText().toString())) {
                        Pa += P[3][i];
                    }
                    if (sP3b.getAdapter().getItem(i).toString().equals(sP3b.getText().toString())) {
                        Pb += P[3][i];
                    }
                    if (sP3c.getAdapter().getItem(i).toString().equals(sP3c.getText().toString())) {
                        Pc += P[3][i];
                    }
                    if (sP3d.getAdapter().getItem(i).toString().equals(sP3d.getText().toString())) {
                        Pd += P[3][i];
                    }
                    if (sP3e.getAdapter().getItem(i).toString().equals(sP3e.getText().toString())) {
                        Pe += P[3][i];
                    }
                    if (sP3f.getAdapter().getItem(i).toString().equals(sP3f.getText().toString())) {
                        Pf += P[3][i];
                    }
                    if (sP3g.getAdapter().getItem(i).toString().equals(sP3g.getText().toString())) {
                        Pg += P[3][i];
                    }
                    if (sP3h.getAdapter().getItem(i).toString().equals(sP3h.getText().toString())) {
                        Ph += P[3][i];
                    }
                    if (sP3i.getAdapter().getItem(i).toString().equals(sP3i.getText().toString())) {
                        Pi += P[3][i];
                    }
                    if (sP3j.getAdapter().getItem(i).toString().equals(sP3j.getText().toString())) {
                        Pj += P[3][i];
                    }
                }
                //endregion

                //region Lista 4
                for(int i = 0;i < sP4a.getAdapter().getCount();i++) {
                    if (sP4a.getAdapter().getItem(i).toString().equals(sP4a.getText().toString())) {
                        Pa += P[4][i];
                    }
                    if (sP4b.getAdapter().getItem(i).toString().equals(sP4b.getText().toString())) {
                        Pb += P[4][i];
                    }
                    if (sP4c.getAdapter().getItem(i).toString().equals(sP4c.getText().toString())) {
                        Pc += P[4][i];
                    }
                    if (sP4d.getAdapter().getItem(i).toString().equals(sP4d.getText().toString())) {
                        Pd += P[4][i];
                    }
                    if (sP4e.getAdapter().getItem(i).toString().equals(sP4e.getText().toString())) {
                        Pe += P[4][i];
                    }
                    if (sP4f.getAdapter().getItem(i).toString().equals(sP4f.getText().toString())) {
                        Pf += P[4][i];
                    }
                    if (sP4g.getAdapter().getItem(i).toString().equals(sP4g.getText().toString())) {
                        Pg += P[4][i];
                    }
                    if (sP4h.getAdapter().getItem(i).toString().equals(sP4h.getText().toString())) {
                        Ph += P[4][i];
                    }
                    if (sP4i.getAdapter().getItem(i).toString().equals(sP4i.getText().toString())) {
                        Pi += P[4][i];
                    }
                    if (sP4j.getAdapter().getItem(i).toString().equals(sP4j.getText().toString())) {
                        Pj += P[4][i];
                    }
                }
                //endregion

                //region Lista 5
                for(int i = 0;i < sP5a.getAdapter().getCount();i++) {
                    if (sP5a.getAdapter().getItem(i).toString().equals(sP5a.getText().toString())) {
                        Pa += P[5][i];
                    }
                    if (sP5b.getAdapter().getItem(i).toString().equals(sP5b.getText().toString())) {
                        Pb += P[5][i];
                    }
                    if (sP5c.getAdapter().getItem(i).toString().equals(sP5c.getText().toString())) {
                        Pc += P[5][i];
                    }
                    if (sP5d.getAdapter().getItem(i).toString().equals(sP5d.getText().toString())) {
                        Pd += P[5][i];
                    }
                    if (sP5e.getAdapter().getItem(i).toString().equals(sP5e.getText().toString())) {
                        Pe += P[5][i];
                    }
                    if (sP5f.getAdapter().getItem(i).toString().equals(sP5f.getText().toString())) {
                        Pf += P[5][i];
                    }
                    if (sP5g.getAdapter().getItem(i).toString().equals(sP5g.getText().toString())) {
                        Pg += P[5][i];
                    }
                    if (sP5h.getAdapter().getItem(i).toString().equals(sP5h.getText().toString())) {
                        Ph += P[5][i];
                    }
                    if (sP5i.getAdapter().getItem(i).toString().equals(sP5i.getText().toString())) {
                        Pi += P[5][i];
                    }
                    if (sP5j.getAdapter().getItem(i).toString().equals(sP5j.getText().toString())) {
                        Pj += P[5][i];
                    }
                }
                //endregion

                //region Lista 6
                for(int i = 0;i < sP6a.getAdapter().getCount();i++) {
                    if (sP6a.getAdapter().getItem(i).toString().equals(sP6a.getText().toString())) {
                        Pa += P[6][i];
                    }
                    if (sP6b.getAdapter().getItem(i).toString().equals(sP6b.getText().toString())) {
                        Pb += P[6][i];
                    }
                    if (sP6c.getAdapter().getItem(i).toString().equals(sP6c.getText().toString())) {
                        Pc += P[6][i];
                    }
                    if (sP6d.getAdapter().getItem(i).toString().equals(sP6d.getText().toString())) {
                        Pd += P[6][i];
                    }
                    if (sP6e.getAdapter().getItem(i).toString().equals(sP6e.getText().toString())) {
                        Pe += P[6][i];
                    }
                    if (sP6f.getAdapter().getItem(i).toString().equals(sP6f.getText().toString())) {
                        Pf += P[6][i];
                    }
                    if (sP6g.getAdapter().getItem(i).toString().equals(sP6g.getText().toString())) {
                        Pg += P[6][i];
                    }
                    if (sP6h.getAdapter().getItem(i).toString().equals(sP6h.getText().toString())) {
                        Ph += P[6][i];
                    }
                    if (sP6i.getAdapter().getItem(i).toString().equals(sP6i.getText().toString())) {
                        Pi += P[6][i];
                    }
                    if (sP6j.getAdapter().getItem(i).toString().equals(sP6j.getText().toString())) {
                        Pj += P[6][i];
                    }
                }
                //endregion

                //region Lista 7
                for(int i = 0;i < sP7a.getAdapter().getCount();i++) {
                    if (sP7a.getAdapter().getItem(i).toString().equals(sP7a.getText().toString())) {
                        Pa += P[7][i];
                    }
                    if (sP7b.getAdapter().getItem(i).toString().equals(sP7b.getText().toString())) {
                        Pb += P[7][i];
                    }
                    if (sP7c.getAdapter().getItem(i).toString().equals(sP7c.getText().toString())) {
                        Pc += P[7][i];
                    }
                    if (sP7d.getAdapter().getItem(i).toString().equals(sP7d.getText().toString())) {
                        Pd += P[7][i];
                    }
                    if (sP7e.getAdapter().getItem(i).toString().equals(sP7e.getText().toString())) {
                        Pe += P[7][i];
                    }
                    if (sP7f.getAdapter().getItem(i).toString().equals(sP7f.getText().toString())) {
                        Pf += P[7][i];
                    }
                    if (sP7g.getAdapter().getItem(i).toString().equals(sP7g.getText().toString())) {
                        Pg += P[7][i];
                    }
                    if (sP7h.getAdapter().getItem(i).toString().equals(sP7h.getText().toString())) {
                        Ph += P[7][i];
                    }
                    if (sP7i.getAdapter().getItem(i).toString().equals(sP7i.getText().toString())) {
                        Pi += P[7][i];
                    }
                    if (sP7j.getAdapter().getItem(i).toString().equals(sP7j.getText().toString())) {
                        Pj += P[7][i];
                    }
                }
                //endregion
                //endregion

                ArrayList<datosGenerales> lista;
                lista = db.getDatosGenerales();
                int pos = sName.getSelectedItemPosition();
                String folio = lista.get(Idx.get(pos)).getFolio();

                String r8 = sP8.getText().toString().toUpperCase();
                db.insertarASSIST(Pa.toString(), Pb.toString(), Pc.toString(), Pd.toString(), Pe.toString(), Pf.toString(),
                        Pg.toString(), Ph.toString(), Pi.toString(), Pj.toString(), otro.toUpperCase(), r8, folio);

                db.updateTable("imputado_datos_generales", "ASSIST", "SI", folio);

                Intent intent = new Intent(v.getContext(), MainMenu.class);
                startActivity(intent);
            }
        });
    }
    //endregion

    //region onClick
    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //region Pregunta 1
            case R.id.btnP1:
                if(!p1){
                    llP1.setVisibility(View.VISIBLE);
                    p1=true;
                }
                else{
                    llP1.setVisibility(View.GONE);
                    p1=false;
                }
                break;
            //endregion

            //region Pregunta 2
            case R.id.btnP2:
                if(!p2){
                    llP2.setVisibility(View.VISIBLE);
                    p2=true;
                    if(a){
                        sP2a.setVisibility(View.VISIBLE);
                        tvP2a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2a.setVisibility(View.GONE);
                        tvP2a.setVisibility(View.GONE);
                    }
                    if(b){
                        sP2b.setVisibility(View.VISIBLE);
                        tvP2b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2b.setVisibility(View.GONE);
                        tvP2b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP2c.setVisibility(View.VISIBLE);
                        tvP2c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2c.setVisibility(View.GONE);
                        tvP2c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP2d.setVisibility(View.VISIBLE);
                        tvP2d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2d.setVisibility(View.GONE);
                        tvP2d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP2e.setVisibility(View.VISIBLE);
                        tvP2e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2e.setVisibility(View.GONE);
                        tvP2e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP2f.setVisibility(View.VISIBLE);
                        tvP2f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2f.setVisibility(View.GONE);
                        tvP2f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP2g.setVisibility(View.VISIBLE);
                        tvP2g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2g.setVisibility(View.GONE);
                        tvP2g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP2h.setVisibility(View.VISIBLE);
                        tvP2h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2h.setVisibility(View.GONE);
                        tvP2h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP2i.setVisibility(View.VISIBLE);
                        tvP2i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2i.setVisibility(View.GONE);
                        tvP2i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP2j.setText("Otro: "+otro);
                        sP2j.setVisibility(View.VISIBLE);
                        tvP2j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP2j.setVisibility(View.GONE);
                        tvP2j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP2.setVisibility(View.GONE);
                    p2=false;
                }
                break;
            //endregion

            //region Pregunta 3
            case R.id.btnP3:
                if(!p3){
                    llP3.setVisibility(View.VISIBLE);
                    p3=true;
                    if(a){
                        sP3a.setVisibility(View.VISIBLE);
                        tvP3a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3a.setVisibility(View.GONE);
                        tvP3a.setVisibility(View.GONE);
                    }
                    if(b){
                        sP3b.setVisibility(View.VISIBLE);
                        tvP3b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3b.setVisibility(View.GONE);
                        tvP3b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP3c.setVisibility(View.VISIBLE);
                        tvP3c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3c.setVisibility(View.GONE);
                        tvP3c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP3d.setVisibility(View.VISIBLE);
                        tvP3d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3d.setVisibility(View.GONE);
                        tvP3d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP3e.setVisibility(View.VISIBLE);
                        tvP3e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3e.setVisibility(View.GONE);
                        tvP3e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP3f.setVisibility(View.VISIBLE);
                        tvP3f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3f.setVisibility(View.GONE);
                        tvP3f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP3g.setVisibility(View.VISIBLE);
                        tvP3g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3g.setVisibility(View.GONE);
                        tvP3g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP3h.setVisibility(View.VISIBLE);
                        tvP3h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3h.setVisibility(View.GONE);
                        tvP3h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP3i.setVisibility(View.VISIBLE);
                        tvP3i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3i.setVisibility(View.GONE);
                        tvP3i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP3j.setText("Otro: "+otro);
                        sP3j.setVisibility(View.VISIBLE);
                        tvP3j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP3j.setVisibility(View.GONE);
                        tvP3j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP3.setVisibility(View.GONE);
                    p3=false;
                }
                break;
            //endregion

            //region Pregunta 4
            case R.id.btnP4:
                if(!p4){
                    llP4.setVisibility(View.VISIBLE);
                    p4=true;
                    if(a){
                        sP4a.setVisibility(View.VISIBLE);
                        tvP4a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4a.setVisibility(View.GONE);
                        tvP4a.setVisibility(View.GONE);
                    }
                    if(b){
                        sP4b.setVisibility(View.VISIBLE);
                        tvP4b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4b.setVisibility(View.GONE);
                        tvP4b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP4c.setVisibility(View.VISIBLE);
                        tvP4c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4c.setVisibility(View.GONE);
                        tvP4c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP4d.setVisibility(View.VISIBLE);
                        tvP4d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4d.setVisibility(View.GONE);
                        tvP4d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP4e.setVisibility(View.VISIBLE);
                        tvP4e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4e.setVisibility(View.GONE);
                        tvP4e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP4f.setVisibility(View.VISIBLE);
                        tvP4f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4f.setVisibility(View.GONE);
                        tvP4f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP4g.setVisibility(View.VISIBLE);
                        tvP4g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4g.setVisibility(View.GONE);
                        tvP4g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP4h.setVisibility(View.VISIBLE);
                        tvP4h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4h.setVisibility(View.GONE);
                        tvP4h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP4i.setVisibility(View.VISIBLE);
                        tvP4i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4i.setVisibility(View.GONE);
                        tvP4i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP4j.setText("Otro: "+otro);
                        sP4j.setVisibility(View.VISIBLE);
                        tvP4j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP4j.setVisibility(View.GONE);
                        tvP4j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP4.setVisibility(View.GONE);
                    p4=false;
                }
                break;
            //endregion

            //region Pregunta 5
            case R.id.btnP5:
                if(!p5){
                    llP5.setVisibility(View.VISIBLE);
                    p5=true;
                    /*if(a){
                        sP5a.setVisibility(View.VISIBLE);
                        tvP5a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5a.setVisibility(View.GONE);
                        tvP5a.setVisibility(View.GONE);
                    }*/
                    if(b){
                        sP5b.setVisibility(View.VISIBLE);
                        tvP5b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5b.setVisibility(View.GONE);
                        tvP5b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP5c.setVisibility(View.VISIBLE);
                        tvP5c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5c.setVisibility(View.GONE);
                        tvP5c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP5d.setVisibility(View.VISIBLE);
                        tvP5d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5d.setVisibility(View.GONE);
                        tvP5d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP5e.setVisibility(View.VISIBLE);
                        tvP5e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5e.setVisibility(View.GONE);
                        tvP5e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP5f.setVisibility(View.VISIBLE);
                        tvP5f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5f.setVisibility(View.GONE);
                        tvP5f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP5g.setVisibility(View.VISIBLE);
                        tvP5g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5g.setVisibility(View.GONE);
                        tvP5g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP5h.setVisibility(View.VISIBLE);
                        tvP5h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5h.setVisibility(View.GONE);
                        tvP5h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP5i.setVisibility(View.VISIBLE);
                        tvP5i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5i.setVisibility(View.GONE);
                        tvP5i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP5j.setText("Otro: "+otro);
                        sP5j.setVisibility(View.VISIBLE);
                        tvP5j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP5j.setVisibility(View.GONE);
                        tvP5j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP5.setVisibility(View.GONE);
                    p5=false;
                }
                break;
            //endregion

            //region Pregunta 6
            case R.id.btnP6:
                if(!p6){
                    llP6.setVisibility(View.VISIBLE);
                    p6=true;
                    if(a){
                        sP6a.setVisibility(View.VISIBLE);
                        tvP6a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6a.setVisibility(View.GONE);
                        tvP6a.setVisibility(View.GONE);
                    }
                    if(b){
                        sP6b.setVisibility(View.VISIBLE);
                        tvP6b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6b.setVisibility(View.GONE);
                        tvP6b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP6c.setVisibility(View.VISIBLE);
                        tvP6c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6c.setVisibility(View.GONE);
                        tvP6c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP6d.setVisibility(View.VISIBLE);
                        tvP6d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6d.setVisibility(View.GONE);
                        tvP6d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP6e.setVisibility(View.VISIBLE);
                        tvP6e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6e.setVisibility(View.GONE);
                        tvP6e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP6f.setVisibility(View.VISIBLE);
                        tvP6f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6f.setVisibility(View.GONE);
                        tvP6f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP6g.setVisibility(View.VISIBLE);
                        tvP6g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6g.setVisibility(View.GONE);
                        tvP6g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP6h.setVisibility(View.VISIBLE);
                        tvP6h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6h.setVisibility(View.GONE);
                        tvP6h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP6i.setVisibility(View.VISIBLE);
                        tvP6i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6i.setVisibility(View.GONE);
                        tvP6i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP6j.setText("Otro: "+otro);
                        sP6j.setVisibility(View.VISIBLE);
                        tvP6j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP6j.setVisibility(View.GONE);
                        tvP6j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP6.setVisibility(View.GONE);
                    p6=false;
                }
                break;
            //endregion

            //region Pregunta 7
            case R.id.btnP7:
                if(!p7){
                    llP7.setVisibility(View.VISIBLE);
                    p7=true;
                    if(a){
                        sP7a.setVisibility(View.VISIBLE);
                        tvP7a.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7a.setVisibility(View.GONE);
                        tvP7a.setVisibility(View.GONE);
                    }
                    if(b){
                        sP7b.setVisibility(View.VISIBLE);
                        tvP7b.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7b.setVisibility(View.GONE);
                        tvP7b.setVisibility(View.GONE);
                    }
                    if(c){
                        sP7c.setVisibility(View.VISIBLE);
                        tvP7c.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7c.setVisibility(View.GONE);
                        tvP7c.setVisibility(View.GONE);
                    }
                    if(d){
                        sP7d.setVisibility(View.VISIBLE);
                        tvP7d.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7d.setVisibility(View.GONE);
                        tvP7d.setVisibility(View.GONE);
                    }
                    if(e){
                        sP7e.setVisibility(View.VISIBLE);
                        tvP7e.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7e.setVisibility(View.GONE);
                        tvP7e.setVisibility(View.GONE);
                    }
                    if(f){
                        sP7f.setVisibility(View.VISIBLE);
                        tvP7f.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7f.setVisibility(View.GONE);
                        tvP7f.setVisibility(View.GONE);
                    }
                    if(g){
                        sP7g.setVisibility(View.VISIBLE);
                        tvP7g.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7g.setVisibility(View.GONE);
                        tvP7g.setVisibility(View.GONE);
                    }
                    if(h){
                        sP7h.setVisibility(View.VISIBLE);
                        tvP7h.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7h.setVisibility(View.GONE);
                        tvP7h.setVisibility(View.GONE);
                    }
                    if(i){
                        sP7i.setVisibility(View.VISIBLE);
                        tvP7i.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7i.setVisibility(View.GONE);
                        tvP7i.setVisibility(View.GONE);
                    }
                    if(j){
                        otro=etP1j.getText().toString();
                        tvP7j.setText("Otro: "+otro);
                        sP7j.setVisibility(View.VISIBLE);
                        tvP7j.setVisibility(View.VISIBLE);
                    }
                    else{
                        sP7j.setVisibility(View.GONE);
                        tvP7j.setVisibility(View.GONE);
                    }

                }
                else{
                    llP7.setVisibility(View.GONE);
                    p7=false;
                }
                break;
            //endregion

            //region Pregunta 8
            case R.id.btnP8:
                if(!p8){
                    llP8.setVisibility(View.VISIBLE);
                    p8=true;
                }
                else{
                    llP8.setVisibility(View.GONE);
                    p8=false;
                }
                break;
            //endregion
        }
    }
    //endregion


    //region Control 2-5
    public void control(){
        int c=0;
        for (int i=0;i<arrayControl.length;i++){
            c+=arrayControl[i];
        }

        if(c!=0){
            btnP3.setVisibility(View.VISIBLE);
            btnP4.setVisibility(View.VISIBLE);
            btnP5.setVisibility(View.VISIBLE);
        }
        else{
            btnP3.setVisibility(View.GONE);
            btnP4.setVisibility(View.GONE);
            btnP5.setVisibility(View.GONE);
        }
    }
    //endregion

    //endregion

}
