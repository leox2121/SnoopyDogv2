package com.records.irving.snoopydog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends Activity{

    //private GoogleMap mMap;
    GoogleMap googleMap;
    MapView mapView;

    @Override
    protected void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/

        mapView =(MapView)findViewById(R.id.mi_mapa);
        mapView.onCreate(savedInstanceState);

        googleMap=mapView.getMap();
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        googleMap.setMyLocationEnabled(true);

        googleMap.addMarker(new MarkerOptions().position(new LatLng(0.0, 00))
                .title("Marcador").draggable(true));

    }

    public void INICIO (View view){

        startActivity(new Intent(MapsActivity.this, MainActivity.class));
    }
    public void TIPS (View view){

        startActivity(new Intent(MapsActivity.this, Tips_Activity.class));
    }
    public void MAPAS (View view){

        startActivity(new Intent(MapsActivity.this, MapsActivity.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuAbout:
                startActivity(new Intent(this, About.class));
                return true;
            case R.id.confi:
                startActivity(new Intent(this, Configuracion.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
