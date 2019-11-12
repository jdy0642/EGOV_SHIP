package com.ship.web.aop;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.pxy.Trunk;
import com.ship.web.pxy.UserProxy;
import com.ship.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	//@Autowired HashMap<String, String> map;
	@Autowired Printer p;
	@Autowired TxService txService; 
	@Autowired Trunk<Object> trunk;
	@Autowired UserProxy manager;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site, @PathVariable String srch){
		p.accept(site+", srch: "+srch);
		HashMap<String, String> map = new HashMap<>();
		map.clear();
		map.put("site", site);
		map.put("srch", srch);
		txService.crawling(map);
	}
	@GetMapping("/register/users")
	public Map<?,?> registerUsers(){
		manager.insertUsers();
		return trunk.get();
	}
}
