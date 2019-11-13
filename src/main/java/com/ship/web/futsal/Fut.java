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
public class Fut {
	private String nickname, userid, score, mvp, win, hitmap, km
					, heart, futblack, reportnum;
}
