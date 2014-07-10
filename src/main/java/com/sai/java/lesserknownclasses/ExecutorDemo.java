/**
 * 
 */
package com.sai.java.lesserknownclasses;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
/**
 * Demonstrates the usage of the java.util.concurrent.Executor class
 * @author Sai.Dandem
 *
 */
public class ExecutorDemo {

	// Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n",  threadName, message);
    }

    static class MessageLoop implements Runnable {
        public void run() {
            String importantInfo[] = { "I am option 1", "I am option 2",
            						   "I am option 3", "I am option 4" };
            try {
                for (int i = 0; i < importantInfo.length; i++) {
                    // Pause for 4 seconds
                    Thread.sleep(1500);
                    // Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("I wasn't done!");
            }
        }
    }
    
	public static void main(String[] args) throws InterruptedException{
		threadMessage("Starting MessageLoop thread");
       
		// UNCOMMENT THE BELOW CODE TO CHECK NORMAL THREAD IMPLEMENTAION.
	/*	Thread t1 = new Thread(new MessageLoop());
        t1.start();
        Thread t2 = new Thread(new MessageLoop());
        t2.start();
        Thread t3 = new Thread(new MessageLoop());
        t3.start();
    */
		
		// UNCOMMENT THE BELOW CODE TO CHECK EXECUTOR IMPLEMENTATION.
	/*	DirectExecutor executor = new ExecutorDemo().new DirectExecutor();
        executor.execute(new MessageLoop());
        executor.execute(new MessageLoop());
        executor.execute(new MessageLoop());
    */   
		
		// UNCOMMENT THE BELOW CODE TO CHECK SIMPLE EXECUTOR IMPLEMENTATION THAT SPANS NEW THREAD.
		ThreadPerTaskExecutor executor2 = new ExecutorDemo().new ThreadPerTaskExecutor();
        executor2.execute(new MessageLoop());
        executor2.execute(new MessageLoop());
        executor2.execute(new MessageLoop());
        
        threadMessage("Waiting for MessageLoop thread to finish");
	}

	/**
	 * Executor implementation class.
	 * In the below simplest case, an executor will run the submitted task immediately in the caller's thread.
	 * @author Sai.Dandem
	 *
	 */
	class DirectExecutor implements Executor {
	     public void execute(Runnable r) {
	         r.run();
	     }
	 }
	
	/**
	 * The executor below spawns a new thread for each task
	 * @author Sai.Dandem
	 *
	 */
	class ThreadPerTaskExecutor implements Executor {
	     public void execute(Runnable r) {
	         new Thread(r).start();
	     }
	 }
	
	/**
	 * If the Executor implementation need to impose some sort of limitation on how and when tasks are scheduled.,
	 * The executor below serializes the submission of tasks to a second executor, illustrating a composite executor. 
	 * @author Sai.Dandem
	 */
	class SerialExecutor implements Executor {
	   final Queue<Runnable> tasks = new ArrayDeque<Runnable>();
	   final Executor executor;
	   Runnable active;

	   SerialExecutor(Executor executor) {
	     this.executor = executor;
	   }

	   public synchronized void execute(final Runnable r) {
	     tasks.offer(new Runnable() {
	       public void run() {
	         try {
	           r.run();
	         } finally {
	           scheduleNext();
	         }
	       }
	     });
	     if (active == null) {
	       scheduleNext();
	     }
	   }

	   protected synchronized void scheduleNext() {
	     if ((active = tasks.poll()) != null) {
	       executor.execute(active);
	     }
	   }
	 }
}
