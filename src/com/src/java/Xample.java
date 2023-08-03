package com.src.java;

public class Xample {

	static int x = 1111;
	
	static {
		x = x-- - --x;
		System.out.println("Static block "+x);
	}
	
	{
		x = x++ + ++x;
		System.out.println("Instance block "+x);
	}
	
}

