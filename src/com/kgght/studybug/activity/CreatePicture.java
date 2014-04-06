package com.kgght.studybug.activity;

import com.kgght.studybug.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class CreatePicture extends Activity{

	 private Button btnSelectPic;
	 private Button btnDemoPic;
	 
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_picture);
	 
		addListenerOnButton();
	  }
	  public void addListenerOnButton() {
			 
			
			btnSelectPic = (Button) findViewById(R.id.btnSelectPic);
			btnSelectPic.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
				
			    Toast.makeText(CreatePicture.this,
				"Feature not yet completed.", Toast.LENGTH_SHORT).show();
			   
			}
		 
			});
			
			btnDemoPic = (Button) findViewById(R.id.btnDemoPic);
			btnDemoPic.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
						Intent createIntent = new Intent(getApplicationContext(), DemoPicture.class);
						startActivity(createIntent);
			     
			  }
		 
			});
		  }

}
