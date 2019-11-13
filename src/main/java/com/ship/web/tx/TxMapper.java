package com.ship.web.tx;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ship.web.brd.Article;
import com.ship.web.usr.User;

import com.ship.web.usr.User;

import com.ship.web.usr.User;

import com.ship.web.usr.User;

@Repository
@Transactional
public interface TxMapper {
	@Insert("insert into USER(USERID, USERNAME, USERPW,"
			+ "USERLOC, USERTEL,  AGE, GENDER,EMAIL, USERPOINT, "
			+ "SCORE,MVP, WIN, HITMAP, KM, HEART,BOOKMARK, LOLBLACK)" +
            " VALUES (#{uid},#{uname},#{upw},#{loc},"
            + "#{tel},#{age},#{gender},#{email},#{upoint},#{score},#{mvp}, #{win}, "
            + "#{hitmap}, #{km}, #{heart}, #{author}, #{lolname})")
	public void insertUser(User u);
	
	@Insert("INSERT INTO ARTICLE (TITLE, CONTENT, USERID, COMMENTS, PAGENO, FILE) VALUES (\n" + 
			"              #{title}, #{content}, #{userid}, #{comments}, #{pageno}, #{file})")
	public void insertArticle(Article a);
		
}
