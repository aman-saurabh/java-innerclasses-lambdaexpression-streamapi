package com.tp.sec1.inner_classes;

/*
 * Anonymous inner class as an arguments.
 * It is also similar to the previous two the only difference is it is directly defined as argument.
 * It is most rarely used Anonymous inner class as it might deteriorate the readability of the code.   
 */
public class Part13_Type3_Subtype3 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("Called from child thread created using Anonymous inner class as an arguments");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t1.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Called from main thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
