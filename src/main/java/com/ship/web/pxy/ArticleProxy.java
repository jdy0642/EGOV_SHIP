package com.ship.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.brd.Article;
import com.ship.web.brd.ArticleMapper;
import com.ship.web.usr.UserMapper;

@Component("art")
public class ArticleProxy extends Proxy{
	@Autowired ArticleMapper articleMapper;
	@Autowired UserMapper userMapper;
	
	private String makeArtseq() {
		return null;
	}
	private String makeTitle() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String title[] = 
				"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9".split(",");
		
		for (int i = 0 ; i < 3; i++) {
			buffer.append(title[ran.nextInt(title.length)]);
		}
		return buffer.toString();
	}
	private String makeContent() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String content[] = 
				"a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9".split(",");
		
		for (int i = 0 ; i < 5; i++) {
			buffer.append(content[ran.nextInt(content.length)]);
		}
		return buffer.toString();
	}
	
	private String makeFile() {
		return null;
	}
	private String makeUserid() {
		return null;
	}
	private String makeComments() {
		return null;
	}

	@Transactional
	public void insertArticle() {
		for(String x : cralw() ) {
			Article y = makeArticle();
			y.setContent(x);
			System.out.println(x);
			articleMapper.insertArticle(y);
		}
	}
	public Article makeArticle() {
	      return new Article(null,makeTitle(),makeContent(), makeUserid(), makeComments(), makeFile());
	   }
	
	
	public List<String> cralw() {
		List<String> result = new ArrayList<>();
		int x = random(1,1);
		String url = "https://talk.op.gg/s/lol/free?page="+x,input = "",ptnS="";
		try {
			Document rawData = Jsoup.connect(url).timeout(10*1000)
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
		//result.add(input);
		return result;
	}
	
	public List<String> matching(String input, String ptnS, int cut){
		List<String> x = new ArrayList<>();
		Pattern ptn = Pattern.compile(ptnS);
		Matcher matcher = ptn.matcher(input);
		while(matcher.find()){
			x.add(matcher.group().replace("ago ","").replace("[","")); 
		}
		return x;
	}

}
