package com.kgght.studybug.objects;

public class ActiveArea {

	private int[]  topleft = new int[2]; 
	private int[]  botright = new int[2];
	
	public ActiveArea() {
		
	}
	
	public ActiveArea(int[] tl, int[] br){
		topleft =tl;
		botright =br;
	}
	public ActiveArea(int x1,int y1, int x2, int y2){
		topleft[0] = x1;
		topleft[1] = y1;
		botright[0] = x2;
		botright[1] =y2;
	}
	
	public void setActiveArea(int[] tl, int[] br){
		topleft =tl;
		botright =br;
	}
	
	public int[] getTL(){
		return topleft;
	}
	
	public int[] getBR(){
		return botright;
	}
	
	private int getTLX(){
		return topleft[0];
	}
	
	private int getTLY(){
		return topleft[1];
	}
	
	private int getBRX(){
		return botright[0];
	}
	
	private int getBRY(){
		return botright[1];
	}
	
	
	public boolean checkSelection(int x, int y)
	{
		int xMax = getBRX();
		int xMin = getTLX();
		
		int yMax = getBRY(); 
		int yMin = getTLY();
		
		if ( (x <=xMax && x>=xMin) && (y <=yMax && y>= yMin) )
			return true;
		return false;
		
	}
	
}
