package com.kgght.studybug.objects;

import android.graphics.Bitmap;

public class Picture {
	
	private ActiveArea activeArea;
	private Bitmap bmp;
	private String Question;
	private String Answer;
	
	public Picture(Bitmap newBitmap) {
		bmp = newBitmap;
		activeArea = new ActiveArea();
		Question = "";
		Answer = "";
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
	
	public void setActiveArea(int x1, int y1, int x2, int y2 ){
		activeArea.setActiveArea(x1, y1, x2, y2);
	}
	
	public String getQuestion (){
		return Question; 
	}
	public void setQuestion (String Q){
		Question = Q;
	}
	
	public String getAnswer (){
		return Answer; 
	}
	
	public void setAnswer (String A){
		Question = A;
	}

}
