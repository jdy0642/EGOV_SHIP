package com.ship.web.futsal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ship.web.enums.SQL;
import com.ship.web.pxy.Box;
import com.ship.web.pxy.FutProxy;
import com.ship.web.pxy.Trunk;

@RestController
@RequestMapping("/fut")
public class FutCtrl {
	@Autowired Trunk<Object> trunk;
	@Autowired Box<Object> box;
	@Autowired FutMapper futMapper;
	@Autowired FutProxy futsal;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/create/Futtab")
	public Map<?,?> createFutTab(){
		HashMap<String, String> paramMap = new HashMap<>();
		trunk.put(Arrays.asList("CREATE_FUTTAB","msg")
				,Arrays.asList(SQL.CREATE_FUTTAB.toString(),"Sucess"));
		Consumer<Map<?, ?>> c = x-> futMapper.createFutTab(x);
		System.out.println(SQL.CREATE_FUTTAB.toString());
		c.accept(trunk.get());
		return trunk.get();
	}
	@GetMapping("/create/Posttab")
	public Map<?,?> createPostTab(){
		HashMap<String, String> paramMap = new HashMap<>();
		//logger.info("Create table {}",SQL.CREATE_FUTTAB.toString());
		paramMap.put("CREATE_POSTTAB", SQL.CREATE_POSTTAB.toString());
		Consumer<Map<?, ?>> c = x-> futMapper.createPostTab(x);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg","Sucess");
		return paramMap;
	}
	
	@GetMapping("/create/FutDummy")
	public Map<?,?> createFutDummy(){
		trunk.put(Arrays.asList("msg")
				,Arrays.asList("Sucess"));
		futsal.insertFutsal();
		return trunk.get();
	}
}
