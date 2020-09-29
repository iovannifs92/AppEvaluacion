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

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.sistemas.evaluacion.entidades.datosAbandonoEstado;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosEscolarLaboral;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosHabitantes;
import com.sistemas.evaluacion.entidades.datosReferencias;
import com.sistemas.evaluacion.entidades.datosSalud;
import com.sistemas.evaluacion.entidades.datosVictima;

import net.glxn.qrgen.android.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ReporteEntrevista extends AppCompatActivity implements View.OnClickListener {

    //region Variables Globales
    private LinearLayout llControl;
    private TextView tvControl;
    private Button btnGenerarReporte;
    private Spinner sName;
    private TemplatePDF templatePDF;

    private String folio;

    private static final int TRANSPARENCY = 128;

    private BaseColor lightGray = new BaseColor(230, 230, 230);
    private BaseColor colorGenerales = new BaseColor(0, 120, 167);
    private BaseColor colorHabitantes = new BaseColor(65, 86, 103);
    private BaseColor colorEscolar = new BaseColor(128, 174, 171);
    private BaseColor colorOcupacional = new BaseColor(35, 52, 96);
    private BaseColor colorAbandono = new BaseColor(55, 52, 53);
    private BaseColor colorSalud = new BaseColor(169, 208, 142);

    private ArrayList<datosGenerales> lista;
    private ArrayList<datosDomicilio> addresses;
    private ArrayList<datosHabitantes> habitantes;
    private ArrayList<datosReferencias> referencias;
    private ArrayList<datosEscolarLaboral> historialEscolarLaboral;
    private ArrayList<datosAbandonoEstado> listaAbandonoEstado;
    private ArrayList<datosSalud> listaSalud;
    private ArrayList<datosVictima> victima;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_entrevista);

        MyOpenHelper db;
        db=new MyOpenHelper(this);
        db.getReadableDatabase();

        lista = db.getDatosGenerales();
        addresses = db.getDomicilios();
        habitantes = db.getHabitantes();
        referencias = db.getReferencias();
        historialEscolarLaboral = db.getHistorialEscolarLaboral();
        listaAbandonoEstado = db.getDatosAbandonoEstado();
        listaSalud = db.getDatosSalud();
        victima = db.getVictima();

        //region Inicializa un spinner con los nombres de los entrevistados
        sName = (Spinner) findViewById(R.id.sName);
        String[] names = new String[lista.size()];
        for(int i = 0; i < lista.size(); i++){
            names[i] = lista.get(i).getNombre();
        }
        sName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion

        //region Verificar si hay registros
        if(lista.isEmpty() == false){
            sName.setSelection(lista.size() - 1);

            tvControl=(TextView) findViewById(R.id.tvControl);
            llControl=(LinearLayout) findViewById(R.id.llControl);

            llControl.setVisibility(View.VISIBLE);
            tvControl.setVisibility(View.GONE);
        }
        //endregion

        //region setOnItemSelectedListener
        sName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        btnGenerarReporte=(Button) findViewById(R.id.btnGenerarReporte);
        btnGenerarReporte.setOnClickListener(this);
    }

    //region Create and display the report in PDF format
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGenerarReporte:
                int pos = sName.getSelectedItemPosition();
                folio = lista.get(pos).getFolio();

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
                templatePDF.addMetaData("FORMATO DE ENTREVISTA", "FOLIO", "SCORPION");
                templatePDF.addColumnTextTitles("FORMATO DE ENTREVISTA\n", "", fecha + "\n");

                templatePDF.createTable(getHeader(), 2, new float[]{1, 1}, false, false);
                templatePDF.createTable(getDatosGenerales(), 4, new float[]{1, 1, 6, 6}, false, false);
                templatePDF.createTable(getHabitantes(), 4, new float[]{1, 1, 6, 6}, false, false);
                templatePDF.createTable(getHistorialEscolar(), 4, new float[]{1, 1, 6, 6}, false, false);
                templatePDF.createTable(getHistorialLaboral(), 4, new float[]{1, 1, 6, 6}, false, false);
                templatePDF.createTable(getDatosAbandonoEstado(), 4, new float[]{1, 1, 6, 6}, false, false);
                templatePDF.createTable(getDatosSalud(), 4, new float[]{1, 1, 6, 6}, false, true);
                templatePDF.addColumnTextParagraph("OBSERVACIONES FINALES: " + lista.get(pos).getObservacionesF());
                templatePDF.addColumnTextImgQR();
                templatePDF.closeDocument();
                templatePDF.appViewPDF(this);
                break;
        }
    }
    //endregion

    private ArrayList<PdfPCell> getDatosGenerales() {
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Datos generales
        pdfPCell=new PdfPCell(new Phrase("DATOS GENERALES"));
        pdfPCell.setRowspan(44);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorGenerales);
        cells.add(pdfPCell);

        pdfPCell=new PdfPCell(new Phrase("DATOS PERSONALES"));
        pdfPCell.setRowspan(13);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e1_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getEntrevistado()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e1_2)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getAntecedentePenal()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e2)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getAlias()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e3)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getfNacimiento()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e4)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getEdad()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e5)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getlNacimiento()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e6)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getSexo()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e21_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getTieneDomicilioS()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e29)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE29()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e30)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE30()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e31)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE31()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e31_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getDelito()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e31_2)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getOtroDelito()));
        cells.add(pdfPCell);
        //endregion

        //region Domicilio
        pdfPCell=new PdfPCell(new Phrase("DOMICILIO"));
        pdfPCell.setRowspan(11);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e7)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE7()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e7_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE7_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e8)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE8()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e9)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE9()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e10)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE10()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e11)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE11()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e12)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE12()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e13)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE13()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e14)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE14()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e15)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE15()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e16)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE16()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("PADRES"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE32_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e17)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE17()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e18)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE18()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e19)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE19()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e20)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE20()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("DOMICILIO SECUNDARIO"));
        pdfPCell.setRowspan(10);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e21)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE21()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e22)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE22()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e23)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE23()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e24)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE24()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e25)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE25()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e26)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE26()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e27)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE27()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e28)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE28()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e21_2)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE21_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e21_3)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(addresses.get(pos).getE21_3()));
        cells.add(pdfPCell);
        //endregion

        //region Víctima
        pdfPCell=new PdfPCell(new Phrase("VÍCTIMA"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e101)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(victima.get(pos).getE101()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e102)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(victima.get(pos).getE102()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e103)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(victima.get(pos).getE103()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e104)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(victima.get(pos).getE104()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e105)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(victima.get(pos).getE105()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getHabitantes() {
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Datos Familiares y personas con las que habita el imputado
        pdfPCell=new PdfPCell(new Phrase("DATOS FAMILIARES Y PERSONAS CON LAS QUE HABITA EL IMPUTADO"));
        pdfPCell.setRowspan(42);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorHabitantes);
        cells.add(pdfPCell);

        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e32)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(habitantes.get(pos).getE32()));
        cells.add(pdfPCell);
        //region Persona 1
        pdfPCell=new PdfPCell(new Phrase("PERSONA 1"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e33)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE33()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e34)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE34()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e35)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE35()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e36)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE36()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e37)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE37()));
        cells.add(pdfPCell);
        //endregion
        //region Persona 2
        pdfPCell=new PdfPCell(new Phrase("PERSONA 2"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e33)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE33_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e34)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE34_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e35)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE35_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e36)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE36_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e37)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE37_1()));
        cells.add(pdfPCell);
        //endregion
        //region Persona 3
        pdfPCell=new PdfPCell(new Phrase("PERSONA 3"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e33)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE33_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e34)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE34_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e35)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE35_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e36)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE36_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e37)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE37_2()));
        cells.add(pdfPCell);
        //endregion
        //region Persona 4
        pdfPCell=new PdfPCell(new Phrase("PERSONA 4"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e33)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE33_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e34)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE34_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e35)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE35_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e36)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE36_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e37)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE37_3()));
        cells.add(pdfPCell);
        //endregion
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e38)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(habitantes.get(pos).getE38()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("DEPENDIENTES"));
        pdfPCell.setRowspan(6);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_2)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_3)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_4)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_4()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_5)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_5()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_6)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_6()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e32_7)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(habitantes.get(pos).getE32_7()));
        cells.add(pdfPCell);
        //endregion

        //region Referencias
        //region Referencia 1
        pdfPCell=new PdfPCell(new Phrase("REFERENCIA 1"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e39)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE39()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e40)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE40()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e41)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE41()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e42)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE42()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e43)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE43()));
        cells.add(pdfPCell);
        //endregion
        //region Referencia 2
        pdfPCell=new PdfPCell(new Phrase("REFERENCIA 2"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e39)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE39_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e40)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE40_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e41)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE41_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e42)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE42_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e43)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE43_1()));
        cells.add(pdfPCell);
        //endregion
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e44)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(referencias.get(pos).getE44()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("DOMICILIO"));
        pdfPCell.setRowspan(3);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorHabitantes));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e45)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE45()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e46)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE46()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e47)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(referencias.get(pos).getE47()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getHistorialEscolar() {
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Historial escolar
        pdfPCell=new PdfPCell(new Phrase("HISTORIAL ESCOLAR"));
        pdfPCell.setRowspan(3);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorEscolar);
        cells.add(pdfPCell);

        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e48)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE48()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e49)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE49()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e50)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE50()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getHistorialLaboral(){
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Historial laboral
        pdfPCell=new PdfPCell(new Phrase("HISTORIAL LABORAL OCUPACIONAL"));
        pdfPCell.setRowspan(11);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorOcupacional);
        cells.add(pdfPCell);

        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e51)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE51()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e52)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE52()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e53)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE53()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e54)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE54()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e55)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE55()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e57)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE57()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e56)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE56()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e56_1)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE56_1()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e58)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE58()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e51_1)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE51_1()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e59)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(historialEscolarLaboral.get(pos).getE59()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getDatosAbandonoEstado(){
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Información de facilidades para abandonar el estado
        pdfPCell=new PdfPCell(new Phrase("INFORMACIÓN DE FACILIDADES PARA ABANDONAR EL ESTADO"));
        pdfPCell.setRowspan(40);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorAbandono);
        cells.add(pdfPCell);

        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e60)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE60()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("VIAJADO AL EXTRANJERO"));
        pdfPCell.setRowspan(7);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e61)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE61()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e62)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE62()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e63)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE63()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e64)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE64()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e64_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE64_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65_1)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_1()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e65_2)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_2()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("VIAJADO DENTRO DEL LA REPÚBLICA"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65_3)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65_4)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_4()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65_5)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_5()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e65_6)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE65_6()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e66)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE66()));
        cells.add(pdfPCell);
        //region Familiar 1
        pdfPCell=new PdfPCell(new Phrase("FAMILIAR 1"));
        pdfPCell.setRowspan(6);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e67)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE67()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e68)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE68()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e69)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE69()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e70)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE70()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e71)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE71()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e72)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE72()));
        cells.add(pdfPCell);
        //endregion
        //region Familiar 2
        pdfPCell=new PdfPCell(new Phrase("FAMILIAR 2"));
        pdfPCell.setRowspan(6);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e67)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE67_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e68)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE68_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e69)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE69_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e70)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE70_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e71)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE71_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e72)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE72_1()));
        cells.add(pdfPCell);
        //endregion
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e73)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE73()));
        cells.add(pdfPCell);
        //region Familiar 1
        pdfPCell=new PdfPCell(new Phrase("FAMILIAR 1"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e74)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE74()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e75)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE75()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e76)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE76()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e77)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE77()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e78)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE78()));
        cells.add(pdfPCell);
        //endregion
        //region Familiar 2
        pdfPCell=new PdfPCell(new Phrase("FAMILIAR 2"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorAbandono));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e74)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE74_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e75)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE75_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e76)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE76_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e77)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE77_1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e78)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE78_1()));
        cells.add(pdfPCell);
        //endregion
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e79)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE79()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e80)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE80()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e81)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaAbandonoEstado.get(pos).getE81()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getDatosSalud() {
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Salud y condición física
        pdfPCell=new PdfPCell(new Phrase("SALUD Y CONDICIÓN FÍSICA"));
        pdfPCell.setRowspan(35);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorSalud);
        cells.add(pdfPCell);

        //region Alcohol
        pdfPCell=new PdfPCell(new Phrase("ALCOHOL"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e82)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE82()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_alcohol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_alcohol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_alcohol()));
        cells.add(pdfPCell);
        //endregion
        //region Tabaco
        pdfPCell=new PdfPCell(new Phrase("TABACO"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e83)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE83()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_tabaco()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_tabaco()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_tabaco()));
        cells.add(pdfPCell);
        //endregion
        //region Marihuana
        pdfPCell=new PdfPCell(new Phrase("MARIHUANA"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e84)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE84()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_marihuana()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_marihuana()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_marihuana()));
        cells.add(pdfPCell);
        //endregion
        //region Pastillas
        pdfPCell=new PdfPCell(new Phrase("PASTILLAS"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e85)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE85()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_pastillas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_pastillas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_pastillas()));
        cells.add(pdfPCell);
        //endregion
        //region Solventes
        pdfPCell=new PdfPCell(new Phrase("SOLVENTES"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e86)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE86()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_solventes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_solventes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_solventes()));
        cells.add(pdfPCell);
        //endregion
        //region Cristal
        pdfPCell=new PdfPCell(new Phrase("CRISTAL"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e87)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE87()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_cristal()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_cristal()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_cristal()));
        cells.add(pdfPCell);
        //endregion
        //region Cocaina
        pdfPCell=new PdfPCell(new Phrase("COCAINA"));
        pdfPCell.setRowspan(4);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e88)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE88()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_cocaina()));
        cells.add(pdfPCell);
        //endregion
        //region Otro consumo
        pdfPCell=new PdfPCell(new Phrase("OTRO CONSUMO"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorSalud));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e89)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE89()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e93)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE93_otroConsumo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e90)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE90_otroConsumo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e91)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE91_otroConsumo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e92)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(listaSalud.get(pos).getE92_otroConsumo()));
        cells.add(pdfPCell);
        //endregion
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e94)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaSalud.get(pos).getE94()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(getString(R.string.e95)));
        pdfPCell.setColspan(2);
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(listaSalud.get(pos).getE95()));
        cells.add(pdfPCell);
        //endregion

        return cells;
    }

    private ArrayList<PdfPCell> getHeader() {
        int pos = sName.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        pdfPCell=new PdfPCell(new Phrase("NOMBRE DEL EVALUADO"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getNombre()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("FECHA DE ENTREVISTA"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getfEntrevista()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("DURACIÓN ENTREVISTA"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getDuracionE() + " MINUTOS"));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("FOLIO"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getFolio()));
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase("ENTREVISTADOR"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell=new PdfPCell(new Phrase(lista.get(pos).getEntrevistador()));
        cells.add(pdfPCell);
        return cells;
    }

    //region Makes the color lighter to sue in the subsection of the report lighter
    public BaseColor lighter(BaseColor color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();

        return new BaseColor(r, g, b, TRANSPARENCY);
    }
    //endregion
}
