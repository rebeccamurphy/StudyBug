package com.kgght.studybug.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.util.Log.*;

import com.kgght.studybug.R;
import com.kgght.studybug.activity.CreateScreen;
import com.kgght.studybug.objects.ActiveArea;
import com.kgght.studybug.objects.Test;


public class TitleView extends View {

	private Context myContext;
	private int screenW;
	private int screenH;
	private int numOptions = 3; //kinds of tests added so far
	private float scale;
	private Paint blackPaint;
	
	private ActiveArea flipCardButton;
	private ActiveArea pictureButton;
	private ActiveArea preTestButton;
	
	public TitleView(Context context) {
		super(context);
		myContext = context;
		
		scale = myContext.getResources().getDisplayMetrics().density;
		
		screenH = myContext.getResources().getDisplayMetrics().heightPixels;
		screenW = myContext.getResources().getDisplayMetrics().widthPixels;
		blackPaint = new Paint();
		blackPaint.setAntiAlias(true);
		blackPaint.setColor(Color.BLACK);
		blackPaint.setStyle(Paint.Style.STROKE);
		blackPaint.setTextAlign(Paint.Align.LEFT);
		blackPaint.setTextSize(screenH/9);
		Log.d("size", Integer.toString(screenW));
		
	
		flipCardButton = new ActiveArea(0,0, screenW, (int) blackPaint.getTextSize());
		pictureButton = new ActiveArea(0, 100 +(int) blackPaint.getTextSize(), screenW, 100+(int) blackPaint.getTextSize()*2);
		preTestButton = new ActiveArea(0, 200+(int) blackPaint.getTextSize()*2, screenW, 200+(int) blackPaint.getTextSize()*3);
		
		
		
		}
	@Override
	public void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		screenW = w;
		screenH = h;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawText("FlipCard", 20, blackPaint.getTextSize() , blackPaint);
		canvas.drawText("Picture", 20,100+ blackPaint.getTextSize()*2 , blackPaint);
		canvas.drawText("PreTest", 20,200+blackPaint.getTextSize()*3 , blackPaint);
		
		
	}
	public boolean onTouchEvent(MotionEvent event) {
		int eventaction = event.getAction();
		int X = (int) event.getX();
		int Y = (int) event.getY();

		switch (eventaction) {

		case MotionEvent.ACTION_DOWN:
			if (flipCardButton.checkSelection(X, Y)){
				Log.d("FLIP", Integer.toString(X) + " " + Integer.toString(Y));
				Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreateFlipCard.class);
				myContext.startActivity(createIntent);
				}
			else if (pictureButton.checkSelection(X, Y)) {
				Log.d("PIC", Integer.toString(X) + " " + Integer.toString(Y));
				Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreatePicture.class);
				myContext.startActivity(createIntent);
				}
			else if (preTestButton.checkSelection(X, Y)){
				Log.d("PreTest", Integer.toString(X) + " " + Integer.toString(Y));
				Intent createIntent = new Intent(myContext, com.kgght.studybug.activity.CreatePreTest.class);
				myContext.startActivity(createIntent);
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