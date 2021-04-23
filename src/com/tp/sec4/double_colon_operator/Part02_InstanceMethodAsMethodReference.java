package com.tp.sec4.double_colon_operator;

/* 
 * Demo program for how to use an existing instance method as method reference in double colon operator. 
 */

public class Part02_InstanceMethodAsMethodReference {
	
	public void iterarteMessage() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			System.out.format("%s thread - count : %d\n", Thread.currentThread().getName(), i+1);
		}
	}
	
	public static void main(String[] args) {
		Part02_InstanceMethodAsMethodReference p = new Part02_InstanceMethodAsMethodReference();
		p.iterarteMessage();
		
		Runnable r1 = () -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
				System.out.format("%s thread - count : %d\n", Thread.currentThread().getName(), i+1);
			}
		};
		Thread t1 = new Thread(r1,"first");
		t1.start();
		
		//But since we already have iterarteMessage() method to be used by main thread.
		//So wouldn't it be better if we reuse same method to implement Runnable interface SAM(i.e run method).
		//We can do it as follows using double colon operator
		Runnable r2 = p::iterarteMessage;
		Thread t2 = new Thread(r2,"second");
		t2.start();
	}
}
