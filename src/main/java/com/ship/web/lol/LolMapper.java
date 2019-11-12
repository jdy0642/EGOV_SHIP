package com.ship.web.lol;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface LolMapper {

	public void createLolTable(HashMap<String,String> paramMap);
}
