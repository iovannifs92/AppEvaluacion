package com.sistemas.evaluacion;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sistemas.evaluacion.fragments.MapsFragment;

public class MapsActivity extends AppCompatActivity {

    Fragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        if(savedInstanceState == null) {
            mapFragment = new MapsFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mapFragment).commit();
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
