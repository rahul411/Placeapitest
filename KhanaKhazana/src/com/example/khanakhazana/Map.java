package com.example.khanakhazana;

import android.support.v4.app.FragmentActivity;
//import java.util.ArrayList;

//import android.app.ActionBar;
//import android.app.Activity;
//import android.app.ProgressDialog;
//import android.content.Context;
import android.content.Intent;
//import android.location.Criteria;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.AsyncTask;
import android.os.Bundle;
//import android.util.Log;
//import android.view.Menu;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.AbsListView;
//import android.widget.ListView;
//import android.widget.TextView;

//import com.example.khanakhazana.Restaurants.GetPlaces;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
//import com.google.android.gms.location.*;

public class Map extends FragmentActivity {

	private GoogleMap mMap;
	public   int Value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		 Intent mIntent = getIntent();
		  Value = mIntent.getIntExtra("position", 0);
		  setContentView(R.layout.activity_map);
		 /* mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
					.getMap();
		mMap.addMarker(new MarkerOptions()
		.title(Place.a[Value].getName())
		.position(
				new LatLng(Place.a[Value].getLatitude(),
					Place.a[Value].getLongitude()))
		.snippet(Place.a[Value].getVicinity()));
*/
		 
	               mMap =  ((SupportMapFragment)getSupportFragmentManager()
	                       .findFragmentById(R.id.map)).getMap();
	               mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	               
	               
	         mMap.addMarker(new MarkerOptions().
	         position(new LatLng(Place.a[Value].getLatitude(),
					Place.a[Value].getLongitude())).title(Place.a[Value].getName()));

CameraPosition cameraPosition = new CameraPosition.Builder()
	.target(new LatLng(Restaurants.loc.getLatitude(), Restaurants.loc.getLongitude())) // Sets the center of the map to Mountain View
	.zoom(14) // Sets the zoom
	.tilt(30) // Sets the tilt of the camera to 30 degrees
	.build(); // Creates a CameraPosition from the builder
mMap.animateCamera(CameraUpdateFactory
	.newCameraPosition(cameraPosition));
	
	}

	
	
	}

