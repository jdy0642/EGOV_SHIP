package com.ship.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ship.web.enums.Path;
import com.ship.web.utl.Printer;
@Component("crawler")
public class CrawlingProxy extends Proxy {
	@Autowired Printer p;
	@Autowired Box<String> box;
	
	  public Box<String> choose(Map<?,?> paramMap){
		  String url = "";
		  switch (string(paramMap.get("srch"))) {
		case "인기글":
			for(int i =1; i<5; i++) {
				box = crawling(Path.CRAWLING_OPGG.toString()+i);
			}
			break;
		default:
				box = crawling("http://"+paramMap.get("site")+"/");
			break;
		}
	      return box;
	   }
	private Box<String> crawling(String url) {
		
		box.clear();
	      try {
	    	  Document rawData = Jsoup.connect(url).timeout(10*1000).get();
	    	  	Elements artist = rawData.select("article[class=\"article-list-item \"]");
	    	  	for(Element e : artist) {
	    	  		box.add(e.text()+"\n ***************\n");
	    	  	}
	    	  	p.accept(""+box);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return box;
	}
}