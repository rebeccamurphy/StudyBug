package com.kgght.studybug.view;

import com.kgght.studybug.objects.FlipCard;
import com.kgght.studybug.objects.Picture;
import com.kgght.studybug.objects.Test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class QuestionView extends View{

	private Context myContext;
	private Test preTest;
	private int screenH;
	private int screenW;
	private Paint blackPaint;
	
	
	
	private Picture questionPic; 
	private FlipCard questionFlip;
	
	
	 public QuestionView(Context context) {
			super(context);
			myContext = context;
			screenH = myContext.getResources().getDisplayMetrics().heightPixels;
			screenW = myContext.getResources().getDisplayMetrics().widthPixels;
			//preTest = new Test(com.kgght.studybug.objects.PreTest.myTest;
			blackPaint = new Paint();
			blackPaint.setAntiAlias(true);
			blackPaint.setColor(Color.BLACK);
			blackPaint.setStyle(Paint.Style.STROKE);
			blackPaint.setTextAlign(Paint.Align.LEFT);
			blackPaint.setTextSize(screenH/12);
			
			//shuffle should come later.
			if (!com.kgght.studybug.objects.PreTest.flipq){
				//Log.d("Size", Boolean.toString(com.kgght.studybug.objects.PreTest.myTest.getPicList().isEmpty()));
				try{ questionPic = com.kgght.studybug.objects.PreTest.myTest.getPicList().get(com.kgght.studybug.objects.PreTest.qNum);
				} catch ( IndexOutOfBoundsException e ) {
					new AlertDialog.Builder(myContext)
				    .setTitle("Test Over!")
				    //.setMessage("?")
				    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
				        	Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreateScreen.class);
							myContext.startActivity(createIntent);
				        }
				    }
				    ).show();
					
				}
				com.kgght.studybug.objects.PreTest.qNum += 1;
			}
			else{
				
				try{ questionFlip = com.kgght.studybug.objects.PreTest.myTest.getFlipList().get(com.kgght.studybug.objects.PreTest.qNum);
				} catch ( IndexOutOfBoundsException e ) {
					new AlertDialog.Builder(myContext)
				    .setTitle("Test Over!")
				    //.setMessage("?")
				    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
				        	Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreateScreen.class);
							myContext.startActivity(createIntent);
				        }
				    }
				    ).show();
					
				}
				com.kgght.studybug.objects.PreTest.qNum += 1;
			}
	 }
	 @Override
		public void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
			screenW = w;
			screenH = h;
		}
	 
	 @Override
		protected void onDraw(Canvas canvas) {
			//canvas.drawText("Save", 50, screenH -blackPaint.getTextSize() , blackPaint);
			//canvas.drawText("Cancel",screenW-500, screenH -blackPaint.getTextSize() , blackPaint);
			if (questionPic != null){
				canvas.drawBitmap(questionPic.getBitmap(), (screenW - questionPic.getBitmap().getWidth()) / 2, 50, null);
				canvas.drawText(questionPic.getQuestion(), 50, screenH -blackPaint.getTextSize() , blackPaint);
			}
			
		}
	 
	 public boolean onTouchEvent(MotionEvent event) {
			if (questionPic != null){
		 	int eventaction = event.getAction();
			int X = (int) event.getX();
			int Y = (int) event.getY();
			Log.d("POINTS", Integer.toString(X) + " " + Integer.toString(Y));
			switch (eventaction) {

			case MotionEvent.ACTION_DOWN:
				if (questionPic.getActiveArea().checkSelection(X, Y)){
					Log.d("SAVE", Integer.toString(X) + " " + Integer.toString(Y));
					
					
					new AlertDialog.Builder(myContext)
				    .setTitle("Correct!")
				    //.setMessage("?")
				    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
							com.kgght.studybug.objects.PreTest.flipq = true;
				        	Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreatePreTest.class);
							myContext.startActivity(createIntent);
				        }
				    }//).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				       // public void onClick(DialogInterface dialog, int whichButton) {
				            // Do nothing.
				        //}
				    ).show();
					
				
				}
				else{
					new AlertDialog.Builder(myContext)
				    .setTitle("Try Again.")
				    //.setMessage("?")
				    //.setView(input)
				    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
							//do nothing
				        }
				    }//).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				       // public void onClick(DialogInterface dialog, int whichButton) {
				            // Do nothing.
				        //}
				    ).show();
				}
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_UP:
				break;
			}

			invalidate();
			}
			return true;
			
		}

}
