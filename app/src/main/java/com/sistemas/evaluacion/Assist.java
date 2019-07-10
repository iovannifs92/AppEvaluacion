package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Assist extends AppCompatActivity implements View.OnClickListener{

    String[] lista1 = {"Nunca", "Una o dos veces", "Mensualmente", "Semanalmente","Diariamente o casi diariamente"};
    String[] lista2={"No, nunca","Si, en los ultimos 3 meses","Si, pero no en los últimos 3 meses"};
    String[] nosi={"NO", "SI"};
    TextView tvP2a, tvP2b, tvP2c, tvP2d, tvP2e, tvP2f, tvP2g, tvP2h, tvP2i, tvP2j,
            tvP3a, tvP3b;
    Button btnP1, btnP2, btnP3;
    LinearLayout llP1, llP2, llP3;
    boolean p1=false, p2=false, p3=false, a=false, b=false, c=false, d=false, e=false, f=false, g=false, h=false, i=false, j=false;

    EditText etP1j;
    String otro;

    MaterialBetterSpinner sP1a, sP1b, sP1c, sP1d, sP1e, sP1f, sP1g, sP1h, sP1i, sP1j,
                        sP2a, sP2b, sP2c, sP2d, sP2e, sP2f, sP2g, sP2h, sP2i, sP2j,
                        sP3a, sP3b;
    ArrayAdapter<String> array1, array2, array3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assist);

        array1= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lista1);
        array2= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, lista2);
        array3= new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, nosi);

        etP1j=(EditText) findViewById(R.id.etP1j); //Edit Text para otro tipo de adicción

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
        sP2a.setAdapter(array1);
        sP2b.setAdapter(array1);

        btnP3=(Button) findViewById(R.id.btnP3);
        llP3=(LinearLayout) findViewById(R.id.llP3);
        btnP3.setOnClickListener(this);
        tvP3a=(TextView) findViewById(R.id.tvP3a);
        tvP3b=(TextView) findViewById(R.id.tvP3b);
        sP3a=(MaterialBetterSpinner) findViewById(R.id.sp3a);
        sP3b=(MaterialBetterSpinner) findViewById(R.id.sp3b);
        sP3a.setAdapter(array1);
        sP3b.setAdapter(array1);



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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
                }
                else{
                    llP2.setVisibility(View.GONE);
                    p2=false;
                }
                if(c){
                    sP2c.setVisibility(View.VISIBLE);
                    tvP2c.setVisibility(View.VISIBLE);
                }
                else{
                    sP2c.setVisibility(View.GONE);
                    tvP2c.setVisibility(View.GONE);
                }

                break;

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
                }
                else{
                    llP3.setVisibility(View.GONE);
                    p3=false;
                }
                break;

        }
    }
}
