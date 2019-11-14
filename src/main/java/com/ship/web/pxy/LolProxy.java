package com.ship.web.pxy;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.brd.Article;
import com.ship.web.lol.Lol;
import com.ship.web.lol.LolMapper;
import com.ship.web.usr.UserMapper;

@Component("lols")
public class LolProxy extends Proxy{
	@Autowired LolMapper lolMapper;
	@Autowired UserMapper userMapper;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
	private String makeLolname() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String name[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

		for (int i = 0; i < 15; i++) {
			buffer.append(name[ran.nextInt(name.length)]);
		}
		return buffer.toString();
	}
	
	private String makeUid() {
		return null;
	}
	private String makeRoomnum() {
		return null;
	}
	private String makeRoommake() {
		return null;
	}
	private String makeInvite() {
		return null;
	}
	private String makeLolstart() {
		return null;
	}
	private String makeLolblack() {
		return null;
	}
	private String makeReportnum() {
		return null;
	}
	
	
	@Transactional
	public void insertLol() {
		for(int i = 0 ; i < 100 ; i++) {
			lolMapper.insertLol(new Lol(makeLolname(),makeUid(), 
					makeRoomnum(), makeRoommake(), makeInvite(),makeLolstart(),
					makeLolblack(),makeReportnum()));
		}
	}
}
