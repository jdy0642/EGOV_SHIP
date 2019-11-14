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
import com.ship.web.pxy.Trunk;

@RestController
@RequestMapping("/fut")
public class FutCtrl {
	@Autowired Trunk<Object> trunk;
	@Autowired Box<Object> box;
	@Autowired FutMapper futMapper;
	
	@GetMapping("/create/Futtab")
	public Map<?,?> createFutTab(){
		trunk.put(Arrays.asList("CREATEFUTTAB","msg")
				,Arrays.asList(SQL.CREATEFUTTAB.toString(),"SUCCESS"));
		Consumer<Map<?, ?>> c = x-> futMapper.createFuttab(x);
		return trunk.get();
	}
	@GetMapping("/create/Posttab")
	public Map<?,?> createPostTab(){
		trunk.put(Arrays.asList("CREATEFUTTAB","msg")
				,Arrays.asList(SQL.CREATEPOSTTAB.toString(),"SUCCESS"));
		Consumer<Map<?, ?>> c = x-> futMapper.createPosttab(x);
		return trunk.get();
	}
}
