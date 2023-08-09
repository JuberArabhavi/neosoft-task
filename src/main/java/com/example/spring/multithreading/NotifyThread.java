package com.example.spring.multithreading;

public class NotifyThread extends Thread{

	@Override
	public void run() {
		synchronized (this) {
			System.out.println("Thread start "+Thread.currentThread().getName());
			try {
				this.wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(Thread.currentThread().getName() + " notify");
			}
			
		}
	}
	
}
