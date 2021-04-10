package com.tp.sec1.inner_classes;

/*
 * Anonymous inner class that extends a class.
 * In the previous part, the example was of this type of Anonymous inner class only.
 * Now in this example let's see how we can use the concept of 'Anonymous inner class that extends a class' to define a Thread. 
 */

class MyThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Called by thread created by MyThread class - "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	};
}

public class Part11_Type3_Subtype1 {
	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		Thread t2 = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Called by thread created by Anonymous inner class that extends Thread class");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};
		};
		t1.start();
		t2.start();
		System.out.println("Main method called by main thread");
	}
}
