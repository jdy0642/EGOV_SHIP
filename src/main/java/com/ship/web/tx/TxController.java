package com.ship.web.tx;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.pxy.Trunk;
import com.ship.web.pxy.UserProxy;
import com.ship.web.pxy.Box;
import com.ship.web.pxy.CrawlingProxy;
import com.ship.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	//@Autowired HashMap<String, String> map;
	@Autowired Printer p;
	@Autowired TxService txService; 
	@Autowired Trunk<String> trunk;
	@Autowired CrawlingProxy crawler;
	@Autowired Box<String> box;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site, @PathVariable String srch){
		p.accept("site: "+site);
		p.accept("srch: "+srch);
		trunk.put(Arrays.asList("site","srch"), Arrays.asList(site, srch));
		box = txService.crawling(trunk.get());
	}
	@GetMapping("/register/users")
	public Map<?,?> registerUsers(){
		int userCount =  txService.registerUsers();
		p.accept("서비스 카운팅: "+userCount);
		trunk.put(Arrays.asList("userCount"), Arrays.asList(crawler.string(userCount)));
		return trunk.get();
	}
	@GetMapping("/register/articles")
	public Map<?,?> registerArticles(){
		int articleCount =  txService.registerArticles();
		p.accept("아티클 카운팅: "+articleCount);
		trunk.put(Arrays.asList("articleCount"), Arrays.asList(crawler.string(articleCount)));
		return trunk.get();
	}
	@GetMapping("/register/lols")
	public Map<?,?> registerLol(){
		int lolCount =  txService.registerLol();
		p.accept("롤 카운팅: "+lolCount);
		trunk.put(Arrays.asList("lolCount"), Arrays.asList(crawler.string(lolCount)));
		return trunk.get();
	}
	
}
