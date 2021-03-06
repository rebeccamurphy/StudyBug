package com.kgght.studybug.objects;

import java.util.ArrayList;

public class Test {

	private ArrayList<Picture> picturesList;
	private ArrayList<FlipCard> flipCardList;
	
	public Test() {
		picturesList = new ArrayList<Picture>();
		flipCardList = new ArrayList<FlipCard>();
	}
	public Test(Test oldTest){
		flipCardList = oldTest.getFlipList();
		picturesList = oldTest.getPicList();
	}
	
	public void add(Picture pic){
		picturesList.add(pic);
	}
	
	public void add(FlipCard card){
		flipCardList.add(card);
	}
	
	public ArrayList<Picture> getPicList(){
		return picturesList;
	}
	
	public ArrayList<FlipCard> getFlipList(){
		return flipCardList;
	}


}
