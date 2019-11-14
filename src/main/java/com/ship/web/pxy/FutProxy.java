package com.ship.web.pxy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.futsal.Fut;
import com.ship.web.futsal.FutMapper;
import com.ship.web.usr.UserMapper;

@Component("futsal")
public class FutProxy extends Proxy{
	@Autowired UserMapper userMapper;
	@Autowired FutMapper futMapper;
	
	@Transactional
	public void insertFutsal() {
		for(String y : getUserIdList()) futMapper.createFutDummy(makeFut(y));
}
	
	public Fut makeFut(String x) {
		return new Fut(eng(6),
				random(1,111)+"",
				random(1,11)+"",
				random(1,11)+"",
				random(1,1111)+"",
				random(1,11)+"",
				random(1,11)+"",
				random(1,2)+"",
				x);
	}
	@Transactional
	public List<String> getUserIdList() {
		return userMapper.getUserIdList();
	}
}
