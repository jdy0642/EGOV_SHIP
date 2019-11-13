package com.ship.web.tx;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.adm.AdminMapper;
import com.ship.web.brd.ArticleMapper;
import com.ship.web.pxy.AdminProxy;
import com.ship.web.pxy.ArticleProxy;
import com.ship.web.pxy.Box;
import com.ship.web.pxy.CrawlingProxy;
import com.ship.web.pxy.UserProxy;
import com.ship.web.usr.UserMapper;
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired AdminMapper adminMapper;
	@Autowired CrawlingProxy crawler;
	@Autowired UserProxy manager;
	@Autowired ArticleProxy art;
	@Autowired AdminProxy adms;
	@Autowired Box<String> box;
	
	public Box<String> crawling(Map<?,?> paramMap){
		return crawler.choose(paramMap);
	}
	@Transactional
	public int registerUsers(){
		manager.insertUsers();
		return userMapper.countUsers();
	}
	@Transactional
	public int registerArticles() {
		art.insertArticle();
		return Integer.parseInt(articleMapper.countArticle());
	}
	@Transactional
	public int registerAdmins() {
		adms.insertAdmins();
		return Integer.parseInt(adminMapper.countAdmin());
	}
}
