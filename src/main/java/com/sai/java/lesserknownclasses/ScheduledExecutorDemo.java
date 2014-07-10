package com.sai.java.lesserknownclasses;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {

	private static final ScheduledExecutorService worker = 
									Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {
		
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("I am called..");
			}
		};
		
		/* Starts the task with delay of 2 seconds and repeats after every 5 seconds. */
		worker.scheduleWithFixedDelay(task, 2, 5, TimeUnit.SECONDS);
		
	}
}
