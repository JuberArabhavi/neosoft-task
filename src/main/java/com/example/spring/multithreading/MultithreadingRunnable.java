package com.example.spring.multithreading;


/**
 * 
 * @author Juber Arabhavi
 *	1. Thread()
 *	2. Thread(String name)
 *	3. Thread(Runnable r)
 *	4. Thread(Runnable r,String name)
 */
public class MultithreadingRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable thread is running");
	}

	public static void main(String[] args) {
		MultithreadingRunnable threadRunnable = new MultithreadingRunnable();
		Thread thread = new Thread(threadRunnable);
		
		thread.start();
	}	
}
