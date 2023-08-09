package com.example.spring.multithreading;

public class NotifyThreads extends Thread{

	NotifyThread notifythread;
	NotifyThreads(NotifyThread notifyThread) {
		this.notifythread = notifyThread;
	}
	
	@Override
	public void run() {
		synchronized (this.notifythread) {
			System.out.println("Thread start "+Thread.currentThread().getName());
			
			this.notifythread.notifyAll();
			System.out.println(Thread.currentThread().getName()+" notify");
		}
	}
}
