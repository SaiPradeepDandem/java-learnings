package com.sai.java.jdk7.experiments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Ref : http://docs.oracle.com/javase/7/docs/technotes/guides/language/type-inference-generic-instance-creation.html
 * @author Sai.Dandem
 *
 */
public class TypeInferenceOrDiamond {

	public static void main(String[] args) {
		Map<String, List<String>> myMap1 = new HashMap();  // Shows warning
		Map<String, List<String>> myMap2 = new HashMap<String, List<String>>();
		Map<String, List<String>> myMap3 = new HashMap<>();
		
		// A more complicated initiation.
		Main<Third<First,Second>, Fourth<Second,First>> obj1 = new Main<Third<First, Second>, Fourth<Second, First>>();
		Main<Third<First,Second>, Fourth<Second,First>> obj2 = new Main<>();
		obj2.showMe();
		
		Second s = new Second();
		Main<Third<First,Second>, Fourth<Second,First>> obj3 = new Main<>(s);
	}

}
class First{
	
}
class Second{
	public void treatMe(){
		System.out.println(" I am treated");
	}
}
class Third<A,B>{
	
}
class Fourth<B,A>{
	
}
class Main<S,T>{
	Main(){}
	<X> Main(X t){
		System.out.println(t);
	}
	public void showMe(){
		System.out.println("I am in main show me.");
	}
}
