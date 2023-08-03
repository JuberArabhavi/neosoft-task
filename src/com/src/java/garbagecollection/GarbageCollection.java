
package com.src.java.garbagecollection;

/*
 * Created By @author : Juber
 * */
public class GarbageCollection {

	/**
	 * 
	 * 1. By Nullifying the reference variable
	 * 
	 * */
	static GarbageCollection gc = new GarbageCollection();
	static GarbageCollection gc1 = new GarbageCollection();
	
	
	/*
	 * 
	 * 2. By re-assigning the reference variable
	 * 
	 * */
	static GarbageCollection gc2 = new GarbageCollection();
	static GarbageCollection gc3 = new GarbageCollection();
	
	
	/*
	 * 3. By creating objects inside a method.
	 * 
	 * */
	static void makeGCEligible() {
		GarbageCollection gc4 = new GarbageCollection();
		GarbageCollection gc5 = new GarbageCollection();
	}
	
	public static void main(String[] args) {
		
		/**
		 * 
		 * 1. By Nullifying the reference variable
		 * 
		 * */
		gc = null;
		gc1 = null;
		
		/*
		 * 2. By re-assigning the reference variable
		 * */
		gc3 = gc2;
		
		
		/*
		 * 3. By creating objects inside a method
		 * */
		makeGCEligible();
	}
}
