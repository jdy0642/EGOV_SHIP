package com.ship.web.aop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.pxy.CrawlingProxy;
import com.ship.web.pxy.PageProxy;
import com.ship.web.usr.User;
import com.ship.web.usr.UserMapper;
@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
	@Autowired CrawlingProxy pxy;
	
	@SuppressWarnings("unchecked")
	public List<String> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		txServiceList.clear();
		txServiceList = (List<String>) pxy.crawl(paramMap);
		return txServiceList;
	}
	@Transactional
	public int registerUsers(){
		List<User> list = new ArrayList<>();
		for(User u : list) {
			txMapper.insertUser(u);
		}
		return 4;
	}
}
