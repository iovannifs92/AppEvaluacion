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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

import net.glxn.qrgen.android.QRCode;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import com.sistemas.evaluacion.entidades.datosEntrevistadorA;
import com.sistemas.evaluacion.entidades.datosGeneralesA;
import com.sistemas.evaluacion.entidades.datosResponsablesA;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosFamiliaresA;
import com.sistemas.evaluacion.entidades.datosDependientesEconomicosA;
import com.sistemas.evaluacion.entidades.datosHistorialEscolarA;
import com.sistemas.evaluacion.entidades.datosHistorialLaboralA;
import com.sistemas.evaluacion.entidades.datosActividadesExtraescolaresA;
import com.sistemas.evaluacion.entidades.datosRevisionMedicaA;
import com.sistemas.evaluacion.entidades.datosConsumoSustanciasA;

public class ReporteAdolescentes extends AppCompatActivity implements View.OnClickListener {

    //region Variables Globales
    private LinearLayout llControl1;
    private TextView tvControl1;
    private Button btnGenerarReporte1;
    private Spinner sName1;
    private TemplatePDF templatePDF1;
    private String folio1;
    private static final int TRANSPARENCY = 128;

    private BaseColor lightGray = new BaseColor(230, 230, 230);
    private BaseColor colorGenerales = new BaseColor(0, 120, 167);
    private BaseColor colorVinculos = new BaseColor(65, 86, 103);
    private BaseColor colorEscolar = new BaseColor(128, 174, 171);
    private BaseColor colorOcupacional = new BaseColor(35, 52, 96);
    private BaseColor colorAbandono = new BaseColor(55, 52, 53);
    private BaseColor colorSalud = new BaseColor(169, 208, 142);

      private ArrayList<datosEntrevistadorA> entrevistador;
      private ArrayList<datosResponsablesA> responsables;
      private ArrayList<datosGeneralesA> lista1;
      private ArrayList<datosFichaFamiliarA> ficha;
      private ArrayList<datosFamiliaresA> familiares;
      private ArrayList<datosDependientesEconomicosA> economicos;
      private ArrayList<datosHistorialEscolarA> escolar;
      private ArrayList<datosHistorialLaboralA> laboral;
      private ArrayList<datosActividadesExtraescolaresA> extraescolares;
      private ArrayList<datosRevisionMedicaA> revision;
      private ArrayList<datosConsumoSustanciasA> consumo;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_adolescentes);

        MyOpenHelper db;
        db = new MyOpenHelper(this);
        db.getReadableDatabase();

         entrevistador = db.getdatosEntrevistadorA();
         responsables = db.getdatosResponsablesA();
         lista1 = db.getdatosGeneralesA();
         ficha = db.getdatosFichaFamiliarA();
         familiares = db.getdatosFamiliaresA();
         economicos = db.getdatosDependientesEconomicosA();
         escolar = db.getdatosHistorialEscolarA();
         laboral = db.getdatosHistorialLaboralA();
         extraescolares = db.getdatosActividadesExtraescolaresA();
         revision = db.getdatosRevisionMedicaA();
         consumo = db.getdatosConsumoSustanciasA();

        //region Inicializa un spinner con los nombres de los entrevistados
        sName1 = (Spinner) findViewById(R.id.sName1);
        String[] names = new String[lista1.size()];
        for (int i = 0; i < lista1.size(); i++) {
            names[i] = lista1.get(i).getAnombre();
        }
        sName1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, names));
        //endregion

        //region Verificar si hay registros
        if (lista1.isEmpty() == false) {
            sName1.setSelection(lista1.size() -1);

            tvControl1 = (TextView) findViewById(R.id.tvControl1);
            llControl1 = (LinearLayout) findViewById(R.id.llControl1);

            llControl1.setVisibility(View.VISIBLE);
            tvControl1.setVisibility(View.GONE);
        }
        //endregion

        //region setOnItemSelectedListener
        sName1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        btnGenerarReporte1 = (Button) findViewById(R.id.btnGenerarReporte1);
        btnGenerarReporte1.setOnClickListener(this);
    }

    //region Create and display the report in PDF format
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGenerarReporte1:
                int pos = sName1.getSelectedItemPosition();
                folio1 = lista1.get(pos).getAfolio();

                //region Generar Código QR
                String texto = folio1;
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

                templatePDF1 = new TemplatePDF(getApplicationContext());
                templatePDF1.openDocument();
                templatePDF1.addImgName();
                templatePDF1.addMetaData("ENTREVISTA ADOLESCENTES", "FOLIO", "SCORPION");
                templatePDF1.addColumnTextTitles("ENTREVISTA ADOLESCENTES\n", "", fecha + "\n");

                  templatePDF1.createTable(getDatosEntrevistadorA(), 2, new float[]{1, 1});
                  templatePDF1.createTable(getDatosResponsablesA(), 2, new float[]{1, 1});
                  templatePDF1.createTable(getDatosGeneralesA(), 4, new float[]{1, 1, 6, 6});
                  templatePDF1.createTable(getDatosVinculosA(), 4, new float[]{1, 1, 6, 6});
                  templatePDF1.createTable(getDatosConsideracionesA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosFamiliaresA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosDependientesEconomicosA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosHistorialEconomicoA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosDependientesLaboralA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosDependientesEscolarA(), 4, new float[]{1, 1, 6, 6});
                //templatePDF1.createTable(getDatosActividadesExtraescolaresA(), 4, new float[]{1, 1, 6, 6});
                templatePDF1.addColumnTextParagraph("OBSERVACIONES FINALES: " + lista1.get(pos).getAtraductor());
                templatePDF1.addColumnTextImgQR();
                templatePDF1.closeDocument();
                templatePDF1.appViewPDF(this);
                break;
        }
    }

      private ArrayList<PdfPCell> getDatosEntrevistadorA() {
        int pos = sName1.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        pdfPCell = new PdfPCell(new Phrase("NUMERO DE CAUSA"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(entrevistador.get(pos).getAcausa()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("FECHA DE ENTREVISTA"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(entrevistador.get(pos).getAfecha()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("EVALUADOR"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(entrevistador.get(pos).getAevaluador()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("FOLIO"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(entrevistador.get(pos).getAfolio()));
        cells.add(pdfPCell);
        return cells;
    }

    private ArrayList<PdfPCell> getDatosResponsablesA() {
        int pos = sName1.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        pdfPCell = new PdfPCell(new Phrase("¿PROPORCIONA CONSENTIMIENTO?"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getAconsetimiento()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("NOMBRE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getAnombre1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("RELACION CON EL ADOLESCENTE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getArelacion1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("PARTICIPANTE/OYENTE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getAoyente1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("NOMBRE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getAnombre2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("RELACION CON EL ADOLESCENTE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getArelacion2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase("PARTICIPANTE/OYENTE"));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(responsables.get(pos).getAoyente2()));
        cells.add(pdfPCell);
        return cells;
    }

    private ArrayList<PdfPCell> getDatosGeneralesA() {
        int pos = sName1.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Datos generales
        pdfPCell = new PdfPCell(new Phrase("DATOS GENERALES"));
        pdfPCell.setRowspan(58);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorGenerales);
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("DATOS PERSONALES"));
        pdfPCell.setRowspan(12);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e_134)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getApaterno()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e_135)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAmaterno()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e136)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAnombre()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e137)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAsexo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e138)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAedad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e139)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAfechanac()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e140)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAcurp()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e141)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAlugarnac()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e142)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAestado()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e143)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAmunicipio()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e144)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAlocalidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e145)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAnacionalidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e146)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAespanol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e147)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(lista1.get(pos).getAtraductor()));
        cells.add(pdfPCell);

        //endregion
        pdfPCell = new PdfPCell(new Phrase("FICHA FAMILIAR"));
        pdfPCell.setRowspan(16);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e149)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAcalle()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e150)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAnumero()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e151)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAcolonia()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e_151)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAnombrecol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e152)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAcp()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e153)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAmunicipio()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e154)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAestado()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e155)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getApais()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e156)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAtemporalidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e157)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAdomiciliof()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e158)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAdomicilioant()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e159)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAlocalidad1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e160)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAtemporalidadant1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e159)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAlocalidad2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e160)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAtemporalidadant2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e159)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAlocalidad3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e160)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(ficha.get(pos).getAtemporalidadant3()));
        cells.add(pdfPCell);

        //endregion
        pdfPCell = new PdfPCell(new Phrase("DATOS FAMILIARES PRIMARIOS"));
        pdfPCell.setRowspan(14);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e161)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAnombre1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e162)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getArelacion1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e163)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAedad1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e164)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAtelefono1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e165)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAvivecon1()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e161)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAnombre2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e162)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getArelacion2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e163)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAedad2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e164)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAtelefono2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e165)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAvivecon2()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e166)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAubicarfam()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e167)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAnombrefam()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e168)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getArelacionfam()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e169)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(familiares.get(pos).getAlocalidadfam()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("DEPENDIENTES ECONOMICOS"));
        pdfPCell.setRowspan(16);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e170)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAdependientes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e171)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAnombre1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e172)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getArelacion1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e173)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAedad1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e174)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAtelefono1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e175)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAresponsable1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e171)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAnombre2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e172)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getArelacion2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e173)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAedad2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e174)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAtelefono2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e175)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAresponsable2()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e171)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAnombre3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e172)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getArelacion3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e173)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAedad3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e174)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAtelefono3()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e175)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(economicos.get(pos).getAresponsable3()));
        cells.add(pdfPCell);
        return cells;
    }
    private ArrayList<PdfPCell> getDatosVinculosA() {
        int pos = sName1.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Datos generales
        pdfPCell = new PdfPCell(new Phrase("VINCULOS COMUNITARIOS"));
        pdfPCell.setRowspan(31);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorGenerales);
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("HISTORIAL ESCOLAR"));
        pdfPCell.setRowspan(13);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e177)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAasiste()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e178)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAconcluyo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e180)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAnombreact()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e181)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAdireccionact()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e182)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAtelefonoact()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e183)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAnivelact()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e184)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAgrado()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e186)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAnombreant1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e187)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAlocalidad1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e188)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(escolar.get(pos).getAgradoant1()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e186)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);

        //endregion
        pdfPCell = new PdfPCell(new Phrase("HISTORIAL LABORAL"));
        pdfPCell.setRowspan(13);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e190)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAtrabaja()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e191)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getArecurrente()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e193)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAnombre()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e194)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAdireccion()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e195)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAtelefono()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e196)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAantiguedad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e197)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAtiempo()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e198)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAjefe()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e199)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAtrabajoant()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e200)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAnombreant()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e201)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAlocalidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e202)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAatiguedadant()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e203)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(laboral.get(pos).getAtelefonoant()));
        cells.add(pdfPCell);

        //endregion
        pdfPCell = new PdfPCell(new Phrase("ACTIVIDADES EXTRAESCOLARES ACTUALES"));
        pdfPCell.setRowspan(5);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e205)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(extraescolares.get(pos).getArealiza()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e206)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(extraescolares.get(pos).getAactividad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e207)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(extraescolares.get(pos).getAlocalidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e208)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(extraescolares.get(pos).getAcontacto()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e209)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(extraescolares.get(pos).getAtelefono()));
        cells.add(pdfPCell);
        return cells;
    }
    private ArrayList<PdfPCell> getDatosConsideracionesA() {
        int pos = sName1.getSelectedItemPosition();

        ArrayList<PdfPCell> cells = new ArrayList<>();
        PdfPCell pdfPCell;

        //region Datos generales
        pdfPCell = new PdfPCell(new Phrase("CONSIDERACIOES EXCEPCIONALES SOBRE LA PERSONA ADOLESCENTE"));
        pdfPCell.setRowspan(36);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(colorGenerales);
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase("CONSIDERACIONES"));
        pdfPCell.setRowspan(7);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e211)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAembarazada()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e212)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAmadre()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e213)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAenfermendad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e213)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAcual()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e214)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAdiscapacidad()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e215)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAmedicamento()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e216)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(revision.get(pos).getAentrevistador()));
        cells.add(pdfPCell);

        //endregion
        pdfPCell = new PdfPCell(new Phrase("CONSUMO DE SUSTANCIAS"));
        pdfPCell.setRowspan(29);
        pdfPCell.setRotation(90);
        pdfPCell.setBackgroundColor(lighter(colorGenerales));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_alcohol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_alcohol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_alcohol()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_alcohol()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_tabaco()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_tabaco()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_tabaco()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_tabaco()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_marihuana()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_marihuana()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_marihuana()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_marihuana()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_pastillas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_pastillas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_pastillas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_pastillas()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_solventes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_solventes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_solventes()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_solventes()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_metanfetaminas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_metanfetaminas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_metanfetaminas()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_metanfetaminas()));
        cells.add(pdfPCell);

        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e301)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsume_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3010)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAcantidad_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e309)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAfrecuencia_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3011)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAultimo_consumo_cocaina()));
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(getString(R.string.e3012)));
        pdfPCell.setBackgroundColor(lightGray);
        cells.add(pdfPCell);
        pdfPCell = new PdfPCell(new Phrase(consumo.get(pos).getAconsumemas()));
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

