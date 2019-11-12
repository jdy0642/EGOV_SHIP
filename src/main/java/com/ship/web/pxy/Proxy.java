package com.ship.web.pxy;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;

@Component
public class Proxy {
	public int integer(String param) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> ljs
=======
//		IFunction<String,Integer> f = s -> Integer.parseInt(s);
>>>>>>> hsc1
		IFunction<String,Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public boolean equals(String p1, String p2) {
		BiFunction<String,String,Boolean> f = String :: equals;
		return f.apply(p1,p2);
	}

<<<<<<< HEAD
	public int random(int i, int o) {
<<<<<<< HEAD
=======
	public boolean equals(String p1,String p2) {
		BiFunction<String,String,Boolean> f = String :: equals;
		return f.apply(p1,p2);
	}

	public int random(int i, int o) {
>>>>>>> hsc1
=======
		IFunction<String,Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
		public boolean equals(String p1, String p2) {
			BiFunction<String, String, Boolean> f = String :: equals;
			return f.apply(p1, p2);
		}
	   public int random(int i, int o) {
>>>>>>> yyh
	      BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
	    return p.apply(i, o);
	   }
<<<<<<< HEAD
=======
	    BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
	      return p.apply(i, o);
	   }
<<<<<<< HEAD
	public boolean equals(String p1, String p2) {
		  BiFunction<String, String, Boolean> f = String :: equals;
		   return f.apply(p1, p2);
	   }
>>>>>>> ljs
	public int[] array(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
<<<<<<< HEAD
=======
		//IFunction<String,Integer> f = s -> Integer.parseInt(s);
		Function<String, Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	
	public boolean equals (String p1, String p2) {
		BiFunction<String, String, Boolean> f = String :: equals;
		return f.apply(p1, p2);
	}

   public int random(int i, int o) {
      BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
      return p.apply(i, o);
   }
   public int[] intArray(int size) {
	   Function<Integer, int[]> f = int[] :: new;
	   return f.apply(size);
   }
>>>>>>> sjw
=======
	
>>>>>>> ljs
=======
	public int[] Array(int size) {
		Function<Integer,int[]> f = int[] :: new ;
		return f.apply(size);
	}
>>>>>>> hsc1
=======
	   public int[] intArray(int size) {
		   Function<Integer, int[]> f = int[] :: new;
		   return f.apply(size);
	   }
>>>>>>> yyh
}
