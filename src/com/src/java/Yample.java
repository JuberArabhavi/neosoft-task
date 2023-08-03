package com.src.java;

public class Yample extends Xample {
	
	static {
		x = --x - x--;
		System.out.println("In static Y "+x);
	}
	
	{
		x = ++x + x++;
		System.out.println("In instance Y "+x);
	}
}
