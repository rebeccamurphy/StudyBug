package com.kgght.studybug.view;

import com.kgght.studybug.objects.ActiveArea;
import com.kgght.studybug.objects.Picture;

import com.kgght.studybug.R;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DemoView extends View {

	private Context myContext;
	private int screenW;
	private int screenH;
	private float scale;
	private Paint blackPaint;
	private Canvas canvas;
	private Bitmap demoPic;
	private Picture pic;
	private ActiveArea saveButton;
	private ActiveArea cancelButton;
	private boolean selectionComplete;
	private boolean selectionPartial;
	
	private Paint redPaint;
	private int pointX1;
	private int pointY1;
	private int pointX2;
	private int pointY2;
	private float radius;
	
	private int tlX;
	private int tlY;
	private int brX;
	private int brY; 
	
	
	
	 public DemoView(Context context) {
		super(context);
		myContext = context;
		demoPic = BitmapFactory.decodeResource(getResources(), R.drawable.face);
		pic = new Picture (demoPic);
		selectionComplete = false;
		selectionPartial = false;
		redPaint = new Paint();
		redPaint.setAntiAlias(true);
		redPaint.setColor(Color.RED);
		redPaint.setStrokeWidth(10);
		radius = 20;
		
		
		scale = myContext.getResources().getDisplayMetrics().density;
		screenH = myContext.getResources().getDisplayMetrics().heightPixels;
		screenW = myContext.getResources().getDisplayMetrics().widthPixels;
		blackPaint = new Paint();
		blackPaint.setAntiAlias(true);
		blackPaint.setColor(Color.BLACK);
		blackPaint.setStyle(Paint.Style.STROKE);
		blackPaint.setTextAlign(Paint.Align.LEFT);
		blackPaint.setTextSize(screenH/12);
		
		saveButton = new ActiveArea(50,screenH-100- (int) blackPaint.getTextSize(), 50 +(int) blackPaint.measureText("Save") , screenH );
		Log.d("Active Area Dimensionss Save", saveButton.toString());
		cancelButton = new ActiveArea(screenW/2,screenH-100- (int) blackPaint.getTextSize(), 500 +(int) blackPaint.measureText("Cancel") , screenH );
		Log.d("Dimensions", "(" +screenW + "," + screenH +")");
		Log.d("Active Area Dimensionss Cancel", cancelButton.toString());
	 }
	 
	 @Override
		public void onSizeChanged(int w, int h, int oldw, int oldh) {
			super.onSizeChanged(w, h, oldw, oldh);
			screenW = w;
			screenH = h;
		}
	 
	 @Override
		protected void onDraw(Canvas canvas) {
			canvas.drawText("Save", 50, screenH -blackPaint.getTextSize() , blackPaint);
			canvas.drawText("Cancel",screenW-500, screenH -blackPaint.getTextSize() , blackPaint);
			
			canvas.drawBitmap(demoPic, (screenW - demoPic.getWidth()) / 2, 50, null);
			if (selectionPartial)
				canvas.drawCircle(pointX1, pointY1, radius, redPaint);
			else if (selectionComplete){
				//horizontal
				canvas.drawLine(pointX1, pointY1, pointX2, pointY1, redPaint);
				canvas.drawLine(pointX1, pointY2, pointX2, pointY2, redPaint);
				//vertical
				canvas.drawLine(pointX1, pointY1, pointX1, pointY2, redPaint);
				canvas.drawLine(pointX2, pointY1, pointX2, pointY2, redPaint);
				
				if (pointX1 < pointX2 && pointY1 < pointY2 ){
					//topleft bottom right
					tlX = pointX1;
					tlY = pointY1;
					brX = pointX2;
					brY = pointY2;
				}
				else{
					tlX = pointX2;
					tlY = pointY2;
					brX = pointX1;
					brY = pointY1;
				}
					
				Log.d("Active Area", "(" + Integer.toString(tlX) + ", " + Integer.toString(tlY) + ") ("  
						+ Integer.toString(brX) + ", " + Integer.toString(brY) + ")");
			}

	 }
	 
	 public boolean onTouchEvent(MotionEvent event) {
			int eventaction = event.getAction();
			int X = (int) event.getX();
			int Y = (int) event.getY();
			Log.d("POINTS", Integer.toString(X) + " " + Integer.toString(Y));
			switch (eventaction) {

			case MotionEvent.ACTION_DOWN:
				if (saveButton.checkSelection(X, Y) && selectionComplete){
					Log.d("SAVE", Integer.toString(X) + " " + Integer.toString(Y));
					final EditText input = new EditText(myContext);
					
					new AlertDialog.Builder(myContext)
				    .setTitle("Enter Question:")
				    //.setMessage("?")
				    .setView(input)
				    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
				            Editable value = input.getText(); 
				            pic.setQuestion(value.toString());
				            pic.setActiveArea(tlX,tlY, brX, brY);
				            pic.setBitmap(demoPic);
							com.kgght.studybug.objects.PreTest.myTest.add(pic);
							Log.d("Size", Boolean.toString(com.kgght.studybug.objects.PreTest.myTest.getPicList().isEmpty()));
							Toast.makeText(myContext,
									"Saved!", Toast.LENGTH_SHORT).show();
							Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreateScreen.class);
							myContext.startActivity(createIntent);
				        }
				    }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int whichButton) {
				            // Do nothing.
				        }
				    }).show();
					
				
				}
				else if (cancelButton.checkSelection(X, Y)){
					Log.d("CANCEL", Integer.toString(X) + " " + Integer.toString(Y));
					selectionComplete=false;
					selectionPartial= false;
				}
				else if (selectionPartial){
					//Log.d("box", "drawing");
					selectionPartial =false;
					pointX2 = X;
					pointY2 = Y;
					selectionComplete = true;
				}
				else if (X < screenH -200){
					pointX1 = X;
					pointY1 = Y;
					selectionPartial = true;
					}
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_UP:
				break;
			}

			invalidate();
			return true;
		}


}
