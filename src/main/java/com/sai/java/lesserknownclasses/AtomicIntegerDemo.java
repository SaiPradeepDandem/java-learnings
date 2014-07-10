package com.sai.java.lesserknownclasses;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger();
		System.out.println("a : "+a.get());
		
		System.out.println("a.addAndGet(5) :"+a.addAndGet(5));
		System.out.println("a.addAndGet(7) :"+a.addAndGet(7));
		System.out.println("a.byteValue() : "+a.byteValue());
		System.out.println("a.compareAndSet(12, 15) : "+a.compareAndSet(12, 15)+" , Result val : "+a.get());
		System.out.println("a.compareAndSet(12, 18) : "+a.compareAndSet(12, 18)+" , Result val : "+a.get());
		System.out.println("a.compareAndSet(15, 18) : "+a.compareAndSet(15, 18)+" , Result val : "+a.get());
		System.out.println("a.decrementAndGet() : "+a.decrementAndGet());
		System.out.println("a.doubleValue() : "+a.doubleValue());
		System.out.println("a.floatValue() : "+a.floatValue());
		System.out.println("a.get() : "+a.get());
		System.out.println("a.getAndAdd(7) : "+a.getAndAdd(7)+" , Result val : "+a.get());
		System.out.println("a.getAndDecrement() : "+a.getAndDecrement()+" , Result val : "+a.get());
		System.out.println("a.getAndSet(8) : "+a.getAndSet(8)+" , Result val : "+a.get());
		System.out.println("a.incrementAndGet() : "+a.incrementAndGet()+" , Result val : "+a.get());
		System.out.println("a.intValue() : "+a.intValue());
		
		a.lazySet(3);
		System.out.println("a.lazySet(3) :  , Result val : "+a.get());
		System.out.println("a.longValue() : "+a.longValue());
		
		
		a.set(5);
		System.out.println("a.set(5) :  , Result val : "+a.get());
		System.out.println("a.shortValue() : "+a.shortValue());
		System.out.println("a.weakCompareAndSet(12, 15) : "+a.weakCompareAndSet(12, 15)+" , Result val : "+a.get());
		
	}
}
