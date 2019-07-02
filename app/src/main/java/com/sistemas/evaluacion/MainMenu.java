package com.sistemas.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sistemas.evaluacion.entidades.datosGenerales;
import com.sistemas.evaluacion.entidades.DatosEntrevistador;

import java.util.ArrayList;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //region Variables Globales
    private MyOpenHelper db;
    private ArrayList<datosGenerales> lista;
    private ArrayList<DatosEntrevistador> listaEntrevistador;
    public static String entrevistador;
    private TextView tvLista;
    public String tamaño="";
    ListToCSV convierte=new ListToCSV();
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //region Navigation Drawer
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent= new Intent(view.getContext(), entrevista.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //endregion

        db=new MyOpenHelper(this);
        lista=db.getDatosGenerales();
        tamaño=""+(lista.size());
        tvLista = (TextView) findViewById(R.id.tvLista);
        tvLista.setText(tamaño);

        //region entrevistador
        listaEntrevistador=db.getEntrevistador();
        entrevistador=listaEntrevistador.get(0).getCodigo();
        //endregion

        //db.nada();

        Button btnExport= (Button) findViewById(R.id.btnExport);
        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res=convierte.exportDB(getApplicationContext());

                if (res==true){
                    Toast.makeText(getApplicationContext(), "El archivo se guardo correctamente",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "El archivo NO se pudo guardar, ponerse en contacto con el administrador",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //endregion

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent= new Intent(this, Settings.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch(id){
            case R.id.nav_car:
                Intent intent= new Intent(this, ConsultaDomicilio.class);
                startActivity(intent);
                break;
            case R.id.nav_verificacion:
                Intent intent2= new Intent(this, verificacion.class);
                startActivity(intent2);
                break;
            case R.id.bd_nube:
                Intent intent3= new Intent(this, SincronizarBD.class);
                startActivity(intent3);
                break;
            case R.id.nav_manage:
                Intent intent4= new Intent(this, Settings.class);
                startActivity(intent4);
                break;
        }

        /*if (id == R.id.nav_verificacion) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.bd_nube) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
