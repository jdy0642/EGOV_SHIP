package com.ship.web.futsal;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @ Component
@AllArgsConstructor
@NoArgsConstructor
@Lazy
public class Post {
	private String POST_NUM, POST_TITLE, POST_TEXT, IMG
				, INTERLOCK, CATEGORY, USER_ID, NICKNAME;
}
