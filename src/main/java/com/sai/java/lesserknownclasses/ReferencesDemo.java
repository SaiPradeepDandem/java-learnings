package com.sai.java.lesserknownclasses;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferencesDemo {
	static ReferenceQueue rqueue= new ReferenceQueue();
	
	public static void checkQueue() {
		Object obj = rqueue.poll();
		if(obj != null)
		System.out.println("In queue: " + (VeryBig)((Reference)obj).get());
	}
	
	public static void main(String[] args) {
		int size = 10;
		
		// Normal Reference
		VeryBig[] normal = new VeryBig[size];
		for(int i = 0; i < normal.length; i++) {
			normal[i] = new VeryBig("Normal " + i);
			System.out.println("Just created: " +normal[i]);
		}
		
		// Soft Reference
		SoftReference[] sa = new SoftReference[size];
		for(int i = 0; i < sa.length; i++) {
			sa[i] = new SoftReference( new VeryBig("Soft " + i), rqueue);
			System.out.println("Just created: " +(VeryBig)sa[i].get());
			checkQueue();
		}
		
		// Weak Reference
		WeakReference[] wa = new WeakReference[size];
		for(int i = 0; i < wa.length; i++) {
			wa[i] = new WeakReference( new VeryBig("Weak " + i), rqueue);
			System.out.println("Just created: " +(VeryBig)wa[i].get());
			checkQueue();
		}
		
		SoftReference s = new SoftReference(new VeryBig("Soft"));
		WeakReference w = new WeakReference(new VeryBig("Weak"));
		
		System.gc();
		
		PhantomReference[] pa =	new PhantomReference[size];
		for(int i = 0; i < pa.length; i++) {
			pa[i] = new PhantomReference(new VeryBig("Phantom " + i), rqueue);
			System.out.println("Just created: " +(VeryBig)pa[i].get());
			checkQueue();
		}
		System.out.println("*************************************************************************************");
		//System.gc();
		
	}
}

class VeryBig {
	static final int SZ = 10000;
	double[] d = new double[SZ];
	String ident;
	public VeryBig(String id) { 
		ident = id; 
	}
	public String toString() { 
		return ident; 
	}
	public void finalize() {
		System.out.println("Finalizing " + ident);
	}
}