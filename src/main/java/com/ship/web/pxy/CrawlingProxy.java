package com.ship.web.pxy;

import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
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
	@Autowired Printer pt;
	@Autowired Box<String> box;
	  public Box<String> choose(Map<?, ?> map){
	      pt.accept("키값 : "+ map.get("site"));
	      pt.accept("값 : "+ map.get("srch"));
	      String url = "";
	      switch(String.format("%s",(map.get("site")))) {
	      case " ":
	      	crawl(Path.CRAWLING_TARGET.toString());
	      	break;
	      default :
	    	  url = "http://"+ map.get("site") + "/";
	    	  crawl(url);
	    	  break;
	      }
	      return box;
	   }
	  
	private Box crawl(String url) {
		pt.accept("넘어온 URL \n"+url);
      	box.clear();
		try {
			Connection.Response response = Jsoup.connect(url)
					.method(Connection.Method.GET)
					.execute();
			Document document = Jsoup.connect(url).timeout(10*1000).get();
			//System.out.println(document);
			Elements e = document.select("<div>");
			String text = document.text();
			pt.accept("넘어온 url : "+url);
			box.add(text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return box;
	}
}
