package com.ship.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

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
	@Autowired CrawlingProxy crawl;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
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
	private Box<String> makeContent() {
		trunk.put(Arrays.asList("site","srch"), Arrays.asList("직접입력","인기글"));
		return crawl.choose(trunk.get());
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
		Box<String> box = makeContent();
		for(int i=0; i< 200; i++) {
			Collections.shuffle(box.get());
			articleMapper.insertArticle(new Article(null,makeTitle(),box.get(0), makeUserid(), makeComments(), makeFile()));
		}
	}

}
