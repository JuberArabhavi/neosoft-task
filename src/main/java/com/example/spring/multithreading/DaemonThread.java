package com.example.spring.multithreading;


/*
 * If you want to make a thread, a daemon thread then set a daemon thread as true and start a thread. 
 * If this is vice versa then it will give exception.
 */
public class DaemonThread extends Thread{

	@Override
	public void run() {
		
		System.out.println("Thread : "+Thread.currentThread().getName());  
		System.out.println("Daemon : "+Thread.currentThread().isDaemon());  
		
		if (Thread.currentThread().isDaemon()) {
			System.out.println("It is a daemon thread");
		} else 
			System.out.println("The thread works");
	}
	
	public static void main(String[] args) {
		DaemonThread d1 = new DaemonThread();
		DaemonThread d2 = new DaemonThread();
		
		d1.setDaemon(true);
		d2.setDaemon(false);
		
		d1.start();
		d2.start();
	}
}
