package com.ship.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.usr.User;

import com.ship.web.usr.User;

import com.ship.web.usr.User;

import com.ship.web.usr.User;

@Repository
@Transactional
public interface TxMapper {
	@Insert("insert into USER(USER_ID, USER_NAME, USER_PW,"
			+ "USER_LOC, USER_TEL,  AGE, GENDER,EMAIL, USER_POINT, "
			+ "SCORE,MVP, WIN, HITMAP, KM, HEART,BOOKMARK, LOL_BLACK)" +
            " VALUES (#{uid},#{uname},#{upw},#{loc},"
            + "#{tel},#{age},#{gender},#{email},#{upoint},#{score},#{mvp}, #{win}, "
            + "#{hitmap}, #{km}, #{heart}, #{author}, #{lolname})")
	public void insertUser(User u);
		
}
