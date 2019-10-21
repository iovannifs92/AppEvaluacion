package com.sistemas.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class entrevista_adolescente extends AppCompatActivity {
    //region variables globales
    private MyOpenHelper db;
    //endregion

    //region TextView
    private TextView tvNc;


    //endregion

    //region EditText
    private EditText txtNc, txtFecha, txtNe, txtFolioA;
    //endregion EditText

    //reguin Sppiner
    private Spinner a;
    //endregion
    //region LinearLayout
    private LinearLayout ab;
    //endregionLinearLayout
    //region Buttons
    private Button btnGuardarA;

    //endregion Buttons
    //regionCheckedTextView
    CheckedTextView s;
    //endregion

    //Region String
    private String r1A, r2A, r3A, r4A;
    //endregion String

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrevista_adolescente);
        db=new MyOpenHelper(this);


            btnGuardarA=(Button) findViewById(R.id.btnGuardarA);
            btnGuardarA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    btnGuardarA.setEnabled(false);
                    //region Datos Generales
                    //region Difinicion de variables
                    txtNc=(EditText) findViewById(R.id.txtNc);
                    txtFecha=(EditText) findViewById(R.id.txtFecha);
                    txtNe=(EditText) findViewById(R.id.txtNe);
                    txtFolioA=(EditText) findViewById(R.id.txtFolioA);
                    //endregion variabels

                    r1A=txtNc.getText().toString().toUpperCase();
                    r2A=txtFecha.getText().toString().toUpperCase();
                    r3A=txtNe.getText().toString().toUpperCase();
                    r4A=txtFolioA.getText().toString().toUpperCase();
                    //endregion

                  // Base de datos  db.insertarDatosGeneralesA(r1A, r2A, r3A);

                }
            });

    }
}
