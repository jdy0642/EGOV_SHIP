package com.ship.web.pxy;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;

@Component
public class Proxy {
	public int integer(String param) {
		IFunction<String,Integer> f = Integer :: parseInt;
		return f.apply(param);
	}
	public String string(Object param) {
		IFunction<Object,String> f = String :: valueOf;
		return f.apply(param);
	}

	public boolean equals(String p1,String p2) {
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
	public String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	public String currentTime() {
		
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
	
}
