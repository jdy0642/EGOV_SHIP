package com.ship.web.adm;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
	public Admin selectByAdminIdPw(Admin param);
	public void select(Admin param);
	public void update(Admin param);
	public void delete(Admin param);
	public void createGame(HashMap<String, String> param);
	public void createAdminTable(HashMap<String, String> map);
	public void createRevenueTable(HashMap<String, String> map);
}