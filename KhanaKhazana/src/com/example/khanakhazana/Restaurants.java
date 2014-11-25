package com.example.khanakhazana;

import java.util.ArrayList;

import android.annotation.SuppressLint;
//import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
//import android.widget.AbsListView;
import android.widget.ListView;
//import android.widget.TextView;

//import com.example.khanakhazana.Restaurants.GetPlaces;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapFragment;
//import com.google.android.gms.maps.model.BitmapDescriptorFactory;
//import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;

public class Restaurants extends Activity {

	private final String TAG = getClass().getSimpleName();
	
	private String[] places;
	private LocationManager locationManager;
	public static Location loc;
	public String[] names1=new String[20];
	public int no=0;
	public static String typeOfPlace;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_restaurants);
	/*	RelativeLayout layout= (RelativeLayout)findViewById(R.id.layout1234);
	switch(MainActivity.typeOfPlace)
	{
	case "restaurant"       :	 layout.setBackgroundResource(R.drawable.restaurant);
	                             break;
	case "bakery"            :	 layout.setBackgroundResource(R.drawable.cake);
                                 break;
	case "cafe"              :	 layout.setBackgroundResource(R.drawable.download);
                                 break;                         
	case "food&name=chinese" :	 layout.setBackgroundResource(R.drawable.chinese);
                                  break;                         
	case "food&name=icecream" :	 layout.setBackgroundResource(R.drawable.icecream);
                                 break;                         
	case "food&name=pizza"   :	 layout.setBackgroundResource(R.drawable.pizz);
                                 break;
    default                   : break;                              
	}*/
		
		
		//names1[0]="purple";
			//names1[1]="red";
		
		//initCompo();
		places = getResources().getStringArray(R.array.places);
		currentLocation();
		
	/*	final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(ArrayAdapter.createFromResource(
				this, R.array.places, android.R.layout.simple_list_item_1),
				new ActionBar.OnNavigationListener() {

					@Override
					public boolean onNavigationItemSelected(int itemPosition,
							long itemId) {
						Log.e(TAG,
								places[itemPosition].toLowerCase().replace("-",
										"_"));
						if (loc != null) {
							mMap.clear();
							new GetPlaces(MainActivity.this,
									places[itemPosition].toLowerCase().replace(
											"-", "_").replace(" ", "_")).execute();
						}
						return true;
					}

				});
*/
	}	
	
	

	public class restaurantadapter extends BaseAdapter
	{
		ArrayList<SingleRow> list=new ArrayList<SingleRow>();
		 Context context;
		restaurantadapter(Context c)
		{    
			context=c;
			for(int i=0;i<no;i++)
				list.add(new SingleRow(names1[i],"open"));
			
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		
		@SuppressLint("ViewHolder")
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View row=(View) inflater.inflate(R.layout.activity_main1,parent,false);
			TextView title=(TextView) row.findViewById(R.id.textView1);
			TextView subtitle=(TextView) row.findViewById(R.id.textView2);
			SingleRow temp=list.get(position);
			title.setText(temp.titles);
			title.setTextColor(Color.parseColor("#f6a711"));
			subtitle.setText(temp.subtitle);
			subtitle.setTextColor(Color.parseColor("#f6a711"));
			return row;
		}
	}
    
	public class SingleRow
	{
	 String titles;
	 String subtitle;
	 SingleRow(String titles,String subtitle)
	 {
		 this.titles=titles;
		 this.subtitle=subtitle;
	 }
	}
	
	public class GetPlaces extends AsyncTask<Void, Void, ArrayList<Place>> {

		private ProgressDialog dialog;
		private Context context;
		private String places;
        public 	ArrayList<Place> findPlaces;
		public GetPlaces(Context context, String places) {
			this.context = context;
			this.places = places;
		}

		@Override
		protected void onPostExecute(ArrayList<Place> result) {
			super.onPostExecute(result);
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			no=result.size();
			for (int i = 0; i < result.size(); i++)
			{
				 names1[i]=result.get(i).getName();
			}
			//ArrayAdapter<String> adapt= new ArrayAdapter<String>(Restaurants.this ,R.layout.activity_main1,names1);
			 ListView list= (ListView) findViewById(R.id.listView1);
			 list.setAdapter(new restaurantadapter(Restaurants.this));
				// list= (ListView) findViewById(R.id.listView1);
			 list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				    public void onItemClick(AdapterView<?>  parent, View view, int position, long id) {
				    	Intent intent=new Intent(view.getContext(),Info.class);
				    	intent.putExtra("position",position);
                          startActivity(intent); 
				      // Do something like this
				       

				    }
					
			});
		//	registerClickCallback();
			/*for (int i = 0; i < result.size(); i++) {
				mMap.addMarker(new MarkerOptions()
						.title(result.get(i).getName())
						.position(
								new LatLng(result.get(i).getLatitude(), result
										.get(i).getLongitude()))
						.snippet(result.get(i).getVicinity()));
			}*/
		/*	CameraPosition cameraPosition = new CameraPosition.Builder()
					.target(new LatLng(result.get(0).getLatitude(), result.get(0).getLongitude())) // Sets the center of the map to Mountain View
					.zoom(14) // Sets the zoom
					.tilt(30) // Sets the tilt of the camera to 30 degrees
					.build(); // Creates a CameraPosition from the builder
			mMap.animateCamera(CameraUpdateFactory
					.newCameraPosition(cameraPosition));*/
		}
		
		
	//	private void registerClickCallback(){
		
		//}		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(context);
			dialog.setCancelable(false);
			dialog.setMessage("Loading..");
			dialog.isIndeterminate();
			dialog.show();
		}

		@Override
		protected ArrayList<Place> doInBackground(Void... arg0) {
			PlacesService service = new PlacesService(
					"AIzaSyAcHs_KfnIK-VRSASpc0_DTcz-yJFf7VlQ");
			 findPlaces = service.findPlaces(loc.getLatitude(), // 28.632808
					loc.getLongitude(), "places"); // 77.218276,places
			for (int i = 0; i < findPlaces.size(); i++) {
				Place placeDetail = findPlaces.get(i);
				Log.e(TAG, "places : " + placeDetail.getName());
			}
			return findPlaces;
		}

	}

	/*private void initCompo() {
		mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
	}*/

	
	
	  @Override
	   public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void currentLocation() {
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		String provider = locationManager
				.getBestProvider(new Criteria(), false);

		Location location = locationManager.getLastKnownLocation(provider);

		if (location == null) {
			locationManager.requestLocationUpdates(provider, 0, 0, listener);
		} else {
			loc = location;
			new GetPlaces(Restaurants.this, places[0].toLowerCase().replace(
					"-", "_")).execute();
			Log.e(TAG, "location : " + location);
		}

	}

	private LocationListener listener = new LocationListener() {

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {

		}

		@Override
		public void onProviderEnabled(String provider) {

		}

		@Override
		public void onProviderDisabled(String provider) {

		}

		@Override
		public void onLocationChanged(Location location) {
			Log.e(TAG, "location update : " + location);
			loc = location;
			locationManager.removeUpdates(listener);
		}
	};

	


	}
