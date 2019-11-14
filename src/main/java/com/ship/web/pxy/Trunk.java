package com.ship.web.pxy;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ship.web.cmm.IFunction;
@Component
public class Trunk<T>{
	private HashMap<String, T> map;
	public Trunk() {map = new HashMap<>();}
	
	public void put(List<String> x, List<T> y) {
		for (int i = 0; i < x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.print(String.format("%s : %s\n", k,v)));
	}
	public T get(String k) {
		IFunction<String, T> f = p -> map.get(p);
		return f.apply(k);
		}
	public HashMap<String, T> get() {return map;}
	public int size() {return map.size();}
	public void clear() {map.clear();}
}
