package com.tp.sec3.lamda_expressions;

public class Part03_LambdaForRunnableInterface {
	public static void main(String[] args) {
		Runnable r = () -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Child thread call count : " + (i + 1));
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("Child thread execution end");
		};

		Thread t = new Thread(r);
		t.start();

		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread call count : " + (i + 1));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Main thread execution end");
	}
}
