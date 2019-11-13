package com.ship.web.lol;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.enums.SQL;
import com.ship.web.pxy.Box;
import com.ship.web.pxy.Trunk;
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/lols")
public class LolCtrl {
	private static final Logger logger = LoggerFactory.getLogger(LolCtrl.class);
	@Autowired Lol lol;
	@Autowired Printer p;
	@Autowired Map<String,Object> map;
	@Autowired LolMapper lolMapper;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	
	
	@GetMapping("/create/lol")
	public Map<?,?> createLolTable(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_LOL", SQL.CREATE_LOL.toString());
		p.accept("LOL테이블생성쿼리:\n"+paramMap.get("CREATE_LOL"));
		Consumer<HashMap<String, String>> c = t -> lolMapper.createLolTable(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
		
	}
}
