package com.kgght.studybug.objects;

import android.graphics.Bitmap;

public class Picture {
	
	private ActiveArea activeArea;
	private Bitmap bmp;
	
	public Picture(Bitmap newBitmap) {
		bmp = newBitmap;
		activeArea = new ActiveArea();
	}
	
	public void setBitmap(Bitmap newBitmap){
		bmp = newBitmap;
	}
	
	public Bitmap getBitmap() {
		return bmp;
	}
	
	public ActiveArea getActiveArea(){
		return activeArea;
	}
	
	

}
