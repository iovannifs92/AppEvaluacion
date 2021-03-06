package com.sistemas.evaluacion;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosASSIST;
import com.sistemas.evaluacion.entidades.datosGenerales;

import net.glxn.qrgen.android.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ReporteAssist extends AppCompatActivity implements View.OnClickListener {

    //region Variables Globales
    private TextView tvPa, tvPb, tvPc, tvPd, tvPe, tvPf, tvPg, tvPh, tvPi, tvPj, tvRa, tvRb, tvRc, tvRd, tvRe, tvRf, tvRg, tvRh, tvRi, tvRj, tvOtro, tvControl;
    private Button btnGenerarReporte;
    private LinearLayout llControl;
    private TemplatePDF templatePDF;

    private String[] header={"Sustancia", "Puntuación", "Nivel de riesgo"};
    private ArrayList<String[]> imputado;

    private String nombre, folio, pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, jOtro, p8,
            ra, rb, rc, rd, re, rf, rg, rh, ri, rj;
    private int pia, pib, pic, pid, pie, pif, pig, pih, pii, pij;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_assist);

        MyOpenHelper db;
        db = new MyOpenHelper(this);
        db.getReadableDatabase();

        ArrayList<datosGenerales> lista;
        lista = db.getDatosGenerales();

        ArrayList<String> names = new ArrayList<String>();
        final ArrayList<String> Folios = new ArrayList<String>();
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getASSIST().equals("SI")) {
                names.add(lista.get(i).getNombre());
                Folios.add(lista.get(i).getFolio());
            }
        }

        Spinner sName;
        sName = (Spinner) findViewById(R.id.sName);
        sName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        if(names.isEmpty() == false) {
            sName.setSelection(names.size() - 1);
        }

        //region Verificar si hay registros
        if(names.size()!=0){
            tvControl=(TextView) findViewById(R.id.tvControl);
            llControl=(LinearLayout) findViewById(R.id.llControl);

            llControl.setVisibility(View.VISIBLE);
            tvControl.setVisibility(View.GONE);
        }
        //endregion

        final ArrayList <datosASSIST> P = db.getASSIST();

        //region identify the TextView´s
        tvPa = (TextView) findViewById(R.id.tvPa);
        tvPb = (TextView) findViewById(R.id.tvPb);
        tvPc = (TextView) findViewById(R.id.tvPc);
        tvPd = (TextView) findViewById(R.id.tvPd);
        tvPe = (TextView) findViewById(R.id.tvPe);
        tvPf = (TextView) findViewById(R.id.tvPf);
        tvPg = (TextView) findViewById(R.id.tvPg);
        tvPh = (TextView) findViewById(R.id.tvPh);
        tvPi = (TextView) findViewById(R.id.tvPi);
        tvPj = (TextView) findViewById(R.id.tvPj);

        tvRa = (TextView) findViewById(R.id.tvRa);
        tvRb = (TextView) findViewById(R.id.tvRb);
        tvRc = (TextView) findViewById(R.id.tvRc);
        tvRd = (TextView) findViewById(R.id.tvRd);
        tvRe = (TextView) findViewById(R.id.tvRe);
        tvRf = (TextView) findViewById(R.id.tvRf);
        tvRg = (TextView) findViewById(R.id.tvRg);
        tvRh = (TextView) findViewById(R.id.tvRh);
        tvRi = (TextView) findViewById(R.id.tvRi);
        tvRj = (TextView) findViewById(R.id.tvRj);

        tvOtro = (TextView) findViewById(R.id.tvOtro);
        //endregion

        sName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                int position = 0;
                while (position < P.size() && P.get(position).getFolio().equals(Folios.get(pos)) == false) {
                    position++;
                }
                //region Get the question´s score
                pa = P.get(position).getPa();
                pb = P.get(position).getPb();
                pc = P.get(position).getPc();
                pd = P.get(position).getPd();
                pe = P.get(position).getPe();
                pf = P.get(position).getPf();
                pg = P.get(position).getPg();
                ph = P.get(position).getPh();
                pi = P.get(position).getPi();
                pj = P.get(position).getPj();
                folio=P.get(position).getFolio();
                p8=P.get(position).getE8();
                //endregion

                jOtro = P.get(position).getJOtro();
                tvOtro.setText("Otros, especifique: " + jOtro);

                //region Convert the score to int
                pia = Integer.parseInt(pa);
                pib = Integer.parseInt(pb);
                pic = Integer.parseInt(pc);
                pid = Integer.parseInt(pd);
                pie = Integer.parseInt(pe);
                pif = Integer.parseInt(pf);
                pig = Integer.parseInt(pg);
                pih = Integer.parseInt(ph);
                pii = Integer.parseInt(pi);
                pij = Integer.parseInt(pj);
                //endregion

                //region Display the scores
                tvPa.setText(pa);
                tvPb.setText(pb);
                tvPc.setText(pc);
                tvPd.setText(pd);
                tvPe.setText(pe);
                tvPf.setText(pf);
                tvPg.setText(pg);
                tvPh.setText(ph);
                tvPi.setText(pi);
                tvPj.setText(pj);
                //endregion

                //region Color depending on the risk
                //region Color a
                if(pia <= 3){
                    tvRa.setText("Bajo");
                    tvRa.setBackgroundResource(R.color.green);
                }
                else if(pia >= 27){
                    tvRa.setText("Alto");
                    tvRa.setBackgroundResource(R.color.red);
                }
                else{
                    tvRa.setText("Moderado");
                    tvRa.setBackgroundResource(R.color.yellow);
                }
                ra=tvRa.getText().toString();
                //endregion

                //region Color b
                //0 - 10 Bajo
                if(pib <= 10){
                    tvRb.setText("Bajo");
                    tvRb.setBackgroundResource(R.color.green);
                }
                else if(pib >= 27){
                    tvRb.setText("Alto");
                    tvRb.setBackgroundResource(R.color.red);
                }
                else{
                    tvRb.setText("Moderado");
                    tvRb.setBackgroundResource(R.color.yellow);
                }
                rb=tvRb.getText().toString();
                //endregion

                //region Color c
                if(pic <= 3){
                    tvRc.setText("Bajo");
                    tvRc.setBackgroundResource(R.color.green);
                }
                else if(pic >= 27){
                    tvRc.setText("Alto");
                    tvRc.setBackgroundResource(R.color.red);
                }
                else{
                    tvRc.setText("Moderado");
                    tvRc.setBackgroundResource(R.color.yellow);
                }
                rc=tvRc.getText().toString();
                //endregion

                //region Color d
                if(pid <= 3){
                    tvRd.setText("Bajo");
                    tvRd.setBackgroundResource(R.color.green);
                }
                else if(pid >= 27){
                    tvRd.setText("Alto");
                    tvRd.setBackgroundResource(R.color.red);
                }
                else{
                    tvRd.setText("Moderado");
                    tvRd.setBackgroundResource(R.color.yellow);
                }
                rd=tvRd.getText().toString();
                //endregion

                //region Color e
                if(pie <= 3){
                    tvRe.setText("Bajo");
                    tvRe.setBackgroundResource(R.color.green);
                }
                else if(pie >= 27){
                    tvRe.setText("Alto");
                    tvRe.setBackgroundResource(R.color.red);
                }
                else{
                    tvRe.setText("Moderado");
                    tvRe.setBackgroundResource(R.color.yellow);
                }
                re=tvRe.getText().toString();
                //endregion

                //region Color f
                if(pif <= 3){
                    tvRf.setText("Bajo");
                    tvRf.setBackgroundResource(R.color.green);
                }
                else if(pif >= 27){
                    tvRf.setText("Alto");
                    tvRf.setBackgroundResource(R.color.red);
                }
                else{
                    tvRf.setText("Moderado");
                    tvRf.setBackgroundResource(R.color.yellow);
                }
                rf=tvRf.getText().toString();
                //endregion

                //region Color g
                if(pig <= 3){
                    tvRg.setText("Bajo");
                    tvRg.setBackgroundResource(R.color.green);
                }
                else if(pig >= 27){
                    tvRg.setText("Alto");
                    tvRg.setBackgroundResource(R.color.red);
                }
                else{
                    tvRg.setText("Moderado");
                    tvRg.setBackgroundResource(R.color.yellow);
                }
                rg=tvRg.getText().toString();
                //endregion

                //region Color h
                if(pih <= 3){
                    tvRh.setText("Bajo");
                    tvRh.setBackgroundResource(R.color.green);
                }
                else if(pih >= 27){
                    tvRh.setText("Alto");
                    tvRh.setBackgroundResource(R.color.red);
                }
                else{
                    tvRh.setText("Moderado");
                    tvRh.setBackgroundResource(R.color.yellow);
                }
                rh=tvRh.getText().toString();
                //endregion

                //region Color i
                if(pii <= 3){
                    tvRi.setText("Bajo");
                    tvRi.setBackgroundResource(R.color.green);
                }
                else if(pii >= 27){
                    tvRi.setText("Alto");
                    tvRi.setBackgroundResource(R.color.red);
                }
                else{
                    tvRi.setText("Moderado");
                    tvRi.setBackgroundResource(R.color.yellow);
                }
                ri=tvRi.getText().toString();
                //endregion

                //region Color j
                if(pij <= 3){
                    tvRj.setText("Bajo");
                    tvRj.setBackgroundResource(R.color.green);
                }
                else if(pij >= 27){
                    tvRj.setText("Alto");
                    tvRj.setBackgroundResource(R.color.red);
                }
                else{
                    tvRj.setText("Moderado");
                    tvRj.setBackgroundResource(R.color.yellow);
                }
                rj=tvRj.getText().toString();
                //endregion
                //endregion


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGenerarReporte=(Button) findViewById(R.id.btnGenerarReporte);
        btnGenerarReporte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGenerarReporte:
                //region Generar Código QR
                String texto = folio;
                if (texto.isEmpty()) return;
                ByteArrayOutputStream byteArrayOutputStream = QRCode.from(texto).withSize(200, 200).stream();
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

                templatePDF=new TemplatePDF(getApplicationContext());
                templatePDF.openDocument();
                templatePDF.addImgName();
                templatePDF.addMetaData("Reporte ASSIST", "FOLIO", "SCORPION");
                templatePDF.addTitles("Reporte ASSIST",folio, fecha);
                templatePDF.createTable(header, getImputado());
                templatePDF.addParagraph("Ha consumido droga por vía inyectada: "+p8);
                templatePDF.addImgQR();
                templatePDF.closeDocument();
                templatePDF.appViewPDF(this);
                break;
        }
    }

    private ArrayList<String[]> getImputado(){
        ArrayList<String[]> rows=new ArrayList<>();
        rows.add(new String[]{"Productos de Tabaco",pa,ra});
        rows.add(new String[]{"Bebidas Alcoholicas",pb,rb});
        rows.add(new String[]{"Cannabis",pc,rc});
        rows.add(new String[]{"Cocaína",pd,rd});
        rows.add(new String[]{"Estimulantes de tipo anfetaminas",pe,re});
        rows.add(new String[]{"Inhalantes",pf,rf});
        rows.add(new String[]{"Sedantes o pastillas para dormir",pg,rg});
        rows.add(new String[]{"Alucinógenos",ph,rh});
        String otro="Otros, especifique: " + jOtro;
        rows.add(new String[]{otro,pj,rj});
        return rows;
    }
}
