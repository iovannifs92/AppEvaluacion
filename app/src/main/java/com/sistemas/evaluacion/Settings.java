package com.sistemas.evaluacion;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sistemas.evaluacion.entrevista;

public class Settings extends AppCompatActivity {


    String pass="";
    EditText etEntrevistador;
    Button btnGuardarEntrevistador;
    private MyOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        etEntrevistador=(EditText) findViewById(R.id.etEntrevistador);
        btnGuardarEntrevistador=(Button) findViewById(R.id.btnGuardarEntrevistador);

        btnGuardarEntrevistador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputDialog();
            }
        });
    }

    private void showInputDialog() {
        LayoutInflater layoutInflater=LayoutInflater.from(Settings.this);
        View promtView= layoutInflater.inflate(R.layout.input_dialog,null);
        AlertDialog.Builder alertDialogBuilder= new AlertDialog.Builder(Settings.this);
        alertDialogBuilder.setView(promtView);
        db=new MyOpenHelper(this);
        db.getReadableDatabase();
        final String contraseña="s";

        final EditText etPass=(EditText) promtView.findViewById(R.id.etPass);
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        pass=etPass.getText().toString();
                        if(pass.equals(contraseña)){
                            db.updateTableEntrevistador("codigo", (etEntrevistador.getText().toString()).toUpperCase(), "1");
                            Toast.makeText(getApplicationContext(), "Se realizaron los cambios de manera correcta",Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(getApplicationContext(), MainMenu.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Contraseña incorrecta",Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }
}
