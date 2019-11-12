package com.ship.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
@Component("crawler")
public class CrawlingProxy extends Proxy {
	  public List<?> crawl(Map<?,?> paramMap){
	      List<String> proxyList = new ArrayList<>();
	      String url = "http://www."+paramMap.get("site")+"/";
	      proxyList.clear();
	      try {
	         Connection.Response response = Jsoup.connect(url)
	                           .method(Connection.Method.GET)
	                           .execute();
	         Document document = response.parse();
	         String text = document.text();
	         proxyList.add(text);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return proxyList;
	   }
}
