package com.ship.web.pxy;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;
@Component
public class Trunk<T>{
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.Data;
@Component("trunk")
public class Trunk<T> {
>>>>>>> sjw
	private HashMap<String, T> map;
	public void put(List<String> x, List<T> y) {
		map = new HashMap<>();
		for (int i = 0; i < x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.print(String.format("%s : %s", k,v)));
	}
<<<<<<< HEAD
	public T get(String k) {
		IFunction<String, T> f = p -> map.get(p);
		return f.apply(k);
		}
=======
	
	public T get(String k) {
		Function<String, T> f = p -> map.get(p);
		return f.apply(k);
	}
>>>>>>> sjw
	public HashMap<String, T> get() {return map;}
	public int size() {return map.size();}
}
