package com.sai.java.lesserknownclasses;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

	public static void main(String[] args) {
		ExecutorDemo.threadMessage("Starting MessageLoop thread");
		
		/*Thread t1 = new Thread(new ExecutorDemo.MessageLoop());
        t1.start();
        Thread t2 = new Thread(new ExecutorDemo.MessageLoop());
        t2.start();
        Thread t3 = new Thread(new ExecutorDemo.MessageLoop());
        t3.start();*/

		ExecutorService  executor = Executors.newSingleThreadExecutor();
        executor.execute(new ExecutorDemo.MessageLoop());
        executor.execute(new ExecutorDemo.MessageLoop());
        executor.execute(new ExecutorDemo.MessageLoop());
	        
	        
        Executor executor1 = Executors.newFixedThreadPool(2);
        executor1.execute(new ExecutorDemo.MessageLoop());
        executor1.execute(new ExecutorDemo.MessageLoop());
        executor1.execute(new ExecutorDemo.MessageLoop());
        
        ExecutorDemo.threadMessage("Waiting for MessageLoop thread to finish");
	}

}
