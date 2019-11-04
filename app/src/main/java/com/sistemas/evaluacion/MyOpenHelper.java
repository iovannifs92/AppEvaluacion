package com.sistemas.evaluacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import com.sistemas.evaluacion.entidades.datosASSIST;
import com.sistemas.evaluacion.entidades.datosEntrevistador;
import com.sistemas.evaluacion.entidades.datosAbandonoEstado;
import com.sistemas.evaluacion.entidades.datosEscolarLaboral;
import com.sistemas.evaluacion.entidades.datosEvaluacion;
import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.datosDomicilio;
import com.sistemas.evaluacion.entidades.datosHabitantes;
import com.sistemas.evaluacion.entidades.datosObservaciones;
import com.sistemas.evaluacion.entidades.datosReferencias;
import com.sistemas.evaluacion.entidades.datosSalud;
import com.sistemas.evaluacion.entidades.datosVictima;
import com.sistemas.evaluacion.entidades.datosCarpetaInvestigacion;
import com.sistemas.evaluacion.entidades.datosEntrevistadorA;
import com.sistemas.evaluacion.entidades.datosResponsablesA;
import com.sistemas.evaluacion.entidades.datosGeneralesA;
import com.sistemas.evaluacion.entidades.datosFichaFamiliarA;
import com.sistemas.evaluacion.entidades.datosFamiliaresA;
import com.sistemas.evaluacion.entidades.datosDependientesEconomicosA;
import com.sistemas.evaluacion.entidades.datosActividadesExtraescolaresA;
import com.sistemas.evaluacion.entidades.datosRevisionMedicaA;
import com.sistemas.evaluacion.entidades.datosConsumoSustanciasA;

public class MyOpenHelper extends SQLiteOpenHelper {

    //region Crear Tablas
    //region Tabla comments
    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, r1 TEXT, r2 TEXT, " +
            "r3 TEXT, r4 TEXT, r5 TEXT, r6 TEXT, r8 TEXT, r8a TEXT, r9 TEXT, r10 TEXT, r11 TEXT, r12 TEXT, r13 TEXT, r14 TEXT, r15 TEXT, " +
            "r16 TEXT, r17 TEXT, r18 TEXT, r19 TEXT, r20 TEXT, r21 TEXT, r21a TEXT,r22 TEXT, r22a TEXT, r23 TEXT, r24 TEXT, r25 TEXT)";
    //endregion

    //region Tabla imputado_datos_generales
    private static final String CREATE_TABLE_IMPUTADO_DATOS_GENERALES = "CREATE TABLE imputado_datos_generales(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "Nombre TEXT, Alias TEXT, FNacimiento TEXT, Edad TEXTO, LNacimiento TEXT, Sexo TEXT, Folio TEXT, FEntrevista TEXT, DuraciónE INTEGER, Entrevistador TEXT, " +
            "ObservacionesF TEXT, Tipo TEXT, ASSIST TEXT, TieneVerificacion TEXT, TieneEvaluacion TEXT, TieneDomicilioS TEXT, OtrosHabitantes TEXT, " +
            "Entrevistada TEXT, AntecedentePenal TEXT, Delito TEXT, OtroDelito TEXT, CarpetaInvestigacion TEXT)";
    //endregion

    //region Tabla imputado_datos_domicilio
    private static final String CREATE_TABLE_IMPUTADO_DATOS_DOMICILIO="CREATE TABLE imputado_datos_domicilio (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e7 TEXT, e7_1 TEXT, e8 TEXT, e9 TEXT, e10 TEXT, e11 TEXT, e12 TEXT, e13 TEXT, e14 TEXT, e15 TEXT, e16 TEXT, e32_1 TEXT, e17 TEXT, e18 TEXT, " +
            "e19 TEXT, e20 TEXT, e21 TEXT, e22 TEXT, e23 TEXT, e24 TEXT, e25 TEXT, e26 TEXT, e27 TEXT, e28 TEXT, e21_2 TEXT, e21_3 TEXT, e29 TEXT, " +
            "e30 TEXT, e31 TEXT, e106 TEXT, e107 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_familiares
    private static final String CREATE_TABLE_IMPUTADO_DATOS_HABITANTES="CREATE TABLE imputado_datos_habitantes (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "e32 TEXT, e33 TEXT, e34 TEXT, e35 TEXT, e36 TEXT, e37 TEXT, e33_1 TEXT, e34_1 TEXT, e35_1 TEXT, e36_1 TEXT, e37_1 TEXT, " +
            "e33_2 TEXT, e34_2 TEXT, e35_2 TEXT, e36_2 TEXT, e37_2 TEXT, e33_3 TEXT, e34_3 TEXT, e35_3 TEXT, e36_3 TEXT, e37_3 TEXT, e38 TEXT, " +
            "e32_2 TEXT, e32_3 TEXT, e32_4 TEXT, e32_5 TEXT, e32_6 TEXT, e32_7 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_referencias
    private static final String CREATE_TABLE_IMPUTADO_DATOS_REFERENCIAS="CREATE TABLE imputado_datos_referencias(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e39 TEXT, e40 TEXT, e41 TEXT, e42 TEXT, e43 TEXT, e39_1 TEXT, e40_1 TEXT, e41_1 TEXT, e42_1 TEXT, e43_1 TEXT, e44 TEXT, e45 TEXT," +
            "e46 TEXT, e47 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_historial_escolar_laboral
    private static final String CREATE_TABLE_IMPUTADO_HISTORIAL_ESCOLAR_LABORAL="CREATE TABLE imputado_datos_historial_escolar_laboral (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e48 TEXT, e49 TEXT, e50 TEXT, e51 TEXT, e52 TEXT, e53 TEXT, e54 TEXT, e55 TEXT, e56 TEXT, e56_1 TEXT, e57 TEXT, e58 TEXT, e51_1 TEXT, e59 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_abandono_estado
    private static final String CREATE_TABLE_IMPUTADO_ABANDONO_ESTADO="CREATE TABLE imputado_datos_abandono_estado (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e60 TEXT, e61 TEXT, e62 TEXT, e63 TEXT, e64 TEXT, e64_1 TEXT, e65 TEXT, e65_1 TEXT, e65_2 TEXT, e65_3 TEXT, e65_4 TEXT, e65_5 TEXT, " +
            "e65_6 TEXT, e66 TEXT, e67 TEXT, e68 TEXT, e69 TEXT, e70 TEXT, e71 TEXT, e72 TEXT, e67_1 TEXT, e68_1 TEXT, e69_1 TEXT, e70_1 TEXT, " +
            "e71_1 TEXT, e72_1 TEXT, e73 TEXT, e74 TEXT, e75 TEXT, e76 TEXT, e77 TEXT, e78 TEXT, e74_1 TEXT, e75_1 TEXT, e76_1 TEXT, e77_1 TEXT, " +
            "e78_1 TEXT, e79 TEXT, e80 TEXT, e81 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_salud
    private static final String CREATE_TABLE_IMPUTADO_SALUD="CREATE TABLE imputado_datos_salud (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "e82 TEXT, e90_alcohol TEXT, e91_alcohol TEXT, e92_alcohol TEXT, e83 TEXT, e90_tabaco TEXT, e91_tabaco TEXT, e92_tabaco TEXT," +
            "e84 TEXT, e90_marihuana TEXT, e91_marihuana TEXT, e92_marihuana TEXT, e85 TEXT, e90_pastillas TEXT, e91_pastillas TEXT, e92_pastillas TEXT," +
            "e86 TEXT, e90_solventes TEXT, e91_solventes TEXT, e92_solventes TEXT, e87 TEXT, e90_cristal TEXT, e91_cristal TEXT, e92_cristal TEXT," +
            "e88 TEXT, e90_cocaina TEXT, e91_cocaina TEXT, e92_cocaina TEXT, e89 TEXT, e93_otroConsumo TEXT, e90_otroConsumo TEXT, e91_otroConsumo TEXT, e92_otroConsumo TEXT," +
            "e94 TEXT, e95 TEXT, Folio TEXT)";
    //endregion

    //region Tabla verificacion_observaciones
    private static final String CREATE_TABLE_VERIFICACION_OBSERVACIONES="CREATE TABLE verificacion_observaciones (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Campo TEXT, Observacion TEXT, Original TEXT, Folio TEXT)";
    //endregion

    //region Tabla verificacion_entrevistado
    private static final String CREATE_TABLE_VERIFICACION_ENTREVISTADO="CREATE TABLE verificacion_entrevistado (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "VEntrevistado TEXT, VRelacion TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_victima
    private static final String CREATE_TABLE_IMPUTADO_DATOS_VICTIMA="CREATE TABLE imputado_datos_victima(_id INTEGER PRIMARY KEY AUTOINCREMENT, e101 TEXT, e102 TEXT, e103 TEXT, e104 TEXT, e105 TEXT, Folio TEXT)";
    //endregion

    //region Tabla assist
    private static final String CREATE_TABLE_ASSIST="CREATE TABLE assist(_id INTEGER PRIMARY KEY AUTOINCREMENT, Pa INT, Pb TEXT, Pc TEXT, Pd TEXT," +
            "Pe TEXT, Pf TEXT, Pg TEXT, Ph TEXT, Pi TEXT, Pj TEXT, JOtro TEXT, e8 TEXT, Folio TEXT)";
    //endregion

    //TODO: agregar tabla a sincronizadb
    //region Tabla eva_riesgos
    private static final String CREATE_TABLE_EVA_RIESGOS="CREATE TABLE eva_riesgos(_id INTEGER PRIMARY KEY AUTOINCREMENT, Arraigo INTEGER, ResidenciaEdo INTEGER," +
            " AbandonoEdo INTEGER, VoluntadSometimiento INTEGER, Antecedentes INTEGER, MedidasNoPrivativas INTEGER, Escala INTEGER, Folio TEXT)";
    //endregion

    //region Tabla entrevistador
    private static final String CREATE_TABLE_ENTREVISTADOR="CREATE TABLE entrevistador(_id INTEGER PRIMARY KEY AUTOINCREMENT, codigo TEXT, nombre TEXT)";
    private static final String INSERT_INTO_ENTREVISTADIR="INSERT INTO entrevistador (_id, codigo, nombre) VALUES(1, \"E1\", \"COMANDANTE\")";
    //endregion

    //region Tabla imputado_carpeta_investigación
    private static final String CREATE_TABLE_IMPUTADO_CARPETA_INVESTIGACION="CREATE TABLE imputado_carpeta_investigacion(_id INTEGER PRIMARY KEY AUTOINCREMENT, noCarpetaInvestigacion TEXT, e111 TEXT, e112 TEXT, e113 TEXT, e114 TEXT, " +
            "e115 TEXT, e116 TEXT, e117 TEXT, e118 TEXT, e119 TEXT, e120 TEXT, e121 TEXT, e122 TEXT, e123 TEXT, e124 TEXT, e125 TEXT, e126 TEXT, Folio TEXT)";
    //endregion

    //region Tabla_Entrevistador_Adolescentes
    private static final String CREATE_TABLE_ENTREVISTADOR_A="CREATE TABLE entrevistador_adolescentes(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Acausa TEXT, Afecha TEXT, Aevaluador TEXT, Afolio TEXT)";
    //endregion

    //region Tabla_Responsables_Adolescentes
    private static final String CREATE_TABLE_RESPONSABLES_A="CREATE TABLE responsables_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aconsentimiento TEXT, " +
            "Anombre1 TEXT, Arelacion1 TEXT, Aoyente1 TEXT,Anombre2 TEXT, Arelacion2 TEXT,Aoyente2 TEXT, Afolio TEXT)";
    //endregion

    //region Tabla_Datos_Generales_Adolescentes
    private static final String CREATE_TABLE_DATOS_GENERALES_A="CREATE TABLE datos_generales_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Anombre TEXT, Asexo TEXT, Aedad TEXT, " +
            "Afechanac TEXT, Acurp TEXT, Alugarnac TEXT, Aestado TEXT, Amunicipio TEXT, Alocalidad TEXT, Anacionalidad TEXT, Aespanol TEXT, Atraductor TEXT, Afolio TEXT)";
    //endregion

    //region Tabla_Datos_Ficha_Familiar_Adolescentes
    private static final String CREATE_TABLE_FICHA_FAMILIAR_A="CREATE TABLE ficha_familiar_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Acalle TEXT, Anumero TEXT," +
            " Acolonia TEXT, Acp TEXT, Amunicipio TEXT, Aestado TEXT, Apais Text, Atemporalidad TEXT, Adomiciliof TEXT,  Adomicilioant TEXT," +
            " Alocalidad1 TEXT, Atemporalidadant1 TEXT, Alocalidad2 TEXT, Atemporalidadant2 TEXT,Alocalidad3 TEXT, Atemporalidadant3 TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Familiares_Adolescentes
    private static final String CREATE_TABLE_DATOS_FAMILIARES_A="CREATE TABLE datos_familiares_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Anombre1 TEXT, Arelacion1 TEXT," +
            "Aedad1 TEXT, Atelefono1 TEXT, Avivecon1 TEXT, Anombre2 TEXT, Arelacion2 TEXT,Aedad2 TEXT, Atelefono2 TEXT, Avivecon2 TEXT, Aubicarfam TEXT," +
            " Anombrefam TEXT, Arelacionfam TEXT, Alocalidadfam TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Dependientes_Economicos_Adolescentes
    private static final String CREATE_TABLE_DEPENDIENTES_ECONOMICOS_A="CREATE TABLE dependientes_economicos_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Adependientes TEXT," +
            "Anombre1 TEXT, Arelacion1 TEXT, Aedad1 TEXT, Atelefono1 TEXT, Aresponsable1 TEXT,Anombre2 TEXT, Arelacion2 TEXT, Aedad2 TEXT, Atelefono2 TEXT, Aresponsable2 TEXT," +
            " Anombre3 TEXT, Arelacion3 TEXT, Aedad3 TEXT, Atelefono3 TEXT, Aresponsable3 TEXT,Afolio TEXT)";
    //endregion

    //region Tabla_Datos_Historial_Escolar_Adolescentes
    private static final String CREATE_TABLE_HISTORIAL_ESCOLAR_A="CREATE TABLE historial_escolar_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aasiste TEXT, Aconcluyo TEXT," +
            "Anombreact TEXT, Adireccionact TEXT, Atelefonoact TEXT, Anivel TEXT, Agrado TEXT, Anombreant1 TEXT, Alocalidad1 TEXT, Agradoant1 TEXT," +
            "Anombreant2 TEXT, Alocalidad2 TEXT, Agradoant2 TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Historial_Laboral_Adolescentes
    private static final String CREATE_TABLE_HISTORIAL_LABORAL_A="CREATE TABLE historial_laboral_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Atrabaja TEXT, Arecurrente TEXT," +
            "Anombre TEXT, Adireccion TEXT, Atelefono TEXT, Aantiguedad TEXT, Atiempo TEXT, Ajefe TEXT,Atrabajoant TEXT, Anombreant TEXT, Alocalidad TEXT, Aantiguedadant TEXT," +
            " Atelefonoant TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Actividades_Extraescolares_Adolescentes
    private static final String CREATE_TABLE_ACTIVIDADES_EXTRAESCOLARES_A="CREATE TABLE actividades_extraescolares_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Arealiza TEXT," +
            "Aactividad TEXT, Alocalidad TEXT, Acontacto TEXT, Atelefono TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Revision_Medica_Adolescentes
    private static final String CREATE_TABLE_REVISION_MEDICA_A="CREATE TABLE revision_medica_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aembarazada TEXT," +
            "Amadre TEXT, Aenfermedad TEXT, Acual TEXT, Adiscapacidad TEXT, Amedicamento TEXT, Aentrevistador TEXT, Afolio TEXT)";
    //endregion_Adolescentes

    //region Tabla_Datos_Conduamo_Sustancias_Adolescentes
    private static final String CREATE_TABLE_CONSUMO_SUSTENCIAS_A="CREATE TABLE consumo_sustancias_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aconsume_alcohol TEXT," +
            "Acantidad1 TEXT, Afrecuencia1 TEXT, Aultimo_consumo1,Aconsume_tabaco TEXT,Acantidad2 TEXT, Afrecuencia2 TEXT, Aultimo_consumo2, " +
            "Aconsume_marihuana TEXT,Acantidad3 TEXT, Afrecuencia3 TEXT, Aultimo_consumo3,Aconsume_pastillas TEXT,Acantidad4 TEXT, Afrecuencia4 TEXT, Aultimo_consumo4," +
            "Aconsume_solventes TEXT,Acantidad5 TEXT, Afrecuencia5 TEXT, Aultimo_consumo5,Aconsume_metanfetaminas TEXT,Acantidad6 TEXT, Afrecuencia6 TEXT, Aultimo_consumo6," +
            "Aconsume_cocaina TEXT,Acantidad7 TEXT, Afrecuencia7 TEXT, Aultimo_consumo7 TEXT,Aconsumemas TEXT, Afolio TEXT)";
    //endregion


    //region Tabla_Datos_Informacion_Caso
    private static final String CREATE_TABLE_INFORMACION_CASO_A="CREATE TABLE informacion_caso_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aexpediente TEXT," +
            "Afechadis TEXT,Aaccesofuente TEXT, Acualfuente TEXT, Adelito TEXT, Adelitomencionado_145 TEXT, Adelitomencionado_164 TEXT," +
            "Ainternamiento TEXT, Ahechosalegados TEXT, Afolio TEXT)";
    //endregion

    //endregion

    //region Tabla_Datos_Procesos_Penales_Adolescentes
    private static final String CREATE_TABLE_PROCESOS_PENALES_A="CREATE TABLE procesos_penales_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aprocesos TEXT,Amedidacautelar TEXT," +
            "Aacusa1 TEXT, Adelitomedida1 TEXT, Atipomedida1 TEXT, Aestatus1 TEXT,Aacusa2 TEXT, Adelitomedida2 TEXT, Atipomedida2 TEXT, Aestatus2 TEXT," +
            "Aacusa3 TEXT, Adelitomedida3 TEXT, Atipomedida3 TEXT, Aestatus3 TEXT,Aacusa4 TEXT, Adelitomedida4 TEXT, Atipomedida4 TEXT, Aestatus4 TEXT," +
            "Aacusa5 TEXT, Adelitomedida5 TEXT, Atipomedida5 TEXT, Aestatus5 TEXT,Afolio TEXT)";
    //endregion

    //endregion

    //region Tabla_Datos_Victima_U_Ofendido_Adolescentes
    private static final String CREATE_TABLE_VICTIMA_OFENDIDO_A="CREATE TABLE victima_ofendido_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Aexistevictima TEXT," +
            "Avivedomicilio TEXT, Anovivevictima TEXT, Acasomismodomicilio TEXT, Aintegridad TEXT, Aintenciones TEXT, Afolio TEXT)";
    //endregion

    //endregion

    //region Tabla_Datos_Proceso_Legal_Adolescentes
    private static final String CREATE_TABLE_PROCESO_LEGAL_A="CREATE TABLE proceso_legal_a(_id INTEGER PRIMARY KEY AUTOINCREMENT, Ariesgocontinuo TEXT," +
            "Aexpliquecontinuo TEXT, Aamanazatestigo TEXT, Aexpliqueamenaza TEXT, Afolio TEXT)";
    //endregion



    //endregion

    //region Definicion de la base de datos
    private static final String DB_NAME="evaluacion.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMENTS_TABLE_CREATE);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_GENERALES);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_DOMICILIO);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_HABITANTES);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_REFERENCIAS);
        db.execSQL(CREATE_TABLE_IMPUTADO_HISTORIAL_ESCOLAR_LABORAL);
        db.execSQL(CREATE_TABLE_IMPUTADO_ABANDONO_ESTADO);
        db.execSQL(CREATE_TABLE_IMPUTADO_SALUD);
        db.execSQL(CREATE_TABLE_VERIFICACION_OBSERVACIONES);
        db.execSQL(CREATE_TABLE_VERIFICACION_ENTREVISTADO);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_VICTIMA);
        db.execSQL(CREATE_TABLE_ENTREVISTADOR);
        db.execSQL(CREATE_TABLE_ASSIST);
        db.execSQL(CREATE_TABLE_EVA_RIESGOS);
        db.execSQL(INSERT_INTO_ENTREVISTADIR);
        db.execSQL(CREATE_TABLE_IMPUTADO_CARPETA_INVESTIGACION);

        db.execSQL(CREATE_TABLE_ENTREVISTADOR_A);
        db.execSQL(CREATE_TABLE_RESPONSABLES_A);
        db.execSQL(CREATE_TABLE_DATOS_GENERALES_A);
        db.execSQL(CREATE_TABLE_FICHA_FAMILIAR_A);
        db.execSQL(CREATE_TABLE_DATOS_FAMILIARES_A);
        db.execSQL(CREATE_TABLE_DEPENDIENTES_ECONOMICOS_A);
        db.execSQL(CREATE_TABLE_HISTORIAL_ESCOLAR_A);
        db.execSQL(CREATE_TABLE_HISTORIAL_LABORAL_A);
        db.execSQL(CREATE_TABLE_ACTIVIDADES_EXTRAESCOLARES_A);
        db.execSQL(CREATE_TABLE_REVISION_MEDICA_A);
        db.execSQL(CREATE_TABLE_CONSUMO_SUSTENCIAS_A);
        db.execSQL(CREATE_TABLE_INFORMACION_CASO_A);
        db.execSQL(CREATE_TABLE_PROCESOS_PENALES_A);
        db.execSQL(CREATE_TABLE_VICTIMA_OFENDIDO_A);
        db.execSQL(CREATE_TABLE_PROCESO_LEGAL_A);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //endregion

    //region Insertar a Base de Datos
    //region Insertar un nuevo comentario
    public void insertar(String r1,String r2, String r3, String r4, String r5,String r6, String r8, String r8a, String r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r21a, String r22, String r22a, String r23, String r24, String r25){
        ContentValues cv = new ContentValues();
        cv.put("r1", r1);
        cv.put("r2", r2);
        cv.put("r3", r3);
        cv.put("r4", r4);
        cv.put("r5", r5);
        cv.put("r6", r6);
        cv.put("r8", r8);
        cv.put("r8a", r8a);
        cv.put("r9", r9);
        cv.put("r10", r10);
        cv.put("r11", r11);
        cv.put("r12", r12);
        cv.put("r13", r13);
        cv.put("r14", r14);
        cv.put("r15", r15);
        cv.put("r16", r16);
        cv.put("r17", r17);
        cv.put("r18", r18);
        cv.put("r19", r19);
        cv.put("r20", r20);
        cv.put("r21", r21);
        cv.put("r21a", r21a);
        cv.put("r22", r22);
        cv.put("r22a", r22a);
        cv.put("r23", r23);
        cv.put("r24", r24);
        cv.put("r25", r25);
        db.insert("comments", null, cv);
    }
    //endregion

    //region Insertar Datos Generales
    public void insertarDatosGenerales(String nombre, String alias, String fNacimiento, String edad, String lNacimiento,
                                       String sexo, String folio, String fEntrevista, int duracionE, String entrevistador,
                                       String observacionesF, String tipo, String assist, String tieneVerificacion,
                                       String tieneEvaluacion, String tieneDomicilioS, String otrosHabitantes,
                                       String entrevistada, String antecedentePenal, String delito, String otroDelito, String carpetaInvestigacion){
        ContentValues dato=new ContentValues();
        dato.put("Nombre", nombre);
        dato.put("Alias", alias);
        dato.put("FNacimiento", fNacimiento);
        dato.put("Edad", edad);
        dato.put("LNacimiento", lNacimiento);
        dato.put("Sexo", sexo);
        dato.put("Folio", folio);
        dato.put("FEntrevista", fEntrevista);
        dato.put("DuraciónE", duracionE);
        dato.put("Entrevistador", entrevistador);
        dato.put("ObservacionesF", observacionesF);
        dato.put("Tipo", tipo);
        dato.put("ASSIST", assist);
        dato.put("TieneVerificacion", tieneVerificacion);
        dato.put("TieneEvaluacion", tieneEvaluacion);
        dato.put("TieneDomicilioS", tieneDomicilioS);
        dato.put("OtrosHabitantes", otrosHabitantes);
        dato.put("Entrevistada", entrevistada);
        dato.put("AntecedentePenal", antecedentePenal);
        //TODO: agregar Delito, OtroDelito, ASSIST, TieneVerificacion, TieneEvaluacion, a sincronizarBD
        dato.put("Delito", delito);
        dato.put("OtroDelito", otroDelito);
        dato.put("CarpetaInvestigacion", carpetaInvestigacion);
        db.insert("imputado_datos_generales", null, dato);
    }
    //endregion

    //region Insertar Datos Generales Domicilio
    public void insertarDatosGeneralesDomicilio(String e7, String e7_1, String e8, String e9, String e10, String e11, String e12, String e13, String e14, String e15,
                                                String e16, String e32_1, String e17, String e18, String e19, String e20, String e21, String e22, String e23,
                                                String e24, String e25, String e26, String e27, String e28, String e21_2, String e21_3, String e29, String e30, String e31,
                                                String e106, String e107, String folio){
        ContentValues dato=new ContentValues();
        //TODO: agregar e21_2, e21_3 a sincronizarBD
        dato.put("e7", e7);
        dato.put("e7_1", e7_1);
        dato.put("e8", e8);
        dato.put("e9", e9);
        dato.put("e10", e10);
        dato.put("e11", e11);
        dato.put("e12", e12);
        dato.put("e13", e13);
        dato.put("e14", e14);
        dato.put("e15", e15);
        dato.put("e16", e16);
        dato.put("e32_1", e32_1);
        dato.put("e17", e17);
        dato.put("e18", e18);
        dato.put("e19", e19);
        dato.put("e20", e20);
        dato.put("e21", e21);
        dato.put("e22", e22);
        dato.put("e23", e23);
        dato.put("e24", e24);
        dato.put("e25", e25);
        dato.put("e26", e26);
        dato.put("e27", e27);
        dato.put("e28", e28);
        dato.put("e21_2", e21_2);
        dato.put("e21_3", e21_3);
        dato.put("e29", e29);
        dato.put("e30", e30);
        dato.put("e31", e31);
        dato.put("e106", e106);
        dato.put("e107", e107);
        dato.put("Folio", folio);

        db.insert("imputado_datos_domicilio", null, dato);
    }
    //endregion

    //region Insertar Datos Familiares
    public void insertarDatosFamiliares(String e32, String e33, String e34, String e35, String e36, String e37,
                                        String e33_1, String e34_1, String e35_1, String e36_1, String e37_1,
                                        String e33_2, String e34_2, String e35_2, String e36_2, String e37_2,
                                        String e33_3, String e34_3, String e35_3, String e36_3, String e37_3,
                                        String e38, String e32_2, String e32_3, String e32_4, String e32_5,
                                        String e32_6, String e32_7, String folio){
        ContentValues dato=new ContentValues();
        //TODO: agregar e32_2, e32_3, e32_4, e32_5, e32_6, e32_7 a sincronizarBD
        dato.put("e32", e32);
        dato.put("e33", e33);
        dato.put("e34", e34);
        dato.put("e35", e35);
        dato.put("e36", e36);
        dato.put("e37", e37);
        dato.put("e33_1", e33_1);
        dato.put("e34_1", e34_1);
        dato.put("e35_1", e35_1);
        dato.put("e36_1", e36_1);
        dato.put("e37_1", e37_1);
        dato.put("e33_2", e33_2);
        dato.put("e34_2", e34_2);
        dato.put("e35_2", e35_2);
        dato.put("e36_2", e36_2);
        dato.put("e37_2", e37_2);
        dato.put("e33_3", e33_3);
        dato.put("e34_3", e34_3);
        dato.put("e35_3", e35_3);
        dato.put("e36_3", e36_3);
        dato.put("e37_3", e37_3);
        dato.put("e38", e38);
        dato.put("e32_2", e32_2);
        dato.put("e32_3", e32_3);
        dato.put("e32_4", e32_4);
        dato.put("e32_5", e32_5);
        dato.put("e32_6", e32_6);
        dato.put("e32_7", e32_7);
        dato.put("Folio", folio);
        db.insert("imputado_datos_habitantes", null, dato);

    }
    //endregion

    //region Insertar Datos Referencias
    public void insertarDatosReferencias(String e39, String e40, String e41, String e42, String e43, String e39_1, String e40_1,
                                         String e41_1, String e42_1, String e43_1, String e44, String e45, String e46, String e47,
                                         String folio) {
        ContentValues dato = new ContentValues();
        dato.put("e39", e39);
        dato.put("e40", e40);
        dato.put("e41", e41);
        dato.put("e42", e42);
        dato.put("e43", e43);
        dato.put("e39_1", e39_1);
        dato.put("e40_1", e40_1);
        dato.put("e41_1", e41_1);
        dato.put("e42_1", e42_1);
        dato.put("e43_1", e43_1);
        dato.put("e44", e44);
        dato.put("e45", e45);
        dato.put("e46", e46);
        dato.put("e47", e47);
        dato.put("Folio", folio);
        db.insert("imputado_datos_referencias", null, dato);
    }
    //endregion

    //region Insertar Datos Historial Escolar Laboral
    public void insertarDatosEscolarLaboral(String e48, String e49, String e50, String e51, String e52, String e53, String e54,
                                            String e55, String e56, String e56_1, String e57, String e58, String e51_1, String e59, String folio) {
        ContentValues dato = new ContentValues();
        //TODO: agregar e51_1, e56_1 a sincronizarBD
        dato.put("e48", e48);
        dato.put("e49", e49);
        dato.put("e50", e50);
        dato.put("e51", e51);
        dato.put("e52", e52);
        dato.put("e53", e53);
        dato.put("e54", e54);
        dato.put("e55", e55);
        dato.put("e56", e56);
        dato.put("e56_1", e56_1);
        dato.put("e57", e57);
        dato.put("e58", e58);
        dato.put("e51_1", e51_1);
        dato.put("e59", e59);
        dato.put("Folio", folio);
        db.insert("imputado_datos_historial_escolar_laboral", null, dato);
    }
    //endregion

    //region Insertar Datos Abandodo Estado
    public void insertarDatosAbandonoEstado(String e60, String e61, String e62, String e63, String e64, String e64_1, String e65, String e65_1,
                                            String e65_2, String e65_3, String e65_4, String e65_5, String e65_6, String e66,
                                            String e67, String e68, String e69, String e70, String e71, String e72,
                                            String e67_1, String e68_1, String e69_1, String e70_1, String e71_1, String e72_1,
                                            String e73, String e74, String e75, String e76, String e77, String e78,
                                            String e74_1, String e75_1, String e76_1, String e77_1, String e78_1,
                                            String e79, String e80, String e81, String folio) {
        ContentValues dato = new ContentValues();
        //TODO: agregar e64_1, e65_1, e65_2, e65_3, e65_4, e65_5, e65_6 a sincronizarBD
        dato.put("e60", e60);
        dato.put("e61", e61);
        dato.put("e62", e62);
        dato.put("e63", e63);
        dato.put("e64", e64);
        dato.put("e64_1", e64_1);
        dato.put("e65", e65);
        dato.put("e65_1", e65_1);
        dato.put("e65_2", e65_2);
        dato.put("e65_3", e65_3);
        dato.put("e65_4", e65_4);
        dato.put("e65_5", e65_5);
        dato.put("e65_6", e65_6);
        dato.put("e66", e66);
        dato.put("e67", e67);
        dato.put("e68", e68);
        dato.put("e69", e69);
        dato.put("e70", e70);
        dato.put("e71", e71);
        dato.put("e72", e72);
        dato.put("e67_1", e67_1);
        dato.put("e68_1", e68_1);
        dato.put("e69_1", e69_1);
        dato.put("e70_1", e70_1);
        dato.put("e71_1", e71_1);
        dato.put("e72_1", e72_1);
        dato.put("e73", e73);
        dato.put("e74", e74);
        dato.put("e75", e75);
        dato.put("e76", e76);
        dato.put("e77", e77);
        dato.put("e78", e78);
        dato.put("e74_1", e74_1);
        dato.put("e75_1", e75_1);
        dato.put("e76_1", e76_1);
        dato.put("e77_1", e77_1);
        dato.put("e78_1", e78_1);
        dato.put("e79", e79);
        dato.put("e80", e80);
        dato.put("e81", e81);
        dato.put("Folio", folio);
        db.insert("imputado_datos_abandono_estado", null, dato);
    }
    //endregion

    //region Insertar Datos Salud
    public void insertarDatosSalud(String e82, String e90_alcohol, String e91_alcohol, String e92_alcohol, String e83, String e90_tabaco, String e91_tabaco, String e92_tabaco,
                                   String e84, String e90_marihuana, String e91_marihuana, String e92_marihuana, String e85, String e90_pastillas, String e91_pastillas, String e92_pastillas,
                                   String e86, String e90_solventes, String e91_solventes, String e92_solventes, String e87, String e90_cristal, String e91_cristal, String e92_cristal,
                                   String e88, String e90_cocaina, String e91_cocaina, String e92_cocaina, String e89, String e93_otroConsumo, String e90_otroConsumo, String e91_otroConsumo, String e92_otroConsumo,
                                   String e94, String e95, String folio) {
        ContentValues dato = new ContentValues();

        dato.put("e82", e82);
        dato.put("e90_alcohol", e90_alcohol);
        dato.put("e91_alcohol", e91_alcohol);
        dato.put("e92_alcohol", e92_alcohol);
        dato.put("e83", e83);
        dato.put("e90_tabaco", e90_tabaco);
        dato.put("e91_tabaco", e91_tabaco);
        dato.put("e92_tabaco", e92_tabaco);
        dato.put("e84", e84);
        dato.put("e90_marihuana", e90_marihuana);
        dato.put("e91_marihuana", e91_marihuana);
        dato.put("e92_marihuana", e92_marihuana);
        dato.put("e85", e85);
        dato.put("e90_pastillas", e90_pastillas);
        dato.put("e91_pastillas", e91_pastillas);
        dato.put("e92_pastillas", e92_pastillas);
        dato.put("e86", e86);
        dato.put("e90_solventes", e90_solventes);
        dato.put("e91_solventes", e91_solventes);
        dato.put("e92_solventes", e92_solventes);
        dato.put("e87", e87);
        dato.put("e90_cristal", e90_cristal);
        dato.put("e91_cristal", e91_cristal);
        dato.put("e92_cristal", e92_cristal);
        dato.put("e88", e88);
        dato.put("e90_cocaina", e90_cocaina);
        dato.put("e91_cocaina", e91_cocaina);
        dato.put("e92_cocaina", e92_cocaina);
        dato.put("e89", e89);
        dato.put("e93_otroConsumo", e93_otroConsumo);
        dato.put("e90_otroConsumo", e90_otroConsumo);
        dato.put("e91_otroConsumo", e91_otroConsumo);
        dato.put("e92_otroConsumo", e92_otroConsumo);
        dato.put("e94", e94);
        dato.put("e95", e95);
        dato.put("Folio", folio);
        db.insert("imputado_datos_salud", null, dato);
    }
    //endregion

    //region Insertar Datos Victima
    public void insertarDatosVictima(String e101, String e102, String e103, String e104, String e105, String folio) {
        ContentValues dato = new ContentValues();
        dato.put("e101", e101);
        dato.put("e102", e102);
        dato.put("e103", e103);
        dato.put("e104", e104);
        dato.put("e105", e105);

        dato.put("Folio", folio);
        db.insert("imputado_datos_victima", null, dato);
    }
    //endregion

    //region Insertar Datos Observaciones
    public void insertarObservaciones(String campo, String observacion, String original, String folio) {
        ContentValues dato = new ContentValues();
        dato.put("Campo", campo);
        dato.put("Observacion", observacion);
        dato.put("Original", original);
        dato.put("Folio", folio);
        db.insert("verificacion_observaciones", null, dato);
    }
    //endregion

    //region Insertar datos de quien atiende la entrevista de verificación
    public void insertarDatosVerificacion(String nombre, String relacion, String folio){
        ContentValues dato=new ContentValues();
        dato.put("VEntrevistado", nombre);
        dato.put("VRelacion", relacion);
        dato.put("Folio", folio);
        db.insert("verificacion_entrevistado", null, dato);
    }
    //endregion

    //TODO: agregar tabla assist a sincronizarBD
    //region Inserta los datos del ASSIST
    public void insertarASSIST(String pa, String pb, String pc, String pd, String pe, String pf, String pg, String ph, String pi, String pj, String otro,
                               String e8, String folio){
        ContentValues dato=new ContentValues();
        dato.put("Pa", pa);
        dato.put("Pb", pb);
        dato.put("Pc", pc);
        dato.put("Pd", pd);
        dato.put("Pe", pe);
        dato.put("Pf", pf);
        dato.put("Pg", pg);
        dato.put("Ph", ph);
        dato.put("Pi", pi);
        dato.put("Pj", pj);
        dato.put("JOtro", otro);
        dato.put("e8", e8);
        dato.put("Folio", folio);
        db.insert("assist", null, dato);
    }
    //endregion

    //region Inserta los datos del instrumento de evaluación de riesgo
    public void insertarEvaluacionRiesgos(int arraigo, int residenciaEdo, int abandonoEdo, int voluntadSometimiento, int antecedentes,
                                          int medidasNoPrivativas, int escala, String folio){
        ContentValues dato=new ContentValues();
        dato.put("Arraigo", arraigo);
        dato.put("ResidenciaEdo", residenciaEdo);
        dato.put("AbandonoEdo", abandonoEdo);
        dato.put("VoluntadSometimiento", voluntadSometimiento);
        dato.put("Antecedentes", antecedentes);
        dato.put("MedidasNoPrivativas", medidasNoPrivativas);
        dato.put("Escala", escala);
        dato.put("Folio", folio);
        db.insert("eva_riesgos", null, dato);
    }
    //endregion

    //region Datos Carpeta de Investigación
    public void insertarCarpetaInvestigacion(String carpeta, String e111, String e112, String e113, String e114, String e115, String e116, String e117, String e118,
                                             String e119, String e120, String e121, String e122, String e123, String e124, String e125, String e126,
                                             String folio){
        ContentValues dato=new ContentValues();
        dato.put("noCarpetaInvestigacion", carpeta);
        dato.put("e111", e111);
        dato.put("e112", e112);
        dato.put("e113", e113);
        dato.put("e114", e114);
        dato.put("e115", e115);
        dato.put("e116", e116);
        dato.put("e117", e117);
        dato.put("e118", e118);
        dato.put("e119", e119);
        dato.put("e120", e120);
        dato.put("e121", e121);
        dato.put("e122", e122);
        dato.put("e123", e123);
        dato.put("e124", e124);
        dato.put("e125", e125);
        dato.put("e126", e126);
        dato.put("Folio", folio);
        db.insert("imputado_carpeta_investigacion", null, dato);
    }


    //endregion

    //region Insertar Datos Entrevistador Adolescentes
    public void insertarDatosEntrevistadorA(String acausa, String afecha, String aevaluador, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Acausa", acausa);
        dato.put("Afecha", afecha);
        dato.put("Aevaluador", aevaluador);
        dato.put("Afolio", afolio);
        db.insert("entrevistador_adolescentes", null, dato);
    }
    //endregion

    //region Insertar Datos Responsables Adolescentes
    public void insertarDatosResponsablesA(String aconsentimiento, String anombre1, String arelacion1, String aoyente1, String anombre2, String arelacion2,
                                           String aoyente2, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aconsentimiento", aconsentimiento);
        dato.put("Anombre1", anombre1);
        dato.put("Arelacion1", arelacion1);
        dato.put("Aoyente1", aoyente1);
        dato.put("Anombre2", anombre2);
        dato.put("Arelacion2", arelacion2);
        dato.put("Aoyente2", aoyente2);
        dato.put("Afolio", afolio);
        db.insert("responsables_a", null, dato);
    }

    //endregion

    //region Insertar Datos Generales Adolescentes
    public void insertarDatosGeneralesA(String anombre, String asexo, String aedad, String afechanac, String acurp, String alugarnac,
                                        String aestado, String amunicipio, String alocalidad, String anacionalidad, String aespanol,
                                        String atraductor, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Anombre", anombre);
        dato.put("Asexo", asexo);
        dato.put("Aedad", aedad);
        dato.put("Afechanac", afechanac);
        dato.put("Acurp", acurp);
        dato.put("Alugarnac", alugarnac);
        dato.put("Aestado", aestado);
        dato.put("Amunicipio", amunicipio);
        dato.put("Alocalidad", alocalidad);
        dato.put("Anacionalidad", anacionalidad);
        dato.put("Aespanol", aespanol);
        dato.put("Atraductor", atraductor);
        dato.put("Afolio", afolio);
        db.insert("datos_generales_a", null, dato);
    }
    //endregion

    //region Insertar Datos Ficha Familiar Adolescentes
    public void insertarDatosFichaFamiliarA(String acalle, String anumero, String acolonia, String acp, String amunicipio, String aestado, String apais,
                                            String atemporalidad, String adomiciliof, String adomicilioant, String alocalidad1, String atemporalidadant1,String alocalidad2,
                                            String atemporalidadant2,String alocalidad3, String atemporalidadant3, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Acalle", acalle);
        dato.put("Anumero", anumero);
        dato.put("Acolonia", acolonia);
        dato.put("Acp", acp);
        dato.put("Amunicipio", amunicipio);
        dato.put("Aestado", aestado);
        dato.put("Apais", apais);
        dato.put("Atemporalidad", atemporalidad);
        dato.put("Adomiciliof", adomiciliof);
        dato.put("Adomicilioant", adomicilioant);
        dato.put("Alocalidad1", alocalidad1);
        dato.put("Atemporalidadant1", atemporalidadant1);
        dato.put("Alocalidad2", alocalidad2);
        dato.put("Atemporalidadant2", atemporalidadant2);
        dato.put("Alocalidad3", alocalidad3);
        dato.put("Atemporalidadant3", atemporalidadant3);
        dato.put("Afolio", afolio);
        db.insert("ficha_familiar_a", null, dato);
    }
    //endregion

    //region Insertar Datos Familiares Adolescentes
    public void insertarDatosFamiliaresA(String anombre1, String arelacion1, String aedad1, String atelefono1, String avivecon1,String anombre2, String arelacion2,
                                         String aedad2, String atelefono2, String avivecon2, String aubicarfam, String anombrefam,
                                         String arelacionfam, String alocalidadfam, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Anombre1", anombre1);
        dato.put("Arelacion1", arelacion1);
        dato.put("Aedad1", aedad1);
        dato.put("Atelefono1", atelefono1);
        dato.put("Avivecon1", avivecon1);
        dato.put("Anombre2", anombre2);
        dato.put("Arelacion2", arelacion2);
        dato.put("Aedad2", aedad2);
        dato.put("Atelefono2", atelefono2);
        dato.put("Avivecon2", avivecon2);
        dato.put("Aubicarfam", aubicarfam);
        dato.put("Anombrefam", anombrefam);
        dato.put("Arelacionfam", arelacionfam);
        dato.put("Alocalidadfam", alocalidadfam);
        dato.put("Afolio", afolio);
        db.insert("datos_familiares_a", null, dato);
    }
    //endregion

    //region Insertar Datos Dependientes Economicos Adolescentes
    public void insertarDatosDependientesEconomicosA(String adependientes, String anombre1, String arelacion1, String aedad1, String atelefono1, String aresponsable1,
                                                     String anombre2, String arelacion2, String aedad2, String atelefono2, String aresponsable2,
                                                     String anombre3, String arelacion3, String aedad3, String atelefono3, String aresponsable3, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Adependientes", adependientes);
        dato.put("Anombre1", anombre1);
        dato.put("Arelacion1", arelacion1);
        dato.put("Aedad1", aedad1);
        dato.put("Atelefono1", atelefono1);
        dato.put("Aresponsable1", aresponsable1);
        dato.put("Anombre2", anombre2);
        dato.put("Arelacion2", arelacion2);
        dato.put("Aedad2", aedad2);
        dato.put("Atelefono2", atelefono2);
        dato.put("Aresponsable2", aresponsable2);
        dato.put("Anombre3", anombre3);
        dato.put("Arelacion3", arelacion3);
        dato.put("Aedad3", aedad3);
        dato.put("Atelefono3", atelefono3);
        dato.put("Aresponsable3", aresponsable3);
        dato.put("Afolio", afolio);
        db.insert("dependientes_economicos_a", null, dato);
    }
    //endregion

    //region Insertar Datos Actividades Extraescolare Adolescentes
    public void insertarDatosActividadesExtraescolaresA(String arealiza, String aactividad, String alocalidad, String acontacto,
                                                        String atelefono, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Arealiza", arealiza);
        dato.put("Aactividad", aactividad);
        dato.put("Alocalidad", alocalidad);
        dato.put("Acontacto", acontacto);
        dato.put("Atelefono", atelefono);
        dato.put("Afolio", afolio);
        db.insert("actividades_extraescolares_a", null, dato);
    }
    //endregion

    //region Insertar Datos Revision Medica Adolescentes
    public void insertarDatosRevisionMedicaA(String aembarazada, String amadre,String aenfermedad, String acual, String adiscapacidad,
                                             String amedicamento, String aentrevistador,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aembarazada", aembarazada);
        dato.put("Amadre", amadre);
        dato.put("Aenfermedad", aenfermedad);
        dato.put("Acual", acual);
        dato.put("Adiscapacidad", adiscapacidad);
        dato.put("Amedicamento", amedicamento);
        dato.put("Aentrevistador", aentrevistador);
        dato.put("Afolio", afolio);
        db.insert("revision_medica_a", null, dato);
    }
    //endregion

    //region Insertar Datos Historial Escolar Adolescentes
    public void insertarDatosHistorialEscolarA(String aasiste, String aconcluyo, String anombreact, String adireccionact, String atelefonoact, String anivel,
                                               String agrado, String anombreant1, String alocalidad1, String agradoant1, String anombreant2, String alocalidad2,
                                               String agradoant2,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aasiste", aasiste);
        dato.put("Aconcluyo", aconcluyo);
        dato.put("Anombreact", anombreact);
        dato.put("Adireccionact", adireccionact);
        dato.put("Atelefonoact", atelefonoact);
        dato.put("Anivel", anivel);
        dato.put("Agrado", agrado);
        dato.put("Anombreant1", anombreant1);
        dato.put("Alocalidad1", alocalidad1);
        dato.put("Agradoant1", agradoant1);
        dato.put("Anombreant2", anombreant2);
        dato.put("Alocalidad2", alocalidad2);
        dato.put("Agradoant2", agradoant2);
        dato.put("Afolio", afolio);
        db.insert("historial_escolar_a", null, dato);
    }
    //endregion

    //region Insertar Datos Historial Laboral Adolescentes
    public void insertarDatosHistorialLaboralA(String atrabajoant,String atrabaja, String arecurrente, String anombre, String adireccion, String atelefono, String aantiguedad,
                                               String atiempo, String ajefe, String anombreant, String alocalidad, String aantiguedadant, String atelefonoant,
                                                String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Atrabajoant", atrabajoant);
        dato.put("Atrabaja", atrabaja);
        dato.put("Arecurrente", arecurrente);
        dato.put("Anombre", anombre);
        dato.put("Adireccion", adireccion);
        dato.put("Atelefono", atelefono);
        dato.put("Aantiguedad", aantiguedad);
        dato.put("Atiempo", atiempo);
        dato.put("Ajefe", ajefe);
        dato.put("Anombreant", anombreant);
        dato.put("Alocalidad", alocalidad);
        dato.put("Aantiguedadant", aantiguedadant);
        dato.put("Atelefonoant", atelefonoant);
        dato.put("Afolio", afolio);
        db.insert("historial_laboral_a", null, dato);
    }
    //endregion

    //region Insertar Datos Consumo Sustancias Adolescentes
    public void insertarDatosConsumoSustanciaA(String aconsume_alcohol, String acantidad1, String afrecuencia1, String aultimo_consumo1,
                                              String aconsume_tabaco, String acantidad2, String afrecuencia2, String aultimo_consumo2,
                                              String aconsume_marihuana, String acantidad3, String afrecuencia3, String aultimo_consumo3,
                                              String aconsume_pastillas, String acantidad4, String afrecuencia4, String aultimo_consumo4,
                                              String aconsume_solventes, String acantidad5, String afrecuencia5, String aultimo_consumo5,
                                              String aconsume_metanfetaminas, String acantidad6, String afrecuencia6, String aultimo_consumo6,
                                              String aconsume_cocaina, String acantidad7, String afrecuencia7, String aultimo_consumo7,
                                              String aconsumemas, String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aconsume_alcohol", aconsume_alcohol);
        dato.put("Acantidad1", acantidad1);
        dato.put("Afrecuencia1", afrecuencia1);
        dato.put("Aultimo_consumo1", aultimo_consumo1);
        dato.put("Aconsume_tabaco", aconsume_tabaco);
        dato.put("Acantidad2", acantidad2);
        dato.put("Afrecuencia2", afrecuencia2);
        dato.put("Aultimo_consumo2", aultimo_consumo2);
        dato.put("Aconsume_marihuana", aconsume_marihuana);
        dato.put("Acantidad3", acantidad3);
        dato.put("Afrecuencia3", afrecuencia3);
        dato.put("Aultimo_consumo3", aultimo_consumo3);
        dato.put("Aconsume_pastillas", aconsume_pastillas);
        dato.put("Acantidad4", acantidad4);
        dato.put("Afrecuencia4", afrecuencia4);
        dato.put("Aultimo_consumo4", aultimo_consumo4);
        dato.put("Aconsume_solventes", aconsume_solventes);
        dato.put("Acantidad5", acantidad5);
        dato.put("Afrecuencia5", afrecuencia5);
        dato.put("Aultimo_consumo5", aultimo_consumo5);
        dato.put("Aconsume_metanfetaminas", aconsume_metanfetaminas);
        dato.put("Acantidad6", acantidad6);
        dato.put("Afrecuencia6", afrecuencia6);
        dato.put("Aultimo_consumo6", aultimo_consumo6);
        dato.put("Aconsume_cocaina", aconsume_cocaina);
        dato.put("Acantidad7", acantidad7);
        dato.put("Afrecuencia7", afrecuencia7);
        dato.put("Aultimo_consumo7", aultimo_consumo7);
        dato.put("Aconsumemas", aconsumemas);
        dato.put("Afolio", afolio);
        db.insert("consumo_sustancias_a", null, dato);
    }
    //endregion

    //region Insertar Datos Informacion Caso Actual Adolescentes
    public void insertarDatosInformacionCasoA(String aexpediente, String afechadis, String aaccesofuente, String acualfuente,
                                              String adelito, String adelitomencionado_145,
                                              String adelitomensionado_164, String ainternamiento, String ahechoalegados,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aexpediente", aexpediente);
        dato.put("Afechadis", afechadis);
        dato.put("Aaccesofuente", aaccesofuente);
        dato.put("Acualfuente", acualfuente);
        dato.put("Adelito", adelito);
        dato.put("Adelitomencionado_145", adelitomencionado_145);
        dato.put("Adelitomensionado_164", adelitomensionado_164);
        dato.put("Ainternamiento", ainternamiento);
        dato.put("Ahechoalegados", ahechoalegados);
        dato.put("Afolio", afolio);
        db.insert("informacion_caso_a", null, dato);
    }
    //endregion


    //region Insertar Datos Procesos Penales Adolescentes
    public void insertarDatosProcesosPenalesA(String aproceso, String amedidacautelar,
                                              String acausa1, String adelitomedida1, String atipomedida1, String aestatus1,
                                              String acausa2, String adelitomedida2, String atipomedida2, String aestatus2,
                                              String acausa3, String adelitomedida3, String atipomedida3, String aestatus3,
                                              String acausa4, String adelitomedida4, String atipomedida4, String aestatus4,
                                              String acausa5, String adelitomedida5, String atipomedida5, String aestatus5,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aproceso", aproceso);
        dato.put("Amedidacautelar", amedidacautelar);
        dato.put("Acausa", acausa1);
        dato.put("Adelitomedida", adelitomedida1);
        dato.put("Atipomedida", atipomedida1);
        dato.put("Aestatus", aestatus1);
        dato.put("Acausa", acausa2);
        dato.put("Adelitomedida", adelitomedida2);
        dato.put("Atipomedida", atipomedida2);
        dato.put("Aestatus", aestatus2);
        dato.put("Acausa", acausa3);
        dato.put("Adelitomedida", adelitomedida3);
        dato.put("Atipomedida", atipomedida3);
        dato.put("Aestatus", aestatus3);
        dato.put("Acausa", acausa4);
        dato.put("Adelitomedida", adelitomedida4);
        dato.put("Atipomedida", atipomedida4);
        dato.put("Aestatus", aestatus4);
        dato.put("Acausa", acausa5);
        dato.put("Adelitomedida", adelitomedida5);
        dato.put("Atipomedida", atipomedida5);
        dato.put("Aestatus", aestatus5);
        dato.put("Afolio", afolio);
        db.insert(" procesos_penales_a", null, dato);
    }
    //endregion

    //region Insertar Datos Victima U Ofendidos Adolescentes
    public void insertarDatosVictimaOfendidoA(String aexistevictima, String avivedomicilio, String anovivevictima, String acasomismodomicilio,
                                              String aintegridad, String aintenciones,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Aexistevictima", aexistevictima);
        dato.put("Avivedomicilio", avivedomicilio);
        dato.put("Anovivevictima", anovivevictima);
        dato.put("Acasomismodomicilio", acasomismodomicilio);
        dato.put("Aintegridad", aintegridad);
        dato.put("Aintenciones", aintenciones);
        dato.put("Afolio", afolio);
        db.insert(" victima_ofendido_a", null, dato);
    }
    //endregion

    //region Insertar Datos Proceso Legal Adolescentes
    public void insertarDatosProcesoLegalA(String ariesgocontinuo, String aexpliquecontinuo, String aamenazatestigo,
                                           String aexpliqueamenaza,String afolio){
        ContentValues dato=new ContentValues();
        dato.put("Ariesgocontinuo", ariesgocontinuo);
        dato.put("Aexpliquecontinuo", aexpliquecontinuo);
        dato.put("Aamenazatestigo", aamenazatestigo);
        dato.put("Aexpliqueamenaza", aexpliqueamenaza);
        dato.put("Afolio", afolio);
        db.insert(" proceso_legal_a", null, dato);
    }
    //endregion

    //endregion

    //region Obtener Datos

    //region Obtener la lista de comentarios en la base de datos
    public ArrayList<Comentario> getComments(){
        //Creamos el cursor
        ArrayList<Comentario> lista=new ArrayList<Comentario>();
        Cursor c = db.rawQuery("select _id, r1,r2, r3, r4, r5, r6, r8, r8a, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r21a, r22, r22a, r23, r24, r25  from comments", null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                //region Asignamos el valor en nuestras variables para crear un nuevo objeto Comentario
                String r1 = c.getString(c.getColumnIndex("r1"));
                String r2 = c.getString(c.getColumnIndex("r2"));
                String r3 = c.getString(c.getColumnIndex("r3"));
                String r4 = c.getString(c.getColumnIndex("r4"));
                String r5 = c.getString(c.getColumnIndex("r5"));
                String r6 = c.getString(c.getColumnIndex("r6"));
                String r8 = c.getString(c.getColumnIndex("r8"));
                String r8a = c.getString(c.getColumnIndex("r8a"));
                String r9 = c.getString(c.getColumnIndex("r9"));
                String r10 = c.getString(c.getColumnIndex("r10"));
                String r11 = c.getString(c.getColumnIndex("r11"));
                String r12 = c.getString(c.getColumnIndex("r12"));
                String r13 = c.getString(c.getColumnIndex("r13"));
                String r14 = c.getString(c.getColumnIndex("r14"));
                String r15 = c.getString(c.getColumnIndex("r15"));
                String r16 = c.getString(c.getColumnIndex("r16"));
                String r17 = c.getString(c.getColumnIndex("r17"));
                String r18 = c.getString(c.getColumnIndex("r18"));
                String r19 = c.getString(c.getColumnIndex("r19"));
                String r20 = c.getString(c.getColumnIndex("r20"));
                String r21 = c.getString(c.getColumnIndex("r21"));
                String r21a = c.getString(c.getColumnIndex("r21a"));
                String r22 = c.getString(c.getColumnIndex("r22"));
                String r22a = c.getString(c.getColumnIndex("r22a"));
                String r23 = c.getString(c.getColumnIndex("r23"));
                String r24 = c.getString(c.getColumnIndex("r24"));
                String r25 = c.getString(c.getColumnIndex("r25"));

                int id=c.getInt(c.getColumnIndex("_id"));
                Comentario com =new Comentario(id,r1,r2, r3, r4, r5, r6, r8, r8a, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r21a, r22, r22a, r23, r24, r25);
                //endregion

                //Añadimos el comentario a la lista
                lista.add(com);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos Generales

    public ArrayList<datosGenerales> getDatosGenerales(){
        ArrayList<datosGenerales> lista=new ArrayList<datosGenerales>();
        Cursor c=db.rawQuery("select _id, Nombre, Alias, FNacimiento, Edad, LNacimiento, Sexo, Folio, FEntrevista, DuraciónE, Entrevistador, " +
                "ObservacionesF, Tipo, ASSIST, TieneVerificacion, TieneEvaluacion, TieneDomicilioS, OtrosHabitantes, Entrevistada, AntecedentePenal, " +
                "Delito, OtroDelito, CarpetaInvestigacion " + "  from imputado_datos_generales",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                //region Asignamos el valor en nuestras variables para crear un nuevo objeto Comentario
                String r1=c.getString(c.getColumnIndex("Nombre"));
                String r2=c.getString(c.getColumnIndex("Alias"));
                String r3=c.getString(c.getColumnIndex("FNacimiento"));
                String r4=c.getString(c.getColumnIndex("Edad"));
                String r5=c.getString(c.getColumnIndex("LNacimiento"));
                String r6=c.getString(c.getColumnIndex("Sexo"));
                String folio=c.getString(c.getColumnIndex("Folio"));
                String r98=c.getString(c.getColumnIndex("FEntrevista"));
                String min=c.getString(c.getColumnIndex("DuraciónE"));
                String r96=c.getString(c.getColumnIndex("Entrevistador"));
                String r99=c.getString(c.getColumnIndex("ObservacionesF"));
                String r100=c.getString(c.getColumnIndex("Tipo"));
                String assist=c.getString(c.getColumnIndex("ASSIST"));
                String tieneVerificacion=c.getString(c.getColumnIndex("TieneVerificacion"));
                String tieneEvaluacion=c.getString(c.getColumnIndex("TieneEvaluacion"));
                String r21_1=c.getString(c.getColumnIndex("TieneDomicilioS"));
                String r32=c.getString(c.getColumnIndex("OtrosHabitantes"));
                String r1_1=c.getString(c.getColumnIndex("Entrevistada"));
                String r1_2=c.getString(c.getColumnIndex("AntecedentePenal"));
                String r31_1=c.getString(c.getColumnIndex("Delito"));
                String r31_2=c.getString(c.getColumnIndex("OtroDelito"));
                String r31_3=c.getString(c.getColumnIndex("CarpetaInvestigacion"));



                int id=c.getInt(c.getColumnIndex("_id"));
                datosGenerales dato =new datosGenerales(id,r1,r2, r3, r4, r5, r6, folio, r98, min, r96, r99, r100, assist, tieneVerificacion,
                        tieneEvaluacion, r21_1, r32, r1_1, r1_2, r31_1, r31_2,r31_3);
                //endregion

                //Añadimos el comentario a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }

    //endregion

    //region Obtener los datos del domicilio en la base de datos
    public ArrayList<datosDomicilio> getDomicilios(){
        ArrayList<datosDomicilio> lista = new ArrayList<datosDomicilio>();
        Cursor c=db.rawQuery("select _id, e7, e7_1, e8, e9, e10, e11, e12, e13, e14, e15, e16, e32_1, " +
                "e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e21_2, e21_3, e29, e30, e31, e106, e107, Folio" +
                "  from imputado_datos_domicilio",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e7 = c.getString(c.getColumnIndex("e7"));
                String e7_1 = c.getString(c.getColumnIndex("e7_1"));
                String e8 = c.getString(c.getColumnIndex("e8"));
                String e9 = c.getString(c.getColumnIndex("e9"));
                String e10 = c.getString(c.getColumnIndex("e10"));
                String e11 = c.getString(c.getColumnIndex("e11"));
                String e12 = c.getString(c.getColumnIndex("e12"));
                String e13 = c.getString(c.getColumnIndex("e13"));
                String e14 = c.getString(c.getColumnIndex("e14"));
                String e15 = c.getString(c.getColumnIndex("e15"));
                String e16 = c.getString(c.getColumnIndex("e16"));
                String e32_1 = c.getString(c.getColumnIndex("e32_1"));
                String e17 = c.getString(c.getColumnIndex("e17"));
                String e18 = c.getString(c.getColumnIndex("e18"));
                String e19 = c.getString(c.getColumnIndex("e19"));
                String e20 = c.getString(c.getColumnIndex("e20"));
                String e21 = c.getString(c.getColumnIndex("e21"));
                String e22 = c.getString(c.getColumnIndex("e22"));
                String e23 = c.getString(c.getColumnIndex("e23"));
                String e24 = c.getString(c.getColumnIndex("e24"));
                String e25 = c.getString(c.getColumnIndex("e25"));
                String e26 = c.getString(c.getColumnIndex("e26"));
                String e27 = c.getString(c.getColumnIndex("e27"));
                String e28 = c.getString(c.getColumnIndex("e28"));
                String e21_2 = c.getString(c.getColumnIndex("e21_2"));
                String e21_3 = c.getString(c.getColumnIndex("e21_3"));
                String e29 = c.getString(c.getColumnIndex("e29"));
                String e30 = c.getString(c.getColumnIndex("e30"));
                String e31 = c.getString(c.getColumnIndex("e31"));
                String e106 = c.getString(c.getColumnIndex("e106"));
                String e107 = c.getString(c.getColumnIndex("e107"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosDomicilio dato = new datosDomicilio(id, e7, e7_1, e8, e9, e10, e11, e12, e13, e14,
                        e15, e16, e32_1, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e21_2, e21_3, e29,
                        e30, e31, e106, e107, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos de los familiares y habitantes en la base de datos
    public ArrayList<datosHabitantes> getHabitantes(){
        ArrayList<datosHabitantes> lista = new ArrayList<datosHabitantes>();
        Cursor c=db.rawQuery("select _id, e32, e33, e34, e35, e36, e37, e33_1, e34_1, e35_1, " +
                "e36_1, e37_1, e33_2, e34_2, e35_2, e36_2, e37_2, e33_3, e34_3, e35_3, e36_3, " +
                "e37_3, e38, e32_2, e32_3, e32_4, e32_5, e32_6, e32_7, Folio" + "  from imputado_datos_habitantes",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e32 = c.getString(c.getColumnIndex("e32"));
                String e33 = c.getString(c.getColumnIndex("e33"));
                String e34 = c.getString(c.getColumnIndex("e34"));
                String e35 = c.getString(c.getColumnIndex("e35"));
                String e36 = c.getString(c.getColumnIndex("e36"));
                String e37 = c.getString(c.getColumnIndex("e37"));
                String e33_1 = c.getString(c.getColumnIndex("e33_1"));
                String e34_1 = c.getString(c.getColumnIndex("e34_1"));
                String e35_1 = c.getString(c.getColumnIndex("e35_1"));
                String e36_1 = c.getString(c.getColumnIndex("e36_1"));
                String e37_1 = c.getString(c.getColumnIndex("e37_1"));
                String e33_2 = c.getString(c.getColumnIndex("e33_2"));
                String e34_2 = c.getString(c.getColumnIndex("e34_2"));
                String e35_2 = c.getString(c.getColumnIndex("e35_2"));
                String e36_2 = c.getString(c.getColumnIndex("e36_2"));
                String e37_2 = c.getString(c.getColumnIndex("e37_2"));
                String e33_3 = c.getString(c.getColumnIndex("e33_3"));
                String e34_3 = c.getString(c.getColumnIndex("e34_3"));
                String e35_3 = c.getString(c.getColumnIndex("e35_3"));
                String e36_3 = c.getString(c.getColumnIndex("e36_3"));
                String e37_3 = c.getString(c.getColumnIndex("e37_3"));
                String e38 = c.getString(c.getColumnIndex("e38"));
                String e32_2 = c.getString(c.getColumnIndex("e32_2"));
                String e32_3 = c.getString(c.getColumnIndex("e32_3"));
                String e32_4 = c.getString(c.getColumnIndex("e32_4"));
                String e32_5 = c.getString(c.getColumnIndex("e32_5"));
                String e32_6 = c.getString(c.getColumnIndex("e32_6"));
                String e32_7 = c.getString(c.getColumnIndex("e32_7"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosHabitantes dato = new datosHabitantes(id, e32, e33, e34, e35, e36, e37, e33_1,
                        e34_1, e35_1, e36_1, e37_1, e33_2, e34_2, e35_2, e36_2, e37_2, e33_3, e34_3,
                        e35_3, e36_3, e37_3, e38, e32_2, e32_3, e32_4, e32_5, e32_6, e32_7, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos de las referencias en la base de datos
    public ArrayList<datosReferencias> getReferencias(){
        ArrayList<datosReferencias> lista = new ArrayList<datosReferencias>();
        Cursor c=db.rawQuery("select _id, e39, e40, e41, e42, e43, e39_1, e40_1, e41_1, e42_1, " +
                "e43_1, e44, e45, e46, e47, Folio" + "  from imputado_datos_referencias",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e39 = c.getString(c.getColumnIndex("e39"));
                String e40 = c.getString(c.getColumnIndex("e40"));
                String e41 = c.getString(c.getColumnIndex("e41"));
                String e42 = c.getString(c.getColumnIndex("e42"));
                String e43 = c.getString(c.getColumnIndex("e43"));
                String e39_1 = c.getString(c.getColumnIndex("e39_1"));
                String e40_1 = c.getString(c.getColumnIndex("e40_1"));
                String e41_1 = c.getString(c.getColumnIndex("e41_1"));
                String e42_1 = c.getString(c.getColumnIndex("e42_1"));
                String e43_1 = c.getString(c.getColumnIndex("e43_1"));
                String e44 = c.getString(c.getColumnIndex("e44"));
                String e45 = c.getString(c.getColumnIndex("e45"));
                String e46 = c.getString(c.getColumnIndex("e46"));
                String e47 = c.getString(c.getColumnIndex("e47"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosReferencias dato = new datosReferencias(id, e39, e40, e41, e42, e43, e39_1,
                        e40_1, e41_1, e42_1, e43_1, e44, e45, e46, e47, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos escolares y laborales en la base de datos
    public ArrayList<datosEscolarLaboral> getHistorialEscolarLaboral(){
        ArrayList<datosEscolarLaboral> lista = new ArrayList<datosEscolarLaboral>();
        Cursor c=db.rawQuery("select _id, e48, e49, e50, e51, e52, e53, e54, e55, e57, e56, e56_1, e58, " +
                "e51_1, e59, Folio" + "  from imputado_datos_historial_escolar_laboral",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e48 = c.getString(c.getColumnIndex("e48"));
                String e49 = c.getString(c.getColumnIndex("e49"));
                String e50 = c.getString(c.getColumnIndex("e50"));
                String e51 = c.getString(c.getColumnIndex("e51"));
                String e52 = c.getString(c.getColumnIndex("e52"));
                String e53 = c.getString(c.getColumnIndex("e53"));
                String e54 = c.getString(c.getColumnIndex("e54"));
                String e55 = c.getString(c.getColumnIndex("e55"));
                String e57 = c.getString(c.getColumnIndex("e57"));
                String e56 = c.getString(c.getColumnIndex("e56"));
                String e56_1 = c.getString(c.getColumnIndex("e56_1"));
                String e58 = c.getString(c.getColumnIndex("e58"));
                String e51_1 = c.getString(c.getColumnIndex("e51_1"));
                String e59 = c.getString(c.getColumnIndex("e59"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosEscolarLaboral dato = new datosEscolarLaboral(id, e48, e49, e50, e51, e52, e53,
                        e54, e55, e57, e56, e56_1, e58, e51_1, e59, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos del abandono de estado en la base de datos
    public ArrayList<datosAbandonoEstado> getDatosAbandonoEstado(){
        ArrayList<datosAbandonoEstado> lista = new ArrayList<datosAbandonoEstado>();
        Cursor c=db.rawQuery("select _id, e60, e61, e62, e63, e64, e64_1, e65, e65_1, " +
                "e65_2, e65_3, e65_4, e65_5, e65_6, e66, e67, e68, e69, e70, " +
                "e71, e72, e67_1, e68_1, e69_1, e70_1, e71_1, e72_1, e73, e74, e75, e76, e77, e78, " +
                "e74_1, e75_1, e76_1, e77_1, e78_1, e79, e80, e81, Folio" +
                "  from imputado_datos_abandono_estado",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e60 = c.getString(c.getColumnIndex("e60"));
                String e61 = c.getString(c.getColumnIndex("e61"));
                String e62 = c.getString(c.getColumnIndex("e62"));
                String e63 = c.getString(c.getColumnIndex("e63"));
                String e64 = c.getString(c.getColumnIndex("e64"));
                String e64_1 = c.getString(c.getColumnIndex("e64_1"));
                String e65 = c.getString(c.getColumnIndex("e65"));
                String e65_1 = c.getString(c.getColumnIndex("e65_1"));
                String e65_2 = c.getString(c.getColumnIndex("e65_2"));
                String e65_3 = c.getString(c.getColumnIndex("e65_3"));
                String e65_4 = c.getString(c.getColumnIndex("e65_4"));
                String e65_5 = c.getString(c.getColumnIndex("e65_5"));
                String e65_6 = c.getString(c.getColumnIndex("e65_6"));
                String e66 = c.getString(c.getColumnIndex("e66"));
                String e67 = c.getString(c.getColumnIndex("e67"));
                String e68 = c.getString(c.getColumnIndex("e68"));
                String e69 = c.getString(c.getColumnIndex("e69"));
                String e70 = c.getString(c.getColumnIndex("e70"));
                String e71 = c.getString(c.getColumnIndex("e71"));
                String e72 = c.getString(c.getColumnIndex("e72"));
                String e67_1 = c.getString(c.getColumnIndex("e67_1"));
                String e68_1 = c.getString(c.getColumnIndex("e68_1"));
                String e69_1 = c.getString(c.getColumnIndex("e69_1"));
                String e70_1 = c.getString(c.getColumnIndex("e70_1"));
                String e71_1 = c.getString(c.getColumnIndex("e71_1"));
                String e72_1 = c.getString(c.getColumnIndex("e72_1"));
                String e73 = c.getString(c.getColumnIndex("e73"));
                String e74 = c.getString(c.getColumnIndex("e74"));
                String e75 = c.getString(c.getColumnIndex("e75"));
                String e76 = c.getString(c.getColumnIndex("e76"));
                String e77 = c.getString(c.getColumnIndex("e77"));
                String e78 = c.getString(c.getColumnIndex("e78"));
                String e74_1 = c.getString(c.getColumnIndex("e74_1"));
                String e75_1 = c.getString(c.getColumnIndex("e75_1"));
                String e76_1 = c.getString(c.getColumnIndex("e76_1"));
                String e77_1 = c.getString(c.getColumnIndex("e77_1"));
                String e78_1 = c.getString(c.getColumnIndex("e78_1"));
                String e79 = c.getString(c.getColumnIndex("e79"));
                String e80 = c.getString(c.getColumnIndex("e80"));
                String e81 = c.getString(c.getColumnIndex("e81"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosAbandonoEstado dato = new datosAbandonoEstado(id, e60, e61, e62, e63,
                        e64, e64_1, e65, e65_1, e65_2, e65_3, e65_4, e65_5, e65_6,
                        e66, e67, e68, e69, e70, e71, e72, e67_1, e68_1, e69_1, e70_1, e71_1, e72_1,
                        e73, e74, e75, e76, e77, e78, e74_1, e75_1, e76_1, e77_1, e78_1, e79, e80,
                        e81, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos de salud en la base de datos
    public ArrayList<datosSalud> getDatosSalud(){
        ArrayList<datosSalud> lista = new ArrayList<datosSalud>();
        Cursor c=db.rawQuery("select _id, e82, e90_alcohol, e91_alcohol, e92_alcohol, e83, " +
                "e90_tabaco, e91_tabaco, e92_tabaco, e84, e90_marihuana, e91_marihuana, " +
                "e92_marihuana, e85, e90_pastillas, e91_pastillas, e92_pastillas, e86, " +
                "e90_solventes, e91_solventes, e92_solventes, e87, e90_cristal, e91_cristal, " +
                "e92_cristal, e88, e90_cocaina, e91_cocaina, e92_cocaina, e89, e93_otroConsumo, " +
                "e90_otroConsumo, e91_otroConsumo, e92_otroConsumo, e94, e95, Folio" +
                "  from imputado_datos_salud",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e82 = c.getString(c.getColumnIndex("e82"));
                String e90_alcohol = c.getString(c.getColumnIndex("e90_alcohol"));
                String e91_alcohol = c.getString(c.getColumnIndex("e91_alcohol"));
                String e92_alcohol = c.getString(c.getColumnIndex("e92_alcohol"));
                String e83 = c.getString(c.getColumnIndex("e83"));
                String e90_tabaco = c.getString(c.getColumnIndex("e90_tabaco"));
                String e91_tabaco = c.getString(c.getColumnIndex("e91_tabaco"));
                String e92_tabaco = c.getString(c.getColumnIndex("e92_tabaco"));
                String e84 = c.getString(c.getColumnIndex("e84"));
                String e90_marihuana = c.getString(c.getColumnIndex("e90_marihuana"));
                String e91_marihuana = c.getString(c.getColumnIndex("e91_marihuana"));
                String e92_marihuana = c.getString(c.getColumnIndex("e92_marihuana"));
                String e85 = c.getString(c.getColumnIndex("e85"));
                String e90_pastillas = c.getString(c.getColumnIndex("e90_pastillas"));
                String e91_pastillas = c.getString(c.getColumnIndex("e91_pastillas"));
                String e92_pastillas = c.getString(c.getColumnIndex("e92_pastillas"));
                String e86 = c.getString(c.getColumnIndex("e86"));
                String e90_solventes = c.getString(c.getColumnIndex("e90_solventes"));
                String e91_solventes = c.getString(c.getColumnIndex("e91_solventes"));
                String e92_solventes = c.getString(c.getColumnIndex("e92_solventes"));
                String e87 = c.getString(c.getColumnIndex("e87"));
                String e90_cristal = c.getString(c.getColumnIndex("e90_cristal"));
                String e91_cristal = c.getString(c.getColumnIndex("e91_cristal"));
                String e92_cristal = c.getString(c.getColumnIndex("e92_cristal"));
                String e88 = c.getString(c.getColumnIndex("e88"));
                String e90_cocaina = c.getString(c.getColumnIndex("e90_cocaina"));
                String e91_cocaina = c.getString(c.getColumnIndex("e91_cocaina"));
                String e92_cocaina = c.getString(c.getColumnIndex("e92_cocaina"));
                String e89 = c.getString(c.getColumnIndex("e89"));
                String e93_otroConsumo = c.getString(c.getColumnIndex("e93_otroConsumo"));
                String e90_otroConsumo = c.getString(c.getColumnIndex("e90_otroConsumo"));
                String e91_otroConsumo = c.getString(c.getColumnIndex("e91_otroConsumo"));
                String e92_otroConsumo = c.getString(c.getColumnIndex("e92_otroConsumo"));
                String e94 = c.getString(c.getColumnIndex("e94"));
                String e95 = c.getString(c.getColumnIndex("e95"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosSalud dato = new datosSalud(id, e82, e90_alcohol, e91_alcohol, e92_alcohol,
                        e83, e90_tabaco, e91_tabaco, e92_tabaco, e84, e90_marihuana, e91_marihuana,
                        e92_marihuana, e85, e90_pastillas, e91_pastillas, e92_pastillas, e86,
                        e90_solventes, e91_solventes, e92_solventes, e87, e90_cristal, e91_cristal,
                        e92_cristal, e88, e90_cocaina, e91_cocaina, e92_cocaina, e89,
                        e93_otroConsumo, e90_otroConsumo, e91_otroConsumo, e92_otroConsumo, e94,
                        e95, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos de la vicitma en la base de datos
    public ArrayList<datosVictima> getVictima(){
        ArrayList<datosVictima> lista = new ArrayList<datosVictima>();
        Cursor c=db.rawQuery("select _id, e101, e102, e103, e104, e105, Folio  from imputado_datos_victima",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e101 = c.getString(c.getColumnIndex("e101"));
                String e102 = c.getString(c.getColumnIndex("e102"));
                String e103 = c.getString(c.getColumnIndex("e103"));
                String e104 = c.getString(c.getColumnIndex("e104"));
                String e105 = c.getString(c.getColumnIndex("e105"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosVictima dato = new datosVictima(id, e101, e102, e103, e104, e105, Folio);
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos de observaciones en la base de datos
    public ArrayList<datosObservaciones> getObservaciones(){
        ArrayList<datosObservaciones> lista = new ArrayList<datosObservaciones>();
        Cursor c=db.rawQuery("select _id, Campo, Observacion , Folio from verificacion_observaciones",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String Campo = c.getString(c.getColumnIndex("Campo"));
                String Observacion = c.getString(c.getColumnIndex("Observacion"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosObservaciones dato = new datosObservaciones(id, Campo, Observacion , Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos del ASSIST
    public ArrayList<datosASSIST> getASSIST(){
        ArrayList<datosASSIST> lista = new ArrayList<datosASSIST>();
        Cursor c=db.rawQuery("select _id, Pa, Pb, Pc, Pd, Pe, Pf, Pg, Ph, Pi, Pj, JOtro, e8, Folio from assist",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String pa = c.getString(c.getColumnIndex("Pa"));
                String pb = c.getString(c.getColumnIndex("Pb"));
                String pc = c.getString(c.getColumnIndex("Pc"));
                String pd = c.getString(c.getColumnIndex("Pd"));
                String pe = c.getString(c.getColumnIndex("Pe"));
                String pf = c.getString(c.getColumnIndex("Pf"));
                String pg = c.getString(c.getColumnIndex("Pg"));
                String ph = c.getString(c.getColumnIndex("Ph"));
                String pi = c.getString(c.getColumnIndex("Pi"));
                String pj = c.getString(c.getColumnIndex("Pj"));
                String jOtro = c.getString(c.getColumnIndex("JOtro"));
                String e8 = c.getString(c.getColumnIndex("e8"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosASSIST dato = new datosASSIST(id, pa, pb, pc, pd, pe, pf, pg, ph, pi, pj, jOtro, e8, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener los datos del instrumento de evaluación de riesgo
    public ArrayList<datosEvaluacion> getEvaluacionRiesgos(){
        ArrayList<datosEvaluacion> lista = new ArrayList<datosEvaluacion>();
        Cursor c=db.rawQuery("select _id, Arraigo, ResidenciaEdo, AbandonoEdo, VoluntadSometimiento, Antecedentes, " +
                "MedidasNoPrivativas, Escala, Folio from eva_riesgos",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                int arraigo = c.getInt(c.getColumnIndex("Arraigo"));
                int residenciaEdo = c.getInt(c.getColumnIndex("ResidenciaEdo"));
                int abandonoEdo = c.getInt(c.getColumnIndex("AbandonoEdo"));
                int voluntadSometimiento = c.getInt(c.getColumnIndex("VoluntadSometimiento"));
                int antecedentes = c.getInt(c.getColumnIndex("Antecedentes"));
                int medidasNoPrivativas = c.getInt(c.getColumnIndex("MedidasNoPrivativas"));
                int escala = c.getInt(c.getColumnIndex("Escala"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosEvaluacion dato = new datosEvaluacion(id, arraigo, residenciaEdo, abandonoEdo, voluntadSometimiento, antecedentes,
                        medidasNoPrivativas, escala, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener datos de entrevistador
    public ArrayList<datosEntrevistador> getEntrevistador(){
        ArrayList<datosEntrevistador> lista = new ArrayList<datosEntrevistador>();
        Cursor c=db.rawQuery("select _id, codigo, nombre from entrevistador",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String codigo = c.getString(c.getColumnIndex("codigo"));
                String nombre = c.getString(c.getColumnIndex("nombre"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosEntrevistador dato = new datosEntrevistador(id, codigo, nombre);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //region Obtener datos Carpeta Investigacion
    public ArrayList<datosCarpetaInvestigacion> getCarpetaInvestigacion(){
        ArrayList<datosCarpetaInvestigacion> lista = new ArrayList<datosCarpetaInvestigacion>();
        Cursor c=db.rawQuery("select _id, noCarpetaInvestigacion, e111, e112, e113, e114, e115, e116, e117, e118, e119, e120, e121, e122, e123, e124, e125, e126, Folio",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String carpeta= c.getString(c.getColumnIndex("noCarpetaInvestigacion"));
                String e111=c.getString(c.getColumnIndex("e111"));
                String e112=c.getString(c.getColumnIndex("e112"));
                String e113=c.getString(c.getColumnIndex("e113"));
                String e114=c.getString(c.getColumnIndex("e114"));
                String e115=c.getString(c.getColumnIndex("e115"));
                String e116=c.getString(c.getColumnIndex("e116"));
                String e117=c.getString(c.getColumnIndex("e117"));
                String e118=c.getString(c.getColumnIndex("e118"));
                String e119=c.getString(c.getColumnIndex("e119"));
                String e120=c.getString(c.getColumnIndex("e120"));
                String e121=c.getString(c.getColumnIndex("e121"));
                String e122=c.getString(c.getColumnIndex("e122"));
                String e123=c.getString(c.getColumnIndex("e123"));
                String e124=c.getString(c.getColumnIndex("e124"));
                String e125=c.getString(c.getColumnIndex("e125"));
                String e126=c.getString(c.getColumnIndex("e126"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosCarpetaInvestigacion dato = new datosCarpetaInvestigacion(id, e111, e112, e113, e114, e115, e116, e117, e118, e119, e120, e121, e122, e123, e124, e125, e126, carpeta, Folio);

                //Añadimos la direccion a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }
        //Cerramos el cursor
        c.close();
        return lista;
    }
    //endregion

    //endregion

    //region Actualizacion, Borrar Cursor

    //region Actualiza una tabla a partir de una observacion
    public void updateTable(String table, String field, String observation, String folio){
        ContentValues cv = new ContentValues();
        cv.put(field, observation);
        String[] args = new  String[]{folio};
        db.update(table, cv, "Folio=?", args);
    }
    //endregion

    //region Actualiza tabla entrevistador
    public void updateTableEntrevistador( String field, String codigo, String _id){
        ContentValues cv = new ContentValues();
        cv.put(field, codigo);
        String[] args = new  String[]{_id};
        db.update("entrevistador", cv, "_id=?", args);
    }
    //endregion

    //region Borrar un comentario a partir de su id
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("comments", "_id=?", args);
    }

    //endregion

    public Cursor raw() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DB_NAME , new String[]{});
        return res;
    }



    //endregion

}