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
	private String NICKNAME, USER_ID, SCORE, MVP, WIN, HITMAP, KM
					, HEART, FUT_BLACK, REPORT_NUM;
}
