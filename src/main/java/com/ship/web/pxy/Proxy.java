package com.ship.web.pxy;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;

@Component
public class Proxy {
	public int integer(String param) {
<<<<<<< HEAD
		IFunction<String,Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public boolean equals(String p1, String p2) {
		BiFunction<String,String,Boolean> f = String :: equals;
		return f.apply(p1,p2);
	}

	public int random(int i, int o) {
	      BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
	      return p.apply(i, o);
	   }
	public int[] array(int size) {
		Function<Integer, int[]> f = int[] :: new;
		return f.apply(size);
	}
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
}
