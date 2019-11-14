package com.ship.web.pxy;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiFunction;

public class GenFile<T> {
	/*public File makeDir(String t, String u) {
		BiFunction<String, String, File> f = File :: new;
		return f.apply(t, u);
	}
	public File makeFile(File t, String u) {
		BiFunction<File ,String, File> f = File :: new;
		return f.apply(t, u);
	}*/
	private File file;
	
	public File makeFile(T t1, String t2) {
		HashMap<String, T> o = new HashMap<>();
		o.put("T", t1);
		if (o.get("T") instanceof String) {
			file = new File ((String) o.get("T"),t2);
			
		}else if (o.get("T") instanceof File) {
			System.out.println((File)o.get("T"));
			file =  new File((File)o.get("T"),t2);
		}
		return file;
	}
	//사용법
	/*File uploadPath = new GenFile<String>().makeFile(uploadFolder, getFolder());
		System.out.println("파일경로"+uploadPath.getPath());
	File savedFile = new GenFile<String>().makeFile(uploadPath, "");
		System.out.println("파일경로"+savedFile.getPath());*/
}
