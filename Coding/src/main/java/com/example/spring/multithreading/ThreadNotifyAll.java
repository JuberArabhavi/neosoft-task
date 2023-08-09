package com.example.spring.multithreading;

public class ThreadNotifyAll {
	
	public static void main(String[] args) {
		NotifyThread notifyThread = new NotifyThread();
		NotifyThreads notifyThreads = new NotifyThreads(notifyThread);
		
		Thread thread1 = new Thread(notifyThread, "Thread 1");
		Thread thread2 = new Thread(notifyThreads, "Thread 2");
		
		thread1.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.start();
	}
}
