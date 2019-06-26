package com.sistemas.evaluacion.fragments;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.sistemas.evaluacion.CustomMapTileProvider;
import com.sistemas.evaluacion.MainActivity;
import com.sistemas.evaluacion.MapsActivity;
import com.sistemas.evaluacion.R;
import com.sistemas.evaluacion.entrevista;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    //region Global variables
    private View rootView;
    private GoogleMap gMap;
    private MapView mapView;
    private Marker loc;
    private TextView tViewAddress;
    private Button btnConfirm;
    private Marker marker;
    private List<Address> addresses;
    private Geocoder geocoder;
    //region EditText
    private EditText eTextLat;
    private EditText eTextLong;
    private EditText eTextAddress;
    private EditText eTextMunicipality;
    private EditText eTextState;
    private EditText eTextCountry;
    private EditText eTextZipCode;
    private EditText eTextNeighborhood;
    private EditText eTextStreet;
    private EditText eTextNumber;
    //endregion
    //endregion

    public MapsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_maps, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapView = (MapView) rootView.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    //region onMapReady
    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        gMap.addTileOverlay(new TileOverlayOptions().tileProvider(new CustomMapTileProvider(getResources().getAssets())));

        LatLng newLatLong = new LatLng(24+1/60., -(104+38/60.));
        /*CameraPosition camera = new CameraPosition.Builder()
                .target(newLatLong)
                .zoom(10)
                .bearing(0)
                .tilt(0)
                .build();
        gMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));*/

        //region Get the address from the interview format
        String address = "";
        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            address = bundle.getString("address");
        }

        /*geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocationName(address, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        //Warn if no address is found
        if(addresses.size() == 0) {
            Toast.makeText(getContext(), "No se encontro el domicilio", Toast.LENGTH_LONG).show();
            getActivity().finish();
            return;
        }

        double latitude = addresses.get(0).getLatitude();
        double longitude = addresses.get(0).getLongitude();
        LatLng newLatLong = new LatLng(latitude, longitude);*/
        marker = gMap.addMarker(new MarkerOptions()
                .position(newLatLong)
                .draggable(true));

        btnConfirm = (Button) rootView.findViewById(R.id.confirm);

        //region Sends the marker address back to the interview format
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String finalSubAdminArea = addresses.get(0).getSubAdminArea();
                String finalState = addresses.get(0).getAdminArea();
                String finalZipCode = addresses.get(0).getPostalCode();
                String finalNeighborhood = addresses.get(0).getSubLocality();
                String finalStreet = addresses.get(0).getThoroughfare();
                String finalNumber = addresses.get(0).getSubThoroughfare();

                double lat = addresses.get(0).getLatitude();
                String finalLatitude = String.valueOf(lat);
                double lon = addresses.get(0).getLongitude();
                String finalLongitude = String.valueOf(lon);

                Intent intent = new Intent(v.getContext(), entrevista.class);
                intent.putExtra("confirmedStreet", finalStreet);
                intent.putExtra("confirmedNumber", finalNumber);
                intent.putExtra("confirmedNeighborhood", finalNeighborhood);
                intent.putExtra("confirmedMunicipality", finalSubAdminArea);
                intent.putExtra("confirmedState", finalState);
                intent.putExtra("confirmedLatitude", finalLatitude);
                intent.putExtra("confirmedLongitude", finalLongitude);
                getActivity().setResult(MapsActivity.RESULT_OK, intent);
                getActivity().finish();
            }
        });
        //endregion

        gMap.setOnMarkerDragListener(this);

        onMarkerDragEnd(marker);
        //Initialize the zoom level
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        gMap.animateCamera(zoom);
    }
    //endregion

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    //region onMarkerDragEnd
    @Override
    public void onMarkerDragEnd(Marker marker) {
        //region Get the marker address
        double newLat = marker.getPosition().latitude;
        double newLong = marker.getPosition().longitude;

        /*try {
            addresses = geocoder.getFromLocation(newLat, newLong, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*String gMapAddress = addresses.get(0).getAddressLine(0);
        tViewAddress = (TextView) rootView.findViewById(R.id.address);
        tViewAddress.setText(gMapAddress);*/
        //endregion

        LatLng newLatLong = new LatLng(newLat, newLong);
        //Move the camera to the marker
        CameraUpdate center = CameraUpdateFactory.newLatLng(newLatLong);
        gMap.moveCamera(center);
    }
    //endregion
}
