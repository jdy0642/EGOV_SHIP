package com.ship.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.brd.ArticleMapper;
import com.ship.web.pxy.ArticleProxy;
import com.ship.web.pxy.CrawlingProxy;
import com.ship.web.pxy.UserProxy;
import com.ship.web.usr.UserMapper;
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired CrawlingProxy crawler;
	@Autowired UserProxy manager;
	@Autowired ArticleProxy art;
	
	
	@SuppressWarnings("unchecked")
	public List<String> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		txServiceList.clear();
		txServiceList = (List<String>) crawler.crawl(paramMap);
		return txServiceList;
	}
	@Transactional
	public int registerUsers(){
		manager.insertUsers();
		return userMapper.countUsers();
	}
	public int registerArticles() {
		art.insertArticle();
		return Integer.parseInt(articleMapper.countArticle());
	}
	public void truncateUsers() {
		
	}
}
