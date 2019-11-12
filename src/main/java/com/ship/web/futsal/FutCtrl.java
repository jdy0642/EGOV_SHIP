package com.ship.web.futsal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> ljs
=======
import org.springframework.beans.factory.annotation.Qualifier;
>>>>>>> yyh
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ship.web.enums.SQL;
<<<<<<< HEAD
import com.ship.web.pxy.Box;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> sjw
=======
>>>>>>> ljs
=======
>>>>>>> hsc1
=======
>>>>>>> yyh
import com.ship.web.pxy.Trunk;

@RestController
@RequestMapping("/fut")
public class FutCtrl {
<<<<<<< HEAD
	@Autowired Trunk<Object> trunk;
<<<<<<< HEAD
=======
	@Autowired Box<Object> box;
	
>>>>>>> ljs
=======
	@Autowired Trunk<Object> map;
>>>>>>> hsc1
	@Autowired FutMapper futMapper;
	@Autowired Trunk<Object> trunk;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/create/Futtab")
	public Map<?,?> createFutTab(){
		HashMap<String, String> paramMap = new HashMap<>();
<<<<<<< HEAD
<<<<<<< HEAD
		trunk.put(Arrays.asList("CREATEFUTTAB","msg")
=======
		map.put(Arrays.asList("CREATEFUTTAB","msg")
>>>>>>> hsc1
=======
		trunk.put(Arrays.asList("CREATEFUTTAB","msg")
>>>>>>> yyh
				,Arrays.asList(SQL.CREATEFUTTAB.toString(),"Sucess"));
		Consumer<Map<?, ?>> c = x-> futMapper.createFuttab(x);
		c.accept(paramMap);
		return trunk.get();
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
