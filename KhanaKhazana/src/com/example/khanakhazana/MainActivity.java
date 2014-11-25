package com.example.khanakhazana;

//import java.io.IOException;
//import java.util.List;
//import java.util.Locale;






import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
//import android.widget.Button;
//import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends ActionBarActivity {
	 
	private ImageButton imagebutton1,imagebutton2,imagebutton3,imagebutton4,imagebutton5,imagebutton6;
	public static String typeOfPlace;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imagebutton1=(ImageButton) findViewById(R.id.imagebutton1);
		
		  imagebutton1.setOnClickListener(new View.OnClickListener() {
			  public void onClick(View view) {
				  Intent intent= new Intent(view.getContext(),Restaurants.class);
	              typeOfPlace="restaurant";
				  startActivityForResult(intent,0);
				  
			  }
			  });
			imagebutton2=(ImageButton) findViewById(R.id.imagebutton2);
			
			  imagebutton2.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view) {
					  Intent intent= new Intent(view.getContext(),Restaurants.class);
					  typeOfPlace="food&name=chinese";
					  startActivityForResult(intent,0);
				  }
				  });
			  imagebutton3=(ImageButton) findViewById(R.id.imagebutton3);
				
			  imagebutton3.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view) {
					  Intent intent= new Intent(view.getContext(),Restaurants.class);
					  typeOfPlace="food&name=pizza";
					  startActivityForResult(intent,0);
				  }
				  });
		    
			  imagebutton4=(ImageButton) findViewById(R.id.imagebutton4);
			  imagebutton4.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view){
					  Intent intent =new Intent(view.getContext(),Restaurants.class);
					  typeOfPlace="bakery";
					  startActivityForResult(intent,0);
				  }
			  });
			  
			  imagebutton5=(ImageButton) findViewById(R.id.imagebutton5);
			  imagebutton5.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view){
					  Intent intent =new Intent(view.getContext(),Restaurants.class);
					  typeOfPlace="food&name=icecream";
					  startActivityForResult(intent,0);
				  }
			  });
			  
			  imagebutton6=(ImageButton) findViewById(R.id.imagebutton6);
			  imagebutton6.setOnClickListener(new View.OnClickListener() {
				  public void onClick(View view){
					  Intent intent =new Intent(view.getContext(),Restaurants.class);
					  typeOfPlace="cafe";
					  startActivityForResult(intent,0);
				  }
			  });
				  
	}
				
				
			
	


	
}	