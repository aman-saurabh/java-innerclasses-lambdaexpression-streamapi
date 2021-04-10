package com.tp.sec1.inner_classes;

/*
 * Anonymous inner class that implements an interface
 * It is quiet similar to Anonymous inner class that extends a class.
 * The only difference is it implements an interface instead of extending a class.
 */
class MyRunnable implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Called by thread created by MyRunnable class - "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	};
}

public class Part12_Type3_Subtype2 {
	public static void main(String[] args) {
		MyRunnable r1 = new MyRunnable();
		Thread t1 = new Thread(r1);
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Called by thread created by Anonymous inner class that implements Runnable interface");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		System.out.println("Main method called by main thread");
	}
}
