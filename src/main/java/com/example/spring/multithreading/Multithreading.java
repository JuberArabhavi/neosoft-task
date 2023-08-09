package com.example.spring.multithreading;

public class Multithreading extends Thread{

	@Override
	public void run() {
		System.out.println("Mutithreading thread is running");
	}
	
	public static void main(String[] args) {
		Multithreading thread = new Multithreading();
		thread.start();
	}
}
