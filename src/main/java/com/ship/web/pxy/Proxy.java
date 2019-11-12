package com.ship.web.pxy;
import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;

@Component
public class Proxy {
	public int integer(String param) {
		IFunction<String,Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}

	   public int random(int i, int o) {
	      BiFunction<Integer,Integer,Integer> p = (a,b) ->(int)(Math.random()*(b-a))+a; 
	      return p.apply(i, o);
	   }
}
