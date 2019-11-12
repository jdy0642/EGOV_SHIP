package com.ship.web.res;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface ReserMapper {
	public void createRes(HashMap<String, String> parmaMap);
}
