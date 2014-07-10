package com.sai.java.lesserknownclasses;

import java.util.WeakHashMap;


public class WeakHashMapDemo {
	public static void main(String[] args) {
		int size = 1000;
		Key[] keys = new Key[size];
		WeakHashMap whm = new WeakHashMap();
		for(int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if(i % 3 == 0)
			keys[i] = k; // Save as "real" references
			whm.put(k, v);
		}
		
		/*HashMap hm = new HashMap();
		for(int i = 0; i < size; i++) {
			Key k = new Key(Integer.toString(i));
			Value v = new Value(Integer.toString(i));
			if(i % 3 == 0)
			keys[i] = k; // Save as "real" references
			hm.put(k, v);
		}*/
		System.gc();
		System.out.println("DONE !!!");
	}
}

class Key {
	String ident;
	static final int SZ = 10000;
	double[] d = new double[SZ];
	public Key(String id) { ident = id; }
	public String toString() { return ident; }
	public int hashCode() {
		return ident.hashCode();
	}
	public boolean equals(Object r) {
		return (r instanceof Key) && ident.equals(((Key)r).ident);
	}
	public void finalize() {
		System.out.println("Finalizing Key "+ ident);
	}
}

class Value {
	String ident;
	static final int SZ = 10000;
	double[] d = new double[SZ];
	public Value(String id) { ident = id; }
	public String toString() { return ident; }
	public void finalize() {
		System.out.println("Finalizing Value "+ident);
	}
}
