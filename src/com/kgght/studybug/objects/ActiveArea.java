package com.kgght.studybug.objects;

public class ActiveArea {

	private int[]  topleft; 
	private int[]  botright;
	
	public ActiveArea() {
		
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
