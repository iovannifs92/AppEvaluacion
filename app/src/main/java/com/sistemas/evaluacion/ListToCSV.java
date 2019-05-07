package com.sistemas.evaluacion;

import android.content.Context;
import android.os.Environment;
import java.io.FileOutputStream;
import java.nio.channels.*;
import java.io.File;
import java.io.FileInputStream;

public class ListToCSV {
    public boolean exportDB(Context context) {
        // TODO Auto-generated method stub
        boolean res=false;
        try {
            //File sd = new File("/sdcard");/sdcard/Download
            //File sd=Environment.getExternalStorageDirectory();
            File sd = new File("/storage/sdcard0/");
            //File sd=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            //File sd = new File("//sdcard//Download//");
            File data = Environment.getDataDirectory();
            res=sd.canWrite();



            if (sd.canWrite()) {
                String  currentDBPath= "//data//" + "com.sistemas.evaluacion"
                        + "//databases//" + "comments.sqlite";
                String backupDBPath  = "/Encuestas/T9EncuestaAndroid.sqlite";
                File currentDB = new File(data, currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                FileChannel src = new FileInputStream(currentDB).getChannel();
                FileChannel dst = new FileOutputStream(backupDB).getChannel();
                dst.transferFrom(src, 0, src.size());
                src.close();
                dst.close();
                String r=backupDB.toString();

            }
        } catch (Exception e) {
            res=false;
            String g= e.toString();


        }
        return res;
    }
}
