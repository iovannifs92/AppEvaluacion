package com.sistemas.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class encuesta extends AppCompatActivity {
    private MyOpenHelper db;
    private ArrayList<Comentario> lista;
    private Comentario c;

    EditText fecha, txt3Ubicacion, txt4CP, txt8Experiencia, txt19, txt20, txt21a, txt22a, txt24, txtuniun ;
    TextView tvEstudio, tv21a, tv22a;
    ImageButton btnFecha;
    Spinner municipios, sEstudio,s9, s10, s11, s12, s13, s14, s15, s16, s17, s21, s22, s23, s25;
    CheckBox cb18a, cb18b, cb18c, cb18d, cb18e, cb18f, cb18g, cb18h, cb18i, cb18j;
    String [] strSpinner={"MUY BAJA","BAJA","MEDIA", "ALTA","MUY ALTA", "NO SABE"};

    String r1="", r2="", r3="NC", r4="NC", r5="", r6="", r7, r8="", r8a="NA", r9="", r10="",
            r11="", r12="", r13="", r14="", r15="", r16="", r17="", r18a="0,", r18b="0,", r18c="0,", r18d="0,", r18e="0,", r18f="0,",
            r18g="0,", r18h="0,", r18i="0,", r18j="0,",r19="NA", r20="NA", r21="", r21a="NA", r22="", r22a="NA", r23="", r24="NC", r25="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        db=new MyOpenHelper(this);

        //region Formulario
        fecha=(EditText) findViewById(R.id.fecha);
        //Iniciamos el controlador de la base de datos


        //region 1. Fecha
        SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yyyy_HHmmss", Locale.getDefault());
        String fechaFormato=formatoFecha.format(Calendar.getInstance().getTime());
        fecha.setText(fechaFormato);
        r1=fecha.getText().toString();
        //endregion

        //region 2.Municipios
        final Spinner municipios=(Spinner) findViewById(R.id.sMunicipio);
        String [] municipiosDurango={"CANATLÁN","CANELASCONETO DE COMONFORT","CUENCAMÉ","DURANGO","EL ORO","GÓMEZ PALACIO","GENERAL  SIMÓN BOLÍVAR","GUADALUPE VICTORIA","GUANACEVÍ","HIDALGO","INDÉ","LERDO","MAPIMÍ","MEZQUITAL","NAZAS","NOMBRE DE DIOS","NUEVO IDEAL","OCAMPO","OTÁEZ","PÁNUCO DE CORONADO","PEÑÓN BLANCO","POANAS","PUEBLO NUEVO","RODEO","SAN BERNARDO","SAN DIMAS","SAN JUAN DE GUADALUPE","SAN JUAN DEL RÍO","SAN LUIS DEL CORDERO","SAN PEDRO DEL GALLO","SANTA CLARA","SANTIAGO PAPASQUIARO","SÚCHIL","TAMAZULA","TEPEHUANES","TLAHUALILO","TOPIA","VICENTE GUERRERO"};
        municipios.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,municipiosDurango));
        r2=municipios.getSelectedItem().toString();
        municipios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r2=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //endregion

        //region 3. Ubicación
        txt3Ubicacion=(EditText) findViewById(R.id.txt3Ubicacion);
        //r3=txt3Ubicacion.getText().toString();
        txt3Ubicacion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r3=txt3Ubicacion.getText().toString();
            }
        });
        //endregion

        //region 4. Codigo Postal
        txt4CP=(EditText) findViewById(R.id.txt4CP);
        //r4=txt4CP.getText().toString();

        txt4CP.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                r4=txt4CP.getText().toString();
            }
        });
        //endregion

        //region 5 - 6
        r5="Brigadista Android";

        r6="Brigada de Android";
        //endregion

        //region 8. Tuvo la oportunidad de estudiar ¿Cual fue su experiencia?
        final Spinner estudio=(Spinner) findViewById(R.id.sEstudio);
        String [] opcionEstudio={"NO","SI"};
        estudio.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opcionEstudio));

        tvEstudio= (TextView) findViewById(R.id.tvEstudio);
        txt8Experiencia=(EditText) findViewById(R.id.txt8Experiencia);
        r8=estudio.getSelectedItem().toString();


        estudio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r8=estudio.getSelectedItem().toString();
                String selectedItem= parent.getSelectedItem().toString();
                if (selectedItem=="SI"){
                    tvEstudio.setVisibility(View.VISIBLE);
                    txt8Experiencia.setVisibility(View.VISIBLE);
                }
                else{
                    tvEstudio.setVisibility(View.GONE);
                    txt8Experiencia.setVisibility(View.GONE);
                    r8a="NA";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });
        //r8a=txt8Experiencia.getText().toString();

        txt8Experiencia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r8a=txt8Experiencia.getText().toString();
            }
        });
        //endregion

        //region 9.
        Spinner s9=(Spinner) findViewById(R.id.s9);
        s9.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strSpinner));
        r9=s9.getSelectedItem().toString();

        s9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r9=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 10
        Spinner s10=(Spinner) findViewById(R.id.s10);
        s10.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strSpinner));
        r10=s10.getSelectedItem().toString();
        s10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r10=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 11
        Spinner s11=(Spinner) findViewById(R.id.s11);
        s11.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strSpinner));
        r11=s11.getSelectedItem().toString();
        s11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r11=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 12
        Spinner s12=(Spinner) findViewById(R.id.s12);
        s12.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strSpinner));
        r12=s12.getSelectedItem().toString();

        s12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r12=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 13
        Spinner s13=(Spinner) findViewById(R.id.s13);
        String [] p13={"1. Fortalecer la educación inicial (0 a 3 años)","2. Brindar apoyos a las escuelas multigrado (que con un maestro atiendan a diversos grados", "3. Crear más escuelas de tiempo completo", "4. Apoyar a los alumnos con discapacidad","5. Construir nuevas universidades en municipios de alta marginación", "6. No sabe"};
        s13.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p13));
        r13=s13.getSelectedItem().toString();

        s13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r13=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 14
        Spinner s14=(Spinner) findViewById(R.id.s14);
        String [] p14={"1. Fortalecer las escuelas normales y la Universidad Pedagógica Nacional ","2. Elaborar un plan educativo con la participación de padres de familia, maestros, directores, supervisores y expertos ", "3. Revalorar socialmente al magisterio y respetar su independencia y autonomía ", "4. Impulsar la educación indígena con pleno respeto a sus formas de organización ","5. Dar cabida a la diversidad retomando las alternativas de educación que proponga cada Estado", "6. No sabe"};
        s14.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p14));
        r14=s14.getSelectedItem().toString();

        s14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r14=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 15
        Spinner s15=(Spinner) findViewById(R.id.s15);
        String [] p15={"1. Proveer de alimentos a todas las escuelas de educación básica de zonas marginadas  ","2. Otorgar una beca mensual a todos los estudiantes de nivel medio superior y una beca a los estudiantes de nivel superior de escasos recursos", "3. Garantizar que ningún estudiante sea rechazado en las universidades públicas ", "4. Suspender las cuotas para el mantenimiento de las escuelas, e invertir recursos públicos en la infraestructura educativa  ","5. Hacer realidad el internet público gratuito y darle acceso a maestros y estudiantes ", "6. No sabe"};
        s15.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p15));
        r15=s15.getSelectedItem().toString();

        s15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r15=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 16
        Spinner s16=(Spinner) findViewById(R.id.s16);
        String [] p16={"1. Promover la formación y actualización de docentes  ","2. Apoyar a las familias de los alumnos para que no abandonen la escuela", "3. Fortalecer el liderazgo de directores y supervisores", "4. Incorporar la educación artística  ","5. Incorporar las tecnologías al proceso educativo ", "6. Dotar de director y docentes a escuelas multigrado", "7. Atender las condiciones materiales de las escuelas"};
        s16.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p16));
        r16=s16.getSelectedItem().toString();

        s16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r16=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 17
        Spinner s17=(Spinner) findViewById(R.id.s17);
        String [] p17={"1. Ampliar la " +
                "oferta de materiales para los docentes","2. Multiplicar los cursos en línea", "3. Fomentar la autoevaluación entre los docentes", "4. Impartir más cursos presenciales","5. Promover investigación educativa que identifique las necesidades de formación ", "6. Estimular el estudio compartido", "7. Generar espacios de diálogo en el seno de los colectivos docentes"};
        s17.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p17));
        r17=s17.getSelectedItem().toString();

        s17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r17=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        // region 18
        cb18a=(CheckBox) findViewById(R.id.cb18a);
        cb18b=(CheckBox) findViewById(R.id.cb18b);
        cb18c=(CheckBox) findViewById(R.id.cb18c);
        cb18d=(CheckBox) findViewById(R.id.cb18d);
        cb18e=(CheckBox) findViewById(R.id.cb18e);
        cb18f=(CheckBox) findViewById(R.id.cb18f);
        cb18g=(CheckBox) findViewById(R.id.cb18g);
        cb18h=(CheckBox) findViewById(R.id.cb18h);
        cb18i=(CheckBox) findViewById(R.id.cb18i);
        cb18j=(CheckBox) findViewById(R.id.cb18j);
        //endregion

        //region 19
        final EditText txt19=(EditText) findViewById(R.id.txt19);
        //r19=txt19.getText().toString();
        txt19.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r19=txt19.getText().toString();
            }
        });
        //endregion

        //region 20
        final EditText txt20=(EditText) findViewById(R.id.txt20);
        //r20=txt20.getText().toString();

        txt20.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r20=txt20.getText().toString();
            }
        });
        //endregion

        //region 21
        Spinner s21=(Spinner) findViewById(R.id.s21);
        String [] p21={"1. Poco importante  ","2. Algo importante", "3. Importante", "4. Muy importante  ","5.Otro comentario"};
        s21.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p21));
        tv21a=(TextView) findViewById(R.id.tv21a);
        txt21a=(EditText) findViewById(R.id.txt21a);
        r21=s21.getSelectedItem().toString();

        s21.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r21=parent.getSelectedItem().toString();
                String selectedItem= parent.getSelectedItem().toString();
                if (selectedItem=="5.Otro comentario"){
                    tv21a.setVisibility(View.VISIBLE);
                    txt21a.setVisibility(View.VISIBLE);
                }
                else{
                    tv21a.setVisibility(View.GONE);
                    txt21a.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //r21a=txt21a.getText().toString();
        txt21a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r21a=txt21a.getText().toString();
            }
        });
        //endregion

        //region 22
        Spinner s22=(Spinner) findViewById(R.id.s22);
        String [] p22={"1. Sin estudios  ","2. Primaria", "3. Secundaria", "4. Estudios  Técnicos  ","5. Preparatoria", "6. Licenciatura", "7. Maestría", "8. Doctorado"};
        s22.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p22));
        tv22a=(TextView) findViewById(R.id.tv22a);
        txt22a=(EditText) findViewById(R.id.txt22a);
        //r22=s22.getSelectedItem().toString();

        s22.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r22=parent.getSelectedItem().toString();
                String selectedItem= parent.getSelectedItem().toString();
                if ((selectedItem=="6. Licenciatura")||(selectedItem=="7. Maestría")||(selectedItem=="8. Doctorado")){
                    tv22a.setVisibility(View.VISIBLE);
                    txt22a.setVisibility(View.VISIBLE);
                }
                else{
                    tv22a.setVisibility(View.GONE);
                    txt22a.setVisibility(View.GONE);
                    r22a="NA";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        });

        //r22a=txt22a.getText().toString();
        txt22a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r22a=txt22a.getText().toString();
            }
        });
        //endregion

        //region 23
        Spinner s23=(Spinner) findViewById(R.id.s23);
        String [] p23={"Hombre","Mujer"};
        s23.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p23));
        r23=s23.getSelectedItem().toString();
        s23.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r23=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //region 24
        txt24= (EditText) findViewById(R.id.txt24);
        //r24=txt24.getText().toString();

        txt24.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                r24=txt24.getText().toString();
            }
        });
        //endregion

        //region 25
        Spinner s25=(Spinner) findViewById(R.id.s25);
        String [] p25={"1. Funcionarios","2. Trabajadores Auxiliares","3. Comerciantes", "4. Seguridad", "5. Agropecuarias", "6. Artesanos", "7. Operadores Maquinaria", "8. Otros"};
        s25.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,p25));
        r25=s25.getSelectedItem().toString();

        s25.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                r25=parent.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion

        //endregion

        Button btnGuardar =(Button) findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String r18=r18a+r18b+r18c+r18d+r18e+r18f+r18g+r18h+r18i+r18j;
                db.insertar(r1,r2, r3, r4, r5, r6, r8, r8a, r9, r10,
                        r11, r12, r13, r14, r15, r16, r17, r18, r19, r20,
                        r21, r21a, r22, r22a, r23, r24, r25);
                Toast.makeText(getApplicationContext(),"Datos Guardados", Toast.LENGTH_SHORT).show();

                Intent intent= new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });





    }


    public void onCheckboxClicked(View view){
        boolean checked=((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.cb18a:
                if (checked){
                    r18a="Falta de electricidad / Apagones,";
                }
                else{
                    r18a="0,";
                }
                break;
            case R.id.cb18b:
                if (checked){
                    r18b="Falta de agua potable,";
                }
                else{
                    r18b="0,";
                }
                break;
            case R.id.cb18c:
                if (checked){
                    r18c="Falta de seguridad dentro de la escuela,";
                }
                else{
                    r18c="0,";
                }
                break;
            case R.id.cb18d:
                if (checked){
                    r18d="Falta de materiales didácticos,";
                }
                else{
                    r18d="0,";
                }
                break;
            case R.id.cb18e:
                if (checked){
                    r18e="Falta de mobiliario escolar,";
                }
                else{
                    r18e="0,";
                }
                break;
            case R.id.cb18f:
                if (checked){
                    r18f="Falta de baños,";
                }
                else{
                    r18f="0,";
                }
                break;
            case R.id.cb18g:
                if (checked){
                    r18g="Falta de aulas,";
                }
                else{
                    r18g="0,";
                }
                break;
            case R.id.cb18h:
                if (checked){
                    r18h="Falta de Mantenimiento,";
                }
                else{
                    r18h="0,";
                }
                break;
            case R.id.cb18i:
                if (checked){
                    r18i="Reconstrucción después de los sismos,";
                }
                else{
                    r18i="0,";
                }
                break;
            case R.id.cb18j:
                if (checked){
                    r18j="Falta de drenaje,";
                }
                else{
                    r18j="0,";
                }
                break;
        }
    }

}
