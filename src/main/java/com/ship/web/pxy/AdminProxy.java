package com.ship.web.pxy;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.adm.Admin;
import com.ship.web.adm.AdminMapper;

@Component("adms")
public class AdminProxy extends Proxy {
	@Autowired AdminMapper adminMapper;
	@Autowired CrawlingProxy crawl;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
	private String makeAdminid() {
		StringBuffer buffer = new StringBuffer();
		Random ran = new Random();

		String name[] = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");

		for (int i = 0; i < 7; i++) {
			buffer.append(name[ran.nextInt(name.length)]);
		}
		return buffer.toString();
	}
	private String makeAdminpw() {
		return null;
	}
	private String makeAdminname() {
		return null;
	}
	private String makeAdmintel() {
		return null;
	}
	private String makeAdminemail() {
		return null;
	}
	private String makeRegister() {
		return null;
	}
	private String makeRegisternum() {
		return null;
	}
	private String makeStadiumid() {
		return null;
	}
	private String makeStadiumnum() {
		return null;
	}
	
	@Transactional 
	public void insertAdmins() {
		for(int i =0; i<200; i++) {
			adminMapper.insertAdmins(new Admin(makeAdminid(),
					makeAdminpw(),makeAdminname(),makeAdmintel(),
					makeAdminemail(),makeRegister(),makeRegisternum(),
					makeStadiumid(),makeStadiumnum()));
		}
	}
}
