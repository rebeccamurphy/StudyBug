package com.kgght.studybug.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.kgght.studybug.R;

public class TitleView extends View {

	private Context myContext;
	private int screenW;
	private int screenH;
	
	public TitleView(Context context) {
		super(context);
		myContext = context;
	}
	
	@Override
	public void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		screenW = w;
		screenH = h;
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		
	}
}