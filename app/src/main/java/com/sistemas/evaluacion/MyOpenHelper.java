package com.sistemas.evaluacion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;


public class MyOpenHelper extends SQLiteOpenHelper {
    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE comments(_id INTEGER PRIMARY KEY AUTOINCREMENT, r1 TEXT, r2 TEXT, r3 TEXT, r4 TEXT, r5 TEXT, r6 TEXT, r8 TEXT, r8a TEXT, r9 TEXT, r10 TEXT, r11 TEXT, r12 TEXT, r13 TEXT, r14 TEXT, r15 TEXT, r16 TEXT, r17 TEXT, r18 TEXT, r19 TEXT, r20 TEXT, r21 TEXT, r21a TEXT,r22 TEXT, r22a TEXT, r23 TEXT, r24 TEXT, r25 TEXT)";
    private static final String DB_NAME="comments.sqlite";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public MyOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db=this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(COMMENTS_TABLE_CREATE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //Insertar un nuevo comentario
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

    //Borrar un comentario a partir de su id
    public void borrar(int id){
        String[] args = new String[]{String.valueOf(id)};
        db.delete("comments", "_id=?", args);
    }



    //Obtener la lista de comentarios en la base de datos
    public ArrayList<Comentario> getComments(){
        //Creamos el cursor
        ArrayList<Comentario> lista=new ArrayList<Comentario>();
        Cursor c = db.rawQuery("select _id, r1,r2, r3, r4, r5, r6, r8, r8a, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r21a, r22, r22a, r23, r24, r25  from comments", null);
        if (c != null && c.getCount()>0) {
            c.moveToFirst();
            do {
                //Asignamos el valor en nuestras variables para crear un nuevo objeto Comentario
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

                //Añadimos el comentario a la lista
                lista.add(com);
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
}
