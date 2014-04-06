package com.kgght.studybug.objects;

import android.app.Application;

public class PreTest extends Application{
	public static Test myTest = new Test();
	public static boolean flipq = false;
	public static int qNum = 0;

	public Test getTest(){
		return myTest;
	}

}
