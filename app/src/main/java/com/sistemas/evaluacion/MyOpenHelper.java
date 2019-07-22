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
            "Entrevistada TEXT, AntecedentePenal TEXT, Delito TEXT, OtroDelito TEXT)";
    //endregion

    //region Tabla imputado_datos_domicilio
    private static final String CREATE_TABLE_IMPUTADO_DATOS_DOMICILIO="CREATE TABLE imputado_datos_domicilio (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e7 TEXT, e7_1 TEXT, e8 TEXT, e9 TEXT, e10 TEXT, e11 TEXT, e12 TEXT, e13 TEXT, e14 TEXT, e15 TEXT, e16 TEXT, e32_1 TEXT, e17 TEXT, e18 TEXT, e19 TEXT, e20 TEXT," +
            "e21 TEXT, e22 TEXT, e23 TEXT, e24 TEXT, e25 TEXT, e26 TEXT, e27 TEXT, e28 TEXT, e29 TEXT, e30 TEXT, e31 TEXT, e106 TEXT, e107 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_familiares
    private static final String CREATE_TABLE_IMPUTADO_DATOS_HABITANTES="CREATE TABLE imputado_datos_habitantes (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "e32 TEXT, e33 TEXT, e34 TEXT, e35 TEXT, e36 TEXT, e37 TEXT, e33_1 TEXT, e34_1 TEXT, e35_1 TEXT, e36_1 TEXT, e37_1 TEXT, " +
            "e33_2 TEXT, e34_2 TEXT, e35_2 TEXT, e36_2 TEXT, e37_2 TEXT, e33_3 TEXT, e34_3 TEXT, e35_3 TEXT, e36_3 TEXT, e37_3 TEXT, e38 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_referencias
    private static final String CREATE_TABLE_IMPUTADO_DATOS_REFERENCIAS="CREATE TABLE imputado_datos_referencias(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e39 TEXT, e40 TEXT, e41 TEXT, e42 TEXT, e43 TEXT, e39_1 TEXT, e40_1 TEXT, e41_1 TEXT, e42_1 TEXT, e43_1 TEXT, e44 TEXT, e45 TEXT," +
            "e46 TEXT, e47 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_historial_escolar_laboral
    private static final String CREATE_TABLE_IMPUTADOS_HISTORIAL_ESCOLAR_LABORAL="CREATE TABLE imputado_datos_historial_escolar_laboral (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e48 TEXT, e49 TEXT, e50 TEXT, e51 TEXT, e52 TEXT, e53 TEXT, e54 TEXT, e55 TEXT, e56 TEXT, e57 TEXT, e58 TEXT, e51_1 TEXT, e59 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputados_datos_abandono_estado
    private static final String CREATE_TABLE_IMPUTADOS_ABANDONO_ESTADO="CREATE TABLE imputados_datos_abandono_estado (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e60 TEXT, e61 TEXT, e62 TEXT, e63 TEXT, e64 TEXT, e65 TEXT, e66 TEXT, e67 TEXT, e68 TEXT, e69 TEXT, e70 TEXT, e71 TEXT, e72 TEXT," +
            "e67_1 TEXT, e68_1 TEXT, e69_1 TEXT, e70_1 TEXT, e71_1 TEXT, e72_1 TEXT, e73 TEXT, e74 TEXT, e75 TEXT, e76 TEXT, e77 TEXT, e78 TEXT," +
            "e74_1 TEXT, e75_1 TEXT, e76_1 TEXT, e77_1 TEXT, e78_1 TEXT, e79 TEXT, e80 TEXT, e81 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_salud
    private static final String CREATE_TABLE_IMPUTADOS_SALUD="CREATE TABLE imputado_datos_salud (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
            " AbandonoEdo INTEGER, VoluntadSometimiento INTEGER, Antecedentes INTEGER, MedidasNoPrivativas, Escala INTEGER, Folio TEXT)";
    //endregion

    //region Tabla entrevistador

    private static final String CREATE_TABLE_ENTREVISTADOR="CREATE TABLE entrevistador(_id INTEGER PRIMARY KEY AUTOINCREMENT, codigo TEXT, nombre TEXT)";
    private static final String INSERT_INTO_ENTREVISTADIR="INSERT INTO entrevistador (_id, codigo, nombre) VALUES(1, \"E1\", \"COMANDANTE\")";
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
        db.execSQL(CREATE_TABLE_IMPUTADOS_HISTORIAL_ESCOLAR_LABORAL);
        db.execSQL(CREATE_TABLE_IMPUTADOS_ABANDONO_ESTADO);
        db.execSQL(CREATE_TABLE_IMPUTADOS_SALUD);
        db.execSQL(CREATE_TABLE_VERIFICACION_OBSERVACIONES);
        db.execSQL(CREATE_TABLE_VERIFICACION_ENTREVISTADO);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_VICTIMA);
        db.execSQL(CREATE_TABLE_ENTREVISTADOR);
        db.execSQL(CREATE_TABLE_ASSIST);
        db.execSQL(CREATE_TABLE_EVA_RIESGOS);
        db.execSQL(INSERT_INTO_ENTREVISTADIR);
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
                                       String entrevistada, String antecedentePenal, String delito, String otroDelito){
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
        db.insert("imputado_datos_generales", null, dato);
    }
    //endregion

    //region Insertar Datos Generales Domicilio
    public void insertarDatosGeneralesDomicilio(String e7, String e7_1, String e8, String e9, String e10, String e11, String e12, String e13, String e14, String e15,
                                                String e16, String e32_1, String e17, String e18, String e19, String e20, String e21, String e22, String e23,
                                                String e24, String e25, String e26, String e27, String e28, String e29, String e30, String e31,
                                                String e106, String e107, String folio){
        ContentValues dato=new ContentValues();
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
                                        String e33_3, String e34_3, String e35_3, String e36_3, String e37_3, String e38, String folio){
        ContentValues dato=new ContentValues();
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
        dato.put("e38",e38);
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
                                            String e55, String e56, String e57, String e58, String e51_1, String e59, String folio) {
        ContentValues dato = new ContentValues();
        dato.put("e48", e48);
        dato.put("e49", e49);
        dato.put("e50", e50);
        dato.put("e51", e51);
        dato.put("e52", e52);
        dato.put("e53", e53);
        dato.put("e54", e54);
        dato.put("e55", e55);
        dato.put("e56", e56);
        dato.put("e57", e57);
        dato.put("e58", e58);
        dato.put("e51_1", e51_1);//TODO: agregar e51_1 a sincronizarBD
        dato.put("e59", e59);
        dato.put("Folio", folio);
        db.insert("imputado_datos_historial_escolar_laboral", null, dato);
    }
    //endregion

    //region Insertar Datos Abandodo Estado
    public void insertarDatosAbandonoEstado(String e60, String e61, String e62, String e63, String e64, String e65, String e66,
                                            String e67, String e68, String e69, String e70, String e71, String e72,
                                            String e67_1, String e68_1, String e69_1, String e70_1, String e71_1, String e72_1,
                                            String e73, String e74, String e75, String e76, String e77, String e78,
                                            String e74_1, String e75_1, String e76_1, String e77_1, String e78_1,
                                            String e79, String e80, String e81, String folio) {
        ContentValues dato = new ContentValues();
        dato.put("e60", e60);
        dato.put("e61", e61);
        dato.put("e62", e62);
        dato.put("e63", e63);
        dato.put("e64", e64);
        dato.put("e65", e65);
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
        db.insert("imputados_datos_abandono_estado", null, dato);
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

    public ArrayList<datosGenerales> getDatosGenerales(){
        ArrayList<datosGenerales> lista=new ArrayList<datosGenerales>();
        Cursor c=db.rawQuery("select _id, Nombre, Alias, FNacimiento, Edad, LNacimiento, Sexo, Folio, FEntrevista, DuraciónE, Entrevistador, " +
                "ObservacionesF, Tipo, ASSIST, TieneVerificacion, TieneEvaluacion, TieneDomicilioS, OtrosHabitantes, Entrevistada, AntecedentePenal, " +
                "Delito, OtroDelito " + "  from imputado_datos_generales",  null);
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



                int id=c.getInt(c.getColumnIndex("_id"));
                datosGenerales dato =new datosGenerales(id,r1,r2, r3, r4, r5, r6, folio, r98, min, r96, r99, r100, assist, tieneVerificacion,
                        tieneEvaluacion, r21_1, r32, r1_1, r1_2, r31_1, r31_2);
                //endregion

                //Añadimos el comentario a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }

    //region Obtener los datos del domicilio en la base de datos
    public ArrayList<datosDomicilio> getDomicilios(){
        ArrayList<datosDomicilio> lista = new ArrayList<datosDomicilio>();
        Cursor c=db.rawQuery("select _id, e7, e7_1, e8, e9, e10, e11, e12, e13, e14, e15, e16, e32_1, " +
                "e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e106, e107, Folio" +
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
                String e29 = c.getString(c.getColumnIndex("e29"));
                String e30 = c.getString(c.getColumnIndex("e30"));
                String e31 = c.getString(c.getColumnIndex("e31"));
                String e106 = c.getString(c.getColumnIndex("e106"));
                String e107 = c.getString(c.getColumnIndex("e107"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosDomicilio dato = new datosDomicilio(id, e7, e7_1, e8, e9, e10, e11, e12, e13, e14,
                        e15, e16, e32_1, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27, e28, e29,
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
                "e37_3, e38, Folio" + "  from imputado_datos_habitantes",  null);
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
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosHabitantes dato = new datosHabitantes(id, e32, e33, e34, e35, e36, e37, e33_1,
                        e34_1, e35_1, e36_1, e37_1, e33_2, e34_2, e35_2, e36_2, e37_2, e33_3, e34_3,
                        e35_3, e36_3, e37_3, e38, Folio);

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
        Cursor c=db.rawQuery("select _id, e48, e49, e50, e51, e52, e53, e54, e55, e57, e56, e58, " +
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
                String e58 = c.getString(c.getColumnIndex("e58"));
                String e51_1 = c.getString(c.getColumnIndex("e51_1"));
                String e59 = c.getString(c.getColumnIndex("e59"));
                String Folio = c.getString(c.getColumnIndex("Folio"));

                int id = c.getInt(c.getColumnIndex("_id"));
                datosEscolarLaboral dato = new datosEscolarLaboral(id, e48, e49, e50, e51, e52, e53,
                        e54, e55, e57, e56, e58, e51_1, e59, Folio);

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
        Cursor c=db.rawQuery("select _id, e60, e61, e62, e63, e64, e65, e66, e67, e68, e69, e70, " +
                "e71, e72, e67_1, e68_1, e69_1, e70_1, e71_1, e72_1, e73, e74, e75, e76, e77, e78, " +
                "e74_1, e75_1, e76_1, e77_1, e78_1, e79, e80, e81, Folio" +
                "  from imputados_datos_abandono_estado",  null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                String e60 = c.getString(c.getColumnIndex("e60"));
                String e61 = c.getString(c.getColumnIndex("e61"));
                String e62 = c.getString(c.getColumnIndex("e62"));
                String e63 = c.getString(c.getColumnIndex("e63"));
                String e64 = c.getString(c.getColumnIndex("e64"));
                String e65 = c.getString(c.getColumnIndex("e65"));
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
                datosAbandonoEstado dato = new datosAbandonoEstado(id, e60, e61, e62, e63, e64, e65,
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

    public Cursor raw() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DB_NAME , new String[]{});
        return res;
    }

    public void nada(){
        System.out.println("si llego");
    }

}
