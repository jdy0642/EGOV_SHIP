package com.ship.web.res;

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
import com.ship.web.utl.Printer;

@RestController
@RequestMapping("/reser")
public class ReserCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ReserCtrl.class);
	@Autowired Reser reser;
	@Autowired Printer printer;
	@Autowired ReserMapper reserMapper;
	
	@GetMapping("/create/res")
	public Map<?,?> createRes(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_RES", SQL.CREATE_RES.toString());
		printer.accept("테이블 생성 : \n"+paramMap.get("CREATE_RES"));
		Consumer<HashMap<String, String>> c = t -> reserMapper.createRes(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}
}
