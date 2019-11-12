package com.ship.web.futsal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.enums.SQL;
import com.ship.web.pxy.ProxyMap;

@RestController
@RequestMapping("/fut")
public class FutCtrl {
	@Autowired ProxyMap map;
	@Autowired FutMapper futMapper;
	
	@GetMapping("/create/Futtab")
	public Map<?,?> createFutTab(){
		HashMap<String, String> paramMap = new HashMap<>();
		map.accept(Arrays.asList("CREATEFUTTAB","msg")
				,Arrays.asList(SQL.CREATEFUTTAB.toString(),"Sucess"));
		Consumer<Map<?, ?>> c = x-> futMapper.createFuttab(x);
		c.accept(paramMap);
		return map.get();
	}
	@GetMapping("/create/Posttab")
	public Map<?,?> createPostTab(){
		HashMap<String, String> paramMap = new HashMap<>();
		//logger.info("Create table {}",SQL.CREATEFUTTAB.toString());
		paramMap.put("CREATEPOSTTAB", SQL.CREATEPOSTTAB.toString());
		Consumer<Map<?, ?>> c = x-> futMapper.createPosttab(x);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","Sucess");
		return paramMap;
	}
}
