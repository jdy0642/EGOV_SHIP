package com.ship.web.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {
	public static void main(String[] args) {
		List<String> loc = Arrays.asList("서울, 경기, 충청");
	   	Collections.shuffle(loc);
	   	loc = cralw();
		System.out.printf("%s\n",loc.get(22));
	}


	public static List<String> cralw() {
		List<String> result = new ArrayList<>();
		String url = "https://talk.op.gg/s/lol/free?page=2",input = "",ptnS="";
		try {
			Document rawData;
			rawData = Jsoup.connect(url).timeout(10*1000)
					.ignoreContentType(true)
					.get();
		input = rawData.text(); 
		int cut = 0;
		System.out.println(input);
		ptnS = "ago(.*?)\\[";
		cut = 10; 
		result = matching(input,ptnS,cut);
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.add(input);
		return result;
	}
	
	public static List<String> matching(String input, String ptnS, int cut){
		List<String> x = new ArrayList<>();
		Pattern ptn = Pattern.compile(ptnS);
		Matcher matcher = ptn.matcher(input);
		while(matcher.find()){
			x.add(matcher.group().replace("ago ","").replace("[","")); 
		}
		return x;
	}

}
