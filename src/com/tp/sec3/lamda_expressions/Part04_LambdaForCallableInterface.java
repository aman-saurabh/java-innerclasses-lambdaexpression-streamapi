package com.tp.sec3.lamda_expressions;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
/*
 * The difference between Runnable interface and callable interface is that Runnable interface run() method doesn't return a value while Callable class call method return a value.
 * Apart from that call() method can throw exception whereas run() method cannot.
 * But the main difference between them is Runnable interface can be used to create thread but Callable interface not.
 * So to use Callable interface we will need 'ExecutorService' to create thread pool where we can submit Callable object and 'Future' to get and hold the call() method response which main thread can use.
 * These can be used with Runnable also.        
 */
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class Part04_LambdaForCallableInterface {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Using this we can create a thread pool of one thread only.  
		// ExecutorService executor = Executors.newSingleThreadExecutor();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		Runnable r = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date());
		};
		//Used execute() for Runnable interface here as return type of execute() method is void.
		//We can also use submit() method here but submit() methods return a "Future" type value and since run() method don't return anything so submit() will return null upon completion of run() method.   
		executor.execute(r);
		
		Callable<Integer> c = () -> {
			int min = 100000;
			int max = 999999;
			//In Java 1.7 or later, the standard way to generate a random number.
			//nextInt() is normally exclude the top value, so add 1 to make it inclusive.
			int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
			//Note that with Callable, you don’t need to surround Thread.sleep() by a try/catch block but you have to do with Runnable interface, because unlike Runnable, a Callable can throw a checked exception.
			Thread.sleep(3000);
			return randomNum;
		};
		
		//Used submit() method here as call() method returns a value and submit() methods returns that value in a 'Future' type variable, from which main thread can get the original returned value. 
		//Hence execute() method can't be applied here with Callable interface as execute() don't return anything while Callable interface call() method returns.
		//i.e For Runnable interface 'execute()' and 'submit()' both methods are applicable while for Callable interface only 'submit()' method is applicable.
		Future<Integer> future = executor.submit(c);
		
		while(!future.isDone()) {
			System.out.println("Call method is still processing.");
			Thread.sleep(1000);
		}
		
		//To get call() method response whenever it will return any value.
		//Future class get() method throws ExecutionException as well as InterruptedException which are checked exceptions.
		Integer result = future.get(); 
		System.out.println(result);
		executor.shutdown();
	}
}
