package com.kgght.studybug.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.kgght.studybug.R;
import com.kgght.studybug.objects.PreTest;
import com.kgght.studybug.view.DemoView;
import com.kgght.studybug.view.TitleView;

public class DemoPicture extends Activity {

	private Button btnSave;
	 @Override
	  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.demo_picture);
		DemoView dView = new DemoView(this);
		dView.setKeepScreenOn(true); // keeps screen on for this view
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(dView);

		//addListenerOnButton();
		
	  }
	 /*
	  public void addListenerOnButton() {
	 
	
		btnSave = (Button) findViewById(R.id.btnSelectPic);
		btnSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
		
			//com.kgght.studybug.view.TitleView.myTest.add(pic);
				Toast.makeText(DemoPicture.this,
				"Saved!", Toast.LENGTH_SHORT).show();
	   
			}

		});
	}*/
}