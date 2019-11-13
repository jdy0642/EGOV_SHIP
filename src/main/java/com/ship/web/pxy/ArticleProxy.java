package com.ship.web.pxy;

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
	private String makePageno() {
		return null;
	}
	@Transactional
	public void insertArticle() {
		for(int i=0; i< 500; i++) {
			articleMapper.insertArticle(makeArticle());
		}
	}
	public Article makeArticle() {
	      return new Article(null,makeTitle(),makeContent(), makeUserid(), makeComments(), makePageno(), makeFile());
	   }

}
