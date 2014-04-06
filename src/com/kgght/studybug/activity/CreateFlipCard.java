package com.kgght.studybug.activity;

import com.kgght.studybug.R;
import com.kgght.studybug.objects.FlipCard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateFlipCard extends Activity {
	private Button btnSave;
	private EditText qText; 
	private EditText aText;
	private FlipCard card;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.create_flip_card);
	
	qText = (EditText)findViewById(R.id.questionText);
	aText = (EditText)findViewById(R.id.answerText);
	
	addListenerOnButton();
	}

	 public void addListenerOnButton() {
		 
			
			btnSave = (Button) findViewById(R.id.btnSave);
		 
			btnSave.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
				//check question and answer are filled
				qText = (EditText)findViewById(R.id.questionText);
				aText = (EditText)findViewById(R.id.answerText);
				if ( qText.getText().toString().equals("") || aText.getText().toString().equals(""))
			    Toast.makeText(CreateFlipCard.this,"Fill out all fields!", Toast.LENGTH_SHORT).show();
				else {
					card = new FlipCard(qText.getText().toString(), aText.getText().toString());
					com.kgght.studybug.objects.PreTest.myTest.add(card);
					Toast.makeText(CreateFlipCard.this,"Saved!", Toast.LENGTH_SHORT).show();
					Intent createIntent = new Intent(CreateFlipCard.this, com.kgght.studybug.activity.CreateScreen.class);
					startActivity(createIntent);
				}
					
			  }
		 
			});
		  }
}
