package com.sistemas.evaluacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import com.sistemas.evaluacion.entidades.datosGenerales;

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
            "ObservacionesF TEXT, Tipo TEXT)";
    //endregion

    //region Tabla imputado_datos_domicilio
    private static final String CREATE_TABLE_IMPUTADO_DATOS_DOMICILIO="CREATE TABLE imputado_datos_domicilio (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "e7 TEXT, e8 TEXT, e9 TEXT, e10 TEXT, e11 TEXT, e12 TEXT, e13 TEXT, e14 TEXT, e15 TEXT, e16 TEXT, e17 TEXT, e18 TEXT, e19 TEXT, e20 TEXT," +
            "e21 TEXT, e22 TEXT, e23 TEXT, e24 TEXT, e25 TEXT, e26 TEXT, e27 TEXT, e28 TEXT, e29 TEXT, e30 TEXT, e31 TEXT, Folio TEXT)";
    //endregion

    //region Tabla imputado_datos_familiares
    private static final String CREATE_TABLE_IMPUTADO_DATOS_FAMILIARES="CREATE TABLE imputado_datos_familiares (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
            "e48 TEXT, e49 TEXT, e50 TEXT, e51 TEXT, e52 TEXT, e53 TEXT, e54 TEXT, e55 TEXT, e56 TEXT, e57 TEXT, e58 TEXT, e59 TEXT, Folio TEXT)";
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
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_FAMILIARES);
        db.execSQL(CREATE_TABLE_IMPUTADO_DATOS_REFERENCIAS);
        db.execSQL(CREATE_TABLE_IMPUTADOS_HISTORIAL_ESCOLAR_LABORAL);
        db.execSQL(CREATE_TABLE_IMPUTADOS_ABANDONO_ESTADO);
        db.execSQL(CREATE_TABLE_IMPUTADOS_SALUD);
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
                                       String sexo, String folio, String fEntrevista, int duracionE, String entrevistador, String observacionesF, String tipo ){
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
        db.insert("imputado_datos_generales", null, dato);
    }
    //endregion

    //region Insertar Datos Generales Domicilio
    public void insertarDatosGeneralesDomicilio(String e7, String e8, String e9, String e10, String e11, String e12, String e13, String e14, String e15,
                                                String e16, String e17, String e18, String e19, String e20, String e21, String e22, String e23, String e24,
                                                String e25, String e26, String e27, String e28, String e29, String e30, String e31, String folio){
        ContentValues dato=new ContentValues();
        dato.put("e7", e7);
        dato.put("e7", e7);
        dato.put("e8", e8);
        dato.put("e9", e9);
        dato.put("e10", e10);
        dato.put("e11", e11);
        dato.put("e12", e12);
        dato.put("e13", e13);
        dato.put("e14", e14);
        dato.put("e15", e15);
        dato.put("e16", e16);
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
        db.insert("imputado_datos_familiares", null, dato);

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
                                            String e55, String e56, String e57, String e58, String e59, String folio) {
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

    public ArrayList<datosGenerales> getDatosGenerales(){
        ArrayList<datosGenerales> lista=new ArrayList<datosGenerales>();
        Cursor c=db.rawQuery("select _id, Nombre, Alias, FNacimiento, Edad, LNacimiento, Sexo, Folio, FEntrevista, DuraciónE, Entrevistador, ObservacionesF, Tipo" +
                "  from imputado_datos_generales",  null);
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


                int id=c.getInt(c.getColumnIndex("_id"));
                datosGenerales dato =new datosGenerales(id,r1,r2, r3, r4, r5, r6, folio, r98, min, r96, r99, r100);
                //endregion

                //Añadimos el comentario a la lista
                lista.add(dato);
            } while (c.moveToNext());
        }

        //Cerramos el cursor
        c.close();
        return lista;
    }

    public Cursor raw() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + DB_NAME , new String[]{});
        return res;
    }

    //endregion

}
