package com.example.khanakhazana;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class StartActivity extends FragmentActivity {
    
	public Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		
		button= (Button) findViewById(R.id.startbutton1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(v.getContext(),MainActivity.class);
				startActivityForResult(intent,0);
				// TODO Auto-generated method stub
				
			}
		});
	}

	
}
