package com.kgght.studybug.activity;

import com.kgght.studybug.view.QuestionView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CreatePreTest extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		QuestionView QView = new QuestionView(this);
		QView.setKeepScreenOn(true); // keeps screen on for this view
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(QView);

	}
	

}
