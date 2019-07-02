package com.sistemas.evaluacion.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sistemas.evaluacion.CustomMapTileProvider;
import com.sistemas.evaluacion.MapsActivity;
import com.sistemas.evaluacion.R;
import com.sistemas.evaluacion.entrevista;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMyLocationClickListener, GoogleMap.OnMyLocationButtonClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback {

    //Request code for location permission request.
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

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
    private double currLat;
    private double currLong;
    private FusedLocationProviderClient fusedLocationClient;

    // A default location at the center of Durango to use when location permission is not granted.
    private final LatLng defaultLocation = new LatLng(24.0252891, -104.6613149);
    private static final int DEFAULT_ZOOM = 15;

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

        //Sets needed listeners
        gMap.setOnMyLocationButtonClickListener(this);
        gMap.setOnMyLocationClickListener(this);

        enableMyLocation();

        //region Get the address from the interview format
        String address = "";
        Bundle bundle = getActivity().getIntent().getExtras();
        if (bundle != null) {
            address = bundle.getString("address");
        }

        geocoder = new Geocoder(getContext(), Locale.getDefault());
        try {
            addresses = geocoder.getFromLocationName(address, 1);

            //Warn if no address is found
            if(addresses.size() == 0) {
                Toast.makeText(getContext(), "No se encontro el domicilio", Toast.LENGTH_LONG).show();
                getActivity().finish();
                return;
            }

            currLat = addresses.get(0).getLatitude();
            currLong = addresses.get(0).getLongitude();
        }
        catch (IOException e) {
            e.printStackTrace();

            currLat = defaultLocation.latitude;
            currLong = defaultLocation.longitude;

            // Construct a FusedLocationProviderClient.
            fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

            //region If there is no network to retrieve the address, try to center at the current location
            Task<Location> locationResult = fusedLocationClient.getLastLocation();
            locationResult.addOnCompleteListener(getActivity(), new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    if (task.isSuccessful()) {
                        // Set the map's camera position to the current location of the device.
                        Location lastLoc;
                        lastLoc = task.getResult();
                        currLat = lastLoc.getLatitude();
                        currLong = lastLoc.getLongitude();

                        marker.setPosition(new LatLng(currLat, currLong));

                        onMarkerDragEnd(marker);
                        //Initialize the zoom level
                        CameraUpdate zoom = CameraUpdateFactory.zoomTo(DEFAULT_ZOOM);
                        gMap.animateCamera(zoom);
                    }
                    else {
                        gMap.getUiSettings().setMyLocationButtonEnabled(false);
                    }
                }
            });
            //endregion
        }
        //endregion

        LatLng newLatLong = new LatLng(currLat, currLong);

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
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(DEFAULT_ZOOM);
        gMap.animateCamera(zoom);

        //Cache map for offline use
        gMap.addTileOverlay(new TileOverlayOptions().tileProvider(new CustomMapTileProvider(getResources().getAssets())));
    }
    //endregion

    @Override
    public void onMyLocationClick(@NonNull Location location) {

    }

    @Override
    public boolean onMyLocationButtonClick() {
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        }
    }

    //Checks if the result contains a PackageManager.PERMISSION_GRANTED result for a
    //permission from a runtime permissions request.
    public static boolean isPermissionGranted(String[] grantPermissions, int[] grantResults,
                                              String permission) {
        for (int i = 0; i < grantPermissions.length; i++) {
            if (permission.equals(grantPermissions[i])) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }
        return false;
    }

    //Requests the fine location permission. If a rationale with an additional explanation should
    //be shown to the user, displays a dialog that triggers the request.
    public static void requestPermission(AppCompatActivity activity, int requestId,
                                         String permission, boolean finishActivity) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            //TODO: Show rationale and request permission.
            //Always allow location access
        } else {
            // Location permission has not been granted yet, request it.
            ActivityCompat.requestPermissions(activity, new String[]{permission}, requestId);

        }
    }

    //Enables the My Location layer if the fine location permission has been granted.
    private void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            requestPermission((AppCompatActivity)getActivity(), LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (gMap != null) {
            // Access to the location has been granted to the app.
            gMap.setMyLocationEnabled(true);
        }
    }

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

        try {
            addresses = geocoder.getFromLocation(newLat, newLong, 1);

            String gMapAddress = addresses.get(0).getAddressLine(0);
            tViewAddress = (TextView) rootView.findViewById(R.id.address);
            tViewAddress.setText(gMapAddress);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //endregion

        LatLng newLatLong = new LatLng(newLat, newLong);
        //Move the camera to the marker
        CameraUpdate center = CameraUpdateFactory.newLatLng(newLatLong);
        gMap.moveCamera(center);
    }
    //endregion
}

