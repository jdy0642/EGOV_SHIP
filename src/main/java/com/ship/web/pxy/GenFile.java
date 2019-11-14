package com.ship.web.pxy;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component("gfile")
public class GenFile<T> {
	
	private File file;
	
	/*public A makeDir(T t, T u) {
		BiFunction<T, T, A> f = (z,w) -> new A(z,w);
		return f.apply(t, u);
	}
	
	public A makeFile(A t, T u) {
		BiFunction<A, T, A> f =  A :: new ;
		return f.apply(t, u);
	}*/
	
	public File makeFile(T t1, String t2) {
		HashMap<String, T> o = new HashMap<>();
		o.put("T", t1);
		
		if(o.get("T") instanceof String) {
			file = new File((String)o.get("T"),t2);
		}else if (o.get("T") instanceof File) {
			System.out.println(">>" + (File)o.get("T"));
			file = new File((File)o.get("T"),t2);
		}
		return file;
	}
	
	/*File uploadPath = new GenFile<String>().makeFile(uploadFolder, getFolder());
		System.out.println("파일경로 1: "+ uploadPath.getPath());
	File savedFile = new GenFile<String>().makeFile(uploadFolder, "");
		System.out.println("파일경로 1: "+ savedFile.getPath());*/
}
