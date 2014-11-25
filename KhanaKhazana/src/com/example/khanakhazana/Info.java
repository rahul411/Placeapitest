package com.example.khanakhazana;

//import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
//import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.net.Uri;

public class Info extends ActionBarActivity {
//public	 Place result1 = new Place();
public   int Value;
public   String vicinity;
public   String name;
public   Double phone_number;
private ImageButton button1;
private ImageButton button2;
public static int i=0;
	

 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  Intent mIntent = getIntent();
		  Value = mIntent.getIntExtra("position", 0);
		  i=0;
		   name=Place.a[Value].getName();
		   vicinity=Place.a[Value].getVicinity();
		  // phone_number=Place.a[Value].getphone();
		setContentView(R.layout.activity_info);
	   TextView	txt = (TextView)findViewById(R.id.text12);
	   txt.setTextColor(Color.parseColor("#f6a711"));
		txt.setText("Name:"+ name + "\nVicinity:" + vicinity );
		
		button1=(ImageButton) findViewById(R.id.mapbutton);
		
		  button1.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View view) {
			    	//Intent intent=new Intent(view.getContext(),Map.class);
			    	//intent.putExtra("position",Value);
                     // startActivity(intent);
//				  Intent navigation = new Intent(Intent.ACTION_VIEW, Uri
//					        .parse("http://maps.google.com/maps?saddr="
//					                + Place.a[Value].getLatitude() + ","
//					                + Place.a[Value].getLongitude() + "&daddr="
//					                + PlacesService.lat + "," + PlacesService.longi));
				  Intent navigation=new Intent(Intent.ACTION_VIEW,Uri.parse("http://maps.google.com/maps?q="+Place.a[Value].getName()
						  +Place.a[Value].getVicinity()));
				  navigation.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
				  startActivity(navigation);
			  }
			  });
		  
			button2=(ImageButton) findViewById(R.id.sharebutton);
			
			  button2.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view) {
				    	sendEmail();
				  }
				  }); 
	

}
	
     protected void sendEmail() {
         Log.i("Send email", "");

         String[] TO = {"enter the recipient email"};
         //String[] CC = {"mcmohd@gmail.com"};
         Intent emailIntent = new Intent(Intent.ACTION_SEND);
         emailIntent.setData(Uri.parse("mailto:"));
         emailIntent.setType("text/plain");


         emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
         //emailIntent.putExtra(Intent.EXTRA_CC, CC);
         //emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
         switch(MainActivity.typeOfPlace)
         {
         case "bakery"     :
         case "cafe"       :	 
         case "restaurant" :  emailIntent.putExtra(Intent.EXTRA_TEXT, Place.a[Value].getName()+"," + Place.a[Value].getVicinity()+", is an awesome  " + MainActivity.typeOfPlace );
                                                break;
         case "food&name=chinese": emailIntent.putExtra(Intent.EXTRA_TEXT, Place.a[Value].getName()+"," + Place.a[Value].getVicinity()+", is an awesome chinese restaurant" );
                                   break;   
         case "food&name=icecream": emailIntent.putExtra(Intent.EXTRA_TEXT, Place.a[Value].getName()+"," + Place.a[Value].getVicinity()+", is an awesome icecream place" );
                                    break;
         case "food&name=pizza": emailIntent.putExtra(Intent.EXTRA_TEXT, Place.a[Value].getName()+"," + Place.a[Value].getVicinity()+", is an awesome pizza place" );
                                  break;
          default:break;                        
         }
         
         try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
         } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Info.this, 
            "There is no email client installed.", Toast.LENGTH_SHORT).show();
         }
      }
     
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
