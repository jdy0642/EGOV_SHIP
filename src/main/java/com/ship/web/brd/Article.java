package com.ship.web.brd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data 
@Lazy
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Article {
	private String artseq, title, content, userid, comments, file; 
}
