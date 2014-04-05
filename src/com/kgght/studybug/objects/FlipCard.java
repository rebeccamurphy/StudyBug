package com.kgght.studybug.objects;

public class FlipCard {

	private String question;
	private String answer;
	
	public FlipCard(String Q, String A) {
		question = Q;
		answer =   A;
	}
	
	public void setQ (String Q){
		question = Q;
	}
	
	public void setA (String A){
		answer = A;
	}
	
	public String getQ() {
		return question;
	}
	
	public String getA(){
		return answer;
	}
	
}
