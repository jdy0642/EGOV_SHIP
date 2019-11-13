package com.ship.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ship.web.pxy.PageProxy;

@Repository
public interface ArticleMapper {
	public String countArticle();
	public void insertArticle(Article param);
	public List<Article> selectList(PageProxy pxy);
	public void updateArticle(Article param);
	public void deleteArticle(Article param);
	
	public int countArticles();
}
