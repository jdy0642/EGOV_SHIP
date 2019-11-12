package com.ship.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Qualifier;
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> sjw
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> ljs
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> hsc1
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> yyh
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.pxy.CrawlingProxy;
import com.ship.web.pxy.PageProxy;
import com.ship.web.pxy.UserProxy;
import com.ship.web.usr.User;
import com.ship.web.usr.UserMapper;
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
<<<<<<< HEAD
<<<<<<< HEAD
	@Autowired CrawlingProxy pxy;
<<<<<<< HEAD
<<<<<<< HEAD
=======
	@Autowired CrawlingProxy crawler;
>>>>>>> sjw
=======
	@Autowired CrawlingProxy crawler;
>>>>>>> ljs
=======
>>>>>>> yyh
	@Autowired UserProxy manager;
	
=======
	@Autowired UserProxy manager;
>>>>>>> hsc1
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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
	}
	public int trucateUsers() {
		
		return 0;
>>>>>>> ljs
=======
	}
	public void truncateUsers() {
		
>>>>>>> hsc1
=======
>>>>>>> yyh
	}
}
