package com.ship.web.futsal;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public interface FutMapper {

	public void createFutTab(Map<?, ?> x);

	public void createPostTab(Map<?, ?> x);
	
	@Insert("insert into futsal(NICKNAME, SCORE, WIN,HITMAP, KM,  HEART, FUTBLACK,REPORTNUM, USERID)\n" + 
			"            VALUES(#{nickname},#{score},#{win},#{hitmap},#{km},#{heart},#{futblack},#{reportnum},#{userid})")
	public void createFutDummy(Fut x);
}
