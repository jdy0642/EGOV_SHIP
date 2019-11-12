package com.ship.web.adm;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.cmm.IConsumer;
import com.ship.web.cmm.IFunction;
import com.ship.web.enums.SQL;
import com.ship.web.utl.Printer;
import com.sun.org.apache.regexp.internal.recompile;

@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	private static final Logger logger = LoggerFactory.getLogger(AdminCtrl.class);
	@Autowired Admin admin;
	@Autowired Printer printer;
	//@Autowired Map <String, Object> map;
	@Autowired AdminMapper adminMapper;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/{aid}")
	public Map<?,?> access(@PathVariable String aid, @RequestBody Admin param){
		logger.info("어드민");
		Map map = new HashMap<>();
		IFunction<Admin, Admin> f = t -> adminMapper.selectByAdminIdPw(param);
		map.clear();
		map.put("msg", (f.apply(param))!=null ? "SUCCESS" : "FAIL");
		logger.info("어드민2"+param);
		return map;
	}
	@GetMapping("/create/game")
	public Map<?,?> createGame(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_GAME", SQL.CREATE_GAME.toString());
		printer.accept("테이블생성: \n"+paramMap.get("CREATE_GAME"));
		Consumer<HashMap<String, String>> c = t -> adminMapper.createGame(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
	@GetMapping("/create/table")
	public Map<?,?> createUser(){
		HashMap<String, String> map = new HashMap<>();
		map.clear();
		map.put("CREATE_ADMIN",SQL.CREATE_ADMIN.toString());
		printer.accept("테이블 생성 쿼리: \n"+map.get("CREATE_ADMIN"));
		IConsumer<HashMap<String, String>> c = t -> adminMapper.createAdminTable(map);
		c.accept(map);
		map.clear();
		map.put("msg","SUCCESS");
		return map;
	}
	@GetMapping("/create/revenue")
	public Map<?,?> createRevenue(){
		HashMap<String, String> map = new HashMap<>();
		map.clear();
		map.put("CREATE_REVENUE",SQL.CREATE_REVENUE.toString());
		printer.accept("테이블 생성 쿼리: \n"+map.get("CREATE_REVENUE"));
		IConsumer<HashMap<String, String>> c = t -> adminMapper.createRevenueTable(map);
		c.accept(map);
		map.clear();
		map.put("msg","SUCCESS");
		return map;
	}
}